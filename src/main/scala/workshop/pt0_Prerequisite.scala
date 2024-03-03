package workshop

import workshop.pt0_Prerequisite.Wrapper.Aux

object pt0_Prerequisite extends App {

  val i: Int = 5
  val y = i
  val i5: 5 = 5
  val iType: i.type = i
  //  val iType2: i.type = 5
  var yType: y.type = y
  //  yType = iType
  //  yType = y.type

  summon[i.type <:< Singleton]
  summon[42 <:< Singleton]
  summon[(42 & Singleton) <:< Int]
  //  implicitly[Int <:< Singleton]

  val x: String = scala.io.StdIn.readLine()
  val zzz: x.type = x
  println(zzz)

  def singleCheck42[T <: Singleton](x: T)(using ev: T =:= 5): T = x

  val x2 = singleCheck42(5)
  println(x2)

  def check42[T](x: T)(using ev: T =:= 5): T = x
//    val x1 = check42(5)

  // trait Schedule[-Env, -In, +Out] - state is hidden, WithState
  // trait Zippable[-A, -B] - out is hidden
  //  val a: ZIO[Any, Nothing, (Int, Int, Int)] = ZIO.succeed((1, 2)) <*> ZIO.succeed(3)
  //  val a: ZIO[Any, Nothing, (Int, Int, (Int, Int))] = ZIO.succeed((1, 2)) <*> ZIO.succeed((3, 4))

  trait Wrapper {
    type A

    def value: A
  }

  object Wrapper {

    type Aux[A0] = Wrapper { type A = A0 }
    def apply[A0](a: A0): Wrapper.Aux[A0] =
      new Wrapper {
        type A = A0
        def value: A0 = a
      }
  }

  val w: Wrapper = Wrapper(1)
//  val z = w.value + w.value

}
