package org.boychemist.characterbuilder5.ui.races

import org.boychemist.characterbuilder5.races.Dnd5Race
import scalafx.scene.control._
import scalafx.scene.layout.{GridPane, VBox}
import scalafx.scene.text.Font

object Elf {

  def elfTab(elfRace: Dnd5Race): Tab =
  {
    val grid = new GridPane()
    var rowNum = 1

    val sizeLabel = new Label(" Size ")
    val size = new TextField {
      text = elfRace.size.toString
      editable = false
      maxWidth = 80
    }
    grid.addRow(rowNum, sizeLabel)
    grid.addRow(rowNum, size)
    rowNum += 1

    val speedLabel = new Label(" Base Speed ")
    val speed = new TextField {
      text = "" + elfRace.baseSpeed
      editable = false
      maxWidth = 30
    }
    grid.addRow(rowNum, speedLabel)
    grid.addRow(rowNum, speed)
    rowNum += 1

    val weaponsLabel = new Label("Weapon Proficiencies")
    val weapons = new TextArea {
      text = elfRace.weaponProficiencies.mkString("\n")
      editable = false
      maxHeight = 80
      editable = false
      maxWidth = 90
      wrapText = true
    }
    grid.addRow(rowNum, weaponsLabel)
    grid.addRow(rowNum, weapons)
    rowNum += 1

    val languagesLabel = new Label(" Languages ")
    val languages = new TextArea {
      text = elfRace.languages.mkString("\n")
      editable = false
      maxHeight = 45
      maxWidth = 100
    }
    grid.addRow(rowNum, languagesLabel)
    grid.addRow(rowNum, languages)
    rowNum += 1

    val adjustmentsLabel = new Label(" Ability Adjustments")
    val adjustmentTexts =
      elfRace.abilityAdjustments.map(aa => new TextField {
        text = " " + aa.ability.toString + ": +" + aa.amount + " "
        editable = false
        maxWidth = 110
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
      elfRace.racialAbilities.iterator
    while (raIter.hasNext) {
      val anAbility = raIter.next()
      val label = new Label(" " + anAbility.abilityName + " ")
      val desc = new TextArea() {
        text = anAbility.description
        editable = false
        maxWidth = 250
        maxHeight = 110
        wrapText = true
      }
      grid.addRow(rowNum, label)
      grid.addRow(rowNum, desc)
      rowNum += 1
    }

    val hdTab = new Tab {
      text = elfRace.race.toString
    }
    hdTab.content = new ScrollPane {
      content = grid
    }
    hdTab
  }
}
