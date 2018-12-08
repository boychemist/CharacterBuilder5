package org.boychemist.characterbuilder5.ui.character

import scalafx.geometry.{HPos, Orientation, Pos}
import scalafx.scene.control.{ComboBox, ScrollPane, Tab, TextField}
import scalafx.scene.layout.{FlowPane, GridPane, HBox, Region}
import org.boychemist.characterbuilder5.{Dnd5Character, Dnd5RacesEnum}
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import scalafx.Includes.handle

import scala.collection.mutable.ListBuffer

object NewCharacterUI {

  private var needsInit = true

  def newCharacterTab(): Tab = {
    val pane = new ScrollPane {
      content = getTopLevelNewCharacterPane
    }

    val hdTab = new Tab {
      text = "New Character"
      content = pane
      onSelectionChanged = handle {
        if (needsInit) {
          Dnd5Character.editNewCharacter // create a new Dnd5Character instance that can be checked for changes
          LeftSide.resetEntries()
        }
        needsInit = !needsInit
        println(Dnd5Character.getWorkingCharacter.toString) // development debug
      }
    }
    hdTab
  }

  private def getRaceNames: List[Dnd5RacesEnum.Value] = {
    val racesList = new ListBuffer[Dnd5RacesEnum.Value]
    val raceIter = Dnd5RacesEnum.values.iterator
    while (raceIter.hasNext) {
      racesList += raceIter.next()
    }
    racesList.toList
  }

  private def getTopLevelNewCharacterPane = {
    val leftSide = LeftSide.pane
    val rightSide = new FlowPane() {
      orientation = Orientation.Vertical
      columnHalignment = HPos.Left
    }

    val theBox = new HBox {
      children = List(leftSide, rightSide)
    }
    theBox
  }

  object LeftSide {
    private val nameIn = new TextField {
      promptText = "Enter the character's name"
      maxWidth = 500
      minWidth = 160
      text.onChange((_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.name = newVal.toString)
    }

    private val raceIn = new ComboBox[Dnd5RacesEnum.Value](getRaceNames) {
      promptText = "Select a race"
      editable = false
      value.onChange((_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.race = newVal)
    }

    private val strengthModifier = new TextField{
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.strengthModifier.toString
    }

    val strength: TextField = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.strength.toString
      text.onChange { (_, _, newVal) =>
        {
          var checkVar = newVal.toString
          if (!checkVar.matches("""\d*""")) {
            checkVar = checkVar.replaceAll("""[^\d]""", "")
          }
          text = checkVar
          if (checkVar.length > 0)
            Dnd5Character.getWorkingCharacter.strength = checkVar.toInt
          strengthModifier.text = Dnd5Character.getWorkingCharacter.strengthModifier.toString
        }
      }
    }

    private val constitutionModifier = new TextField{
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.constitutionModifier.toString
    }

    val constitution:TextField = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.constitution.toString
      text.onChange { (_, _, newVal) =>
        {
          var checkVar = newVal.toString
          if (!checkVar.matches("""\d*""")) {
            checkVar = checkVar.replaceAll("""[^\d]""", "")
          }
          text = checkVar
          if (checkVar.length > 0)
            Dnd5Character.getWorkingCharacter.constitution = checkVar.toInt
          constitutionModifier.text = Dnd5Character.getWorkingCharacter.constitutionModifier.toString
        }
      }
    }

    private val dexterityModifier = new TextField{
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.dexterityModifier.toString
    }

    val dexterity: TextField = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.dexterity.toString
      text.onChange { (_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.dexterity = newVal.toInt
        dexterityModifier.text = Dnd5Character.getWorkingCharacter.dexterityModifier.toString
      }
    }

    private val intelligenceModifier = new TextField{
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.intelligenceModifier.toString
    }

    val intelligence: TextField  = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.intelligence.toString
      text.onChange { (_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.intelligence = newVal.toInt
        intelligenceModifier.text = Dnd5Character.getWorkingCharacter.intelligenceModifier.toString
      }
    }

