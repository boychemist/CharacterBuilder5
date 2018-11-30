package org.boychemist.characterbuilder5.dbInterface


import Tables._
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import slick.jdbc.JdbcBackend.Database

import scala.collection.mutable.ListBuffer

/**
  * Provide access to the classes in the database
  */
object DbClasses {

  private val allClasses = TableQuery[Classes]
  private val allSpecializations = TableQuery[Specializations]

  def exec[T](db: Database, action: DBIO[T]): T = Await.result(db.run(action), Duration.Inf)

  def getClassNames (db: Database): Seq[String] = {
//    val allVals = TableQuery[Classes]
    val names = allClasses.map(_.name)
    exec(db, names.result)
  }

  def getSpecializationNamesByClassName(db: Database, className: String): Seq[String] = {
    val getClassId = allClasses.filter(_.name === className).map(_.classId)
    val retClassId = exec(db, getClassId.result)

    val getSpecNames = allSpecializations.filter(_.classId === retClassId(0)).map(_.name)
    exec(db, getSpecNames.result)
  }
}
