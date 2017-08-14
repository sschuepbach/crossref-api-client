import sbt._

object Dependencies {
  lazy val json4sNative: ModuleID = "org.json4s" %% "json4s-native" % "3.5.3"
  lazy val scalaJHttp: ModuleID =  "org.scalaj" %% "scalaj-http" % "2.3.0"
  lazy val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % "3.0.3"
}
