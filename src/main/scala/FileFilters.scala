class FileFilters(f:String) {
  val _file =f;

 // val filesHere=(new java.io.File("C:\\Users\\ashodha\\Documents\\GitHub\\Scala_lab\\.\\src\\main\\scala")).listFiles()
 val filesHere=(new java.io.File(f)).listFiles()

  def listofFiles()=filesHere

  def fileLines(file: java.io.File) :List[String]=scala.io.Source.fromFile(file).getLines().toList
/*
  // /traditional
def filesContain(query: String)=
  for(file<-filesHere;if file.getName.contains(query)) yield file
  def filesRegex(query: String)=
    for(file<-filesHere;if file.getName.matches(query)) yield file
  def filesEnding(query: String)=
    for(file<-filesHere;if file.getName.endsWith(query)) yield file
*/

  // Passing arnd Function value
  def filesMatching(query:String,matcher: (String,String)=> Boolean) =
  { for(file<-filesHere;if matcher(file.getName,query))yield file}

  //Matcher rewrite
  def filesMatcherContain(query: String)=filesMatching(query,_.contains(_))




  def grep(pattern:String)=
  //  for(file <- filesHere  ) println(file)
 // print("Start")
  for {
      file <- filesHere               //initialise
      if file.getName.endsWith((".scala")); // multiple if acts like condition for the "for" loop
      if file.isFile
       line <- fileLines(file)                                // nested loops within Condition of for stmnt
       word<-line.split(" ")
     if word.trim.matches(pattern)

    }println(file.getAbsolutePath+"::"+line)



}
