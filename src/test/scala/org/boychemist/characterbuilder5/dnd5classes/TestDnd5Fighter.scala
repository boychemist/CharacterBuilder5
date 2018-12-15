package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5Fighter extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Fighter is '" + Dnd5ClassesEnum.Fighter.toString + "'") {
    assert(Dnd5Fighter.classID == Dnd5ClassesEnum.Fighter)
  }

  test("Dnd5Fighter is specialized starting at level 3") {
    assert(Dnd5Fighter.specializationStartLevel == 3)
  }

  test("Dnd5Fighter hit dice is 1d10") {
    assert(Dnd5Fighter.hitDice == "1d10")
  }

  test("Dnd5Fighter is proficient with light armor, medium armor, heavy armor, and shields") {
    assert(Dnd5Fighter.armorProficiencies.length == 4)
    assert((Dnd5Fighter.armorProficiencies count(_ == "Light armor")) == 1)
    assert((Dnd5Fighter.armorProficiencies count(_ == "Medium armor")) == 1)
    assert((Dnd5Fighter.armorProficiencies count(_ == "Heavy armor")) == 1)
    assert((Dnd5Fighter.armorProficiencies count(_ == "Shields")) == 1)
  }

  test("Dnd5Fighter is proficient with simple weapons and martial weapons") {
    assert(Dnd5Fighter.weaponProficiencies.length == 2)
    assert((Dnd5Fighter.weaponProficiencies count(_ == "Simple weapons")) == 1)
    assert((Dnd5Fighter.weaponProficiencies count(_ == "Martial weapons")) == 1)
  }

  test("Dnd5Fighter has no tool proficiencies") {
    assert(Dnd5Fighter.toolProficiencies.isEmpty)
  }

  test("Dnd5Fighter has Strength and Constitution saving throw proficiencies") {
    assert(Dnd5Fighter.savingThrowProficiencies.length == 2)
    assert((Dnd5Fighter.savingThrowProficiencies count(_ == DndAbilitiesEnum.Strength)) == 1)
    assert((Dnd5Fighter.savingThrowProficiencies count(_ == DndAbilitiesEnum.Constitution)) == 1)
  }

  test("Dnd5Fighter may choose from 8 skills") {
    assert(Dnd5Fighter.skillChoices.length == 8)
    assert((Dnd5Fighter.skillChoices count( _== "Acrobatics")) == 1)
    assert((Dnd5Fighter.skillChoices count( _== "Animal Handling")) == 1)
    assert((Dnd5Fighter.skillChoices count( _== "Athletics")) == 1)
    assert((Dnd5Fighter.skillChoices count( _== "History")) == 1)
    assert((Dnd5Fighter.skillChoices count( _== "Insight")) == 1)
    assert((Dnd5Fighter.skillChoices count( _== "Intimidation")) == 1)
    assert((Dnd5Fighter.skillChoices count( _== "Perception")) == 1)
    assert((Dnd5Fighter.skillChoices count( _== "Survival")) == 1)
  }

  test("Dnd5Fighter gets to choose 2 skills") {
    assert(Dnd5Fighter.numberOfSkills == 2)
  }

  test("Dnd5Fighter has 5 class features") {
    assert(Dnd5Fighter.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("Dnd5Fighter has 2 first level class features (Fighting Style and Second Wind)") {
    val features = Dnd5Fighter.getClassFeaturesForClassLevel(1)
    assert(features.length == 2)
    assert(features.head.name == "Fighting Style")
    assert(features.last.name == "Second Wind")
  }

  test("Dnd5Fighter has 1 second level class feature (Action Surge)") {
    val features = Dnd5Fighter.getClassFeaturesForClassLevel(2)
    assert(features.length == 1)
    assert(features.head.name == "Action Surge")
  }

  test("Dnd5Fighter has 1 5th level class feature (Extra Attack)") {
    val features = Dnd5Fighter.getClassFeaturesForClassLevel(5)
    assert(features.length == 1)
    assert(features.head.name == "Extra Attack")
  }

  test("Dnd5Fighter has 1 9th level class feature (Indomitable)") {
    val features = Dnd5Fighter.getClassFeaturesForClassLevel(9)
    assert(features.length == 1)
    assert(features.head.name == "Indomitable")
  }
}
