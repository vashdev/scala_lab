import scala.annotation.tailrec

object ScalaRecursn {
  //AlexAlvin Examples
  def main(args: Array[String]) = {
    val list = List(1, 2, 3, 4)  //1,2,3,4,NIL
   //add anotation ot check for tail recur
    // @tailrec
    def sumf(l:List[Int]):Int= l match {         //scala syntax for match
      case Nil=>0
      case x ::xs=> { println("Exec step in recurison") ; x+sumf(xs) }       //split list to head(x) and tail(xs) and tell what to od with it
    }

    val sum = sumf(list)
    println("Recursion sample \n"+sum)

    //Tail Recursion :Scala can optimize the resulting JVM bytecode so that the function
    //requires only one stack frame — as opposed to one stack frame for each

    def tailsumf(l2:List[Int]):Int={
      @tailrec
      def sum(l3:List[Int], accumulator:Int):Int=
        l3 match {
          case Nil=>accumulator
          case x::xs=>{ println("Exec Step at tial recursion");sum(xs,x+accumulator) }
        }
      sum(l2,0)
    }
    println("Tail Recursion Sample "+tailsumf(list))




  } //main



}  //Object
