package de.htwg.se.malefiz.model.gameboardComponent

import de.htwg.se.malefiz.model.cellComponent.Cell

case class lastSave(lastFullDice: Int, lastDirectionOpposite: String, lastCell: Cell) extends lastSaveInterface {
  def updateLastFullDice(newNum: Int): lastSave = copy(newNum, lastDirectionOpposite, lastCell)

  def updateLastDirection(newDic: String): lastSave = copy(lastFullDice, newDic, lastCell)

  def updatelastCell(newCel: Cell): lastSave = copy(lastFullDice, lastDirectionOpposite, newCel)
}