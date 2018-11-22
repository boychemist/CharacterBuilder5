package org.boychemist.characterbuilder5.dnd5classes

import org.scalatest._
import org.boychemist.characterbuilder5.dnd5classes.specializations.Dnd5SpecializationsEnum
import org.boychemist.characterbuilder5._

class TestDnd5Rogue extends FunSuite with DiagrammedAssertions {
  test("The class ID for Dnd5Rogue is '" + Dnd5ClassesEnum.Rogue.toString + "'") {
    assert(Dnd5Rogue.classID == Dnd5ClassesEnum.Rogue)
  }

  test("Dnd5Rogue has three allowed specializations (Thief, Assassin, Arcane Trickster)") {
    assert(Dnd5Rogue.allowedSpecializations.length == 3)
    assert(Dnd5Rogue.allowedSpecializations(0) == Dnd5SpecializationsEnum.Thief)
    assert(Dnd5Rogue.allowedSpecializations(1) == Dnd5SpecializationsEnum.Assassin)
    assert(Dnd5Rogue.allowedSpecializations(2) == Dnd5SpecializationsEnum.ArcaneTrickster)
  }

  test("Dnd5Rogue is specialized starting at level 3") {
    assert(Dnd5Rogue.specializationStartLevel == 3)
  }

  test("Dnd5Rogue hit dice is 1d8") {
    assert(Dnd5Rogue.hitDice == "1d8")
  }

  test("Dnd5Rogue is proficient with light armor") {
    assert(Dnd5Rogue.armorProficiencies.length == 1)
    assert(Dnd5Rogue.armorProficiencies.head == "Light armor")
  }

  test("Dnd5Rogue is proficient with simple weapons, Hand crossbows, Longswords, Rapiers, Shortswords ") {
    assert(Dnd5Rogue.weaponProficiencies.length == 5)
    assert((Dnd5Rogue.weaponProficiencies count(_ == "Simple weapons")) == 1)
    assert((Dnd5Rogue.weaponProficiencies count(_ == "Hand crossbows")) == 1)
    assert((Dnd5Rogue.weaponProficiencies count(_ == "Longswords")) == 1)
    assert((Dnd5Rogue.weaponProficiencies count(_ == "Rapiers")) == 1)
    assert((Dnd5Rogue.weaponProficiencies count(_ == "Shortswords")) == 1)
 }

  test("Dnd5Rogue has 1 tool proficiency, thieves' tools") {
    assert(Dnd5Rogue.toolProficiencies.length == 1)
    assert(Dnd5Rogue.toolProficiencies.head == "Thieves' tools")
  }

  test("Dnd5Rogue has Strength and Constitution saving throw proficiencies") {
    assert(Dnd5Rogue.savingThrowProficiencies.length == 2)
    assert((Dnd5Rogue.savingThrowProficiencies count(_ == DndAbilitiesEnum.Dexterity)) == 1)
    assert((Dnd5Rogue.savingThrowProficiencies count(_ == DndAbilitiesEnum.Intelligence)) == 1)
  }

  test("Dnd5Rogue may choose from 11 skills") {
    assert(Dnd5Rogue.skillChoices.length == 11)
    assert((Dnd5Rogue.skillChoices count( _== "Acrobatics")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Athletics")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Deception")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Insight")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Intimidation")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Investigation")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Perception")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Performance")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Persuasion")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Sleight of Hand")) == 1)
    assert((Dnd5Rogue.skillChoices count( _== "Stealth")) == 1)
  }

  test("Dnd5Rogue gets to choose 4 skills") {
    assert(Dnd5Rogue.numberOfSkills == 4)
  }

  test("Dnd5Rogue has 11 class features") {
    assert(Dnd5Rogue.getClassFeaturesUpToClassLevel(20).length == 11)
  }

  test("Dnd5Rogue has 3 first level class features (Expertise, Sneak Attack, Thieves' Cant)") {
    val features = Dnd5Rogue.getClassFeaturesForClassLevel(1)
    assert(features.length == 3)
    assert((features count(_.name == "Expertise")) == 1)
    assert((features count(_.name == "Sneak Attack")) == 1)
    assert((features count(_.name == "Thieves' Cant")) == 1)
  }

  test("Dnd5Rogue has 1 second level class feature (Cunning Action)") {
    val features = Dnd5Rogue.getClassFeaturesForClassLevel(2)
    assert(features.length == 1)
    assert(features.head.name == "Cunning Action")
  }

  test("Dnd5Rogue has 1 5th level class feature (Uncanny Dodge)") {
    val features = Dnd5Rogue.getClassFeaturesForClassLevel(5)
    assert(features.length == 1)
    assert(features.head.name == "Uncanny Dodge")
  }

  test("Dnd5Rogue has 1 7th level class feature (Evasion)") {
    val features = Dnd5Rogue.getClassFeaturesForClassLevel(7)
    assert(features.length == 1)
    assert(features.head.name == "Evasion")
  }

  test("Dnd5Rogue has 1 11th level class feature (Reliable Talent)") {
    val features = Dnd5Rogue.getClassFeaturesForClassLevel(11)
    assert(features.length == 1)
    assert(features.head.name == "Reliable Talent")
  }

  test("Dnd5Rogue has 1 14th level class feature (Blindsense)") {
    val features = Dnd5Rogue.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Blindsense")
  }

  test("Dnd5Rogue has 1 15th level class feature (Slippery Mind)") {
    val features = Dnd5Rogue.getClassFeaturesForClassLevel(15)
    assert(features.length == 1)
    assert(features.head.name == "Slippery Mind")
  }

  test("Dnd5Rogue has 1 18th level class feature (Elusive)") {
    val features = Dnd5Rogue.getClassFeaturesForClassLevel(18)
    assert(features.length == 1)
    assert(features.head.name == "Elusive")
  }

  test("Dnd5Rogue has 1 20th level class feature (Stroke of Luck)") {
    val features = Dnd5Rogue.getClassFeaturesForClassLevel(20)
    assert(features.length == 1)
    assert(features.head.name == "Stroke of Luck")
  }
}
