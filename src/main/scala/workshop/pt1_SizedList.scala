package workshop

import scala.compiletime.ops.int.+

object pt1_SizedList {

  // E.g. they would allow us to create matrices of a known size and check at compile time that they are multipliable.
  final class SizedList[N <: Int & Singleton, A] private(private val values: List[A]) {
    def ++[M <: Int & Singleton](that: SizedList[M, A]): SizedList[(N + M) & Singleton, A] =
      new SizedList(values ++ that.values)
  }

  object SizedList {
    def empty[A]: SizedList[0, A] = new SizedList(List.empty[A])

    def apply[A](a1: A): SizedList[1, A] = new SizedList(List(a1))
  }

  val v0: SizedList[0, Int] = SizedList.empty
  val v1: SizedList[1, Int] = SizedList(1)
  val v2: SizedList[1, Int] = SizedList(2)
  val v3: SizedList[2, Int] = v1 ++ v2
  val v4: SizedList[3, Int] = v1 ++ v3

}
