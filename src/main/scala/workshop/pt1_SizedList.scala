package workshop

import scala.compiletime.ops.int.*
import scala.compiletime.ops.int.given

object pt1_SizedList {

  trait Proof[A]

  final class SizedList[N <: Int , A] private(private val values: List[A]) {
    def ++[M <: Int ](that: SizedList[M, A]): SizedList[(N + M) , A] =
      new SizedList(values ++ that.values)

    def head(using Proof[N > 0]): A = values.head
  }

  object SizedList {
    def empty[A]: SizedList[0, A] = new SizedList(List.empty[A])

    def apply[A](a1: A): SizedList[1, A] = new SizedList(List(a1))
    def apply[A](a1: A, a2: A): SizedList[2, A] = new SizedList(List(a1, a2))
  }

  given Proof[true] with {}

  val v0: SizedList[0, Int] = SizedList.empty
  val v1: SizedList[1, Int] = SizedList(1)
  val v2: SizedList[2, Int] = SizedList(2, 3)
  val v3: SizedList[3, Int] = v1 ++ v2
  val v4: SizedList[4, Int] = v1 ++ v3
  val hV4 = v4.head

}
