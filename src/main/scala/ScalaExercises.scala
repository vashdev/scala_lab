import scala.annotation.tailrec
// https://www.scala-exercises.org/scala_tutorial
object ScalaExercises {
  def  main(args:Array[String])={
    println(gcd(50,4))
    println(factorialTail(4)  )

  }//Main

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(x: Int, acc: Int): Int = {
      if (x > b) acc
      else loop(x +1, acc + f(x))
    }
    loop(a,1 )
  }

  def factorial(n: Int): Int =
    if (n == 0) 1 else n * factorial(n - 1)

  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def factorialTail(n: Int): Int = {
    @tailrec
    def iter(x: Int, result: Int): Int = {
      if (x == 0) result
      else iter(x - 1, result * x)
    }

    iter(n,1)

  } //factorialTail

}
