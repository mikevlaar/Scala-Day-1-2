package scala

import Array._

class Board {
	var gameOver = false
	var board = ofDim[String](3, 3)
	var possibleCharacters = List("X", "O", "-")
	
	def initializeBoard() = {
		for (i <- 0 until board.length) {
			for ( j <- 0 until board.length) {			
				board(i)(j) = possibleCharacters(2);
			}
		}
	}
	
	def placeCharacter(character :String, row :Int, col :Int) = {
		board(col)(row) = character
	}
	
	def checkMatch(currentPlayer :String) {
		if(checkHorizontal() || checkVertical() || checkDiagonal()) {
			println(currentPlayer+" Won the match!")
			gameOver = true
		}
		else if(checkForTie){
			println("Its a tie!")
			gameOver = true
		}
	}
	
	def checkHorizontal() : Boolean =  {
		if(board(0)(0) == board(0)(1) && board(0)(0) == board(0)(2)) {
			return checkWinner(board(0)(0))
		}
		else if(board(1)(0) == board(1)(1) && board(1)(0) == board(1)(2)) {
			return checkWinner(board(1)(0))
		}
		else if(board(2)(0) == board(2)(1) && board(2)(0) == board(2)(2)) {
			return checkWinner(board(2)(0))
		}
		else {
			return false
		}
	}
	
	def checkVertical() : Boolean = {
		if(board(0)(0) == board(1)(0) && board(0)(0) == board(2)(0)) {
			return checkWinner(board(0)(0))
		}
		if(board(0)(1) == board(1)(1) && board(0)(1) == board(2)(1)) {
			return checkWinner(board(0)(1))
		}
		if(board(0)(2) == board(1)(2) && board(0)(2) == board(2)(2)) {
			return checkWinner(board(0)(2))
		}
		else {
			return false
		}
	}
	
	def checkDiagonal() : Boolean = {
		if(board(0)(0) == board(1)(1) && board(0)(0) == board(2)(2)) {
			return checkWinner(board(0)(0))
		}
		if(board(0)(2) == board(1)(1) && board(0)(2) == board(2)(0)) {
			return checkWinner(board(0)(2))
		}
		else {
			return false
		}
	}
	
	def checkForTie() : Boolean = {
		for( i <- 0 until board.length) {
			for(j <- 0 until board.length) {
				if(board(i)(j) == "-") {
					return false
				}
			}
		}
		return true
	}
	
	def checkWinner(character: String) : Boolean = {
		return(character == "X" || character == "O")
	}
	
	def validateMove(row : Int, col : Int) : Boolean = {
		var rowCount = board.length;
		var columnCount = board.length;
        return row < rowCount && row >= 0 && col < columnCount && col >= 0 && board(col)(row) == possibleCharacters(2)
    }
	
	def printBoard() {
		for (i <- 0 until board.length) {
			for ( j <- 0 until board.length) {
				print(" " + board(i)(j));
			}
			println();
		}
	}
}