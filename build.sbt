ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.0"

lazy val root = (project in file("."))
  .settings(
    name := "scala3-dependent-types-polymorphic-functions-workshop"
  )

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.17.0" % Test
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % Test
