package org.boychemist.characterbuilder5.dbInterface


import Tables._
import slick.jdbc.H2Profile.api._

import scala.collection.mutable.ListBuffer
import scala.concurrent.Await
import scala.concurrent.duration._

case class SpecializationInstanceDescription(level: Int, name: String, description: String)

/**
  * Provide access to the classes in the database
  */
object DbClassInfo {

  private lazy val allClasses = TableQuery[Classes]
  private lazy val allSpecializations = TableQuery[Specializations]
  private lazy val allSpecFeatures = TableQuery[SpecFeatures]

  private def exec[T](action: DBIO[T]): T = Await.result(CharacterDatabaseConnection.db.run(action), 2.seconds)

  def getClassNames: Seq[String] = {
    val names = allClasses.map(_.name)
    exec(names.result)
  }

  def getClassIdByClassName(className: String): Int = {
    val getClassId = allClasses.filter(_.name === className).map(_.classId)
    val retClassId = exec(getClassId.result)
    retClassId.head
  }

  def getSpecializationNamesByClassName(className: String): Seq[String] = {
    val getClassId = allClasses.filter(_.name === className).map(_.classId)
    val retClassId = exec(getClassId.result)

    val getSpecNames = allSpecializations.filter(_.classId === retClassId.head).map(_.name)
    exec(getSpecNames.result)
  }

  def getSpecializationsDataByClassId(classId: Int): Seq[(Int, String, String, Boolean)] = {
    val getSpecData = allSpecializations.filter(_.classId === classId).map(s => (s.specId, s.name, s.description, s.providesSpells))
    exec(getSpecData.result)
  }

  def getSpecializationDataByName(specName: String): Seq[(Int, String, Boolean)] = {
    val specDescription = allSpecializations.filter(_.name === specName).map(s => (s.specId, s.description, s.providesSpells))
    exec(specDescription.result)
  }

  def getSpecializationDataById(id: Int): Seq[(String, String, Boolean)] = {
    val specDescription = allSpecializations.filter(_.specId === id).map(s => (s.name, s.description, s.providesSpells))
    exec(specDescription.result)
  }

  def getSpecilalizationFeaturesBySpecID(specId: Int): List[SpecializationInstanceDescription] = {
    val specFeatures = allSpecFeatures.filter(_.specId === specId).sortBy(_.level).map(s => (s.level, s.name, s.description))
    val tuples =exec(specFeatures.result)
    val features = new ListBuffer[SpecializationInstanceDescription]
    val iter = tuples.iterator
    while (iter.hasNext) {
      val aTuple = iter.next()
      features += SpecializationInstanceDescription(aTuple._1, aTuple._2, aTuple._3)
    }
    features.toList
  }
}
