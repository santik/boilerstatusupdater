package repository

import domain.{Game, GameId}

class GameRepository {
  def getGame(gameId: GameId): Option[Game] = ???

  def save(game: Game): Game = ???
}

