package org.boychemist.characterbuilder5.dnd5classes

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap
import org.boychemist.characterbuilder5._

object Dnd5Cleric extends Dnd5BasicClass with Dnd5SpellCaster {
  // basic class features
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Cleric
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val  specializationStartLevel: Int = 1
  val hitDice: String = "1d8"
  val armorProficiencies: List[String] = List("Light armor", "Medium armor", "Shields")
  val weaponProficiencies: List[String] = List("Simple weapons")
  val toolProficiencies: List[String] = List()
  val savingThrowProficiencies: List[DndAbilitiesEnum.Value] = List(DndAbilitiesEnum.Wisdom,
    DndAbilitiesEnum.Charisma)
  val skillChoices: List[String] = List("History", "Insight", "Medicine", "Persuasion", "Religion")
  val numberOfSkills: Int = 2
  val features: Map[Int, List[ClassFeature]] = createClericClassFeatures()
  override val specializationName: String = "Divine Domain"

  // spell caster features
  // defines the spell list to use when choosing spells
  val spellSourceType: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Cleric
  val  classLevelForFirstSpells: Int = 1
  val abilityModifierforDC_attack: DndAbilitiesEnum.Value = DndAbilitiesEnum.Wisdom
  // empty cleric, druid, or wizard (Wizards must have spells in spell book)
  val totalSpellsKnownByClassLevel: Vector[Int] = Vector()
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

  private def createClericClassFeatures(): Map[Int, List[ClassFeature]] = {
    var workingMap = new mTreeMap[Int, List[ClassFeature]]()

    val turnUndead = new ClassFeature("Channel Divinity: Turn Undead",
      "As an action, you present your holy symbol and speak a prayer censuring the undead. Each " +
        "undead that can see or hear you within 30 feet of you must make a Wisdom saving throw. If the creature " +
        "fails its saving throw, it is turned for 1 minute or until it takes any damage.\nA turned creature must " +
        "spend its turns trying to move as far away from you as it can, and it can't willingly move to a space " +
        "within 30 feet of you. It also can't take reactions. For its action, it can use only the Dash action or " +
    "try to escape from an effect that prevents it from moving. If there's nowhere to move, the creature can use " +
        "the Dodge action.")
    // level 2
    val channel = new ClassFeature("Channel Divinity",
      "At 2nd level, you gain the ability to channel divine energy directly from your deity, using " +
        "that energy to fuel magical effects. You start with two such effects: Turn Undead and an effect " +
        "determined by your domain. Some domains grant you additional effects as you advance in levels, as noted " +
        "in the domain description.\nWhen you use your Channel Divinity, you choose which effect to create. You " +
        "must then finish a short or long rest to use your Channel Divinity again. Some Channel Divinity effects " +
        "require saving throws. When you use such an effect from this class, the DC equals your cleric spell save " +
        "DC.\nBeginning at 6th level, you can use your Channel Divinity twice between rests, and beginning at " +
        "18th level, you can use it three times between rests. When you finish a short or long rest, you regain " +
        "your expended uses.")
    workingMap.put(2, List(turnUndead, channel))

    // level 5
    val destroy = new ClassFeature("Destroy Undead",
      "Starting at 5th level, when an undead fails its saving throw against your Turn Undead feature, " +
        "the creature is instantly destroyed if its challenge rating is at or below a certain threshold, as shown " +
        "in the Destroy Undead table.\nCleric Level \tDestroys Undead of CR...\n5th \t1/2 or lower\n8th \t1 or " +
        "lower\n11th \t2 or lower\n14th \t3 or lower\n17th \t4 or lower")
    workingMap.put(5, List(destroy))

    // level 10
    val intervene = new ClassFeature("Divine Intervention",
    "Beginning at 10th level, you can call on your deity to intervene on your behalf when your need " +
      "is great.\nImploring your deity's aid requires you to use your action. Describe the assistance you seek, " +
      "and roll percentile dice. If you roll a number equal to or lower than your cleric level, your deity " +
      "intervenes. The GM chooses the nature of the intervention; the effect of any cleric spell or cleric " +
      "domain spell would be appropriate.\nIf your deity intervenes, you can't use this feature again for 7 " +
      "days. Otherwise, you can use it again after you finish a long rest.\nAt 20th level, your call for " +
      "intervention succeeds automatically, no roll required.")
    workingMap.put(10, List(intervene))

    // return an immutable Map
    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }
}
