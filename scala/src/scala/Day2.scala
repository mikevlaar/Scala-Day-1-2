package scala

import scala.io.Source._

class Day2 extends Censor {
	def totalListSize(listOfStrings :List[String]) : Int = {
		val size = (0 /: listOfStrings) {
      		(size, string) => size + string.length 
      	}
		
		return size
	}
  
    def readWordsFromFile(file : String) {
		var source = fromFile(file) 
		var wordsFromFile = source.getLines().map(_.split(" ")).map(fields => fields(0) -> fields(1)).toMap
		source.close()
		
		setCurseWords(wordsFromFile)
	}
}