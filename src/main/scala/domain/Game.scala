package domain

final case class GameId(value: String) extends AnyVal

object GameId {
  def generate: GameId = ???
}

sealed trait GameTurn

final case object Player1 extends GameTurn
final case object Player2 extends GameTurn

sealed trait Game

final case class Initial(id: GameId, player1: Player, player1ShipBoard: ShipBoard) extends Game

object Initial {
  def create(shipBoard: ShipBoard): Initial = {
    new Initial(GameId.generate, Player.generate, shipBoard)
  }
}

final case class Joined(id: GameId, player1: Player, player2: Player, player1ShipBoard: ShipBoard, player2ShipBoard: ShipBoard) extends Game

object Joined {
  def from(initial: Initial, shipBoard: ShipBoard): Joined = {
    new Joined(id = initial.id, player1 = initial.player1, player2 = Player.generate, player1ShipBoard = initial.player1ShipBoard, player2ShipBoard = shipBoard)
  }
}

final case class Ready(
                        id: GameId,
                        player1: Player,
                        player2: Player,
                        player1ShipBoard: ShipBoard,
                        player2ShipBoard: ShipBoard,
                        player1ShotBoard: ShotBoard,
                        player2ShotBoard: ShotBoard,
                        turn: GameTurn
                      ) extends Game

object Ready {
  def from(ready: Ready): Ready = {
    new Ready(
      id = ready.id,
      player1 = ready.player1,
      player2 = ready.player2,
      player1ShipBoard = ready.player1ShipBoard,
      player2ShipBoard = ready.player2ShipBoard,
      player1ShotBoard = ShotBoard.generate,
      player2ShotBoard = ShotBoard.generate,
      turn = Player1
    )
  }
}
