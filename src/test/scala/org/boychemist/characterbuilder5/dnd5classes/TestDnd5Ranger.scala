package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum
import org.boychemist.characterbuilder5._

class TestDnd5Ranger extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Ranger is '" + Dnd5ClassesEnum.Ranger.toString + "'") {
    assert(Dnd5Ranger.classID == Dnd5ClassesEnum.Ranger)
  }

  test("Dnd5Ranger has 2 allowed specializations (Hunter and BeastMaster)") {
    assert(Dnd5Ranger.allowedSpecializations.length == 2)
    assert(Dnd5Ranger.allowedSpecializations(0) == Dnd5SpecializationsEnum.Hunter)
    assert(Dnd5Ranger.allowedSpecializations(1) == Dnd5SpecializationsEnum.BeastMaster)
  }

  test("Dnd5Ranger is specialized starting at level 3") {
    assert(Dnd5Ranger.specializationStartLevel == 3)
  }

  test("Dnd5Ranger hit dice is 1d10") {
    assert(Dnd5Ranger.hitDice == "1d10")
  }

  test("Dnd5Ranger is proficient with Light armor, Medium armor, and Shields") {
    assert(Dnd5Ranger.armorProficiencies.length == 3)
    assert((Dnd5Ranger.armorProficiencies count (_ == "Light armor")) == 1)
    assert((Dnd5Ranger.armorProficiencies count (_ == "Medium armor")) == 1)
    assert((Dnd5Ranger.armorProficiencies count (_ == "Shields")) == 1)
  }

  test("Dnd5Ranger may choose from 8 skills (Athletics, Insight, Intimidation, Medicine, " +
    "Persuasion, Religion") {
    assert(Dnd5Ranger.skillChoices.length == 8)
    assert((Dnd5Ranger.skillChoices count(_ == "Animal Handling")) == 1)
    assert((Dnd5Ranger.skillChoices count(_ == "Athletics")) == 1)
    assert((Dnd5Ranger.skillChoices count(_ == "Insight")) == 1)
    assert((Dnd5Ranger.skillChoices count(_ == "Investigation")) == 1)
    assert((Dnd5Ranger.skillChoices count(_ == "Nature")) == 1)
    assert((Dnd5Ranger.skillChoices count(_ == "Perception")) == 1)
    assert((Dnd5Ranger.skillChoices count(_ == "Stealth")) == 1)
    assert((Dnd5Ranger.skillChoices count(_ == "Survival")) == 1)
  }

  test("Dnd5Ranger gets to choose 3 skills") {
    assert(Dnd5Ranger.numberOfSkills == 3)
  }

  test("Dnd5Ranger has 11 class features") {
    assert(Dnd5Ranger.getClassFeaturesUpToClassLevel(20).length == 11)
  }

  test("Dnd5Ranger has 2 first level class features (Favored Enemy, Natural Explorer)") {
    val features = Dnd5Ranger.getClassFeaturesForClassLevel(1)
    assert(features.length == 2)
    assert(features.head.name == "Favored Enemy")
    assert(features.last.name == "Natural Explorer")
  }

  test("Dnd5Ranger has 2 second level class features (Fighting Style, Spellcasting)") {
    val features = Dnd5Ranger.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert((features count(_.name == "Fighting Style")) == 1)
    assert((features count(_.name == "Spellcasting")) == 1)
  }

  test("Dnd5Ranger has 1 3rd level class feature (Primeval Awareness)") {
    val features = Dnd5Ranger.getClassFeaturesForClassLevel(3)
    assert(features.length == 1)
    assert(features.head.name == "Primeval Awareness")
  }

  test("Dnd5Ranger has 1 5th level class feature (Extra Attack)") {
    val features = Dnd5Ranger.getClassFeaturesForClassLevel(5)
    assert(features.length == 1)
    assert(features.head.name == "Extra Attack")
  }

  test("Dnd5Ranger has 1 8th level class feature (Land's Stride)") {
    val features = Dnd5Ranger.getClassFeaturesForClassLevel(8)
    assert(features.length == 1)
    assert(features.head.name == "Land's Stride")
  }

  test("Dnd5Ranger has 1 10th level class feature (Hide in Plain Sight)") {
    val features = Dnd5Ranger.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Hide in Plain Sight")
  }

  test("Dnd5Ranger has 1 14th level class feature (Vanish)") {
    val features = Dnd5Ranger.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Vanish")
  }

  test("Dnd5Ranger has 1 18th level class feature (Feral Senses)") {
    val features = Dnd5Ranger.getClassFeaturesForClassLevel(18)
    assert(features.length == 1)
    assert(features.head.name == "Feral Senses")
  }

  test("Dnd5Ranger has 1 20th level class feature (Foe Slayer)") {
    val features = Dnd5Ranger.getClassFeaturesForClassLevel(20)
    assert(features.length == 1)
    assert(features.head.name == "Foe Slayer")
  }

  //
  // spell caster abilities
  //

  test("Dnd5Ranger may not cast cantrips") {
    for (level <- 1 to 20)
      assert(Dnd5Ranger.cantripsPerLevel(level) == 0)
  }

  test("Dnd5Ranger has no known spells at level 1") {
    assert(Dnd5Ranger.totalSpellsKnownByClassLevel(1) == 0)
  }

  test("Dnd5Ranger has 1 + (level +1 )/2 known spells at levels > 1") {
    for(level <- 2 to 20) {
      val spells = 1 + (level + 1)/2
      assert(Dnd5Ranger.totalSpellsKnownByClassLevel(level) == spells)
    }
  }

  test("Dnd5Ranger has no level 1 spell slots at level 1") {
    assert(Dnd5Ranger.firstLevelSlotsPerLevel(1) == 0)
  }

  test("Dnd5Ranger has 2 level 1 spell slots at level 2") {
    assert(Dnd5Ranger.firstLevelSlotsPerLevel(2) == 2)
  }

  test("Dnd5Ranger has 3 level 1 spell slots at levels 3 and 4") {
    for (level <- 3 to 4)
      assert(Dnd5Ranger.firstLevelSlotsPerLevel(level) == 3)
  }

  test("Dnd5Ranger has 4 level 1 spell slots at levels 5 through 20") {
    for (level <- 5 to 20)
      assert(Dnd5Ranger.firstLevelSlotsPerLevel(level) == 4)
  }

  test("Dnd5Ranger has no 2nd level spell slots at levels 1 through 4") {
    for (level <- 1 to 4)
      assert(Dnd5Ranger.level2SlotsPerLevel(level) == 0)
  }

  test("Dnd5Ranger has 2 level 2 spell slots at level 5 and 6") {
    for (level <- 5 to 6)
      assert(Dnd5Ranger.level2SlotsPerLevel(level) == 2)
  }

  test("Dnd5Ranger has 3 2nd level spell slots at levels 7 through 20") {
    for (level <- 7 to 20)
      assert(Dnd5Ranger.level2SlotsPerLevel(level) == 3)
  }

  test("Dnd5Ranger has no 3rd level spell slots at levels 1 through 8") {
    for (level <- 1 to 8)
      assert(Dnd5Ranger.level3SlotsPerLevel(level) == 0)
  }

  test("Dnd5Ranger has 2 level 3 spell slots at levels 9 and 10") {
    for (level <- 9 to 10)
      assert(Dnd5Ranger.level3SlotsPerLevel(level) == 2)
  }

  test("Dnd5Ranger has 3 3rd level spell slots at levels 11 through 20") {
    for (level <- 11 to 20)
      assert(Dnd5Ranger.level3SlotsPerLevel(level) == 3)
  }

  test("Dnd5Ranger has no 4th level spell slots at levels 1 through 12") {
    for (level <- 1 to 12)
      assert(Dnd5Ranger.level4SlotsPerLevel(level) == 0)
  }

  test("Dnd5Ranger has 1 4th level spell slots at levels 13 and 14") {
    for (level <- 13 to 14)
      assert(Dnd5Ranger.level4SlotsPerLevel(level) == 1)
  }

  test("Dnd5Ranger has 2 4th level spell slots at levels 15 and 16") {
    for (level <- 15 to 16)
      assert(Dnd5Ranger.level4SlotsPerLevel(level) == 2)
  }

  test("Dnd5Ranger has 3 4th level spell slots at levels 17 through 20") {
    for (level <- 17 to 20)
      assert(Dnd5Ranger.level4SlotsPerLevel(level) == 3)
  }

  test("Dnd5Ranger has no 5th level spell slots at levels 1 through 16") {
    for (level <- 1 to 16 )
      assert(Dnd5Ranger.level5SlotsPerLevel(level) == 0)
  }

  test("Dnd5Ranger has 1 5th level spell slot at levels 17 and 18") {
    for (level <- 17 to 18 )
      assert(Dnd5Ranger.level5SlotsPerLevel(level) == 1)
  }

  test("Dnd5Ranger has 2 5th level spell slots at levels 19 and 20") {
    for (level <- 19 to 20)
      assert(Dnd5Ranger.level5SlotsPerLevel(level) == 2)
  }

  test("Dnd5Ranger has no 6th level spell slots") {
    for (level <- 1 to 20) {
      assert(Dnd5Ranger.level6SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Ranger has no 7th level spell slots") {
    for (level <- 1 to 20) {
      assert(Dnd5Ranger.level7SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Ranger has no 8th level spell slots") {
    for (level <- 1 to 20) {
      assert(Dnd5Ranger.level8SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Ranger has no 9th level spell slots") {
    for (level <- 1 to 20) {
      assert(Dnd5Ranger.level9SlotsPerLevel(level) == 0)
    }
  }
}
