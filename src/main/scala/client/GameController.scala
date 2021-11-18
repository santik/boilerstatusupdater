package client

import service.GameService

class GameController(gameService: GameService) {

  def create(): CreateGameResponse =
    CreateGameResponse.of(gameService.createGame)

  def joinGame(joinGameRequest: JoinGameRequest): JoinGameResponse =
    JoinGameResponse.of(
      gameService.joinGame(domain.GameId(joinGameRequest.gameId.value))
    )
}
