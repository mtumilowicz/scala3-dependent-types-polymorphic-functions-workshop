package workshop

import workshop.compliance.*
import workshop.pt4_PathDependent.{ApprovalRecommendationEngine, TransactionPlan}

object compliance {
  trait CompliancePolicy {
    type B <: Blueprint

    def apply(blueprint: B): ComplianceCheckResult
  }

  object CompliancePolicy {
    type Aux[B0] = CompliancePolicy {type B = B0}
  }

  enum ComplianceCheckResult {
    case Violations(data: List[String])

    case NoViolationFound
  }

  trait ComplianceHeuristicEngine {
    type B <: Blueprint

    def apply(blueprint: B): ComplianceCheckResult
  }

  object ComplianceHeuristicEngine {
    type Aux[B0] = ComplianceHeuristicEngine {type B = B0}
  }

}

trait Specification {
  type Target <: Blueprint

  def prepare(): Target
}

trait Blueprint

object pt4_PathDependent {

  case class TransactionPlan(amount: Double, merchant: String) extends Blueprint

  enum ApprovalRecommendation {
    case Approve, Reject, ManualCheck
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
            case ComplianceCheckResult.Violations(data) => ApprovalRecommendation.ManualCheck
            case ComplianceCheckResult.NoViolationFound => ApprovalRecommendation.Approve
    }

  }

}