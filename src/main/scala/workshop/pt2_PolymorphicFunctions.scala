package workshop

import scala.compiletime.ops.int.+

object pt2_PolymorphicFunctions {
  enum SList[N <: Int] {
    self =>
    case SNil extends SList[0]
    case SCons[M <: Int](head: Int, tail: SList[M]) extends SList[M + 1]

    def foldRight[B[_ <: Int]](z: B[0])(op: [M <: Int] => (Int, B[M]) => B[M + 1]): B[N] =
      this match {
        case SNil => z
        case SCons(head, tail) => op(head, tail.foldRight(z)(op))
      }

    def ::(elem: Int): SList[N + 1] =
      val newTail: SList[1] = SCons(elem, SNil)
      foldRight[[X <: Int] =>> SList[X + 1]](newTail)([M <: Int] => SCons(_, _))

    def reverse: SList[N] =
      foldRight[[X <: Int] =>> SList[X]](SNil)([M <: Int] => (elem, acc) => acc.::(elem))
  }

}
