ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.4.0"

lazy val root = (project in file("."))
  .settings(
    name := "scala3-dependent-types-workshop"
  )

// Add ScalaCheck dependency
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.17.0" % Test

// Optional: If you want to use ScalaTest as well
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % Test
