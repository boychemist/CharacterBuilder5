package org.boychemist.characterbuilder5.ui

import scalafx.scene.control._
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.control.TabPane.TabClosingPolicy
import slick.jdbc.JdbcBackend.Database

/*
 * Create a tab based Scene to put on the stage.
 */
class BuilderUI(db: Database, stage: Stage) {
  private val topPane = new TabPane {
    tabClosingPolicy = TabClosingPolicy.Unavailable
    maxWidth = 720
    minWidth = 700
    maxHeight = 700
  }
  topPane += RacesTab.racesTab()
  topPane += ClassesUI.classesTab(db)

  stage.scene = new Scene {
    root = topPane
  }
}
