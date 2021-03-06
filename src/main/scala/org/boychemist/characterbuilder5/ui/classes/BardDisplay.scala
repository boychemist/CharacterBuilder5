package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Bard
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

object BardDisplay {
  def getBardGrid: ScrollPane = {
    val bardGrid = wideGrid4()
    bardGrid.style = "-fx-background-color: skyblue"
    bardGrid.vgap = 2
    var rowNum = 1

    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Bard.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = easyTextField(Dnd5Bard.armorProficiencies.mkString, 150)
    bardGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapons")
    val weapons = getFittedTextArea(Dnd5Bard.weaponProficiencies.mkString("\n"), 150)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = getFittedTextArea(Dnd5Bard.savingThrowProficiencies.mkString("\n"), 150)
    bardGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Bard.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices = getFittedTextArea(Dnd5Bard.skillChoices.mkString("\n"), 150)
    bardGrid.addRow(rowNum, labelNumberOfSkills, numberOfSkills, labelSkillChoices, skillChoices)
    rowNum += 1

    val toolProficiencyLabel = enhancedLabel("Tool Proficiency")
    val toolProficiency = getFittedTextArea(Dnd5Bard.toolProficiencies.mkString, 120)
    bardGrid.addRow(rowNum, toolProficiencyLabel, toolProficiency)
    rowNum += 1

    val labelChooseCollegeLevel = enhancedLabel("College Choice Level")
    val chooseCollegeLevel = easyTextField(Dnd5Bard.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val specializationType = "College"
    val labelBardColleges = enhancedLabel(specializationType)
    val originsList = getSpecializationNamesByClassName(Dnd5Bard.classID.toString)
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
    bardGrid.addRow(rowNum, labelChooseCollegeLevel, chooseCollegeLevel, labelBardColleges, buttonBox)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Bard Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    bardGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Bard.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Bard.features(level)
      val featureIter = featureList.toIterator
      while (featureIter.hasNext) {
        val feature = featureIter.next()
        bardGrid.addRow(rowNum, levelAndName(level, feature.name))
        add3ColTextArea(bardGrid, rowNum, feature.description)
        rowNum += 1
      }
    }

    // add a blank row
    bardGrid.addRow(rowNum, enhancedLabel(" "))
    rowNum += 1

    val centeredBox = new HBox {
      alignment = Pos.Center
      children = generateBardTableView
    }
    bardGrid.add(centeredBox, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = bardGrid
    }
    thePane
  }

  private case class BardTableData(level: String, cantrip: String, spells:String, slot1: String, slot2: String,
                                   slot3: String, slot4:String, slot5: String, slot6: String, slot7: String,
                                   slot8: String, slot9: String)
  private def generateBardTableData: ObservableBuffer[BardTableData] = {
    val workingList = new ObservableBuffer[BardTableData]
    for (i <- 1 to 20) {
      workingList += BardTableData(
        i.toString, Dnd5Bard.cantripsPerLevel(i).toString, Dnd5Bard.totalSpellsKnownByClassLevel(i).toString,
        Dnd5Bard.firstLevelSlotsPerLevel(i).toString, Dnd5Bard.level2SlotsPerLevel(i).toString,
        Dnd5Bard.level3SlotsPerLevel(i).toString, Dnd5Bard.level4SlotsPerLevel(i).toString,
        Dnd5Bard.level5SlotsPerLevel(i).toString, Dnd5Bard.level6SlotsPerLevel(i).toString,
        Dnd5Bard.level7SlotsPerLevel(i).toString, Dnd5Bard.level4SlotsPerLevel(i).toString,
        Dnd5Bard.level9SlotsPerLevel(i).toString
      )
    }
    workingList
  }

  private def generateBardTableView: TableView[BardTableData] = {
    val view = new TableView[BardTableData](generateBardTableData) {
      editable = false
    }
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("Bard\nLevel") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.level)
      })

    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("Cantrips\nKnown") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.cantrip)
      })

    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("Spells\nKnown") {
        editable = false
        cellValueFactory = cdf => StringProperty(cdf.value.spells)
      })
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("1st\nLevel\nSpell\nSlots") {
        editable = false
      sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slot1)
      })
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("2nd\nLevel\nSpell\nSlots") {
        editable = false
      sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slot2)
      })
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("3rd\nLevel\nSpell\nSlots") {
        editable = false
      sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slot3)
      })
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("4th\nLevel\nSpell\nSlots") {
        editable = false
      sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slot4)
      })
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("5th\nLevel\nSpell\nSlots") {
        editable = false
      sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slot5)
      })
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("6th\nLevel\nSpell\nSlots") {
        editable = false
      sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slot6)
      })
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("7th\nLevel\nSpell\nSlots") {
        editable = false
      sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slot7)
      })
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("8th\nLevel\nSpell\nSlots") {
        editable = false
      sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slot8)
      })
    view.columns += sfx2jfx(new TableColumn[BardTableData, String]("9th\nLevel\nSpell\nSlots") {
        editable = false
      sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slot9)
      })

    view.maxWidth = 610

    view
  }
}
