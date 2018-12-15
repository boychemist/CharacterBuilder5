package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap

object Dnd5Ranger extends Dnd5BasicClass with Dnd5SpellCaster {
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Ranger
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val specializationStartLevel: Int = 3
  def hitDice: String = "1d10"
  def armorProficiencies: List[String] = List("Light armor", "Medium armor", "Shields")
  def weaponProficiencies: List[String] = List("Simple weapons", "Martial weapons")
  def toolProficiencies: List[String] = List()
  def savingThrowProficiencies: List[DndAbilitiesEnum.Value] =
    List(DndAbilitiesEnum.Strength, DndAbilitiesEnum.Dexterity)
  def skillChoices: List[String] = List("Animal Handling", "Athletics", "Insight", "Investigation", "Nature",
    "Perception", "Stealth", "Survival")
  def numberOfSkills: Int = 3
  def features: Map[Int, List[ClassFeature]] = createRangerClassFeatures()
  override val specializationName: String = "Ranger Archetype"

  // spell caster related features
  val spellSourceType: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Ranger  // defines the spell list to use when choosing spells
  val classLevelForFirstSpells: Int = 2
  val abilityModifierforDC_attack: DndAbilitiesEnum.Value = DndAbilitiesEnum.Wisdom
  // empty cleric, paladin, druid, or wizard (Wizards must have spell in spell book)
  val totalSpellsKnownByClassLevel: Vector[Int] =
    Vector(0, 0, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10, 11, 11)
  // the level restriction for spell slots is the class level, not the character level
  // Eldrich Knights, Paladins, and Rangers don't have cantrips at any level and don't have
  // spell slots above certain levels (4 or 5).  Arcane Tricksters don't have spell slots above level 4.
  // the map keys are the level, the value is the number of spells
  override def cantripsPerLevel(level: Int): Int = 0
  override def firstLevelSlotsPerLevel(level: Int): Int = {
    if (level == 1)
      0
    else if (level == 2)
      2
    else if (level < 5)
      3
    else
      4
  }
  override def level2SlotsPerLevel(level:Int): Int = {
    if (level < 5)
      0
    else if (level < 7)
      2
    else
      3
  }
  override def level3SlotsPerLevel(level:Int): Int = {
    if (level < 9)
      0
    else if (level < 11)
      2
    else
      3
  }
  override def level4SlotsPerLevel(level:Int): Int = {
    if (level < 13)
      0
    else if (level < 15)
      1
    else if (level < 17)
      2
    else
      3
  }
  override def level5SlotsPerLevel(level:Int): Int = {
    if (level < 17)
      0
    else if (level < 19)
      1
    else
      2
  }
  override def level6SlotsPerLevel(level:Int): Int = 0
  override def level7SlotsPerLevel(level:Int): Int = 0
  override def level8SlotsPerLevel(level:Int): Int = 0
  override def level9SlotsPerLevel(level:Int): Int = 0

