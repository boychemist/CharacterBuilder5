package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum
import org.boychemist.characterbuilder5._

class TestDnd5Bard extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Bard is '" + Dnd5ClassesEnum.Bard.toString + "'") {
    assert(Dnd5Bard.classID == Dnd5ClassesEnum.Bard)
  }

  test("Dnd5Bard has two allowed specializations (College of Lore and College of Valor)") {
    assert(Dnd5Bard.allowedSpecializations.length == 2)
    assert(Dnd5Bard.allowedSpecializations(0) == Dnd5SpecializationsEnum.CollegeOfLore)
    assert(Dnd5Bard.allowedSpecializations(1) == Dnd5SpecializationsEnum.CollegeOfValor)
  }

  test("Dnd5Bard is specialized starting at level 3") {
    assert(Dnd5Bard.specializationStartLevel == 3)
  }

  test("Dnd5Bard hit dice is 1d8") {
    assert(Dnd5Bard.hitDice == "1d8")
  }

  test("Dnd5Bard is proficient with light armor") {
    assert(Dnd5Bard.armorProficiencies.length == 1)
    assert(Dnd5Bard.armorProficiencies.head == "Light armor")
  }

  test("Dnd5Bard is proficient with simple weapons, hand crossbows, longswords, rapiers, and shortswords") {
    assert(Dnd5Bard.weaponProficiencies.length == 5)
    assert((Dnd5Bard.weaponProficiencies count(_ == "Simple weapons")) == 1)
    assert((Dnd5Bard.weaponProficiencies count(_ == "Hand crossbows")) == 1)
    assert((Dnd5Bard.weaponProficiencies count(_ == "longswords")) == 1)
    assert((Dnd5Bard.weaponProficiencies count(_ == "rapiers")) == 1)
    assert((Dnd5Bard.weaponProficiencies count(_ == "shortswords")) == 1)
  }

  test("Dnd5Bard may choose 3 instruments as tool proficiencies") {
    assert(Dnd5Bard.toolProficiencies.length == 1)
    assert(Dnd5Bard.toolProficiencies.head == "Three musical instruments of your choice")
  }

  test("Dnd5Bard has Dexterity and Charisma saving throw proficiencies") {
    assert(Dnd5Bard.savingThrowProficiencies.length == 2)
    assert((Dnd5Bard.savingThrowProficiencies count(_ == DndAbilitiesEnum.Dexterity)) == 1)
    assert((Dnd5Bard.savingThrowProficiencies count(_ == DndAbilitiesEnum.Charisma)) == 1)
  }

