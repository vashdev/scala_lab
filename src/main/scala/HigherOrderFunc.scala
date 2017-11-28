import HigherOrdrfuncSamples.reCurex
/*
Examples by: Learning Scala by Jason Swartz
 */
object HigherOrderFunc {
  def  main(args:Array[String])={
var rtnVal=calcTotal(List(1,2,3,4,5,6,7,8))
    var l=List(11,12,13,14,15,16,17,18)
  println(rtnVal)
    println(calcEvenTotal(List(1,2,3,4,5,6,7,8)))
    println("Hig Order Funtion Example")

    var res=calcTotalSel(l,{e=>{println("val of e: "+e);  e%2!=1}})
    println(res)
   // println(addTwoListSel(List(17,18),List(12,14),{e=>e%2!=1},{e2=>e2%2==1}))
    println("tail Recursion "+factorialImpl((5),1))
    println("Recurssion "+ factorial(5))
   println("Tuples")
    val t=(50,100)
    println(offset((10,20),(40,50)))
    println(offset((10,20),t))
    println("Passing Functions by name")
    println(pickOne( (10,30,50),max ))
    println("Passing Functions by passing body /logic")
    println(pickOne( (10,30,50),(num1,num2)=>if(num1>num2) num1 else num2 ))
    println("functions returning fucntions ")
    val multiplier=rtnfunction(10)
    println(multiplier(5))
    println("")
    fzero("Hello", s => println(s.reverse))
    println("This throws exception  \n val sq=square to assign fuction value give default args type _")
    val sq=square _
    println(sq(10))
    println("Here's our conditional() function with a value parameter and two function parameters.")
    val a = conditional[String]("yo", _.size > 4, _.reverse)
    println(a)
  }  //Main
  //Here's our "conditional()" function with a value parameter and two function parameters.
  def conditional[A](x: A,p: A=> Boolean,f: A => A ):A=if (p(x)) f(x) else x




def square(x:Int)=x*x
   // def fzero[A](x: A)(f: A => Unit): A = { f(x); x }
  def fzero(x: String, f: String => Unit): String = { f(x); x }
  // simple Funtion to get max of 2 ints
  def max(num1:Int,num2:Int):Int=if(num1>num2) num1 else num2
  def pickOne(t: (Int, Int, Int), cmp: (Int, Int) => Int): Int = {
    cmp(t._1, cmp(t._2, t._3))
  }
  //return function
def rtnfunction(num:Int) = (x:Int)=> num*x
    //Write a function that takes a 3-sized tuple and returns a 6-sized tuple
  def stringify[A,B,C](t: (A,B,C)): (A,String,B,String,C,String) = {
    (t._1, t._1.toString, t._2, t._2.toString, t._3, t._3.toString)

  }
  // Handle tuple
 def offset(src: (Int, Int), dest: (Int, Int)): (Int, Int)= {
    (dest._1 - src._1, dest._2 - src._2)
  }
  //Tail Recusrion --Scala for the Intrigued
  def factorialImpl(n:Int,fact:BigInt) :BigInt ={
    if(n==1) fact
    else
      factorialImpl(n-1,n*fact)

  }
  //Reg recursion
  def factorial(n:Int) :Int ={
    if(n<2) n
    else
      n*factorial(n-1)

  }
  def calcTotal(l: List[Int]): Int = {
    var sum=0
    l.foreach{
     e=>sum+=e
    }

    return sum
  }

  def calcEvenTotal(l: List[Int]): Int = {
    var sum=0
    l.foreach{
      e=>if(e%2==1)sum+=e
    }
    return sum
  }

  var selector1: (Int) => Boolean = _

  def calcTotalSel(l: List[Int], selector: Int=>Boolean): Int = {
    var sum=0
    selector1 = selector
    println(selector1)
    l.foreach{
          println("value of e passed by caller client")
      e=>if(selector(e))sum+=e
    }
    return sum
  }

  }