package workshop

import org.scalatest.Assertions.{assertCompiles, assertDoesNotCompile}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import workshop.pt2_PolymorphicFunction.SList.*
import workshop.pt2_PolymorphicFunction.SList

class pt2_PolymorphicFunctionSpec extends AnyFlatSpec with Matchers {

  it should "not compile if size is wrong" in {
    assertDoesNotCompile("val l1: SList[0] = 1 :: 2 :: 3 :: SNil")
    assertDoesNotCompile("val l1: SList[1] = 1 :: 2 :: 3 :: SNil")
    assertDoesNotCompile("val l1: SList[2] = 1 :: 2 :: 3 :: SNil")
    assertDoesNotCompile("val l1: SList[4] = 1 :: 2 :: 3 :: SNil")
    assertDoesNotCompile("val l1: SList[5] = 1 :: 2 :: 3 :: SNil")
  }

  it should "compile if size is correct" in {
    assertCompiles("val l1: SList[0] = SList.SNil")
    assertCompiles("val l1: SList[1] = 1 :: SNil")
    assertCompiles("val l1: SList[2] = 1 :: 2 :: SNil")
    assertCompiles("val l1: SList[3] = 1 :: 2 :: 3 :: SNil")
    assertCompiles("val l1: SList[4] = 1 :: 2 :: 3 :: 4 :: SNil")
  }

  it should "correctly reverse" in {
    (1 :: 2 :: 3 :: 4 :: SNil).reverse shouldBe (4 :: 3 :: 2 :: 1 :: SNil)
    (1 :: 2 :: 3 :: SNil).reverse shouldBe (3 :: 2 :: 1 :: SNil)
    (1 :: 2 :: SNil).reverse shouldBe (2 :: 1 :: SNil)
    (1 :: SNil).reverse shouldBe (1 :: SNil)
    SNil.reverse shouldBe SNil
  }

}