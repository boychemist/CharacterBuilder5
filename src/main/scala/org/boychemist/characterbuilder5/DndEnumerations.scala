package org.boychemist.characterbuilder5

/**
  * Declares the languages described in the table on page 82 of the v3.5 Player's Handbook
  */
object Dnd5LanguagesEnum extends Enumeration {
  // Standard Languages
  val Common = Value
  val Dwarvish = Value
  val Elvish = Value
  val Giant = Value
  val Gnoll = Value
  val Gnomish = Value
  val Goblin = Value
  val Halfling = Value
  val Orc = Value
  // Exotic Languages
  val Abyssal = Value
  val Celestial = Value
  val DeepSpeach = Value("Deep Speach")
  val Draconic = Value
  val Infernal = Value
  val Primordial = Value
  val Sylvan = Value
  val Undercommon = Value
}

/**
  * Declares the races described in Chapter 2 of the v3.5 Player's Handbook
  */
object Dnd5RacesEnum extends Enumeration {
  val Human = Value
  val HillDwarf = Value("Hill Dwarf")
  val MountainDwarf = Value("Mountain Dwarf")
  val HighElf = Value("High Elf")
  val WoodElf = Value("Wood Elf")
  val Drow = Value
  val ForestGnome = Value("Forest Gnome")
  val RockGnome = Value("Rock Gnome")
  val HalfElf = Value("Half-Elf")
  val HalfOrc = Value("Half-Orc")
  val LightfootHalfling = Value("Lightfoot Hafling")
  val StoutHafling = Value("Stout Hafling")
  val DragonBorn = Value
  val Tiefling = Value
}

object DndCharacterSizeEnum extends Enumeration {
  val Small, Medium, Large = Value
}

/**
  * Declares the classes described in Chapter 3 of the v3.5 Player's Handbook and the
  * prestige classes in Chapter 2 of the Complete Adventurer
  */
object Dnd5ClassesEnum extends Enumeration {
  val Barbarian = Value
  val Bard = Value
  val Cleric = Value
  val Druid = Value
  val Fighter = Value
  val Monk = Value
  val Paladin = Value
  val Ranger = Value
  val Rogue = Value
  val Sorcerer = Value
  val Warlock = Value
  val Wizard = Value
}

object DndAlignmentEnum extends Enumeration {
  val LawfulGood = Value("Lawful Good")
  val NeutralGood = Value("Neutral Good")
  val ChaoticGood = Value("Chaotic Good")
  val LawfulNeutral = Value("Lawful Neutral")
  val Neutral = Value("Neutral")
  val ChaoticNeutral = Value("Chaotic Neutral")
  val LawfulEvil = Value("Lawful Evil")
  val NeutralEvil = Value("Neutral Evil")
  val ChaoticEvil = Value("Chaotic Evil")
}

object Dnd5SkillsEnum extends Enumeration {
  val Athletics = Value
  val Acrobatics = Value
  val SleightOfHand = Value("Slieght of Hand")
  val Stealth = Value
  val Arcana = Value
  val History = Value
  val Investigation = Value
  val Nature = Value
  val Religion = Value
  val AnimalHandling = Value("Animal Handling")
  val Insight = Value
  val Medicine = Value
  val Perception = Value
  val Survival = Value
  val Deception = Value
  val Intimidation = Value
  val Performance = Value
  val Persuasion = Value
}

object DndAbilitiesEnum extends Enumeration {
  val Strength, Dexterity, Constitution, Intelligence, Wisdom, Charisma = Value
}
