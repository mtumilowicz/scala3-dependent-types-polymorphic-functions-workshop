package workshop

import org.scalacheck.Prop.forAll
import org.scalacheck.Properties
import org.scalatest.Assertions.{assertCompiles, assertDoesNotCompile}
import workshop.pt3_TypeSafeMethod.*


object pt3_TypeSafeMethodPropertiesSpec extends Properties("TypeSafeMethod")  {

  property("supports %s %d format") = forAll { (s: String, i: Int) =>
    tsFormat("%s is %d")(s, i) == s"$s is $i"
  }

  property("support %d %s format") = forAll { (s: String, i: Int) =>
    tsFormat("%d is %s")(i, s) == s"$i is $s"
  }
}