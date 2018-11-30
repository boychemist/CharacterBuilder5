package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.dbInterface.DbClasses
import scalafx.scene.control.TabPane.TabClosingPolicy
import scalafx.scene.control._
import scalafx.scene.layout.GridPane
import scalafx.scene.Node
import slick.jdbc.JdbcBackend.Database

import scala.collection.mutable.{HashMap => mHashMap}

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
        case None => val a = 0
      }
      pane += theTab
    }
    val hdTab = new Tab {
      text = "Classes"
      content = pane
    }
    hdTab
  }

  def getClassGrid(className: String, db: Database): Option[Node] = {
    val paneMap = new mHashMap[String, Node]()

    paneMap("Barbarian") = BarbarianDisplay.getBarbarianGrid(db)


    val node = paneMap.get(className)
    node
  }

}
