object HigherOrdrfuncSamples {
  def  main(args:Array[String])={
    println("bunch of High Order functions - lambdas " )

    println("1st Simple functions  as values....")
    println(sayHello("X"))

    //Assigning a Function with the Wildcard Operator _
    val mydouble=double _
    println(mydouble(5))
    println(" Default Fun type and Func Variable with wild card varibales ..")
    val maxim=max _
    println(maxim(5,10))
    println("Higher-Order Functions. Input OR output is a function")
    println(safeStringOp("My Name is " ,_.reverse))
    println(safeStringOp("My Name is " ,_.toUpperCase))
    println(safeStringOp("My Name is " ,_.trim))
    println(safeStringOp("My Name is " ,_.toLowerCase))
    println(safeStringOp("" ,_.reverse))

    println("Function Literals ..Workign function without a name")
    val doublerf = (x: Int) => x * 2
    println(doublerf(5))
    val greeter = (name: String) => s"Hello, $name"
    println(greeter("TestPara1"))
    val logStart=()=>{
  "   ...Starting Log Now .."
    }
    println(logStart())

    println(combination(5,6,_*_))
    println(tripleOp(23, 92, 14, _ * _ + _))
    println("Placeholder syntax  ..")
    println(tripleOps[Int,Int](23, 92, 14, _ * _ + _))
    println("Partially Applied Functions and Currying")
    val f = factorOf _     // geenral ref to function
    println(" Normal facotr call "+f(4,2))
    println(" multipleOf3 function call "+multipleOf3(3,9))
    println("Partialy applied ...")
    val m3=factorOf(3,_:Int)
    println("Partially applied "+m3(9))
    println("Currying a cleaner Way of partially applied functions concept ...")
    val m4=curriedFactor(4)_
    println(" Much cleaner  "+m4(16))
    println("Partial Functions ...")
    val statusHandler: Int => String = {
      case 200 => "Okay"
      case 400 => "Your Error"
      case 500 => "Our error"
    }
    println(statusHandler(200))
    println("Invoking Higher-Order Functions with Function Literal Blocks")
    val uuid = java.util.UUID.randomUUID.toString
    val timedUUID = safeStringOpcurried(uuid) { s =>
      val now = System.currentTimeMillis
      val timed = s.take(24) + now
      timed.toUpperCase

    }


  val veryRandomAmount = timer {
    util.Random.setSeed(System.currentTimeMillis)
    for (i <- 1 to 100000) util.Random.nextDouble
    util.Random.nextDouble
  }
    reCurex(49)
  }
  // recur fun to print vals in 5's till 50
   def reCurex(num:Int):Int ={
     if(num <5 || num >50) num
     else {
       if(num%5==0) println(num)
       reCurex(num-1)
     }
  }
    def curriedFactor(x:Int)(y:Int)= y%x == 0
  def factorOf(x: Int, y: Int) = y % x == 0
  def multipleOf3(x:Int,Y:Int)= factorOf(3,Y)
  def tripleOps[A,B](a: A, b: A, c: A, f: (A, A, A) => B): B = f(a,b,c)
  def tripleOp(a: Int, b: Int, c: Int, f: (Int, Int, Int) => Int) = f(a,b,c)
  def combination(x: Int, y: Int, f: (Int,Int) => Int) = f(x*10,y*10)
  def safeStringOp(s: String, f: String => String) ={
    if (s != null) f(s) else s
  }

  def safeStringOpcurried(s: String)(f: String => String) = {
       if (s != null) f(s) else s
     }
  def sayHello(s:String)={ println("Hello "+s)}
  def double(x: Int): Int = x * 2
  def max(a: Int, b: Int) = if (a > b) a else b

  def timer[A](f: => A): A = {
    def now = System.currentTimeMillis

    val start = now
    val a = f
    val end = now
    println(s"Executed in ${end - start} ms")
    a
  }
}
