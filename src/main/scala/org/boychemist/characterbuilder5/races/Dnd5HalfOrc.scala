package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5HalfOrc extends Dnd5Race {
  override val race: Dnd5RacesEnum.Value = Dnd5RacesEnum.HalfOrc
  override val size: DndCharacterSizeEnum.Value = DndCharacterSizeEnum.Medium
  override val baseSpeed = 30
  override val skillProficiencies = List() // player choice, see racial abilities
  override val weaponProficiencies = List()
  override val armorProficiencies = List()
  override val toolsForProficiency = List()
  override val abilityAdjustments: List[AbilityAdjustment] = createHalfOrcAbilityAdjustments()
  override val racialAbilities: List[RacialAbilitiy] = createHalfOrcRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Orc)
  override def hitPointIncrement() = 0

  private def createHalfOrcAbilityAdjustments() = {
    val strAdjust = new AbilityAdjustment(DndAbilitiesEnum.Strength, 2)
    val conAdjust = new AbilityAdjustment(DndAbilitiesEnum.Constitution, 1)
    List(strAdjust, conAdjust)
  }

  private def createHalfOrcRacialAbilities() ={
    val darkvision = new RacialAbilitiy("Darkvision",
      "Thanks to your orc blood, you have superior vision in dark and dim conditions. You can see in " +
        "dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You " +
        "can’t discern color in darkness, only shades of gray. ")

    val manace = new RacialAbilitiy("Menacing",
      "You gain proficiency in the Intimidation skill.")

    val endurance = new RacialAbilitiy("Relentless Endurance",
      "When you are reduced to 0 hit points but not killed outright, you can drop to 1 hit point " +
        "instead. You can’t use this feature again until you finish a long rest.")

    val attack = new RacialAbilitiy("Savage Attacks",
      "When you score a critical hit with a melee weapon attack, you can roll one of the weapon’s " +
        "damage dice one additional time and add it to the extra damage of the critical hit.")

    List(darkvision, manace, endurance, attack)
  }
}
