package org.boychemist.characterbuilder5.dnd5classes

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap

import org.boychemist.characterbuilder5._

object Dnd5Druid extends Dnd5BasicClass with Dnd5SpellCaster {
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Druid
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val specializationStartLevel: Int = 2
  val hitDice: String = "1d8"
  val armorProficiencies: List[String] = List("Light armor", "Medium armor", "Shields")
  val weaponProficiencies: List[String] = List("Clubs", "Daggers", "Darts", "Javelins", "Maces",
  "Quarterstaffs", "Scimitars", "Sickles", "Slings", "Spears")
  val toolProficiencies: List[String] = List("Herbalism kit")
  val savingThrowProficiencies: List[DndAbilitiesEnum.Value] =
    List(DndAbilitiesEnum.Intelligence, DndAbilitiesEnum.Wisdom)
  val skillChoices: List[String] = List("Arcana", "Animal Handling", "Insight", "Medicine", "Nature",
  "Perception", "Religion", "Survival")
  val numberOfSkills: Int = 2
  val features: Map[Int, List[ClassFeature]] = createDruidClassFeatures()
  override val specializationName: String = "Druid Circle"

  // spell caster features
  // defines the spell list to use when choosing spells
  val spellSourceType: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Druid
  val  classLevelForFirstSpells: Int = 1
  val abilityModifierforDC_attack: DndAbilitiesEnum.Value = DndAbilitiesEnum.Wisdom

  // empty for cleric, druid, or wizard (Wizards must have spells in spell book)
  val totalSpellsKnownByClassLevel: Vector[Int] = Vector()

  // the level restriction for spell slots is the class level, not the character level
  // Eldrich Knights, Paladins, and Rangers don't have cantrips at any level and don't have
  // spell slots above certain levels (4 or 5).  Arcane Tricksters don't have spell slots above level 4.
  override def cantripsPerLevel(level: Int): Int = {
    if (level < 4)
      2
    else if (level < 10)
      3
    else
      4
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
    else 3
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

  private def createDruidClassFeatures(): Map[Int, List[ClassFeature]] = {
    val workingMap = new mTreeMap[Int, List[ClassFeature]]()

    // level 1
    val druidic = new ClassFeature("Druidic",
    "You know Druidic, the secret language of druids.  You can speak the language and use it " +
    "leave hidden messages.  You and others who know this language automatically spot such a message.  " +
    "Others spot the message's presence with a successful DC 15 Wisdom(Perception) check but can't " +
    "decipher it without magic.")
    workingMap(1) = List(druidic)

    // level 2
    val wild = new ClassFeature("Wild Shape",
    "Starting a 2nd level, you can use your action to magically assume the shape of a beast " +
    "that you have seen before.  You can use this feature twice.  You regain expended uses when you finish " +
    "a short or long rest.\nYour druid level determines the beasts you can transform into, as shown in the " +
    "Beast Shapes table.  At 2nd level, for example, you can transform into any beast tha has a challenge " +
    "rating of 1/4 or lower that doesn't have a flying or swimming speed.")
    workingMap(2) = List(wild)

    // level 18
    val body = new ClassFeature("Timeless Body",
    "Starting at 18th level, the primal magic the you wield causes you to age more slowly.  " +
    "For every 10 years that pass, your body ages only 1 year.")
    val beast = new ClassFeature("Beast Spells",
    "Beginning at 18th level, you can cast many of your druid spells in any shape you assume " +
    "using Wild Shape.  You can perform the somatic and verbal components of a druid spell while in a " +
    "beast shape, but you aren't able to provide material componets.")
    workingMap(18) = List(body, beast)

    // level 20
    val archdruid = new ClassFeature("Archdruid",
    "At 20th level, you can use your Wild Shape an unlimited number of times.\n" +
    "Additionally, you can ignore the verbal and somatic components of your druid spells, as well as any " +
    "material components that lack a cost and aren't consumed by a spell.  You gain the benefit in both " +
    "your normal shape and you beast shape from Wild Shape.")
    workingMap(20) = List(archdruid)

    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }
}
