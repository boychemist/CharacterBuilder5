package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5WoodElf extends Dnd5Race {
  override val race = Dnd5RacesEnum.WoodElf
  override val size = DndCharacterSizeEnum.Medium
  override val baseSpeed = 35
  override val skillProficiencies = List()
  override val weaponProficiencies = List("longsword", "shortsword", "shortbow", "longbow")
  override val armorProficiencies = List() // Mountain Dwarf only
  override val toolsForProficiency = List()
  override val abilityAdjustments = createWoodElfAbilityAdjustments()
  override val racialAbilities = createWoodElfRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Elvish)
  override def hitPointIncrement() = 0

  private def createWoodElfAbilityAdjustments() = {
    val dexAdjust = new AbilityAdjustment(DndAbilitiesEnum.Dexterity, 2)
    val wisAdjust = new AbilityAdjustment(DndAbilitiesEnum.Wisdom, 1)
    List(dexAdjust, wisAdjust)
  }

  private def createWoodElfRacialAbilities() ={
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

    val wild = new RacialAbilitiy("Mask of the Wild",
    "You can attempt to hide even when you are only obscured by foliage, heavy rain, falling show, " +
    "mist, and other natural phenonomena.")

    List(darkVision, keenSense, feyAncestry, trance, wild)
  }
}
