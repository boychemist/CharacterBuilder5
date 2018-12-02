package org.boychemist.characterbuilder5.dnd5classes

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum

object Dnd5Wizard extends Dnd5BasicClass with Dnd5SpellCaster {
  // basic class features
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Wizard
  // specialization is the unique choice for class leveling and has different names for each class
  val allowedSpecializations: Vector[Dnd5SpecializationsEnum.Value] = Vector.empty  // todo -- remove this from base

  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val  specializationStartLevel: Int = 1
  val hitDice: String = "1d6"
  val armorProficiencies: List[String] = List()
  val weaponProficiencies: List[String] = List("Daggers", "Darts", "Slings", "Quarterstaffs", "Light crossbows")
  val toolProficiencies: List[String] = List()
  val savingThrowProficiencies: List[DndAbilitiesEnum.Value] = List(DndAbilitiesEnum.Intelligence,
    DndAbilitiesEnum.Wisdom)
  val skillChoices: List[String] = List("Arcana", "History", "Insight", "Investigation", "Medicine", "Religion")
  val numberOfSkills: Int = 2
  val features: Map[Int, List[ClassFeature]] = createWizardClassFeatures()

  // spell caster features
  // defines the spell list to use when choosing spells
  val spellSourceType: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Wizard
  val  classLevelForFirstSpells: Int = 1
  val abilityModifierforDC_attack: DndAbilitiesEnum.Value = DndAbilitiesEnum.Intelligence
  // empty cleric, druid, or wizard (Wizards must have spells in spell book)
  val totalSpellsKnownByClassLevel: Vector[Int] = Vector.empty
  // the level restriction for spell slots is the class level, not the character level
  // Eldrich Knights, Paladins, and Rangers don't have cantrips at any level and don't have
  // spell slots above certain levels (4 or 5).  Arcane Tricksters don't have spell slots above level 4.
  override def cantripsPerLevel(level: Int): Int = {
    if (level < 4)
      3
    else if (level < 10)
      4
    else
      5
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

  private def createWizardClassFeatures(): Map[Int, List[ClassFeature]] = {
    var workingMap = new mTreeMap[Int, List[ClassFeature]]()
    // level 18
    val mastery = new ClassFeature("Spell Mastery",
      "At 18th level, you have achieved such masery over certain spells that you can cast them at will.  " +
      "Choose a 1st-level wizard spell and a 2nd-level wizard spell that are in your spellbook.  You can cast those " +
      "spells at their lowest level without expending a spell slot when you have them prepared.  If you want to cast " +
      "either spell at a higher level, you must expend a spell slot as normal.\n" +
      "By spending 8 hours in study, you can exchange one or both of the spells you chose for different spells of the " +
      "same levels."
    )
    workingMap.put(18, List(mastery))

    // level 20
    val signature = new ClassFeature("Signature Spells",
      "When you reach 20th level, you gain mastery over two powerful spells and can cast them with little " +
    "effort.  Choose two 3rd-level wizard spells in your spellbook as your signature spells.  You always have these " +
    "spells prepared, they don't count against the number of spells you have prepared, and you can cast each of them " +
    "once at 3rd level without expending a spell slot.  When you do so, you can't do so again until you finish a " +
    "short or long rest.\n" +
    "If you want to cast either spell at a higher level, you must expend a spell slot as normal.")
    workingMap.put(20, List(signature))

    // return an immutable Map
    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }
}
