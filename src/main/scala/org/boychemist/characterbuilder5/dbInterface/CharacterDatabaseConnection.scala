package org.boychemist.characterbuilder5.dbInterface

import slick.jdbc.JdbcBackend.Database

object CharacterDatabaseConnection {
  private var connection: Database = _

  def connectToDB(url: String, user: String = "sa", keepAlive: Boolean = true, dbDriver: String = "org.h2.Driver" ): Unit = {
    connection = Database.forURL(url, user, keepAliveConnection = keepAlive, driver = dbDriver)
  }

  def db: Database = connection

  def close(): Unit = connection.close()
}
