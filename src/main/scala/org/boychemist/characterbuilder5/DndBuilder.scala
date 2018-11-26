package org.boychemist.characterbuilder5

import slick.jdbc.H2Profile.api._
import org.boychemist.characterbuilder5.db.Tables._

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global

class RaceFromDb(id: Int, rname: String) {
  val raceId = id
  val name = rname
}
object RaceFromDb {
  var allLines = new ListBuffer[RaceFromDb]

  def addRace(id: Int, name: String) = {
    allLines += new RaceFromDb(id, name)
  }

  def getAllRaces: Seq[RaceFromDb] = allLines.toList
}

object DndBuilder {

}
