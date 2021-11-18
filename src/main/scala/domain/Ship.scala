package domain

sealed trait Ship
object Ship {
  final case class Carrier(decks: Seq[Deck]) extends Ship
  final case class BattleShip(decks: Seq[Deck]) extends Ship
  final case class Cruiser(decks: Seq[Deck]) extends Ship
  final case class Submarine(decks: Seq[Deck]) extends Ship
  final case class Destroyer(decks: Seq[Deck]) extends Ship
}

