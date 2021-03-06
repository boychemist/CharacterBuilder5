package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5HillDwarf extends Dnd5Race {
  override val race: Dnd5RacesEnum.Value = Dnd5RacesEnum.HillDwarf
  override val size: DndCharacterSizeEnum.Value = DndCharacterSizeEnum.Medium
  override val baseSpeed = 25
  override val skillProficiencies = List()
  override val weaponProficiencies = List("battleaxe", "handaxe", "light hammer", "warhammer")
  override val armorProficiencies = List() // only applies to Mountain Dwarves
  override val toolsForProficiency = List("smith's tools", "brewer's supplies", "mason's tools")
  override val abilityAdjustments: List[AbilityAdjustment] = createHillDwarfAbilityAdjustments()
  override val racialAbilities: List[RacialAbilitiy] = createHillDwarfRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Dwarvish)
  override def hitPointIncrement(): Int = 1

  private def createHillDwarfAbilityAdjustments() = {
    val conAdjust = new AbilityAdjustment(DndAbilitiesEnum.Constitution, 2)
    val wisdomAdjust = new AbilityAdjustment(DndAbilitiesEnum.Wisdom, 1)
    List(conAdjust, wisdomAdjust)
  }

  private def createHillDwarfRacialAbilities() ={
    val darkVision = new RacialAbilitiy("Darkvision",
      "You can see in dim light with 60 feet of your as if it were bright light, "+
    "and in darkness as if it were dim light.")

    val resilience = new RacialAbilitiy("Dwarven Resilience",
    "You have advantage on saving throws against poison, and you have resistence " +
    "against poison damage.")

    val stonecunning = new RacialAbilitiy("Stonecunning",
    "Whenever you make an Intelligence(History) check related to the origin of stonework, " +
    "you are considered proficient in the History skill and add double your proficiency bonus to the check, " +
    "instead of your normal proficiency bonus.")

    List(darkVision, resilience, stonecunning)
  }
}
