name := """play-with-ebean"""

lazy val root = (project in file(".")).
    aggregate(play, models)

lazy val play = (project in file("play")).
    dependsOn(models).
    settings(commonSettings: _*).
    enablePlugins(PlayJava).
    enablePlugins(PlayScala)

lazy val models = (project in file("ebean")).
    settings(commonSettings: _*)

lazy val commonSettings = Seq(
  version := "1.0",
  scalaVersion := "2.11.5"
)

libraryDependencies ++= Seq(
  "junit"             % "junit"           % "4.12"  % "test",
  "com.novocode"      % "junit-interface" % "0.11"  % "test"
)
