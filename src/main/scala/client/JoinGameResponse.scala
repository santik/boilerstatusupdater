package client

import domain.{JoinedGame}

final case class JoinGameResponse(gameId: GameId, playerId: PlayerId)

object JoinGameResponse {
  def of(game: JoinedGame): JoinGameResponse = ???
}