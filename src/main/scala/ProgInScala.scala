object ProgInScala   extends App {

println(" this obj uses App trait (extends app)  to avoid  main method")
  println( s"Supports bash like  String intropolation  ${6 * 7 } ")
 println(" object equality is ==  and not eq  != " )

  class Rational(a:Int, b:String)
  val x= new  Rational (1,"obj 1")
  val y= new  Rational (1,"obj 1")

  println(x==y)
  println(x.equals(y))
  println(s" ${x.hashCode()}  ${y.hashCode()}" )

  println(" comparing memory locations so not equal")
  var z= new  Rational (2,"obj 2")
  var z1= new  Rational (2,"obj 2")
  println(z==z1)
  println(z.equals(z1))
  println(s" ${z.hashCode()}  ${z1.hashCode()}" )

  case class caseRational(a:Int, b:String)
  var cz= new  caseRational (2,"obj 2")
  var cz1= new  caseRational (2,"obj 2")
  println(cz==cz1)
  println(cz.equals(cz1))
  println(s" ${cz.hashCode()}  ${cz1.hashCode()}" )

  println(" for -- returning new collection")
  val filesHere = (new java.io.File(".")).listFiles
  def scalaFiles =
    for {
      file <- filesHere
      if file.getName.endsWith(".scala")
    } yield file

  println(scalaFiles)


}
