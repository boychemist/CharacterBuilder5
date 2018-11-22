package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._
import org.scalatest._

class TestDnd5Drow extends FunSuite with DiagrammedAssertions {
  test("The Drow race identifier should be '" + Dnd5RacesEnum.Drow.toString + "'"){
    assert(Dnd5Drow.race.toString == Dnd5RacesEnum.Drow.toString)
  }

  test("Drow are medium sized creatures"){
    assert(Dnd5Drow.size == DndCharacterSizeEnum.Medium)
  }

  test("Drow Elf base speed is 30 feet"){
    assert(Dnd5Drow.baseSpeed == 30)
  }

  test("Drow have no intrinsic skills"){
    assert(Dnd5Drow.skillProficiencies.isEmpty)
  }

  test("Drow have 4 weapon proficiencies") {
    assert(Dnd5Drow.weaponProficiencies.length == 3)
  }

  test("Drow have no armor proficiencies") {
    assert(Dnd5Drow.armorProficiencies.isEmpty)
  }

  test("Drow get +2 Dex and +1 Charisma") {
    val dexAdjust = Dnd5Drow.abilityAdjustments.head
    val chaAdjust = Dnd5Drow.abilityAdjustments.tail.head

    assert(dexAdjust.ability == DndAbilitiesEnum.Dexterity)
    assert(dexAdjust.amount == 2)
    assert(chaAdjust.ability == DndAbilitiesEnum.Charisma)
    assert(chaAdjust.amount == 1)
  }

  test("Drow have 7 racial abilities (Darkvision, Keen Senses, Fey Ancestry, Trance, " +
    "Superior Darkvision, Sunlight Sensitivity, and Drow Magic)") {
    assert(Dnd5Drow.racialAbilities.length == 7)
    assert((Dnd5Drow.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5Drow.racialAbilities count(_.abilityName == "Keen Senses")) == 1)
    assert((Dnd5Drow.racialAbilities count(_.abilityName == "Fey Ancestry")) == 1)
    assert((Dnd5Drow.racialAbilities count(_.abilityName == "Trance")) == 1)
    assert((Dnd5Drow.racialAbilities count(_.abilityName == "Superior Darkvision")) == 1)
    assert((Dnd5Drow.racialAbilities count(_.abilityName == "Sunlight Sensitivity")) == 1)
    assert((Dnd5Drow.racialAbilities count(_.abilityName == "Drow Magic")) == 1)
  }
}
