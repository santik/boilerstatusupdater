package client

import cats.effect.{ExitCode, IO, IOApp}
import cats.syntax.all._
import org.http4s._
import org.http4s.dsl.io._
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder
import repository.GameRepository
import service.GameService

import scala.concurrent.ExecutionContext

object HttpServer extends IOApp {

  val gameController: GameController = new GameController(new GameService(new GameRepository))

  import io.circe.generic.auto._
  import org.http4s.circe.CirceEntityCodec._

  private val createRoutes = {

    HttpRoutes.of[IO] {
      case req @ POST -> Root / "create" =>
        req.as[CreateGameRequest].flatMap {
          request =>
            val response = gameController.create(request)
            Ok(response)
        }
    }
  }

  private val joinRoutes = {

    HttpRoutes.of[IO] {
      case req @ POST -> Root / "join" =>
        req.as[JoinGameRequest].flatMap {
          request =>
            val response = gameController.joinGame(request)
            Ok(response)
        }
    }
  }


  private val httpApp = Seq(
    createRoutes,
    joinRoutes,
  ).reduce(_ <+> _).orNotFound


  override def run(args: List[String]): IO[ExitCode] = BlazeServerBuilder[IO](ExecutionContext.global)
    .bindHttp(port = 9001, host = "localhost")
    .withHttpApp(httpApp)
    .serve
    .compile
    .drain
    .as(ExitCode.Success)
}