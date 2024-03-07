package workshop

import workshop.pt2_SafeHead.Nat.{Succ, _0}
import workshop.pt2_SafeHead.SizedVector.{NonEmpty, VNil}

import scala.compiletime.ops.int.+

object pt2_SafeHead extends App {

  sealed trait Nat

  object Nat {
    class _0 extends Nat

    class Succ[Prev <: Nat] extends Nat
  }

  enum SizedVector[+A, N <: Nat] { xs =>
    case NonEmpty(head: A, tail: SizedVector[A, N]) extends SizedVector[A, Succ[N]]
    case VNil extends SizedVector[Nothing, _0]

    def ::[B >: A](x: B): NonEmpty[B, N] = NonEmpty(x, xs)
  }

  object SizedVector {

    given [A, N <: Nat]: Conversion[SizedVector[A, Succ[N]], NonEmpty[A, N]] = {
      case ne@NonEmpty(head, tail) => ne // input has: Succ[N] = N + 1 as size so it's not empty
    }

    extension [A, M <: Nat](xs: SizedVector[A, M]) {
      def ++[N <: Nat](ys: SizedVector[A, N])(using concat: VConcat[A, M, N]): concat.Out = concat(xs, ys)

    }

    extension [A, M <: Nat](xs: SizedVector[A, Succ[M]]) {
      def head2: A = xs.head

    }

  }

  trait VConcat[A, N <: Nat, M <: Nat] {
    type MN <: Nat
    type Out = SizedVector[A, MN]

    def apply(xs: SizedVector[A, N], ys: SizedVector[A, M]): Out
  }

  object VConcat {
    given vnilConcat[A, N <: Nat]: VConcat[A, _0, N] with {
      type MN = N

      def apply(xs: SizedVector[A, _0], ys: SizedVector[A, N]): Out = ys
    }

    given vconsConcat[A, M <: Nat, N <: Nat](using ctail: VConcat[A, M, N]): VConcat[A, Succ[M], N] with {
      type MN = Succ[ctail.MN]

      def apply(xs: SizedVector[A, Succ[M]], ys: SizedVector[A, N]): Out = xs.head :: (xs.tail ++ ys)
    }
  }

}
