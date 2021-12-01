package client

import domain.ShipBoard

final case class JoinGameRequest(gameId: GameId, board: ShipBoard)