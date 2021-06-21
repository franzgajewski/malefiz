/*
Class: BlockStrategy.scala

Beschreibung:
Interface unseres BlockStrategy-Patterns.

 */

package de.htwg.se.malefiz.util

import de.htwg.se.malefiz.model.gameboardComponent.GameboardInterface

trait BlockStrategy {
  def replaceBlock(spielbrett:GameboardInterface): GameboardInterface
}
