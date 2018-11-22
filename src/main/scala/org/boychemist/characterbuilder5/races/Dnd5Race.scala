package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

class RacialAbilitiy(val abilityName: String, val description: String)

class AbilityAdjustment(val ability: DndAbilitiesEnum.Value, val amount: Int)

/**
  * Define the data that describes a race in Dungeons and Dragons version 5.
  */
trait Dnd5Race {
  def race: Dnd5RacesEnum.Value
  def size: DndCharacterSizeEnum.Value
  def baseSpeed: Int
  def skillProficiencies: List[Dnd5SkillsEnum.Value]
  def weaponProficiencies: List[String]
  def armorProficiencies: List[String] // only applies to Mountain Dwarves
  def toolsForProficiency: List[String]
  def abilityAdjustments: List[AbilityAdjustment]
  def racialAbilities: List[RacialAbilitiy]
  def languages: List[Dnd5LanguagesEnum.Value]

  /**
    * Hill Dwarves have the Dwarven Toughness ability which adds 1 to the Hit Points added at
    * each level.  All other races / sub-races do not provide this ability.
    *
    * @return number of hit points to add at each level after the die is rolled.
    */
  def hitPointIncrement() = 0
}
