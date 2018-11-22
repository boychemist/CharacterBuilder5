package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum
import org.boychemist.characterbuilder5._

class TestDnd5Monk extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Monk is '" + Dnd5ClassesEnum.Monk.toString + "'") {
    assert(Dnd5Monk.classID == Dnd5ClassesEnum.Monk)
  }

  test("Dnd5Monk has three allowed specializations (Way of the Open Hand, Way of Shadow, and Way of the Four Elements)") {
    assert(Dnd5Monk.allowedSpecializations.length == 3)
    assert(Dnd5Monk.allowedSpecializations(0) == Dnd5SpecializationsEnum.WayOfTheOpenHand)
    assert(Dnd5Monk.allowedSpecializations(1) == Dnd5SpecializationsEnum.WayOfShadow)
    assert(Dnd5Monk.allowedSpecializations(2) == Dnd5SpecializationsEnum.WayOfTheFourElements)
  }

  test("Dnd5Monk is specialized starting at level 3") {
    assert(Dnd5Monk.specializationStartLevel == 3)
  }

  test("Dnd5Monk hit die is 1d8") {
    assert(Dnd5Monk.hitDice == "1d8")
  }

  test("Dnd5Monk is not proficient with any armor or shields") {
    assert(Dnd5Monk.armorProficiencies.isEmpty)
  }

  test("Dnd5Monk is proficient with simple weapons and shortswords") {
    assert(Dnd5Monk.weaponProficiencies.length == 2)
    assert((Dnd5Monk.weaponProficiencies count(_ == "Simple weapons")) == 1)
    assert((Dnd5Monk.weaponProficiencies count(_ == "Shortswords")) == 1)
  }

  test("Dnd5Monk has one tool proficiency") {
    assert(Dnd5Monk.toolProficiencies.length == 1)
  }

  test("Dnd5Monk has Strength and Dexterity saving throw proficiencies") {
    assert(Dnd5Monk.savingThrowProficiencies.length == 2)
    assert((Dnd5Monk.savingThrowProficiencies count(_ == DndAbilitiesEnum.Strength)) == 1)
    assert((Dnd5Monk.savingThrowProficiencies count(_ == DndAbilitiesEnum.Dexterity)) == 1)
  }

  test("Dnd5Monk may choose from 6 skills") {
    assert(Dnd5Monk.skillChoices.length == 6)
    assert((Dnd5Monk.skillChoices count( _== "Acrobatics")) == 1)
    assert((Dnd5Monk.skillChoices count( _== "Athletics")) == 1)
    assert((Dnd5Monk.skillChoices count( _== "History")) == 1)
    assert((Dnd5Monk.skillChoices count( _== "Insight")) == 1)
    assert((Dnd5Monk.skillChoices count( _== "Religion")) == 1)
    assert((Dnd5Monk.skillChoices count( _== "Stealth")) == 1)
  }

  test("Dnd5Monk gets to choose 2 skills") {
    assert(Dnd5Monk.numberOfSkills == 2)
  }

  test("Dnd5Monk has 17 class features") {
    assert(Dnd5Monk.getClassFeaturesUpToClassLevel(20).length == 17)
  }

  test("Dnd5Monk has 2 1st level class features (Unarmored Defense and Martial Arts)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(1)
    assert(features.length == 2)
    assert(features.head.name == "Unarmored Defense")
    assert(features.last.name == "Martial Arts")
  }

  test("Dnd5Monk has 2 2nd level class features (Ki and Unarmored Movement)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert(features.head.name == "Ki")
    assert(features.last.name == "Unarmored Movement")
  }

  test("Dnd5Monk has 1 3rd level class feature (Deflect Missiles)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(3)
    assert(features.length == 1)
    assert(features.head.name == "Deflect Missiles")
  }

  test("Dnd5Monk has 1 4th level class features (Slow Fall)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(4)
    assert(features.length == 1)
    assert(features.head.name == "Slow Fall")
  }

  test("Dnd5Monk has 2 5th level class features (Extra Attack and Stunning Strike)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(5)
    assert(features.length == 2)
    assert(features.head.name == "Extra Attack")
    assert(features.last.name == "Stunning Strike")
  }

  test("Dnd5Monk has 1 6th level class feature (Ki-Empowered Strikes)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Ki-Empowered Strikes")
  }

  test("Dnd5Monk has 2 7th level class feature (Evasion and Stillness of Mind)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(7)
    assert(features.length == 2)
    assert(features.head.name == "Evasion")
    assert(features.last.name == "Stillness of Mind")
  }

  test("Dnd5Monk has 1 10th level class feature (Purity of Body)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Purity of Body")
  }

  test("Dnd5Monk has 1 13th level class feature (Tongue of the Sun and Moon)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(13)
    assert(features.length == 1)
    assert(features.head.name == "Tongue of the Sun and Moon")
  }

  test("Dnd5Monk has 1 14th level class feature (Diamond Soul)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Diamond Soul")
  }

  test("Dnd5Monk has 1 156th level class feature (Timeless Body)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(15)
    assert(features.length == 1)
    assert(features.head.name == "Timeless Body")
  }

  test("Dnd5Monk has 1 18th level class feature (Empty Body)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(18)
    assert(features.length == 1)
    assert(features.head.name == "Empty Body")
  }

  test("Dnd5Monk has 1 20th level class feature (Perfect Self)") {
    val features = Dnd5Monk.getClassFeaturesForClassLevel(20)
    assert(features.length == 1)
    assert(features.head.name == "Perfect Self")
  }

  test("Dnd5Monk has a 1d4 martial arts hit die at levels 1 - 4)") {
    for(level <- 1 to 4) assert(Dnd5Monk.getMartialArtsHitDie(level) == "1d4")
  }

  test("Dnd5Monk has a 1d6 martial arts hit die at levels 5 - 10)") {
    for(level <- 5 to 10) assert(Dnd5Monk.getMartialArtsHitDie(level) == "1d6")
  }

  test("Dnd5Monk has a 1d8 martial arts hit die at levels 11 - 16)") {
    for(level <- 11 to 16) assert(Dnd5Monk.getMartialArtsHitDie(level) == "1d8")
  }

  test("Dnd5Monk has a 1d10 martial arts hit die at levels 17 - 20)") {
    for(level <- 17 to 20) assert(Dnd5Monk.getMartialArtsHitDie(level) == "1d10")
  }

  test("Dnd5Monk has no ki points at level 1 and level number of ki points after level 1") {
    assert(Dnd5Monk.getKiPointsForLevel(1) == 0)
    for (level <- 2 to 20) {
      assert(Dnd5Monk.getKiPointsForLevel(level) == level)
    }
  }

  test("Dnd5Monk has no unarmored movement bonus at level 1") {
    assert(Dnd5Monk.getMovementBonus(1) == 0)
  }

  test("Dnd5Monk has a 10 ft unarmored movement bonus at levels 2 - 5") {
    for (level <- 2 to 5) assert(Dnd5Monk.getMovementBonus(level) == 10)
  }

  test("Dnd5Monk has a 15 ft unarmored movement bonus at levels 6 - 9") {
    for (level <- 6 to 9) assert(Dnd5Monk.getMovementBonus(level) == 15)
  }

  test("Dnd5Monk has a 20 ft unarmored movement bonus at levels 10 - 13") {
    for (level <- 10 to 13) assert(Dnd5Monk.getMovementBonus(level) == 20)
  }

  test("Dnd5Monk has a 25 ft unarmored movement bonus at levels 14 - 17") {
    for (level <- 14 to 17) assert(Dnd5Monk.getMovementBonus(level) == 25)
  }

  test("Dnd5Monk has a 30 ft unarmored movement bonus at levels 18 - 20") {
    for (level <- 18 to 20) assert(Dnd5Monk.getMovementBonus(level) == 30)
  }
}
