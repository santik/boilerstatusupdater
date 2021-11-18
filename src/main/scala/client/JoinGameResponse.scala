package client

import domain.Game

final case class GameId(value: String) extends AnyVal
final case class PlayerId(value: String) extends AnyVal

final case class JoinGameResponse(gameId: GameId, playerId: PlayerId)

object JoinGameResponse {
  def of(game: Game): JoinGameResponse = ???
}