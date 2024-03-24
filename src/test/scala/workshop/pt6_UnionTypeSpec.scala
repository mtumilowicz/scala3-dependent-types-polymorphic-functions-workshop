package workshop

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import workshop.pt6_UnionType.*

class pt6_UnionTypeSpec extends AnyFlatSpec with Matchers  {

  it should "types specified in union type are subtype of union type" in {
    assertCompiles("summon[Not[Not[Int]] <:< (Int v String)]")
    assertCompiles("summon[Not[Not[String]] <:< (Int v String)]")
  }

  it should "types not specified in union type are not part of union type" in {
    assertDoesNotCompile("summon[Not[Not[Float]] <:< (Double v Int)]")
    assertDoesNotCompile("summon[Not[Not[String]] <:< (Double v Int)]")
  }

  it should "verify union types using evidence at compile time" in {
    def size[T](t: T)(using Not[Not[T]] <:< (Int v String)) =
      t match {
        case i: Int => i
        case s: String => s.length
      }

    assertCompiles("size(1)")
    assertCompiles("size(\"11\")")
    assertDoesNotCompile("size(1.0)")
  }

  it should "verify union types using bounds at compile time" in {
    def size[T: (Int |∨| String)](t: T) =
      t match {
        case i: Int => i
        case s: String => s.length
      }

    assertCompiles("size(1)")
    assertCompiles("size(\"11\")")
    assertDoesNotCompile("size(1.0)")
  }

}
