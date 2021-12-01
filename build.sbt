name := "navybattle"

version := "0.1"
val http4sVersion = "0.21.22"
val catsVersion = "2.2.0"
val catsTaglessVersion = "0.11"
val catsEffectVersion = "2.2.0"
val circeVersion = "0.13.0"


scalaVersion := "2.13.7"
libraryDependencies ++= Seq(
  "eu.timepit" %% "refined" % "0.9.17",
  "org.http4s" %% "http4s-dsl" % http4sVersion,
  "org.http4s" %% "http4s-blaze-server" % http4sVersion,
  "org.http4s" %% "http4s-blaze-client" % http4sVersion,
  "org.http4s" %% "http4s-circe" % http4sVersion,
  "org.http4s" %% "http4s-jdk-http-client" % "0.3.6",
  "org.http4s" %% "rho-swagger" % "0.21.0",
  "org.typelevel" %% "cats-core" % catsVersion,
  "org.typelevel" %% "cats-effect" % catsEffectVersion,
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-generic-extras" % circeVersion,
  "io.circe" %% "circe-optics" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "org.http4s" %% "http4s-circe" % http4sVersion,

)