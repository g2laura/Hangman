package main

/* Hangman with a predefined list of fruits
 * */

object MyProgram {
  val greeting: String = "Hello World"
  val fruits: List[String] = List("apples", "oranges", "pears", "mangoes", "banana")
  var randomFruit = ""
  
  def main(args: Array[String]): Unit = {
    println(greeting)
    var fruitToGuess: Array[String] = getFruitToGuess()
    for (ln <- io.Source.stdin.getLines) {
      if (ln.length() == 1) {
        checkLetter(ln, fruitToGuess) 
      } else {
        if (!isWinner(fruitToGuess)) println("Please insert a letter")
      }
    }
  }
  
  // Select a fruit from the predefined list of fruit to guess the name
  def getFruitToGuess(): Array[String] = {
    randomFruit = util.Random.shuffle(fruits).head
    var fruitToGuess: Array[String] = new Array(randomFruit.length)
    //Replace name with underscores
    for ((underscore, index) <- randomFruit.zipWithIndex) {
      fruitToGuess.update(index, "_")
    }
    println("What is the name of the fruit?: " + fruitToGuess.mkString(" "))
    return fruitToGuess
  }
  
  // Verify if the fruit name contains the letter selected by the user
  def checkLetter(letter: String, fruitToGuess: Array[String]) {
    if (randomFruit.contains(letter)) {
      // Replace the letter who matches
      for ((randomFruitChar, index) <- randomFruit.zipWithIndex) {
        if(randomFruitChar.toString() == letter) fruitToGuess.update(index, letter)
      }
      if (!isWinner(fruitToGuess)) println("Correct! " + fruitToGuess.mkString(" "))
    } else {
      println("Incorrect, try again: " + fruitToGuess.mkString(" "))
    }
  }
  
  // Verify if the user guess the fruit name
  def isWinner(fruitToGuess: Array[String]): Boolean = {
    if (fruitToGuess.mkString("").equals(randomFruit)) {
      println("Congratulations! You win! The fruit was: " + randomFruit)
      return true
    }
    return false
  }
}