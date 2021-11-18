package domain

import domain.DeckStatus.DeckStatus

object DeckStatus extends Enumeration {
  type DeckStatus = Value
  val Shot, Alive = Value
}

final case class Deck(coord: Coordinate, status: DeckStatus)
