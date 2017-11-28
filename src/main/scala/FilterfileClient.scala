// grep files matching word pattern
object FilterfileClient {

  def main(args:Array[String])={
      println(args(0) +"::"+ args(1))
    val f = new FileFilters(args(0))
   val names=f.listofFiles()
    //for(n<-names) println(n)
   // print(f.toPrint(args(1)))
//    val flist=f.listofFiles()
  // for(f<-flist)println(f)
    println(f.grep(args(1)))
  }
}
