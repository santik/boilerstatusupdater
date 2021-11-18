package service

import domain.{Game, GameId, Player}
import repository.GameRepository

class GameService(gameRepository: GameRepository) {

  def createGame: Game = {
    gameRepository.save(Game.create())
  }

  def addSecondPlayer(game: Game): Game = {
    game.copy(player2 = Player.generate)
  }

  def joinGame(gameId: GameId): Game = {
    gameRepository.getGame(gameId).map {
      game => addSecondPlayer(game)
    }.getOrElse(throw RuntimeException)
  }
}
