package repository

import domain.{Game, GameId, InitialGame, JoinedGame}

class GameRepository {
  def getGame(gameId: GameId): Option[Game] = ???
  def saveJoinedGame(game: JoinedGame): JoinedGame = ???
  def saveInitialGame(game: InitialGame): InitialGame = ???
}

