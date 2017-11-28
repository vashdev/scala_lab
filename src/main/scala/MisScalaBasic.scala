import scala.annotation.tailrec
object MisScalaBasic {

  def  main(args:Array[String])= {

    //Match Sample
    val day = args(0)  // ex :"MON"
    val kind = day match {
      case "MON" | "TUE" | "WED" | "THU" | "FRI" =>"weekday"
      case "SAT" | "SUN" =>"Weeknd"
      /* Default with _ or Anyname */
      case anyWordthisToomuchFreedom  => {
        println("Not a Week Day")
      }
      /*
    case _ => {
      println("Not a Week Day Default 2")
    }
    */
    }
    print(day +" "+ kind)


    val x: Int = 12180
    val y: Any = x
    val z=y match {
      case x: String => s"'x'"
      case x: Double => f"$x%.2f"
      case x: Float => f"$x%.2f"
      case x: Long => s"${x}l"
      case x: Int => s"${x}i"
    }
    println("Matches right type " +z)
    println(" Collet Iterations and put it in vector")
    val v = for (x <- 1 to 7) yield { s"Day $x:" }
    println(v)
    println("ITERATOR GUARDS ..adds an if expression to an iterator. ")
    val threes = for (i <- 1 to 20 if i % 3 == 0) yield i
    println(threes)

    println( " nested loops ..");
    val tup= for { x <- 1 to 2
                   y <- 1 to 3 }
    {print(s"($x,$y) ") }
    println(tup)
    println(hi)

  println("Stack overflow with toomuchr ecurssion ")
    //println(power(5,300000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000))
    println(power(5,3))
  println("remedy ...tail recurssion:e. Only functions whose last statement is the recursive invocation can be optimized /If the result of invoking itself is used for anything but the direct return value, a function can’t be optimized")
    println("... function annotation...." )
    println(recur(2,8))
 //  val f= fib()
   //println(f)
   // val f1=fibtailrec(9)
   // println(f1)
  println("Var Arg example")
    sum(10,20)
    println("Parse List ...")
    val l=List(10,20)
   println( sumList(l))
    println("Identity funtion with paarameter type -act like caste, Like Class types ")
    val s: String = identity[String]("Hello")
    val d: Double = identity[Double](2.717)
    println("String Paramter "+s + "Double Parameter  "+d)

  }  //End Main

  def hi(): String = "hi"
  //recurssion
  def power(x: Int, n: Int): Long = {
       if (n >= 1) x * power(x, n-1)
       else 1
     }
  @annotation.tailrec
  def recur(x: Int, n: Int, t: Int = 1): Int = {
     if (n < 1) t
     else recur(x, n-1, x*t)
     }
   // https://alvinalexander.com/scala/scala-recursion-examples-recursive-programming
  // (3) good descriptions of recursion here:
  // stackoverflow.com/questions/12496959/summing-values-in-a-list
  // this example is from that page:
  def sumList(xs: List[Int]): Int = {
    if (xs.isEmpty) 0
    else xs.head + sumList(xs.tail)
  }
  //recurssion
  def fib(x:Int=0,y:Int=1): Int= {
    val z = x + y
    println(z)
    if (z > 1000) System.exit(0)
    fib(y, z)
  }

  def sum(items: Int*): Int = {
       var total = 0
       for (i <- items) total += i
       total
       }
  // Identity function with parameter type
  def identity[A](a: A): A = a



}
