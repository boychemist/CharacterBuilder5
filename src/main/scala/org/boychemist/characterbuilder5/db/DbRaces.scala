package org.boychemist.characterbuilder5.db

import Tables._
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.JdbcBackend.Database


class RaceFromDb(id: Int, rname: String) {
  val raceId: Int = id
  val name: String = rname
}
object RacesFromDb {
  val allLines = new ListBuffer[RaceFromDb]

  def addRace(id: Int, name: String): Unit = {
    allLines += new RaceFromDb(id, name)
  }

  def getAllRaces: Seq[RaceFromDb] = {
    val retList: List[RaceFromDb] = allLines.clone.toList
    allLines.clear()
    retList
  }
}

object DbRaces {
  def getRacesFromDb(db: Database) = {
    val classes = TableQuery[Classes]
    val resultFuture = db.run(classes.result).map(_.foreach {
      case r: Tables.ClassesRow => RacesFromDb.addRace(r.classId, r.name)
    })
    Await.result(resultFuture, Duration.Inf)
    RacesFromDb.getAllRaces
  }

}
