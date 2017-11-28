object WeatherParse {
  def  main(args:Array[String])= {
    val url= "http://api.openweathermap.org/data/2.5/forecast?mode=xml&lat=55&lon=0"
    val l: List[String] = io.Source.fromURL(url).getLines.toList
    println( l(0) )
  }
}
