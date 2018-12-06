package org.boychemist.characterbuilder5

import org.boychemist.characterbuilder5.dnd5classes._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5ClassSpecializationImpl

object Dnd5Character {
  lazy private val invalidCharacter = invalidChar
  private var referenceCharacter: Dnd5Character = invalidCharacter
  private var working: Dnd5Character = invalidCharacter

  private def invalidChar = {
    val invalid = new Dnd5Character()
    invalid.currentHitPoints = -999
    invalid
  }

  private def saveReference(): Unit = {
    if (working == invalidCharacter) {
      working = new Dnd5Character()
    }
    referenceCharacter = working
  }

  /**
    * Allows access to leveling information.
    */
  val minExperiencePointsPerLevel: Map[Int, Int] =
    Map(1 -> 0, 2 -> 300, 3 -> 900, 4 -> 2700, 5 -> 6500, 6 -> 14000, 7 -> 23000, 8 -> 34000, 9 -> 48000,
      10 -> 64000, 11 -> 85000, 12 -> 100000, 13 -> 140000, 14 -> 140000, 15 -> 165000, 16 -> 195000, 17 -> 225000,
      18 -> 265000, 19 -> 305000, 20 -> 355000)

  /**
    * Return an indication of whether or not the working Dnd5Character needs to be saved.
    *
    * @return true if the working instance needs to be saved, false otherwise
    */
  def needsSave: Boolean =
    working != invalidCharacter && referenceCharacter != invalidCharacter && working != referenceCharacter

  def startEditingCharacter(forEditing: Dnd5Character): Unit = {
    working = forEditing
    saveReference()
  }

  def editNewCharacter: Dnd5Character = {
    working = new Dnd5Character
    saveReference()
    working
  }

  def getWorkingCharacter: Dnd5Character = {
    if (working == invalidCharacter) {
      editNewCharacter
    } else
      working
  }

  case class CharacterGearItem(name: String,
                               weight: Double,
                               acAdjust: Int = 0,
                               toHitBonus: Int = 0,
                               damagenBonus: Int = 0,
                               abilityAdjustments: String = "")

  case class CharacterWeapon(name: String,
                             hitDie: String,
                             weight: Double,
                             toHitBonus: Int = 0,
                             damageBonus: Int = 0,
                             abilityAdjustments: String = "")

  case class CharacterArmor(name: String,
                            armorClass: Int,
                            weight: Double,
                            maxDexModifier: Int,
                            stealthDisadvantage: Boolean,
                            minStrength: Int = 0,
                            acAdjust: Int = 0,
                            toHitBonus: Int = 0,
                            damageBonus: Int = 0,
                            abilityAdjustments: String = "")

  case class CharacterJewel(name: String, value: Int, count: Int = 1)

  class CharacterClassDescription(charClass: String) {
    /*
       data that is saved in the database
     */
    val dndClass: Dnd5BasicClass =
      Dnd5ClassesEnum.withName(charClass) match {
        case Dnd5ClassesEnum.Barbarian => Dnd5Barbarian
        case Dnd5ClassesEnum.Bard => Dnd5Bard
        case Dnd5ClassesEnum.Cleric => Dnd5Cleric
        case Dnd5ClassesEnum.Druid => Dnd5Druid
        case Dnd5ClassesEnum.Fighter => Dnd5Fighter
        case Dnd5ClassesEnum.Monk => Dnd5Monk
        case Dnd5ClassesEnum.Paladin => Dnd5Paladin
        case Dnd5ClassesEnum.Ranger => Dnd5Ranger
        case Dnd5ClassesEnum.Rogue => Dnd5Rogue
        case Dnd5ClassesEnum.Sorcerer => Dnd5Sorcerer
        case Dnd5ClassesEnum.Warlock => Dnd5Warlock
        case Dnd5ClassesEnum.Wizard => Dnd5Wizard
      }
    var level: Int = 1 // all classes start at level 1
    var specialization_id
    : Int = -1; // database primary key of the specialization
    /*
       data not saved in the database
     */
    var specialization: Dnd5ClassSpecializationImpl = _
  }

}

/**
  * This class contains the attributes of a Dungeons and Dragons Version 5 character.
  */
class Dnd5Character {
  /*
     data that is saved in the database
   */
  var name: String = "" // unique key in the database
  var race: Dnd5RacesEnum.Value = Dnd5RacesEnum.NotSet
  var size: DndCharacterSizeEnum.Value = DndCharacterSizeEnum.NotSet
  var characterClass: List[Dnd5Character.CharacterClassDescription] = List()
  var gear: List[Dnd5Character.CharacterGearItem] = List()
  var equippedGear: List[Dnd5Character.CharacterGearItem] = List()
  var weapons: List[Dnd5Character.CharacterWeapon] = List()
  var equippedWeapons: List[Dnd5Character.CharacterWeapon] = List()
  var armor: List[Dnd5Character.CharacterArmor] = List()
  var equippedArmor: List[Dnd5Character.CharacterArmor] = List()
  var armorProficiencies: List[String] = List()
  var weaponProficiencies: List[String] = List()
  var toolProficiencies: List[String] = List()
  var skillProficiencies: List[String] = List()
  var characterLevel: Int = 1 // all characters start at level 1
  var experiencePoints: Int = 0 // all characters start with 0 experience
  var checkPoints: Int = 0 // alternate experience determination mechanism
  var treasurePoints: Int = 0 // alternate mechanism for getting magic items
  var maximumHitPoints: Int = 0
  var currentHitPoints: Int = 0
  var copper: Int = 0
  var silver: Int = 0
  var electrum: Int = 0
  var gold: Int = 0
  var platinum: Int = 0
  var jewels: List[Dnd5Character.CharacterJewel] = List()
  var strength: Int = 8
  var constitution: Int = 8
  var dexterity: Int = 8
  var intelligence: Int = 8
  var wisdom: Int = 8
  var charisma: Int = 8
  var draconicAncestry: String = "" // Dragonborn and draconic sorcerer only
  var characterId: Int = -1 // not set value

