package scala

import org.junit.Assert._
import org.junit.Test
import org.junit.Before

class Day2Test {
	var day2 :Day2 = _
	var listOfStrings :List[String] = _
  
	@Before def initialize() {
	  	day2 = new Day2
		listOfStrings = List("One", "Two", "Three", "Four") 
	}

  	@Test def verifyEasy() {
	  	assertEquals(15, day2.totalListSize(listOfStrings))
    }
}