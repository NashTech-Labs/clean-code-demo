package edu.knolx.conventions.names

class IntentionRevealing {

  object Constants {
    val O = Pos(0, 0) //origin //TODO: Feels like zero
    val MP = Pos(100, 100)  //Maximum Position of cell
  }

  case class Pos(x: Int, y: Int)

  //Todo: Intention revealing names 'Game' doesn't tells what this class is about
  case class Game(listOfCells: List[(Pos, Int)]) { //TODO: avoid disinformation not sure listOfCells will be a list always

    //Todo: Try to understand the following method
    def getFlaggedCells: List[(Pos, Int)] = {
      for(c <- listOfCells if c._2 == 1) yield c
    }
    //TODO: what does listOfCells denote??
    //TODO: what does c._2 denote??
    //TODO: why c._2 has to be 1??
    //TODO: What is the returned list??

    ???
  }

}

class IntentionRevealingRefactored{

  object ConstantsRefactored {
    /**ORIGIN is better than O which can be misunderstood as 0*/
    val ORIGIN = Position(0, 0)
    /**descriptive*/
    val MAX_POSITION = Position(100, 100)
    /**use this FLAG_VALUE rather than direct value*/
    val FLAG_VALUE = 1
  }

  /**
    * Explains for itself
    */
  case class Position(x: Int, y: Int)

  /**A meaningful structure instead of a (Pos, Int)*/
  case class Cell(position: Position, f: Int){
    def isFlagged: Boolean = f == ConstantsRefactored.FLAG_VALUE
  }

  /**Specifically is about MineSweeper game
    * gameBoard tells about what the collection on cells represent
    * */
  case class MineSweeper(gameBoard: List[Cell]) {

    /**isFlagged is a better notation to understand rather than comparing it to some integer*/
    def getFlaggedCells: List[Cell] = {
      for(cell <- gameBoard if cell.isFlagged) yield cell
    }

    ???

  }

}
