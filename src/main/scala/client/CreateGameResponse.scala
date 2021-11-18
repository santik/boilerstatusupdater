package client

import domain.Game

final case class GameId(value: String) extends AnyVal
final case class PlayerId(value: String) extends AnyVal

final case class CreateGameResponse(gameId: GameId, playerId: PlayerId)

object CreateGameResponse {
  def of(game: Game): CreateGameResponse = CreateGameResponse(
    GameId(game.id.value),
    PlayerId(game.player1.getOrElse(throw RuntimeException).id.value))
}