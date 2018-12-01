package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClasses.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Druid
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Pos
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.text.{Font, FontWeight}
import slick.jdbc.JdbcBackend.Database
import scalafx.scene.control.TableColumn.{sfxTableColumn2jfx => sfx2jfx}

import scala.collection.mutable.ListBuffer

object DruidDisplay {

  def getDruidGrid(db: Database): ScrollPane = {
    val druidGrid = wideGrid4()
    druidGrid.style = "-fx-background-color: skyblue"
    druidGrid.vgap = 2
    var rowNum = 1


    val hitLabel = enhancedLabel(" Hit Die")
    val hit = easyTextField(Dnd5Druid.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = variableTextArea(Dnd5Druid.armorProficiencies.mkString("\n"), 100, 60)
    druidGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1


    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = variableTextArea(Dnd5Druid.weaponProficiencies.mkString("\n"), 100, 178)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = variableTextArea(Dnd5Druid.savingThrowProficiencies.mkString("\n"), 100, 45)
    druidGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Druid.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices = variableTextArea(Dnd5Druid.skillChoices.mkString("\n"), 100, 165)
    druidGrid.addRow(rowNum, labelNumberOfSkills, numberOfSkills, labelSkillChoices, skillChoices)
    rowNum += 1

    val labelDruidCircleLevel = enhancedLabel("Druid Circles Choice Level")
    val chooseCircleLevel = easyTextField(Dnd5Druid.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val labelDruidCircles = enhancedLabel("Druid Circles")
    val druidCirclesList = getSpecializationNamesByClassName(db, Dnd5Druid.classID.toString)
    val iterator = druidCirclesList.toIterator
    while (iterator.hasNext) {
      buttonList += new Button(iterator.next())
    }
    val buttonBox = new VBox {
      children = buttonList.toList
      spacing = 2
    }
    druidGrid.addRow(rowNum, labelDruidCircleLevel, chooseCircleLevel, labelDruidCircles, buttonBox)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Druid Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    druidGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Druid.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Druid.features(level)
      val featureIter = featureList.toIterator
      while (featureIter.hasNext) {
        val feature = featureIter.next()
        druidGrid.addRow(rowNum, levelAndName(level, feature.name))
        add3ColTextArea(druidGrid, rowNum, feature.description)
        rowNum += 1
      }
    }

    // add a blank row
    druidGrid.addRow(rowNum, enhancedLabel(" "))
    rowNum += 1

    val centeredBox = new HBox {
      alignment = Pos.Center
      children = generateDruidTableView
    }

    druidGrid.add(centeredBox, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = druidGrid
    }
    thePane
  }

  private case class DruidTableData(level: Int, cantrips: Int, slots1: Int, slots2: Int, slots3: Int,
                                     slots4: Int, slots5: Int, slots6: Int, slots7: Int, slots8: Int, slots9: Int)

  private def generateDruidTableData: ObservableBuffer[DruidTableData] = {
    val working = new ObservableBuffer[DruidTableData]
    for (i <- 1 to 20) {
      working += DruidTableData(i, Dnd5Druid.cantripsPerLevel(i), Dnd5Druid.firstLevelSlotsPerLevel(i),
        Dnd5Druid.level2SlotsPerLevel(i), Dnd5Druid.level3SlotsPerLevel(i), Dnd5Druid.level4SlotsPerLevel(i),
        Dnd5Druid.level5SlotsPerLevel(i), Dnd5Druid.level6SlotsPerLevel(i), Dnd5Druid.level7SlotsPerLevel(i),
        Dnd5Druid.level8SlotsPerLevel(i), Dnd5Druid.level9SlotsPerLevel(i))
    }
    working
  }

  private def generateDruidTableView: TableView[DruidTableData] = {
    val view = new TableView[DruidTableData](generateDruidTableData)
    view.editable = false
    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("Druid\nLevel") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.level.toString)
    })

    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("Cantrips\nKnown") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.cantrips.toString)
    })

    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("1st\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots1.toString)
    })
    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("2nd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots2.toString)
    })
    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("3rd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots3.toString)
    })
    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("4th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots4.toString)
    })
    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("5th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots5.toString)
    })
    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("6th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots6.toString)
    })
    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("7th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots7.toString)
    })
    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("8th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots8.toString)
    })
    view.columns += sfx2jfx(new TableColumn[DruidTableData, String]("9th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots9.toString)
    })

    view.maxWidth = 555

    view
  }

}
