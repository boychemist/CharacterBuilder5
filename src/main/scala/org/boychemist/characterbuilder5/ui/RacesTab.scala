package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.dbInterface.DbRaces
import org.boychemist.characterbuilder5.dbInterface.RaceFromDb
import org.boychemist.characterbuilder5.races._
import org.boychemist.characterbuilder5.ui.races.{Dwarf, GeneralRace}
import scalafx.scene.control.TabPane.TabClosingPolicy
import scalafx.scene.control._
import slick.jdbc.JdbcBackend.Database

class RacesTab(db: Database) {

  def racesTab():Tab = {
    val racesList: Seq[RaceFromDb] = DbRaces.getRacesFromDb(db)

    val pane = new TabPane {
      tabClosingPolicy = TabClosingPolicy.Unavailable
    }
    pane += Dwarf.dwarfTab(Dnd5HillDwarf)
    pane += Dwarf.dwarfTab(Dnd5MountainDwarf)
    pane += GeneralRace.raceTab(Dnd5HighElf)
    pane += GeneralRace.raceTab(Dnd5WoodElf)
    pane += GeneralRace.raceTab(Dnd5Drow)
    pane += GeneralRace.raceTab(Dnd5LightfootHafling)
    pane += GeneralRace.raceTab(Dnd5StoutHafling)
    pane += GeneralRace.raceTab(Dnd5Human)
    pane += GeneralRace.raceTab(Dnd5Dragonborn)
    pane += GeneralRace.raceTab(Dnd5ForestGnome)
    pane += GeneralRace.raceTab(Dnd5RockGnome)
    pane += GeneralRace.raceTab(Dnd5HalfElf)
    pane += GeneralRace.raceTab(Dnd5HalfOrc)
    pane += GeneralRace.raceTab(Dnd5Tiefling)

    val raceTabs = new Tab{
      text = "Races"
      closable = false
    }
    raceTabs.content = pane
    raceTabs
  }
}
