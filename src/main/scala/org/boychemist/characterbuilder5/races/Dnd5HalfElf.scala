package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5HalfElf extends Dnd5Race {
  override val race: Dnd5RacesEnum.Value = Dnd5RacesEnum.HalfElf
  override val size: DndCharacterSizeEnum.Value = DndCharacterSizeEnum.Medium
  override val baseSpeed = 30
  override val skillProficiencies = List() // player choice, see racial abilities
  override val weaponProficiencies = List()
  override val armorProficiencies = List()
  override val toolsForProficiency = List()
  override val abilityAdjustments: List[AbilityAdjustment] = createHalfElfAbilityAdjustments()
  override val racialAbilities: List[RacialAbilitiy] = createHalfElfRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Elvish)
  override def hitPointIncrement() = 0

  private def createHalfElfAbilityAdjustments() = {
    val chaAdjust = new AbilityAdjustment(DndAbilitiesEnum.Charisma, 2)
    // two player choices, see racial abilities
    List(chaAdjust)
  }

  private def createHalfElfRacialAbilities() ={
    val darkvision = new RacialAbilitiy("Darkvision",
      "Thanks to your elf blood, you have superior vision in dark and dim conditions. You can see in " +
        "dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You " +
        "can’t discern color in darkness, only shades of gray. ")

    val ability = new RacialAbilitiy("Ability Score Increase",
      "Two abilities (other than Charisma) increase by 1 during character creation.")

    val fey = new RacialAbilitiy("Fey Ancestry",
      "You have advantage on saving throws against being charmed, and magic can’t put you to sleep.")

    val skill = new RacialAbilitiy("Skill Versatility",
      "You gain proficience it two skills of your choice.")

    val language = new RacialAbilitiy("Extra Language",
    "You get one extra language of your choice.")

    List(darkvision, ability, fey, skill, language)
  }
}
