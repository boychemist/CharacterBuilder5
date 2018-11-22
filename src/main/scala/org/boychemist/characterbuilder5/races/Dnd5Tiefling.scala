package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5Tiefling extends Dnd5Race {
  override val race: Dnd5RacesEnum.Value = Dnd5RacesEnum.Tiefling
  override val size: DndCharacterSizeEnum.Value = DndCharacterSizeEnum.Medium
  override val baseSpeed = 30
  override val skillProficiencies = List() // player choice, see racial abilities
  override val weaponProficiencies = List()
  override val armorProficiencies = List()
  override val toolsForProficiency = List()
  override val abilityAdjustments: List[AbilityAdjustment] = createTieflingAbilityAdjustments()
  override val racialAbilities: List[RacialAbilitiy] = createTieflingRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Infernal)
  override def hitPointIncrement() = 0

  private def createTieflingAbilityAdjustments() = {
    val chaAdjust = new AbilityAdjustment(DndAbilitiesEnum.Charisma, 2)
    val intAdjust = new AbilityAdjustment(DndAbilitiesEnum.Intelligence, 1)
    List(chaAdjust, intAdjust)
  }

  private def createTieflingRacialAbilities() ={
    val darkvision = new RacialAbilitiy("Darkvision",
      "Thanks to your infernal heritage you have superior vision in dark and dim conditions. You can see in " +
        "dim light within 60 feet of you as if it were bright light, and in darkness as if it were dim light. You " +
        "can’t discern color in darkness, only shades of gray. ")

    val hellish = new RacialAbilitiy("Hellish Resistance",
      "You have resistance to fire damage.")

    val infernal = new RacialAbilitiy("Infernal Legacy",
      "You know the 'thaumaturgy' cantrip. When you reach 3rd level, you can cast the 'hellish rebuke' " +
        "spell as a 2nd-level spell once with this trait and regain the ability to do so when you finish a long " +
        "rest. When you reach 5th level, you can cast the 'darkness' spell once with this trait and regain the " +
        "ability to do so when you finish a long rest. Charisma is your spellcasting ability for these spells.")

    List(darkvision, hellish, infernal)
  }
}
