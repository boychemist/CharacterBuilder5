package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5HalfElf extends FunSuite with DiagrammedAssertions {
  test("The Half-Elf race identifier should be '" + Dnd5RacesEnum.HalfElf.toString + "'"){
    assert(Dnd5HalfElf.race.toString == Dnd5RacesEnum.HalfElf.toString)
  }

  test("Half-Elves are medium sized creatures"){
    assert(Dnd5HalfElf.size == DndCharacterSizeEnum.Medium)
  }

  test("Half-Elf base speed is 30 feet"){
    assert(Dnd5HalfElf.baseSpeed == 30)
  }

  test("Half-Elves have no intrinsic skills"){
    assert(Dnd5HalfElf.skillProficiencies.isEmpty)
  }

  test("Half-Elves have no weapon proficiencies") {
    assert(Dnd5HalfElf.weaponProficiencies.length == 0)
  }

  test("Half-Elves have no armor proficiencies") {
    assert(Dnd5HalfElf.armorProficiencies.isEmpty)
  }

  test("Half-Elves no tool proficiency choices") {
    assert(Dnd5HalfElf.toolsForProficiency.isEmpty)
  }

  test("Half-Elves get +2 Charisma") {
    val chaAdjust = Dnd5HalfElf.abilityAdjustments.head

    assert(chaAdjust.ability == DndAbilitiesEnum.Charisma)
    assert(chaAdjust.amount == 2)
  }

  test("Half-Elves have 5 racial abilities (Darkvision, Fey Ancestry, Skill Versatility, " +
    "Ability Score Increase, and Extra Language)") {
    assert(Dnd5HalfElf.racialAbilities.length == 5)
    assert((Dnd5HalfElf.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5HalfElf.racialAbilities count(_.abilityName == "Fey Ancestry")) == 1)
    assert((Dnd5HalfElf.racialAbilities count(_.abilityName == "Skill Versatility")) == 1)
    assert((Dnd5HalfElf.racialAbilities count(_.abilityName == "Ability Score Increase")) == 1)
    assert((Dnd5HalfElf.racialAbilities count(_.abilityName == "Extra Language")) == 1)
  }
}
