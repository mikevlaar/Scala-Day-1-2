package scala

object Application {
	def main(args: Array[String]) {
      	val day1 = new Day1
      	day1.play
		
		val day2 = new Day2
		
		//Use foldLeft to compute the total size of a list of strings.
		val listOfStrings = List("One", "Two", "Three", "Four") 
		println("Amount of characters = " + day2.totalListSize(listOfStrings))
		
		var evilSentence = "What the Shoot! That Darn."
		day2.readWordsFromFile("res/censorWords.txt")
		println(day2.censor(evilSentence))
    }
}