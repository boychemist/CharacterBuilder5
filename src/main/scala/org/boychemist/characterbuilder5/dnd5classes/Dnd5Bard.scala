package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap

object Dnd5Bard extends Dnd5BasicClass with Dnd5SpellCaster {
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Bard
  // specialization is the unique choice for class leveling and has different names for each class
  val allowedSpecializations: Vector[Dnd5SpecializationsEnum.Value] =
    Vector(Dnd5SpecializationsEnum.CollegeOfLore, Dnd5SpecializationsEnum.CollegeOfValor)
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  def specializationStartLevel: Int = 3
  def hitDice: String = "1d8"
  def armorProficiencies: List[String] = List("Light armor")
  def weaponProficiencies: List[String] = List("Simple weapons", "Hand crossbows",
    "longswords", "rapiers", "shortswords")
  def toolProficiencies: List[String] = List("Three musical instruments of your choice")
  def savingThrowProficiencies: List[DndAbilitiesEnum.Value] =
    List(DndAbilitiesEnum.Dexterity, DndAbilitiesEnum.Charisma)
  def skillChoices: List[String] = List("Choose any 3")
  def numberOfSkills: Int = 3
  def features: Map[Int, List[ClassFeature]] = createBardClassFeatures()

  // spell caster related features
  val spellSourceType: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Bard  // defines the spell list to use when choosing spells
  val classLevelForFirstSpells: Int = 1
  val abilityModifierforDC_attack: DndAbilitiesEnum.Value = DndAbilitiesEnum.Charisma
  // empty cleric, druid, or wizard (Wizards must have spell in spell book)
  val totalSpellsKnownByClassLevel: Vector[Int] =
    Vector(0, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 15, 15, 16, 18, 19, 19, 20, 22, 22, 22)
  // the level restriction for spell slots is the class level, not the character level
  // Eldrich Knights, Paladins, and Rangers don't have cantrips at any level and don't have
  // spell slots above certain levels (4 or 5).  Arcane Tricksters don't have spell slots above level 4.
  // the map keys are the level, the value is the number of spells
  override def cantripsPerLevel(level: Int): Int = {
    if (level < 4)
      2
    else if (level < 10)
      3
    else
      4
  }
  override def firstLevelSlotsPerLevel(level: Int): Int = {
    if (level == 1)
      2
    else if (level == 2)
      3
    else
      4
  }
  override def level2SlotsPerLevel(level:Int): Int = {
    if (level < 3)
      0
    else if (level == 3)
      2
    else
      3
  }
  override def level3SlotsPerLevel(level:Int): Int = {
    if (level < 5)
      0
    else if (level == 5)
      2
    else
      3
  }
  override def level4SlotsPerLevel(level:Int): Int = {
    if (level < 7)
      0
    else if (level == 7)
      1
    else if (level == 8)
      2
    else
      3
  }
  override def level5SlotsPerLevel(level:Int): Int = {
    if (level < 9)
      0
    else if (level == 9)
      1
    else if (level < 18)
      2
    else
      3
  }
  override def level6SlotsPerLevel(level:Int): Int = {
    if (level < 11)
      0
    else if (level < 19)
      1
    else
      2
  }
  override def level7SlotsPerLevel(level:Int): Int = {
    if (level < 13)
      0
    else if (level < 20)
      1
    else
      2
  }
  override def level8SlotsPerLevel(level:Int): Int = {
    if (level < 15)
      0
    else
      1
  }
  override def level9SlotsPerLevel(level:Int): Int = {
    if (level < 17)
      0
    else
      1
  }

