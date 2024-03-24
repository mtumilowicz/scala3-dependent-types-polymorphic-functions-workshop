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

  // (all S are M) and (all M are P) => (all S are P)
  object Theorem1 {
    type All_M_are_P = (x: Entity) => x.M => x.P

    type All_S_are_M = (x: Entity) => x.S => x.M

    type All_S_are_P = (x: Entity) => x.S => x.P

    def proof(assumption: And[All_M_are_P, All_S_are_M]): All_S_are_P =
      x => assumption._1(x) compose assumption._2(x)
  }

  // (some M are not P) and (all M are S) => some S are not P
  object Theorem2 {
    trait Some_M_are_not_P:
      val x: Entity
      val value: (x.M, Not[x.P])

    type All_M_are_S = (x: Entity) => x.M => x.S

    trait Some_S_are_not_P:
      val x: Entity
      val value: (x.S, Not[x.P])

    def proof(assumption: And[All_M_are_S, Some_M_are_not_P]): Some_S_are_not_P = new Some_S_are_not_P:
      val some_M_are_not_P = assumption._2
      val m = some_M_are_not_P.value._1
      val not_P = some_M_are_not_P.value._2
      val all_M_are_S = assumption._1
      
      val x: some_M_are_not_P.x.type = some_M_are_not_P.x
      val s: x.S = all_M_are_S(x)(m)
      val value: (x.S, Not[x.P]) = (s, not_P)
  }

}
