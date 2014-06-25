package scala

trait Censor {
	var curseWords = Map(
        "Shoot" -> "Pucky",
        "Darn" -> "Beans"
    )
    
    def setCurseWords(newCurseWords : Map[String, String]) = {
        curseWords = newCurseWords
    }
    
	def censor(unappropriateSentence : String) : String = {
		var newSentence = unappropriateSentence
	
	    for ((key, value) <- curseWords) {
	    	newSentence = newSentence.replaceAll(key, value)
	    }
	
	    return newSentence
    }
}