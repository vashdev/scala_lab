import scala.collection.mutable.ListBuffer

object ScalaExampleAlexAlven {
  def main(args: Array[String]) = {
    //Funciton as values
    val name = "Al" // string value
    val weight = 222 // int value
    val double = (i: Int) => i * 2
    //implicit rtn type
    val isEvenimpl = (i: Int) => i % 2 == 0
    // val isEven = (i: Int=>Boolean) => i % 2 == 0  impl return type for these...
    println("isevn implicit syntax " + isEvenimpl(40))

    println(" store them  in MAP as K,V ")
    val dbl = (i: Int) => i * 2;
    val triple = (i: Int) => i * 3
    val fmap=Map("2x"->dbl,"3x"->triple)
    println(fmap)
    val dblmap=fmap("2x")
    println("Using dbl fucntion from map")
    println(dblmap(100))

    println(" val function vs def ")
    println("Val function is  instance of Function1 ...Function22 Trait")
    println(dbl(50) +" "+this.dbl(50))
    println("Use def Method as Variable ")
    val dblf2m=this.dbl _
    println(dblf2m(50))
    println("Create def Maps")
    val defmap=Map("2x"->dblf2m)
    val dub=defmap("2x")
    println(dub(50))

    println("Defining functions that take functions as parameters")
    sayHello(helloAl)
    println("Taking a function parameter along with other parameters")
    println(executeNTimes(helloAl,5))
println("######################################################################")
println(" Writing map function")
val l1= List(1,2,3,5,6,7,8,9,10)
    println()
    println(customMap(dbl ,l1))
    println("Custm Filter")
    println(customFilter(isEvenimpl,l1))
    println(" Func By-name is just Evaluvated at function Access -Leave off () after input para declaration for by name funcs ")
    val (result, time) = timer(println("Hello"))
println(time)
    println("Test While loop by name")
    var i = 1
    whilstbyName(i < 5) { println(i); i += 1 }
    //reset i
     i = 1
    whilstbyVal(()=>i<5) { println(i); i += 1 }

    println("currying ...")
    // Currying

    val addFunction = add _
    val addCurried = (add _).curried
    addCurried(1)(2)


println("PAF: Partially applied function are more useful ...")

    val plus1=plus(10)_
    println(plus1(5))

    val hello = "Hello, world"
    val results = wrap("<div>")(hello)("</div>")
    val resultsGenericwithPartilFunc = wrap("<div>")(_: String)("</div>")
    println(resultsGenericwithPartilFunc("Whatever"))


  }
  def dbl (i:Int) :Int=i*10000
  def helloAl(): Unit = { println("Hello, Al") }
  def sayHello(callback: () => Unit) { callback() }
  def runAFunction(f: Int => Unit): Unit = { f(42) }
  def printAnInt (i: Int): Unit = { println(i+1) }
  def executeNTimes(f: () => Unit, n: Int) { for (i <- 1 to n) f() }
  def customMap[A](f:(Int)=>A,l:List[Int]):List[A] ={
    for { x <- l } yield f(x) //<-- apply 'f' to each element 'x'
  }
  def customFilter(f:(Int)=>Boolean,l:List[Int]):List[Int] = {

    {
      for {
        e <- l

        if (f(e))  //no logical and operator required
        if (e < 10)
      }
        yield e // cant creat var lsit var and add ...immutable list even buffer list wont work to retunr list this is best way
    }
  }

    def timer[A](blockOfCode: => A) =
    {
      val startTime = System.nanoTime
      val result = blockOfCode
      val stopTime = System.nanoTime
      val delta = stopTime - startTime
      (result, delta)

    }
//Byname parameters
  def whilstbyName(testCondition: => Boolean)(codeBlock: => Unit): Unit = { while (testCondition) { println("code Block byname");codeBlock } }
  def whilstbyVal(testCondition:() => Boolean)(codeBlock: => Unit): Unit = { while (testCondition()) { println("code Block by val Supposed to be  inf loop but i dont see it");codeBlock } }
// Partially applied Function
  def plus(a:Int)(b:Int) = a+b
  def wrap(prefix: String)(html: String)(suffix: String) = { prefix + html + suffix }
  // curried Fucntion
  def add(x: Int, y: Int) = x + y
  val addFunction = add _
  val addCurried = (add _).curried



}