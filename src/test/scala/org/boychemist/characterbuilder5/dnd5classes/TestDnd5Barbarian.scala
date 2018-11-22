package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum
import org.boychemist.characterbuilder5._

class TestDnd5Barbarian extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Barbarian is '" + Dnd5ClassesEnum.Barbarian.toString + "'") {
    assert(Dnd5Barbarian.classID == Dnd5ClassesEnum.Barbarian)
  }

  test("Dnd5Barbarian has two allowed specializations (Path of the Berserker and Path of the Totem Warrior") {
    assert(Dnd5Barbarian.allowedSpecializations.length == 2)
    assert(Dnd5Barbarian.allowedSpecializations(0) == Dnd5SpecializationsEnum.PathOfTheBerserker)
    assert(Dnd5Barbarian.allowedSpecializations(1) == Dnd5SpecializationsEnum.PathOfTheTotemWarrior)
  }

  test("Dnd5Barbarian is specialized starting at level 3") {
    assert(Dnd5Barbarian.specializationStartLevel == 3)
  }

  test("Dnd5Barbarian hit dice is 1d12") {
    assert(Dnd5Barbarian.hitDice == "1d12")
  }

  test("Dnd5Barbarian is proficient with light and medium armor and shields") {
    assert(Dnd5Barbarian.armorProficiencies.length == 3)
    assert((Dnd5Barbarian.armorProficiencies count(_ == "Light armor")) == 1)
    assert((Dnd5Barbarian.armorProficiencies count(_ == "Medium armor")) == 1)
    assert((Dnd5Barbarian.armorProficiencies count(_ == "Shields")) == 1)
  }

  test("Dnd5Barbarian is proficient with simple and martial weapons") {
    assert(Dnd5Barbarian.weaponProficiencies.length == 2)
    assert((Dnd5Barbarian.weaponProficiencies count(_ == "Simple weapons")) == 1)
    assert((Dnd5Barbarian.weaponProficiencies count(_ == "Martial weapons")) == 1)
  }

  test("Dnd5Barbarian has no tool proficiencies") {
    assert(Dnd5Barbarian.toolProficiencies.isEmpty)
  }

  test("DndBarbarian has Strength and Consitution saving throw proficiencies") {
    assert(Dnd5Barbarian.savingThrowProficiencies.length == 2)
    assert((Dnd5Barbarian.savingThrowProficiencies count(_ == DndAbilitiesEnum.Strength)) == 1)
    assert((Dnd5Barbarian.savingThrowProficiencies count(_ == DndAbilitiesEnum.Constitution)) == 1)
  }

  test("Dnd5Barbarian has 6 skill choices (Animal Handling, Athletics, Intimidation, Nature, " +
    "Perception, and Survival") {
    assert(Dnd5Barbarian.skillChoices.length == 6)
    assert((Dnd5Barbarian.skillChoices count(_ == "Animal Handling")) == 1)
    assert((Dnd5Barbarian.skillChoices count(_ == "Athletics")) == 1)
    assert((Dnd5Barbarian.skillChoices count(_ == "Intimidation")) == 1)
    assert((Dnd5Barbarian.skillChoices count(_ == "Nature")) == 1)
    assert((Dnd5Barbarian.skillChoices count(_ == "Perception")) == 1)
    assert((Dnd5Barbarian.skillChoices count(_ == "Survival")) == 1)
  }

  test("Dnd5Barbarian gets to choose 2 of the available skills") {
    assert(Dnd5Barbarian.numberOfSkills == 2)
  }

  test("Dnd5Barbarian has 12 class features") {
    assert(Dnd5Barbarian.getClassFeaturesUpToClassLevel(20).length == 12)
  }

  test("DndBarbarian has 2 first level class features (Rage and Unarmored Defense)") {
    val features = Dnd5Barbarian.getClassFeaturesForClassLevel(1)
    assert(features.length == 2)
    assert(features(0).name == "Rage")
    assert(features(1).name == "Unarmored Defense")
  }

  test("DndBarbarian has 2 2nd level class features (Danger Sense and Reckless Attack)") {
    val features = Dnd5Barbarian.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert(features(0).name == "Reckless Attack")
    assert(features(1).name == "Danger Sense")
  }

  test("DndBarbarian has no 3rd or 4th level class features") {
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(3).isEmpty)
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(4).isEmpty)
  }

  test("DndBarbarian has 2 5th level class features (Extra Attack and Fast Movement)") {
    val features = Dnd5Barbarian.getClassFeaturesForClassLevel(5)
    assert(features.length == 2)
    assert(features(0).name == "Extra Attack")
    assert(features(1).name == "Fast Movement")
  }

  test("DndBarbarian has no 6th level class features") {
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(6).isEmpty)
  }

  test("DndBarbarian has 1 7th level class feature (Feral Instinct)") {
    val features = Dnd5Barbarian.getClassFeaturesForClassLevel(7)
    assert(features.length == 1)
    assert(features.head.name == "Feral Instinct")
  }

  test("DndBarbarian has no 8th level class features") {
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(8).isEmpty)
  }

  test("DndBarbarian has 1 9th level class feature (Brutal Critical)") {
    val features = Dnd5Barbarian.getClassFeaturesForClassLevel(9)
    assert(features.length == 1)
    assert(features.head.name == "Brutal Critical")
  }

  test("DndBarbarian has no 10th level class features") {
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(10).isEmpty)
  }

  test("DndBarbarian has 1 11th level class feature (Relentless Rage)") {
    val features = Dnd5Barbarian.getClassFeaturesForClassLevel(11)
    assert(features.length == 1)
    assert(features.head.name == "Relentless Rage")
  }

  test("DndBarbarian has no 12th, 13th, or 14th level class features") {
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(12).isEmpty)
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(13).isEmpty)
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(14).isEmpty)
  }

  test("DndBarbarian has 1 15th level class feature (Peristent Rage)") {
    val features = Dnd5Barbarian.getClassFeaturesForClassLevel(15)
    assert(features.length == 1)
    assert(features.head.name == "Persistent Rage")
  }

  test("DndBarbarian has no 16th or 17th level class features") {
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(16).isEmpty)
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(17).isEmpty)
  }

  test("DndBarbarian has 1 18th level class feature (Indomitable Might)") {
    val features = Dnd5Barbarian.getClassFeaturesForClassLevel(18)
    assert(features.length == 1)
    assert(features.head.name == "Indomitable Might")
  }

  test("DndBarbarian has no 19th level class features") {
    assert(Dnd5Barbarian.getClassFeaturesForClassLevel(19).isEmpty)
  }

  test("DndBarbarian has 1 20th level class feature (Primal Champion)") {
    val features = Dnd5Barbarian.getClassFeaturesForClassLevel(20)
    assert(features.length == 1)
    assert(features.head.name == "Primal Champion")
  }

  test("DndBarbarian may rage twice per long rest at levels 1 and 2") {
    assert(Dnd5Barbarian.ragesByLevel(1) == 2)
    assert(Dnd5Barbarian.ragesByLevel(2) == 2)
  }

  test("DndBarbarian may rage 3 times per long rest at levels 3 through 5") {
    assert(Dnd5Barbarian.ragesByLevel(3) == 3)
    assert(Dnd5Barbarian.ragesByLevel(4) == 3)
    assert(Dnd5Barbarian.ragesByLevel(5) == 3)
  }

  test("DndBarbarian may rage 4 times per long rest at levels 6 through 11") {
    assert(Dnd5Barbarian.ragesByLevel(6) == 4)
    assert(Dnd5Barbarian.ragesByLevel(7) == 4)
    assert(Dnd5Barbarian.ragesByLevel(8) == 4)
    assert(Dnd5Barbarian.ragesByLevel(9) == 4)
    assert(Dnd5Barbarian.ragesByLevel(10) == 4)
    assert(Dnd5Barbarian.ragesByLevel(11) == 4)
  }

  test("DndBarbarian may rage 5 times per long rest at levels 12 through 16") {
    assert(Dnd5Barbarian.ragesByLevel(12) == 5)
    assert(Dnd5Barbarian.ragesByLevel(13) == 5)
    assert(Dnd5Barbarian.ragesByLevel(14) == 5)
    assert(Dnd5Barbarian.ragesByLevel(15) == 5)
    assert(Dnd5Barbarian.ragesByLevel(16) == 5)
  }

  test("DndBarbarian may rage 6 times per long rest at levels 17 through 19") {
    assert(Dnd5Barbarian.ragesByLevel(17) == 6)
    assert(Dnd5Barbarian.ragesByLevel(18) == 6)
    assert(Dnd5Barbarian.ragesByLevel(19) == 6)
  }

  test("DndBarbarian has an unlimited number of rages at level 20") {
    assert(Dnd5Barbarian.ragesByLevel(20) == -1)
  }

  test("DndBarbarian has +2 extra Rage damage at levels 1 through 8") {
    assert(Dnd5Barbarian.rageDamageBonusByLevel(1) == 2)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(2) == 2)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(3) == 2)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(4) == 2)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(5) == 2)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(6) == 2)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(7) == 2)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(8) == 2)
  }

  test("DndBarbarian has +3 extra Rage damage at levels 9 through 15") {
    assert(Dnd5Barbarian.rageDamageBonusByLevel(9) == 3)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(10) == 3)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(11) == 3)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(12) == 3)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(13) == 3)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(14) == 3)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(15) == 3)
  }

  test("DndBarbarian has +4 extra Rage damage at levels 16 through 20") {
    assert(Dnd5Barbarian.rageDamageBonusByLevel(16) == 4)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(17) == 4)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(18) == 4)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(19) == 4)
    assert(Dnd5Barbarian.rageDamageBonusByLevel(20) == 4)
  }
}
