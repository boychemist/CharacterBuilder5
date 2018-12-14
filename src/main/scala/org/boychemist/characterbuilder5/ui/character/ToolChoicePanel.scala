package org.boychemist.characterbuilder5.ui.character

import org.boychemist.characterbuilder5.Dnd5Character
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils.{dragCopyFromField, dragCopyToField, enhancedLabel}
import scalafx.geometry.Pos
import scalafx.scene.Node
import scalafx.scene.control.{Button, Label, ScrollPane}
import scalafx.scene.layout.{BorderPane, HBox, VBox}
import scalafx.scene.text.{Font, FontWeight}
import scalafx.Includes.handle

import scala.collection.mutable.ListBuffer

object ToolChoicePanel {
  def toolChoicePanel(theCharacter: Dnd5Character):ScrollPane = {
    val raceInfo = Dnd5Character.getRaceDescription(theCharacter.race)
    val toolChoices = raceInfo.toolsForProficiency

    val windowTitle = new Label("Dwarf Tool Proficiency Chooser") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }

    val titleVbox = new VBox {
      alignment = Pos.Center
      spacing = 10.0
      children = List(windowTitle, enhancedLabel("Drag the Choice to the Left"))
    }

    // create the right side of the pane that holds the selection field
    val choiceTitle = enhancedLabel("Your Choice")
    val chosenTool = dragCopyToField("", 110)

    val selectionSide = new BorderPane{
      center = new VBox {
        alignment = Pos.Center
        spacing = 10.0
        children = List(choiceTitle, chosenTool)
      }
    }

    // create the left side of the pane that holds the choices to select
    val theChoices: ListBuffer[Node] = new ListBuffer()
    theChoices += enhancedLabel("The Choices")
    for(choice <- toolChoices) {
      theChoices += dragCopyFromField(choice, 110)
    }

    val selectFromSide = new VBox {
      alignment = Pos.Center
      spacing = 5
      children = theChoices.toList
    }

    val bothSides = new HBox {
      alignment = Pos.Center
      spacing = 10
      children = List(selectionSide, selectFromSide)
    }

    val saveButton = new Button("Save Choice"){
      onAction = handle(
        if (chosenTool.text.isNotEmpty.getValue) {
          // only save once (if there is something to save)
          theCharacter.toolProficiencies = theCharacter.toolProficiencies ++ List(choiceTitle.text.value)
          this.disable = true
          NewCharacterUI.choiceMade = true
        }
      )
    }

    new ScrollPane {
      style = "-fx-background-color: cyan"
      content = new VBox{
        spacing = 5
        children = List(titleVbox, bothSides, saveButton)
      }
    }
  }
}
