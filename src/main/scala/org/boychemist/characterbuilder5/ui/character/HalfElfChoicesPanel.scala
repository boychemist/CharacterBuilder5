package org.boychemist.characterbuilder5.ui.character

import org.boychemist.characterbuilder5.{Dnd5Character, Dnd5SkillsEnum}
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.geometry.Pos
import scalafx.scene.Node
import scalafx.scene.control.{Button, Label, ScrollPane, TextField}
import scalafx.scene.layout.{GridPane, HBox, VBox}
import scalafx.scene.text.{Font, FontWeight}
import scalafx.Includes.handle

import scala.collection.immutable.ListSet
import scala.collection.mutable.ListBuffer

/**
  * Provides for choosing 1 languagem two ability score adjustments, and 2 skills.
  * Uses language choice elements provided by LanguageChoicesPanel for the language
  * choice, adds ability to choose two abilities scores other than Charisma that
  * will be increased by 1, and add ability to choose 2 skills for proficiency.
  */
class HalfElfChoicesPanel {

  def getHalfElfChoices(workingCharacter: Dnd5Character): ScrollPane = {
    val langBox = LanguageChoicesPanel.getLanguageChoiceBox(workingCharacter)

    val skillBox = getSkillsBox

    val elfChoicesBox = new HBox {
      style = "-fx-background-color: cyan"
      spacing = 5
      alignment = Pos.Center
      children = List(langBox, skillBox)
    }

    val saveButton = new Button("Save") {
      onAction = handle({
        if (LanguageChoicesPanel.saveSelectedLanguage() &&
          skillChoice1.text.length().isNotEqualTo(0).getValue &&
          skillChoice2.text.length().isNotEqualTo(0).getValue) {
          saveSkills()
          this.disable = true
          NewCharacterUI.choiceMade = true
        }
      })
    }

    new ScrollPane {
      style = "-fx-background-color: cyan"
      content = new VBox {
        style = "-fx-background-color: cyan"
        spacing = 5
        children = List(elfChoicesBox, saveButton)
      }
    }
  }

  def getHalfElfAbilityChoices: ScrollPane = {
    val abilityBox = getAbilityBox

    val saveButton = new Button("Save") {
      onAction = handle({
        if (abilityChoice1.text.length().isNotEqualTo(0).getValue &&
          abilityChoice2.text.length().isNotEqualTo(0).getValue) {
          saveAbilities()
          saveSkills()
          this.disable = true
          NewCharacterUI.choiceMade = true
        }
      })
    }

    new ScrollPane {
      style = "-fx-background-color: cyan"
      content = new VBox {
        style = "-fx-background-color: cyan"
        spacing = 5
        children = List(abilityBox, saveButton)
      }
    }

  }

  private val abilityChoice1: TextField = dragToIfEmptyTextField("", 80)
  private val abilityChoice2: TextField = dragToIfEmptyTextField("", 80)

  private def getAbilityBox: VBox = {
    // build the ability scores choice box
    val abilityTitleText = new Label("Ability Scores To Adjust") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    val abilityTitleBox = new VBox {
      alignment = Pos.Center
      spacing = 10
      children =
        List(abilityTitleText, enhancedLabel("Drag Two Ability Scores"))
    }

    val abilityLeftSide = new VBox {
      alignment = Pos.Center
      spacing = 10
      children = List(enhancedLabel("Chosen Abilities"), abilityChoice1, abilityChoice2)
    }

    val strength = dragToIfEmptyTextField("Strength", 80)
    val dexterity = dragToIfEmptyTextField("Dexterity", 80)
    val constitution = dragToIfEmptyTextField("Constitution", 80)
    val intelligence = dragToIfEmptyTextField("Intelligence", 80)
    val wisdom = dragToIfEmptyTextField("Wisdom", 80)
    val abilityRightSide = new VBox {
      alignment = Pos.Center
      spacing = 10
      children = List(enhancedLabel("Available Abilities"),
        strength,
        dexterity,
        constitution,
        intelligence,
        wisdom)
    }

    val abilityHbox = new HBox {
      spacing = 10
      children = List(abilityLeftSide, abilityRightSide)
    }

    new VBox {
      spacing = 5
      alignment = Pos.Center
      children = List(abilityTitleBox, abilityHbox)
    }
  }

  private def saveAbilities():Unit = {
    val chosenAbilities = ListSet(abilityChoice1.text.value, abilityChoice2.text.value)
    if (chosenAbilities.contains("Strength"))
      NewCharacterUI.LeftSide.strength.text = (NewCharacterUI.LeftSide.strength.text.value.toInt + 1).toString
    if (chosenAbilities.contains("Dexterity"))
      NewCharacterUI.LeftSide.dexterity.text = (NewCharacterUI.LeftSide.dexterity.text.value.toInt +1).toString
    if (chosenAbilities.contains("Constitution"))
      NewCharacterUI.LeftSide.constitution.text = (NewCharacterUI.LeftSide.constitution.text.value.toInt +1).toString
    if (chosenAbilities.contains("Intelligence"))
      NewCharacterUI.LeftSide.intelligence.text = (NewCharacterUI.LeftSide.intelligence.text.value.toInt +1).toString
    if (chosenAbilities.contains("Wisdom"))
      NewCharacterUI.LeftSide.wisdom.text = (NewCharacterUI.LeftSide.wisdom.text.value.toInt + 1).toString
  }

  private val skillChoice1: TextField = dragToIfEmptyTextField("", 100)
  private val skillChoice2: TextField = dragToIfEmptyTextField("", 100)

  private def saveSkills(): Unit = {
    Dnd5Character.getWorkingCharacter.skillProficiencies ++ List(skillChoice1.text.value, skillChoice2.text.value)
  }

  private def getSkillsBox: VBox = {

    // build the skills proficiency choice box
    val skillsTitleText = new Label("Skills to Choose for Proficiency") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    val skillsTitleBox = new HBox {
      spacing = 10
      alignment = Pos.Center
      children = List(enhancedLabel("Drag Two Skills"))
    }

    val skillLeftBox = new VBox {
      spacing = 10
      alignment = Pos.Center
      children = List(enhancedLabel("Select 2 Skills"), skillChoice1, skillChoice2)
    }

    val rightSideElements = new ListBuffer[Node]
//    rightSideElements += enhancedLabel("Available Skills")
    val skillsIter = Dnd5SkillsEnum.values.iterator
    while (skillsIter.hasNext) {
      val skillName = skillsIter.next().toString
      rightSideElements += dragToIfEmptyTextField(skillName, 100)
    }
    val skillsArray = rightSideElements.toArray
    val skillsGrid = new GridPane {
      style = "-fx-background-color: linen"
      vgap = 2
      hgap = 2
    }
    val maxIter = skillsArray.length / 2
    for (i <- 0 until maxIter) {
      val idx = i * 2
      skillsGrid.addRow(i, skillsArray(idx), skillsArray(idx + 1))
    }
    if ((skillsArray.length % 2) == 1) {
      skillsGrid.addRow(maxIter, skillsArray.last)
    }
    val skillRightBox = new VBox {
      spacing = 10
      alignment = Pos.Center
//      children = rightSideElements.toList
      children = List(enhancedLabel("Available Skills"), skillsGrid)
    }

    val skillsBox = new HBox {
      spacing = 5
      alignment = Pos.Center
      children = List(skillLeftBox, skillRightBox)
    }

    new VBox{
      spacing = 5
      alignment = Pos.Center
      children = List(skillsTitleBox, skillsBox)
    }
  }
}
