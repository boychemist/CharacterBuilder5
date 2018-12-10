package org.boychemist.characterbuilder5.ui.character

import org.boychemist.characterbuilder5.races.Dnd5Dragonborn
import scalafx.geometry.{HPos, Orientation, Pos}
import scalafx.scene.control._
import scalafx.scene.layout._
import org.boychemist.characterbuilder5.{Dnd5Character, Dnd5RacesEnum, DndAlignmentEnum}
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import org.boychemist.characterbuilder5.ui.FXUtils
import scalafx.Includes.handle
import scalafx.scene.Node

import scala.collection.mutable.{MutableList => mList}
import scala.collection.mutable.ListBuffer

object NewCharacterUI {

  private var needsInit = true

  def newCharacterTab(): Tab = {
    val pane = new ScrollPane {
      border = getBorder
      content = getTopLevelNewCharacterPane
      style = "-fx-background-color: cyan"
    }

    val hdTab = new Tab {
      text = "New Character"
      content = pane
      onSelectionChanged = handle {
        if (needsInit) {
          Dnd5Character.editNewCharacter // create a new Dnd5Character instance that can be checked for changes
          LeftSide.resetEntries()
          resetRightSide
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

  private def getAlignments: List[DndAlignmentEnum.Value] = {
    val alignmentsList = new ListBuffer[DndAlignmentEnum.Value]
    val alignmentIter = DndAlignmentEnum.values.iterator
    while (alignmentIter.hasNext) {
      alignmentsList += alignmentIter.next()
    }
    alignmentsList.toList
  }

  private def getTopLevelNewCharacterPane = {
    val leftSide = LeftSide.pane
    val rightSide = generateRightSide

    val theBox = new HBox(10) {
      children = List(leftSide, rightSide)
      style = "-fx-background-color: red"
    }
    theBox
  }

  val classChooser = new Button("Choose Class") {
    disable = true  // can't set HP until abilities adjusted for race
  }   // todo add dialog windows (and set HP)

  val racialFeatures: Button = new Button("Set Racial Features") {// todo add dialog, disable race select
    disable = true // enable when race selected
    onAction = handle {
      LeftSide.raceIn.disable = true
      setRaceOneTimeValues(Dnd5Character.getWorkingCharacter.race)
      racialFeatures.disable = true
      classChooser.disable = true
    }
  }

  val racialAbilities = new Button("Add Racial Ability Adjustments") {
    disable = true
    onAction = handle {
      classChooser.disable = false
      // todo add dialog window (enable choosing class)
      disable = true
    }
  }

  private def resetRightSide: Unit = {
    racialFeatures.disable = true
    racialAbilities.disable = true
  }

  private def generateRightSide: FlowPane = {
    val theChildren = new mList[Node]

    val abilityList = new Button("From List") {
      onAction = handle {
        FXUtils.onFXAndWait(
          FXUtils.showDialogPane("Ability Scores from List",
                                 AbilitiesFromListPanel.abilitiesFromListPane))
      }
    }
    val abilityPoints = new Button("From Points") {
      onAction = handle {
        FXUtils.onFXAndWait(
          FXUtils.showDialogPane("Ability Scores from Points",
                                 AbilitiesFromPoints.abilitiesFromPointsPanel))
      }
    }
    theChildren += new VBox {
      alignment = Pos.Center
      children = List(enhancedLabel("Set Ability Scores"), new HBox(5) {
        alignment = Pos.Center
        children = List(abilityList, abilityPoints)
      })
    }

    theChildren += new Separator {
      orientation = Orientation.Horizontal
      style = "-fx-background-color: black"
    }

    theChildren += new HBox(5) {
      alignment = Pos.Center
      children = List(racialFeatures, classChooser)
    }

    theChildren += racialAbilities


    val fPane = new FlowPane(Orientation.Vertical, 5, 3) {
      border = getBorder
      columnHalignment = HPos.Center
      children = theChildren.toList
      style = "-fx-background-color: cyan"
    }

    fPane
  }

  /**
    * Adds all racial features to the character except the ability bonuses
    *
    * @param raceId of the race which was chosen
    */
  private def setRaceOneTimeValues(raceId: Dnd5RacesEnum.Value): Unit = {
    val raceInfo = Dnd5Character.getRaceDescription(raceId)
    val workingChar = Dnd5Character.getWorkingCharacter
    if (raceInfo.weaponProficiencies.nonEmpty)
      workingChar.weaponProficiencies = workingChar.weaponProficiencies ++ raceInfo.weaponProficiencies
    if (raceInfo.armorProficiencies.nonEmpty)
      workingChar.armorProficiencies = workingChar.armorProficiencies ++ raceInfo.armorProficiencies
    if (raceInfo.languages.nonEmpty)
      workingChar.languages = workingChar.languages ++ raceInfo.languages
    raceId match {
      case Dnd5RacesEnum.MountainDwarf => println("Mountain Dwarf -- choose tool") // need to invoke the proper dialog for the cases
      case Dnd5RacesEnum.HillDwarf => println("Hill Dwarf -- choose tool")
      case Dnd5RacesEnum.HighElf => println("HighElf -- choose 1 language")
      case Dnd5RacesEnum.Human => println("Human -- choose 1 language")
      case Dnd5RacesEnum.DragonBorn => println("Dragonborn -- choose ancestry")
      case Dnd5RacesEnum.HalfElf => println("Half-Elf -- choose 1 language")
      case _ => val x = 0
    }
  }

  object LeftSide {
    private val nameIn = new TextField {
      promptText = "Enter the character's name"
      maxWidth = 500
      minWidth = 160
      text.onChange((_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.name = newVal.toString)
    }

    private val charSpeed = easyTextField("")

    private val charSize = easyTextField("", 70)

    val raceIn: ComboBox[Dnd5RacesEnum.Value] = new ComboBox[Dnd5RacesEnum.Value](getRaceNames) {
      promptText = "Select a race"
      editable = false
      value.onChange((_, _, newVal) => {
        Dnd5Character.getWorkingCharacter.race = newVal
        Dnd5Character.getWorkingCharacter.addRacialBasicAbilities()
        charSpeed.text = Dnd5Character.getWorkingCharacter.speed.toString
        charSize.text = Dnd5Character.getWorkingCharacter.size.toString
        NewCharacterUI.racialFeatures.disable = false
        NewCharacterUI.racialAbilities.disable = false
      })
    }

    private val alignmentIn =
      new ComboBox[DndAlignmentEnum.Value](getAlignments) {
        promptText = "Select an alignment"
        editable = false
        value.onChange((_, _, newVal) => {
          Dnd5Character.getWorkingCharacter.alignment = newVal
        })
      }

    private val strengthModifier = new TextField {
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
          strengthModifier.text =
            Dnd5Character.getWorkingCharacter.strengthModifier.toString
        }
      }
    }

    private val constitutionModifier = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.constitutionModifier.toString
    }

    val constitution: TextField = new TextField {
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
          constitutionModifier.text =
            Dnd5Character.getWorkingCharacter.constitutionModifier.toString
        }
      }
    }

    private val dexterityModifier = new TextField {
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
        dexterityModifier.text =
          Dnd5Character.getWorkingCharacter.dexterityModifier.toString
      }
    }

