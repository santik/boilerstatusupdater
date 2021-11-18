package client

final case class GameId(value: String) extends AnyVal

final case class JoinGameRequest(gameId: GameId)