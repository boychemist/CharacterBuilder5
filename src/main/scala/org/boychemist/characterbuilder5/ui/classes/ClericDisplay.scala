package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClasses.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Cleric
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.scene.control._
import scalafx.scene.layout.VBox
import scalafx.scene.text.{Font, FontWeight}
import slick.jdbc.JdbcBackend.Database
import scalafx.scene.control.TableColumn.{sfxTableColumn2jfx => sfx2jfx}

import scala.collection.mutable.ListBuffer

object ClericDisplay {
  def getClericGrid(db: Database): ScrollPane = {
    val clericGrid = wideGrid4()
    clericGrid.style = "-fx-background-color: skyblue"
    clericGrid.vgap = 2
    var rowNum = 1


    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Cleric.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = variableTextArea(Dnd5Cleric.armorProficiencies.mkString("\n"), 150, 60)
    clericGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = easyTextField(Dnd5Cleric.weaponProficiencies.mkString(""), 150)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = variableTextArea(Dnd5Cleric.savingThrowProficiencies.mkString("\n"), 150, 45)
    clericGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Cleric.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices = variableTextArea(Dnd5Cleric.skillChoices.mkString("\n"), 150, 93)
    clericGrid.addRow(rowNum, labelNumberOfSkills, numberOfSkills, labelSkillChoices, skillChoices)
    rowNum += 1

    val labelDivineDomainLevel = enhancedLabel("Divine Domain Choice Level")
    val chooseDomainLevel = easyTextField(Dnd5Cleric.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val labelDivineDomaines = enhancedLabel("Divine Domains")
    val divineDomainsList = getSpecializationNamesByClassName(db, Dnd5Cleric.classID.toString)
    val iterator = divineDomainsList.toIterator
    while (iterator.hasNext) {
      buttonList += new Button(iterator.next())
    }
    val buttonBox = new VBox {
      children = buttonList.toList
      spacing = 2
    }
    clericGrid.addRow(rowNum, labelDivineDomainLevel, chooseDomainLevel, labelDivineDomaines, buttonBox)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Cleric Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    clericGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Cleric.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Cleric.features(level)
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

    clericGrid.add(generateClericTableView, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = clericGrid
    }
    thePane
  }

  private case class ClericTableData(level: Int, cantrips: Int, slots1: Int, slots2: Int, slots3: Int,
                                     slots4: Int, slots5: Int, slots6: Int, slots7: Int, slots8: Int, slots9: Int)

  private def generateClericTableData: ObservableBuffer[ClericTableData] = {
    val working = new ObservableBuffer[ClericTableData]
    for (i <- 1 to 20) {
      working += ClericTableData(i, Dnd5Cleric.cantripsPerLevel(i), Dnd5Cleric.firstLevelSlotsPerLevel(i),
        Dnd5Cleric.level2SlotsPerLevel(i), Dnd5Cleric.level3SlotsPerLevel(i), Dnd5Cleric.level4SlotsPerLevel(i),
        Dnd5Cleric.level5SlotsPerLevel(i), Dnd5Cleric.level6SlotsPerLevel(i), Dnd5Cleric.level7SlotsPerLevel(i),
        Dnd5Cleric.level8SlotsPerLevel(i), Dnd5Cleric.level9SlotsPerLevel(i))
    }
    working
  }

  private def generateClericTableView: TableView[ClericTableData] = {
    val view = new TableView[ClericTableData](generateClericTableData)
    view.editable = false
    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("Cleric\nLevel") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.level.toString)
    })

    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("Cantrips\nKnown") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.cantrips.toString)
    })

    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("1st\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots1.toString)
    })
    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("2nd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots2.toString)
    })
    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("3rd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots3.toString)
    })
    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("4th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots4.toString)
    })
    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("5th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots5.toString)
    })
    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("6th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots6.toString)
    })
    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("7th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots7.toString)
    })
    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("8th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots8.toString)
    })
    view.columns += sfx2jfx(new TableColumn[ClericTableData, String]("9th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots9.toString)
    })

    view.maxWidth = 555

    view
  }

}
