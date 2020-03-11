name := "cats2"

version := "0.1"

scalaVersion := "2.13.1"

scalacOptions += "-language:higherKinds"

libraryDependencies ++= Seq(
  "org.typelevel" %% "cats-core" % "2.0.0",
  "org.scalatest" %% "scalatest" % "3.1.0" % Test
)
