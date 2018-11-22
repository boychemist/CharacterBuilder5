package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5WoodElf extends FunSuite with DiagrammedAssertions {
  test("The Wood Elf race identifier should be '" + Dnd5RacesEnum.WoodElf.toString + "'"){
    assert(Dnd5WoodElf.race.toString == Dnd5RacesEnum.WoodElf.toString)
  }

  test("Wood Elves are medium sized creatures"){
    assert(Dnd5WoodElf.size == DndCharacterSizeEnum.Medium)
  }

  test("Wood Elf base speed is 35 feet"){
    assert(Dnd5WoodElf.baseSpeed == 35)
  }

  test("Wood Elves have no intrinsic skills"){
    assert(Dnd5WoodElf.skillProficiencies.isEmpty)
  }

  test("Wood Elves have 4 weapon proficiencies") {
    assert(Dnd5WoodElf.weaponProficiencies.length == 4)
  }

  test("Wood Elves have no armor proficiencies") {
    assert(Dnd5WoodElf.armorProficiencies.isEmpty)
  }

  test("Wood Elves have no tool proficiency choices") {
    assert(Dnd5WoodElf.toolsForProficiency.isEmpty)
  }

  test("Wood Elves get +2 Dex and +1 Intelligence") {
    val dexAdjust = Dnd5WoodElf.abilityAdjustments.head
    val wisAdjust = Dnd5WoodElf.abilityAdjustments.tail.head

    assert(dexAdjust.ability == DndAbilitiesEnum.Dexterity)
    assert(dexAdjust.amount == 2)
    assert(wisAdjust.ability == DndAbilitiesEnum.Wisdom)
    assert(wisAdjust.amount == 1)
  }

  test("Wood Elves have 5 racial abilities (Darkvision, Keen Senses, Fey Ancestry, Trance, " +
    "and Mask of the Wild)") {
    assert(Dnd5WoodElf.racialAbilities.length == 5)
    assert((Dnd5WoodElf.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5WoodElf.racialAbilities count(_.abilityName == "Keen Senses")) == 1)
    assert((Dnd5WoodElf.racialAbilities count(_.abilityName == "Fey Ancestry")) == 1)
    assert((Dnd5WoodElf.racialAbilities count(_.abilityName == "Trance")) == 1)
    assert((Dnd5WoodElf.racialAbilities count(_.abilityName == "Mask of the Wild")) == 1)
  }
}
