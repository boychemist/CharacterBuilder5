package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Ranger
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

object RangerDisplay {

  def getRangerGrid: ScrollPane = {
    val rangerGrid = wideGrid4()
    rangerGrid.style = "-fx-background-color: skyblue"
    rangerGrid.vgap = 2
    var rowNum = 1


    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Ranger.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = variableTextArea(Dnd5Ranger.armorProficiencies.mkString("\n"), 150, 60)
    rangerGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = variableTextArea(Dnd5Ranger.weaponProficiencies.mkString("\n"), 120, 45)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = variableTextArea(Dnd5Ranger.savingThrowProficiencies.mkString("\n"), 150, 45)
    rangerGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Ranger.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices = variableTextArea(Dnd5Ranger.skillChoices.mkString("\n"), 150, 93)
    rangerGrid.addRow(rowNum, labelNumberOfSkills, numberOfSkills, labelSkillChoices, skillChoices)
    rowNum += 1

    val labelArchetypeLevel = enhancedLabel("Ranger Archetype Choice Level")
    val chooseArchetypeLevel = easyTextField(Dnd5Ranger.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val labelArchetype = enhancedLabel("Ranger Archetype")
    val specializationType = "Ranger Archetype"
    val labelPatrons = enhancedLabel(specializationType)
    val originsList =
      getSpecializationNamesByClassName(Dnd5Ranger.classID.toString)
    val iterator = originsList.toIterator
    while (iterator.hasNext) {
      val specName = iterator.next()
      val specPane =
        ClassSpecializationDisplay.buildSpecializationGrid(specName)
      buttonList += new Button(specName) {
        onAction = handle {
          FXUtils.onFXAndWait(
            FXUtils.showDialogPane(specializationType, specPane))
        }
      }
    }
    val buttonBox = new VBox {
      children = buttonList.toList
      spacing = 2
    }
    rangerGrid.addRow(rowNum, labelArchetypeLevel, chooseArchetypeLevel, labelArchetype, buttonBox)
    rowNum += 1

    rangerGrid.addRow(rowNum, enhancedLabel("Min Ranger Level for Spells"), easyTextField("2"))
    rowNum += 1

    val classAbilitiesLabel = new Label(" Ranger Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    rangerGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Ranger.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Ranger.features(level)
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
      children = generateRangerTableView
    }
    rangerGrid.add(centeredBox, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = rangerGrid
    }
    thePane
  }

  private case class RangerTableData(level: Int, slots1: Int, slots2: Int, slots3: Int, slots4: Int, slots5: Int)

  private def generateRangerTableData: ObservableBuffer[RangerTableData] = {
    val working = new ObservableBuffer[RangerTableData]
    for (i <- 1 to 20) {
      working += RangerTableData(i, Dnd5Ranger.firstLevelSlotsPerLevel(i), Dnd5Ranger.level2SlotsPerLevel(i),
        Dnd5Ranger.level3SlotsPerLevel(i), Dnd5Ranger.level4SlotsPerLevel(i), Dnd5Ranger.level5SlotsPerLevel(i))
    }
    working
  }

  private def generateRangerTableView: TableView[RangerTableData] = {
    val view = new TableView[RangerTableData](generateRangerTableData)
    view.editable = false
    view.columns += sfx2jfx(new TableColumn[RangerTableData, String]("Ranger\nLevel") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.level.toString)
    })

    view.columns += sfx2jfx(new TableColumn[RangerTableData, String]("1st\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots1.toString)
    })
    view.columns += sfx2jfx(new TableColumn[RangerTableData, String]("2nd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots2.toString)
    })
    view.columns += sfx2jfx(new TableColumn[RangerTableData, String]("3rd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots3.toString)
    })
    view.columns += sfx2jfx(new TableColumn[RangerTableData, String]("4th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots4.toString)
    })
    view.columns += sfx2jfx(new TableColumn[RangerTableData, String]("5th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots5.toString)
    })

    view.maxWidth = 315

    view
  }

}
