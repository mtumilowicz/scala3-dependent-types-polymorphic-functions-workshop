* https://github.com/milessabin/strangeloop-2013/tree/master
* ["Scala vs Idris: Dependent types, now and in the future" by Miles Sabin and Edwin Brady (2013)](https://www.youtube.com/watch?v=fV2no1Rkzdw)
* https://github.com/mbovel/scalacon-typelevel-operations
* [Type level Programming in Scala - Matt Bovel](https://www.youtube.com/watch?v=B7uficxARKM)
* [Why Netflix ❤'s Scala for Machine Learning - Jeremy Smith & Aish](https://www.youtube.com/watch?v=BfaBeT0pRe0)


to use:
* https://stackoverflow.com/questions/12935731/any-reason-why-scala-does-not-explicitly-support-dependent-types/12937819#12937819
* https://stackoverflow.com/questions/24960722/what-is-the-difference-between-path-dependent-types-and-dependent-types
* https://lampwww.epfl.ch/~amin/dot/fpdt.pdf

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