package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClasses.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Barbarian
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.geometry.HPos
import scalafx.scene.control.{Button, Label, ScrollPane}
import scalafx.scene.layout.{ColumnConstraints, GridPane, VBox}
import scalafx.scene.text.{Font, FontWeight}
import slick.jdbc.JdbcBackend.Database

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

    // add a blank row
    barbGrid.addRow(rowNum, enhancedLabel(" "))
    rowNum += 1

    barbGrid.add(generateBarbarianTable, 1, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = barbGrid
    }
    thePane
  }

  private def generateBarbarianTable:GridPane = {
    val col1Constraints = new ColumnConstraints {
      halignment = HPos.Center

    }
    val col2Constraints = new ColumnConstraints {
      halignment = HPos.Center
    }
    val col3Constraints = new ColumnConstraints {
      halignment = HPos.Center
    }
    val col4Constraints = new ColumnConstraints {
      halignment = HPos.Center
    }
    val tableGrid = new GridPane {
      gridLinesVisible = true
      columnConstraints = List(col1Constraints, col2Constraints, col3Constraints, col4Constraints)
      style = "-fx-background-color: white"
      maxWidth = 410
    }
    var rowNum = 1
    tableGrid.addRow(rowNum, enhancedLabel(" Barbarian Level "))
    tableGrid.addRow(rowNum, enhancedLabel(" Rages / Long Rest "))
    tableGrid.addRow(rowNum, enhancedLabel(" Rage Damage "))
    tableGrid.addRow(rowNum, enhancedLabel(" Brutal Critical Bonus "))

    for (i <- 1 to 20) {
      rowNum += 1
      tableGrid.addRow(rowNum, enhancedLabel(i.toString))
      val rages = Dnd5Barbarian.ragesByLevel(i)
      if (rages > 0)
        tableGrid.addRow(rowNum, enhancedLabel(rages.toString))
      else
        tableGrid.addRow(rowNum, enhancedLabel("Unlimited"))
      tableGrid.addRow(rowNum, enhancedLabel(Dnd5Barbarian.rageDamageBonusByLevel(i).toString),
        enhancedLabel(Dnd5Barbarian.getBrutalCriticalBonusDice(i).toString))
    }

    tableGrid
  }

}
