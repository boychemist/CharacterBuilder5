package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5Cleric extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Cleric is '" + Dnd5ClassesEnum.Cleric.toString + "'") {
    assert(Dnd5Cleric.classID == Dnd5ClassesEnum.Cleric)
  }

  test("Dnd5Cleric is specialized starting at level 1") {
    assert(Dnd5Cleric.specializationStartLevel == 1)
  }

  test("Dnd5Cleric hit dice is 1d8") {
    assert(Dnd5Cleric.hitDice == "1d8")
  }

  test("Dnd5Cleric is proficient with light armor, medium armor, and shields") {
    assert(Dnd5Cleric.armorProficiencies.length == 3)
    assert((Dnd5Cleric.armorProficiencies count (_ == "Light armor")) == 1)
    assert((Dnd5Cleric.armorProficiencies count (_ == "Medium armor")) == 1)
    assert((Dnd5Cleric.armorProficiencies count (_ == "Shields")) == 1)
  }

  test("Dnd5Cleric is proficient with simple weapons") {
    assert(Dnd5Cleric.weaponProficiencies.length == 1)
    assert(Dnd5Cleric.weaponProficiencies.head == "Simple weapons")
  }

  test("Dnd5Cleric has no tool proficiencies") {
    assert(Dnd5Cleric.toolProficiencies.isEmpty)
  }

  test("Dnd5Cleric has Wisdom and Charisma saving throw proficiencies") {
    assert(Dnd5Cleric.savingThrowProficiencies.length == 2)
    assert((Dnd5Cleric.savingThrowProficiencies count(_ == DndAbilitiesEnum.Wisdom)) == 1)
    assert((Dnd5Cleric.savingThrowProficiencies count(_ == DndAbilitiesEnum.Charisma)) == 1)
  }

  test("Dnd5Cleric may choose from 5 skills (History, Insight, Medicine, Persuasion, Religion") {
    assert(Dnd5Cleric.skillChoices.length == 5)
    assert((Dnd5Cleric.skillChoices count (_ == "History")) == 1)
    assert((Dnd5Cleric.skillChoices count (_ == "Insight")) == 1)
    assert((Dnd5Cleric.skillChoices count (_ == "Medicine")) == 1)
    assert((Dnd5Cleric.skillChoices count (_ == "Persuasion")) == 1)
    assert((Dnd5Cleric.skillChoices count (_ == "Religion")) == 1)
  }

  test("Dnd5Cleric gets to choose 2 skills") {
    assert(Dnd5Cleric.numberOfSkills == 2)
  }

  test("Dnd5Cleric has 5 class features") {
    assert(Dnd5Cleric.getClassFeaturesUpToClassLevel(20).length == 4)
  }

  test("Dnd5Cleric has 2 second level class features (Channel Divinity, Channel Divinity: Turn Undead)") {
    val features = Dnd5Cleric.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert(features(1).name == "Channel Divinity")
    assert(features.head.name == "Channel Divinity: Turn Undead")
  }

  test("Dnd5Cleric has 1 5th level class feature (Destroy Dead)") {
    val features = Dnd5Cleric.getClassFeaturesForClassLevel(5)
    assert(features.length == 1)
    assert(features.head.name == "Destroy Undead")
  }

  test("Dnd5Cleric has 1 10th level class feature (Divine Intervention)") {
    val features = Dnd5Cleric.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Divine Intervention")
  }

  //
  // spell caster abilities
  //

  test("Dnd5Cleric may know 3 cantrips at level 1, 2, and 3") {
    for (level <- 1 to 3)
      assert(Dnd5Cleric.cantripsPerLevel(level) == 3)
  }

  test("Dnd5Cleric may know 4 cantrips at levels 4 through 9") {
    for (level <- 4 to 9)
      assert(Dnd5Cleric.cantripsPerLevel(level) == 4)
  }

  test("Dnd5Cleric may know 5 cantrips at levels 10 through 20") {
    for (level <- 10 to 20)
      assert(Dnd5Cleric.cantripsPerLevel(level) == 5)
  }

  test("Dnd5Cleric has no limit on known cleric spells") {
    assert(Dnd5Cleric.totalSpellsKnownByClassLevel.isEmpty)
  }

  test("Dnd5Cleric has 2 level 1 spell slots at level 1") {
    assert(Dnd5Cleric.firstLevelSlotsPerLevel(1) == 2)
  }

  test("Dnd5Cleric has 3 level 1 spell slots at level 2") {
    assert(Dnd5Cleric.firstLevelSlotsPerLevel(2) == 3)
  }

  test("Dnd5Cleric has 4 level 1 spell slots at levels 3 through 20") {
    for (level <- 3 to 20)
      assert(Dnd5Cleric.firstLevelSlotsPerLevel(level) == 4)
  }

  test("Dnd5Cleric has no 2nd level spell slots at levels 1 and 2") {
    for (level <- 1 to 2)
      assert(Dnd5Cleric.level2SlotsPerLevel(level) == 0)
  }

  test("Dnd5Cleric has 2 level 2 spell slots at level 3") {
    assert(Dnd5Cleric.level2SlotsPerLevel(3) == 2)
  }

  test("Dnd5Cleric has 3 2nd level spell slots at levels 4 through 20") {
    for (level <- 4 to 220)
      assert(Dnd5Cleric.level2SlotsPerLevel(level) == 3)
  }

  test("Dnd5Cleric has no 3rd level spell slots at levels 1 through 4") {
    for (level <- 1 to 4)
      assert(Dnd5Cleric.level3SlotsPerLevel(level) == 0)
  }

  test("Dnd5Cleric has 2 level 3 spell slots at level 5") {
    assert(Dnd5Cleric.level3SlotsPerLevel(5) == 2)
  }

  test("Dnd5Cleric has 3 3rd level spell slots at levels 6 through 20") {
    for (level <- 6 to 220)
      assert(Dnd5Cleric.level3SlotsPerLevel(level) == 3)
  }

  test("Dnd5Cleric has no 4th level spell slots at levels 1 through 6") {
    for (level <- 1 to 6)
      assert(Dnd5Cleric.level4SlotsPerLevel(level) == 0)
  }

  test("Dnd5Cleric has 1 4th level spell slots at level 7") {
    assert(Dnd5Cleric.level4SlotsPerLevel(7) == 1)
  }

  test("Dnd5Cleric has 2 4th level spell slots at level 8") {
    assert(Dnd5Cleric.level4SlotsPerLevel(8) == 2)
  }

  test("Dnd5Cleric has 3 4th level spell slots at levels 9 through 20") {
    for (level <- 9 to 20)
      assert(Dnd5Cleric.level4SlotsPerLevel(level) == 3)
  }

  test("Dnd5Cleric has no 5th level spell slots at levels 1 through 8") {
    for (level <- 1 to 8) {
      assert(Dnd5Cleric.level5SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Cleric has 1 5th level spell slot at level 9") {
    assert(Dnd5Cleric.level5SlotsPerLevel(9) == 1)
  }

  test("Dnd5Cleric has 2 5th level spell slots at levels 10 through 17") {
    for (level <- 10 to 17)
      assert(Dnd5Cleric.level5SlotsPerLevel(level) == 2)
  }

  test("Dnd5Cleric has 3 5th level spell slots at levels 18 through 207") {
    for (level <- 18 to 20)
      assert(Dnd5Cleric.level5SlotsPerLevel(level) == 3)
  }

  test("Dnd5Cleric has no 6th level spell slots at levels 1 through 10") {
    for (level <- 1 to 10) {
      assert(Dnd5Cleric.level6SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Cleric has 1 6th level spell slot at levels 11 through 18") {
    for (level <- 11 to 18) {
      assert(Dnd5Cleric.level6SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Cleric has 2 6th level spell slot at levels 19 and 20") {
    assert(Dnd5Cleric.level6SlotsPerLevel(19) == 2)
    assert(Dnd5Cleric.level6SlotsPerLevel(20) == 2)
  }

  test("Dnd5Cleric has no 7th level spell slots at levels 1 through 12") {
    for (level <- 1 to 10) {
      assert(Dnd5Cleric.level7SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Cleric has 1 7th level spell slot at levels 13 through 19") {
    for (level <- 13 to 19) {
      assert(Dnd5Cleric.level7SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Cleric has 2 7th level spell slot at level 20") {
    assert(Dnd5Cleric.level7SlotsPerLevel(20) == 2)
  }

  test("Dnd5Cleric has no 8th level spell slots at levels 1 through 14") {
    for (level <- 1 to 14) {
      assert(Dnd5Cleric.level8SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Cleric has 1 8th level spell slot at levels 15 through 20") {
    for (level <- 15 to 20) {
      assert(Dnd5Cleric.level8SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Cleric has no 9th level spell slots at levels 1 through 16") {
    for (level <- 1 to 16) {
      assert(Dnd5Cleric.level9SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Cleric has 1 9th level spell slot at levels 17 through 20") {
    for (level <- 17 to 20) {
      assert(Dnd5Cleric.level9SlotsPerLevel(level) == 1)
    }
  }
}
