package org.boychemist.characterbuilder5.ui

import scalafx.scene.control._
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.control.TabPane.TabClosingPolicy
import slick.jdbc.JdbcBackend.Database

/*
  * Create a tab based Scene to put on the stage.
  */
class BuilderUI (db: Database, stage: Stage) {
  private val races = new RacesTab(db).racesTab

//  val tabPane = new TabPane {
//    minWidth = 400
//    tabs = Seq(
//      races,
//    )
    stage.scene = new Scene {
      root = new TabPane {
        tabClosingPolicy = TabClosingPolicy.Unavailable
        minWidth = 400
        maxHeight = 800
        tabs = Seq(races)
    }
  }
}
