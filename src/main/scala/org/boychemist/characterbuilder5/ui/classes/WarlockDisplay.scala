package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Warlock
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import org.boychemist.characterbuilder5.ui.FXUtils
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Pos
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.text.{Font, FontWeight}
import scalafx.scene.control.TableColumn.{sfxTableColumn2jfx => sfx2jfx}
import scalafx.Includes._

import scala.collection.mutable.ListBuffer

object WarlockDisplay {
  def getWarlockGrid: ScrollPane = {
    val clericGrid = wideGrid4()
    clericGrid.style = "-fx-background-color: skyblue"
    clericGrid.vgap = 2
    var rowNum = 1


    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Warlock.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = easyTextField(Dnd5Warlock.armorProficiencies.mkString("\n"), 150)
    clericGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = easyTextField(Dnd5Warlock.weaponProficiencies.mkString, 120)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = getFittedTextArea(Dnd5Warlock.savingThrowProficiencies.mkString("\n"), 150)
    clericGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Warlock.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices = getFittedTextArea(Dnd5Warlock.skillChoices.mkString("\n"), 150)
    clericGrid.addRow(rowNum, labelNumberOfSkills, numberOfSkills, labelSkillChoices, skillChoices)
    rowNum += 1

    val labelPatronLevel = enhancedLabel("Otherworldly Patron Level")
    val choosePatronLevel = easyTextField(Dnd5Warlock.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val specializationType = "Otherworldly Patrons"
    val labelPatrons = enhancedLabel(specializationType)
    val originsList = getSpecializationNamesByClassName(Dnd5Warlock.classID.toString)
    val iterator = originsList.toIterator
    while (iterator.hasNext) {
      val specName = iterator.next()
      val specPane = ClassSpecializationDisplay.buildSpecializationGrid(specName)
      buttonList += new Button(specName) {
        onAction = handle {FXUtils.onFXAndWait(FXUtils.showDialogWindow(specializationType, specPane))}
      }
    }
    val buttonBox = new VBox {
      children = buttonList.toList
      spacing = 2
    }
    clericGrid.addRow(rowNum, labelPatronLevel, choosePatronLevel, labelPatrons, buttonBox)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Warlock Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    clericGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Warlock.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Warlock.features(level)
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
      children = generateWarlockTableView
    }
    clericGrid.add(centeredBox, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = clericGrid
    }
    thePane
  }

  private case class WarlockTableData(level: Int, cantrips: Int, slots1: Int, slots2: Int, slots3: Int,
                                       slots4: Int, slots5: Int, invocations: Int)

  private def generateWarlockTableData: ObservableBuffer[WarlockTableData] = {
    val working = new ObservableBuffer[WarlockTableData]
    for (i <- 1 to 20) {
      working += WarlockTableData(i, Dnd5Warlock.cantripsPerLevel(i), Dnd5Warlock.firstLevelSlotsPerLevel(i),
        Dnd5Warlock.level2SlotsPerLevel(i), Dnd5Warlock.level3SlotsPerLevel(i), Dnd5Warlock.level4SlotsPerLevel(i),
        Dnd5Warlock.level5SlotsPerLevel(i), Dnd5Warlock.invocationsPerLevel(i))
    }
    working
  }

  private def generateWarlockTableView: TableView[WarlockTableData] = {
    val view = new TableView[WarlockTableData](generateWarlockTableData)
    view.editable = false
    view.columns += sfx2jfx(new TableColumn[WarlockTableData, String]("Warlock\nLevel") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.level.toString)
    })

    view.columns += sfx2jfx(new TableColumn[WarlockTableData, String]("Cantrips\nKnown") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.cantrips.toString)
    })

    view.columns += sfx2jfx(new TableColumn[WarlockTableData, String]("1st\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots1.toString)
    })
    view.columns += sfx2jfx(new TableColumn[WarlockTableData, String]("2nd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots2.toString)
    })
    view.columns += sfx2jfx(new TableColumn[WarlockTableData, String]("3rd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots3.toString)
    })
    view.columns += sfx2jfx(new TableColumn[WarlockTableData, String]("4th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots4.toString)
    })
    view.columns += sfx2jfx(new TableColumn[WarlockTableData, String]("5th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots5.toString)
    })
    view.columns += sfx2jfx(new TableColumn[WarlockTableData, String]("Invocations\nKnown") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.invocations.toString)
    })

    view.maxWidth = 460
    view
  }

}
