package workshop

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import workshop.pt3_TypeSafeMethod.*

class pt3_TypeSafeMethodSpec extends AnyFlatSpec with Matchers {

  it should "tsFormat: should not compile %s due to EmptyTuple tail" in {
    assertDoesNotCompile("summon[ArgTypes[\"%s\"] =:= (String)]")
  }

  it should "tsFormat: represent %s as (String, EmptyTuple)" in {
    assertCompiles("summon[ArgTypes[\"%s\"] =:= String *: EmptyTuple]")
  }

  it should "tsFormat: represent %s %s as (String, String)" in {
    assertCompiles("summon[ArgTypes[\"%s %s\"] =:= (String, String)]")
  }

  it should "tsFormat: represent %s %s %s as (String, String, String)" in {
    assertCompiles("summon[ArgTypes[\"%s %s %s\"] =:= (String, String, String)]")
  }

  it should "tsFormat: represent %s %d as (String, Int)" in {
    assertCompiles("summon[ArgTypes[\"%s is %d\"] =:= (String, Int)]")
  }

  it should "tsFormat: represent %d %s as (Int, String)" in {
    assertCompiles("summon[ArgTypes[\"%d is %s\"] =:= (Int, String)]")
  }

  it should "tsFormat: compile %s %d format with correctly ordered params" in {
    assertCompiles("tsFormat(\"%d is %s\")(5, \"a\")")
  }

  it should "tsFormat: not compile %s %d format with wrong ordered params" in {
    assertDoesNotCompile("tsFormat(\"%s %d\")(5, \"a\")")
  }

  it should "tsFormat: not compile %d %s format with wrong ordered params" in {
    assertDoesNotCompile("tsFormat(\"%d %s\")(\"a\", 5)")
  }

  it should "tsFormat: not compile %d %s format with too many params" in {
    assertDoesNotCompile("tsFormat(\"%s %d\")(\"a\", 5, 6)")
  }

  it should "tsFormat: not compile %d %s format with too few params" in {
    assertDoesNotCompile("tsFormat(\"%s %d\")(\"a\")")
  }

  it should "tsFormat: correctly format text" in {
    val name = "Mika"
    val surname = "Tumi"
    val age = 20
    val expected = s"hello $name: your surname is $surname and your age is $age"
    tsFormat("hello %s: your surname is %s and your age is %d")(name, surname, age) shouldBe expected
  }

  it should "tsCharAt: not compile for idx < 0" in {
    assertDoesNotCompile("tsCharAt(\"bonjour\")(-1)")
    assertDoesNotCompile("tsCharAt(\"bonjour\")(-2)")
    assertDoesNotCompile("tsCharAt(\"bonjour\")(-3)")
    assertDoesNotCompile("tsCharAt(\"bonjour\")(-4)")
  }

  it should "tsCharAt: not compile tsCharAt for empty str" in {
    assertDoesNotCompile("tsCharAt(\"\")(0)")
    assertDoesNotCompile("tsCharAt(\"\")(1)")
    assertDoesNotCompile("tsCharAt(\"\")(2)")
    assertDoesNotCompile("tsCharAt(\"\")(3)")
  }

  it should "tsCharAt: not compile tsCharAt for idx >= str.length" in {
    assertDoesNotCompile("tsCharAt(\"bonjour\")(7)")
    assertDoesNotCompile("tsCharAt(\"bonjour\")(8)")
    assertDoesNotCompile("tsCharAt(\"bonjour\")(9)")
    assertDoesNotCompile("tsCharAt(\"bonjour\")(10)")
  }

  it should "tsCharAt: return correct tsCharAt for valid idx" in {
    tsCharAt("bonjour", 0) shouldBe 'b'
    tsCharAt("bonjour", 1) shouldBe 'o'
    tsCharAt("bonjour", 2) shouldBe 'n'
    tsCharAt("bonjour", 3) shouldBe 'j'
    tsCharAt("bonjour", 4) shouldBe 'o'
    tsCharAt("bonjour", 5) shouldBe 'u'
    tsCharAt("bonjour", 6) shouldBe 'r'
  }
}