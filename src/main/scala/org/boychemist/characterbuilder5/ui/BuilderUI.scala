package org.boychemist.characterbuilder5.ui

import scalafx.scene.control._
import scalafx.stage.Stage
import scalafx.scene.Scene
import scalafx.scene.control.TabPane.TabClosingPolicy
import CharacterBuilderUIutils.getBorder
import org.boychemist.characterbuilder5.ui.backgrounds.BackgroundsTab

/*
 * Create a tab based Scene to put on the stage.
  * TODO -- Consider changing this to an Accordian with TitledPanes rather than tabs
 */
class BuilderUI(stage: Stage) {
  private val topPane = new TabPane {
    tabClosingPolicy = TabClosingPolicy.Unavailable
    border = getBorder
    maxWidth = 720
    minWidth = 700
    maxHeight = 600
  }
  topPane += RacesTab.racesTab()
  topPane += ClassesUI.classesTab()
  topPane += BackgroundsTab.backgroundsTab()
  topPane += character.NewCharacterUI.newCharacterTab()

  private val scn = new Scene {
    stylesheets = List(getClass.getResource("style.css").toExternalForm)
    root = topPane
  }
  stage.scene = scn

//  stage.scene = new Scene {
//    root = topPane
//  }
}
