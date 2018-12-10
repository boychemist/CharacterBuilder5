package org.boychemist.characterbuilder5

/**
  * Declares the languages described in the table on page 82 of the v3.5 Player's Handbook
  */
object Dnd5LanguagesEnum extends Enumeration {
  // Standard Languages
  val Common: Value = Value
  val Dwarvish: Value = Value
  val Elvish: Value = Value
  val Giant: Value = Value
  val Gnoll: Value = Value
  val Gnomish: Value = Value
  val Goblin: Value = Value
  val Halfling: Value = Value
  val Orc: Value = Value
  // Exotic Languages
  val Abyssal: Value = Value
  val Celestial: Value = Value
  val DeepSpeach: Value = Value("Deep Speach")
  val Draconic: Value = Value
  val Infernal: Value = Value
  val Primordial: Value = Value
  val Sylvan: Value = Value
  val Undercommon: Value = Value
}

/**
  * Declares the races described in Chapter 2 of the v3.5 Player's Handbook
  */
object Dnd5RacesEnum extends Enumeration {
  val Human: Value = Value
  val HillDwarf: Value = Value("Hill Dwarf")
  val MountainDwarf: Value = Value("Mountain Dwarf")
  val HighElf: Value = Value("High Elf")
  val WoodElf: Value = Value("Wood Elf")
  val Drow: Value = Value
  val ForestGnome: Value = Value("Forest Gnome")
  val RockGnome: Value = Value("Rock Gnome")
  val HalfElf: Value = Value("Half-Elf")
  val HalfOrc: Value = Value("Half-Orc")
  val LightfootHalfling: Value = Value("Lightfoot Hafling")
  val StoutHafling: Value = Value("Stout Hafling")
  val DragonBorn: Value = Value
  val Tiefling: Value = Value
}

object DndCharacterSizeEnum extends Enumeration {
  val Small, Medium, Large = Value
}

/**
  * Declares the classes described in Chapter 3 of the v3.5 Player's Handbook and the
  * prestige classes in Chapter 2 of the Complete Adventurer
  */
object Dnd5ClassesEnum extends Enumeration {
  val Barbarian: Value = Value
  val Bard: Value = Value
  val Cleric: Value = Value
  val Druid: Value = Value
  val Fighter: Value = Value
  val Monk: Value = Value
  val Paladin: Value = Value
  val Ranger: Value = Value
  val Rogue: Value = Value
  val Sorcerer: Value = Value
  val Warlock: Value = Value
  val Wizard: Value = Value
}

object DndAlignmentEnum extends Enumeration {
  val LawfulGood: Value = Value("Lawful Good")
  val NeutralGood: Value = Value("Neutral Good")
  val ChaoticGood: Value = Value("Chaotic Good")
  val LawfulNeutral: Value = Value("Lawful Neutral")
  val Neutral: Value = Value("Neutral")
  val ChaoticNeutral: Value = Value("Chaotic Neutral")
  val LawfulEvil: Value = Value("Lawful Evil")
  val NeutralEvil: Value = Value("Neutral Evil")
  val ChaoticEvil: Value = Value("Chaotic Evil")
}

object Dnd5SkillsEnum extends Enumeration {
  val Athletics: Value = Value
  val Acrobatics: Value = Value
  val SleightOfHand: Value = Value("Slieght of Hand")
  val Stealth: Value = Value
  val Arcana: Value = Value
  val History: Value = Value
  val Investigation: Value = Value
  val Nature: Value = Value
  val Religion: Value = Value
  val AnimalHandling: Value = Value("Animal Handling")
  val Insight: Value = Value
  val Medicine: Value = Value
  val Perception: Value = Value
  val Survival: Value = Value
  val Deception: Value = Value
  val Intimidation: Value = Value
  val Performance: Value = Value
  val Persuasion: Value = Value
}

object DndAbilitiesEnum extends Enumeration {
  val Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma = Value
}
