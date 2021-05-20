package de.htwg.se.malefiz.model

case class Cell(cellStatus: String = "  ") {
  def isWalkable: Boolean = (cellStatus != "  " && cellStatus != "T ")
  override def toString(): String = { cellStatus }
}