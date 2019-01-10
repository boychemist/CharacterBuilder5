package org.boychemist.characterbuilder5.dbInterface

import Tables.{Tools, ToolsRow}
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.duration._

object DbToolsInfo {

  private def exec[T](action: DBIO[T]): T =
    Await.result(CharacterDatabaseConnection.db.run(action), 2.seconds)

  private lazy val allTools = TableQuery[Tools]

  def getArtisanToolNames: Seq[String] = {
    val artisanTools =
      allTools.filter(_.`type` === "Artisan's tools").map(_.name)
    exec(artisanTools.result)
  }

  def getInstrumentNames: Seq[String] = {
    val artisanTools =
      allTools.filter(_.`type` === "Musical instrument").map(_.name)
    exec(artisanTools.result)
  }

  def getGamingSetNames: Seq[String] = {
    val artisanTools = allTools.filter(_.`type` === "Gaming set").map(_.name)
    exec(artisanTools.result)
  }

  def getToolInfoByName(toolName: String): ToolsRow = {
    val aTool = allTools.filter(_.name === toolName)
    exec(allTools.result).head
  }
}
