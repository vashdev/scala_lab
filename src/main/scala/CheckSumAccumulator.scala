import scala.collection.mutable

class CheckSumAccumulator {
  private var sum =0
  def add(b:Byte): Unit ={
    sum+=b
  }
  def checkSum(): Int ={
    return ~(sum & 0xFF)+1

  }
  // shorter versions since its single result expression
  def addshort(i :Int) =sum+=i
  def checksumshort():Int = ~(sum & 0xFF)+1
}
object CheckSumAccumulator {
private val cache=mutable.Map.empty[String,Int]

  //methos with side effects called procedures
def calculate (sampleS :String): Int ={
      if(cache.contains(sampleS)) cache(sampleS)
      else {
      val acc=new CheckSumAccumulator
        for(c <- sampleS)  //foreach c in sampleS
          acc.add(c.toByte)
        val cs =acc.checkSum()
       // cache+=(sampleS->cs)     //add to map
            cache.put(sampleS,cs)
        cs
    }
  }

}


