/* http://twitter.github.io/scala_school/basics.html 
Practice */

val addOne = (x: Int) => x + 1
println(addOne(49))

 {
   x:Int=> {
     println("Hello Anonymous")
     println(x+1)
     x+1
   }
 }

// Partial application of paras
def adder(m: Int, n: Int) = m + n
val add2 = adder(2, _:Int) // Send an integer Later
add2(3)

//Curried functions Args should be as saperate parameters
def multiply(m: Int)(n: Int): Int = m * n
val timesTwo = multiply(2) _       // type inferred
timesTwo(3)
/*   this is not valid
def multiplyvariant(m: Int,n: Int): Int = m * n
val timesTwovariant = multiplyvariant(2) _
timesTwovariant(3)
*/
// to convert to Curry
//val addvariant=(adder_).curried  --Space ?
val   addvariant=(adder _).curried   // Parameters curries 
val addTwovariant = addvariant(2)   // cannot pass addvariant(2) _ like above Ridiculous
println(addTwovariant(10))
println(addvariant(8)(8))

def capitalizeAll(args: String*) = {
  args.map { arg =>
  c     arg.capitalize
  }
}
// Variable length arguments
val c=capitalizeAll("rarity", "applejack")
println(c)

// Classes

class Calculator {
  val brand: String = "HP"
  def add(m: Int, n: Int): Int = m + n 
}
val calc = new Calculator
println(calc +"   " + calc.add(10,10))

// constructors
class Calculator(brand: String) {
  /**
   * A constructor. - code outside of method definition (add)
   */
  val color: String = if (brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }

  // An instance method.
  def add(m: Int, n: Int): Int = m + n
  def getColor(): String = {
    println(" Calculator color: "+color)
    color
}

val calc = new Calculator("HP")
println(calc.color)


// http://twitter.github.io/scala_school/basics.html

class C {
        var acc = 0
        def minc = { acc += 1 }
        val finc = { () => acc += 1 }
      }
val c=new C
println(c.minc)

println(c.finc)

// Inheritance

class Calculator(nm:String) {
  println("Calculator Constructor")
  val brand: String = nm
  
        def add(m: Int, n: Int): Int = m + n
      }
class ScientificCalculator(brand: String) extends Calculator(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
  // override def  add(m: Int, n: Int): Int = m - n
}
val sc = new ScientificCalculator("sony")

println(sc.add(5,5))

// Abstract Classes
abstract class Shape {
        def getArea():Int    // subclass should define this
      }
class Circle(r: Int) extends Shape {
        def getArea():Int = { r * r * 3 }
      }
val circle = new Circle(2)

// Traits
trait Car {
  val brand: String
}

trait Shiny {
  val shineRefraction: Int
}
class BMW extends Car with Shiny {   // Multiple Traits "With Key word" like interfaces if used must be implementd or declare abstract
  val brand = "BMW"
  val shineRefraction = 12 // If undefined then BMW is abstract
}
/*
When do you want a Trait instead of an Abstract Class? If you want to define an interface-like type, you might find it difficult to choose between a trait or an abstract class. Either one lets you define a type with some behavior, asking extenders to define some other behavior. Some rules of thumb:

Favor using traits. It’s handy that a class can extend several traits; a class can extend only one class.
If you need a constructor parameter, use an abstract class. Abstract class constructors can take parameters; trait constructors can’t. For example, you can’t say trait t(i: Int) {}; the i parameter is illegal.
You are not the first person to ask this question. See fuller answers at stackoverflow:Scala traits vs abstract classes, Difference between Abstract Class and Trait, and Programming in Scala: To trait, or not to trait?
*/

//Types
//Earlier, you saw that we defined a function that took an Int which is a type of Number. Functions can also be generic and work on any type. When that occurs, you’ll see a type parameter introduced with the square bracket syntax

trait Cache[K, V] {
  def get(key: K): V
  def put(key: K, value: V)
  def delete(key: K)
}

