package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5MountainDwarf extends Dnd5Race {
  override val race = Dnd5RacesEnum.MountainDwarf
  override val size = DndCharacterSizeEnum.Medium
  override val baseSpeed = 25
  override val skillProficiencies = List()
  override val weaponProficiencies = List("battleaxe", "handaxe", "light hammer", "warhammer")
  override val armorProficiencies = List("light armor", "medium armor")
  override val toolsForProficiency = List("smith's tools", "brewer's supplies", "mason's tools")
  override val abilityAdjustments = createMountainDwarfAbilityAdjustments()
  override val racialAbilities = createMountainDwarfRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Dwarvish)
  override def hitPointIncrement() = 0

  private def createMountainDwarfAbilityAdjustments() = {
    val conAdjust = new AbilityAdjustment(DndAbilitiesEnum.Constitution, 2)
    val strAdjust = new AbilityAdjustment(DndAbilitiesEnum.Strength, 2)
    List(conAdjust, strAdjust)
  }

  private def createMountainDwarfRacialAbilities() ={
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
