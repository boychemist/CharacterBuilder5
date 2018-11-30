package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap


object Dnd5Rogue extends Dnd5BasicClass {
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Rogue
  // specialization is the unique choice for class leveling and has different names for each class
  val allowedSpecializations: Vector[Dnd5SpecializationsEnum.Value] =
    Vector(Dnd5SpecializationsEnum.Thief, Dnd5SpecializationsEnum.Assassin, Dnd5SpecializationsEnum.ArcaneTrickster)
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val specializationStartLevel: Int = 3

  def hitDice: String = "1d8"

  def armorProficiencies: List[String] = List("Light armor")

  def weaponProficiencies: List[String] = List("Simple weapons", "Hand crossbows", "Longswords", "Rapiers", "Shortswords")

  def toolProficiencies: List[String] = List("Thieves' tools")

  def savingThrowProficiencies: List[DndAbilitiesEnum.Value] =
    List(DndAbilitiesEnum.Intelligence, DndAbilitiesEnum.Dexterity)

  def skillChoices: List[String] = List("Acrobatics", "Athletics", "Deception", "Insight", "Intimidation",
    "Investigation", "Perception", "Performance", "Persuasion", "Sleight of Hand", "Stealth")

  def numberOfSkills: Int = 4

  def features: Map[Int, List[ClassFeature]] = createRogueClassFeatures()

  private def createRogueClassFeatures() = {
    val workingMap = new mTreeMap[Int, List[ClassFeature]]()

    // Level 1
    val expertise = new ClassFeature("Expertise",
      "At 1st level, choose two of our skill proficiencies, or one of your skill proficiencis and " +
        "your proficiency with thieves's tools.  Your proficiency bonus us doubled for any ability check you make " +
        "that uses either of the chosen proficiencies.\n" +
        "At 6th level, you can choose two more of your proficiencies (in skills or thieves' tools) to gain this benefit.")
    val attack = new ClassFeature("Sneak Attack",
      "Beginning at 1st level, you know how to strike subtly and exploit a foe's distraction.  Once per " +
        "turn, you can deal an extra 1d6 damage to one creature you hit with an attack if you have advantage on the " +
        "attack roll.  The attack must use a finesse or a ranged weapon.\n" +
        "You don't need advantage on the attack roll if another enemy of the target is within 5 feet of it, that " +
        "enemy is not incapacitated, and your don't have disadvantage on the attack roll.\n" +
        "The amount of extra damage increases as you gain levels in this class, as shown in the Sneak Attack " +
        "column of the Rogue table.")
    val cant = new ClassFeature("Thieves' Cant",
      "During your rogue training you learned thieves' cant, a secret mix of dialect, jargon, and code " +
        "that allows you to hide messages in seemingly normal conversation.  Only another creature that knows thieves' " +
        "cant understands such messages.  It takes four times longer to convey such a message that it does to speak the " +
        "same idea plainly.\n" +
        "In addition, you understand a set of secret signs and symbols used to convey short, simple messages, such as " +
        "whether an area is dangerous or the territory of a thieves' guild, whether loot is nearby, or whether the " +
        "people in an area are easy marks or will provide a safe house for thieves on the run.")
    workingMap(1) = List(expertise, attack, cant)

    // Level 2
    val cunning = new ClassFeature("Cunning Action",
      "Starting at 2nd level, you quick thinking and agility allow you to move and act quickly.  You " +
        "can take a bonus action on each of your turns in combat.  This action can only be uset to take the Dash, " +
        "Disengage, or Hide action.")
    workingMap(2) = List(cunning)

    // Level 5
    val dodge = new ClassFeature("Uncanny Dodge",
      "Starting at 5th level, when an attacker, that you can see hits you with an attack, you can use " +
        "your reaction to halve the attack's damage against you.")
    workingMap(5) = List(dodge)

    // Level 7
    val evasion = new ClassFeature("Evasion",
      "Beginning at 7th level, you can nimbly dodge out of the way of certain area effects, such as a " +
        "red dragon's fiery breath or an 'ice storm' spell.  Your you are subjected to an effect that allows you to " +
        "make a Dexterity saving throw to take only half damage, you instead take no damage if you succeed on the " +
        "saving throw, and only half damage if you fail.")
    workingMap(7) = List(evasion)

    // Level 11
    val talent = new ClassFeature("Reliable Talent",
      "By 11th level, you have refined your chosen skills until the approach perfection.  Whenever you " +
        "make an ability check that lets you add your proficiency bonus, you can treat a d20 for of 9 or lower as a 10.")
    workingMap(11) = List(talent)

    // Level 14
    val sense = new ClassFeature("Blindsense",
      "Starting at 14th level, if you are able to hear, you are aware of the location of any hidden or " +
        "invisible creature within 10 feet of you.")
    workingMap(14) = List(sense)

    // Level 15
    val mind = new ClassFeature("Slippery Mind",
      "by 15th level, you have acquired greater mental strength.  You gain proficiency in Wisdom " +
        "saving throws.")
    workingMap(15) = List(mind)

    // Level 18
    val elusive = new ClassFeature("Elusive",
      "Beginning at 18th level, you are so evasive that attackers rarely gain the upper hand against " +
        "you.  No attack roll has advantage against you while you aren't incapacitated.")
    workingMap(18) = List(elusive)

    // Level 20
    val luck = new ClassFeature("Stroke of Luck",
      "At 20th level, you have an uncanny knack for succeeding when you need to.  If your attack " +
        "misses a target within range, you can turn the miss into a hit.  Alternatively, if you fail an ability check," +
        "you can treat the d20 roll as a 20.\n" +
        "Once you use this feature, you can't use it again until you finish a short or long rest.")
    workingMap(20) = List(luck)

    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }
}
