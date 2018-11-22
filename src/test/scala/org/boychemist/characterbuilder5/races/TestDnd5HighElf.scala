package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5HighElf extends FunSuite with DiagrammedAssertions {
  test("The High Elf race identifier should be '" + Dnd5RacesEnum.HighElf.toString + "'") {
    assert(Dnd5HighElf.race.toString == Dnd5RacesEnum.HighElf.toString)
  }

  test("High Elves are medium sized creatures"){
    assert(Dnd5HighElf.size == DndCharacterSizeEnum.Medium)
  }

  test("High Elf base speed is 30 feet"){
    assert(Dnd5HighElf.baseSpeed == 30)
  }

  test("High Elves have no intrinsic skills"){
    assert(Dnd5HighElf.skillProficiencies.isEmpty)
  }

  test("High Elves have 4 weapon proficiencies") {
    assert(Dnd5HighElf.weaponProficiencies.length == 4)
  }

  test("High Elves have no armor proficiencies") {
    assert(Dnd5HighElf.armorProficiencies.isEmpty)
  }

  test("High Elves have no tool proficiency choices") {
    assert(Dnd5HighElf.toolsForProficiency.isEmpty)
  }

  test("High Elves get +2 Dex and +1 Intelligence") {
    val dexAdjust = Dnd5HighElf.abilityAdjustments.head
    val intAdjust = Dnd5HighElf.abilityAdjustments.tail.head

    assert(dexAdjust.ability == DndAbilitiesEnum.Dexterity)
    assert(dexAdjust.amount == 2)
    assert(intAdjust.ability == DndAbilitiesEnum.Intelligence)
    assert(intAdjust.amount == 1)
  }

  test("High Elves have 6 racial abilities (Darkvision, Keen Senses, Fey Ancestry, Trance, " +
    "Cantrip, and Extra Language)") {
    assert(Dnd5HighElf.racialAbilities.length == 6)
    assert((Dnd5HighElf.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5HighElf.racialAbilities count(_.abilityName == "Keen Senses")) == 1)
    assert((Dnd5HighElf.racialAbilities count(_.abilityName == "Fey Ancestry")) == 1)
    assert((Dnd5HighElf.racialAbilities count(_.abilityName == "Trance")) == 1)
    assert((Dnd5HighElf.racialAbilities count(_.abilityName == "Cantrip"))== 1)
    assert((Dnd5HighElf.racialAbilities count(_.abilityName == "Extra Language")) == 1)
  }
}
