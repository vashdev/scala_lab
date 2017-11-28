object FpInScala {
  def  main(args:Array[String])= {
    println( "Ref: Functional Programming in Scala Examples")
    println(fib(5))

  } //Main

  def fib(n: Int): Int = {
    @annotation.tailrec
    def loop(n: Int, prev: Int, cur: Int): Int =
      if (n <=0) prev
      else loop(n -1, cur, prev + cur)
    loop(n, 0, 1)
  }


}
