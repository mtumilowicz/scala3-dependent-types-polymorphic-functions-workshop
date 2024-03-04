package workshop

import scala.language.postfixOps

object pt6_LogicProofs extends App {

  type Not[P] = P => Nothing
  type Or[P, Q] = Either[P, Q]
  type And[P, Q] = (P, Q)
  type Implies[P, Q] = P => Q


  trait Entity:
    type P
    type M
    type S

  object first {
    // Some M are not P
    trait Major:
      val x: Entity;
      val value: (x.M, Not[x.P])

    // All M are S
    type Minor = (x: Entity) => x.M => x.S

    // Some S are not P
    trait Thesis:
      val x: Entity;
      val value: (x.S, Not[x.P])

    def proof(assumption: And[Minor, Major]): Thesis = new Thesis:
      val major = assumption._2
      val minor = assumption._1
      val x: major.x.type = major.x
      val value = (minor(x) apply major.value._1, major.value._2)
  }

  object second {
    //All M are P
    type Major = (x: Entity) => x.M => x.P

    //All S are M
    type Minor = (x: Entity) => x.S => x.M

    //All S are P
    type Conclusion = (x: Entity) => x.S => x.P

    def proof(major: Major, minor: Minor): Conclusion =
      x => major(x) compose minor(x)
  }

}
