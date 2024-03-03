* https://github.com/milessabin/strangeloop-2013/tree/master
* ["Scala vs Idris: Dependent types, now and in the future" by Miles Sabin and Edwin Brady (2013)](https://www.youtube.com/watch?v=fV2no1Rkzdw)
* https://github.com/mbovel/scalacon-typelevel-operations
* [Type level Programming in Scala - Matt Bovel](https://www.youtube.com/watch?v=B7uficxARKM)
* [Why Netflix ❤'s Scala for Machine Learning - Jeremy Smith & Aish](https://www.youtube.com/watch?v=BfaBeT0pRe0)
* https://docs.scala-lang.org/sips/42.type.html
* https://dotty.epfl.ch/api/scala/Singleton.html
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

to use:
* https://stackoverflow.com/questions/12935731/any-reason-why-scala-does-not-explicitly-support-dependent-types/12937819#12937819
* https://stackoverflow.com/questions/24960722/what-is-the-difference-between-path-dependent-types-and-dependent-types
* https://lampwww.epfl.ch/~amin/dot/fpdt.pdf

## prerequisite


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
    * example of standard type that has only one inhabitant: `Unit`
    * example
        ```
        val i: Int = 5
        val i5: 5 = 5
        val iType: i.type = i
        ```
    * bridge the gap between types and values
* literal types are also singleton types
    * literal = an expression is equal to some specific primitive value known at compile time
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

## dependent types
* you can write types that depend on terms (calculations)
    * is enough to specify types about every aspect of your program
    * means the type system is capable of full program specification
* problem: can't automatically do type inference
    * have to write annotations for your program in the form of proofs
    * solution: one can improve the basic hygiene of one's programs, enforcing additional invariants in types
        * without going all the way to a full specification
    * maybe place for AI?
* are fundamentally hard
    * first-order logic is undecidable
* means that types can depend on values
    * in other words: values can parameterise types
    * example: Idris - https://tio.run/#idris
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
* connected to formal verification
    * formal verification is an automated process that uses mathematical techniques to prove the correctness of the program
        * can prove that program's business logic meets a predefined specification
    * formal model is a mathematical description of a computational process
        * provide a level of abstraction over which analysis of a program's behavior can be evaluated
    * blockchain context: smart contracts
        * example
            ```
            uint user1Balance;
            uint user2Balance;
            uint totalSupply; // = user1Balance + user2Balance

            function transferFromUser1(uint amount) {
                user1Balance = user1Balance - amount;
                user2Balance = user2Balance + amount;
            }
            ```
            define program invariants
            ```
            // Formula 1: totalSupply = balance1 + balance2
            ```
            and translate `transferFromUser1` into formulas true at each point
            ```
            function transferFromUser1(uint amount) {

                user1Balance = user1Balance - amount;

                // old(balance1) represents the value of balance1 when entering the function.
                // Formula 2: totalSupply = old(user1Balance) + user2Balance
                // Formula 3: user1Balance = old(user1Balance) - amount // implied by the assignment
                // Formula 4: Formula 2 ^ Formula 3

                user2Balance = user2Balance + amount;

                // old(user2Balance) represents the value of balance2 when entering the function.
                // Formula 5: (totalSupply = old(user1Balance) + old(user2Balance)) ^
                //            (user1Balance = old(user1Balance) - amount)
                // Formula 6: user2Balance = old(user2Balance) + amount   // implied by the assignment
                // Formula 7: Formula 5 ^ Formal 6
            }
            ```
            proof that `transferFromUser1` maintains the program invariant


## path dependent types
* Scala unifies concepts from object and module systems
    * essential ingredient of this unification is to support objects that contain type members in addition to
    fields and methods
    * to make any use of type members, programmers need a way to refer to them
        * some level of dependent types is required
        * usual notion is that of path-dependent types

## Curry-Howard isomorphism


* spark pipes
    * example1
        trait TransformFunction[In, Out] {
            def andThen[In2, Out2](next: TransformFunction[In2, Out2])
            (using c: SchemaComposition[In, Out, In2, Out2]) : TransformFunction[c.CombinedIn, c.CombinedOut]
        }
        example
        val first: TransformFunction[A with B, C]
        val second: TransformFunction[B with C with D, E with F]

        val result: TransformFunction[A with B with D, C with E with F] = first andThen second
    * example2: search for standard transform functions that can provide missing columns needed
        trait TransformFunction[In, Out] {
            def adapted[S](using adapt: AdaptTransform[In, S]): adapt.Out
        }

        sealed trait B extends Col[B]
        object B extends B {
            // given A and C, B can be derived with a known transform
            // also provides a bonus E column
            given provide: ColProvider[B, A with C, B with E]
        }

        val fn: TransformFunction[A with B with C, D]
        val data: Dataset[A with C]

        val result: Dataset[A with B with C with D with E] = fn.adapted(data)

* https://tio.run/#idris
    ```
    data Vect : Nat -> Type -> Type where
      Nil : Vect Z a
      (::) : a -> Vect n a -> Vect (S n) a

    v : Vect 3 Integer
    v = 10 :: 5 :: 1 :: Nil

    cons : a -> Vect n a -> Vect (S n) a
    cons x xs = x :: xs

    head : Vect (plus 1 n) a -> a // (S n)
    head (x :: xs) = x

    vjoin : Vect n a -> Vect m a -> Vect (n + m) a
    vjoin Nil ys = ys
    vjoin (x :: xs) ys = x :: vjoin xs ys

    emptyVect : Vect 0 a
    emptyVect = Nil

    hhh : Integer
    hhh = head v

    main : IO ()
    main = putStrLn $ "Head of v assigned to hhh: " ++ show hhh
    ```