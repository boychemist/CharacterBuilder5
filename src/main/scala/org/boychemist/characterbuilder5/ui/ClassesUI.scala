package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.dbInterface.DbClasses
import org.boychemist.characterbuilder5.races._
import scalafx.scene.control.TabPane.TabClosingPolicy
import scalafx.scene.control._
import slick.jdbc.JdbcBackend.Database

object ClassesUI {
  def classesTab(db: Database):Tab = {
    val classNames = DbClasses.getClassNames(db)

    val pane = new TabPane {
      tabClosingPolicy = TabClosingPolicy.Unavailable
    }
    val classIter = classNames.toIterator
    while (classIter.hasNext) {
      pane += new Tab{text = classIter.next()}
    }
    val hdTab = new Tab {
      text = "Classes"
      content = pane
    }
    hdTab
  }

}
