package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.dbInterface.DbRaces
import org.boychemist.characterbuilder5.dbInterface.RaceFromDb
import org.boychemist.characterbuilder5.races.{Dnd5HillDwarf, Dnd5MountainDwarf}
import org.boychemist.characterbuilder5.ui.races.Dwarf
import scalafx.scene.control.TabPane.TabClosingPolicy
import scalafx.scene.control._
import scalafx.scene.Node
import scalafx.scene.layout.HBox
import slick.jdbc.JdbcBackend.Database

import scala.collection.mutable.ListBuffer

class RacesTab(db: Database) {
  private val racesList: Seq[RaceFromDb] = DbRaces.getRacesFromDb(db)

  val pane = new TabPane {
    tabClosingPolicy = TabClosingPolicy.Unavailable
  }
  pane += Dwarf.dwarfTab(Dnd5HillDwarf)
  pane += Dwarf.dwarfTab(Dnd5MountainDwarf)

  private val raceTab = new Tab{
    text = "Races"
    closable = false
  }
//  private val root = new Group{children = buttonBox}
  racesTab.content = pane

  def racesTab():Tab = raceTab
}
