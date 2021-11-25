package domain

sealed trait DeckStatus
final case object Shot extends DeckStatus
final case object Alive extends DeckStatus

final case class Deck(coord: Coordinate, status: DeckStatus)
