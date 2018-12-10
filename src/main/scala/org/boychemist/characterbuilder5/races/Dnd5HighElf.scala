package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5HighElf extends Dnd5Race {
  override val race: Dnd5RacesEnum.Value = Dnd5RacesEnum.HighElf
  override val size: DndCharacterSizeEnum.Value = DndCharacterSizeEnum.Medium
  override val baseSpeed = 30
  override val skillProficiencies = List()
  override val weaponProficiencies = List("longsword", "shortsword", "shortbow", "longbow")
  override val armorProficiencies = List() // Mountain Dwarf only
  override val toolsForProficiency = List()
  override val abilityAdjustments: List[AbilityAdjustment] = createHighElfAbilityAdjustments()
  override val racialAbilities: List[RacialAbilitiy] = createHighElfRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Elvish)
  override def hitPointIncrement() = 0

  private def createHighElfAbilityAdjustments() = {
    val dexAdjust = new AbilityAdjustment(DndAbilitiesEnum.Dexterity, 2)
    val intAdjust = new AbilityAdjustment(DndAbilitiesEnum.Intelligence, 1)
    List(dexAdjust, intAdjust)
  }

  private def createHighElfRacialAbilities() ={
    val darkVision = new RacialAbilitiy("Darkvision",
      "You can see in dim light with 60 feet of your as if it were bright light, "+
        "and in darkness as if it were dim light.")

    val keenSense = new RacialAbilitiy("Keen Senses",
      "You have proficiency in the Perception skill")

    val feyAncestry = new RacialAbilitiy("Fey Ancestry",
      "You have advantage on saving throws against being charmed, and magic can't put you to sleep.")

    val trance = new RacialAbilitiy("Trance",
    "Elves don't need to sleep.  Instead, they meditate deeply, remaining semiconscious, for 4 hours " +
    "a day.  (The Common word for such meditation is \"trance.\")  While meditating, you can dream after a fashion; " +
    "such dreams are actually mental exercises that have become reflexive through years of practice.  After resting " +
    "in this way, you gain the same benefit that a human does from 8 hours of sleep.")

    val cantrip = new RacialAbilitiy("Cantrip",
    "You know one cantrip of your choice from the wizard spell list.  Intelligence is your spellcasting " +
    "ability for it.")

    val extraLanguage = new RacialAbilitiy("Extra Language",
    "You can speak, read, and write one extra language of your choice.")

    List(darkVision, keenSense, feyAncestry, trance, cantrip, extraLanguage)
  }
}
