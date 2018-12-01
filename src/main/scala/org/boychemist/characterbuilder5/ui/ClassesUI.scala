package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.dbInterface.DbClasses
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
        case None => val a = 0 // effectively a no-op
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
      "Bard" -> BardDisplay.getBardGrid(db)
    )


    val node = paneMap.get(className)
    node
  }

}
