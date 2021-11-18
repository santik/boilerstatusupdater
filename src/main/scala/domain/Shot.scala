package domain

import domain.ShotStatus.ShotStatus

object ShotStatus extends Enumeration {
  type ShotStatus = Value
  val Success, Failure = Value
}

final case class Shot(location: Coordinate, status: ShotStatus)

object Shot {
  def generate: ShotBoard = ???
}
