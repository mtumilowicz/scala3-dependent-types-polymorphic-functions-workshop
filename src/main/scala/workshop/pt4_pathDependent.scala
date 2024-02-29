package workshop

import workshop.pt4_pathDependent.ComplianceCheckResult.NoViolationFound

object pt4_pathDependent extends App {

  trait Blueprint

  enum ComplianceCheckResult {
    case Violations(data: List[String])

    case NoViolationFound
  }

  trait CompliancePolicy {
    type B <: Blueprint

    def apply(blueprint: B): ComplianceCheckResult
  }

  trait FraudCheckPolicy extends CompliancePolicy {
    type B = Transaction

    def isSuspicious(transaction: Transaction): Boolean

    def apply(blueprint: Transaction): ComplianceCheckResult = {
      if (isSuspicious(blueprint)) {
        ComplianceCheckResult.Violations(List("Fraud detected"))
      } else {
        ComplianceCheckResult.NoViolationFound
      }
    }
  }

  trait Specification {
    type Target <: Blueprint

    def prepare(): Target
  }

  case class Transaction(amount: Double, merchant: String) extends Blueprint

  enum ApprovalRecommendation {
    case Approve, Reject, ManualCheck
  }

  trait ComplianceHeuristicEngine[-B <: Blueprint] {
    def apply(blueprint: B): ComplianceCheckResult
  }

  class ApprovalRecommendationEngine {

    def check(compliancePolicy: CompliancePolicy,
              spec: Specification {type Target <: compliancePolicy.B},
              heuristicEngine: ComplianceHeuristicEngine[compliancePolicy.B]
             ): ApprovalRecommendation = {
      val blueprint = spec.prepare()
      compliancePolicy(blueprint) match
        case ComplianceCheckResult.Violations(data) => ApprovalRecommendation.Reject
        case ComplianceCheckResult.NoViolationFound =>
          heuristicEngine(blueprint) match
            case ComplianceCheckResult.Violations(data) => ApprovalRecommendation.Reject
            case ComplianceCheckResult.NoViolationFound => ApprovalRecommendation.ManualCheck
    }

  }

  val approvalRecommendationEngine = new ApprovalRecommendationEngine
  val transactionLimitPolicy = new FraudCheckPolicy {
    def isSuspicious(transaction: Transaction): Boolean = transaction.amount > 1000.0
  }
  val transactionSpecification = new Specification {
    type Target = Transaction

    def prepare(): Target = Transaction(amount = 1001.0, merchant = "")
  }
  val transactionHeuristicsPolicy = new ComplianceHeuristicEngine[Transaction] {

    override def apply(blueprint: Transaction): ComplianceCheckResult = NoViolationFound
  }

  val result = approvalRecommendationEngine.check(transactionLimitPolicy, transactionSpecification, transactionHeuristicsPolicy)

  println(result) // Output: NoViolationFound

}
