package scala

import java.util.Random

class Day1 {
	val Position = """(\d+)\s*(\d+)""".r
	var currentPlayer = "X"
      
	def createBoard() :Board = {
		return new Board
	}
	
	def play() = {
		var board = createBoard()
		board.initializeBoard
		board.printBoard
			
		while(!board.gameOver) {
			if (currentPlayer == "X") {
				currentPlayer = "O" 
			} else { 
				currentPlayer = "X"
			}
			
			var (row, col) = readNextMove(board)
			
			board.placeCharacter(currentPlayer, row, col)
			board.checkMatch(currentPlayer)
			board.printBoard
		}
	}
	
	def readNextMove(board: Board): (Int, Int) = {
        var validMove = false
        var col = -1
        var row = -1
        
        while(!validMove) {
            var input = ""
            try {
                print("Enter cell position: (example: 01): ")
                input = readLine()
                val Position(columnNumber, rowNumber) = input
                row = rowNumber.toInt
                col = columnNumber.toInt
            } catch {
                case e => { 
                	println(input + " is not a valid input!") 
                }
            }

            validMove = board.validateMove(row, col)
            if(!validMove) {
                println("Can't move there, try again!\n")
            }
        }

        return (row, col)
    }
}