package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.dnd5classes.Dnd5Barbarian
import scalafx.scene.layout.{GridPane, VBox}
import scalafx.scene.control._
import CharacterBuilderUIutils._
import slick.jdbc.JdbcBackend.Database
import org.boychemist.characterbuilder5.dbInterface.DbClasses._
import scalafx.scene.text.{Font, FontWeight}

import scala.collection.mutable.ListBuffer

object BarbarianDisplay {
  def getBarbarianGrid(db: Database): ScrollPane = {
    val barbGrid = wideGrid4()
    barbGrid.style = "-fx-background-color: skyblue"
    barbGrid.vgap = 2
    var rowNum = 1

    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Barbarian.hitDice, 50)
    barbGrid.addRow(rowNum, hitLabel)
    barbGrid.addRow(rowNum, hit)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = variableTextArea(Dnd5Barbarian.armorProficiencies.mkString("\n"), 150, 60)
    barbGrid.addRow(rowNum, armorLabel)
    barbGrid.addRow(rowNum, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = variableTextArea(Dnd5Barbarian.weaponProficiencies.mkString("\n"), 150, 45)
    barbGrid.addRow(rowNum, weaponsLabel)
    barbGrid.addRow(rowNum, weapons)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = variableTextArea(Dnd5Barbarian.savingThrowProficiencies.mkString("\n"), 150, 45)
    barbGrid.addRow(rowNum, savingThrowsLabel)
    barbGrid.addRow(rowNum, savingThrows)
    rowNum += 1

    val numSkillChoicesLabel = enhancedLabel("Number of Skills to Choose")
    val numSkillChoices = easyTextField(Dnd5Barbarian.numberOfSkills.toString)
    barbGrid.addRow(rowNum, numSkillChoicesLabel)
    barbGrid.addRow(rowNum, numSkillChoices)

    val skillChoicesLabel = enhancedLabel("Skill Choices")
    val skillChoices = variableTextArea(Dnd5Barbarian.skillChoices.mkString("\n"), 150, 120)
    barbGrid.addRow(rowNum, skillChoicesLabel)
    barbGrid.addRow(rowNum, skillChoices)
    rowNum += 1

    val labelPrimalPathLevel = enhancedLabel("Pimal Path Choice Level")
    val levelPrimalPath = easyTextField(Dnd5Barbarian.specializationStartLevel.toString)
    barbGrid.addRow(rowNum, labelPrimalPathLevel)
    barbGrid.addRow(rowNum, levelPrimalPath)

    val buttonList = new ListBuffer[Button]
    val allowedSpecializations = getSpecializationNamesByClassName(db, Dnd5Barbarian.classID.toString)
    val iterator = allowedSpecializations.toIterator
    while (iterator.hasNext) {
      buttonList += new Button(iterator.next())
    }
    val buttonBox = new VBox {
      children = buttonList.toList
      spacing = 2
    }
    barbGrid.addRow(rowNum, enhancedLabel("Primal Paths"))
    barbGrid.addRow(rowNum, buttonBox)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Barbarian Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    barbGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Barbarian.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Barbarian.features(level)
      val featureIter = featureList.toIterator
      while (featureIter.hasNext) {
        val feature = featureIter.next()
        barbGrid.addRow(rowNum, levelAndName(level, feature.name))
        add3ColTextArea(barbGrid, rowNum, feature.description)
        rowNum += 1
      }
    }

    val thePane = new ScrollPane {
      content = barbGrid
    }
    thePane
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

  def add3ColTextArea(grid: GridPane, rowNum: Int, theText: String, startCol: Int = 1): Unit = {
    val area = wideTextArea(theText)
    grid.add(area, startCol, rowNum, 3, 1)
  }
}
