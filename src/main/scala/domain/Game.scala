package domain

import domain.GameTurn.GameTurn

final case class GameId(value: String) extends AnyVal

object GameId {
  def generate: GameId = ???
}

object GameTurn extends Enumeration {
  type GameTurn = Value
  val Player1, Player2 = Value
}

final case class Game(
                 id: GameId,
                 player1: Option[Player],
                 player2: Option[Player],
                 player1ShipBoard: Option[ShipBoard],
                 player2ShipBoard: Option[ShipBoard],
                 player1ShotBoard: Option[ShotBoard],
                 player2ShotBoard: Option[ShotBoard],
                 turn: GameTurn
               ) {

}

object Game {
  def create(): Game = {
    new Game(
      GameId.generate,
      Player.generate,
      None,
      None,
      None,
      None,
      None,
      GameTurn.Player1
    )
  }
}
