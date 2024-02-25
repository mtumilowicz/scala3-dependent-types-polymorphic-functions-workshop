import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalatest.Assertions.{assertCompiles, assertDoesNotCompile}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import workshop.TypeSafePrintf._


object TypeSafePrintfPropertiesSpec extends Properties("TypeSafePrintf")  {

  property("supports %s %d format") = forAll { (s: String, i: Int) =>
    printf("%s is %d")(s, i)
    true
  }

  property("support %d %s format") = forAll { (s: String, i: Int) =>
    printf("%d is %s")(i, s)
    true
  }
}

class TypeSafePrintfSpec extends AnyFlatSpec with Matchers {

  it should "should not compile %s due to EmptyTuple tail" in {
    assertDoesNotCompile("summon[ArgTypes[\"%s\"] =:= (String)]")
  }

  it should "represent %s as (String, EmptyTuple)" in {
    assertCompiles("summon[ArgTypes[\"%s\"] =:= String *: EmptyTuple]")
  }

  it should "represent %s %s as (String, String)" in {
    assertCompiles("summon[ArgTypes[\"%s %s\"] =:= (String, String)]")
  }

  it should "represent %s %s %s as (String, String, String)" in {
    assertCompiles("summon[ArgTypes[\"%s %s %s\"] =:= (String, String, String)]")
  }

  it should "represent %s %d as (String, Int)" in {
    assertCompiles("summon[ArgTypes[\"%s is %d\"] =:= (String, Int)]")
  }

  it should "represent %d %s as (Int, String)" in {
    assertCompiles("summon[ArgTypes[\"%d is %s\"] =:= (Int, String)]")
  }

  it should "compile %s %d format with correctly ordered params" in {
    assertCompiles("printf(\"%d is %s\")(5, \"a\")")
  }

  it should "not compile %s %d format with wrong ordered params" in {
    assertDoesNotCompile("printf(\"%s %d\")(5, \"a\")")
  }

  it should "not compile %d %s format with wrong ordered params" in {
    assertDoesNotCompile("printf(\"%d %s\")(\"a\", 5)")
  }

  it should "not compile %d %s format with too many params" in {
    assertDoesNotCompile("printf(\"%s %d\")(\"a\", 5, 6)")
  }

  it should "not compile %d %s format with too few params" in {
    assertDoesNotCompile("printf(\"%s %d\")(\"a\")")
  }
}