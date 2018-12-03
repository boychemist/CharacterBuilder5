package org.boychemist.characterbuilder5.ui

import scalafx.scene.control.{Label, TextArea, TextField}
import scalafx.scene.layout.{ColumnConstraints, GridPane, VBox}
import scalafx.scene.text.{Font, FontWeight}

object CharacterBuilderUIutils {

  def enhancedLabel(text: String): Label = {
    val aLabel = new Label(text + " ") {
      font = Font.font("Sans Serif", FontWeight.Bold, 12)
    }
    aLabel
  }

  def wideGrid4(): GridPane = {
    val col1Constraints = new ColumnConstraints {
      percentWidth = 25
    }
    val col2Constraints = new ColumnConstraints {
      percentWidth = 25
    }
    val col3Constraints = new ColumnConstraints {
      percentWidth = 25
    }
    val col4Constraints = new ColumnConstraints {
      percentWidth = 25
    }
    val theGrid = new GridPane() {
      columnConstraints = List(col1Constraints, col2Constraints, col3Constraints, col4Constraints)
      minWidth = 700
      maxWidth = 1000
      minHeight = 650
    }
    theGrid.style = "-fx-background-color: skyblue"
    theGrid.vgap = 2

    theGrid
  }

  def wideTextArea(theText: String): TextArea = {
    val textArea = new TextArea() {
      text = theText
      editable = false
      maxWidth = 500
      maxHeight = 75
      minHeight = 50
      wrapText = true
    }
    textArea
  }

  def variableTextArea(theText: String, labelWidth: Int, labelHeight: Int): TextArea = {
    val textArea = new TextArea() {
      text = theText
      editable = false
      maxWidth = labelWidth
      maxHeight = labelHeight
      wrapText = true
    }
    textArea
  }

  def easyTextField(theText: String, fieldWidth: Int = 30): TextField = {

    val textField = new TextField {
      text = theText
      maxWidth = fieldWidth
      editable = false
    }

    textField
  }

  def add3ColTextArea(grid: GridPane, rowNum: Int, theText: String, startCol: Int = 1): Unit = {
    val area = wideTextArea(theText)
    grid.add(area, startCol, rowNum, 3, 1)
  }

  def levelAndName (level: Int, name: String): VBox = {
    val theBox = new VBox {
      spacing = 4
      children = List(
        enhancedLabel("Level " + level),
        enhancedLabel(name)
      )
    }
    theBox
  }

}
