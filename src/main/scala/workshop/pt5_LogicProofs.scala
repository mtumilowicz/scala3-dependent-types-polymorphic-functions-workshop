package workshop

import scala.language.postfixOps

object pt5_LogicProofs {

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
    trait Assumption1:
      val x: Entity;
      val value: (x.M, Not[x.P])

    // All M are S
    type Assumption2 = (x: Entity) => x.M => x.S

    // Some S are not P
    trait Thesis:
      val x: Entity;
      val value: (x.S, Not[x.P])

    def proof(assumption: And[Assumption2, Assumption1]): Thesis = new Thesis:
      val major = assumption._2
      val minor = assumption._1
      val x: major.x.type = major.x
      val value = (minor(x) apply major.value._1, major.value._2)
  }

  object second {
    //All M are P
    type Assumption1 = (x: Entity) => x.M => x.P

    //All S are M
    type Assumption2 = (x: Entity) => x.S => x.M

    //All S are P
    type Conclusion = (x: Entity) => x.S => x.P

    def proof(major: Assumption1, minor: Assumption2): Conclusion =
      x => major(x) compose minor(x)
  }

}
