package workshop

import org.scalatest.Assertions.{assertCompiles, assertDoesNotCompile}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import workshop.SafeHead.{Nat, SizedVector}
import workshop.SafeHead.SizedVector.VNil

class SafeHeadPropertiesSpec extends AnyFlatSpec with Matchers {

  it should "should not compile if size is wrong" in {
    assertDoesNotCompile("val l1: NonEmpty[Int, Succ[_0]] = 1 :: 2 :: 3 :: VNil")
  }

  it should "should compile if size is correct" in {
    assertDoesNotCompile("val l1: NonEmpty[Int, Succ[Succ[_0]]] = 1 :: 2 :: 3 :: VNil")
  }

  it should "should not compile if calling head on empty" in {
    assertDoesNotCompile("val l1 = VNil; l1.head")
  }

  it should "should compile if calling head on non empty" in {
    assertCompiles("val l1 = 1 :: VNil; l1.head")
  }

  it should "return correct head if calling on non empty" in {
    val l1 = 1 :: 2 :: 3 :: 4 :: VNil
    assert(l1.head == 1)
  }

  it should "return correct tail if calling on non empty" in {
    val l1 = 1 :: 2 :: 3 :: 4 :: VNil
    val expectedTail = 2 :: 3 :: 4 :: VNil
    assert(l1.tail == expectedTail)
  }

  it should "return empty if called tail sufficient number of times" in {
    val l1 = 1 :: 2 :: 3 :: 4 :: VNil
    val result: SizedVector[Int, Nat._0] = l1.tail.tail.tail.tail
    assert(result == VNil)
  }

  it should "should not compile if calling head on empty after operations" in {
    assertDoesNotCompile("val l1 = 1 :: 2 :: VNil; l1.tail.tail.head")
  }

  it should "should not compile if calling tail on empty after operations" in {
    assertDoesNotCompile("val l1 = 1 :: 2 :: VNil; l1.tail.tail.tail")
  }

}