package org.boychemist.characterbuilder5.ui.character

import javafx.scene.input.TransferMode
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.scene.control.{ScrollPane, TextField}
import scalafx.scene.layout.GridPane

/**
  * Provides a ScrollPane that allows character ability scores to be set by
  * choosing values from a predetermined set of ability scores that may be
  * allocated as desired to the various character abilities.
  */
object AbilitiesFromListPanel {

  private def setDependentAbilityField(sourceField: TextField,
                                       dependentField: TextField): Unit = {
    sourceField.onDragDropped = { evt => {
      val db = evt.getDragboard
      var success = false
      if (db.hasString && evt.getGestureTarget == sourceField.delegate) {
        val dragged = new TextField(
          evt.getGestureSource.asInstanceOf[javafx.scene.control.TextField])
        sourceField.text = dragged.text.value
        dependentField.text = dragged.text.value
        success = true
      }
      sourceField.style = ""
      // let the source know whether the string was successfully transferred and used
      evt.setDropCompleted(success)
      evt.consume()
    }
    }

    sourceField.onDragDone = { evt => {
      // this is where the drag started, clear the color and the content
      if (evt.getGestureSource == sourceField.delegate) {
        if (evt.getTransferMode == TransferMode.MOVE) {
          sourceField.text = "" // only clear the text if transfer successful
          dependentField.text = "8" // default value of ability fields
          sourceField.style = ""
        }
        sourceField.style = ""
        evt.consume()
      }
    }
    }
  }

  def abilitiesFromListPane: ScrollPane = {

    val theGrid = new GridPane {
      maxWidth = 300
      prefWidth = 250
      maxHeight = 700
    }
    var rowNum = 0

    theGrid.add(enhancedLabel("Ability Scores"), 0, rowNum, 2, 1)
    theGrid.add(enhancedLabel("     "), 2, rowNum)
    theGrid.add(enhancedLabel("Scores to Allocate"), 3, rowNum)
    rowNum += 1

    val strength = dragToIfEmptyTextField()
    setDependentAbilityField(strength, NewCharacterUI.LeftSide.strength)
    theGrid.addRow(rowNum,
      enhancedLabel("Strength"),
      strength,
      enhancedLabel("     "),
      dragToIfEmptyTextField("15"))
    rowNum += 1

    val constitution = dragToIfEmptyTextField()
    setDependentAbilityField(constitution, NewCharacterUI.LeftSide.constitution)
    theGrid.addRow(rowNum,
      enhancedLabel("Constitution"),
      constitution,
      enhancedLabel("     "),
      dragToIfEmptyTextField("14"))
    rowNum += 1

    val dexterity = dragToIfEmptyTextField()
    setDependentAbilityField(dexterity, NewCharacterUI.LeftSide.dexterity)
    theGrid.addRow(rowNum,
      enhancedLabel("Dexterity"),
      dexterity,
      enhancedLabel("     "),
      dragToIfEmptyTextField("13"))
    rowNum += 1

    val intelligence = dragToIfEmptyTextField()
    setDependentAbilityField(intelligence, NewCharacterUI.LeftSide.intelligence)
    theGrid.addRow(rowNum,
      enhancedLabel("Intelligence"),
      intelligence,
      enhancedLabel("     "),
      dragToIfEmptyTextField("12"))
    rowNum += 1

    val wisdom = dragToIfEmptyTextField()
    setDependentAbilityField(wisdom, NewCharacterUI.LeftSide.wisdom)
    theGrid.addRow(rowNum,
      enhancedLabel("Wisdom"),
      wisdom,
      enhancedLabel("     "),
      dragToIfEmptyTextField("10"))
    rowNum += 1

    val charisma = dragToIfEmptyTextField()
    setDependentAbilityField(charisma, NewCharacterUI.LeftSide.charisma)
    theGrid.addRow(rowNum,
      enhancedLabel("Charisma"),
      charisma,
      enhancedLabel("     "),
      dragToIfEmptyTextField("8"))

    new ScrollPane {
      style = "-fx-background-color: cyan"
      content = theGrid
    }
  }
}
