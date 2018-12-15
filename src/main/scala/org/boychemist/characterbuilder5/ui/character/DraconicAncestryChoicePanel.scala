package org.boychemist.characterbuilder5.ui.character

import org.boychemist.characterbuilder5.Dnd5Character
import scalafx.scene.control._
import scalafx.scene.layout.{GridPane, VBox}
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.geometry.Pos
import scalafx.scene.text.{Font, FontWeight}
import scalafx.Includes.handle


object DraconicAncestryChoicePanel {
  def apply(): DraconicAncestryChoicePanel = new DraconicAncestryChoicePanel()
}

class DraconicAncestryChoicePanel {
  def getDraconicAncestryChoicePanel: ScrollPane = {

    val titleText = new Label("Select a Dragon Type as Your Ancestor") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    val titleBox = new VBox {
      alignment = Pos.Center
      children = List(titleText)
    }

    val rbGroup = new ToggleGroup  // group for the radio buttons
    val theGrid = new GridPane {
      style = "-fx-background-color: cyan"
      maxWidth = 300
      prefWidth = 200
      maxHeight = 700
    }
    var rowNum = 0

    theGrid.add(new Separator(), 0, rowNum, 3, 1)
    rowNum += 1
    theGrid.addRow(rowNum, enhancedLabel("Dragon"), enhancedLabel("Damage Type"), enhancedLabel("Breath Weapon"))
    rowNum += 1
    theGrid.add(new Separator(), 0, rowNum, 3, 1)
    rowNum += 1

    val ancestorIter = Dnd5Character.draconicAncestryMap.keysIterator
    while (ancestorIter.hasNext) {
      val dragon = ancestorIter.next()
      val (dType, weapon) = Dnd5Character.draconicAncestryMap(dragon)
      val rb = new RadioButton(dragon){
        toggleGroup = rbGroup
      }
      theGrid.addRow(rowNum, rb, new Label(dType), new Label(weapon))
      rowNum += 1
      theGrid.add(new Separator(), 0, rowNum, 3, 1)
      rowNum += 1
    }

    val saveButton = new Button("Save") {
      onAction = handle({
        if (rbGroup.selectedToggle.isNotNull.getValue) {
          this.disable = true
          val radioButton = rbGroup.selectedToggle.value.asInstanceOf[javafx.scene.control.RadioButton]
          Dnd5Character.getWorkingCharacter.draconicAncestry = radioButton.getText
          NewCharacterUI.choiceMade = true
        }
      })
    }

    new ScrollPane {
      style = "-fx-background-color: cyan"
      content = new VBox {
        style = "-fx-background-color: cyan"
        spacing = 5
        children = List(titleBox, theGrid, saveButton)
      }
    }
  }
}