    private val wisdomModifier = new TextField{
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.wisdomModifier.toString
    }

    val wisdom: TextField  = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.wisdom.toString
      text.onChange { (_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.wisdom = newVal.toInt
        wisdomModifier.text = Dnd5Character.getWorkingCharacter.wisdomModifier.toString
      }
    }

    private val charismaModifier = new TextField{
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.charismaModifier.toString
    }

    val charisma: TextField  = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.charisma.toString
      text.onChange { (_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.charisma = newVal.toInt
        charismaModifier.text = Dnd5Character.getWorkingCharacter.charismaModifier.toString
      }
    }

    val pane:GridPane = buildLeftSide

    private def buildLeftSide: GridPane = {
      val leftSide = new GridPane {
        maxWidth = 700
        vgap = 2
        hgap = 2
        style = "-fx-background-color: cyan"
      }
      var leftRowNum = 0

      leftSide.addRow(leftRowNum, enhancedLabel("Character Name"), nameIn)
      leftRowNum += 1

      leftSide.addRow(leftRowNum, enhancedLabel("Race"), raceIn)
      GridPane.setHalignment(raceIn, HPos.Center)
      leftRowNum += 1

      val abilityGrid = new GridPane {
        maxWidth = 500
        vgap = 2
        hgap = 2
      }
      var abilityRow = 0

      val abilityLabel = enhancedLabel("Abilty Scores")
      val modifierLabel = enhancedLabel("Modifiers")
      abilityGrid.add(abilityLabel, 1, abilityRow)
      abilityGrid.add(modifierLabel, 2, abilityRow)
      abilityRow += 1

      abilityGrid.addRow(abilityRow, enhancedLabel("Strength"), strength, strengthModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow, enhancedLabel("Constitution"), constitution, constitutionModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow, enhancedLabel("Dexterity"), dexterity, dexterityModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow, enhancedLabel("Intelligence"), intelligence, intelligenceModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow, enhancedLabel("Wisdom"), wisdom, wisdomModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow, enhancedLabel("Charisma"), charisma, charismaModifier)

      leftSide.add(abilityGrid, 0, leftRowNum, 2, 1)

      /* *************** not needed during character construction, kept for example of how to solve the problem */
      //    val charLevel = new TextField {
      //      maxWidth = 40
      //      prefWidth = 35
      //      minWidth = 30
      //      maxHeight = Region.USE_COMPUTED_SIZE
      //      text = Dnd5Character.getWorkingCharacter.characterLevel.toString
      //    }
      //    charLevel.text.onChange { (obs, oldVal, newVal) =>
      //      {
      //        var checkVar = newVal
      //        if (!newVal.toString.matches("""\d*""""))
      //          checkVar = newVal.toString.replaceAll("""[^\d]""", "")
      //          charLevel.text = checkVar
      //        if (checkVar.length > 0)
      //          Dnd5Character.getWorkingCharacter.characterLevel = checkVar.toInt
      //        if (Dnd5Character.getWorkingCharacter.characterLevel > 20) {
      //          charLevel.text = "20"
      //          Dnd5Character.getWorkingCharacter.characterLevel = 20
      //        }
      //      }
      //    }
      //    leftSide.addRow(leftRowNum, enhancedLabel("Character Level"), charLevel)
      //    leftRowNum += 1

      leftSide
    }

    def resetEntries(): Unit = {
      nameIn.text = ""
      raceIn.value = null
      strength.text = Dnd5Character.getWorkingCharacter.strength.toString
      constitution.text =
        Dnd5Character.getWorkingCharacter.constitution.toString
      dexterity.text = Dnd5Character.getWorkingCharacter.dexterity.toString
      intelligence.text =
        Dnd5Character.getWorkingCharacter.intelligence.toString
      wisdom.text = Dnd5Character.getWorkingCharacter.wisdom.toString
      charisma.text = Dnd5Character.getWorkingCharacter.charisma.toString
    }
  }
}
