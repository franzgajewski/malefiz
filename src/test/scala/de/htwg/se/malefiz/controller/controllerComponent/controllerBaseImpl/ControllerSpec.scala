package de.htwg.se.malefiz.controller.controllerComponent.controllerBaseImpl

import de.htwg.se.malefiz.controller.controllerComponent.GameStatus._
import de.htwg.se.malefiz.controller.controllerComponent.PlayerState1
import de.htwg.se.malefiz.model.cellComponent.PlayerCell
import de.htwg.se.malefiz.model.gameboardComponent.gameboardBaseImpl.{Gameboard, Settings}
import de.htwg.se.malefiz.util.Observer
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ControllerSpec extends AnyWordSpec with Matchers {
  "A Controller" when {
    "observed by an Observer with 4 Players" should {
      val set = Settings()
      val gameboard = new Gameboard(set.xDim, set.yDim)
      val controller = Controller(gameboard)
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated
        override def update: Boolean = {updated = true; updated}
      }
      //controller.add(observer)
      "from the offset" in {
        controller.gameStatus should be(IDLE)
        controller.playerStatus should be(PlayerState1)
        controller.moveCounter should be(0)
      }
      "change blockStrategy to replace" in {
        controller.setBlockStrategy("replace")
      }
      "change blockStrategy to remove" in {
        controller.setBlockStrategy("remove")
      }
     "when adding player" in {
       controller.addPlayerName("Eins")
       controller.game.getPlayerNumber() should be(1)
       //controller.gameStatus should be(IDLE)
     }
     "when adding another player" in {
       controller.addPlayerName("Zwei")
       controller.game.getPlayerNumber() should be(2)
       //controller.gameStatus should be(READY1)
     }
     "when adding 4 players" in {
       controller.addPlayerName("Drei")
       controller.addPlayerName("Vier")
       controller.game.getPlayerNumber() should be(4)
       //controller.gameStatus should be(READY2)
     }
     "when adding more than 4 players" in {
       controller.addPlayer()
       controller.game.getPlayerNumber() should be(4)
     }
      "when starting game" in {
        controller.startGame()
        controller.gameStatus should be(PLAYING)
        controller.playerStatus should be(PlayerState1)
      }
      "when rolling dice" in {
        controller.rollDice() should (be(1) or be(2) or be(3) or be(4) or be(5) or be(6))
      }
      "when as Player 1" in {
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("w", 1)
        controller.move("w", 1)
        controller.move("w", 1)
        controller.move("d", 1)
        controller.move("undo", 1)
        controller.move("redo", 1)
        controller.move("undo", 1)
        controller.move("a", 1)
        controller.move("a", 1)
        controller.move("w", 1)
        controller.move("w", 1)
      }
      "when as Player 2" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("w", 1)
        controller.move("d", 1)
        controller.move("undo", 1)
        controller.move("redo", 1)
        controller.move("undo", 1)
        controller.move("a", 1)
        controller.move("a", 1)
        controller.move("w", 1)
        controller.move("w", 1)
      }
      "when as Player 3" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("w", 1)
        controller.move("d", 1)
        controller.move("undo", 1)
        controller.move("redo", 1)
        controller.move("undo", 1)
        controller.move("a", 1)
        controller.move("a", 1)
        controller.move("w", 1)
        controller.move("w", 1)
      }
      "when as Player 4" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("w", 1)
        controller.move("d", 1)
        controller.move("undo", 1)
        controller.move("redo", 1)
        controller.move("undo", 1)
        controller.move("a", 1)
        controller.move("a", 1)
        controller.move("w", 1)
        controller.move("w", 1)
      }
      "when as Player 1 2nd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("s", 1)
        controller.move("skip", 1)
      }
      "when as Player 2 2nd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("s", 1)
        controller.move("skip", 1)
      }
      "when as Player 3 2nd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("s", 1)
        controller.move("skip", 1)
      }
      "when as Player 4 2nd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("s", 1)
        controller.move("skip", 1)
      }
      "when as Player 1 3rd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 6
        controller.move("s", 1)
        controller.move("d", 1)
        controller.move("d", 1)
        controller.move("d", 1)
        controller.move("d", 1)
        controller.move("w", 1)
      }
      "when as Player 2 3rd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 6
        controller.gameboard.movePlayer((2,9), PlayerCell(1))
        controller.move("w", 1)
      }
    }
    "observed by an Observer with 3 Players" should {
      val set = Settings()
      val gameboard = new Gameboard(set.xDim, set.yDim)
      val controller = Controller(gameboard)
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated
        override def update: Boolean = {updated = true; updated}
      }
      //controller.add(observer)
      "from the offset" in {
        controller.gameStatus should be(IDLE)
        controller.playerStatus should be(PlayerState1)
        controller.moveCounter should be(0)
      }
      "change blockStrategy to replace" in {
        controller.setBlockStrategy("replace")
      }
      "change blockStrategy to remove" in {
        controller.setBlockStrategy("remove")
      }
      "when adding player" in {
        controller.addPlayerName("Eins")
        controller.game.getPlayerNumber() should be(1)
        //controller.gameStatus should be(IDLE)
      }
      "when adding another player" in {
        controller.addPlayerName("Zwei")
        controller.game.getPlayerNumber() should be(2)
        //controller.gameStatus should be(READY1)
      }
      "when adding 3 players" in {
        controller.addPlayerName("Drei")
        controller.game.getPlayerNumber() should be(3)
        //controller.gameStatus should be(READY2)
      }
      "when starting game" in {
        controller.startGame()
        controller.gameStatus should be(PLAYING)
        controller.playerStatus should be(PlayerState1)
      }
      "when rolling dice" in {
        controller.rollDice() should (be(1) or be(2) or be(3) or be(4) or be(5) or be(6))
      }
      "when as Player 1" in {
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("w", 1)
        controller.move("w", 1)
        controller.move("w", 1)
        controller.move("d", 1)
        controller.move("undo", 1)
        controller.move("redo", 1)
        controller.move("undo", 1)
        controller.move("a", 1)
        controller.move("a", 1)
        controller.move("w", 1)
        controller.move("w", 1)
      }
      "when as Player 2" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("w", 1)
        controller.move("d", 1)
        controller.move("undo", 1)
        controller.move("redo", 1)
        controller.move("undo", 1)
        controller.move("a", 1)
        controller.move("a", 1)
        controller.move("w", 1)
        controller.move("w", 1)
      }
      "when as Player 3" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("w", 1)
        controller.move("d", 1)
        controller.move("undo", 1)
        controller.move("redo", 1)
        controller.move("undo", 1)
        controller.move("a", 1)
        controller.move("a", 1)
        controller.move("w", 1)
        controller.move("w", 1)
      }
      "when as Player 1 2nd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("s", 1)
        controller.move("skip", 1)
      }
      "when as Player 2 2nd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("s", 1)
        controller.move("skip", 1)
      }
      "when as Player 3 2nd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("s", 1)
        controller.move("skip", 1)
      }
      "when as Player 1 3rd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 6
        controller.move("s", 1)
        controller.move("d", 1)
        controller.move("d", 1)
        controller.move("d", 1)
        controller.move("d", 1)
        controller.move("w", 1)
      }
      "when as Player 2 3rd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 6
        controller.gameboard.movePlayer((2,9), PlayerCell(1))
        controller.move("w", 1)
      }
    }
    "observed by an Observer with 2 Players" should {
      val set = Settings()
      val gameboard = new Gameboard(set.xDim, set.yDim)
      val controller = Controller(gameboard)
      val observer = new Observer {
        var updated: Boolean = false
        def isUpdated: Boolean = updated
        override def update: Boolean = {updated = true; updated}
      }
      //controller.add(observer)
      "from the offset" in {
        controller.gameStatus should be(IDLE)
        controller.playerStatus should be(PlayerState1)
        controller.moveCounter should be(0)
      }
      "change blockStrategy to replace" in {
        controller.setBlockStrategy("replace")
      }
      "change blockStrategy to remove" in {
        controller.setBlockStrategy("remove")
      }
      "when adding player" in {
        controller.addPlayerName("Eins")
        controller.game.getPlayerNumber() should be(1)
        //controller.gameStatus should be(IDLE)
      }
      "when adding another player" in {
        controller.addPlayerName("Zwei")
        controller.game.getPlayerNumber() should be(2)
        //controller.gameStatus should be(READY1)
      }
      "when starting game" in {
        controller.startGame()
        controller.gameStatus should be(PLAYING)
        controller.playerStatus should be(PlayerState1)
      }
      "when rolling dice" in {
        controller.rollDice() should (be(1) or be(2) or be(3) or be(4) or be(5) or be(6))
      }
      "when as Player 1" in {
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("w", 1)
        controller.move("w", 1)
        controller.move("w", 1)
        controller.move("d", 1)
        controller.move("undo", 1)
        controller.move("redo", 1)
        controller.move("undo", 1)
        controller.move("a", 1)
        controller.move("a", 1)
        controller.move("w", 1)
        controller.move("w", 1)
      }
      "when as Player 2" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("w", 1)
        controller.move("d", 1)
        controller.move("undo", 1)
        controller.move("redo", 1)
        controller.move("undo", 1)
        controller.move("a", 1)
        controller.move("a", 1)
        controller.move("w", 1)
        controller.move("w", 1)
      }
      "when as Player 1 2nd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("s", 1)
        controller.move("skip", 1)
      }
      "when as Player 2 2nd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 5
        controller.move("s", 1)
        controller.move("skip", 1)
      }
      "when as Player 1 3rd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 6
        controller.move("s", 1)
        controller.move("d", 1)
        controller.move("d", 1)
        controller.move("d", 1)
        controller.move("d", 1)
        controller.move("w", 1)
      }
      "when as Player 2 3rd Move" in {
        controller.rollDice()
        controller.selectFigure(1)
        controller.moveCounter = 6
        controller.gameboard.movePlayer((2,9), PlayerCell(1))
        controller.move("w", 1)
      }
    }
  }
}