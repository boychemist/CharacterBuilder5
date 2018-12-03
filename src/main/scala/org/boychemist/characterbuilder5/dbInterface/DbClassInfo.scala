package org.boychemist.characterbuilder5.dbInterface


import java.time.Duration

import Tables._
import slick.jdbc.H2Profile.api._
import slick.jdbc.JdbcBackend.Database

import scala.collection.mutable.ListBuffer
import scala.concurrent.Await
import scala.concurrent.duration._

case class SpecializationInstanceDescription(level: Int, name: String, descrition: String)

/**
  * Provide access to the classes in the database
  */
object DbClassInfo {

  private lazy val allClasses = TableQuery[Classes]
  private lazy val allSpecializations = TableQuery[Specializations]
  private lazy val allSpecFeatures = TableQuery[SpecFeatures]

  private def exec[T](db: Database, action: DBIO[T]): T = Await.result(db.run(action), 2.seconds)

  def getClassNames (db: Database): Seq[String] = {
    val names = allClasses.map(_.name)
    exec(db, names.result)
  }

  def getSpecializationNamesByClassName(db: Database, className: String): Seq[String] = {
    val getClassId = allClasses.filter(_.name === className).map(_.classId)
    val retClassId = exec(db, getClassId.result)

    val getSpecNames = allSpecializations.filter(_.classId === retClassId.head).map(_.name)
    exec(db, getSpecNames.result)
  }

  def getSpecializationDataByName(db: Database, specName: String): Seq[(Int, String)] = {
    val specDescription = allSpecializations.filter(_.name === specName).map(s => (s.specId, s.description))
    exec(db, specDescription.result)
  }

  def getSpecilalizationFeaturesBySpecID(db: Database, specId: Int): List[SpecializationInstanceDescription] = {
    val specFeatures = allSpecFeatures.filter(_.specId === specId).sortBy(_.level).map(s => (s.level, s.name, s.description))
    val tuples =exec(db, specFeatures.result)
    val features = new ListBuffer[SpecializationInstanceDescription]
    val iter = tuples.iterator
    while (iter.hasNext) {
      val aTuple = iter.next()
      features += new SpecializationInstanceDescription(aTuple._1, aTuple._2, aTuple._3)
    }
    features.toList
  }
}
