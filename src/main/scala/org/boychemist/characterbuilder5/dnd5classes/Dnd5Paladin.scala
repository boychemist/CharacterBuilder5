package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap


object Dnd5Paladin extends Dnd5BasicClass with Dnd5SpellCaster {
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Paladin
  // specialization is the unique choice for class leveling and has different names for each class
  val allowedSpecializations: Vector[Dnd5SpecializationsEnum.Value] =
    Vector(Dnd5SpecializationsEnum.OathOfDevotion, Dnd5SpecializationsEnum.OathOfTheAncients,
      Dnd5SpecializationsEnum.OathOfVengeance)
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val specializationStartLevel: Int = 3
  def hitDice: String = "1d10"
  def armorProficiencies: List[String] = List("All armor", "Shields")
  def weaponProficiencies: List[String] = List("Simple weapons", "Martial weapons")
  def toolProficiencies: List[String] = List()
  def savingThrowProficiencies: List[DndAbilitiesEnum.Value] =
    List(DndAbilitiesEnum.Wisdom, DndAbilitiesEnum.Charisma)
  def skillChoices: List[String] = List("Athletics", "Insight", "Intimidation", "Medicine",
  "Persuasion", "Religion")
  def numberOfSkills: Int = 2
  def features: Map[Int, List[ClassFeature]] = createPaladinClassFeatures()

  // spell caster related features
  val spellSourceType: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Paladin  // defines the spell list to use when choosing spells
  val classLevelForFirstSpells: Int = 2
  val abilityModifierforDC_attack: DndAbilitiesEnum.Value = DndAbilitiesEnum.Charisma
  // empty cleric, paladin, druid, or wizard (Wizards must have spell in spell book)
  val totalSpellsKnownByClassLevel: Vector[Int] = Vector()
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

  private def createPaladinClassFeatures() = {
    val workingMap = new mTreeMap[Int, List[ClassFeature]]()
    // Level 1
    val sense = new ClassFeature("Divine Sense",
    "The presence of strong evil registers on your senses like a noxious odor, and powerful good rings " +
    "like heavenly music in your ears.  As an action, you can open your awareness to detect such forces.  Until the " +
    "end of your next turn, you know the location of any celestial, fiend, or undead within 60 feet of you that is " +
    "not behind total cover.  You know the type (celestial, fiend, or undead) of any being you sense, but not its " +
    "identity (the vampire Count Strahd von Zarovich, for instance).  Within the same radius, you also detect the " +
    "presence of any place or object that has been consecrated or desecrated, as with the 'hallow' spell.\n" +
    "You can use this feature a number of times equal to 1 + your Charisma modifier.  When you finish a long rest " +
    "you regain all expended uses.")

    val hands = new ClassFeature("Lay on Hands",
    "Your blessed touch can heal wounds.  You have a pool of healing power that replenishes when you " +
    "take a long rest.  With that pool you can restore a total number of hit points equal to your paladin level x 5.\n" +
    "As an action, you can touch a creature and draw power from the pool to restore a number of hit points to that " +
    "creature, up to the maximum amount remaining in your pool.\n" +
    "Alterantively, you can spend 5 hit points from you pool of healing to cure the target of one disease or " +
    "neutralize one poison affecting it.  You can cure multiple diseases and neutralize multiple poisons with a " +
    "single use of Lay on Hands, expending hit points separately for each one.\n" +
    "This feature has no effect on undead and constructs.")
    workingMap(1) = List(sense, hands)

    // Level 2
    val style = new ClassFeature("Fighting Style",
    "At 2nd level, you adopt a style of fighting as your speciality.  Choose one of the following " +
    "options.  You can't take a Fighting Style option more than once, even if you later get to choose again.\n\n" +
    "DEFENSE\nWhile you are wearing armor, you gain a +1 bonus to AC.\n\n" +
    "DUELING\nWhen you a weilding a melee weapon in one hand and no other weapons, you gain a +2 bonus to " +
    "damage rolls with that weapon.\n\n" +
    "GREAT WEAPON FIGHTING\nWhen you roll a 1 or a 2 on a damage die for an attack you make with a melee weapon " +
    "that your are weilding with two hands, you can reroll the die and must use the new roll.  The weapon must " +
    "have the two-handed or versatile property for you to gain this benefit.\n\n" +
    "PROTECTION\nWhen a creature you can see attacks a target other than you that is within 5 feet of you, you can " +
    "use your reaction to impose disadvantage on the attack roll.  You must be weilding a shield.")
    val casting = new ClassFeature("Spellcasting",
    "By 2nd level, you have learned to draw on divine magic through meditation and prayer to cast " +
    "spells as a cleric does.  See pages 84 and 85 in the Player's Handbook for a description of this ability.")
    val smite = new ClassFeature("Divine Smite",
    "Starting at 2nd level, when you hit a creature with a melee weapon attack, you can expend one " +
    "spell slot to deal radiant damage to the target, in addition to the weapon's damage.  The extra damage is " +
    "2d8 for a 1st level spell, plus 1d8 for each spell level higher than 1st, to a maximum of 5d8.  The damage " +
    "increases by 1d8 if the target is an undead or a fiend.")
    workingMap(2) = List(style, casting, smite)

    // Level 3
    val health = new ClassFeature("Divine Health",
    "By 3rd level, the divine magic flowing through you makes you immune to disease.")
    workingMap(3) = List(health)

    // Level 5
    val attack = new ClassFeature("Extra Attack",
    "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack " +
    "action on your turn.")
    workingMap(5) = List(attack)

    // Level 6
    val protection = new ClassFeature("Aura of Protection",
    "Starting at 6th level, whenever you or a friendly creature within 10 feet of you must make a " +
    "saving throw, the creature gains a bonus to the saving throw equal to your Charisma modifier (with a " +
    "minimum bonus of +1).  Your must be consious to grant this bonus.\n" +
    "At 18th level, the range of this aura increases to 30 feet.")
    workingMap(6) = List(protection)

    // Level 10
    val courage = new ClassFeature("Aura of Courage",
    "Starting at 10th level, you and friendly creatures within 10 feet of you can't be frightened " +
    "while you are conscious.\n" +
    "At 18th level, the range of this aura increases to 30 feet.")
    workingMap(10) = List(courage)

    // Level 11
    val improvedSmite = new ClassFeature("Improved Divine Smite",
    "By 11th level, you are so suffused with righteous might that all your melee weapon strikes " +
    "carry divine power with them.  Whenever you hit a creature with a melee weapon, ther creature takes an " +
    "extra 1d8 radiant damage.  If you also use your Divine Smite with an attack, you add this damage to the " +
    "extra damage of your Divine Smite.")
    workingMap(11) = List(improvedSmite)

    // Level 14
    val cleansing = new ClassFeature("Cleansing Touch",
    "Beginning at 14th level, you can use your action to end one spell on yourself or on one willing " +
    "creature that you touch.\n" +
    "You can use this feature a number of times equal to your Charisma modifier (a minimum of once).  You " +
    "regain expended uses when you finish a long rest.")
    workingMap(14) = List(cleansing)

    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }

}
