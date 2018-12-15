package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5Druid extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Druid is '" + Dnd5ClassesEnum.Cleric.toString + "'") {
    assert(Dnd5Druid.classID == Dnd5ClassesEnum.Druid)
  }

  test("Dnd5Druid is specialized starting at level 2") {
    assert(Dnd5Druid.specializationStartLevel == 2)
  }

  test("Dnd5Druid hit dice is 1d8") {
    assert(Dnd5Druid.hitDice == "1d8")
  }

  test("Dnd5Druid is proficient with light armor, medium armor, and shields") {
    assert(Dnd5Druid.armorProficiencies.length == 3)
    assert((Dnd5Druid.armorProficiencies count (_ == "Light armor")) == 1)
    assert((Dnd5Druid.armorProficiencies count (_ == "Medium armor")) == 1)
    assert((Dnd5Druid.armorProficiencies count (_ == "Shields")) == 1)
  }

  test("Dnd5Druid is proficient with 10 specific weapons") {
    assert(Dnd5Druid.weaponProficiencies.length == 10)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Clubs")) == 1)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Daggers")) == 1)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Darts")) == 1)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Javelins")) == 1)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Maces")) == 1)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Quarterstaffs")) == 1)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Scimitars")) == 1)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Slings")) == 1)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Spears")) == 1)
    assert((Dnd5Druid.weaponProficiencies count (_ == "Sickles")) == 1)
  }

  test("Dnd5Druid has is proficient with the Herbilism kit") {
    assert(Dnd5Druid.toolProficiencies.length == 1)
    assert(Dnd5Druid.toolProficiencies.head == "Herbalism kit")
  }

  test("Dnd5Druid has Wisdom and Intelligence saving throw proficiencies") {
    assert(Dnd5Druid.savingThrowProficiencies.length == 2)
    assert((Dnd5Druid.savingThrowProficiencies count(_ == DndAbilitiesEnum.Wisdom)) == 1)
    assert((Dnd5Druid.savingThrowProficiencies count(_ == DndAbilitiesEnum.Intelligence)) == 1)
  }

  test("Dnd5Druid may choose from 8 skills (History, Insight, Medicine, Persuasion, Religion") {
    assert(Dnd5Druid.skillChoices.length == 8)
    assert((Dnd5Druid.skillChoices count (_ == "Arcana")) == 1)
    assert((Dnd5Druid.skillChoices count (_ == "Animal Handling")) == 1)
    assert((Dnd5Druid.skillChoices count (_ == "Insight")) == 1)
    assert((Dnd5Druid.skillChoices count (_ == "Medicine")) == 1)
    assert((Dnd5Druid.skillChoices count (_ == "Perception")) == 1)
    assert((Dnd5Druid.skillChoices count (_ == "Religion")) == 1)
    assert((Dnd5Druid.skillChoices count (_ == "Survival")) == 1)
  }

  test("Dnd5Druid gets to choose 2 skills") {
    assert(Dnd5Druid.numberOfSkills == 2)
  }

  test("Dnd5Druid has 5 class features") {
    assert(Dnd5Druid.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("Dnd5Druid has 1 first level class feature (Druidic)") {
    val features = Dnd5Druid.getClassFeaturesForClassLevel(1)
    assert(features.length == 1)
    assert(features.head.name == "Druidic")
  }

  test("Dnd5Druid has 1 2nd level class feature (Wild Shape)") {
    val features = Dnd5Druid.getClassFeaturesForClassLevel(2)
    assert(features.length == 1)
    assert(features.head.name == "Wild Shape")
  }

  test("Dnd5Druid has 2 18th level class features (Timeless Body and Beast Spells)") {
    val features = Dnd5Druid.getClassFeaturesForClassLevel(18)
    assert(features.length == 2)
    assert(features.head.name == "Timeless Body")
    assert(features.last.name == "Beast Spells")
  }

  test("Dnd5Druid has 1 20th level class feature (Archdruid)") {
    val features = Dnd5Druid.getClassFeaturesForClassLevel(20)
    assert(features.length == 1)
    assert(features.head.name == "Archdruid")
  }

  //
  // spell caster abilities
  //

  test("Dnd5Druid may know 2 cantrips at level 1, 2, and 3") {
    for (level <- 1 to 3)
      assert(Dnd5Druid.cantripsPerLevel(level) == 2)
  }

  test("Dnd5Druid may know 4 cantrips at levels 4 through 9") {
    for (level <- 4 to 9)
      assert(Dnd5Druid.cantripsPerLevel(level) == 3)
  }

  test("Dnd5Druid may know 5 cantrips at levels 10 through 20") {
    for (level <- 10 to 20)
      assert(Dnd5Druid.cantripsPerLevel(level) == 4)
  }

  test("Dnd5Druid has no limit on known cleric spells") {
    assert(Dnd5Druid.totalSpellsKnownByClassLevel.isEmpty)
  }

  test("Dnd5Druid has 2 level 1 spell slots at level 1") {
    assert(Dnd5Druid.firstLevelSlotsPerLevel(1) == 2)
  }

  test("Dnd5Druid has 3 level 1 spell slots at level 2") {
    assert(Dnd5Druid.firstLevelSlotsPerLevel(2) == 3)
  }

  test("Dnd5Druid has 4 level 1 spell slots at levels 3 through 20") {
    for (level <- 3 to 20)
      assert(Dnd5Druid.firstLevelSlotsPerLevel(level) == 4)
  }

  test("Dnd5Druid has no 2nd level spell slots at levels 1 and 2") {
    for (level <- 1 to 2)
      assert(Dnd5Druid.level2SlotsPerLevel(level) == 0)
  }

  test("Dnd5Druid has 2 level 2 spell slots at level 3") {
    assert(Dnd5Druid.level2SlotsPerLevel(3) == 2)
  }

  test("Dnd5Druid has 3 2nd level spell slots at levels 4 through 20") {
    for (level <- 4 to 220)
      assert(Dnd5Druid.level2SlotsPerLevel(level) == 3)
  }

  test("Dnd5Druid has no 3rd level spell slots at levels 1 through 4") {
    for (level <- 1 to 4)
      assert(Dnd5Druid.level3SlotsPerLevel(level) == 0)
  }

  test("Dnd5Druid has 2 level 3 spell slots at level 5") {
    assert(Dnd5Druid.level3SlotsPerLevel(5) == 2)
  }

  test("Dnd5Druid has 3 3rd level spell slots at levels 6 through 20") {
    for (level <- 6 to 220)
      assert(Dnd5Druid.level3SlotsPerLevel(level) == 3)
  }

  test("Dnd5Druid has no 4th level spell slots at levels 1 through 6") {
    for (level <- 1 to 6)
      assert(Dnd5Druid.level4SlotsPerLevel(level) == 0)
  }

  test("Dnd5Druid has 1 4th level spell slots at level 7") {
    assert(Dnd5Druid.level4SlotsPerLevel(7) == 1)
  }

  test("Dnd5Druid has 2 4th level spell slots at level 8") {
    assert(Dnd5Druid.level4SlotsPerLevel(8) == 2)
  }

  test("Dnd5Druid has 3 4th level spell slots at levels 9 through 20") {
    for (level <- 9 to 20)
      assert(Dnd5Druid.level4SlotsPerLevel(level) == 3)
  }

  test("Dnd5Druid has no 5th level spell slots at levels 1 through 8") {
    for (level <- 1 to 8) {
      assert(Dnd5Druid.level5SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Druid has 1 5th level spell slot at level 9") {
    assert(Dnd5Druid.level5SlotsPerLevel(9) == 1)
  }

  test("Dnd5Druid has 2 5th level spell slots at levels 10 through 17") {
    for (level <- 10 to 17)
      assert(Dnd5Druid.level5SlotsPerLevel(level) == 2)
  }

  test("Dnd5Druid has 3 5th level spell slots at levels 18 through 207") {
    for (level <- 18 to 20)
      assert(Dnd5Druid.level5SlotsPerLevel(level) == 3)
  }

  test("Dnd5Druid has no 6th level spell slots at levels 1 through 10") {
    for (level <- 1 to 10) {
      assert(Dnd5Druid.level6SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Druid has 1 6th level spell slot at levels 11 through 18") {
    for (level <- 11 to 18) {
      assert(Dnd5Druid.level6SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Druid has 2 6th level spell slot at levels 19 and 20") {
    assert(Dnd5Druid.level6SlotsPerLevel(19) == 2)
    assert(Dnd5Druid.level6SlotsPerLevel(20) == 2)
  }

  test("Dnd5Druid has no 7th level spell slots at levels 1 through 12") {
    for (level <- 1 to 10) {
      assert(Dnd5Druid.level7SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Druid has 1 7th level spell slot at levels 13 through 19") {
    for (level <- 13 to 19) {
      assert(Dnd5Druid.level7SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Druid has 2 7th level spell slot at level 20") {
    assert(Dnd5Druid.level7SlotsPerLevel(20) == 2)
  }

  test("Dnd5Druid has no 8th level spell slots at levels 1 through 14") {
    for (level <- 1 to 14) {
      assert(Dnd5Druid.level8SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Druid has 1 8th level spell slot at levels 15 through 20") {
    for (level <- 15 to 20) {
      assert(Dnd5Druid.level8SlotsPerLevel(level) == 1)
    }
  }

  test("Dnd5Druid has no 9th level spell slots at levels 1 through 16") {
    for (level <- 1 to 16) {
      assert(Dnd5Druid.level9SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Druid has 1 9th level spell slot at levels 17 through 20") {
    for (level <- 17 to 20) {
      assert(Dnd5Druid.level9SlotsPerLevel(level) == 1)
    }
  }
}