    private val intelligenceModifier = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.intelligenceModifier.toString
    }

    val intelligence: TextField = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.intelligence.toString
      text.onChange { (_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.intelligence = newVal.toInt
        intelligenceModifier.text =
          Dnd5Character.getWorkingCharacter.intelligenceModifier.toString
      }
    }

    private val wisdomModifier = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.wisdomModifier.toString
    }

    val wisdom: TextField = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.wisdom.toString
      text.onChange { (_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.wisdom = newVal.toInt
        wisdomModifier.text =
          Dnd5Character.getWorkingCharacter.wisdomModifier.toString
      }
    }

    private val charismaModifier = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.charismaModifier.toString
    }

    val charisma: TextField = new TextField {
      maxWidth = 40
      prefWidth = 35
      minWidth = 30
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      text = Dnd5Character.getWorkingCharacter.charisma.toString
      text.onChange { (_, _, newVal) =>
        Dnd5Character.getWorkingCharacter.charisma = newVal.toInt
        charismaModifier.text =
          Dnd5Character.getWorkingCharacter.charismaModifier.toString
      }
    }

    val charClass: TextField = new TextField {
      maxWidth = 70
      prefWidth = 65
      minWidth = 60
      maxHeight = Region.USE_COMPUTED_SIZE
      alignment = Pos.Center
      editable = false
      promptText = "Not Chosen"
    }

    val classSpecialization: TextField = easyTextField("", 70)
    val classSpecializationLabel: Label = enhancedLabel("Specialization")

    val pane: GridPane = buildLeftSide

    private def buildLeftSide: GridPane = {
      val leftSide = new GridPane {
        border = getBorder
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

      leftSide.addRow(leftRowNum, enhancedLabel("Speed"), charSpeed)
      leftRowNum += 1

      leftSide.addRow(leftRowNum, enhancedLabel("Size"), charSize)
      leftRowNum += 1

      leftSide.addRow(leftRowNum, enhancedLabel("Alignment"), alignmentIn)
      leftRowNum += 1

      leftSide.addRow(leftRowNum, enhancedLabel("Character Class"), charClass)
      leftRowNum += 1

      leftSide.addRow(leftRowNum, classSpecializationLabel, classSpecialization)
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

      abilityGrid.addRow(abilityRow,
                         enhancedLabel("Strength"),
                         strength,
                         strengthModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow,
                         enhancedLabel("Constitution"),
                         constitution,
                         constitutionModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow,
                         enhancedLabel("Dexterity"),
                         dexterity,
                         dexterityModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow,
                         enhancedLabel("Intelligence"),
                         intelligence,
                         intelligenceModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow,
                         enhancedLabel("Wisdom"),
                         wisdom,
                         wisdomModifier)
      abilityRow += 1

      abilityGrid.addRow(abilityRow,
                         enhancedLabel("Charisma"),
                         charisma,
                         charismaModifier)

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
      raceIn.disable = false
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