  private def createBardClassFeatures(): Map[Int, List[ClassFeature]] = {
    val workingMap = new mTreeMap[Int, List[ClassFeature]]()

    // level 1 feature -- Player's Handdbook also include spell casting but that is handled differently above
    val inspire = new ClassFeature("Bardic Inspiration",
    "You can inspire others through stirring words or music. To do so, you use a bonus action on " +
      "your turn to choose one creature other than yourself within 60 feet of you who can hear you. That creature " +
      "gains one Bardic Inspiration die, a d6.\nOnce within the next 10 minutes, the creature can roll the die and " +
      "add the number rolled to one ability check, attack roll, or saving throw it makes. The creature can wait " +
      "until after it rolls the d20 before deciding to use the Bardic Inspiration die, but must decide before the " +
      "GM says whether the roll succeeds or fails. Once the Bardic Inspiration die is rolled, it is lost. A creature " +
      "can have only one Bardic Inspiration die at a time.\nYou can use this feature a number of times equal to " +
      "your Charisma modifier (a minimum of once). You regain any expended uses when you finish a long rest.\nYour " +
      "Bardic Inspiration die changes when you reach certain levels in this class. The die becomes a d8 at 5th " +
      "level, a d10 at 10th level, and a d12 at 15th level.")
    workingMap(1) = List(inspire)

    // level 2 features
    val joat = new ClassFeature("Jack of All Trades",
    "Starting at 2nd level, you can add half your proficiency bonus, rounded down, to any ability " +
      "check you make that doesn’t already include your proficiency bonus.")
    val rest = new ClassFeature("Song of Rest",
    "Beginning at 2nd level, you can use soothing music or oration to help revitalize your wounded " +
      "allies during a short rest. If you or any friendly creatures who can hear your performance regain hit " +
      "points at the end of the short rest by spending one or more Hit Dice, each of those creatures regains an " +
      "extra 1d6 hit points.\nThe extra hit points increase when you reach certain levels in this class: to 1d8 " +
      "at 9th level, to 1d10 at 13th level, and to 1d12 at 17th level")
    workingMap(2) = List(joat, rest)

    // level 3 feature -- also includes selecting Bard College
    val expertise = new ClassFeature("Expertise",
    "At 3rd level, choose two of your skill proficiencies. Your proficiency bonus is doubled for " +
      "any ability check you make that uses either of the chosen proficiencies. At 10th level, you can choose " +
      "another two skill proficiencies to gain this benefit.")
    workingMap(3) = List(expertise)

    // level 4 ability score only, not a class feature
    // level 5 features
    val font = new ClassFeature("Font of Inspiration",
    "Beginning when you reach 5th level, you regain all of your expended uses of Bardic Inspiration " +
      "when you finish a short or long rest.")
    workingMap(5) = List(font)

    // leve 6 features
    val countercharm = new ClassFeature("Countercharm",
    "At 6th level, you gain the ability to use musical notes or words of power to disrupt " +
      "mind-influencing effects. As an action, you can start a performance that lasts until the end of your " +
      "next turn. During that time, you and any friendly creatures within 30 feet of you have advantage on " +
      "saving throws against being frightened or charmed. A creature must be able to hear you to gain this " +
      "benefit. The performance ends early if you are incapacitated or silenced or if you voluntarily end it " +
      "(no action required).")
    workingMap(6) = List(countercharm)

    // no feature for level 7 through 9 -- Song of Rest improves at level 9
    // level 10 features
    val secrets = new ClassFeature("Magical Secrets",
    "By 10th level, you have plundered magical knowledge from a wide spectrum of disciplines. Choose "  +
      "two spells from any class, including this one. A spell you choose must be of a level you can cast, as shown " +
      "on the Bard table, or a cantrip.\nThe chosen spells count as bard spells for you and are included in the " +
      "number in the Spells Known column of the Bard table.\nYou learn two additional spells from any class at " +
      "14th level and again at 18th level.")
    workingMap(10) = List(secrets)

    // no new class features for level 11 through 19
    // level 20 feature
    val superior = new ClassFeature("Superior Inspiration",
    "At 20th level, when you roll initiative and have no uses of Bardic Inspiration left, you regain " +
      "one use.")
    workingMap(20) = List(superior)

    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }
}
