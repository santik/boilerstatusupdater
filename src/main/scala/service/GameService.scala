package service

import client.CreateGameRequest
import domain.{Game, GameId, InitialGame, JoinedGame, Player, ShipBoard}
import repository.GameRepository

class GameService(gameRepository: GameRepository) {

  def createGame(createGameRequest: CreateGameRequest): InitialGame = {
    gameRepository.saveInitialGame(InitialGame.create(createGameRequest.board))
  }

  def addSecondPlayer(game: InitialGame, board: ShipBoard): JoinedGame = {
    gameRepository.saveJoinedGame(JoinedGame.from(game, board))
  }

  def joinGame(gameId: GameId, board: ShipBoard): JoinedGame = {
    gameRepository.getGame(gameId).map {
      case game: InitialGame => addSecondPlayer(game, board)
      case _ => throw new RuntimeException
    }.getOrElse(throw new RuntimeException)
  }
}
