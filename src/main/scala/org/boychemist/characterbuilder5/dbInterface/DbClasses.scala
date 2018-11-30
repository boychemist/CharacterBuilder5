package org.boychemist.characterbuilder5.dbInterface


import Tables._
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.duration.Duration
import slick.jdbc.JdbcBackend.Database

/**
  * Provide access to the classes in the database
  */
object DbClasses {

  def exec[T](db: Database, action: DBIO[T]): T = Await.result(db.run(action), Duration.Inf)

  def getClassNames (db: Database): Seq[String] = {
    val allVals = TableQuery[Classes]
    val names = allVals.map(_.name)
    exec(db, names.result)
  }
}
