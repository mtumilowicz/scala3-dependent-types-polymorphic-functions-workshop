package workshop

import org.scalatest.Assertions.{assertCompiles, assertDoesNotCompile}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import workshop.pt1_SizedList.*

class pt1_SizedListSpec extends AnyFlatSpec with Matchers {

  it should "not compile if size is wrong" in {
    assertDoesNotCompile("val l1: SizedList[0, Int] = 1 :: 2 :: 3 :: SizedList.empty")
    assertDoesNotCompile("val l1: SizedList[1, Int] = 1 :: 2 :: 3 :: SizedList.empty")
    assertDoesNotCompile("val l1: SizedList[2, Int] = 1 :: 2 :: 3 :: SizedList.empty")
    assertDoesNotCompile("val l1: SizedList[4, Int] = 1 :: 2 :: 3 :: SizedList.empty")
    assertDoesNotCompile("val l1: SizedList[5, Int] = 1 :: 2 :: 3 :: SizedList.empty")
  }

  it should "compile if size is correct" in {
    assertCompiles("val l1: SizedList[0, Int] = SizedList.empty[Int]")
    assertCompiles("val l1: SizedList[1, Int] = 1 :: SizedList.empty")
    assertCompiles("val l1: SizedList[2, Int] = 1 :: 2 :: SizedList.empty")
    assertCompiles("val l1: SizedList[3, Int] = 1 :: 2 :: 3 :: SizedList.empty")
    assertCompiles("val l1: SizedList[4, Int] = 1 :: 2 :: 3 :: 4 :: SizedList.empty")
  }

  it should "not compile if calling head on empty" in {
    assertDoesNotCompile("val l1 = SizedList.empty; l1.head")
  }

  it should "compile if calling head on non empty" in {
    assertCompiles("val l1 = 1 :: SizedList.empty; l1.head")
  }

  it should "not compile if calling head on empty after operations" in {
    assertDoesNotCompile("val l1 = 1 :: 2 :: SizedList.empty; l1.tail.tail.head")
  }

  it should "not compile if calling tail on empty after operations" in {
    assertDoesNotCompile("val l1 = 1 :: 2 :: SizedList.empty; l1.tail.tail.tail")
  }

  it should "return correct head if calling on non empty" in {
    val l1 = 1 :: 2 :: 3 :: 4 :: SizedList.empty
    assert(l1.head == 1)
  }

  it should "return correct tail if calling on non empty" in {
    val l1 = 1 :: 2 :: 3 :: 4 :: SizedList.empty
    val expectedTail = 2 :: 3 :: 4 :: SizedList.empty
    assert(l1.tail.toList == expectedTail.toList)
  }

  it should "return empty if called head sufficient number of times" in {
    val l1 = 1 :: 2 :: 3 :: 4 :: SizedList.empty
    val result: SizedList[0, Int] = l1.tail.tail.tail.tail
    assert(result.toList == SizedList.empty.toList)
  }

}