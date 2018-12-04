package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.races.Dnd5Race
import scalafx.scene.control._
import scalafx.scene.layout.{ColumnConstraints, GridPane, VBox}
import scalafx.scene.text.{Font, FontWeight}

object GeneralRaceTab {

  def enhancedLabel(text: String): Label = {
    val aLabel = new Label(text) {
      font = Font.font("Sans Serif", FontWeight.Bold, 12)
    }
    aLabel
  }

  def wideGrid(): GridPane = {
    val col1Constraints = new ColumnConstraints {
      percentWidth = 20
    }
    val col2Constraints = new ColumnConstraints {
      percentWidth = 80
    }
    val theGrid = new GridPane() {
      columnConstraints = List(col1Constraints, col2Constraints)
      minWidth = 700
      maxWidth = 1000
      minHeight = 650
    }
    theGrid
  }

  def wideTextArea(theText: String): TextArea = {
    val textArea = new TextArea() {
      text = theText
      editable = false
      maxWidth = 500
      maxHeight = 75
      wrapText = true
    }
    textArea
  }

  def raceTab(aRace: Dnd5Race): Tab = {

    val hdTab = new Tab {
      text = aRace.race.toString
    }
    hdTab.content = raceScrollPane(aRace)
    hdTab
  }

  def raceScrollPane(aRace: Dnd5Race): ScrollPane = {
    val grid = wideGrid()
    grid.style = "-fx-background-color: skyblue"
    grid.vgap = 2
    var rowNum = 1

    val sizeLabel = enhancedLabel(" Size ")
    val size = new TextField {
      text = aRace.size.toString
      editable = false
      maxWidth = 80
    }
    grid.addRow(rowNum, sizeLabel)
    grid.addRow(rowNum, size)
    rowNum += 1

    val speedLabel = enhancedLabel(" Base Speed ")
    val speed = new TextField {
      text = "" + aRace.baseSpeed
      editable = false
      maxWidth = 30
    }
    grid.addRow(rowNum, speedLabel)
    grid.addRow(rowNum, speed)
    rowNum += 1

    if (aRace.armorProficiencies.nonEmpty) {
      val armorLabel = GeneralRaceTab.enhancedLabel("Armor Proficiencies")
      val armor = new TextArea {
        text = aRace.armorProficiencies.mkString("\n")
        editable = false
        maxHeight = 45
        editable = false
        maxWidth = 150
        wrapText = true
      }
      grid.addRow(rowNum, armorLabel, armor)
      rowNum += 1
    }

    if (aRace.weaponProficiencies.nonEmpty) {
      val weaponsLabel = enhancedLabel("Weapon Proficiencies")
      val weapons = new TextArea {
        text = aRace.weaponProficiencies.mkString("\n")
        editable = false
        maxHeight = 80
        editable = false
        maxWidth = 90
        wrapText = true
      }
      grid.addRow(rowNum, weaponsLabel, weapons)
      rowNum += 1
    }

    if (aRace.toolsForProficiency.nonEmpty) {
      val toolsLabel = GeneralRaceTab.enhancedLabel("Tool Proficiency")
      val tools = new TextArea {
        text = aRace.toolsForProficiency.head
        editable = false
        maxHeight = 60
        editable = false
        maxWidth = 250
        wrapText = true
      }
      grid.addRow(rowNum, toolsLabel, tools)
      rowNum += 1
    }

    val languagesLabel = enhancedLabel(" Languages ")
    val languages = new TextArea {
      text = aRace.languages.mkString("\n")
      editable = false
      maxHeight = 45
      maxWidth = 100
    }
    grid.addRow(rowNum, languagesLabel, languages)
    rowNum += 1

    val adjustmentsLabel = enhancedLabel(" Ability Adjustments")
    val adjustmentTexts =
      aRace.abilityAdjustments.map(aa =>
        new TextField {
          text = " " + aa.ability.toString + ": +" + aa.amount + " "
          editable = false
          maxWidth = 110
      })
    val adjustmentsBox =
      new VBox {
        children = adjustmentTexts
        spacing = 2
      }
    grid.addRow(rowNum, adjustmentsLabel, adjustmentsBox)
    rowNum += 1

    if (aRace.racialAbilities.nonEmpty) {
      val racialAbilitiesLabel = new Label(" Racial Abilities ") {
        font = Font.font("Sans Serif", FontWeight.Bold, 16)
      }
      grid.add(racialAbilitiesLabel, 1, rowNum, 2, 1)
      rowNum += 1

      val raIter =
        aRace.racialAbilities.iterator
      while (raIter.hasNext) {
        val anAbility = raIter.next()
        val label = enhancedLabel(" " + anAbility.abilityName + " ")
        val desc = wideTextArea(anAbility.description)
        grid.addRow(rowNum, label, desc)
        rowNum += 1
      }
    }

    val thePane = new ScrollPane {
      content = grid
    }
    thePane
  }

}
