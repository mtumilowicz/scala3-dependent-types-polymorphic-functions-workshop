package workshop

import scala.compiletime.ops.int.*

object pt1_SizedList {

  final class SizedList[N <: Int & Singleton, A] private(private val values: List[A]) {
    def ++[M <: Int  & Singleton](that: SizedList[M, A]): SizedList[(N + M) & Singleton, A] =
      new SizedList(values ++ that.values)
    def ::(x: A): SizedList[(N + 1) & Singleton, A] = new SizedList(x +: values)
    def head(using (N > 0) =:= true): A = values.head
    def tail(using (N > 0) =:= true): SizedList[(N - 1) & Singleton, A] = new SizedList(values.tail)
    def toList: List[A] = values
  }

  object SizedList {
    def empty[A]: SizedList[0, A] = new SizedList(List.empty[A])
    def apply[A](a1: A): SizedList[1, A] = new SizedList(List(a1))
    def apply[A](a1: A, a2: A): SizedList[2, A] = new SizedList(List(a1, a2))

  }

  val v0: SizedList[0, Int] = SizedList.empty
  val v1: SizedList[1, Int] = SizedList(1)
  val v2: SizedList[2, Int] = SizedList(2, 3)
  val v3: SizedList[3, Int] = v1 ++ v2
  val v4: SizedList[4, Int] = v1 ++ v3
  val v5: SizedList[5, Int] = 1 :: 2 :: 3 :: 4 :: 5 :: SizedList.empty
  val hV4 = v1.head

}
