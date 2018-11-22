package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.boychemist.characterbuilder5.{Dnd5ClassesEnum, DndAbilitiesEnum}

import scala.collection.mutable.{HashMap => MutableHashMap}
import org.boychemist.characterbuilder5.dnd5classes.Dnd5SpellCaster

object ArcaneTrickster extends Dnd5ClassSpecialization with Dnd5SpellCaster {
  override val providesSpells = true

  val description: String = "Some rogues enhance their fine-honed skills of stealth and agility with magic, " +
  "learning tricks of enchantment and illusion.  These rogues include pickpockets and burglars, but also " +
  "pranksters, mischief-makers, and a significant number of adventurers."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val spells = new SpecializationFeature("Spellcasting",
      "When you reach 3rd level, you gain the ability to cast spells.  See page 98 of the Player's " +
    "Handbook for details.")
    val mageHand = new SpecializationFeature("Mage Hand Legerdemain",
      "Starting at 3rd level, when you cast 'mage hand', you can make the spectral hand invisible, " +
    "and you can perform the following additional tasks with it:\n\n" +
    "* You can stow one object the hand is holding in a container worn by\n" +
    "  another creature.\n" +
    "* You can retrieve an object in a container worn or carried by another\n" +
    "  creature.\n" +
    "* You can use thieves tools to pick locks and disarm trapes at range.\n\n" +
    "You can perform one of these tasks without being noticed by a creature if you succeed on a Dexterity" +
    "(Sleight of Hand) check contested by the creature's Wisdom(Perception) check.\n" +
    "In addition, you can use the bonus action granted by your Cunning Action to control the hand.")
    workingMap(3) = List(spells, mageHand)

    // level 9
    val ambush = new SpecializationFeature("Magical Ambush",
      "Starting at 9th level, if you are hidden from a creature when you cast a spell on it, the " +
    "creature has disadvantage on any saving throw it makes against the spell this turn.")
    workingMap(9) = List(ambush)

    // level 13
    val trickster = new SpecializationFeature("Versatile Trickster",
      "At 13th level, you gain the ability to distract targets with your 'mage hand'.  As a bonus " +
    "action on your turn, you can designate a creature within 5 feet of the spectral hand created by the spell.  " +
    "Doing so gives you advantage on attack rolls against that creature until the end of the turn.")
    workingMap(13) = List(trickster)

    // level 17
    val thief = new SpecializationFeature("Spell Thief",
      "At 17th level, you gain the ability to magically steal the knowledge of how to cast a spell " +
    "from another spellcaster.\n" +
    "Immediately after a creature casts a spell that targets you or includes you in its area of effect, you can " +
    "use your reaction to force the creature to make a saving throw with its spellcasting mofifier.  The DC equals " +
    "your spell save DC.  On a failed save, you negate the spell's effect against you, and you steal the knowledge " +
    "of the spell if it is at least 1st level and of a level you can cast (it doesn't need to be a wizard spell).  " +
    "For the next 8 hour, you know the spell and can cast it using your spell slots.  The creature can't cast that " +
    "spell until the 8 hours have passed.\n" +
    "Once you use this feature, you can't use it again until you finish a long rest.")
    workingMap(17) = List(thief)

    workingMap.toMap
  }

  // spell caster related features
  val spellSourceType: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Wizard  // defines the spell list to use when choosing spells
  val classLevelForFirstSpells: Int = 2
  val abilityModifierforDC_attack: DndAbilitiesEnum.Value = DndAbilitiesEnum.Wisdom
  // empty cleric, paladin, druid, or wizard (Wizards must have spell in spell book)
  val totalSpellsKnownByClassLevel: Vector[Int] =
    Vector(0, 0, 0, 3, 4, 4, 4, 5, 6, 6, 7, 8, 8, 9, 10, 10, 11, 11, 11, 12, 13)
  // the level restriction for spell slots is the class level, not the character level
  // Eldrich Knights, Paladins, and Rangers don't have cantrips at any level and don't have
  // spell slots above certain levels (4 or 5).  Arcane Tricksters don't have spell slots above level 4.
  // the map keys are the level, the value is the number of spells
  override def cantripsPerLevel(level: Int): Int = {
    if (level < 2)
      0
    else if (level < 10)
      3
    else
      4
  }
  override def firstLevelSlotsPerLevel(level: Int): Int = {
    if (level < 3)
      0
    else if (level == 3)
      2
    else if (level < 7)
      3
    else
      4
  }
  override def level2SlotsPerLevel(level:Int): Int = {
    if (level < 7)
      0
    else if (level < 10)
      2
    else
      3
  }
  override def level3SlotsPerLevel(level:Int): Int = {
    if (level < 13)
      0
    else if (level < 16)
      2
    else
      3
  }
  override def level4SlotsPerLevel(level:Int): Int = {
    if (level < 19)
      0
    else
      1
  }
  override def level5SlotsPerLevel(level:Int): Int = 0
  override def level6SlotsPerLevel(level:Int): Int = 0
  override def level7SlotsPerLevel(level:Int): Int = 0
  override def level8SlotsPerLevel(level:Int): Int = 0
  override def level9SlotsPerLevel(level:Int): Int = 0
}
