package specs

import org.junit.Assert
import org.junit.Test
import main.MyProgram

class MyProgramSpec {

  def settupFruit(fruitName: String): Array[String] = {
    MyProgram.randomFruit = fruitName
    var fruitToGuess: Array[String] = new Array(MyProgram.randomFruit.length)
    return fruitToGuess
  }
  
  @Test def verifyGreeting() {
    assert(MyProgram.greeting == "Hello World")
  }
 
  @Test def verifyFruitToGuessLength() {
    var fruitToGuess = MyProgram.getFruitToGuess()
    assert(MyProgram.randomFruit.length() == fruitToGuess.length)
  }
  
  @Test def verifyIfNameContainsLetter() {
    var fruitToGuess = settupFruit("apple")
    assert(MyProgram.checkLetter("a", fruitToGuess), true)
  }
  
  @Test def verifyIfNameDoesNotContainsLetter() {
    var fruitToGuess = settupFruit("apple")
    assert(MyProgram.checkLetter("x", fruitToGuess) == false)
  }
  
  @Test def verifyIfIsAWinner() {
    var fruitToGuess = settupFruit("apple")
    for ((letter, index) <- MyProgram.randomFruit.zipWithIndex) {
      fruitToGuess.update(index, letter.toString)
    }
    assert(MyProgram.isWinner(fruitToGuess), true)
  }
  
  @Test def verifyIfIsNotAWinner() {
    MyProgram.randomFruit = "apple"
    var fruitToGuess: Array[String] = new Array(MyProgram.randomFruit.length)
    assert(MyProgram.isWinner(fruitToGuess) == false)
  }
}