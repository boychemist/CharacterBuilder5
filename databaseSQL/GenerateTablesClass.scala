/*
  Scala script to be run in the sbt console (scala repl) to generate the table definitions
  for slick.  Ensure the database is up to date with the table definitions before running this
  script.  Also ensure the database url points to the proper location of the database file.
*/
import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.H2Profile.api._
import slick.jdbc.H2Profile

val profile = "slick.jdbc.H2Profile"
val jdbcDriver = "org.h2.Driver"
val url = "jdbc:h2:~/character5"
val outputFolder = "./src/main/scala"
val pkg = "org.boychemist.characterbuilder5.dbInterface"
val user = "sa"
val password = ""

slick.codegen.SourceCodeGenerator.main(
  Array(profile, jdbcDriver, url, outputFolder, pkg, user, password)
)
