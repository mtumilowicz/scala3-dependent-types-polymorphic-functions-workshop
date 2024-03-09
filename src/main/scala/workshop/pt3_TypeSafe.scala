package workshop

import scala.compiletime.ops.int.*
import scala.compiletime.ops.string.*

object pt3_TypeSafe extends App {

  type Proof[A <: Boolean] = A =:= true

  def tsCharAt(s: String, i: Int)(using Proof[i.type > -1],
                                Proof[i.type < Length[s.type]],
  ): Char = s.charAt(i)
  
  type ArgTypes[S <: String] <: Tuple = S match
    case "" => EmptyTuple
    case _ =>
      CharAt[S, 0] match
        case '%' =>
          CharAt[S, 1] match
            case 'd' => Int *: ArgTypes[Substring[S, 2, Length[S]]]
            case 's' => String *: ArgTypes[Substring[S, 2, Length[S]]]
        case _ => ArgTypes[Substring[S, 1, Length[S]]]

  def tsFormat(s: String)(t: ArgTypes[s.type]): String =
    s.format(t.productIterator.toList*)

}
