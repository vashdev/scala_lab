import CheckSumAccumulator.calculate
object CheckSumAccumulatorApp {
  // traverse args
  def main(args:Array[String])={
    for(arg<-args) println(arg+ ":" +calculate(arg))
  }

}
