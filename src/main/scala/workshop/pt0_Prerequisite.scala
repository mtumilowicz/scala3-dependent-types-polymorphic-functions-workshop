package workshop

object pt0_Prerequisite extends App {

  val i: Int = 5
  val y = i
  val i5: 5 = 5
  val iType: i.type = i
//  val iType2: i.type = 5
  var yType: y.type = y
//  yType = iType
//  yType = y.type

  implicitly[i.type <:< Singleton]
  implicitly[42 <:< Singleton]
//  implicitly[Int <:< Singleton]

  // Singleton types, types which have a unique inhabitant
  // Singleton is used by the compiler as a supertype for singleton types
  // This includes literal types, as they are also singleton types.
    // Literal types let you indicate that an expression is equal to some specific primitive value.
  // by pairing a type with its unique inhabitant, singleton types bridge the gap between types and values

  // Normally, type inference in Scala widens singleton types to the underlying non-singleton type.
  // When a type parameter has an explicit upper bound of Singleton, the compiler infers a singleton type.

  def singleCheck42[T <: Singleton](x: T)(using ev: T =:= 5): T = x
  val x2 = singleCheck42(5)
  println(x2)

  def check42[T](x: T)(using ev: T =:= 5): T = x
//  val x1 = check42(5)

}
