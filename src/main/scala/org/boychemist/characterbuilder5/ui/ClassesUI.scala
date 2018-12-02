package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.dbInterface.DbClasses
import org.boychemist.characterbuilder5.ui.classes._
import scalafx.scene.control.TabPane.TabClosingPolicy
import scalafx.scene.control._
import slick.jdbc.JdbcBackend.Database

import scala.collection.immutable.HashMap

object ClassesUI {
  def classesTab(db: Database):Tab = {
    val classNames = DbClasses.getClassNames(db)

    val pane = new TabPane {
      tabClosingPolicy = TabClosingPolicy.Unavailable
    }
    val classIter = classNames.toIterator
    while (classIter.hasNext) {
      val className = classIter.next()
      val theTab = new Tab{text = className}
      val theGrid = getClassGrid(className, db)
      theGrid match {
        case Some(grid) => theTab.content = grid
        case None =>
      }
      pane += theTab
    }
    val hdTab = new Tab {
      text = "Classes"
      content = pane
    }
    hdTab
  }

  def getClassGrid(className: String, db: Database): Option[ScrollPane] = {
    val paneMap: HashMap[String, ScrollPane] = HashMap(
      "Barbarian" -> BarbarianDisplay.getBarbarianGrid(db),
      "Bard" -> BardDisplay.getBardGrid(db),
      "Cleric" -> ClericDisplay.getClericGrid(db),
      "Druid" -> DruidDisplay.getDruidGrid(db),
      "Fighter" -> FighterDisplay.getFighterGrid(db),
      "Monk" -> MonkDisplay.getMonkGrid(db),
      "Paladin" -> PaladinDisplay.getPaladinGrid(db),
      "Ranger" -> RangerDisplay.getRangerGrid(db),
      "Rogue" -> RogueDisplay.getRogueGrid(db)
    )


    val node = paneMap.get(className)
    node
  }

}
