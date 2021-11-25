package domain

final case class ShotBoard(shots: Seq[Shot])

object ShotBoard {
  def generate: ShotBoard = ???
}