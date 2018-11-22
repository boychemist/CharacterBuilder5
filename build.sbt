ThisBuild / scalaVersion := "2.12.6"
ThisBuild / organization := "org.boychemist"
name := "Character Builder 5"
version := "1.0"
val javafxModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
val javafxVersion = "11.0.1"
val osName = "Windows" // System.getProperty("os.name")

lazy val hello = (project in file("."))
    .settings (
      name := "CharacterBuilder5",
      libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % Test,
      libraryDependencies += "com.h2database" % "h2" % "1.4.197",
      libraryDependencies += "org.scalafx" %% "scalafx" % "11-R16",
      libraryDependencies ++= javafxModules.map(m => "org.openjfx" % s"javafx-$m" % javafxVersion),
      libraryDependencies ++= Seq(
        "com.typesafe.slick" %% "slick" % "3.2.3",
        "org.slf4j" % "slf4j-nop" % "1.7.25",
        "com.typesafe.slick" %% "slick-hikaricp" % "3.2.3"
      ),
      
)