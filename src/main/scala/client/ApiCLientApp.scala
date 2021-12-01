package client

import cats.effect.{Blocker, ExitCode, IO, IOApp}
import cats.syntax.all._
import domain.Ship.Carrier
import domain.{Alive, Coordinate, Deck, Ship, ShipBoard}
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder
import repository.GameRepository
import service.GameService
import org.http4s._
import org.http4s.client.blaze.BlazeClientBuilder
import org.http4s.client.dsl.io._
import org.http4s.dsl.io._
import org.http4s.headers._
import org.http4s.implicits._
import org.http4s.multipart.{Multipart, Part}
import org.http4s.server.blaze.BlazeServerBuilder

import scala.concurrent.ExecutionContext
import scala.util.Try
import scala.concurrent.ExecutionContext

object HttpClient extends IOApp {

  // Now let's build an HTTP client using Http4s. It will call endpoints, exposed by the HTTP server above.

  private val uri = uri"http://localhost:9001"

  private def printLine(string: String = ""): IO[Unit] = IO(println(string))

  def run(args: List[String]): IO[ExitCode] =
    BlazeClientBuilder[IO](ExecutionContext.global).resource
      .parZip(Blocker[IO]).use { case (client, blocker) =>
      for {
        _ <- printLine(string = "Executing request with JSON entities:")
        _ <- {
          import io.circe.generic.auto._
          import org.http4s.circe.CirceEntityCodec._

          val value = CreateGameRequest(board = ShipBoard(Seq(Carrier(Seq(Deck(Coordinate(1,1), Alive))))))
          client.expect[CreateGameResponse](Method.POST(value, uri / "create"))
            .flatMap(greeting => printLine(greeting.toString))
        }
        _ <- printLine()

      } yield ()
    }.as(ExitCode.Success)
}