package org.boychemist.characterbuilder5

import org.boychemist.characterbuilder5.dnd5classes._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5ClassSpecialization

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
  var characterClass: List[CharacterClassDescription] = List()
  var gear: List[CharacterGearItem] = List()
  var weapons: List[CharacterWeapon] = List()
  var armor: List[CharacterArmor] = List()
  var armorProficiencies: List[String] = List()
  var weaponProficiencies: List[String] = List()
  var toolProficiencies: List[String] = List()
  var skillProficiencies: List[String] = List()
  var characterLevel: Int = 1 // all characters start at level 1
  var maximumHitPoints: Int = 0
  var currentHitPoints: Int = 0
  var copper: Int = 0
  var silver: Int = 0
  var electrum: Int = 0
  var platinum: Int = 0
  var jewels: List[CharacterJewel] = List()
  /*
     data not saved in the database
  */
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

}

case class CharacterGearItem(name: String, weight: Double)

case class CharacterWeapon(name: String, hitDie: String, weight: Double, toHitBonus: Int, damageBonus: Int)

case class CharacterArmor(name: String, armorClass: Int, weight:Double, maxDexModifier: Int, stealthDisadvantage: Boolean,
                          minStrength: Int = 0)

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
  var specialization_id: Int = -1; // database primary key of the specialization
  /*
     data not saved in the database
  */
  var specialization: Dnd5ClassSpecialization = _
}
