package workshop

import workshop.pt4_pathDependent.ComplianceCheckResult.NoViolationFound

// ZIO ZIP

// example with CountDownLatch {type S; protected def updateState S => S; def countdown: UIO[Unit]; def onDone: UIO[Unit]}
// ZIO Schedule[-Env, -In, +Out] // putting state will make it complex, as State can be really long WindowRecurEvery5SecondsEtc
  // we don't need to know what it is to work with schedule
  // why not trait? because u want to keep in the same
// generally improves type inference (invariance)
// exposing implementation detail
  // Box {type A; def value A} box(1).value + box(2).value
  // Aux pattern, enables adding - explicit when I need that type and when I don't
    // u can always forget about it val a: Wrapper = previouslyCreatedWithAux
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
