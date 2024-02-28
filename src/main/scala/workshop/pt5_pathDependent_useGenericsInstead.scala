package workshop

import workshop.pt4_pathDependent.Blueprint

object pt5_pathDependent_useGenericsInstead extends App {

  trait Blueprint

  enum ComplianceCheckResult {
    case Violations(data: List[String])

    case NoViolationFound
  }

  trait CompliancePolicy[B <: Blueprint] {

    def apply(blueprint: B): ComplianceCheckResult
  }

  trait FraudCheckPolicy extends CompliancePolicy[Transaction] {

    def isSuspicious(transaction: Transaction): Boolean

    def apply(blueprint: Transaction): ComplianceCheckResult = {
      if (isSuspicious(blueprint)) {
        ComplianceCheckResult.Violations(List("Fraud detected"))
      } else {
        ComplianceCheckResult.NoViolationFound
      }
    }
  }

  trait Specification[Target <: Blueprint] {
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

  class ApprovalRecommendationEngine {

    def check[B <: Blueprint](compliancePolicy: CompliancePolicy[B],
              spec: Specification[B]
             ): ApprovalRecommendation = {
      val blueprint = spec.prepare()
      compliancePolicy(spec.prepare()) match
        case ComplianceCheckResult.Violations(data) => ApprovalRecommendation.Reject
        case ComplianceCheckResult.NoViolationFound => ApprovalRecommendation.Approve
    }

  }

  val approvalRecommendationEngine = new ApprovalRecommendationEngine
  val transactionLimitPolicy = new FraudCheckPolicy {
    def isSuspicious(transaction: Transaction): Boolean = transaction.amount > 1000.0
  }
  val transactionSpecification = new Specification[Transaction] {

    def prepare(): Transaction = Transaction(amount = 1001.0, merchant = "")
  }

  val result = approvalRecommendationEngine.check(transactionLimitPolicy, transactionSpecification)

  println(result) // Output: NoViolationFound

}
