package org.boychemist.characterbuilder5.ui.races

import org.boychemist.characterbuilder5.races.Dnd5Race
import scalafx.scene.control.{Label, Tab, TextArea, TextField}
import scalafx.scene.layout.{GridPane, VBox}
import scalafx.scene.text.Font

/**
  * Creates a tab containing the information about dwarves.  Takes the specific dwarf class as an argument.
  */
object Dwarf {

  def dwarfTab(dwarfRace: Dnd5Race): Tab =
  {
    val name = dwarfRace.race.toString
    val grid = new GridPane()
    var rowNum = 1

    val sizeLabel = new Label(" Size ")
    val size = new TextField {
      text = dwarfRace.size.toString
      editable = false
      maxWidth = 80
    }
    grid.addRow(rowNum, sizeLabel)
    grid.addRow(rowNum, size)
    rowNum += 1

    val speedLabel = new Label(" Base Speed ")
    val speed = new TextField {
      text = "" + dwarfRace.baseSpeed
      editable = false
      maxWidth = 30
    }
    grid.addRow(rowNum, speedLabel)
    grid.addRow(rowNum, speed)
    rowNum += 1

    if (dwarfRace.armorProficiencies.nonEmpty) {
      val armorLabel = new Label("Armor Proficiencies")
      val armor = new TextArea {
        text = dwarfRace.armorProficiencies.mkString("\n")
        editable = false
        maxHeight = 45
        editable = false
        maxWidth = 150
        wrapText = true
      }
      grid.addRow(rowNum, armorLabel)
      grid.addRow(rowNum, armor)
      rowNum += 1
    }

    val toolsLabel = new Label("Tool Proficiency")
    val tools = new TextArea {
      text = dwarfRace.toolsForProficiency.head
      editable = false
      maxHeight = 90
      editable = false
      maxWidth = 200
      wrapText = true
    }
    tools.autosize()
    rowNum += 1

    val languagesLabel = new Label(" Languages ")
    val languages = new TextArea {
      text = dwarfRace.languages.mkString("\n")
      editable = false
      maxHeight = 45
      maxWidth = 100
    }
    grid.addRow(rowNum, languagesLabel)
    grid.addRow(rowNum, languages)
    rowNum += 1

    val adjustmentsLabel = new Label(" Ability Adjustments")
    val adjustmentTexts =
      dwarfRace.abilityAdjustments.map(aa => new TextField {
      text = " " + aa.ability.toString + ": +" + aa.amount + " "
      editable = false
    })
    val adjustmentsBox =
    new VBox {
      children = adjustmentTexts
      spacing = 2
    }
    grid.addRow(rowNum, adjustmentsLabel)
    grid.addRow(rowNum, adjustmentsBox)
    rowNum += 1

    val racialAbilitiesLabel = new Label(" Racial Abilities ") {
      font = new Font(18)
    }
    grid.add(racialAbilitiesLabel, 1, rowNum, 2, 1)
    rowNum += 1

    val raIter =
      dwarfRace.racialAbilities.iterator
    while (raIter.hasNext) {
      val anAbility = raIter.next()
      val label = new Label(" " + anAbility.abilityName + " ")
      val desc = new TextArea() {
        text = anAbility.description
        editable = false
        maxWidth = 200
        maxHeight = 150
        wrapText = true
      }
      grid.addRow(rowNum, label)
      grid.addRow(rowNum, desc)
      rowNum += 1
    }

    val hdTab = new Tab {
      text = name
    }
    hdTab.content = grid
    hdTab
  }


}
