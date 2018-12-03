package org.boychemist.characterbuilder5.ui.classes

import org.boychemist.characterbuilder5.dnd5classes.Dnd5Monk
import org.boychemist.characterbuilder5.dbInterface.DbClassInfo.getSpecializationNamesByClassName
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import org.boychemist.characterbuilder5.ui.FXUtils
import scalafx.Includes.handle
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer
import scalafx.geometry.Pos
import scalafx.scene.control._
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.text.{Font, FontWeight}
import slick.jdbc.JdbcBackend.Database
import scalafx.scene.control.TableColumn.{sfxTableColumn2jfx => sfx2jfx}

import scala.collection.mutable.ListBuffer

object MonkDisplay {

  def getMonkGrid(db: Database): ScrollPane = {
    val monkGrid = wideGrid4()
    monkGrid.style = "-fx-background-color: skyblue"
    monkGrid.vgap = 2
    var rowNum = 1


    val hitLabel = enhancedLabel(" Hit Die")
    val hit = easyTextField(Dnd5Monk.hitDice, 50)

    val armorLabel = enhancedLabel("Armor Proficiencies")
    val armor = easyTextField("None", 60)
    monkGrid.addRow(rowNum, hitLabel, hit, armorLabel, armor)
    rowNum += 1

    val weaponsLabel = enhancedLabel("Weapon Proficiencies")
    val weapons = variableTextArea(Dnd5Monk.weaponProficiencies.mkString("\n"), 120, 45)

    val savingThrowsLabel = enhancedLabel("Saving Throw Proficiencies")
    val savingThrows = variableTextArea(Dnd5Monk.savingThrowProficiencies.mkString("\n"), 100, 45)
    monkGrid.addRow(rowNum, weaponsLabel, weapons, savingThrowsLabel, savingThrows)
    rowNum += 1

    val labelNumberOfSkills = enhancedLabel("Number of Skills to Choose")
    val numberOfSkills = easyTextField(Dnd5Monk.numberOfSkills.toString)

    val labelSkillChoices = enhancedLabel("Skill Choices")
    val skillChoices = variableTextArea(Dnd5Monk.skillChoices.mkString("\n"), 100, 112)
    monkGrid.addRow(rowNum, labelNumberOfSkills, numberOfSkills, labelSkillChoices, skillChoices)
    rowNum += 1

    val toolProficiencyLabel = enhancedLabel("Tool Proficiency")
    val toolProficiency = variableTextArea(Dnd5Monk.toolProficiencies.mkString, 120, 80)
    monkGrid.addRow(rowNum, toolProficiencyLabel, toolProficiency)
    rowNum += 1

    val labelTraditionLevel = enhancedLabel("Monastic Tradition Choice Level")
    val chooseTraditionLevel = easyTextField(Dnd5Monk.specializationStartLevel.toString)

    val buttonList = new ListBuffer[Button]
    val specializationType = "Monastic Tradition"
    val labelTraditions = enhancedLabel(specializationType)
    val originsList = getSpecializationNamesByClassName(db, Dnd5Monk.classID.toString)
    val iterator = originsList.toIterator
    while (iterator.hasNext) {
      val specName = iterator.next()
      val specPane =
        ClassSpecializationDisplay.buildSpecializationGrid(db, specName)
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
    monkGrid.addRow(rowNum, labelTraditionLevel, chooseTraditionLevel, labelTraditions, buttonBox)
    rowNum += 1

    val classAbilitiesLabel = new Label(" Monk Abilities by Level") {
      font = Font.font("Sans Serif", FontWeight.Bold, 16)
    }
    monkGrid.add(classAbilitiesLabel, 1, rowNum, 4, 1)
    rowNum += 1

    val featureKeyIterator = Dnd5Monk.features.keysIterator
    while (featureKeyIterator.hasNext) {
      val level = featureKeyIterator.next
      val featureList = Dnd5Monk.features(level)
      val featureIter = featureList.toIterator
      while (featureIter.hasNext) {
        val feature = featureIter.next()
        monkGrid.addRow(rowNum, levelAndName(level, feature.name))
        add3ColTextArea(monkGrid, rowNum, feature.description)
        rowNum += 1
      }
    }

    // add a blank row
    monkGrid.addRow(rowNum, enhancedLabel(" "))
    rowNum += 1

    val centeredBox = new HBox {
      alignment = Pos.Center
      children = generateMonkTableView
    }

    monkGrid.add(centeredBox, 0, rowNum, 4, 1)

    val thePane = new ScrollPane {
      content = monkGrid
    }
    thePane

  }

  private case class MonkTableData(level: Int, martialArtsHit: String, kiPoints: Int, unarmoredMove: String)

  private def generateMonkTableData: ObservableBuffer[MonkTableData] = {
    val working = new ObservableBuffer[MonkTableData]
    for (i <- 1 to 20) {
      working += MonkTableData(i, Dnd5Monk.getMartialArtsHitDie(i), Dnd5Monk.getKiPointsForLevel(i),
        "+" + Dnd5Monk.getMovementBonus(i) + " ft")
    }
    working
  }

  private def generateMonkTableView: TableView[MonkTableData] = {
    val view = new TableView[MonkTableData](generateMonkTableData)
    view.editable = false
    view.columns += sfx2jfx(new TableColumn[MonkTableData, String]("Monk Level") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.level.toString)
    })

    view.columns += sfx2jfx(new TableColumn[MonkTableData, String]("Martial Arts\nHit Die") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.martialArtsHit)
    })

    view.columns += sfx2jfx(new TableColumn[MonkTableData, String]("Ki Points"){
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.kiPoints.toString)
    })

    view.columns += sfx2jfx(new TableColumn[MonkTableData, String]("Unarmored\nMovement\nBonus") {
      editable = false
      sortable = false
      cellValueFactory = cdf => StringProperty(cdf.value.unarmoredMove)
    })

    view.maxWidth = 555

    view
  }
}


