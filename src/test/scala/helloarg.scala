/*/
************start interpreter  *
C:\Users\ashodha\scala-2.12.3\scala-2.12.3\bin/scala
// /C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala>
C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala>scalac CheckSumAccumulatorApp.scala


PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala> scalac CheckSumAccumulatorApp.scala
PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala> scala CheckSumAccumulatorApp test
test:-192


PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala> scala
Welcome to Scala 2.12.3 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_144).
Type in expressions for evaluation. Or try :help.

PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala> scalac -cp . RationalClient.scala
PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala> scalac -cp . Rational.scala
PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala> scalac -cp . RationalClient.scala
PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala> scala -cp . RationalClient.scala 16 8

PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala>  scalac -cp .  CurryingExample.scala
PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala>  scala -cp .  CurryingExample
PlainSum ...
3
//http://baddotrobot.com/blog/2013/07/21/curried-functions/
//Learning Scala by Jason Swartz
*
// val is like hava final
val tt="some strng"
//tt="chane illigal"


println("Hello "+ args(0) + "!")
// funtion literal '()' with arument args
args.foreach(
  (arg: String)=>println(arg)
)

// let Scala infer arg type
args.foreach(
  arg=>println(arg)
)

//Funtion literal with single args

args.foreach( println)
//array parameters
val greets=new Array[String](3);
greets(0)=" one Very  ..........Long .....................................String"
greets(1)="   test"
greets(2)="   *******************************************"
for(i<-0 to 2) println(greets(i))  // to method called without dot (illustrates mthod call without dot for single parameter methods)
                                // i is val not a var since i cannot be reassigned inside for loop
// or
val greets2 = Array("zero","one","two");
val operators=(1).+(5)   // no operators + - etc everything is method
println(operators)
println("********************illustrate default apply method ***************")
for (i<-0 to 2 ) println(greets.apply(i  ))   // Default Method invoked by compiler for rray element access

//Lists always immutable - in java list.set(index,val) whihc is mutable
val odds = List(1,3,5)
val evens = List(2,4,6)
val nums=odds:::evens  //list concat :::
println(nums)

// List prepend method - append is list.append but  linear (O)
println(" List prepend for O(1) , but append  list.append  linear (O)")
val cent = 100::nums //nums.::(1)  append method on nums

println(cent)
println("invoking :: on objects without nil 3 is not used")
val numlist = 1::2::3::Nil
 println("**************** tuples to store heterogeneous objects *****************")
val pair =(99,"ballons")
println(pair._1 + " "+  pair._2)

//set - mutables and immutables come rom traits
var jetset = Set("B","A")
jetset+="c"
println(" immutable Sets Demo  jset cannot be val :")
println(jetset)


import scala.collection.mutable
val mset = mutable.Set("x","Y")
mset+="z"
println(" Mutble sets- mset is a val but gets updated ")
println (mset)

println(" Mutable hash set  ")

val hset = mutable.HashSet("t","S")
hset+="P"
println(hset)

println(" Mutable Map  ")
val tMap = mutable.Map[Int,String]()
tMap+=(1->"First string")
tMap+=(2->"Sec string")
tMap+=(3->"thrd string")
tMap+=(4->"Frth string")

println(tMap)

//Unit   function returning any useful value just output stream
def printArgs ( args: Array[String]) : Unit ={
  args.foreach(println)
}
println(printArgs(args))
def formatArgs( args: Array[String]) = { args.mkString("", "X", "X")}

println(formatArgs(args))
println(" test Assert function ")
val res=formatArgs(Array("one","two"))
print(res)
assert(res=="oneXtwoX")

val tt="some strng"
// var increase =(x: Int)=>(x+1)



=>  funtion literal that converts  thing on lft side to thing on rt


scala> somNum.foreach((x: Int) => println(x))  //remove func name
0
10
5
8
12
scala> somnum.filter((x:Int)=>x>0)
res1: List[Int] = List(49, 55, 175)

scala> somnum.filter((x)=>x>0)          // type inference for target typing [inferring type based on target usage)
res2: List[Int] = List(49, 55, 175)

scala> somnum.filter(x=>x>0)             //remove paranthesis
res3: List[Int] = List(49, 55, 175)
scala> somnum.filter(_>0)               //place holder syntax
res4: List[Int] = List(49, 55, 175)


scala> val f=f(_+_)
<console>:11: error: recursive value f needs type
       val f=f(_+_)
             ^

scala> val f=(_ : Int) + (_ :Int)
f: (Int, Int) => Int = $$Lambda$1051/497813380@3703a400

scala> somnum.foreach(println(_))        // under score as para list       
-111
-50
-60
49
55
175

scala>
scala> val somnum = List(1,22,4,-5,-9,-33)
somnum: List[Int] = List(1, 22, 4, -5, -9, -33)

scala> somnum.foreach(println _)              //partially applied func
1
22
4
-5
-9
-33

scala> def sum(a: Int, b: Int, c: Int) = a+b+c
sum: (a: Int, b: Int, c: Int)Int

scala> val a = sum _
a: (Int, Int, Int) => Int = $$Lambda$1048/1355074@608b906d

scala> val b = sum (3, _ , 5)
<console>:12: error: missing parameter type for expanded function ((x$1: <error>) => sum(3, x$1, 5))
       val b = sum (3, _ , 5)
                       ^

scala> val b = sum (3, _: Int , 5)
b: Int => Int = $$Lambda$1062/44979584@4203529f

scala>

scala closure  (function  literals  reffering variables outside the passed parameters

scala> val m1 = 99
m1: Int = 99

scala>

scala> val g = (_:Int) + m1
g: Int => Int = $$Lambda$1090/881344418@20a1c8a1

scala> g(10)
res7: Int = 109

scala> val m1 = 88
m1: Int = 88

scala> g(10)
res8: Int = 109

scala> val g = (_:Int) + m1
g: Int => Int = $$Lambda$1091/873094226@156542b7

scala> g(10)
res9: Int = 98

scala>


File Grep util
PS C:\Users\ashodha\Documents\GitHub\Scala_lab\src\main\scala> scala  FilterfileClient.scala  C:\Users\ashodha\Documents
\GitHub\Scala_lab\src\main\scala scala
*/


