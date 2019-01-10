package org.boychemist.characterbuilder5.ui.character

import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import org.boychemist.characterbuilder5.{Dnd5Character, Dnd5LanguagesEnum}
import scalafx.geometry.Pos
import scalafx.scene.control._
import scalafx.scene.layout.{GridPane, HBox, VBox}
import scalafx.scene.text.{Font, FontWeight}
import scalafx.Includes.handle
import scalafx.scene.Node

import scala.collection.mutable.ListBuffer

/**
  * Provides a ScrollPane for use with Human and High Elf class customization
  * just the selection capability for use with Half-Elf class customization.
  */
object LanguageChoicesPanel {

  /**
    * Holds most recently selected language.  Public variable so that the basic
    * choice box can be combined with an ability chooser for Half-Elf setting.
    */
  val chosenLanguage:  TextField = dragCopyToField("",100)

  def saveSelectedLanguage(): Boolean = {
    var saved = false
    val chosen = chosenLanguage.text.value
     try {
       val working = Dnd5Character.getWorkingCharacter
      working.languages =  working.languages ++ List(Dnd5LanguagesEnum.withName(chosen))
      chosenLanguage.text = ""  // clear for next use
      chosenLanguage.disable = true
      saved = true
    } catch {
      case ex: java.util.NoSuchElementException => saved = false
    }

    saved
  }

  /**
    * Get a Node containing the available languages
    * @param workingCharacter to be updated using this chooser.  Not updated in
    *                         the HBox.
    * @return HBox containing the UI elements for choosing a language
    */
  def getLanguageChoiceBox(workingCharacter: Dnd5Character): VBox = {
    val raceInfo = Dnd5Character.getRaceDescription(workingCharacter.race)
    val unselectableLanguages: List[Dnd5LanguagesEnum.Value] = workingCharacter.languages ++ raceInfo.languages
    chosenLanguage.disable = false

    val windowTitle = new Label("New Language Chooser") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }

    val titleVbox = new VBox {
      alignment = Pos.Center
      spacing = 10.0
      children = List(windowTitle, enhancedLabel("Drag the Language You Want"))
    }

    val chosenBox = new VBox {
      alignment = Pos.Center
      spacing = 10.0
      children = List(enhancedLabel("New Language Choice"), chosenLanguage)
    }

    val langBuffer = new ListBuffer[Node]
    val langIter = Dnd5LanguagesEnum.values.iterator
    while (langIter.hasNext) {
      val lang = langIter.next()
      // get the set of languages not already known (knowable) by the character
      if (!unselectableLanguages.contains(lang)) langBuffer += dragCopyFromField(lang.toString, 100)
    }
    val langArray = langBuffer.toArray
    val rightSide = new GridPane  {
      style = "-fx-background-color: linen"
      vgap = 2
      hgap = 2
    }
    rightSide.addRow(0, enhancedLabel("Choose a language"))
    val maxIter = langArray.length/2
    // assumes at least 2 languages available
    for (i <- 0 until maxIter) {
      val idx = i * 2
      rightSide.addRow(i + 1, langArray(idx), langArray(idx + 1))
    }
    if ((langArray.length % 2) == 1) {
      rightSide.addRow(maxIter + 1, langArray.last)
    }


    val bothSides = new HBox {
      spacing = 10
      children = List(chosenBox, rightSide)
    }

    val theWholeBox =new VBox{
      spacing = 5
      children = List(titleVbox, bothSides)
    }
    theWholeBox
  }

  def get2ElementHbox(node1: Node, node2: Node, inWidth: Int = 220): HBox = {
    new HBox {
      maxWidth = inWidth
      children = List(node1, node2)
    }
  }

  /**
    * Provide scroll pane with Save button and the ability to select a language
    */
  def getLanguageChoicePane(workingCharacter: Dnd5Character): ScrollPane = {
    val newLanguageBox: VBox = getLanguageChoiceBox(workingCharacter)

    val saveButton = new Button("Save") {
      onAction = handle({
        val result = saveSelectedLanguage() // returns true if save successful, false otherwise
        this.disable = result
        NewCharacterUI.choiceMade = result
      })
    }

    new ScrollPane {
      style = "-fx-background-color: cyan"
      content = new VBox {
        spacing = 5
        children = List(newLanguageBox, saveButton)
      }
    }
  }
}
