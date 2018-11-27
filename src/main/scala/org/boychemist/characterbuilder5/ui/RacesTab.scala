package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.dbInterface.DbRaces
import org.boychemist.characterbuilder5.dbInterface.RaceFromDb
import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, StringProperty}
import scalafx.collections.ObservableBuffer
import scalafx.geometry.{HPos, Insets, Orientation, VPos}
import scalafx.scene.control._
import scalafx.scene.Group
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color
import scalafx.scene.text.{Font, FontWeight, Text}
import scalafx.scene.{Cursor, Scene}
import slick.jdbc.JdbcBackend.Database
import scala.collection.mutable.ListBuffer

class RacesTab(db: Database) {
  private val racesList: Seq[RaceFromDb] = DbRaces.getRacesFromDb(db)

  private val raceButtons = new ListBuffer[Button]
  racesList.foreach(f => {
    raceButtons += new Button{text = f.name}
  })
  private val buttonBox = new HBox{children = raceButtons.toList}

  // todo switch buttons to tabs with the info for each class

  val racesTab = new Tab{
    text = "Races"
    closable = false
  }
  private val root = new Group{children = buttonBox}
  racesTab.content = root
}
