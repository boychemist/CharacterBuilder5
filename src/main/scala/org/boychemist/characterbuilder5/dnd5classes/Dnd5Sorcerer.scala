package org.boychemist.characterbuilder5.dnd5classes

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum

object Dnd5Sorcerer extends Dnd5BasicClass with Dnd5SpellCaster {
  // basic class features
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Sorcerer
  // specialization is the unique choice for class leveling and has different names for each class
  val allowedSpecializations: Vector[Dnd5SpecializationsEnum.Value] =
    Vector(Dnd5SpecializationsEnum.DraconicBloodline, Dnd5SpecializationsEnum.WildMagic)
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val  specializationStartLevel: Int = 1
  val hitDice: String = "1d6"
  val armorProficiencies: List[String] = List()
  val weaponProficiencies: List[String] = List("Daggers", "Darts", "Slings", "Quarterstaffs", "Light crossbows")
  val toolProficiencies: List[String] = List()
  val savingThrowProficiencies: List[DndAbilitiesEnum.Value] = List(DndAbilitiesEnum.Constitution,
    DndAbilitiesEnum.Charisma)
  val skillChoices: List[String] = List("Arcana", "Deception", "Insight", "Intimidation", "Persuasion", "Religion")
  val numberOfSkills: Int = 2
  val features: Map[Int, List[ClassFeature]] = createSorcererClassFeatures()
  override val specializationName: String = "Sorcerous Origin"

  // spell caster features
  // defines the spell list to use when choosing spells
  val spellSourceType: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Sorcerer
  val  classLevelForFirstSpells: Int = 1
  val abilityModifierforDC_attack: DndAbilitiesEnum.Value = DndAbilitiesEnum.Charisma
  // empty cleric, druid, or wizard (Wizards must have spells in spell book)
  val totalSpellsKnownByClassLevel: Vector[Int] =
    Vector(0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 12, 13, 13, 14, 14, 15, 15, 15, 15)
  // the level restriction for spell slots is the class level, not the character level
  // Eldrich Knights, Paladins, and Rangers don't have cantrips at any level and don't have
  // spell slots above certain levels (4 or 5).  Arcane Tricksters don't have spell slots above level 4.
  override def cantripsPerLevel(level: Int): Int = {
    if (level < 4)
      4
    else if (level < 10)
      5
    else
      6
  }
  override def firstLevelSlotsPerLevel(level:Int): Int = {
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

  private def createSorcererClassFeatures(): Map[Int, List[ClassFeature]] = {
    var workingMap = new mTreeMap[Int, List[ClassFeature]]()

    // Level 2
    val font = new ClassFeature("Font of Magic",
      "At 2nd level, you tap into a deep wellspring of magic within yourself.  This wellspring is \n" +
    "represented by sorcery points, which allow you to create a variety of magical effects.\n\n" +
    "SORCERY POINTS\n" +
    "Starting a 2nd level, you have the same number of sorcery points as your sorcerer spell level.  You can " +
    "never have more sorcery points than your sorcerer level.  You regain all sorcery points when you finish a " +
    "long rest.\n\n" +
    "FLEXIBLE CASTING\n" +
    "You can use your sorcery points to gain additional spell slots, or you can sacrifice spell slots to gain" +
    "additional sorcery points as you reach higher levels.\n\n" +
    "CREATING SPELL SLOTS.  You can transform unexpended sorcery points into one spell slot as a bonus action on " +
    "your turn.  The Creating Spell slots table (pg 101 of the Player's Handbook) shows the cost of creating " +
    "a spell slot of a given level.  You can create spell slots no higher in level than 5th.\n" +
    "Any spell slot you create with this feature vanishes when you finish a long rest.\n" +
    "CONVERTING A SPELL SLOT TO SORCERY POINTS.  As a bonus action on your turn, you can expend one spell slot " +
    "and gain a number of sorcery points equal to the slot's level.")
    workingMap.put(2, List(font))

    // level 3
    val metamagic = new ClassFeature("Metamagic",
      "At 3rd level, you gain the ability to twist your spells to suit your needs.  You gain two n" +
    "of Metamagic options of your choice.  (Metamagic options are described on pg 102 of the Player's Guide).\n" +
    "You gain another one at 10th level and 17th level.\n" +
    "You can only use one Metamagic option on a spell when you cast it, unless otherwise noted.\n"
    )
    workingMap.put(3, List(metamagic))

    // level 20
    val restore = new ClassFeature("Sorcerous Restoration",
      "At 20th level, you regain 4 expended sorcery points whenever you finish a short rest.")
    workingMap.put(20, List(restore))

    // return an immutable Map
    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }
}
