import sbt._
import Keys._

object Build extends Build {

  lazy val project = Project("root", file(".")).settings(
    // basics
    name := "cake",
    organization := "org.adehaus",
    version := "1.0.0-SNAPSHOT",
    scalaVersion := "2.9.2",
    scalacOptions += "-deprecation",

    // dependencies
    libraryDependencies ++= Seq(
      "org.mockito" % "mockito-all" % "1.8.4",
      "org.scalatest" % "scalatest_2.9.0" % "1.9.1" % "test"
    ),

    resolvers ++= Seq(
      "sonatypeSnapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
      "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
    )
  )
}
