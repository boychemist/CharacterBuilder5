package org.boychemist.characterbuilder5.dbInterface

import Tables._
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import slick.jdbc.JdbcBackend.Database

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
  def getRacesFromDb() = {
    val races = TableQuery[Races]
    val resultFuture = CharacterDatabaseConnection.db.run(races.result).map(_.foreach {
      case r: Tables.RacesRow => RacesFromDb.addRace(r.raceId, r.name)
    })
    Await.result(resultFuture, Duration.Inf)
    RacesFromDb.getAllRaces
  }

}
