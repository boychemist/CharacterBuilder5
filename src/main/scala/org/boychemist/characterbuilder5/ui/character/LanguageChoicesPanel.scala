package org.boychemist.characterbuilder5.ui.character

import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import org.boychemist.characterbuilder5.{Dnd5Character, Dnd5LanguagesEnum}
import scalafx.geometry.Pos
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}
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
    langBuffer += enhancedLabel("Choose a language")
    val langIter = Dnd5LanguagesEnum.values.iterator
    while (langIter.hasNext) {
      val lang = langIter.next()
      // get the set of languages not already known (knowable) by the character
      if (!unselectableLanguages.contains(lang)) langBuffer += dragCopyFromField(lang.toString, 100)
    }

    val rightSide = new VBox {
      spacing = 10
      children = langBuffer.toList
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
