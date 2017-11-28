//package  main.scala
class Rational(n:Int,d:Int) {
  require(d!=0)

private val g = gcd(n.abs,d.abs)
  val num = n/g;
  val denom =d/g
  override def toString=n+"/"+d
def this(n:Int) =this(n,1)              // Aux Construtor
   def Add(x:Rational) : Rational ={
    new Rational(
      num * x.denom + x.num * denom,
      denom*x.denom
    )
  }
def gcd(a:Int,b:Int): Int ={
    if(b==0) a else gcd(b,a%b)
  }
  def testInt(s:String) = s forall(Character.isDigit)

}





