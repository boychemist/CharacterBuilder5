package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5Drow extends Dnd5Race {
  override val race = Dnd5RacesEnum.Drow
  override val size = DndCharacterSizeEnum.Medium
  override val baseSpeed = 30
  override val skillProficiencies = List()
  override val weaponProficiencies = List("rapier", "shortsword", "hand crossbow")
  override val armorProficiencies = List() // Mountain Dwarf only
  override val toolsForProficiency = List()
  override val abilityAdjustments = createDrowAbilityAdjustments()
  override val racialAbilities = createDrowRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Elvish)
  override def hitPointIncrement() = 0

  private def createDrowAbilityAdjustments() = {
    val dexAdjust = new AbilityAdjustment(DndAbilitiesEnum.Dexterity, 2)
    val chaAdjust = new AbilityAdjustment(DndAbilitiesEnum.Charisma, 1)
    List(dexAdjust, chaAdjust)
  }

  private def createDrowRacialAbilities() ={
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

    val superDarkVision = new RacialAbilitiy("Superior Darkvision",
      "Your darkvision has a radius of 120 feet.")

    val sunSensitive = new RacialAbilitiy("Sunlight Sensitivity",
    "You have disadvantage on attack rolls and Whidom(Perception) checks that rely on sight when " +
    "you, the target of your attack, or whatever your are trying to perceive is in direct sunlight.")

    val drowMagic = new RacialAbilitiy("Drow Magic",
    "You know the 'dancing lights' cantrip.  When you reach 3rd level, you can cast the 'faerie fire' " +
    "spell once with this trait and regain the ability to do so when you finish a long rest.  When you reach 5th " +
    "level, you can cast the 'darkness' spell once with this trait and regain the ability to do so when you finish " +
    "a long rest.  Charisma is your spellcasting ability for these spells.")

    List(darkVision, keenSense, feyAncestry, trance, superDarkVision, sunSensitive, drowMagic)
  }
}
