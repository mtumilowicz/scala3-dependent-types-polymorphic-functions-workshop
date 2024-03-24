package workshop

object pt6_UnionType {

  type Not[P] = P => Nothing
  infix type v[T, U] = Not[Not[T] & Not[U]]
  infix type |∨|[T, U] = [X] =>> Not[Not[X]] <:< (T v U)

}
