import scala.collection.mutable.ListBuffer
object ScalaCollection {
  def  main(args:Array[String])= {
    val numbers = List(32, 95, 24, 21, 17)
    val colors = List("red", "green", "blue")
    println(s"I have ${colors.size} colors: $colors" + "\n Head : "+colors.head + " \n Colors tail: "+colors.tail)

    var total = 0;for (i <- numbers) { total += i }
    println(total)
    println(" forEach takes fucntion and invokes for every element ")
    colors.foreach( (c: String) => println(c) )
    println(" Map takes fucntion and Converts elements to Another List or another Type ")
    val sizesMap = colors.map( (c: String) => c.size )
    println(sizesMap)
    println(" nreduce() takes a function that combines two list elements into a single element")
     total = numbers.reduce( (a: Int, b: Int) => a + b )
    println(total)
    val uniqueSet = Set(10, 20, 30, 20, 20, 10) //Eleminates Duplicates
    //val sum=uniqueSet.reduce((a:Int,b:Int)=>a+b)
    val sum=uniqueSet.reduce(_+_)

    val colorMap = Map("red" -> 0xFF0000, "green" -> 0xFF00,  "blue" -> 0xFF)
    val redRGB = colorMap("red")
    colorMap.foreach(e => println(">>> key=" + e._1 + ", value=" + e._2)) // e a funciton that takes Tuple not 2 different args
    println("Get elements in map")
    for(t<-colorMap)(println(t))
    println("Unbelievable simplicity ...")
    val filterMap= colorMap-"red"
    println(filterMap)

    var primes = List(2, 3, 5, 7, 11, 13)
    while ( {
      !primes.isEmpty
    }) {
      print(primes.head + ", ")
      primes = primes.tail
    }

   println("RIGHT-ASSOCIATIVE NOTATION operators are invoked on the entity to their immediate right.")
    // List
    val numbersL = 1 :: 2 :: 3 :: Nil
    println("Append leements to list ...")
    val numbersLext =numbersL.::(50)
    println(numbersLext+" Head: "+numbersLext.head)
    val compl=    List(1, 2) == List(1, 2)
    println("Compare liste easy way "+compl)
    val f = List(23, 8, 14, 21).filter(_>15)
    println("Filtered list"+f)
    val s = List("apple", "to").sortBy(e=>e.size)   // OR sortBy(_.size)
    val v=List(0, 1, 0).collect({case 1 =>"ok"
    case 0 => "Default"})
    println(v)

    println("List folding Operators ")
    val listf=List(4, 5, 6).foldLeft(2)(_+_)

    val listr=List(4, 5, 6).reduce(_+_)
    println("List fold: "+listf  +" List reduce")

    println(", fold, reduce, and scan are all limited to returning a value of the same type ")
    println("")

    println("Collection matching clause ")
    val statuses = List(500, 404)
    val msg = statuses.head match {
      case x if x <500 => "ok"
      case y if y==500 => 500
      case  _ => "Error"
    }

    println(msg)
    println("collections support == operator")
    val msgc = statuses match {
      case List(500,404) => "Not found and error"
      case List(500,400) => " Not found "
      case List(200,200) => "OK"
      case _=> "Unknown"
    }
    println(msgc)
    val statuses2 = List(550, 404)
    println("Pattern wild card matching ")
    val msgt = statuses2 match {
       case List(500, x) => s"Error followed by $x"
           case List(e, x) => s"$e was followed by $x"
        }
    println(msgt)
    println("Pattern matching with tuple")

    val x = ('h',204,true) match {
      case (_,_,false) => " Not Val found"
        case(_,200,true) => 200
        case('h',_,_) => "h"
    }
    println(x)

    // Create List of 20 odd numbers import scala.collection.mutable.ListBuffer
    var oddList= new ListBuffer[Int]()
    for(i<- 1 to 20) {
      if(i%2!=0) oddList+=i
    }
    println(oddList)
   var facList = commonfactorials(List(3,9,15))
    println(facList)
    println(factorOf(9,3))
    println(commonfactorials(List(15)))

    println("Generic List ")
    println(first(List(1,4,6,7,8),3))
    println(first(List("X","Y","Z","AB","BC","ED"),3))
    println(LongstStrg(List("X","Y","Z","AB","ABZFHTYASDC","ABCED")))
  }//Main

  def factorOf(x: Int, y: Int) =   x % y == 0

   def factorials(l:List[Int]) : Set[Int]= {
      var factorialmap = scala.collection.mutable.Map[Int,Int]()
       for(i<- 0 to l.size-1){
         for(j  <- 1 to l(i)  )
       if(factorOf(l(i),j)) {factorialmap.put(l(i),j); println(l(i)+ "->"+j) } //Map only stores unique
       }
  println("Map")
     println(factorialmap)
     factorialmap.values.toSet
  }

  def commonfactorials(l:List[Int]) : List[Int]= {
    var factorialSet =   scala.collection.mutable.Set[Int]()
    for(i<- 0 to l.size-1){
      for(j  <- 1 to l(i)  )
        if(factorOf(l(i),j)) {factorialSet+=j; println(l(i)+ "->"+j) }
    }
    println("List")
    println(factorialSet)
    factorialSet.toList
  }

  def first[A](items: List[A], count: Int): List[A] =  {    items.slice(0,count) }

  def LongstStrg(strl: List[String]) :String ={

    var ls = strl.head
    for(i<-0 to strl.length-1){
      if (ls.length < strl(i).length) ls=strl(i)
    }
    ls


  }


}


