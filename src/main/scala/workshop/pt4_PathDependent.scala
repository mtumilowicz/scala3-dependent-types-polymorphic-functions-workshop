package workshop

import workshop.pt4_PathDependent.ComplianceCheckResult.NoViolationFound

object pt4_PathDependent extends App {

  trait Blueprint

  enum ComplianceCheckResult {
    case Violations(data: List[String])

    case NoViolationFound
  }

  trait CompliancePolicy {
    type B <: Blueprint

    def apply(blueprint: B): ComplianceCheckResult
  }

  object CompliancePolicy {
    type Aux[B0] = CompliancePolicy { type B = B0 }
  }

  trait Specification {
    type Target <: Blueprint

    def prepare(): Target
  }

  case class Transaction(amount: Double, merchant: String) extends Blueprint

  enum ApprovalRecommendation {
    case Approve, Reject, ManualCheck
  }

  trait ComplianceHeuristicEngine {
    type B <: Blueprint

    def apply(blueprint: B): ComplianceCheckResult
  }

  object ComplianceHeuristicEngine {
    type Aux[B0] = ComplianceHeuristicEngine {type B = B0}
  }

  class ApprovalRecommendationEngine {

    def check(spec: Specification,
              compliancePolicy: CompliancePolicy.Aux[spec.Target],
              heuristicEngine: ComplianceHeuristicEngine.Aux[spec.Target]
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

  val transactionLimitPolicy = new CompliancePolicy {
    override type B = Transaction

    def isSuspicious(transaction: B): Boolean = transaction.amount > 1000.0

    override def apply(blueprint: Transaction): ComplianceCheckResult = {
      if (isSuspicious(blueprint)) {
        ComplianceCheckResult.Violations(List("Fraud detected"))
      } else {
        ComplianceCheckResult.NoViolationFound
      }
    }
  }
  val transactionSpecification = new Specification {
    type Target = Transaction

    def prepare(): Target = Transaction(amount = 1001.0, merchant = "")
  }
  val transactionHeuristicsPolicy = new ComplianceHeuristicEngine {
    override type B = Transaction

    override def apply(blueprint: B): ComplianceCheckResult = NoViolationFound
  }

  val result = approvalRecommendationEngine.check(transactionSpecification, transactionLimitPolicy, transactionHeuristicsPolicy)

  println(result) // Output: NoViolationFound

}
