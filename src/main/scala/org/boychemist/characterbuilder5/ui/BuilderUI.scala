package org.boychemist.characterbuilder5.ui

import scalafx.Includes._
import scalafx.beans.property.{DoubleProperty, StringProperty}
import scalafx.collections.ObservableBuffer
import scalafx.geometry.{HPos, Insets, Orientation, VPos}
import scalafx.scene.control._
import scalafx.scene.layout.{FlowPane, HBox}
import scalafx.scene.paint.Color
import scalafx.scene.text.{Font, FontWeight, Text}
import scalafx.stage.Stage
import scalafx.scene.{Cursor, Scene}
import slick.jdbc.JdbcBackend.Database

/*
  * Create a tab based Scene to put on the stage.
  */
class BuilderUI (db: Database, stage: Stage) {
  val races = new RacesTab(db).racesTab

//  val tabPane = new TabPane {
//    minWidth = 400
//    tabs = Seq(
//      races,
//    )
    stage.scene = new Scene {
      root = new TabPane {
        minWidth = 400
        tabs = Seq(races)
    }
  }
}
