package workshop

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import org.scalatest.Assertions.{assertCompiles, assertDoesNotCompile}
import workshop.TypeSafePrintf.*


object TypeSafePrintfPropertiesSpec extends Properties("TypeSafePrintf")  {

  property("supports %s %d format") = forAll { (s: String, i: Int) =>
    tsPrintf("%s is %d")(s, i)
    true
  }

  property("support %d %s format") = forAll { (s: String, i: Int) =>
    tsPrintf("%d is %s")(i, s)
    true
  }
}