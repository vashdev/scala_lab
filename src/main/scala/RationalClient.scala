// package main.scala

object RationalClient {
  def main(args:Array[String])={
//    for(arg<-args) println(arg+ ":" +Rational(arg))


 val r = new Rational(args(0).toInt,args(1).toInt)
println(r.gcd(args(0).toInt,args(1).toInt))
  }
}
