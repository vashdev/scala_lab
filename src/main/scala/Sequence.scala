//source alvinalexander   -creating custom forloop
//generic case class with varargs
// scala> val a = Sequence(1,2)
//a: Sequence[Int] = Sequence(WrappedArray(1, 2))
case class Sequence[A] (initElem:A*){

  // put all code you want to execute when creating object  outside of methods -it becomes part of constructors
  private val elems = scala.collection.mutable.ArrayBuffer[A]()
  // initialize
  elems++=initElem

  //for loop
  def foreach(block: A => Unit): Unit = {
    elems.foreach(block)
  }

  // map impl to do - for/yield,
  //:_* part of the code is
  //a way to adapt a collection to work with a varargs parameter
  def map[B](f: A => B): Sequence[B] = {
    val abMap = elems.map(f)
    new Sequence(abMap: _*)
  }
  def withfilter(p: A => Boolean): Sequence[A] = {
    val tmpArrayBuffer = elems.filter(p)
    Sequence(tmpArrayBuffer: _*)
  }
  //Flat map
/*
  def flatMap[B](f: A => Sequence[B]): Sequence[B] = {
    val mapRes: Sequence[Sequence[B]] = map(f) //map
    //flatten(mapRes) //flatten
  }
*/
}


