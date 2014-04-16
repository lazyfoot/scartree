import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := "org.scartree",
    version := "0.1.0",
    scalaVersion := "2.10.3",
    resolvers += Resolver.sonatypeRepo("releases"),
    resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
    libraryDependencies += "org.specs2" %% "specs2" % "2.3.7" % "test",
    libraryDependencies += "org.scalaz" %% "scalaz-core" % "7.0.6",
    scalacOptions ++= Seq("-feature"),
    scalacOptions in Test ++= Seq("-Yrangepos")
  )
}

object Application extends Build {
  import BuildSettings._
  lazy val app = Project(id = "scartree", base = file("."), settings = buildSettings)
}
