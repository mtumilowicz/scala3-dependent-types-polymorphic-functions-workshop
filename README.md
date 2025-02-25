# scala3-dependent-types-polymorphic-functions-phantom-types-workshop
[![Build Status](https://app.travis-ci.com/mtumilowicz/scala3-dependent-types-polymorphic-functions-workshop.svg?branch=main)](https://app.travis-ci.com/mtumilowicz/scala3-dependent-types-polymorphic-functions-workshop)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

* references
    * ["Scala vs Idris: Dependent types, now and in the future" by Miles Sabin and Edwin Brady (2013)](https://www.youtube.com/watch?v=fV2no1Rkzdw)
    * [Type level Programming in Scala - Matt Bovel](https://www.youtube.com/watch?v=B7uficxARKM)
    * [Why Netflix ❤'s Scala for Machine Learning - Jeremy Smith & Aish](https://www.youtube.com/watch?v=BfaBeT0pRe0)
    * [Zymposium — Path Dependent Types](https://www.youtube.com/watch?v=w2rcHCqdn-o)
    * [f(by) 2020: Dependent types, Vitaly Bragilevsky](https://www.youtube.com/watch?v=ohG-PRwOorA)
    * [Stephan Boyer - What are Dependent Types - λC 2017](https://www.youtube.com/watch?v=FquVty-Ghpg)
    * [Guillaume Martres - Polymorphic Function Types in Scala 3](https://www.youtube.com/watch?v=sauaDZ-1-zM)
    * [Type Members vs Type Parameters - NE Scala 2016](https://www.youtube.com/watch?v=R8GksuRw3VI)
    * https://github.com/milessabin/strangeloop-2013/tree/master
    * https://github.com/mbovel/scalacon-typelevel-operations
    * https://github.com/hablapps/syllogisms
    * https://docs.scala-lang.org/sips/42.type.html
    * https://mypy.readthedocs.io/en/stable/literal_types.html#
    * https://chat.openai.com
    * https://github.com/goldfirere/singletons
    * https://stackoverflow.com/questions/46748559/i-need-help-haskell-inhabitant-for-the-type
    * https://typesandkinds.wordpress.com/2013/12/17/singletons-v0-9-released/
    * https://www.poberezkin.com/posts/2020-05-17-using-dependent-types-haskell-singletons.html
    * https://dl.acm.org/doi/10.1145/2364506.2364522
    * https://stackoverflow.com/questions/12961651/why-not-be-dependently-typed
    * https://www.doubloin.com/learn/formal-verification-smart-contracts
    * https://ethereum.org/en/developers/docs/smart-contracts/formal-verification/
    * https://www.certik.com/resources/blog/3UDUMVAMia8ZibM7EmPf9f-what-is-formal-verification
    * https://lampwww.epfl.ch/~amin/dot/fpdt.pdf
    * https://stackoverflow.com/questions/24960722/what-is-the-difference-between-path-dependent-types-and-dependent-types
    * https://users.rust-lang.org/t/concatenating-arrays/89538/2
    * https://stackoverflow.com/questions/12935731/any-reason-why-scala-does-not-explicitly-support-dependent-types/12937819#12937819
    * https://www.degruyter.com/document/doi/10.1515/9783110657883-018/html?lang=de
    * https://kiranvodrahalli.github.io/notes/curry_howard_cos510notes.pdf
    * https://studenttheses.uu.nl/bitstream/handle/20.500.12932/36496/Thesis%20Jasmijn%20van%20Harskamp.pdf
    * http://www.ivanociardelli.altervista.org/wp-content/uploads/2017/01/Sorensen-excerpt.pdf
    * https://softwarefoundations.cis.upenn.edu/lf-current/ProofObjects.html
    * https://www.quora.com/What-is-an-intuitive-explanation-of-the-Curry-Howard-correspondence
    * https://cstheory.stackexchange.com/questions/50714/why-is-the-curry-howard-isomorphism
    * https://docs.scala-lang.org/scala3/reference/new-types/polymorphic-function-types.html
    * https://docs.scala-lang.org/scala3/reference/new-types/type-lambdas.html
    * https://www.baeldung.com/scala/type-lambdas-scala-3
    * https://github.com/typelevel/kind-projector
    * https://stackoverflow.com/questions/39905267/what-is-a-kind-projector
    * https://medium.com/scala-3/scala-3-type-lambdas-polymorphic-function-types-and-dependent-function-types-2a6eabef896d
    * https://blog.rockthejvm.com/scala-3-type-lambdas/
    * https://stackoverflow.com/questions/51131067/when-are-dependent-types-needed-in-shapeless
    * https://chat.openai.com/
    * https://gemini.google.com/
    * https://medium.com/@Webmarmun/dependent-types-in-haskell-f35b8880cc16
    * https://medium.com/background-thread/the-future-of-programming-is-dependent-types-programming-word-of-the-day-fcd5f2634878
    * https://ps.informatik.uni-tuebingen.de/teaching/ws15/pdt/
    * https://xebia.com/blog/dependent-and-refinement-types-why/
    * https://www.reddit.com/r/ProgrammingLanguages/comments/10f1fr0/basic_building_blocks_of_dependent_type_theory/
    * https://yarax.medium.com/from-logic-and-math-to-code-for-dummies-part-i-242183267efd
    * https://en.wikipedia.org/wiki/Liar_paradox
    * https://yarax.medium.com/from-logic-and-math-to-code-for-dummies-part-ii-higher-order-logic-5db1aa93eb35
    * https://www.stackbuilders.com/blog/reverse-reverse-theorem-proving-with-idris/
    * https://docs.scala-lang.org/scala3/reference/contextual/using-clauses.html
    * https://dotty.epfl.ch/api/scala/
    * [Scala Type-Level Operations – Matt Bovel](https://www.youtube.com/watch?v=6OaW-_aFStA)
    * [Rodolfo Hansen - Keep Your Types Small](https://www.youtube.com/watch?v=2Orv_l8_EVQ)
    * [Philip Wadler – Propositions as Types](https://www.youtube.com/watch?v=ru20eaMYbDo)
    * [Emily Pillmore: Type Arithmetic and the Yoneda Lemma](https://www.youtube.com/watch?v=aXS5HZ_1fNQ)
    * [Formal Logic Undressed — Paul Snively](https://www.youtube.com/watch?v=saMtzIaDCJM)
    * https://milessabin.com/blog/2011/06/09/scala-union-types-curry-howard/
    * https://medium.com/@maximilianofelice/builder-pattern-in-scala-with-phantom-types-3e29a167e863
    * https://infoscience.epfl.ch/record/273667?ln=en
    * https://xebia.com/blog/compile-safe-builder-pattern-using-phantom-types-in-scala/
    * https://www.codecentric.de/wissens-hub/blog/phantom-types-scala
    * https://www.scalamatters.io/post/phantom-types-without-phantom-pain
    * [A Crash Course in Category Theory - Bartosz Milewski](https://www.youtube.com/watch?v=JH_Ou17_zyU)
    * https://math.stackexchange.com/questions/2561353/set-of-functions-from-empty-set-to-0-1
    * [Idris for (im)practical Scala programmers - Marcin Rzeźnicki - Chamberconf 2018](https://www.youtube.com/watch?v=zCJWv9X8eKM)
    * https://leanpub.com/thinking-with-types/
    * https://chatgpt.com

## preface
* goals of this workshop
    * understanding dependent types
        * comprehension how to apply that in practice based on scala3
            * singleton types
            * `=:=`
            * type level programming
            * polymorphic functions
    * applying phantom types to provide compile-time proofs     
    * understanding path dependent types
        * applying knowledge in practice
    * noticing correspondence between logic and computations
        * formal proofs for basic tautologies
        * implemetation of union types using `with`
* workshop plan
    1. `pt1_SizedList`
        * context: rust
            * in rust arrays has compile-time size
                * reason: everything allocated on stack must have known size
                    * array is allocated on stack
                * example: https://play.rust-lang.org/
                    ```
                    fn main() {
                        let array1: [i32; 3] = [1, 2, 3];
                        let array2: [i32; 2] = [4, 5];
                    }
                    ```
            * what rust can't do (at least - for now) is concatenating of two arrays of different size
                * reason: no way to perform operations on types, for example: adding them
                * solution: `generic_const`
                    ```
                    #![allow(incomplete_features)]
                    #![feature(generic_const_exprs)]

                    fn concat_arrays<T, const A: usize, const B: usize>(
                        a: [T; A], b: [T; B]
                    ) -> [T; A+B]
                    where
                        T: Default,
                    {
                        let mut ary: [T; A+B] = std::array::from_fn(|_| Default::default());
                        for (idx, val) in a.into_iter().chain(b.into_iter()).enumerate() {
                            ary[idx] = val;
                        }
                        ary
                    }

                    fn main() {
                        let array1: [i32; 3] = [1, 2, 3];
                        let array2: [i32; 2] = [4, 5];

                        let result_array: [i32; 5] = concat_arrays(array1, array2);

                        println!("{:?}", result_array);
                    }
                    ```
        * task: implement collection that tracks its size at compile time
            * use case: allow us to create matrices of a known size and check at compile time that they are multipliable
            * implement safe version of `head` (fails compilation if invoked on empty list)
            * example
                * rust
                    * example
                        ```
                        fn main() {
                            let array1: [i32; 0] = [];

                            let head = array1[0]; // does not compile: index out of bounds: the length is 0 but the index is 0
                        }
                        ```
                * idris - https://tio.run/#idris
                    ```
                    data Vect : Nat -> Type -> Type where
                      Nil : Vect Z a
                      (::) : a -> Vect n a -> Vect (plus 1 n) a -- (plus 1 n) same as (S n)

                    concat : Vect n a -> Vect m a -> Vect (n + m) a
                    concat Nil ys = ys
                    concat (x :: xs) ys = x :: concat xs ys

                    head : Vect (plus 1 n) a -> a
                    head (x :: xs) = x

                    v0 : Vect 0 a
                    v0 = Nil
                    v3 : Vect 3 Integer
                    v3 = 10 :: 5 :: 1 :: Nil
                    v4 : Vect 4 Integer
                    v4 = 1 :: 2 :: 3 :: 4 :: Nil

                    v3v4 : Vect 7 Integer
                    v3v4 = concat v3 v4

                    v3Head : Integer
                    v3Head = head v3

                    -- v0Head: Integer
                    -- v0Head = head v0 -- not compiling, there is no function head for 0-sized vector

                    main : IO ()
                    main = putStrLn $ "head of v1: " ++ show v3Head
                    ```
    1. `pt2_SList`
        * implement methods: `append` and `reverse` using `foldRightF`
            * why normal `foldRight` is not enough?
                * notice that in classical `foldRight` type of accumulator (`B`) cannot change during processing
                    ```
                    trait SList[N <: Int]: // assume that SList has Strings
                        def foldRight[B](z: B)(op: (String, B) => B): B

                    // SList.foldRight(SNil) { case (elem, acc) => SCons(elem, acc) } // not compiles, SNil is SList[0] and SCons is SList[M]
                    ```
    1. `pt3_TypeSafeMethod`
        * implement type safe version of `format` that validates arguments based on specified types
            * should support
                * `%s` -> `String`
                * `%d` -> `Int`
                * any arbitrary combination of them with every cardinality > 1
            * example
                ```
                tsFormat("%s is %d")("s1", 1) // compiles
                tsFormat("%s %s %s is %d %s")("s1", "s2", "s3", 1, "s4") // compiles
                tsFormat("%s is %d")(i, s) // does not compile: Found: (i : Int) Required: String
                ```
        * explain why cardinality == 1 is complicating a bit implementation
    1. `pt4_pathDependent`
        * rewrite path dependent approach into generics
        * discuss variance
    1. `pt5_LogicalProofs`
        * proof theorems:
            1. (all S are M) and (all M are P) => all S are P
            1. (not all S are M) and (all M are P) => not all S are P
    1. `pt6_CurryHoward`
        * using De Morgan's law implement equivalent of sum type: `|`
        * use phantom types to apply that in method's as evidence

## prerequisite
* `summon[T]`
    * find a given instance of type `T` in the current scope
* `=:=`
    * instance of `A =:= B` witnesses that the types `A` and `B` are equal
    * example: proof of being the same type
        ```
        val i = 5 // val i: 5 = 5
        summon[i.type =:= 5]
        ```
* `<:<`
    * instance of `A <:< B` witnesses that `A` is a subtype of `B`

## phantom types
* called this way, because they never get instantiated
    * used to represent type relationships rather that working directly with their values
* commonly used to express constraints encoded in types
    * to prove static properties of the code using type evidences
* prevent some code from being compiled in certain situations
    * useful when representing models that have a particularily defined structural state with transitions
    * example: assume we need a function that turns a machine on (`turnOn`), only if it is turned off
        ```
        sealed trait MachineState
        object MachineState {
            sealed trait TurnedOn extends MachineState
            sealed trait TurnedOff extends MachineState
        }

        case class Machine[State <: MachineState](){
          def open(implicit ev: State =:= Closed) = Door[Open]()
          def close(implicit ev: State =:= Open) = Door[Closed]()
        }
        ```
* are needed only for compilation
    * do not come with extra runtime overhead
* builder pattern context
    * example: sql query builder
        * problem: aggregation query without `group_by` will fail
        * solution: ZIO SQL
            * https://github.com/zio/zio-sql/blob/b63708a35fb27eeab7a7edf4e320809fce77b5fc/core/jvm/src/main/scala/zio/sql/select/Read.scala#L183
    * case study: case class builder
        * problem: verification that all fields are filled
            ```
            case class Person(firstName: String, lastName: String, email: String)

            Person person = new PersonBuilder()
                .firstName("Hello")
                .lastName("World")
                .build(); // email not set, handle situation
            ```
        * solution
            * naive approach
                1. push checks to runtime - throw runtime exception
                    * loosing referential transparency
                1. `build()` returns `Either[Error, Person]`
                    * troublesome for caller
            * phantom types approach
                ```
                class PersonBuilder[State <: PersonBuilderState] private (
                    val firstName: String,
                    val lastName: String,
                    val email: String) {
                  def firstName(firstName: String): PersonBuilder[State with FirstName] =
                    new PersonBuilder(firstName, lastName, email)
                  def lastName(lastName: String): PersonBuilder[State with LastName] =
                    new PersonBuilder(firstName, lastName, email)
                  def email(email: String): PersonBuilder[State with Email] =
                    new PersonBuilder(firstName, lastName, email)
                  def build()(using State =:= FullPerson): Person = // phantom type
                    Person(firstName, lastName, email)
                }

                object PersonBuilder {
                  sealed trait PersonBuilderState
                  object PersonBuilderState {
                    sealed trait Empty extends PersonBuilderState
                    sealed trait FirstName extends PersonBuilderState
                    sealed trait LastName extends PersonBuilderState
                    sealed trait Email extends PersonBuilderState
                    type FullPerson = Empty with FirstName with LastName with Email
                  }
                  def apply(): PersonBuilder[Empty] = new PersonBuilder("", "", "")
                }
                ```
* ZIO environment parameter context is phantom type
    * is internally used by ZIO to verify that we have provided all the required environment
        * only programs `ZIO[Any, _, _]` are executable
    * usually there is no type `R` that user can provide
        * example: `ZIO[R1 with R2, E, A]`
            * we need to either provide
                1. `ULayer[R1]`, `ULayer[R2]`
                1. `ULayer[R1 with R2]`
                    * there is no value `R1 with R2`


## singleton types
* "inhabitant of a type" means an expression which has some given type
    * example
        ```
        val length: String => Int = (s: String) => s.length
        ```
* usually types has more than one inhabitant
    * `Boolean`: two values
    * `Int`: `[Int.MinValue; Int: MaxValue]`
    * `String`: infinitely many
* notice that there are types that has no values
    * type without any value is the "bottom" type
    * example: `Function1[String, Nothing]`
* singleton types = types which have a unique inhabitant
    * examples
        * `Unit` = only one inhabitant
        * `(a: A, b: B)` = |A| x |B| number of inhabitants
        * `Either(a: A, b: B)` = |A| + |B| number of inhabitants
        * literal types = type inhabited by a single constant value known at compile-time (literal)
            ```
            val i5: 5 = 5
            ```
        * types inhabited by a single value not known at compile-time
            ```
            val userInput = StdIn.readInt()
            val userInput2 = StdIn.readInt()
            val iInput: userInput.type = userInput
            val iInput2: userInput2.type = userInput // not compiling, compiles only with `= userInput2`
            ```
    * bridge the gap between types and values
        * example: compile-time operations on types
            ```
            import scala.compiletime.ops.string.*
            // type Length[X <: String] <: Int

            val a: Length["Hello"] = 5
            val b: Length["Hello"] = "Hello".length() // not compiling, length() returns general Int, but we need 5
            ```
            or for int
            ```
            import scala.compiletime.ops.int.*
            // type +[X <: Int, Y <: Int] <: Int

            val result: 5 + 6 = 11
            ```
            note that operations could be added, suppose that we want to add `Read` type for strings
            ```
            import scala.compiletime.ops.string.Read // type we want to add

            val a: Read["path/to/some/file"] = "Hello\n"

            // 1. go to Dotty core -> Types -> AppliedType -> tryNormalize -> tryCompiletimeConstantFold
            // 1. find where types are handled and add additional entry
            case tpne.Read => constantFold1(stringValue, scala.io.Source.fromFile(_).mkString)
            // 1. add Read name to `tpne` (StdNames)
            final val Read: N = "Read"
            // 1. add to compiletimePackageStringTypes
            ```
* Scala 3
    * `Singleton` is used by the compiler as a supertype for singleton types
        * example
            ```
            summon[42 <:< Singleton]
            ```
    * type inference widens singleton types to the underlying non-singleton type
        * example
            ```
            summon[(42 & Singleton) <:< Int]
            ```
    * when a type parameter has an explicit upper bound of `Singleton`, the compiler infers a singleton type
        * example
            ```
            def singletonCheck5[T <: Singleton](x: T)(using ev: T =:= 5): T = x
            val x = singleCheck42(5) // compiles

            def typeCheck5[T](x: T)(using ev: T =:= 5): T = x
            val x = typeCheck5(5) // not compiles: cannot prove that Int =:= (5 : Int)
            ```
* are a technique for "faking" dependent types in non-dependent languages
    * good approximation of dependent types
* bridges the gap in phase separation between runtime values and compile-time types
    * example
        ```
        val stdInputLine: String = scala.io.StdIn.readLine()
        val inputLine: stdInputLine.type = stdInputLine
        ```
* allow programmers to use dependently typed techniques to enforce rich constraints among the types
    * example: using singletons provably`*` correct sorting algorithm
        * more accurately, it is a proof of partial correctness
        * `*` means: sorting algorithm compiles in finite time and when it runs in finite time => result is indeed a sorted list

## polymorphic lambda
* is a function type which accepts type parameters
    * example
        ```
        def reverse[A](xs: List[A]): List[A] = xs.reverse // polymorphic method
        val reverse2: [A] => List[A] => List[A] = [A] => (xs: List[A]) => reverse[A](xs) // polymorphic lambda
        ```
* are not to be confused with type lambdas
    * polymorphic lambda describes type of a polymorphic value
        * are applied in terms
            * terms = type inhabitants (~ exist at runtime)
                * example
                    * `Nothing` has 0 terms
                    * `Unit` has 1 term
                    * `Boolean` has 2 terms
    * type lambda is an actual function value at the type level
        * are applied in types
* type lambda
    * lets one express a higher-kinded type directly, without a type definition
        * types belong to kinds
            * think of kinds as types of types
            * example
                * `Int` belongs to 0-level kinds
                * `List[_]` belongs to 1-level kinds
                    * it takes 0-level kind as type argument
                    * similar to a function: takes a level-0 type and returns a level-0 type
                        ```
                        [X] -> List[X]
                        ```
    * example
        * type definition
            * unparameterized with a type lambda: `type T = [X] =>> R`
            * parameterized: `type T[X] = R`
                * shorthand for an unparameterized definition
            * unparameterized with a type lambda: `type T = [X] =>> R`
    * defines a function from types to types
        * type analog of “value lambdas”
    * body of a type lambda can again be a type lambda
        * curried type parameters
    * before Scala 3, API designers had to resort to compiler plugins, namely kind-projector, to achieve the same level of expressiveness
        * scala2: doesn’t allow us to use underscore syntax to simply say `Either[Throwable, _]`
            ```
            // type projection implementing the same type anonymously (without a name)
            ({type L[A] = Either[Throwable, A]})#L
            ```
        * kind-projector: `Either[Throwable, *]`
        * scala3: `[K] =>> Either[Throwable, K]`
            * use case: `given Monad[[R] =>> Either[Throwable, R]]`

## dependent types
* gradation
    * values depending on values: functions
        * typed lambda calculi: term - term
    * values depending on types: polymorphism
        ```
        def twice[A](a: A)(f: A => A): A = f(f(a))
        ```
    * types depending on values: dependent types
    * types depending on types: type functions
        * higher order types
* dependent type systems: "values may also appear in types"
* question of how to enforce invariants has two answers in dependent types
    * intrinsic
        * implies that a “wrong” value cannot be constructed at all
        * example
            ```
            -- Agda intrinsic
            get :: (xs : List a l) -> Fin l -> a // Fin is a type defined in such a way that it can only take values from 0 up to n - 1
            ```
    * extrinsic
        * allow any input, but then require an additional proof of the fact that input is within constraints
        * more similar to a refinement
        * example
            ```
            -- Agda extrinsic
            get :: (xs : List a l) -> (n : Nat) -> (inBounds n l) -> a
            ```
* let you move some checks to the type system itself
    * making it impossible to fail while the program is running
* use cases
    1. multiplying matrices
        * encode matrix size in type and verify if multiply is possible at compile time
    1. database queries
        * type of valid queries depends on the "shape" of the database
        * type of the result of a query depends on the query itself
    1. communication protocols
        * what answer is valid for what message
    1. binary serialization
        * all binary formats are described by dependent types
            * exact meaning and layout of later bytes depend on some earlier bytes
            * example: uncompressed picture
                * starts with the size of the picture, number of color channels, bit depth, alignment;
                followed by the raw data, whose size and interpretation depends on those parameters
* Scala context
    * type structure cannot be deduced from runtime structure
        * example: filter in sized vector
            ```
            def filter(p: A => Boolean): SizedList[???, A] // size depends on runtime application of predicate
            ```

## path dependent types
* Scala unifies concepts from object and module systems
    * essential ingredient of this unification is to support objects that contain type members in addition to
    fields and methods
    * to make any use of type members, programmers need a way to refer to them
        * some level of dependent types is required
        * usual notion is that of path-dependent types
* path dependent type is a specific kind of dependent type in which the type depends on a path
* types which are distinguished by the values which are their prefixes
* `Aux` pattern
    * example
        ```
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
        val wAux = Wrapper(1) // Wrapper.Aux[Int]
        val z = wAux.value + wAux.value // ok
        val z = w.value + w.value // compilation fails, type of value is really hidden
        ```
* use cases
    1. hiding internal state: `ZIO Schedule[-Env, -In, +Out]`
        ```
        trait Schedule[-Env, -In, +Out] extends Serializable { self =>
          import Schedule.Decision._
          import Schedule._

          type State

          def initial: State
        ```
        * reason: putting state will make it complex
            * state can be really long like window recur every 5 seconds etc
            * we don't need to know what it is to work with schedule
                * exposing it means exposing implementation detail
        * why not use trait
            * we want to keep it the same in every referred place
        * source: https://github.com/zio/zio/blob/series/2.x/core/shared/src/main/scala/zio/Schedule.scala
    1. type inference & partial application
        * problem: for generics you can only specify all of them or not specify any of the
            ```
            trait Joiner[Elem, R] {
                def join(xs: Seq[Elem]): R
            }

            def doJoin[T, R](xs: T*)(using j: Joiner[T, R]): R = j.join(xs)

            given Joiner[CharSequence, String] with {
              override def join(xs: Seq[CharSequence]): String = xs.mkString
            }

            given Joiner[String, String] with {
              override def join(xs: Seq[String]): String = xs.mkString(",")
            }

            // for Joiner[Elem, R] you can only specify all of them or not specify any of the
            doJoin[CharSequence, String]("a", "b", "c")
            doJoin[String, String]("a", "b", "c")
            doJoin("a", "b", "c")
            ```
        * use case: some subset of types is uniquely determined by other types
            * example: ZIO Zippable
                * source: https://github.com/zio/zio/blob/series/2.x/core/shared/src/main/scala/zio/Zippable.scala
                * no matter how we zip we should always maintain "flat" structure of tuple
                    * `((_, _), _)` ~ `(_, (_, _))` ~ `(_, _, _)`
                    * example
                        ```
                        val zio1: ZIO[Any, Nothing, Int] = ZIO.succeed(1)
                        val zio2: ZIO[Any, Nothing, Int] = ZIO.succeed(2)
                        val zio3: ZIO[Any, Nothing, Int] = ZIO.succeed(3)

                        val zio1_4: ZIO[Any, Nothing, ((Int, Int), Int)] = zio1 <*> zio2 <*> zio3 // ZIO 1: not flattened tuple
                        val zio2_4: ZIO[Any, Nothing, (Int, Int, Int)] = zio1 <*> zio2 <*> zio3 // ZIO 2: no tuples nesting
                        ```
                * digression: it cannot be resolved systematically
                    ```
                    val zio1 = ZIO.succeed(1)
                    val zio2 = ZIO.succeed((2, 3))
                    val zio3 = ZIO.succeed(3)

                    val zio2_4: ZIO[Any, Nothing, (Int, (Int, Int), Int)] = zio1 <*> zio2 <*> zio3 // no implicit for that case
                    ```

## Curry-Howard isomorphism
* both logic and programming with functions are built around the notion of hypotheticals
    * proposition `𝐴→𝐵` says "if I had an 𝐴, I could prove 𝐵"
    * function of type `𝐴→𝐵` says "if I had a value of type 𝐴, I could compute a value of type 𝐵"
    * these logics/languages are really systems for hypothetical reasoning, which we need for both programming and proving
    * whether we say "prove" or "compute" really just depends on whether we only care about
        * existence of an 𝐵
        * or which 𝐵 we get
* propositions as types
    * bottom type = logical falsehood
        * Scala’s `Nothing` type
        * used to define type negation
            ```
            type Not[A] = A => Nothing
            ```
            * on the logical side of Curry-Howard this maps to `A -> false`, which is equivalent to `~A`
        * polymorphic function `absurd[A]: Nothing => A` corresponds to statement "from falsehood you can derive everything"
            * it cannot be constructed, but intuitively it is just a promise: if you give me element of nothing I will
            give you element of `A`
                * usually called `absurd[A]: Nothing => A`
                * notice that for any set 𝐴, there is exactly one function from the empty set to 𝐴
                    * graph of an empty function is a subset of the Cartesian product ∅×𝐴
                        * since the product is empty the only such subset is the empty set ∅
    * function type = implication
        * example: proof that `(a^b)^c = a^(b x c)`
            * logic: `(c⟹(b⟹a))⟺((b∧c)⟹a)`
            * types: `((b, c) -> a) <=> (c -> b -> a)`
                ```
                curry :: ((b, c) -> a) -> c -> b -> a
                curry g c b = g (b, c)

                uncurry :: (c -> b -> a) -> (b, c) -> a
                uncurry f (b, c) = f c b
                ```
    * product type = conjunction
    * sum type = disjunction
    * inhabited types = provable theorems
        * we cannot implement generic function `f: A => B`
            * it would mean we can prove implication `A -> B` - from any information `A` we can derive any information `B`
            * to do that, we need some kind of connection between `A` and `B`
    * summary
        | Algebra | Logic       | Types           |
        |---------|-------------|-----------------|
        | a + b   | a ∨ b       | Either a b      |
        | a × b   | a ∧ b       | (a, b)          |
        | b^a     | a ⇒ b       | a -> b          |
        | a = b   | a ⇔ b       | isomorphism     |
        | 0       | ⊥           | Void            |
        | 1       | ⊤           | ()              |
* relates systems of formal logic to models of computation
    * propositions as types
        * useful way to think of types is to view them as predictions
            * if the expression terminates, you know what form the expression is
    * proofs as programs
        * proof of a proposition is a program of that type
        * provability corresponds to inhabitation
            * if we can find the values that exist for a given a type, it turns out that the type corresponds to a true mathematical theorem
    * normalisation of proofs as evaluation of programs
* propositional calculus
    * implication, negation, conjunction, disjunction, exclusive OR and equality
    * problem: doesn’t know about sets, considering just atomic values
* first-order logic
    * extends propositional logic
        * introduces quantifiers to atomic values
            * Universal quantification ∀
            * Existential quantification ∃
    * corresponds to dependent types
        * statement: for all x, if x is a student then x has an ID
            ```
            trait Student { type Id }
            ```
    * is undecidable
        * Gödel’s incompleteness theorem, which says that even in the formal complete system you can come across with unprovable statements
            * example: "this statement is not provable"
                * case 1: this statement is false => it is provable => we proved something that is false
                    * goes agains whole idea of proofs
                    * if you can proove things that are false => logic is not very useful
                * case 2: this statement is true => we have statements that are not provable
* second-order logic
    * apply quantifiers not only to atomic values but to sets and predicates as well
        * example: there exists a property that holds for all natural numbers greater than 5
            * vs FOL: we can say at most that for property P(x) we have: for all natural numbers greater than 5 P(x) holds
    * corresponds to polymorphic types
        * statement: ∃ P : Students → Bool, ∀ s : Students, hasPassed(s) = P(s)
            ```
            trait StudentPredicate[-A] {
              def test(student: A): Boolean
            }

            def hasPassed[A](student: A)(using predicate: StudentPredicate[A]): Boolean =
              predicate.test(student)
            ```
* has practical implications in e.g. program verification
    * example: proof that `reverse o reverse == identity`
        * by induction and with lemma `reverse (xs ++ ys) == reverse ys ++ reverse xs`
    * formal verification is an automated process that uses mathematical techniques to prove the correctness of the program
        * can prove that program's business logic meets a predefined specification
    * formal model is a mathematical description of a computational process
        * provide a level of abstraction over which analysis of a program's behavior can be evaluated
* in some sense, the Curry-Howard isomorphism isn't an isomorphism at all
    * some people prefer the word "correspondence"
    * maybe it's not "two things that are isomorphic" but "two different views of the same thing"
        * example: `a^1 = a`
            * when viewed through Curry–Howard, it describes an isomorphism between `() -> a` and `a`
            * no distinction between having a value and having a (pure) program that computes that value