object CurryingExample {
  def  main(args:Array[String])={
    println("PlainSum ...")
   var z= plainSum(1,2)
    println(z)
    println("Curried  ...")
    val onep=curriedSum(1)_
    println(onep(2))
  }
  def plainSum(x: Int, y:Int)=x+y

  //Currying is the technique of transforming a function with multiple arguments into a function with just one argument.
  def curriedSum(x: Int)(y:Int)=x+y
}
