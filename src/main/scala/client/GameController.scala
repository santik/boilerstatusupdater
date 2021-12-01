package client

import service.GameService

class GameController(gameService: GameService) {

  def create(createGameRequest: CreateGameRequest): CreateGameResponse =
    CreateGameResponse.of(gameService.createGame(createGameRequest))

  def joinGame(joinGameRequest: JoinGameRequest): JoinGameResponse =
    JoinGameResponse.of(
      gameService.joinGame(domain.GameId(joinGameRequest.gameId.value), joinGameRequest.board)
    )
}