//  test("Dnd5Bard may choose from all skills") {
//    assert(Dnd5Bard.skillChoices.length == 1)
//    assert(Dnd5Bard.skillChoices.head == "Choose any 3")
//  }

  test("Dnd5Bard gets to choose 3 skills") {
    assert(Dnd5Bard.numberOfSkills == 3)
  }

  test("Dnd5Bard has 8 class features") {
    assert(Dnd5Bard.getClassFeaturesUpToClassLevel(20).length == 8)
  }

  test("Dnd5Bard has 1 first level class features (Bardic Inspiration)") {
    val features = Dnd5Bard.getClassFeaturesForClassLevel(1)
    assert(features.length == 1)
    assert(features.head.name == "Bardic Inspiration")
  }

  test("Dnd5Bard has 2 second level class features (Jack of All Trades and Song of Rest)") {
    val features = Dnd5Bard.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert(features.head.name == "Jack of All Trades")
    assert(features(1).name == "Song of Rest")
  }

  test("Dnd5Bard has 1 3rd level class feature (Expertise)") {
    val features = Dnd5Bard.getClassFeaturesForClassLevel(3)
    assert(features.length == 1)
    assert(features.head.name == "Expertise")
  }

  test("Dnd5Bard has 1 5th level class feature (Font of Inspiration)") {
    val features = Dnd5Bard.getClassFeaturesForClassLevel(5)
    assert(features.length == 1)
    assert(features.head.name == "Font of Inspiration")
  }

  test("Dnd5Bard has 1 6th level class feature (Countercharm)") {
    val features = Dnd5Bard.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Countercharm")
  }

  test("Dnd5Bard has 1 10th level class feature (Magical Secrets)") {
    val features = Dnd5Bard.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Magical Secrets")
  }

  test("Dnd5Bard has 1 20th level class feature (Superior Inspiration)") {
    val features = Dnd5Bard.getClassFeaturesForClassLevel(20)
    assert(features.length == 1)
    assert(features.head.name == "Superior Inspiration")
  }

  //
  // spell caster abilities
  //

  test("Dnd5Bard may know 2 cantrips at level 1, 2, and 3") {
    for (level <- 1 to 3)
      assert(Dnd5Bard.cantripsPerLevel(level) == 2)
  }

  test("Dnd5Bard may know 3 cantrips at levels 4 through 9") {
    for (level <- 4 to 9)
      assert(Dnd5Bard.cantripsPerLevel(level) == 3)
  }

  test("Dnd5Bard may know 4 cantrips at levels 10 through 20") {
    for (level <- 10 to 20)
      assert(Dnd5Bard.cantripsPerLevel(level) == 4)
  }

  test("Dnd5Bard may know 4 spells at level 1") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(1) == 4)
  }

  test("Dnd5Bard may know 5 spells at level 2") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(2) == 5)
  }

  test("Dnd5Bard may know 6 spells at level 3") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(3) == 6)
  }

  test("Dnd5Bard may know 7 spells at level 4") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(4) == 7)
  }

  test("Dnd5Bard may know 8 spells at level 5") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(5) == 8)
  }

  test("Dnd5Bard may know 9 spells at level 6") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(6) == 9)
  }

  test("Dnd5Bard may know 10 spells at level 7") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(7) == 10)
  }

  test("Dnd5Bard may know 11 spells at level 8") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(8) == 11)
  }

  test("Dnd5Bard may know 12 spells at level 9") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(9) == 12)
  }

  test("Dnd5Bard may know 14 spells at level 10") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(10) == 14)
  }

  test("Dnd5Bard may know 15 spells at levels 11 and 12") {
    for (level <- 11 to 12)
      assert(Dnd5Bard.totalSpellsKnownByClassLevel(level) == 15)
  }

  test("Dnd5Bard may know 16 spells at level 13") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(13) == 16)
  }

  test("Dnd5Bard may know 18 spells at level 14") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(14) == 18)
  }

  test("Dnd5Bard may know 19 spells at levels 15 and 16") {
    for (level <- 15 to 16)
     assert(Dnd5Bard.totalSpellsKnownByClassLevel(level) == 19)
  }

  test("Dnd5Bard may know 20 spells at level 17") {
    assert(Dnd5Bard.totalSpellsKnownByClassLevel(17) == 20)
  }

  test("Dnd5Bard may know 22 spells at levels 18, 19, and 20") {
    for (level <- 18 to 20)
      assert(Dnd5Bard.totalSpellsKnownByClassLevel(level) == 22)
  }

  test("Dnd5Bard has 2 level 1 spell slots at level 1") {
    assert(Dnd5Bard.firstLevelSlotsPerLevel(1) == 2)
  }

  test("Dnd5Bard has 3 level 1 spell slots at level 2") {
    assert(Dnd5Bard.firstLevelSlotsPerLevel(2) == 3)
  }

  test("Dnd5Bard has 4 level 1 spell slots at levels 3 through 20") {
    for (level <- 3 to 20)
      assert(Dnd5Bard.firstLevelSlotsPerLevel(level) == 4)
  }

  test("Dnd5Bard has no 2nd level spell slots at levels 1 and 2") {
    for (level <- 1 to 2)
      assert(Dnd5Bard.level2SlotsPerLevel(level) == 0)
  }

  test("Dnd5Bard has 2 level 2 spell slots at level 3") {
    assert(Dnd5Bard.level2SlotsPerLevel(3) == 2)
  }

  test("Dnd5Bard has 3 2nd level spell slots at levels 4 through 20") {
    for (level <- 4 to 220)
      assert(Dnd5Bard.level2SlotsPerLevel(level) == 3)
  }

  test("Dnd5Bard has no 3rd level spell slots at levels 1 through 4") {
    for (level <- 1 to 4)
      assert(Dnd5Bard.level3SlotsPerLevel(level) == 0)
  }

  test("Dnd5Bard has 2 level 3 spell slots at level 5") {
    assert(Dnd5Bard.level3SlotsPerLevel(5) == 2)
  }

  test("Dnd5Bard has 3 3rd level spell slots at levels 6 through 20") {
    for (level <- 6 to 220)
      assert(Dnd5Bard.level3SlotsPerLevel(level) == 3)
  }

  test("Dnd5Bard has no 4th level spell slots at levels 1 through 6") {
    for (level <- 1 to 6)
      assert(Dnd5Bard.level4SlotsPerLevel(level) == 0)
  }

  test("Dnd5Bard has 1 4th level spell slots at level 7") {
    assert(Dnd5Bard.level4SlotsPerLevel(7) == 1)
  }

  test("Dnd5Bard has 2 4th level spell slots at level 8") {
    assert(Dnd5Bard.level4SlotsPerLevel(8) == 2)
  }

  test("Dnd5Bard has 3 4th level spell slots at levels 9 through 20") {
    for (level <- 9 to 20)
      assert(Dnd5Bard.level4SlotsPerLevel(level) == 3)
  }

  test("Dnd5Bard has no 5th level spell slots at levels 1 through 8") {
    for (level <- 1 to 8) {
      assert(Dnd5Bard.level5SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Bard has 1 5th level spell slot at level 9") {
    assert(Dnd5Bard.level5SlotsPerLevel(9) == 1)
  }

  test("Dnd5Bard has 2 5th level spell slots at levels 10 through 17") {
    for (level <- 10 to 17)
      assert(Dnd5Bard.level5SlotsPerLevel(level) == 2)
  }

  test("Dnd5Bard has 3 5th level spell slots at levels 18 through 207") {
    for (level <- 18 to 20)
      assert(Dnd5Bard.level5SlotsPerLevel(level) == 3)
  }

  test("Dnd5Bard has no 6th level spell slots at levels 1 through 10") {
    for (level <- 1 to 10) {
      assert(Dnd5Bard.level6SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Bard has 1 6th level spell slot at levels 11 through 18") {
    for (level <- 11 to 18) {
      assert(Dnd5Bard.level6SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Bard has 2 6th level spell slot at levels 19 and 20") {
    assert(Dnd5Bard.level6SlotsPerLevel(19) == 2)
    assert(Dnd5Bard.level6SlotsPerLevel(20) == 2)
  }

  test("Dnd5Bard has no 7th level spell slots at levels 1 through 12") {
    for (level <- 1 to 10) {
      assert(Dnd5Bard.level7SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Bard has 1 7th level spell slot at levels 13 through 19") {
    for (level <- 13 to 19) {
      assert(Dnd5Bard.level7SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Bard has 2 7th level spell slot at level 20") {
    assert(Dnd5Bard.level7SlotsPerLevel(20) == 2)
  }

  test("Dnd5Bard has no 8th level spell slots at levels 1 through 14") {
    for (level <- 1 to 14) {
      assert(Dnd5Bard.level8SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Bard has 1 8th level spell slot at levels 15 through 20") {
    for (level <- 15 to 20) {
      assert(Dnd5Bard.level8SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Bard has no 9th level spell slots at levels 1 through 16") {
    for (level <- 1 to 16) {
      assert(Dnd5Bard.level9SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Bard has 1 9th level spell slot at levels 17 through 20") {
    for (level <- 17 to 20) {
      assert(Dnd5Bard.level9SlotsPerLevel(level) == 1)
    }
  }
}
