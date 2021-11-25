package domain

sealed trait ShotStatus
final case object Success extends ShotStatus
final case object Failure extends ShotStatus

final case class Shot(location: Coordinate, status: ShotStatus)
