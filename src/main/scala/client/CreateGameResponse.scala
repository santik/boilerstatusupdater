package client

import domain.{InitialGame}

final case class GameId(value: String) extends AnyVal
final case class PlayerId(value: String) extends AnyVal

final case class CreateGameResponse(gameId: GameId, playerId: PlayerId)

object CreateGameResponse {
  def of(game: InitialGame): CreateGameResponse = CreateGameResponse(
    GameId(game.id.value),
    PlayerId(game.player1.id.value))
}