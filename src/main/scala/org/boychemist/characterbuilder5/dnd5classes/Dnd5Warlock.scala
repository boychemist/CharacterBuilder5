package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap

object Dnd5Warlock extends Dnd5BasicClass with Dnd5SpellCaster {
  // basic class features
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Warlock
  // specialization is the unique choice for class leveling and has different names for each class
  val allowedSpecializations: Vector[Dnd5SpecializationsEnum.Value] =
    Vector(Dnd5SpecializationsEnum.TheArchfey, Dnd5SpecializationsEnum.TheFiend,
      Dnd5SpecializationsEnum.TheGreatOldOne)
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val specializationStartLevel: Int = 1
  val hitDice: String = "1d8"
  val armorProficiencies: List[String] = List("Light Armor")
  val weaponProficiencies: List[String] = List("Simple Weapons")
  val toolProficiencies: List[String] = List()
  val savingThrowProficiencies: List[DndAbilitiesEnum.Value] = List(DndAbilitiesEnum.Wisdom,
    DndAbilitiesEnum.Charisma)
  val skillChoices: List[String] = List("Arcana", "Deception", "History", "Intimidation", "Investigation",
    "Nature", "Religion")
  val numberOfSkills: Int = 2
  val features: Map[Int, List[ClassFeature]] = createWarlockClassFeatures()
  override val specializationName: String = "Otherworldly Patron"

  // spell caster features
  // defines the spell list to use when choosing spells
  val spellSourceType: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Warlock
  val classLevelForFirstSpells: Int = 1
  val abilityModifierforDC_attack: DndAbilitiesEnum.Value = DndAbilitiesEnum.Charisma
  // empty cleric, druid, or wizard (Wizards must have spells in spell book)
  val totalSpellsKnownByClassLevel: Vector[Int] =
    Vector(0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15)

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

  override def firstLevelSlotsPerLevel(level: Int): Int = {
    if (level == 1)
      2
    else if (level == 2)
      3
    else
      0
  }

  override def level2SlotsPerLevel(level: Int): Int = {
    if (level == 3 || level == 4)
      2
    else
      0
  }

  override def level3SlotsPerLevel(level: Int): Int = {
    if (level == 5 || level == 6)
      2
    else
      0
  }

  override def level4SlotsPerLevel(level: Int): Int = {
    if (level == 7 || level == 8)
      2
    else
      0
  }

  override def level5SlotsPerLevel(level: Int): Int = {
    if (level < 9)
      0
    else if (level < 11)
      2
    else if (level < 17)
      3
    else
      4
  }

  // Warlock specific capability
  def invocationsPerLevel(level: Int): Int = {
    if (level < 2)
      0
    else if (level < 5)
      2
    else if (level < 7)
      3
    else if (level < 9)
      4
    else if (level < 12)
      5
    else if (level < 15)
      6
    else if (level < 18)
      7
    else
      8
  }


  private def createWarlockClassFeatures(): Map[Int, List[ClassFeature]] = {
    val workingMap = new mTreeMap[Int, List[ClassFeature]]()

    // Level 2
    val eldritch = new ClassFeature("Eldritch Invocations",
      "In your study of occult lore, you have unearthed eldritch invocations, fragments of \n" +
        "forbidden knowledge that imbue you with an abiding magical ability.\n" +
        "At 2nd level, you gain two eldritch invocations of your choice. Your invocation options are detailed \n" +
        "at the end of the class description in the Player's Handbook.  When you gain certain warlock levels, \n" +
        "you gain additional invocations of your choice, as shown in the Invocations Known column of the Warlock \n" +
        "table.\n" +
        "Additionally, when you gain a level in this class, you can choose one of the invocations you know and \n" +
        "replace it with another invocation that you could learn at that level.")
    workingMap.put(2, List(eldritch))

    // level 3
    val pact = new ClassFeature("Pact Boon",
      "At 3rd level, your otherworldly patron bestows a gift upon you for your loyal service.\n" +
        "You gain one of the following features of your choice.\n\n" +
        "PACT of the CHAIN\n" +
        "You learn the find familiar spell and can cast it as a ritual. The spell doesn't\n" +
        "count against your number of spells known.\n\n" +
        "When you cast the spell, you can choose one of the normal forms for your familiar or one of the\n" +
        "following special forms: imp, pseudodragon, quasit, or sprite.\n" +
        "Additionally, when you take the Attack action, you can forgo one of your own attacks to allow your\n" +
        "familiar to make one attack of its own with its reaction.\n\n" +
        "PACT of the BLADE\n" +
        "You can use your action to create a pact weapon in your empty hand. You can choose the form that this\n" +
        "melee weapon takes each time you create it.  You are proficient with it while you wield it. This weapon\n" +
        "counts as magical for the purpose of overcoming resistance and immunity to nonmagical attacks and damage.\n" +
        "Your pact weapon disappears if it is more than 5 feet away from you for 1 minute or more. It also\n" +
        "disappears if you use this feature again, if you dismiss the weapon (no action required), or if you die.\n" +
        "You can transform one magic weapon into your pact weapon by performing a special ritual while you hold the\n" +
        "weapon.  You perform the ritual over the course of 1 hour, which can be done during a short rest. You can\n" +
          "then dismiss the weapon, shunting it into an extradimensional space, and it appears whenever you create\n" +
          "your pact weapon thereafter. You can't affect an artifact or a sentient weapon in this way. The weapon\n" +
          "ceases being your pact weapon if you die, if you perform the 1-hour ritual on a different weapon, or if\n" +
          "you use a 1-hour ritual to break your bond to it.  The weapon appears at your feet if it is in the\n" +
          "extradimensional space when the bond breaks.\n\n" +
          "PACT of the TOME\n" +
          "Your patron gives you a grimoire called a Book of Shadows.  When you gain this feature, choose three\n" +
          "cantrips from any class's spell list (the three needn't be from the same list). While the book is on\n" +
          "your person, you can cast those cantrips at will.  They don't count against your number of cantrips\n" +
          "known.  If they don't appear on the warlock spell list, they are nonetheless warlock spells for you.\n\n" +
          "If you lose your Book of Shadows, you can perform a 1-hour ceremony to receive a replacement from your\n" +
          "patron.  This ceremony can be performed during a short or long rest, and it destroys the previous book.\n" +
          "The book turns to ash when you die." )
    workingMap.put(3, List(pact))

    // level 11
    val arcanum = new ClassFeature("Mystic Arcanum",
    "At 11th level, your patron bestows upon you a magical secret called an arcanum.  Choose one\n" +
      "6th- level spell from the warlock spell list as this arcanum.\n\n" +
      "You can cast your arcanum spell once without expending a spell slot.  You must finish a long rest\n" +
      "before you can do so again.\n\n" +
      "At higher levels, you gain more warlock spells of your choice that can be cast in this way: one\n" +
      "7th- level spell at 13th level, one 8th-level spell at 15th level, and one 9th-level spell at 17th\n" +
      "level.  You regain all uses of your Mystic Arcanum when you finish a long rest.")
    workingMap.put(11, List(arcanum))

    // level 20
    val master = new ClassFeature("Eldritch Master",
      "At 20th level, you can draw on your inner reserve of mystical power while entreating your\n" +
        "patron to regain expended spell slots. You can spend 1 minute entreating your patron for aid to regain\n" +
        "all your expended spell slots from your Pact Magic feature.  Once you regain spell slots with this\n" +
        "feature, you must finish a long rest before you can do so again.")
    workingMap.put(20, List(master))

    // return an immutable Map
    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }
}
