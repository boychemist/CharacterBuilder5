package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5RockGnome extends Dnd5Race {
  override val race: Dnd5RacesEnum.Value = Dnd5RacesEnum.RockGnome
  override val size: DndCharacterSizeEnum.Value = DndCharacterSizeEnum.Small
  override val baseSpeed = 25
  override val skillProficiencies = List()
  override val weaponProficiencies = List()
  override val armorProficiencies = List() // Mountain Dwarf only
  override val toolsForProficiency = List("Tinker's Tools")
  override val abilityAdjustments: List[AbilityAdjustment] = createForestGnomeAbilityAdjustments()
  override val racialAbilities: List[RacialAbilitiy] = createForestGnomeRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Draconic)
  override def hitPointIncrement() = 0

  private def createForestGnomeAbilityAdjustments() = {
    val intAdjust = new AbilityAdjustment(DndAbilitiesEnum.Intelligence, 2)
    val conAdjust = new AbilityAdjustment(DndAbilitiesEnum.Constitution, 1)
    List(intAdjust, conAdjust)
  }

  private def createForestGnomeRacialAbilities() ={
    val darkvision = new RacialAbilitiy("Darkvision",
      "Accustomed to live underground, you have superior vision in dark and dim conditions.  " +
        "You can see in dim light within 60 feet of you as if it were bright light, and in darkness as if it " +
        "were dim light.  You can't discern color in darkness, on shades of gray.")

    val cunning = new RacialAbilitiy("Gnome Cunning",
      "You have advantage on all Intelligence, Wisdom, and Charisma saving throws against magic.")

    val illusion = new RacialAbilitiy("Artificier's Lore",
      "Whenever you make an Intelligence (History) check related to magic items, alchemical objects, " +
        "or technological devices, you can add twice your proficiency bonus, instead of any proficiency bonus you " +
        "normally apply. ")

    val speak = new RacialAbilitiy("Tinker",
      " You have proficiency with artisan’s tools (tinker’s tools). Using those tools, you can spend " +
        "1 hour and 10 gp worth of materials to construct a Tiny clockwork device (AC 5, 1 hp). The device ceases to " +
        "function after 24 hours (unless you spend 1 hour repairing it to keep the device functioning), or when you " +
        "use your action to dismantle it; at that time, you can reclaim the materials used to create it. You can have " +
        "up to three such devices active at a time. When you create a device, choose one of the following options:\n\n" +
        "Clockwork Toy.\n This toy is a clockwork animal, monster, or person, such as a frog, mouse, bird, dragon, or "+
        "soldier. When placed on the ground, the toy moves 5 feet across the ground on each of your turns in a random " +
        "direction. It makes noises as appropriate to the creature it represents.\n\n" +
        ":Fire Starter.\nThe device produces a miniature flame, which you can use to light a candle, torch, or " +
        "campfire. Using the device requires your action.\n\n" +
        "Music Box.\nWhen opened, this music box plays a single song at a moderate volume. The box stops playing " +
        "when it reaches the song’s end or when it is closed.")

    List(darkvision, cunning, illusion, speak)
  }
}
