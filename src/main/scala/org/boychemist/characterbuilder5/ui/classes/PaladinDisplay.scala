package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Paladin
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

object PaladinDisplay {

  def getPaladinGrid: ScrollPane = {
    val palGrid = wideGrid4()
    palGrid.style = "-fx-background-color: skyblue"
    palGrid.vgap = 2
    var rowNum = 1


    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Paladin.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = getFittedTextArea(Dnd5Paladin.armorProficiencies.mkString("\n"), 150)
    palGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = getFittedTextArea(Dnd5Paladin.weaponProficiencies.mkString("\n"), 120)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = getFittedTextArea(Dnd5Paladin.savingThrowProficiencies.mkString("\n"), 150)
    palGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Paladin.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices = getFittedTextArea(Dnd5Paladin.skillChoices.mkString("\n"), 150)
    palGrid.addRow(rowNum, labelNumberOfSkills, numberOfSkills, labelSkillChoices, skillChoices)
    rowNum += 1

    val labelOathLevel = enhancedLabel("Sacred Oath Choice Level")
    val chooseOathLevel = easyTextField(Dnd5Paladin.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val labelSacredOaths = enhancedLabel("Sacred Oaths")
    val specializationType = "Sacred Oath"
    val labelPatrons = enhancedLabel(specializationType)
    val originsList =
      getSpecializationNamesByClassName(Dnd5Paladin.classID.toString)
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
    palGrid.addRow(rowNum, labelOathLevel, chooseOathLevel, labelSacredOaths, buttonBox)
    rowNum += 1

    palGrid.addRow(rowNum, enhancedLabel("Min Paladin Level for Spells"), easyTextField("2"))
    rowNum += 1

    val classAbilitiesLabel = new Label(" Paladin Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    palGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Paladin.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Paladin.features(level)
      val featureIter = featureList.toIterator
      while (featureIter.hasNext) {
        val feature = featureIter.next()
        palGrid.addRow(rowNum, levelAndName(level, feature.name))
        add3ColTextArea(palGrid, rowNum, feature.description)
        rowNum += 1
      }
    }

    // add a blank row
    palGrid.addRow(rowNum, enhancedLabel(" "))
    rowNum += 1

    val centeredBox = new HBox {
      alignment = Pos.Center
      children = generatePaladinTableView
    }
    palGrid.add(centeredBox, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = palGrid
    }
    thePane
  }

  private case class PaladinTableData(level: Int, slots1: Int, slots2: Int, slots3: Int, slots4: Int, slots5: Int)

  private def generatePaladinTableData: ObservableBuffer[PaladinTableData] = {
    val working = new ObservableBuffer[PaladinTableData]
    for (i <- 1 to 20) {
      working += PaladinTableData(i, Dnd5Paladin.firstLevelSlotsPerLevel(i), Dnd5Paladin.level2SlotsPerLevel(i),
        Dnd5Paladin.level3SlotsPerLevel(i), Dnd5Paladin.level4SlotsPerLevel(i), Dnd5Paladin.level5SlotsPerLevel(i))
    }
    working
  }

  private def generatePaladinTableView: TableView[PaladinTableData] = {
    val view = new TableView[PaladinTableData](generatePaladinTableData)
    view.editable = false
    view.columns += sfx2jfx(new TableColumn[PaladinTableData, String]("Paladin\nLevel") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.level.toString)
    })

    view.columns += sfx2jfx(new TableColumn[PaladinTableData, String]("1st\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots1.toString)
    })
    view.columns += sfx2jfx(new TableColumn[PaladinTableData, String]("2nd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots2.toString)
    })
    view.columns += sfx2jfx(new TableColumn[PaladinTableData, String]("3rd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots3.toString)
    })
    view.columns += sfx2jfx(new TableColumn[PaladinTableData, String]("4th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots4.toString)
    })
    view.columns += sfx2jfx(new TableColumn[PaladinTableData, String]("5th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots5.toString)
    })

    view.maxWidth = 315

    view
  }

}
