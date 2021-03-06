package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Fighter
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import org.boychemist.characterbuilder5.ui.FXUtils
import scalafx.Includes.handle
import scalafx.scene.control.{Button, Label, ScrollPane}
import scalafx.scene.layout.VBox
import scalafx.scene.text.{Font, FontWeight}

import scala.collection.mutable.ListBuffer

object FighterDisplay {
  def getFighterGrid: ScrollPane = {
    val fighterGrid = wideGrid4()
    fighterGrid.style = "-fx-background-color: skyblue"
    fighterGrid.vgap = 2
    var rowNum = 1

    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Fighter.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = getFittedTextArea(Dnd5Fighter.armorProficiencies.mkString("\n"), 150)
    fighterGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = getFittedTextArea(Dnd5Fighter.weaponProficiencies.mkString("\n"), 150)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = getFittedTextArea(Dnd5Fighter.savingThrowProficiencies.mkString("\n"), 150)
    fighterGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val numSkillChoicesLabel = enhancedLabel("Number of Skills to Choose")
    val numSkillChoices = easyTextField(Dnd5Fighter.numberOfSkills.toString)

    val skillChoicesLabel = enhancedLabel("Skill Choices")
    val skillChoices = getFittedTextArea(Dnd5Fighter.skillChoices.mkString("\n"), 150)
    fighterGrid.addRow(rowNum, numSkillChoicesLabel, numSkillChoices, skillChoicesLabel, skillChoices)
    rowNum += 1

    val labelPrimalPathLevel = enhancedLabel("Martial Archetype Choice Level")
    val levelPrimalPath = easyTextField(Dnd5Fighter.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val specializationType = "Martial Archetype"
    val labelTraditions = enhancedLabel(specializationType)
    val originsList = getSpecializationNamesByClassName(Dnd5Fighter.classID.toString)
    val iterator = originsList.toIterator
    while (iterator.hasNext) {
      val specName = iterator.next()
      val specPane =
        ClassSpecializationDisplay.buildSpecializationGrid(specName)
      buttonList += new Button(specName) {
        onAction = handle {
          FXUtils.onFXAndWait(
            FXUtils.showDialogWindow(specializationType, specPane))
        }
      }
    }
    val buttonBox = new VBox {
      children = buttonList.toList
      spacing = 2
    }
    fighterGrid.addRow(rowNum, labelPrimalPathLevel, levelPrimalPath, enhancedLabel("Martial Archetypes"), buttonBox)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Fighter Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    fighterGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Fighter.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Fighter.features(level)
      val featureIter = featureList.toIterator
      while (featureIter.hasNext) {
        val feature = featureIter.next()
        fighterGrid.addRow(rowNum, levelAndName(level, feature.name))
        add3ColTextArea(fighterGrid, rowNum, feature.description)
        rowNum += 1
      }
    }

    val thePane = new ScrollPane {
      content = fighterGrid
    }
    thePane
  }

}
