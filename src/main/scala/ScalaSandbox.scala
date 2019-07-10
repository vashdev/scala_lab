import scala.collection.mutable.ArrayBuffer

object ScalaSandbox extends App {
  println("Test Setup ..!")
  println("Book Alexander alvin ...!")
  println("Functional code is characterised by one\nthing: the absence of side effects. It (a pure function) doesn’t rely\non data outside the current function, and it doesn’t change\ndata that exists outside the current function. Every other\n‘functional’ thing can be derived from this property. Use it\nas a guide rope as you learn.")
  println("language features : immutable data, first class functions, and tail call\noptimisation")
  println(" programming technique:   mapping, reducing, pipelining, recursing,   currying and the use of higher order functions. These are     programming techniques")
  println(" Scala is Implicit ..but dont use it ..   ")
  println(" Scala  Insted of mutating existing object use case classes to copy updated values to new objects  and becuase of this too much RAM ..   ")
  println("Things that can be mapped over shall be called … Functor.")
  println("higher-order function : take fucntion as parameter  and return a fucntion")
  println(" Lambda: Anonymous Fucntion")

  println(" fucntion ot map over a list without recurssion - I want to write a map function that can be used to apply other\nfunctions to each element in a List[Int] that it’s given ")
  //Start like this - a fucntion map takes a fucntion and list as input, returns a list Book Learning Funtional Programming  in scala Alvin alexander pg 280
  // def map( f:(?)=>?, list:List[int]):???
  // Step 2  Make return genric
  // def map( f:(?)=>?, list:List[int]): List[A]
  // step 3 Scala you add generic type before fucntion signiture
  // def map[A](f:()=>?,list:List[Int]): List[A]
  // step 4 Because f’s input parameter will come from the List[Int], the parameter type must be Int  + Because the overall map function returns a List of the generic typeA, f must also return the generic type A
  // def map[A](f:(Int)=>A,list:List[Int]): List[A]
  // Step5 Convert Int to generic : Fucntion takes element of list which is of type B and returns element of list as type A
  // def map[A,B](f:(B)=>A,list:List[B]): List[A]
  // step 6 replace list with more generic class sequencer
  // def map[A,B](f:(B)=>A,list:Seq[B]): Seq[A]

  def map[A, B](f: (B) => A, list: Seq[B]): Seq[A] = {
    for {
      x <- list
    } yield f(x)
  }

  // Fucntion has input + out put and since its also a value the body goes after =
  def dbl(i: Int): Double = i * 2

  val nums = List(1, 2, 3)
  println(map(dbl, nums))

  // Write filter fucntion
  // Fucntion should take a collection and applya  fucntion and return the smaller collection
  def filter[A](f: (A) => Boolean, c: Seq[A]): Seq[A] = {
    for {
      item <- c
      if f(item)
    } yield item
  }

  def isEven(e: Int): Boolean = {
    e % 2 == 0
  }

  println(filter(isEven, nums))
  println("How to Use By-Name Parameters")
  println("in Scala the term  ' call by-value '  means")
  println("A primitive value (like an Int) that can’t be changed OR  val pointer  like case class Values cannot be changed")
  println(" This (by-name) indicates that the argument is not evaluated\nat the point of function application, but instead is evaluated\nat each use within the function.")
  println("Call on access / Evaluate on access / Evaluate on use/ Evaluate when referenced")

  print(" Write a function that takes fucntion or piece of code and tells how long it took time to run it")
  // def timer[A](f:(A)=>A,long: Long)= { ( A,long)}
  // val (result, time) = timer{ Thread.sleep(500); 1 }  <- This will not work wiht above signiture
  println(" Hence   By-Name Parameters")
  // timer take piece of code as input and output time and result
  //  def timer(pieceofCode ):(result,Time to Execute peiceofcode())
  println(" By name parameter: you cna leave off () of fucntion, The main difference is that you leave off the () after the input parameter")

  def timer[A](blockOfCode: => A) = {
    val startTime = System.nanoTime
    val result = blockOfCode
    val stopTime = System.nanoTime
    val delta = stopTime - startTime
    (result, delta / 1000000d)
  }

  timer(println("Hello"))
  timer(filter(isEven, nums))

