package org.boychemist.characterbuilder5.ui.character

import org.boychemist.characterbuilder5.Dnd5Character
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.geometry.Pos
import scalafx.scene.Node
import scalafx.scene.control.{Label, ScrollPane, Separator}
import scalafx.scene.layout.{GridPane, HBox, VBox}

object CharacterPreviewPanel {
  def apply(theCharacter: Dnd5Character): CharacterPreviewPanel = new CharacterPreviewPanel(theCharacter)
}

class CharacterPreviewPanel(theCharacter: Dnd5Character) {

  private def valueHBox(label: String, value: Node): HBox = {
    new HBox {
      spacing = 10
      alignment  = Pos.Center
      children = List(enhancedLabel(label), value)
    }
  }

  def getCharacterPreviewPanel: ScrollPane = {

    val charGrid = new GridPane {
      style = "-fx-background-color: powderblue"
      maxWidth = 300
      prefWidth = 200
      maxHeight = 700
    }
    var rowNum = 0

    val name = easyTextField(theCharacter.name, 160)
    val hp = easyTextField(theCharacter.maximumHitPoints.toString)
    val alignment = easyTextField(theCharacter.alignment.toString, 100)
    val nameBox = valueHBox("Name", name)

    val hpBox = valueHBox("Hit Points", hp)

    val alignmentBox = valueHBox("Alignment", alignment)

    charGrid.addRow(rowNum, nameBox, hpBox, alignmentBox)
    rowNum += 1
    charGrid.add(new Separator(), 0, rowNum, 3, 1)
    rowNum += 1

    val race = easyTextField(theCharacter.race.toString, 70)
    val raceBox = valueHBox("Race", race)

    val className = if (theCharacter.characterClass.isEmpty) {
      "Not Set"
    } else {
      theCharacter.characterClass.head.dndClass.classID.toString
    }
    val charClass = easyTextField(className, 70)
    val charClassBox = valueHBox("Class", charClass)

      // TODO -- need to make specializations depend on database, not code.

    new ScrollPane {
      style = "-fx-background-color: powderblue"
      content = new VBox {
        style = "-fx-background-color: powderblue"
        spacing = 5
//        children = List(elfChoicesBox, saveButton)
      }
    }

  }
}