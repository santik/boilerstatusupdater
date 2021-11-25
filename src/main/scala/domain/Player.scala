package domain

final case class PlayerId(value: String) extends AnyVal
final case class Player(id: PlayerId)

object Player {
  def generate: Player = ???
}
