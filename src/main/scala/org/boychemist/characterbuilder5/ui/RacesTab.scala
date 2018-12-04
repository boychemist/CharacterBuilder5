package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.races._
import scalafx.scene.control.TabPane.TabClosingPolicy
import scalafx.scene.control._

object RacesTab {

  def racesTab(): Tab = {

    val pane = new TabPane {
      tabClosingPolicy = TabClosingPolicy.Unavailable
    }
    pane += GeneralRaceTab.raceTab(Dnd5HillDwarf)
    pane += GeneralRaceTab.raceTab(Dnd5MountainDwarf)
    pane += GeneralRaceTab.raceTab(Dnd5HighElf)
    pane += GeneralRaceTab.raceTab(Dnd5WoodElf)
    pane += GeneralRaceTab.raceTab(Dnd5Drow)
    pane += GeneralRaceTab.raceTab(Dnd5LightfootHafling)
    pane += GeneralRaceTab.raceTab(Dnd5StoutHafling)
    pane += GeneralRaceTab.raceTab(Dnd5Human)
    pane += GeneralRaceTab.raceTab(Dnd5Dragonborn)
    pane += GeneralRaceTab.raceTab(Dnd5ForestGnome)
    pane += GeneralRaceTab.raceTab(Dnd5RockGnome)
    pane += GeneralRaceTab.raceTab(Dnd5HalfElf)
    pane += GeneralRaceTab.raceTab(Dnd5HalfOrc)
    pane += GeneralRaceTab.raceTab(Dnd5Tiefling)

    val raceTabs = new Tab {
      text = "Races"
      closable = false
    }
    raceTabs.content = pane
    raceTabs
  }
}
