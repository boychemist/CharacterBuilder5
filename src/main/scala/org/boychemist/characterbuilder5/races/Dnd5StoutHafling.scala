package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5StoutHafling extends Dnd5Race {
  override val race = Dnd5RacesEnum.StoutHafling
  override val size = DndCharacterSizeEnum.Small
  override val baseSpeed = 25
  override val skillProficiencies = List()
  override val weaponProficiencies = List()
  override val armorProficiencies = List() // Mountain Dwarf only
  override val toolsForProficiency = List()
  override val abilityAdjustments = createStoutHaflingAbilityAdjustments()
  override val racialAbilities = createStoutHaflingRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Halfling)
  override def hitPointIncrement() = 0

  private def createStoutHaflingAbilityAdjustments() = {
    val dexAdjust = new AbilityAdjustment(DndAbilitiesEnum.Dexterity, 2)
    val conAdjust = new AbilityAdjustment(DndAbilitiesEnum.Constitution, 1)
    List(dexAdjust, conAdjust)
  }

  private def createStoutHaflingRacialAbilities() ={
    val lucky = new RacialAbilitiy("Lucky",
      "When you roll a 1 on the d20 for an attack roll, ability check, or saving throw, " +
        "you can reroll the die and must use the new roll.")

    val brave = new RacialAbilitiy("Brave",
      "You have advantage on saving throws against being freightened.")

    val nimbleness = new RacialAbilitiy("Hafling Nimbleness",
      "You can move through the space of any creature that is of a size larger then yours.")

    val resilience = new RacialAbilitiy("Stout Resilience",
      "You have advantage on saving throws against poison, and you have resistance against " +
    "poison damage.")

    List(lucky, brave, nimbleness, resilience)
  }
}
