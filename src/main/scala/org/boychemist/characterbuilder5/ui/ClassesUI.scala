package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo
import org.boychemist.characterbuilder5.ui.classes._
import scalafx.scene.control.TabPane.TabClosingPolicy
import scalafx.scene.control._

import CharacterBuilderUIutils.getBorder

import scala.collection.immutable.HashMap

object ClassesUI {
  def classesTab(): Tab = {
    val classNames = DbClassInfo.getClassNames

    val pane = new TabPane {
      border = getBorder
      tabClosingPolicy = TabClosingPolicy.Unavailable
    }
    val classIter = classNames.toIterator
    while (classIter.hasNext) {
      val className = classIter.next()
      val theTab = new Tab { text = className }
      val theGrid = getClassGrid(className)
      theGrid match {
        case Some(grid) => theTab.content = grid
        case None       =>
      }
      pane += theTab
    }
    val hdTab = new Tab {
      text = "Classes"
      content = pane
    }
    hdTab
  }

  def getClassGrid(className: String): Option[ScrollPane] = {
    val paneMap: HashMap[String, ScrollPane] = HashMap(
      "Barbarian" -> BarbarianDisplay.getBarbarianGrid,
      "Bard" -> BardDisplay.getBardGrid,
      "Cleric" -> ClericDisplay.getClericGrid,
      "Druid" -> DruidDisplay.getDruidGrid,
      "Fighter" -> FighterDisplay.getFighterGrid,
      "Monk" -> MonkDisplay.getMonkGrid,
      "Paladin" -> PaladinDisplay.getPaladinGrid,
      "Ranger" -> RangerDisplay.getRangerGrid,
      "Rogue" -> RogueDisplay.getRogueGrid,
      "Sorcerer" -> SorcererDisplay.getSorcererGrid,
      "Warlock" -> WarlockDisplay.getWarlockGrid,
      "Wizard" -> WizardDisplay.getWizardGrid
    )

    val node = paneMap.get(className)
    node
  }

}
