package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5ForestGnome extends Dnd5Race {
  override val race: Dnd5RacesEnum.Value = Dnd5RacesEnum.ForestGnome
  override val size: DndCharacterSizeEnum.Value = DndCharacterSizeEnum.Small
  override val baseSpeed = 25
  override val skillProficiencies = List()
  override val weaponProficiencies = List()
  override val armorProficiencies = List() // Mountain Dwarf only
  override val toolsForProficiency = List()
  override val abilityAdjustments: List[AbilityAdjustment] = createForestGnomeAbilityAdjustments()
  override val racialAbilities: List[RacialAbilitiy] = createForestGnomeRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Draconic)
  override def hitPointIncrement() = 0

  private def createForestGnomeAbilityAdjustments() = {
    val intAdjust = new AbilityAdjustment(DndAbilitiesEnum.Intelligence, 2)
    val dexAdjust = new AbilityAdjustment(DndAbilitiesEnum.Dexterity, 1)
    List(intAdjust, dexAdjust)
  }

  private def createForestGnomeRacialAbilities() ={
    val darkvision = new RacialAbilitiy("Darkvision",
      "Accustomed to live underground, you have superior vision in dark and dim conditions.  " +
    "You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it " +
    "were dim light.  You can't discern color in darkness, on shades of gray.")

    val cunning = new RacialAbilitiy("Gnome Cunning",
      "You have advantage on all Intelligence, Wisdom, and Charisma saving throws against magic.")

    val illusion = new RacialAbilitiy("Natural Illusionist",
      "You know the 'minor illusion' cantrip.  Intelligence is your spellcasting ability for it.")

    val speak = new RacialAbilitiy("Speak with Small Beasts",
    "Through sounds and gestures, you can communicate simple ideas with Small or smaller beasts.  " +
    "Forest gnomes love animals and often keep squirrels, badgers, rabbits, moles, woodpeckers, and other " +
    "creatures as beloved pets.")

    List(darkvision, cunning, illusion, speak)
  }
}