  println(" Functions Can Have Multiple Parameter\nGroups")
  println(" They let you have both implicit and non-implicit parameters / They facilitate type inference /A parameter in one group can use a parameter from a previous\ngroup as a default value")
  println(" Read the last one again ... parameter from previous group cna be defaut ")

  def sum(a: Int)(b: Int)(c: Int) = a + b + c

  println(sum(1)(2)(3))
  println(" Using default values ")

  def f2(a: Int = 1)(b: Int = 2) = {
    a + b
  }

  print(f2()())

  println(" One parameter group using previous as default b takes a value ...")

  def f3(a: Int = 1)(b: Int = a) = {
    a + b
  }

  println(f3()())


  println(" Partially-Applied Functions -and Currying")

  // result = f(x)(y)(z)
  // f1 = f(x)
  // f2 = f1(y)
  // result = f2(z)
  def plus(a: Int)(b: Int) = a + b

  def plus2 = plus(2)(_)

  println(plus2(2))

  println(" Cook up a curry ")

  def add(x: Int, y: Int) = x + y // Function
  val addCurried = (add _).curried // turn to Partially applied fucntion
  println(addCurried(1)(2))
  val addCurriedTwo = addCurried(2)
  println(addCurriedTwo(10))

  println("Recurrsion  using match")
  println(" Nil and List() are same ....")
  println("the JVM feels the need to create a new instance of sum for each element in the collection. ")
  println("only one stack frame — as opposed to one stack frame for each Tail-Recursive Algorithms  level of recursion!")
  def sumList(l: List[Int]): Int = l match {
    case Nil => 0
    // Use space for ::
    case head :: tail => head + sumList(tail)
  }

  println(sumList(List(1, 4, 5, 6, 7, 8)))
  println("Stack overflow")
  //  val xs= List.range(1,1000000)
  //  println(sumList(xs))

  println(" Remedy - Tail recurrsion .... 3 steps")
  println(" Create another fucntion with same parent fucntion signiture and Additional paramter accumulator to store intermediate results")
  println(" 2nd fucntions uses this accumulator to store intermediate results")
  println(" call this 2nd fucntion inside 1st with a initial value : - starter ")

  import scala.annotation.tailrec

  def RecursivesumList(l: List[Int]): Int = {
    @tailrec
    def RecursivesumListWithAccumulator(list: List[Int], AccumulatorTotal: Int): Int = list match {
      case Nil => AccumulatorTotal
      case x :: xs => RecursivesumListWithAccumulator(xs, AccumulatorTotal + x)

    }

    RecursivesumListWithAccumulator(l, 0)
  }

  println(RecursivesumList(List.range(1, 1000000)))


  println(" Case classes ")
  println("  apply method to  eliminate new keyword ")
  println("  getters and setters are generated but they are non mutable after creation")
  println("  unapply method to fecilitate match pattern ")
  println("  equals and hash code ")
  println("tupled, curry, curried,")

  // Define
  case class Electronics(Computer: String, Tab: String)

  // Use
  val equip = Electronics("Dell", "Apple")
  val equip2 = Electronics("Dell", "Dell")
  val equip3 = Electronics("Samsung", "Samsung")

  println(" if object dosent match its nasty error - does not act like  if stateemnt- have Nil as one of match options  ")

  //equip match {
  //  case Electronics("Samsung","Samsung")=> println(" Open software")
  //}


  // Match
  equip3 match {
    case Electronics("Samsung", "Samsung") => println(" Open software")
  }
  //Equals method
  println("Case Equals method")
  println(equip2.equals(equip4))

  println(" copy method ...OR update you copy works but themselfs are unmutatable once created")

  val equip4 = equip.copy(Computer = "E-Machines")
  println(equip4)
 println(equip4.Computer)

  println("  FOR LOOP")
  println(" Comprehensions have the form for (enumerators) yield e,\nwhere enumerators refers to a semicolon-separated list of enumerators.\nAn enumerator is either a generator which introduces ( p<- persons ) \nnew variables, or it is a filter")

  println("the for expressions you write is turned into  a series of method calls that may include map, flatMap, foreach, and\nwithFilter.")

