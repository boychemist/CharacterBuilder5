package org.boychemist.characterbuilder5.ui.races

import org.boychemist.characterbuilder5.races.Dnd5Race
import scalafx.geometry.Pos
import scalafx.scene.control.{Label, Tab, TextArea, TextField}
import scalafx.scene.layout.{HBox, VBox}
import scalafx.scene.text.Font

import scala.collection.mutable.ListBuffer

/**
  * Creates a tab containing the information about hill dwarves.
  */
object Dwarf {

  def dwarfTab(dwarfRace: Dnd5Race): Tab =
  {
    val name = dwarfRace.race.toString
    val hboxList = new ListBuffer[HBox]

    val sizeLabel = new Label(" Size ")
    val size = new TextField {
      text = dwarfRace.size.toString
      editable = false
      maxWidth = 80
    }
    hboxList += new HBox{
      children = List(sizeLabel, size)
    }

    val speedLabel = new Label(" Base Speed ")
    val speed = new TextField {
      text = "" + dwarfRace.baseSpeed
      editable = false
      maxWidth = 30
    }
    hboxList += new HBox{
      children = List(speedLabel, speed)
    }
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
      hboxList += new HBox {
        children = List(armorLabel, armor)
      }
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
    hboxList += new HBox {
      children = List(toolsLabel, tools)
    }

    val languagesLabel = new Label(" Languages ")
    val languages = new TextArea {
      text = dwarfRace.languages.mkString("\n")
      editable = false
      maxHeight = 45
      maxWidth = 100
    }
    hboxList += new HBox{
      children = List(languagesLabel, languages)
    }

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
    hboxList += new HBox {
      children = List(adjustmentsLabel, adjustmentsBox)
    }

    val racialAbilitiesLabel = new Label(" Racial Abilities ") {
      font = new Font(18)
    }
    hboxList += new HBox{
      children = racialAbilitiesLabel
      alignment = Pos.Center
    }

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
      hboxList += new HBox{
         children = List(label, desc)
      }
    }

    val hdTab = new Tab {
      text = name
    }
    hdTab.content = new VBox{
      children = hboxList.toList
      spacing = 3.0
    }
    val content = hdTab.delegate.getContent
    hdTab
  }


}
