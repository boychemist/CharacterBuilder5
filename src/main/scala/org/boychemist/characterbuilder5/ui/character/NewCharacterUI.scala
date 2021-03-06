package org.boychemist.characterbuilder5.ui.character

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.races.AbilityAdjustment
import org.boychemist.characterbuilder5.ui.CharacterBuilderUIutils._
import org.boychemist.characterbuilder5.ui.FXUtils
import scalafx.Includes.handle
import scalafx.geometry.{HPos, Orientation, Pos}
import scalafx.scene.Node
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control._
import scalafx.scene.layout._
import org.boychemist.characterbuilder5.dbInterface.DbBackgroundInfo

import scala.collection.mutable.{ListBuffer, MutableList => mList}

object NewCharacterUI {

  private var needsInit = true

  def newCharacterTab(): Tab = {
    val pane = new ScrollPane {
      border = getBorder
      content = getTopLevelNewCharacterPane
      style = "-fx-background-color: linen"
    }

    val hdTab = new Tab {
      text = "New Character"
      content = pane
      onSelectionChanged = handle {
        if (needsInit) {
          Dnd5Character.editNewCharacter // create a new Dnd5Character instance that can be checked for changes
          LeftSide.resetEntries()
          resetRightSide()
        }
        needsInit = !needsInit
        println(Dnd5Character.getWorkingCharacter.toString) // development debug todo remove for production
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

  // to ensure racial dialogs provide the necessary choices before making other changes
  var choiceMade: Boolean = false

  private def getTopLevelNewCharacterPane = {
    val leftSide = LeftSide.pane
    val rightSide = generateRightSide

    val theBox: HBox = new HBox(5) {
      children = List(leftSide, rightSide)
      style = "-fx-background-color: linen"
    }
    theBox
  }

  val classChooser: Button = new Button("Choose Class") {
    disable = true // can't set HP until abilities adjusted for race
  } // todo add dialog windows (and set HP)

  private def resetRightSide(): Unit = {
    racialFeatures.disable = true
    racialAbilities.disable = true
    abilityList.disable = false
    abilityPoints.disable =false
  }

  def abilityPointsReadyForUpdate(
      workingCharacter: Dnd5Character): (Boolean, Int) = {
    // ability point cost for all abilities must equal 27 for success
    var totalAbilityCost = costForAbilityScore(workingCharacter.strength)
    totalAbilityCost += costForAbilityScore(workingCharacter.dexterity)
    totalAbilityCost += costForAbilityScore(workingCharacter.constitution)
    totalAbilityCost += costForAbilityScore(workingCharacter.intelligence)
    totalAbilityCost += costForAbilityScore(workingCharacter.wisdom)
    totalAbilityCost += costForAbilityScore(workingCharacter.charisma)

    (totalAbilityCost == AbilitiesFromPoints.maxPointsToSpend, totalAbilityCost)
  }

  private def costForAbilityScore(theAbility: Int): Int = {
    import AbilitiesFromPoints.abilityCostMap
    if (theAbility > 15) // above range, make very expensive
      15
    else if (theAbility < 8) // below range, make very cheap (should not be possible in app)
      -5
    else
      abilityCostMap(theAbility)
  }

  private def addRaceAbilityAdjustments(): Boolean = {
    val workingCharacter = Dnd5Character.getWorkingCharacter
    val (isReady, totalCost) = abilityPointsReadyForUpdate(workingCharacter)
    if (isReady) {
      if (Dnd5Character.getWorkingCharacter.race == Dnd5RacesEnum.HalfElf) {
        choiceMade = false
        FXUtils.onFXAndWait(
          FXUtils.showDialogPane(
            new HalfElfChoicesPanel().getHalfElfAbilityChoices))
        if (!choiceMade) {
          new Alert(AlertType.Warning) {
            initOwner(DndBuilder.stage)
            title = "Warning Dialog"
            headerText = "Unable to Make Racial Adjustment to Abilities"
            contentText = "You must choose two additional abilities"
          }.showAndWait()
          racialAbilities.disable = false
          return false
        }
      }
      val raceInfo = Dnd5Character.getRaceDescription(workingCharacter.race)
      val raceAdjustments = raceInfo.abilityAdjustments
      for (adjustment: AbilityAdjustment <- raceAdjustments) {
        adjustment.ability match {
          case DndAbilitiesEnum.Strength =>
            LeftSide.strength.text =
              (workingCharacter.strength + adjustment.amount).toString
          case DndAbilitiesEnum.Dexterity =>
            LeftSide.dexterity.text =
              (workingCharacter.dexterity + adjustment.amount).toString
          case DndAbilitiesEnum.Constitution =>
            LeftSide.constitution.text =
              (workingCharacter.constitution + adjustment.amount).toString
          case DndAbilitiesEnum.Intelligence =>
            LeftSide.intelligence.text =
              (workingCharacter.intelligence + adjustment.amount).toString
          case DndAbilitiesEnum.Wisdom =>
            LeftSide.wisdom.text =
              (workingCharacter.wisdom + adjustment.amount).toString
          case DndAbilitiesEnum.Charisma =>
            LeftSide.charisma.text =
              (workingCharacter.charisma + adjustment.amount).toString
        }
      }
    } else {
      // either abilities not set or already modified
      if (totalCost < AbilitiesFromPoints.maxPointsToSpend) {
        new Alert(AlertType.Warning) {
          initOwner(DndBuilder.stage)
          title = "Warning Dialog"
          headerText = "Unable to Make Racial Adjustment to Abilities"
          contentText = "Base Ability values have not been chosen"
        }.showAndWait()
      } else {
        new Alert(AlertType.Warning) {
          initOwner(DndBuilder.stage)
          title = "Warning Dialog"
          headerText = "Unable to Make Racial Adjustment to Abilities"
          contentText = "Ability values have already been modified"
        }.showAndWait()
      }
    }
    isReady
  }

  /**
    * Adds all racial features to the character except the ability bonuses
    *
    * @param raceId of the race which was chosen
    */
  private def setRaceOneTimeValues(raceId: Dnd5RacesEnum.Value): Unit = {
    val raceInfo = Dnd5Character.getRaceDescription(raceId)
    val workingChar = Dnd5Character.getWorkingCharacter
    choiceMade = false
    raceId match {
      case Dnd5RacesEnum.MountainDwarf =>
        FXUtils.onFXAndWait(
          FXUtils.showDialogPane(ToolChoicePanel.dwarfToolChoicePanel(workingChar)))
      case Dnd5RacesEnum.HillDwarf =>
        FXUtils.onFXAndWait(
          FXUtils.showDialogPane(ToolChoicePanel.dwarfToolChoicePanel(workingChar)))
      case Dnd5RacesEnum.HighElf =>
        FXUtils.onFXAndWait(
          FXUtils.showDialogPane(
            LanguageChoicesPanel.getLanguageChoicePane(workingChar)))
      case Dnd5RacesEnum.Human =>
        FXUtils.onFXAndWait(
          FXUtils.showDialogPane(
            LanguageChoicesPanel.getLanguageChoicePane(workingChar)))
      case Dnd5RacesEnum.DragonBorn =>
        FXUtils.onFXAndWait(
          FXUtils.showDialogPane(
            DraconicAncestryChoicePanel().getDraconicAncestryChoicePanel))
      case Dnd5RacesEnum.HalfElf =>
        FXUtils.onFXAndWait(
          FXUtils.showDialogPane(
            new HalfElfChoicesPanel().getHalfElfChoices(workingChar)))

      case _ => choiceMade = true
    }
    if (!choiceMade) {
      new Alert(AlertType.Warning) {
        initOwner(DndBuilder.stage)
        title = "Warning Dialog"
        headerText = "Selection Not Made"
        contentText = "You did not choose the race options for your character"
      }.showAndWait()
      LeftSide.raceIn.disable = false
      return
    }
    if (raceInfo.weaponProficiencies.nonEmpty)
      workingChar.weaponProficiencies = workingChar.weaponProficiencies ++ raceInfo.weaponProficiencies
    if (raceInfo.armorProficiencies.nonEmpty)
      workingChar.armorProficiencies = workingChar.armorProficiencies ++ raceInfo.armorProficiencies
    if (raceInfo.languages.nonEmpty)
      workingChar.languages = raceInfo.languages ++ workingChar.languages
    workingChar.racialFeaturesAddedToLists = true
  }

  val racialFeatures: Button = new Button("Set Racial Features") {
    disable = true // enable when race selected
    onAction = handle {
      LeftSide.raceIn.disable = true
      setRaceOneTimeValues(Dnd5Character.getWorkingCharacter.race)
      racialFeatures.disable = choiceMade
      classChooser.disable = true
    }
  }

  private val abilityList = new Button("From List") {
    onAction = handle {
      FXUtils.onFXAndWait(
        FXUtils.showDialogPane(AbilitiesFromListPanel.abilitiesFromListPane))
    }
  }

  private val abilityPoints = new Button("From Points") {
    onAction = handle {
      FXUtils.onFXAndWait(
        FXUtils.showDialogPane(AbilitiesFromPoints.abilitiesFromPointsPanel))
    }
  }

  val racialAbilities: Button = new Button("Add Racial Ability Adjustments") {
    disable = true
    onAction = handle {
      classChooser.disable = false
      val success = addRaceAbilityAdjustments()
      disable = success
      abilityPoints.disable = success
      abilityList.disable = success
    }
  }

  private def generateRightSide: FlowPane = {
    val theChildren = new mList[Node]

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
      style = "-fx-background-color: linen"
    }

    fPane
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

    val raceIn: ComboBox[Dnd5RacesEnum.Value] =
      new ComboBox[Dnd5RacesEnum.Value](getRaceNames) {
        promptText = "Select a race"
        editable = false
         value.onChange((_, _, newVal) => {
          Dnd5Character.getWorkingCharacter.race = newVal
          Dnd5Character.getWorkingCharacter.addRacialBasicAbilities()
          charSpeed.text = Dnd5Character.getWorkingCharacter.speed.toString
          if (Dnd5Character.getWorkingCharacter.size != null)
            charSize.text = Dnd5Character.getWorkingCharacter.size.toString
          else
            charSize.text = ""
          NewCharacterUI.racialFeatures.disable = false
          NewCharacterUI.racialAbilities.disable = false
        })
      }

    val backgroundIn: ComboBox[String] =
      new ComboBox[String](DbBackgroundInfo.getAllBackgroundNames) {
        promptText = "Select a background"
        editable = false
        // todo -- add on change method
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
        style = "-fx-background-color: linen"
      }
      var leftRowNum = 0

      leftSide.addRow(leftRowNum, enhancedLabel("Character Name"), nameIn)
      leftRowNum += 1

      leftSide.addRow(leftRowNum, enhancedLabel("Race"), raceIn)
      leftRowNum += 1

      leftSide.addRow(leftRowNum, enhancedLabel("Background"), backgroundIn)
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
      backgroundIn.disable = false
      backgroundIn.value = null
      strength.text = Dnd5Character.getWorkingCharacter.strength.toString
      constitution.text =
        Dnd5Character.getWorkingCharacter.constitution.toString
      dexterity.text = Dnd5Character.getWorkingCharacter.dexterity.toString
      intelligence.text =
        Dnd5Character.getWorkingCharacter.intelligence.toString
      wisdom.text = Dnd5Character.getWorkingCharacter.wisdom.toString
      charisma.text = Dnd5Character.getWorkingCharacter.charisma.toString
      choiceMade = false
      alignmentIn.value = null
    }
  }

}