  case class Person(firstName: String, lastName: String)

  val people = List(Person("x", "y"), Person("x1", "Y1"), Person("X2", "Y2"), Person("X3", "X4"))
  val namesStartingWithx = for {
    p <- people // generator
    fname = p.firstName // definition
    if (fname startsWith "x") // filter
  } yield fname
  namesStartingWithx.foreach(println)



  println( " the Class we write with map , flatmap, withfilter cna be used in for expression ")
  abstract class CustomClass[A] {
    def map[B](f: A => B): CustomClass[B]
    def flatMap[B](f: A => CustomClass[B]): CustomClass[B]
    def withFilter(p: A => Boolean): CustomClass[A]
    def foreach(b: A => Unit): Unit
  }

// a class that can be used  in for comprehension etc.. like above
  // genric class with variable args
  case class Sequence[A](initialElems:A*){
    private  val elems=scala.collection.mutable.ArrayBuffer[A]();
  elems ++= initialElems
// make for work ...
def foreach(block: A => Unit): Unit = {
  elems.foreach(block)  // standard scala arraybuffers for ...
                                 }
// make it work for for /yeild ....

  def map[B](f: A => B): Sequence[B] = {
    val abMap: ArrayBuffer[B] = elems.map(f)
    // return as new sequence ....
    Sequence(abMap: _*)
  }

  // Make it work for filter

  def withFilter(p: A => Boolean): Sequence[A] = {
    val tmpArrayBuffer = elems.filter(p)
    Sequence(tmpArrayBuffer: _*)
  }
  def flattenlike[B](seqOfSeq: Sequence[Sequence[B]]): Sequence[B] = {
    var xs = ArrayBuffer[B]()
    for (listB: Sequence[B] <- seqOfSeq) {
      for (e <- listB) {
        xs += e
      }
    }
    Sequence(xs: _*)
  }
  // make it work for flatmap
  def flatMap[B](f: A => Sequence[B]): Sequence[B] = {
    println("Calling flats")
    val mapRes: Sequence[Sequence[B]] = map(f) //map
    flattenlike(mapRes) //flatten
  }



  }

  val strings = Sequence("a", "ab", "abc")
  for(s<-strings) {
    println(s)
  }
  val x=for{
    s<-strings

  } yield s.length*2

  print(x)
val ints=Sequence(1,2,3,4,5,6,7)
  val z= for {
    i<- ints
    if isEven(i)
  }yield i
  print(z)

  val myFriends = Sequence(
    Person("Adam","X"),
    Person("David","y"),
    Person("Frank","z"))
  val adamsFriends = Sequence(
    Person("Nick","a"),
    Person("David","g"),
    Person("Frank","z")
  )

  val mutualFriends = for {
    myFriend <- myFriends // generator
    adamsFriend <- adamsFriends // generator
   if (myFriend.firstName == adamsFriend.firstName)
  } yield myFriend

  mutualFriends.foreach(println)

  /// / function returning an OPTION

  def makeInt(s: String): Option[Int] = {
    try {
      Some(s.trim.toInt)
    } catch {
      case e: Exception => None
    }
  }
  makeInt("50") match {
    case Some(i) => println(s"i = $i")
    case None => println("toInt could not parse 'input'")
  }
// Some and None classes have map and flatmap so this will work
   val result = for {
     x <- makeInt("1")
     y <- makeInt("hi mom")
     z <- makeInt("3")
     } yield x + y + z

   println(" Scala/FP developers use Option rather than exceptions ")
  println("Scala constructs like match and for work great with Option")

  println(" Option Snubbs error ... so for catching Error")
  import scala.util.{Try, Success, Failure}
  def getInt(s: String): Try[Int] = Try(s.trim.toInt)
  val exp = for {
    x <- getInt("1")
    y <- getInt("hi mom")
    z <- getInt("3")
  } yield x + y + z
  println("Gives a failure object" )
  println(exp)
  getInt("hello") match {
    case Success(i) => println(s"Success, value is: $i")
    case Failure(s) => println(s"Failed, message is: $s")
  }
val c = "crazy" * 3
  println(c)
  println(10 min 2)
  println("first Digit"(0))
}



