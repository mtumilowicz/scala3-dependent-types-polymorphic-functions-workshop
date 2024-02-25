package workshop

import workshop.SafeHead.SizedVector.{NonEmpty, VNil}

object SafeHead extends App {

  sealed trait Nat

  class _0 extends Nat

  class Succ[Prev <: Nat] extends Nat

  sealed trait SizedVector[+A, N <: Nat] {
    xs =>
    def ::[B >: A](x: B): NonEmpty[B, N] = NonEmpty(x, xs)
  }

  object SizedVector {

    case class NonEmpty[+A, N <: Nat](head: A, tail: SizedVector[A, N]) extends SizedVector[A, Succ[N]]

    type VNil = SizedVector[Nothing, _0]

    case object VNil extends VNil

    given [A, N <: Nat]: Conversion[SizedVector[A, Succ[N]], NonEmpty[A, N]] =
      v => v.asInstanceOf[NonEmpty[A, N]]

    extension [A, M <: Nat](xs: SizedVector[A, M]) {
      def ++[N <: Nat](ys: SizedVector[A, N])(using concat: VConcat[A, SizedVector[A, M], SizedVector[A, N]]): concat.Out = concat(xs, ys)

    }

    extension [A, M <: Nat](xs: SizedVector[A, Succ[M]]) {
      def head2: A = xs.head

    }

  }

  trait VConcat[A, XS, YS] {
    type MN <: Nat
    type Out = SizedVector[A, MN]

    def apply(xs: XS, ys: YS): Out
  }

  object VConcat {
    given vnilConcat[A, N <: Nat]: VConcat[A, SizedVector[A, _0], SizedVector[A, N]] with {
      type MN = N

      def apply(xs: SizedVector[A, _0], ys: SizedVector[A, N]): Out = ys
    }

    given vconsConcat[A, M <: Nat, N <: Nat](using ctail: VConcat[A, SizedVector[A, M], SizedVector[A, N]]): VConcat[A, SizedVector[A, Succ[M]], SizedVector[A, N]] with {
      type MN = Succ[ctail.MN]

      def apply(xs: SizedVector[A, Succ[M]], ys: SizedVector[A, N]): Out = xs.head :: (xs.tail ++ ys)
    }
  }

  val l1 = 1 :: 2 :: 3 :: VNil

  val h: Int = l1.head
  val t = l1.tail

  println(l1.tail.tail)
//      println(l1.tail.tail.tail.head)

}
