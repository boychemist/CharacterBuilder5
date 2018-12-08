package org.boychemist.characterbuilder5.ui

import scalafx.scene.control._
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.control.TabPane.TabClosingPolicy

/*
 * Create a tab based Scene to put on the stage.
 */
class BuilderUI(stage: Stage) {
  private val topPane = new TabPane {
    tabClosingPolicy = TabClosingPolicy.Unavailable
    maxWidth = 720
    minWidth = 700
    maxHeight = 700
  }
  topPane += RacesTab.racesTab()
  topPane += ClassesUI.classesTab()
  topPane += character.NewCharacterUI.newCharacterTab()

  stage.scene = new Scene {
    root = topPane
  }
}
