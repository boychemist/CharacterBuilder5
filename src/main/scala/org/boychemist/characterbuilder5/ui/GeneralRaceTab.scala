package org.boychemist.characterbuilder5.ui

import org.boychemist.characterbuilder5.races.Dnd5Race
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils.getFittedTextArea
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
    getFittedTextArea(theText, 500)
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
      val armor = getFittedTextArea(aRace.armorProficiencies.mkString("\n"), 150)
      grid.addRow(rowNum, armorLabel, armor)
      rowNum += 1
    }

    if (aRace.weaponProficiencies.nonEmpty) {
      val weaponsLabel = enhancedLabel("Weapon Proficiencies")
      val weapons = getFittedTextArea(aRace.weaponProficiencies.mkString("\n"), 90)
      grid.addRow(rowNum, weaponsLabel, weapons)
      rowNum += 1
    }

    if (aRace.toolsForProficiency.nonEmpty) {
      val toolsLabel = GeneralRaceTab.enhancedLabel("Tool Proficiency")
      val tools = getFittedTextArea(aRace.toolsForProficiency.head, 250)
      grid.addRow(rowNum, toolsLabel, tools)
      rowNum += 1
    }

    val languagesLabel = enhancedLabel(" Languages ")
    val languages = getFittedTextArea(aRace.languages.mkString("\n"), 100)
    grid.addRow(rowNum, languagesLabel, languages)
    rowNum += 1

    val adjustmentsLabel = enhancedLabel(" Ability Adjustments")
    val adjustmentTexts =
      aRace.abilityAdjustments.map(aa =>
        getFittedTextArea(" " + aa.ability.toString + ": +" + aa.amount + " ", 110)
      )
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
      border = CharacterBuilderUIutils.getBorder
      content = grid
    }
    thePane
  }

}
