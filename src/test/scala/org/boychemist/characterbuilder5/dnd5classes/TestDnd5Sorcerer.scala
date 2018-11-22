package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum
import org.boychemist.characterbuilder5._

class TestDnd5Sorcerer extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Sorcerer is '" + Dnd5ClassesEnum.Sorcerer.toString + "'") {
    assert(Dnd5Sorcerer.classID == Dnd5ClassesEnum.Sorcerer)
  }

  test("Dnd5Sorcerer has 2 allowed specializations (Sorcerous Origins)") {
    assert(Dnd5Sorcerer.allowedSpecializations.length == 2)
    assert(Dnd5Sorcerer.allowedSpecializations.head == Dnd5SpecializationsEnum.DraconicBloodline)
    assert(Dnd5Sorcerer.allowedSpecializations.last == Dnd5SpecializationsEnum.WildMagic)
  }

  test("Dnd5Sorcerer is specialized starting at level 1") {
    assert(Dnd5Sorcerer.specializationStartLevel == 1)
  }

  test("Dnd5Sorcerer hit dice is 1d6") {
    assert(Dnd5Sorcerer.hitDice == "1d6")
  }

  test("Dnd5Sorcerer is not proficient with armor or shields") {
    assert(Dnd5Sorcerer.armorProficiencies.isEmpty)
  }

  test("Dnd5Sorcerer is proficient with Daggers, Darts, Slings, Quarterstaffs, and Light crossbows") {
    assert(Dnd5Sorcerer.weaponProficiencies.length == 5)
    assert((Dnd5Sorcerer.weaponProficiencies count(_ == "Daggers")) == 1)
    assert((Dnd5Sorcerer.weaponProficiencies count(_ == "Darts")) == 1)
    assert((Dnd5Sorcerer.weaponProficiencies count(_ == "Slings")) == 1)
    assert((Dnd5Sorcerer.weaponProficiencies count(_ == "Quarterstaffs")) == 1)
    assert((Dnd5Sorcerer.weaponProficiencies count(_ == "Light crossbows")) == 1)
  }

  test("Dnd5Sorcerer has no tool proficiencies") {
    assert(Dnd5Sorcerer.toolProficiencies.isEmpty)
  }

  test("Dnd5Sorcerer has Wisdom and Charisma saving throw proficiencies") {
    assert(Dnd5Sorcerer.savingThrowProficiencies.length == 2)
    assert((Dnd5Sorcerer.savingThrowProficiencies count(_ == DndAbilitiesEnum.Constitution)) == 1)
    assert((Dnd5Sorcerer.savingThrowProficiencies count(_ == DndAbilitiesEnum.Charisma)) == 1)
  }

  test("Dnd5Sorcerer may choose from 6 skills (Arcana, Deception, Insight, Intimidation, Persuasion, " +
    "Religion") {
    assert(Dnd5Sorcerer.skillChoices.length == 6)
    assert((Dnd5Sorcerer.skillChoices count (_ == "Arcana")) == 1)
    assert((Dnd5Sorcerer.skillChoices count (_ == "Deception")) == 1)
    assert((Dnd5Sorcerer.skillChoices count (_ == "Insight")) == 1)
    assert((Dnd5Sorcerer.skillChoices count (_ == "Intimidation")) == 1)
    assert((Dnd5Sorcerer.skillChoices count (_ == "Persuasion")) == 1)
    assert((Dnd5Sorcerer.skillChoices count (_ == "Religion")) == 1)
  }

  test("Dnd5Sorcerer gets to choose 2 skills") {
    assert(Dnd5Sorcerer.numberOfSkills == 2)
  }

  test("Dnd5Sorcerer has 3 class features") {
    assert(Dnd5Sorcerer.getClassFeaturesUpToClassLevel(20).length == 3)
  }

  test("Dnd5Sorcerer has 1 2nd level class feature (Font of Magic)") {
    val features = Dnd5Sorcerer.getClassFeaturesForClassLevel(2)
    assert(features.length == 1)
    assert(features.head.name == "Font of Magic")
  }

  test("Dnd5Sorcerer has 1 3rd level class feature (Metamagic)") {
    val features = Dnd5Sorcerer.getClassFeaturesForClassLevel(3)
    assert(features.length == 1)
    assert(features.head.name == "Metamagic")
  }

  test("Dnd5Sorcerer has 1 20th level class feature (Sorcerous Restoration)") {
    val features = Dnd5Sorcerer.getClassFeaturesForClassLevel(20)
    assert(features.length == 1)
    assert(features.head.name == "Sorcerous Restoration")
  }

  //
  // spell caster abilities
  //

  test("Dnd5Sorcerer may know 4 cantrips at level 1, 2, and 3") {
    for (level <- 1 to 3)
      assert(Dnd5Sorcerer.cantripsPerLevel(level) == 4)
  }

  test("Dnd5Sorcerer may know 5 cantrips at levels 4 through 9") {
    for (level <- 4 to 9)
      assert(Dnd5Sorcerer.cantripsPerLevel(level) == 5)
  }

  test("Dnd5Sorcerer may know 6 cantrips at levels 10 through 20") {
    for (level <- 10 to 20)
      assert(Dnd5Sorcerer.cantripsPerLevel(level) == 6)
  }

  test("Dnd5Sorcerer knows 1 more spell than the character level at levels 1 through 11") {
    for (level <- 1 to 11)
      assert(Dnd5Sorcerer.totalSpellsKnownByClassLevel(level) == level + 1)
  }

  test("Dnd5Sorcerer knows 12 spells at level 12") {
    assert(Dnd5Sorcerer.totalSpellsKnownByClassLevel(12) == 12)
  }

  test("Dnd5Sorcerer knows 13 spells at levels 13 and 14") {
    for (level <- 13 to 14)
      assert(Dnd5Sorcerer.totalSpellsKnownByClassLevel(level) == 13)
  }

  test("Dnd5Sorcerer knows 14 spells at levels 15 and 16") {
    for (level <- 15 to 16)
      assert(Dnd5Sorcerer.totalSpellsKnownByClassLevel(level) == 14)
  }

  test("Dnd5Sorcerer knows 15 spells at levels 17 and 20") {
    for (level <- 17 to 20)
      assert(Dnd5Sorcerer.totalSpellsKnownByClassLevel(level) == 15)
  }

  test("Dnd5Sorcerer has 2 level 1 spell slots at level 1") {
    assert(Dnd5Sorcerer.firstLevelSlotsPerLevel(1) == 2)
  }

  test("Dnd5Sorcerer has 3 level 1 spell slots at level 2") {
    assert(Dnd5Sorcerer.firstLevelSlotsPerLevel(2) == 3)
  }

  test("Dnd5Sorcerer has 4 level 1 spell slots at levels 3 through 20") {
    for (level <- 3 to 20)
      assert(Dnd5Sorcerer.firstLevelSlotsPerLevel(level) == 4)
  }

  test("Dnd5Sorcerer has no 2nd level spell slots at levels 1 and 2") {
    for (level <- 1 to 2)
      assert(Dnd5Sorcerer.level2SlotsPerLevel(level) == 0)
  }

  test("Dnd5Sorcerer has 2 level 2 spell slots at level 3") {
    assert(Dnd5Sorcerer.level2SlotsPerLevel(3) == 2)
  }

  test("Dnd5Sorcerer has 3 2nd level spell slots at levels 4 through 20") {
    for (level <- 4 to 220)
      assert(Dnd5Sorcerer.level2SlotsPerLevel(level) == 3)
  }

  test("Dnd5Sorcerer has no 3rd level spell slots at levels 1 through 4") {
    for (level <- 1 to 4)
      assert(Dnd5Sorcerer.level3SlotsPerLevel(level) == 0)
  }

  test("Dnd5Sorcerer has 2 level 3 spell slots at level 5") {
    assert(Dnd5Sorcerer.level3SlotsPerLevel(5) == 2)
  }

  test("Dnd5Sorcerer has 3 3rd level spell slots at levels 6 through 20") {
    for (level <- 6 to 220)
      assert(Dnd5Sorcerer.level3SlotsPerLevel(level) == 3)
  }

  test("Dnd5Sorcerer has no 4th level spell slots at levels 1 through 6") {
    for (level <- 1 to 6)
      assert(Dnd5Sorcerer.level4SlotsPerLevel(level) == 0)
  }

  test("Dnd5Sorcerer has 1 4th level spell slots at level 7") {
    assert(Dnd5Sorcerer.level4SlotsPerLevel(7) == 1)
  }

  test("Dnd5Sorcerer has 2 4th level spell slots at level 8") {
    assert(Dnd5Sorcerer.level4SlotsPerLevel(8) == 2)
  }

  test("Dnd5Sorcerer has 3 4th level spell slots at levels 9 through 20") {
    for (level <- 9 to 20)
      assert(Dnd5Sorcerer.level4SlotsPerLevel(level) == 3)
  }

  test("Dnd5Sorcerer has no 5th level spell slots at levels 1 through 8") {
    for (level <- 1 to 8) {
      assert(Dnd5Sorcerer.level5SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Sorcerer has 1 5th level spell slot at level 9") {
    assert(Dnd5Sorcerer.level5SlotsPerLevel(9) == 1)
  }

  test("Dnd5Sorcerer has 2 5th level spell slots at levels 10 through 17") {
    for (level <- 10 to 17)
      assert(Dnd5Sorcerer.level5SlotsPerLevel(level) == 2)
  }

  test("Dnd5Sorcerer has 3 5th level spell slots at levels 18 through 207") {
    for (level <- 18 to 20)
      assert(Dnd5Sorcerer.level5SlotsPerLevel(level) == 3)
  }

  test("Dnd5Sorcerer has no 6th level spell slots at levels 1 through 10") {
    for (level <- 1 to 10) {
      assert(Dnd5Sorcerer.level6SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Sorcerer has 1 6th level spell slot at levels 11 through 18") {
    for (level <- 11 to 18) {
      assert(Dnd5Sorcerer.level6SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Sorcerer has 2 6th level spell slot at levels 19 and 20") {
    assert(Dnd5Sorcerer.level6SlotsPerLevel(19) == 2)
    assert(Dnd5Sorcerer.level6SlotsPerLevel(20) == 2)
  }

  test("Dnd5Sorcerer has no 7th level spell slots at levels 1 through 12") {
    for (level <- 1 to 10) {
      assert(Dnd5Sorcerer.level7SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Sorcerer has 1 7th level spell slot at levels 13 through 19") {
    for (level <- 13 to 19) {
      assert(Dnd5Sorcerer.level7SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Sorcerer has 2 7th level spell slot at level 20") {
    assert(Dnd5Sorcerer.level7SlotsPerLevel(20) == 2)
  }

  test("Dnd5Sorcerer has no 8th level spell slots at levels 1 through 14") {
    for (level <- 1 to 14) {
      assert(Dnd5Sorcerer.level8SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Sorcerer has 1 8th level spell slot at levels 15 through 20") {
    for (level <- 15 to 20) {
      assert(Dnd5Sorcerer.level8SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Sorcerer has no 9th level spell slots at levels 1 through 16") {
    for (level <- 1 to 16) {
      assert(Dnd5Sorcerer.level9SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Sorcerer has 1 9th level spell slot at levels 17 through 20") {
    for (level <- 17 to 20) {
      assert(Dnd5Sorcerer.level9SlotsPerLevel(level) == 1)
    }
  }
}
