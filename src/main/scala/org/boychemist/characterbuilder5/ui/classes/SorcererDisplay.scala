package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dbInterface.DbClasses.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.dnd5classes.Dnd5Sorcerer
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

object SorcererDisplay {
  def getSorcererGrid(db: Database): ScrollPane = {
    val clericGrid = wideGrid4()
    clericGrid.style = "-fx-background-color: skyblue"
    clericGrid.vgap = 2
    var rowNum = 1


    val hitLabel = enhancedLabel("Hit Die")
    val hit = easyTextField(Dnd5Sorcerer.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = easyTextField("None", 150)
    clericGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = variableTextArea(Dnd5Sorcerer.weaponProficiencies.mkString("\n"), 120, 100)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = variableTextArea(Dnd5Sorcerer.savingThrowProficiencies.mkString("\n"), 150, 45)
    clericGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Sorcerer.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices = variableTextArea(Dnd5Sorcerer.skillChoices.mkString("\n"), 150, 93)
    clericGrid.addRow(rowNum, labelNumberOfSkills, numberOfSkills, labelSkillChoices, skillChoices)
    rowNum += 1

    val labelDivineDomainLevel = enhancedLabel("Origin Choice Level")
    val chooseDomainLevel = easyTextField(Dnd5Sorcerer.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val labelOrigins = enhancedLabel("Origins")
    val originsList = getSpecializationNamesByClassName(db, Dnd5Sorcerer.classID.toString)
    val iterator = originsList.toIterator
    while (iterator.hasNext) {
      buttonList += new Button(iterator.next())
    }
    val buttonBox = new VBox {
      children = buttonList.toList
      spacing = 2
    }
    clericGrid.addRow(rowNum, labelDivineDomainLevel, chooseDomainLevel, labelOrigins, buttonBox)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Sorcerer Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    clericGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Sorcerer.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Sorcerer.features(level)
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
      children = generateSorcererTableView
    }
    clericGrid.add(centeredBox, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = clericGrid
    }
    thePane
  }

  private case class SorcererTableData(level: Int, sorceryPoints: Int, cantrips: Int, slots1: Int, slots2: Int, slots3: Int,
                                     slots4: Int, slots5: Int, slots6: Int, slots7: Int, slots8: Int, slots9: Int)

  private def getSorceryPoints(level: Int): Int = {
    if (level == 1)
      0
    else
      level
  }

  private def generateSorcererTableData: ObservableBuffer[SorcererTableData] = {
    val working = new ObservableBuffer[SorcererTableData]
    for (i <- 1 to 20) {
      working += SorcererTableData(i,getSorceryPoints(i), Dnd5Sorcerer.cantripsPerLevel(i),
        Dnd5Sorcerer.firstLevelSlotsPerLevel(i), Dnd5Sorcerer.level2SlotsPerLevel(i),
        Dnd5Sorcerer.level3SlotsPerLevel(i), Dnd5Sorcerer.level4SlotsPerLevel(i), Dnd5Sorcerer.level5SlotsPerLevel(i),
        Dnd5Sorcerer.level6SlotsPerLevel(i), Dnd5Sorcerer.level7SlotsPerLevel(i), Dnd5Sorcerer.level8SlotsPerLevel(i),
        Dnd5Sorcerer.level9SlotsPerLevel(i))
    }
    working
  }

  private def generateSorcererTableView: TableView[SorcererTableData] = {
    val view = new TableView[SorcererTableData](generateSorcererTableData)
    view.editable = false
    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("Sorcerer\nLevel") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.level.toString)
    })

    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("Sorcery\nPoints") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.sorceryPoints.toString)
    })

    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("Cantrips\nKnown") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.cantrips.toString)
    })

    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("1st\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots1.toString)
    })
    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("2nd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots2.toString)
    })
    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("3rd\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots3.toString)
    })
    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("4th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots4.toString)
    })
    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("5th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots5.toString)
    })
    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("6th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots6.toString)
    })
    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("7th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots7.toString)
    })
    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("8th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots8.toString)
    })
    view.columns += sfx2jfx(new TableColumn[SorcererTableData, String]("9th\nLevel\nSpell\nSlots") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.slots9.toString)
    })

    view.maxWidth = 615
    view
  }

}
