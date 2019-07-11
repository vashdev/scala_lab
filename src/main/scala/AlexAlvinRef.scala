import scala.annotation.tailrec
import scala.collection.mutable.ArrayBuffer

// ex from Alex Alvin boook
object AlexAlvinRef {
  def main(args: Array[String]) = {
//Def Vs VAL
    def f1(x:Int,y:Int) =x+y
    println(f1(10,20))
    //vs
    val isEven=(i:Int)=>i%2==0  //instance of Function0 ... func22  + A Variable
     println(":vs " +isEven(20))
    def isOdd(x:Int):Boolean={x%2!=0}

    println(" Eta- Expansion use Fun as methods val and def fucntions")

    println("Treating Fucntion as variable")
    def tripDef(x:Int)=x*3
    val tripVal=tripDef _
    println("val tripVal is NOT Eql to tripDef but _ makes it a paratially applied fucntion Eta Expansion")
    println(tripVal(10))

    println("Write Functions that take other fucntions as input parameters")
    val nums=List.range(1,10)
    println {
      nums.filter(isEven)
    }
    println {
      nums.filter(isOdd)
    }

      println("Define Function that takes a string and returns another string")

      def appendHashString(s: String) = s + " UID HashStringValueX "

      println("Define a fucntion thats capable of taking a fucntion like 'appendHashString' and  returns some computed Value ")

      def gethashLen(callbackf: (String) => String): Int = {
        callbackf("AppendString Step X").length
      }
      println("Usage : Now you cna use getLen by passing appendHashString...")
      println("Hash Len of UID="+gethashLen(appendHashString))

      def appendSSHString(s: String) = s + " UID SSH2 HashString Now, gethashLen can take any fucniton with matching signiture  "
      println("SSH2 Len of uid="+gethashLen(appendSSHString))
     println(" One more example of Func Input Parameters")

    def fIPExample( f1:(Int,Int)=>Int , f2:(Int,Int)=>Int, a:Int,b:Int):Tuple2[Int,Int]={
      var v1=f1(a,b)
      var v2=f2(a,b)
      (v1,v2)
    }
    def sumf(x:Int,y:Int) =x+y
    def multi(x:Int,y:Int)=x*y
    var t=fIPExample(sumf,multi,10,20)
    println(" FIP resulting Tuple =" +t)
    println(" Writing your own map function Example , i.e apply a fucntion() to all elements of List and return List with all its elements")

    def myMap[A](fe:(Int)=>A,l:List[Int]  ) : List[A] = for(x <- l) yield fe(x)

    println(myMap(tripDef, List.range(0,10)))
   println(" Its correct- But to be precise since MAP Always maps from Any typeA to Any type B")

    def myMapG[A,B](fe:(A)=>B,l:List[A]  ) : List[B] = for(x <- l) yield fe(x)
    println(myMapG(tripDef, List.range(0,10)))
    println("Example 2")

    def dblLen(s:String):Int=s.length *2

    val stringList=List("abc","dddd","test1","AnimalKingdom")
    val intList=myMapG(dblLen,stringList)
    println(intList)

    println("Parameter groups \n Useful to use as default parameters and type inference ")
    def sumParaGroup(a:Int)(b:Int)(c:Int) =a+b+c
//    var sumParaVal=sumParaGroup(10) (_) (_)
    println(sumParaGroup(20)(20)(20))
    def sumParaGroupDefault(a:Int=10)(b:Int=20)(c:Int=30)={a+b+c}
    println(sumParaGroupDefault()(200)(300))
    /*
    def ifBothTrue(test1: =>Boolean)(test2: =>Boolean)(codeBlock: =>Unit):Unit={
      if(test1 & test2){codeBlock}
    }
    val x=8
    ifBothTrue((true)(true)println("x"))

    println(" Implicit always last parameter a rule ")
    def printIntiftrue(a:Int)(implicit b:Boolean)={ if(b) println(a)}
    val someVal=true
    printIntiftrue(10)
    */
println("Partially applied fucntions ...")
    def plus(a:Int)(b:Int)=a+b
    println( " simpel addition ..")
    println(plus(2)(7))
    println("Create New Function by seedinng more generic fucntion ")
    def partialAppliedplus=plus(5) _
    println(partialAppliedplus(3))
    println(" Currying ...A funtion that takes multiple args is converted to seriels of Partially aplied Function")
    def add(a:Int,b:Int)=a+b
    val addfunction = add _
    val addcurried = (add _).curried
    val addcurried2=addcurried(10)
    println(addcurried2(3))
println("Recurssion Classic Example ")

    def recurSum( l:List[Int] ): Int = {
      @tailrec
      def sumReducer(l1: List[Int], r: Int): Int = {
        l1 match {
          // end of list
          case Nil => r
          // head:tail fashion list
          case head :: tail => sumReducer(tail, head + r)
        }
      }
      // Call it from here
        sumReducer(l, 0)
    }
    println("Solve by Recursion "+recurSum(List(5,10,15,20)))
      println(" Case class- Like Singleton Object Wrappers ")
      // case class
    println("No New +Val by Default + Unapply + copy method ")
      case class Person(name:String,relation:String)

      val v = Person("x","y")
      println(v.name)
    val v1=Person("x","y")
    val z =Person("a","y")

    println("Equality of case class")

    println("Object Instance compare  Compare reference v eq eq z -two different object" +(v==z).toString)
    println( " v and z .equals ? " + v.equals(z))
    println("Object Instance compare v eq eq v1 two obj vars pointing to same object " +(v==v1).toString)
    println( "v and v1 .equals ?" + v.equals(v1))
    println("Update As you copy -gives new object")
    val v3=v1.copy("a1","a2")
    println(v3.name )

    println("******************For/filter By Expression **************")

    val personList= List(v,v1,v3,z)
    val filterForNamesVals=for {
      p<-personList
      fname=p.name
      if(fname=="a1")
    } yield p.relation.toUpperCase
    filterForNamesVals.foreach(println)

    println("******************custm class to use foreach/filter comprehension**********************")
    println("Implementing With for and filter ")
    println("with filter: works on restricting  flatMap,foreach,withfilter on collections ")
    println("Filter returns a new collection")
    /// Class to be used in For comprehension
    case class sequence[A]( initelem:A*){                 //var args
    val e= scala.collection.mutable.ArrayBuffer[A]()       //Array buffer elements
      e++=initelem
      // to enable foreach clause overwrite foreach
      def foreach(block:A=>Unit):Unit ={
        e.foreach(block)
      }
      // to enable yeild
      def map[B](f:A=>B) :sequence[B]={
        println("Only Called for Yeild with for, not reg for expression")
        val abMap:scala.collection.mutable.ArrayBuffer[B]=e.map(f)
        new sequence(abMap:_*)
      }

      // with filter method
      println("Filter method overqwrite withFilter method")
      def withFilter(p:A=>Boolean) :sequence[A]={
        val tempBuffer=e.filter(p)
        sequence(tempBuffer:_*)
      }
      // filter method
      def filter(p: A => Boolean): sequence[A]={
        val tempBuffer=e.filter(p)
        sequence(tempBuffer:_*)
      }
      /*
      // Flatten Map MEthod
      def flatMap[B] (f:A=>sequence[B]):sequence[B]={
        val mapRes: sequence[sequence[B]]=map(f)
        flatten(mapRes)
      }
      def flatten[B](seqofseq:sequence[sequence[A]]):sequence[B]={
        var xs=ArrayBuffer[B]()
        for(listB:sequence[B]<-seqofseq){
          for(e<-listB){
            xs+=e
          }
        }
        sequence(xs:_*)
      }
      */

    }  //sequence class

    val numseq=sequence(1,2,3,4,5)
    for(i<-numseq) println(i)
    println("******************Better Way************")
    numseq.foreach(println(_))

    val testMap=for {
      i<-nums
      if i >2
    } yield i*2
    println("for  with yeild")
println(testMap)
println("Use Filter Method with List")
    println(List(1,2,3,4,5,6).filter(_>5))
    println("Use Filter Method with Sequence case class")
    println(sequence(1,2,3,4,5,6).filter(_>5))
/*
println("Flat Map Vs Map")
    println("FlatMap: Apply Map method then Flatten the collection ")
val fruits = Seq("apple","orange","banana")
    println("Map ...")
    println(fruits.map(_.toUpperCase))
    println("flatMap ...")
    println(fruits.flatmap(_.toUpperCase))
    */
  } //main

}
