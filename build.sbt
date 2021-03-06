import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "io.annotat",
      scalaVersion := "2.12.3",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "Crossref API Client",
    libraryDependencies ++= Seq(
      json4sNative,
      scalaJHttp,
      scalaTest % Test)
  )
