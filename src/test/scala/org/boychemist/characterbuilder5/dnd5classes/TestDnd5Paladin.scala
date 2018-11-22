package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum
import org.boychemist.characterbuilder5._

class TestDnd5Paladin extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Paladin is '" + Dnd5ClassesEnum.Paladin.toString + "'") {
    assert(Dnd5Paladin.classID == Dnd5ClassesEnum.Paladin)
  }

  test("Dnd5Paladin has 3 allowed specializations (Oath of Devotion, Oath of the Ancients, Oath of Vengeance)") {
    assert(Dnd5Paladin.allowedSpecializations.length == 3)
    assert(Dnd5Paladin.allowedSpecializations(0) == Dnd5SpecializationsEnum.OathOfDevotion)
    assert(Dnd5Paladin.allowedSpecializations(1) == Dnd5SpecializationsEnum.OathOfTheAncients)
    assert(Dnd5Paladin.allowedSpecializations(2) == Dnd5SpecializationsEnum.OathOfVengeance)
  }


  test("Dnd5Paladin is specialized starting at level 3") {
    assert(Dnd5Paladin.specializationStartLevel == 3)
  }

  test("Dnd5Paladin hit dice is 1d10") {
    assert(Dnd5Paladin.hitDice == "1d10")
  }

  test("Dnd5Paladin is proficient with All armor and shields") {
    assert(Dnd5Paladin.armorProficiencies.length == 2)
    assert(Dnd5Paladin.armorProficiencies.head == "All armor")
    assert(Dnd5Paladin.armorProficiencies.last == "Shields")
  }

  test("Dnd5Paladin is proficient with simple weapons and martial weapons") {
    assert(Dnd5Paladin.weaponProficiencies.length == 2)
    assert((Dnd5Paladin.weaponProficiencies count(_ == "Simple weapons")) == 1)
    assert((Dnd5Paladin.weaponProficiencies count(_ == "Martial weapons")) == 1)
  }

  test("Dnd5Paladin has no tool proficiencies") {
    assert(Dnd5Paladin.toolProficiencies.isEmpty)
  }

  test("Dnd5Paladin has Wisdom and Charisma saving throw proficiencies") {
    assert(Dnd5Paladin.savingThrowProficiencies.length == 2)
    assert((Dnd5Paladin.savingThrowProficiencies count(_ == DndAbilitiesEnum.Wisdom)) == 1)
    assert((Dnd5Paladin.savingThrowProficiencies count(_ == DndAbilitiesEnum.Charisma)) == 1)
  }

  test("Dnd5Paladin may choose from 6 skills (Athletics, Insight, Intimidation, Medicine, " +
  "Persuasion, Religion") {
    assert(Dnd5Paladin.skillChoices.length == 6)
    assert((Dnd5Paladin.skillChoices count(_ == "Athletics")) == 1)
    assert((Dnd5Paladin.skillChoices count(_ == "Insight")) == 1)
    assert((Dnd5Paladin.skillChoices count(_ == "Intimidation")) == 1)
    assert((Dnd5Paladin.skillChoices count(_ == "Medicine")) == 1)
    assert((Dnd5Paladin.skillChoices count(_ == "Persuasion")) == 1)
    assert((Dnd5Paladin.skillChoices count(_ == "Religion")) == 1)
  }

  test("Dnd5Paladin gets to choose 2 skills") {
    assert(Dnd5Paladin.numberOfSkills == 2)
  }

  test("Dnd5Paladin has 11 class features") {
    assert(Dnd5Paladin.getClassFeaturesUpToClassLevel(20).length == 11)
  }

  test("Dnd5Paladin has 2 first level class features (Divine Sense, Lay on Hands)") {
    val features = Dnd5Paladin.getClassFeaturesForClassLevel(1)
    assert(features.length == 2)
    assert(features.head.name == "Divine Sense")
    assert(features.last.name == "Lay on Hands")
  }

  test("Dnd5Paladin has 3 second level class features (Fighting Style, Spellcasting, Divine Smite)") {
    val features = Dnd5Paladin.getClassFeaturesForClassLevel(2)
    assert(features.length == 3)
    assert((features count(_.name == "Fighting Style")) == 1)
    assert((features count(_.name == "Spellcasting")) == 1)
    assert((features count(_.name == "Divine Smite")) == 1)
  }

  test("Dnd5Paladin has 1 3rd level class feature (Divine Health)") {
    val features = Dnd5Paladin.getClassFeaturesForClassLevel(3)
    assert(features.length == 1)
    assert(features.head.name == "Divine Health")
  }

  test("Dnd5Paladin has 1 5th level class feature (Extra Attack)") {
    val features = Dnd5Paladin.getClassFeaturesForClassLevel(5)
    assert(features.length == 1)
    assert(features.head.name == "Extra Attack")
  }

  test("Dnd5Paladin has 1 6th level class feature (Aura of Protection)") {
    val features = Dnd5Paladin.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Aura of Protection")
  }

  test("Dnd5Paladin has 1 10th level class feature (Aura of Courage)") {
    val features = Dnd5Paladin.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Aura of Courage")
  }

  test("Dnd5Paladin has 1 11th level class feature (Improved Divine Smite)") {
    val features = Dnd5Paladin.getClassFeaturesForClassLevel(11)
    assert(features.length == 1)
    assert(features.head.name == "Improved Divine Smite")
  }

  test("Dnd5Paladin has 1 14th level class feature (Cleansing Touch)") {
    val features = Dnd5Paladin.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Cleansing Touch")
  }

  //
  // spell caster abilities
  //

  test("Dnd5Paladin may not cast cantrips") {
    for (level <- 1 to 20)
      assert(Dnd5Paladin.cantripsPerLevel(level) == 0)
  }

  test("Dnd5Paladin has no level 1 spell slots at level 1") {
    assert(Dnd5Paladin.firstLevelSlotsPerLevel(1) == 0)
  }

  test("Dnd5Paladin has 2 level 1 spell slots at level 2") {
    assert(Dnd5Paladin.firstLevelSlotsPerLevel(2) == 2)
  }

  test("Dnd5Paladin has 3 level 1 spell slots at levels 3 and 4") {
    for (level <- 3 to 4)
      assert(Dnd5Paladin.firstLevelSlotsPerLevel(level) == 3)
  }

  test("Dnd5Paladin has 4 level 1 spell slots at levels 5 through 20") {
    for (level <- 5 to 20)
      assert(Dnd5Paladin.firstLevelSlotsPerLevel(level) == 4)
  }

  test("Dnd5Paladin has no 2nd level spell slots at levels 1 through 4") {
    for (level <- 1 to 4)
      assert(Dnd5Paladin.level2SlotsPerLevel(level) == 0)
  }

  test("Dnd5Paladin has 2 level 2 spell slots at level 5 and 6") {
    for (level <- 5 to 6)
      assert(Dnd5Paladin.level2SlotsPerLevel(level) == 2)
  }

  test("Dnd5Paladin has 3 2nd level spell slots at levels 7 through 20") {
    for (level <- 7 to 20)
      assert(Dnd5Paladin.level2SlotsPerLevel(level) == 3)
  }

  test("Dnd5Paladin has no 3rd level spell slots at levels 1 through 8") {
    for (level <- 1 to 8)
      assert(Dnd5Paladin.level3SlotsPerLevel(level) == 0)
  }

  test("Dnd5Paladin has 2 level 3 spell slots at levels 9 and 10") {
    for (level <- 9 to 10)
      assert(Dnd5Paladin.level3SlotsPerLevel(level) == 2)
  }

  test("Dnd5Paladin has 3 3rd level spell slots at levels 11 through 20") {
    for (level <- 11 to 20)
      assert(Dnd5Paladin.level3SlotsPerLevel(level) == 3)
  }

  test("Dnd5Paladin has no 4th level spell slots at levels 1 through 12") {
    for (level <- 1 to 12)
      assert(Dnd5Paladin.level4SlotsPerLevel(level) == 0)
  }

  test("Dnd5Paladin has 1 4th level spell slots at levels 13 and 14") {
    for (level <- 13 to 14)
      assert(Dnd5Paladin.level4SlotsPerLevel(level) == 1)
  }

  test("Dnd5Paladin has 2 4th level spell slots at levels 15 and 16") {
    for (level <- 15 to 16)
      assert(Dnd5Paladin.level4SlotsPerLevel(level) == 2)
  }

  test("Dnd5Paladin has 3 4th level spell slots at levels 17 through 20") {
    for (level <- 17 to 20)
      assert(Dnd5Paladin.level4SlotsPerLevel(level) == 3)
  }

  test("Dnd5Paladin has no 5th level spell slots at levels 1 through 16") {
    for (level <- 1 to 16 )
      assert(Dnd5Paladin.level5SlotsPerLevel(level) == 0)
  }

  test("Dnd5Paladin has 1 5th level spell slot at levels 17 and 18") {
    for (level <- 17 to 18 )
      assert(Dnd5Paladin.level5SlotsPerLevel(level) == 1)
  }

  test("Dnd5Paladin has 2 5th level spell slots at levels 19 and 20") {
    for (level <- 19 to 20)
      assert(Dnd5Paladin.level5SlotsPerLevel(level) == 2)
  }

  test("Dnd5Paladin has no 6th level spell slots") {
    for (level <- 1 to 20) {
      assert(Dnd5Paladin.level6SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Paladin has no 7th level spell slots") {
    for (level <- 1 to 20) {
      assert(Dnd5Paladin.level7SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Paladin has no 8th level spell slots") {
    for (level <- 1 to 20) {
      assert(Dnd5Paladin.level8SlotsPerLevel(level) == 0)
    }
  }

  test("Dnd5Paladin has no 9th level spell slots") {
    for (level <- 1 to 20) {
      assert(Dnd5Paladin.level9SlotsPerLevel(level) == 0)
    }
  }
}
