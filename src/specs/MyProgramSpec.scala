package specs

import org.junit.Assert
import org.junit.Test
import main.MyProgram

class MyProgramSpec {

  @Test def verifyGreeting() {
    assert(MyProgram.greeting == "Hello World")
  }
 
  @Test def verifyFruitLength() {
    var fruitToGuess = MyProgram.getFruitToGuess()
    assert(MyProgram.randomFruit.length() == fruitToGuess.length)
  }
  
  @Test def verifyIfNameContainsLetter() {
    MyProgram.randomFruit = "apple"
    var fruitToGuess: Array[String] = new Array(MyProgram.randomFruit.length)
    MyProgram.checkLetter("a", fruitToGuess)
  }
}