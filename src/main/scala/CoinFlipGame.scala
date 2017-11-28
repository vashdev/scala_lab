import scala.annotation.tailrec
import scala.collection.mutable
import scala.util.control.Breaks._
import scala.util.Random
// inspiration alvinalexander.com
object CoinFlipGame {
  def  main(args:Array[String])={
    var input = ""
    var count=0

    case class GameState (
                           numFlips: Int,
                           numCorrectGuesses: Int,
                           guessRt: Boolean
                         )
    val gameMap=collection.mutable.Map[Int, GameState]()

    def showPrompt: Unit = { print("\n(h)eads, (t)ails, or (q)uit: or ! for History") }
    def getUserInput = scala.io.StdIn.readLine().toString.trim.toUpperCase
    def printableFlipResult(flip: String) = flip match {
      case "H" => "Heads"
      case "T" => "Tails"
    }



    def printGameStateResult(printableResult: String, gameState: GameState): Unit = {
      print(s"Flip was $printableResult. ")
      printGameState(gameState)
    }
    def printGameState(gameState: GameState): Unit = {
      println(s"#Flips: ${gameState.numFlips}, #Correct: ${gameState.numCorrectGuesses}")
    }
    def printGameHistState(gameState: GameState): Unit = {
      println(s"Trail #: ${gameState.numFlips}, gussedRt ${gameState.guessRt}")
    }

    def gameHist(gmap:collection.mutable.Map[Int, GameState]): Unit ={
  println("***************Printing hist *****************")
      for(e<-gmap){
        println(e._1 +"< >"+ e._2.guessRt)
      }
  break()

}

    // returns "H" for heads, "T" for tails
    def tossCoin() = {
      val i = scala.util.Random.nextInt(2)
       println("Rand i=:;"+ i)
      i match {
        case 0 => "H"
        case 1 => "T"
      }
    }

    var newGameState=GameState(0,0,false)
    mainLoop(newGameState,1)
    @tailrec
    def mainLoop(gameState: GameState,count:Int) {

      // a) prompt the user for input
      // b) get the user's input
      println(" Enter choice")
      input=getUserInput
       // f) if the user didn't type 'q', loop again:
      if(input=="Q") {
         printGameStateResult("q",gameState)
        break()

      }
      // A Functional Game (With a Little Bit of State)
      // c) flip the coin
      if(input=="!"){
        println("Game Hist ..")
        gameHist(gameMap)
      }

     val toss= tossCoin
      // d) compare the flip result to the user's input
      println(" Guessed " + input + " Toss:" + toss)
      if(toss==input){
         newGameState= GameState(newGameState.numCorrectGuesses+1,newGameState.numFlips+1,true)
         gameMap+=(count->newGameState)
      } else {
         newGameState= GameState(newGameState.numCorrectGuesses,newGameState.numFlips+1,false)
         gameMap+=(count->newGameState)
      }
      // e) write the output

      mainLoop(newGameState,count+1)
    }


  }
}
