package org.boychemist.characterbuilder5.ui.backgrounds

import org.boychemist.characterbuilder5.dbInterface.DbBackgroundInfo
import org.boychemist.characterbuilder5.dbInterface.Tables.BackgroundsRow
import org.boychemist.characterbuilder5.backgrounds.BackgroundImpl
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.geometry.Pos
import scalafx.scene.Node
import scalafx.scene.control.{ScrollPane, Tab, TabPane, TextArea}
import scalafx.scene.control.TabPane.TabClosingPolicy
import scalafx.scene.layout.{GridPane, HBox, VBox}

import scala.collection.mutable

object BackgroundsTab {
  def backgroundsTab(): Tab = {

    val pane = new TabPane {
      border = getBorder
      tabClosingPolicy = TabClosingPolicy.Unavailable
      maxWidth = 800
    }

    for (aBackground <- DbBackgroundInfo.getAllBackgrounds) {
      pane += createBackgroundTab(aBackground)
    }

    val backgroundTabs = new Tab {
      text = "Backgrounds"
      closable = false
    }
    backgroundTabs.content = pane
    backgroundTabs
  }

  private def createBackgroundTab(backgroundInfo: BackgroundsRow): Tab = {
    val hdTab = new Tab {
      text = backgroundInfo.name
    }
    hdTab.content = backgroundScrollPane(backgroundInfo.backgroundId)
    hdTab
  }

  /**
    * Create a scroll pane that wraps a VBox containing TextArea, HBox, and GridPane elements
    * to show the complete data for a single Background
    *
    * @param backgroundId of the background to be displayed
    * @return a properly filled ScrollPane
    */
  private def backgroundScrollPane(backgroundId: Int): ScrollPane = {
    val theBackground = new BackgroundImpl(backgroundId)
    val boxChildren = new mutable.ListBuffer[Node]

    // description text
    val descriptionArea = getFittedTextArea(theBackground.description, 650)
    descriptionArea.style = "-fx-background-color: skyblue"
    boxChildren += descriptionArea

    var rowIndex = 0
    val detailsGrid = new GridPane {
      style = "-fx-background-color: skyblue"
      vgap = 2
      hgap = 2
    }

    detailsGrid.addRow(rowIndex, enhancedLabel("Skill Proficiencies"),
      easyTextField(theBackground.skills.mkString(", "), 200))
    rowIndex += 1

    if (theBackground.numAdditionalLanguages > 0) {
      detailsGrid.addRow(rowIndex, enhancedLabel("Number of Additional Languages"),
        easyTextField(theBackground.numAdditionalLanguages.toString))
      rowIndex += 1
    }

    if (theBackground.toolOptions.nonEmpty) {
      val toolArea = getFittedTextArea(theBackground.toolOptions.mkString("\n"), 650)
      detailsGrid.addRow(rowIndex, enhancedLabel("Tools"), toolArea)
      rowIndex += 1
    }

    val equipArea = getFittedTextArea(theBackground.equipmentOptions.mkString("\n"), 650)
    detailsGrid.addRow(rowIndex, enhancedLabel("Equipment"), equipArea)
    boxChildren += detailsGrid

    // background specializations offered by some backgrounds
    if (theBackground.specializationName.length > 0) {
      val specGrid = new GridPane {
        style = "-fx-background-color: skyblue"
        vgap = 2
        hgap = 2
      }
      rowIndex = 0
      for (aSpec <- theBackground.specializationChoices) {
        val seq = enhancedLabel(aSpec._1.toString)
        val text = getFittedTextArea(aSpec._2, 650)
        specGrid.addRow(rowIndex, seq, text)
        rowIndex += 1
      }
      val specBox = new VBox {
        spacing = 2
        fillWidth = true
        style = "-fx-background-color: skyblue"
        children = List(enhancedLabel(theBackground.specializationName),
          getFittedTextArea(theBackground.specializationDescription, 650), specGrid)
      }
      boxChildren += specBox
    }

    // Background Feature
    val featureArea = getFittedTextArea(theBackground.feature.description, 650)
    val featureBox = new VBox {
      spacing = 2
      alignment = Pos.Center
      fillWidth = true
      children = List(enhancedLabel("Feature: " + theBackground.feature.name), featureArea)
    }

    boxChildren += featureBox
    if (theBackground.variantFeatures.nonEmpty) {
      for (variant <- theBackground.variantFeatures) {
        val variantArea = getFittedTextArea(variant.description, 650)
        boxChildren += new VBox {
          spacing = 2
          alignment = Pos.Center
          fillWidth = true
          children = List(enhancedLabel("Variant: " + variant.name), variantArea)
        }
      }
    }

    val personalityGrid = new GridPane {
      style = "-fx-background-color: skyblue"
      vgap = 2
      hgap = 2
    }
    personalityGrid.addRow(0, enhancedLabel("Personality Trait"))
    rowIndex = 1
    for (personalityRow <- theBackground.personalityTraits) {
      val traitArea = getFittedTextArea(personalityRow._2)
      val seq: String = personalityRow._1.toString
      personalityGrid.addRow(rowIndex, enhancedLabel(seq), traitArea)
      rowIndex += 1
    }

    val idealGrid = new GridPane {
      style = "-fx-background-color: skyblue"
      vgap = 2
      hgap = 2
    }
    idealGrid.addRow(0, enhancedLabel("Ideal"))
    rowIndex = 1
    for (idealRow <- theBackground.idealChoices) {
      val idealArea = getFittedTextArea(idealRow._2)
      idealGrid.addRow(rowIndex, enhancedLabel(idealRow._1.toString), idealArea)
      rowIndex += 1
    }
    boxChildren += new HBox {
      alignment = Pos.Center
      spacing = 2
      children = List(personalityGrid, idealGrid)
    }

    val bondGrid = new GridPane {
      style = "-fx-background-color: skyblue"
      vgap = 2
      hgap = 2
    }
    bondGrid.addRow(0, enhancedLabel("Bond"))
    rowIndex = 1
    for (bondRow <- theBackground.bondChoices) {
      val bondArea = getFittedTextArea(bondRow._2)
      bondGrid.addRow(rowIndex, enhancedLabel(bondRow._1.toString), bondArea)
      rowIndex += 1
    }

    val flawGrid = new GridPane {
      style = "-fx-background-color: skyblue"
      vgap = 2
      hgap = 2
    }
    flawGrid.addRow(0, enhancedLabel("Flaw"))
    rowIndex = 1
    for (flawRow <- theBackground.flawChoices) {
      val flawArea = getFittedTextArea(flawRow._2)
      flawGrid.addRow(rowIndex, enhancedLabel(flawRow._1.toString), flawArea)
      rowIndex += 1
    }

    boxChildren += new HBox {
      style = "-fx-background-color: skyblue"
      alignment = Pos.Center
      spacing = 2
      children = List(bondGrid, flawGrid)
    }

    val thePane = new ScrollPane {
      style = "-fx-background-color: skyblue"
      border = getBorder
      content = new VBox {
        spacing = 2
        children = boxChildren
        maxWidth = 700
      }
    }
    thePane
  }

}
