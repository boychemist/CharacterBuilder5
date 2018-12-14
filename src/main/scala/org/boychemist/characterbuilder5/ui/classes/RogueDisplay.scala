package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Rogue
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import org.boychemist.characterbuilder5.ui.FXUtils
import scalafx.Includes.handle
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Pos
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.text.{Font, FontWeight}
import scalafx.scene.control.TableColumn.{sfxTableColumn2jfx => sfx2jfx}

import scala.collection.mutable.ListBuffer

object RogueDisplay {

  def getRogueGrid: ScrollPane = {
    val rangerGrid = wideGrid4()
    rangerGrid.style = "-fx-background-color: skyblue"
    rangerGrid.vgap = 2
    var rowNum = 1


    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Rogue.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = easyTextField(Dnd5Rogue.armorProficiencies.mkString("\n"), 150)
    rangerGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = variableTextArea(Dnd5Rogue.weaponProficiencies.mkString("\n"), 120, 93)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = variableTextArea(Dnd5Rogue.savingThrowProficiencies.mkString("\n"), 150, 45)
    rangerGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Rogue.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices = variableTextArea(Dnd5Rogue.skillChoices.mkString("\n"), 150, 93)
    rangerGrid.addRow(rowNum, labelNumberOfSkills, numberOfSkills, labelSkillChoices, skillChoices)
    rowNum += 1

    val labelArchetypeLevel = enhancedLabel("Roguish Archetype Choice Level")
    val chooseArchetypeLevel = easyTextField(Dnd5Rogue.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val labelTraditions = enhancedLabel("Roguish Archetype")
    val specializationType = "Roguish Archetype"
    val labelPatrons = enhancedLabel(specializationType)
    val originsList =
      getSpecializationNamesByClassName(Dnd5Rogue.classID.toString)
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
    rangerGrid.addRow(rowNum, labelArchetypeLevel, chooseArchetypeLevel, labelTraditions, buttonBox)
    rowNum += 1

    val labelToolProficiency = enhancedLabel("Tool Proficiency")
    val toolProficiency = easyTextField(Dnd5Rogue.toolProficiencies.mkString, 120)
    rangerGrid.addRow(rowNum, labelToolProficiency, toolProficiency)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Rogue Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    rangerGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Rogue.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Rogue.features(level)
      val featureIter = featureList.toIterator
      while (featureIter.hasNext) {
        val feature = featureIter.next()
        rangerGrid.addRow(rowNum, levelAndName(level, feature.name))
        add3ColTextArea(rangerGrid, rowNum, feature.description)
        rowNum += 1
      }
    }

    // add a blank row
    rangerGrid.addRow(rowNum, enhancedLabel(" "))
    rowNum += 1

    val centeredBox = new HBox {
      alignment = Pos.Center
      children = generateRogueTableView
    }
    rangerGrid.add(centeredBox, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = rangerGrid
    }
    thePane
  }

  private case class RogueTabelData(level: Int, sneakHitDice: String)

  private def generateRogueTabelData: ObservableBuffer[RogueTabelData] = {
    val working = new ObservableBuffer[RogueTabelData]
    for (i <- 1 to 20) {
      working += RogueTabelData(i, Dnd5Rogue.sneakAttackBonusByLevel(i))
    }
    working
  }

  private def generateRogueTableView: TableView[RogueTabelData] = {
    val view = new TableView[RogueTabelData](generateRogueTabelData)
    view.editable = false
    view.columns += sfx2jfx(new TableColumn[RogueTabelData, String]("Rogue Level") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.level.toString)
    })

    view.columns += sfx2jfx(new TableColumn[RogueTabelData, String]("Sneak Attack\nBonus Hit Dice") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.sneakHitDice)
    })

    view.maxWidth = 200

    view
  }
}
