package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Wizard
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

object WizardDisplay {

  def getWizardGrid: ScrollPane = {
    val clericGrid = wideGrid4()
    clericGrid.style = "-fx-background-color: skyblue"
    clericGrid.vgap = 2
    var rowNum = 1

    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Wizard.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = easyTextField("None", 150)
    clericGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons =
      variableTextArea(Dnd5Wizard.weaponProficiencies.mkString("\n"), 120, 100)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = variableTextArea(
      Dnd5Wizard.savingThrowProficiencies.mkString("\n"),
      150,
      45)
    clericGrid.addRow(rowNum,
                      weaponsLabel,
                      weapons,
                      savingThrowsLabel,
                      savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Wizard.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices =
      variableTextArea(Dnd5Wizard.skillChoices.mkString("\n"), 150, 93)
    clericGrid.addRow(rowNum,
                      labelNumberOfSkills,
                      numberOfSkills,
                      labelSkillChoices,
                      skillChoices)
    rowNum += 1

    val labelTraditionLevel = enhancedLabel("Arcane Tradition Level")
    val chooseTraditionLevel = easyTextField(
      Dnd5Wizard.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val labelTraditions = enhancedLabel("Arcane Traditions")
    val specializationType = "Arcane Tradition"
    val labelPatrons = enhancedLabel(specializationType)
    val originsList =
      getSpecializationNamesByClassName(Dnd5Wizard.classID.toString)
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
    clericGrid.addRow(rowNum,
                      labelTraditionLevel,
                      chooseTraditionLevel,
                      labelTraditions,
                      buttonBox)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Wizard Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    clericGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Wizard.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Wizard.features(level)
      val featureIter = featureList.toIterator
      while (featureIter.hasNext) {
        val feature = featureIter.next()
        clericGrid.addRow(rowNum, levelAndName(level, feature.name))
        add3ColTextArea(clericGrid, rowNum, feature.description)
        rowNum += 1
      }
    }

    // add a blank row
    clericGrid.addRow(rowNum, enhancedLabel(" "))
    rowNum += 1

    val centeredBox = new HBox {
      alignment = Pos.Center
      children = generateWizardTableView
    }
    clericGrid.add(centeredBox, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = clericGrid
    }
    thePane
  }

  private case class WizardTableData(level: Int,
                                     cantrips: Int,
                                     slots1: Int,
                                     slots2: Int,
                                     slots3: Int,
                                     slots4: Int,
                                     slots5: Int,
                                     slots6: Int,
                                     slots7: Int,
                                     slots8: Int,
                                     slots9: Int)

  private def generateWizardTableData: ObservableBuffer[WizardTableData] = {
    val working = new ObservableBuffer[WizardTableData]
    for (i <- 1 to 20) {
      working += WizardTableData(
        i,
        Dnd5Wizard.cantripsPerLevel(i),
        Dnd5Wizard.firstLevelSlotsPerLevel(i),
        Dnd5Wizard.level2SlotsPerLevel(i),
        Dnd5Wizard.level3SlotsPerLevel(i),
        Dnd5Wizard.level4SlotsPerLevel(i),
        Dnd5Wizard.level5SlotsPerLevel(i),
        Dnd5Wizard.level6SlotsPerLevel(i),
        Dnd5Wizard.level7SlotsPerLevel(i),
        Dnd5Wizard.level8SlotsPerLevel(i),
        Dnd5Wizard.level9SlotsPerLevel(i)
      )
    }
    working
  }

  private def generateWizardTableView: TableView[WizardTableData] = {
    val view = new TableView[WizardTableData](generateWizardTableData)
    view.editable = false
    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("Wizard\nLevel") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.level.toString)
      })

    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("Cantrips\nKnown") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.cantrips.toString)
      })

    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("1st\nLevel\nSpell\nSlots") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slots1.toString)
      })
    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("2nd\nLevel\nSpell\nSlots") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slots2.toString)
      })
    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("3rd\nLevel\nSpell\nSlots") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slots3.toString)
      })
    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("4th\nLevel\nSpell\nSlots") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slots4.toString)
      })
    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("5th\nLevel\nSpell\nSlots") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slots5.toString)
      })
    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("6th\nLevel\nSpell\nSlots") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slots6.toString)
      })
    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("7th\nLevel\nSpell\nSlots") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slots7.toString)
      })
    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("8th\nLevel\nSpell\nSlots") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slots8.toString)
      })
    view.columns += sfx2jfx(
      new TableColumn[WizardTableData, String]("9th\nLevel\nSpell\nSlots") {
        editable = false
        sortable = false
        cellValueFactory = cdf => StringProperty(cdf.value.slots9.toString)
      })

    view.maxWidth = 560
    view
  }

}
