package workshop

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import workshop.compliance.{ComplianceCheckResult, ComplianceHeuristicEngine, CompliancePolicy}
import workshop.pt4_PathDependent.{ApprovalRecommendation, ApprovalRecommendationEngine, TransactionPlan}

class pt4_PathDependentSpec extends AnyFlatSpec with Matchers {

  it should "compliance engine: should correctly recommend transaction plan to be rejected" in {
    // given
    val approvalRecommendationEngine = new ApprovalRecommendationEngine

    val transactionLimitPolicy = new CompliancePolicy {
      override type B = TransactionPlan

      def isSuspicious(transaction: TransactionPlan): Boolean = transaction.amount > 1000.0

      override def apply(blueprint: B): ComplianceCheckResult = {
        if (isSuspicious(blueprint)) {
          ComplianceCheckResult.Violations(List("Fraud detected"))
        } else {
          ComplianceCheckResult.NoViolationFound
        }
      }
    }

    val transactionSpecification = new Specification {
      override type Target = TransactionPlan

      override def prepare(): Target = TransactionPlan(amount = 999.0, merchant = "")
    }

    val transactionHeuristicsPolicy = new ComplianceHeuristicEngine {
      override type B = TransactionPlan

      override def apply(blueprint: B): ComplianceCheckResult = ComplianceCheckResult.NoViolationFound
    }

    // when
    val result = approvalRecommendationEngine.check(transactionSpecification, transactionLimitPolicy, transactionHeuristicsPolicy)

    // then
    result shouldBe ApprovalRecommendation.Approve
  }

  it should "compliance engine: should correctly recommend transaction plan to be accepted" in {
    // given
    val approvalRecommendationEngine = new ApprovalRecommendationEngine

    val transactionLimitPolicy = new CompliancePolicy {
      override type B = TransactionPlan

      def isSuspicious(transaction: TransactionPlan): Boolean = transaction.amount > 1000.0

      override def apply(blueprint: B): ComplianceCheckResult = {
        if (isSuspicious(blueprint)) {
          ComplianceCheckResult.Violations(List("Fraud detected"))
        } else {
          ComplianceCheckResult.NoViolationFound
        }
      }
    }

    val transactionSpecification = new Specification {
      override type Target = TransactionPlan

      override def prepare(): Target = TransactionPlan(amount = 1001.0, merchant = "")
    }

    val transactionHeuristicsPolicy = new ComplianceHeuristicEngine {
      override type B = TransactionPlan

      override def apply(blueprint: B): ComplianceCheckResult = ComplianceCheckResult.NoViolationFound
    }

    // when
    val result = approvalRecommendationEngine.check(transactionSpecification, transactionLimitPolicy, transactionHeuristicsPolicy)

    // then
    result shouldBe ApprovalRecommendation.Reject
  }

  it should "compliance engine: should correctly recommend transaction plan to be checked manually" in {
    // given
    val approvalRecommendationEngine = new ApprovalRecommendationEngine

    val transactionLimitPolicy = new CompliancePolicy {
      override type B = TransactionPlan

      def isSuspicious(transaction: TransactionPlan): Boolean = transaction.amount > 1000.0

      override def apply(blueprint: B): ComplianceCheckResult = {
        if (isSuspicious(blueprint)) {
          ComplianceCheckResult.Violations(List("Fraud detected"))
        } else {
          ComplianceCheckResult.NoViolationFound
        }
      }
    }

    val transactionSpecification = new Specification {
      override type Target = TransactionPlan

      override def prepare(): Target = TransactionPlan(amount = 999.0, merchant = "")
    }

    val transactionHeuristicsPolicy = new ComplianceHeuristicEngine {
      override type B = TransactionPlan

      override def apply(blueprint: B): ComplianceCheckResult = ComplianceCheckResult.Violations(List("fraud merchant"))
    }

    // when
    val result = approvalRecommendationEngine.check(transactionSpecification, transactionLimitPolicy, transactionHeuristicsPolicy)

    // then
    result shouldBe ApprovalRecommendation.ManualCheck
  }

}