  /*
     stuff not saved in the database
   */

  def strengthModifier: Int = calculateAbilityModifier(strength)

  def constitutionModifier: Int = calculateAbilityModifier(constitution)

  def dexterityModifier: Int = calculateAbilityModifier(dexterity)

  def intelligenceModifier: Int = calculateAbilityModifier(intelligence)

  def wisdomModifier: Int = calculateAbilityModifier(wisdom)

  def charismaModifier: Int = calculateAbilityModifier(charisma)

  private def calculateAbilityModifier(abilityScore: Int): Int = {
    (((abilityScore - 10) / 2.0) - 0.5).toInt
  }

  def totalWeightCarried: Int = {
    var totalWeight = 0.0
    if (gear.nonEmpty) {
      val gearIter = gear.iterator
      while (gearIter.hasNext) {
        totalWeight += gearIter.next().weight
      }
    }
    if (armor.nonEmpty) {
      val armorIter = armor.iterator
      while (armorIter.hasNext) {
        totalWeight += armorIter.next().weight
      }
    }
    if (weapons.nonEmpty) {
      val weaponIter = weapons.iterator
      while (weaponIter.hasNext) {
        totalWeight += weaponIter.next().weight
      }
    }
    Math.round(totalWeight).toInt
  }

  def proficiencyBonus: Int = {
    if (characterLevel < 5)
      2
    else if (characterLevel < 9)
      3
    else if (characterLevel < 13)
      4
    else if (characterLevel < 17)
      5
    else
      6
  }

  // equality testing
  def canEqual(other: Any): Boolean = {
    other.isInstanceOf[Dnd5Character]
  }

  override def equals(other: Any): Boolean = {
    other match {
      case that: Dnd5Character =>
        (that canEqual this) &&
          name == that.name &&
          race == that.race &&
          characterClass == that.characterClass &&
          gear == that.gear &&
          equippedGear == that.equippedGear &&
          weapons == that.weapons &&
          equippedWeapons == that.equippedWeapons &&
          armor == that.armor &&
          equippedArmor == that.equippedArmor &&
          armorProficiencies == that.armorProficiencies &&
          weaponProficiencies == that.weaponProficiencies &&
          toolProficiencies == that.toolProficiencies &&
          characterLevel == that.characterLevel &&
          experiencePoints == that.experiencePoints &&
          checkPoints == that.experiencePoints &&
          treasurePoints == that.treasurePoints &&
          maximumHitPoints == that.maximumHitPoints &&
          currentHitPoints == that.currentHitPoints &&
          copper == that.copper &&
          silver == that.silver &&
          electrum == that.electrum &&
          gold == that.gold &&
          platinum == that.platinum &&
          jewels == that.jewels &&
          strength == that.strength &&
          constitution == that.constitution &&
          dexterity == that.dexterity &&
          intelligence == that.intelligence &&
          wisdom == that.wisdom &&
          charisma == that.charisma &&
          characterId == that.characterId &&
          draconicAncestry == that.draconicAncestry &&
          characterId == that.characterId

      case _ => false
    }
  }

  override def hashCode: Int = {
    ((name,
      race,
      size,
      characterClass.hashCode,
      gear.hashCode,
      equippedGear.hashCode,
      weapons.hashCode,
      equippedWeapons.hashCode,
      armor.hashCode,
      equippedArmor.hashCode,
      armorProficiencies.hashCode,
      weaponProficiencies.hashCode,
      toolProficiencies.hashCode,
      skillProficiencies.hashCode,
      characterLevel).##,
      experiencePoints,
      checkPoints,
      treasurePoints,
      maximumHitPoints,
      currentHitPoints,
      copper,
      silver,
      electrum,
      gold,
      platinum,
      jewels.hashCode,
      strength,
      constitution,
      dexterity,
      intelligence,
      wisdom,
      charisma,
      characterId,
      draconicAncestry).##
  }

  def copy: Dnd5Character = {
    val theCopy = new Dnd5Character()
    theCopy.name = name
    theCopy.race = race
    theCopy.size = size
    theCopy.characterClass = characterClass
    theCopy.gear = gear
    theCopy.equippedGear = equippedGear
    theCopy.weapons = weapons
    theCopy.equippedWeapons = equippedWeapons
    theCopy.armorProficiencies = armorProficiencies
    theCopy.weaponProficiencies = weaponProficiencies
    theCopy.toolProficiencies = toolProficiencies
    theCopy.skillProficiencies = skillProficiencies
    theCopy.characterLevel = characterLevel
    theCopy.experiencePoints = experiencePoints
    theCopy.checkPoints = checkPoints
    theCopy.treasurePoints = treasurePoints
    theCopy.maximumHitPoints = maximumHitPoints
    theCopy.currentHitPoints = currentHitPoints
    theCopy.copper = copper
    theCopy.silver = silver
    theCopy.electrum = electrum
    theCopy.gold = gold
    theCopy.platinum = platinum
    theCopy.jewels = jewels
    theCopy.strength = strength
    theCopy.dexterity = dexterity
    theCopy.intelligence = intelligence
    theCopy.wisdom = wisdom
    theCopy.charisma = charisma
    theCopy.characterId = characterId

    theCopy
  }

  // todo -- add a method to compute hit bonus and damage bonus for a weapon (includes proficiency bonus and other pluses)
  // todo -- add a method to compute armor class based on what is equipped, class, dexterity, and other factors
}