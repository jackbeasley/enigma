lazy val root = (project in file(".")).
  	settings(
    	name := "enigma",
    	version := "0.1",
    	scalaVersion := "2.11.4",
    	libraryDependencies += "org.scalatest" % "scalatest_2.10" % "2.0" % "test"
  	)
