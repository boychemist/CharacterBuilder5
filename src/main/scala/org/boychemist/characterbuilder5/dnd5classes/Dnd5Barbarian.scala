package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations._

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap

/**
  * Defines the base Barbarian class features
  */
object Dnd5Barbarian extends Dnd5BasicClass {
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Barbarian
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val specializationStartLevel: Int = 3
  val hitDice: String = "1d12"
  val armorProficiencies: List[String] = List("Light armor", "Medium armor", "Shields")
  val weaponProficiencies: List[String] = List("Simple weapons", "Martial weapons")
  val toolProficiencies: List[String] = List()
  val savingThrowProficiencies: List[DndAbilitiesEnum.Value] =
    List(DndAbilitiesEnum.Strength, DndAbilitiesEnum.Constitution)
  val skillChoices: List[String] =
    List("Animal Handling", "Athletics", "Intimidation", "Nature", "Perception", "Survival")
  val numberOfSkills = 2
  val features: Map[Int, List[ClassFeature]] = createBarbarianClassFeatures()
  override val specializationName: String = "Primal Path"

  /**
    * Provide the number of Barbarian rages per day by Barbarian level
    *
    * @param level of interest
    *
    * @return the number of rages before a long rest is required
    */
  def ragesByLevel(level: Int): Int = {
    if (level <3)
      2
    else if (level < 6)
      3
    else if (level < 12)
      4
    else if (level <17)
      5
    else if (level < 20)
      6
    else
      -1 // easiest way to express unlimited (need to handle in UI)
  }

  /**
    * Provides the rage damage bonus by Barbarian level
    *
    * @param level of interest
    *
    * @return the damage bonus for that level
    */
  def rageDamageBonusByLevel(level: Int): Int = {
    if (level < 9)
      2
    else if (level < 16)
      3
    else
      4
  }

  /**
    * Get the number of additional hit dice for critical hits for the Brutal Critical class feature
    *
    * @param level of interest
    *
    * @return the number of additional hit dice
    */
  def getBrutalCriticalBonusDice(level: Int): Int = {
    if (level < 9)
      0
    else if (level < 13)
      1
    else if (level < 17)
      2
    else
      3
  }

 private def createBarbarianClassFeatures(): Map[Int, List[ClassFeature]] = {
    var workingMap: mTreeMap[Int, List[ClassFeature]] = new mTreeMap()
    // Level 1
    val rage = new ClassFeature("Rage",
    "In battle, you fight with primal ferocity. On your turn, you can enter a rage as a bonus action.\n"+
      "While raging, you gain the following benefits if you aren't wearing heavy armor:\n\n" +
      "  -  You have advantage on Strength checks and Strength saving throws.\n"+
      "  -  When you make a melee weapon attack using Strength, you gain a bonus to the damage roll that increases " +
      "as you gain levels as a barbarian, as shown in the Rage Damage column of the Barbarian table.\n" +
      "  -  You have resistance to bludgeoning, piercing, and slashing damage.\n\n" +
      "If you are able to cast spells, you can't cast them or concentrate on them while raging.\n\n" +
      "Your rage lasts for 1 minute. It ends early if you are knocked unconscious or if your turn ends and you " +
      "haven't attacked a hostile creature since your last turn or taken damage since then. You can also end your " +
      "rage on your turn as a bonus action.\n\n" +
      "Once you have raged the number of times shown for your barbarian level in the Rages column of the Barbarian " +
      "table, you must finish a long rest before you can rage again.")
    val defense = new ClassFeature("Unarmored Defense",
    "While you are not wearing any armor, your Armor Class equals 10 + your Dexterity modifier + your " +
      "Constitution modifier. You can use a shield and still gain this benefit.")
    workingMap(1) = List(rage, defense)

    // Level 2
    val attack = new ClassFeature("Reckless Attack",
      "Starting at 2nd level, you can throw aside all concern for defense to attack with fierce " +
        "desperation. When you make your first attack on your turn, you can decide to attack recklessly. Doing so " +
        "gives you advantage on melee weapon attack rolls using Strength during this turn, but attack rolls against " +
        "you have advantage until your next turn.")
    val danger = new ClassFeature("Danger Sense",
    "At 2nd level, you gain an uncanny sense of when things nearby aren't as they should be, giving " +
      "you an edge when you dodge away from danger. You have advantage on Dexterity saving throws against " +
      "effects that you can see, such as traps and spells. To gain this benefit, you can’t be blinded, deafened, " +
      "or incapacitated.")
    workingMap(2) = List(attack, danger)

    // level 3 is choose specialization (Primal Path) covered as specialization start level above
    // level 4 is improve ability scores, a character feature
    // level 5
    val extraAttack = new ClassFeature("Extra Attack",
    "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack " +
    "action on your turn.")
    val movement = new ClassFeature("Fast Movement",
    "Starting at 5th level, your speed increases by 10 feet while you aren't wearing heavy armor.")
    workingMap(5) = List(extraAttack, movement)

    // level 6 feature is a specialization feature
    // level 7
    val feral = new ClassFeature("Feral Instinct",
    "By 7th level, your instincts are so honed that you have advantage on initiative rolls.\n" +
      "Additionally, if you are surprised at the beginning of combat and aren't incapacitated, you can act " +
      "normally on your first turn, but only if you enter your rage before doing anything else on that turn.")
    workingMap(7) = List(feral)

    // level 8 is improve ability scores, a character feature
    // level 9
    val brutal = new ClassFeature("Brutal Critical",
      "Beginning at 9th level, you can roll one additional weapon damage die when determining the " +
        "extra damage for a critical hit with a melee attack. This increases to two additional dice at 13th level " +
        "and three additional dice at 17th level.")
    workingMap(9) = List(brutal)
    // level 10 is a specialization feature
    // level 11
    val relentless = new ClassFeature("Relentless Rage",
    "Starting at 11th level, your rage can keep you fighting despite grievous wounds. If you drop to " +
      "0 hit points while you're raging and don't die outright, you can make a DC 10 Constitution saving throw. If " +
      "you succeed, you drop to 1 hit point instead.\n\n" +
      "Each time you use this feature after the first, the DC increases by 5. When you finish a short or long " +
      "rest, the DC resets to 10.")
    workingMap(11) = List(relentless)

    // level 12 is improve ability scores, a character feature
    // level 13 is better Brutal Critical
    // level 14 is a specialization feature
    // level 15
    val persistent = new ClassFeature("Persistent Rage",
    "Beginning at 15th level, your rage is so fierce that it ends early only if you fall unconscious " +
      "or if you choose to end it.")
    workingMap(15) = List(persistent)

    // level 16 is improve ability scores, a character feature
    // level 17 is better Brutal Critical
    // level 18
    val might = new ClassFeature("Indomitable Might",
    "Beginning at 18th level, if your total for a Strength check is less than your Strength score, " +
      "you can use that score in place of the total.")
    workingMap(18) = List(might)

    // level 19 is improve ability scores, a character feature
    // level 20
    val champion = new ClassFeature("Primal Champion",
    "At 20th level, you embody the power of the wilds. Your Strength and Constitution scores " +
      "increase by 4. Your maximum for those scores is now 24.")
   workingMap(20) = List(champion)

    // return immutable map
   val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
   immutableMap
  }

}