  private def createRangerClassFeatures() = {
    val workingMap = new mTreeMap[Int, List[ClassFeature]]()
    // Level 1
    val enemy = new ClassFeature("Favored Enemy",
      "Beginning at 1st level, you have significant experience studying, tracking, hunting, and even " +
    "talking to a certain type of enemy.\n" +
    "Choose a type of favored enemy:  aberrations, beasts, celestials, constructs, dragons, elementals, fey, " +
    "fiends, giants, monstrosities, oozes, plants, or undead.  Alternatively, you can select two races of humanoid " +
    "(such as gnolls and orcs) as favored enemies.\n" +
    "You have advantage on Wisdom(Survival) checks to track your favored enemies, as well as on Intelligence checks " +
    "to recall information about them.\n" +
    "When you gain this feature, you also learn one language of your choice that is spoken by your favored enemies, " +
    "if they speak one at all.\n" +
    "You choose one additional favored enemy, as well as an associated language, at 6th and 14th level.  As you " +
    "gain levels, your choices should reflect the types of monsters you have encountered on your adventures.")

    val explorer = new ClassFeature("Natural Explorer",
      "You are particularly familiar with one type of natural environment and are adept at traveling " +
    "and surviving in such regions.  Choose one type of favored terrain:  arctic, coast, desert, forest, grassland, " +
    "mountain, swamp, or the Underdark.  When you make an Intelligence check or Wisdom check related to your " +
    "favored terrain, you proficiency bonus is doubled if you are using a skill that your are proficient in.\n" +
    "While traveling for an hour or more in your favored terrain, you gain the following benefits:\n" +
    "* Difficult terrain doesn't slow your group's travel.\n" +
    "* Your group can't become lost except by magical means.\n" +
    "* Even when you are engaged in another activity while traveling (such as foraging,\n" +
    "  navigating, or tracking), you remain alert to danger.\n" +
    "* If you are traveling alone, you can move stealthily at a normal pace.\n" +
    "* When you forage, you find twice as much food as you normally would.\n" +
    "* While tracking other creatures, you also learn their exact number, their sizes,\n" +
    "  and how long ago they passed through the area.\n" +
    "You choose additional favored terrain types at 6th and 10th level.")
    workingMap(1) = List(enemy, explorer)

    // Level 2
    val style = new ClassFeature("Fighting Style",
      "At 2nd level, you adopt a style of fighting as your speciality.  Choose one of the following " +
        "options.  You can't take a Fighting Style option more than once, even if you later get to choose again.\n\n" +
        "ARCHERY\nYou gain a +2 bonus to attack rolls you make with ranged weapons.\n\n" +
        "DEFENSE\nWhile you are wearing armor, you gain a +1 bonus to AC.\n\n" +
        "DUELING\nWhen you a weilding a melee weapon in one hand and no other weapons, you gain a +2 bonus to " +
        "damage rolls with that weapon.\n\n" +
        "TWO-WEAPON FIGHTING.\nWhen you engage in two-weapon fighting, you can add your ability modifier to the " +
    "damage of the second attack.")
    val casting = new ClassFeature("Spellcasting",
      "By 2nd level, you have learned to use the magical essence of nature to cast spells, much" +
    "as a druid does.  See pages 91 and 92 of the Player's Handbook for a description of ranger spellcasting")
    workingMap(2) = List(style, casting)

    // Level 3
    val awareness = new ClassFeature("Primeval Awareness",
      "Beginning at 3rd level, you can use your action and expend one of your range spell slots to " +
    "focus your awareness on the region around you.  For 1 minute per level of the spell slot you expended, you " +
    "can sense whether the following types of creatures are within 1 mile of your (or within up to 6 miles if you " +
    "are in your favored terrain):  aberrations, celestials, dragons, elementals, fey, fiends, and undead.  This " +
    "feature doesn't reveal the creatures location or number.")
    workingMap(3) = List(awareness)

    // Level 5
    val attack = new ClassFeature("Extra Attack",
      "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack " +
        "action on your turn.")
    workingMap(5) = List(attack)

    // Level 8
    val stride = new ClassFeature("Land's Stride",
      "Starting at 8th level, moving through nonmagical difficult terrain cost you no extra " +
    "movement.  You can also pass through nonmagical plants without being slowed by them and without taking " +
    "damage from them if they have thorns, spines, or similar hazards.\n" +
    "In addition, you have advantage on saving throws against plants that are magically created or " +
    "manipulated to impede movement, such as those created by the 'entangle' spell.")
    workingMap(8) = List(stride)

    // Level 10
    val hide = new ClassFeature("Hide in Plain Sight",
      "Starting at 10th level, you can spend 1 minute creating camouflage for yourself.  You must " +
    "have access to fresh mud, dirt, plants, soot, and other naturally occurring materials with which to create " +
    "your camouflage.\n" +
    "Once your are camouflaged in this way, you can try to hide by pressing yourself up against a solid surface " +
    "such as a tree or wall, that is at least as tall and wide as you are.  You gain a +10 bonus to Dexterity" +
    "(Stealth) checks as long as you remain there without moving or taking actions.  Once you move or take an " +
    "action or a reaction, you must camouflage yourself again to gain the benefit.")
    workingMap(10) = List(hide)

    // Level 14
    val vanish = new ClassFeature("Vanish",
      "Starting at level 14, you can use the Hide action as a bonus action on your turn.  Also, you " +
    "can't be tracked by nonmagicall means, unless you choose to leave a trail.")
    workingMap(14) = List(vanish)

    // Level 18
    val senses = new ClassFeature("Feral Senses",
      "At 18th level, you gain preternatural  senses that help you fight creatures you can't see.  " +
    "When you attack a creature you can't see, you inability to see doesn't impose disadvantage on your attack " +
    "rolls against it.\n" +
    "You are also aware of the location of any invisible creature within 30 feet of you, provided that the " +
    "creature isn't hidden from you and you aren't blinded or deafened.")
    workingMap(18) = List(senses)

    // Level 20
    val slayer = new ClassFeature("Foe Slayer",
      "At 20th level, you become an unparalled hunter of your enemies.  Once on each of your turns, " +
    "you can add your Wisdom modifier to the attack roll or the damage roll of an attack you make against one of " +
    "your favored enemies.  You can choose to use this feature before or after the roll, but before and effects " +
    "of the roll are applied.")
    workingMap(20) = List(slayer)

    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }
}
