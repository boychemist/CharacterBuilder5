package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5HalfOrc extends FunSuite with DiagrammedAssertions {
  test("The Half-Orc race identifier should be '" + Dnd5RacesEnum.HalfOrc.toString + "'"){
    assert(Dnd5HalfOrc.race.toString == Dnd5RacesEnum.HalfOrc.toString)
  }

  test("Half-Orcs are medium sized creatures"){
    assert(Dnd5HalfOrc.size == DndCharacterSizeEnum.Medium)
  }

  test("Half-Orc base speed is 30 feet"){
    assert(Dnd5HalfOrc.baseSpeed == 30)
  }

  test("Half-Orcs have no intrinsic skills"){
    assert(Dnd5HalfOrc.skillProficiencies.isEmpty)
  }

  test("Half-Orcs have no weapon proficiencies") {
    assert(Dnd5HalfOrc.weaponProficiencies.length == 0)
  }

  test("Half-Orcs have no armor proficiencies") {
    assert(Dnd5HalfOrc.armorProficiencies.isEmpty)
  }

  test("Half-Orcs no tool proficiency choices") {
    assert(Dnd5HalfOrc.toolsForProficiency.isEmpty)
  }

  test("Half-Orcs get +2 Strength and +1 Consititution") {
    val strAdjust = Dnd5HalfOrc.abilityAdjustments.head
    val conAdjust = Dnd5HalfOrc.abilityAdjustments.tail.head

    assert(strAdjust.ability == DndAbilitiesEnum.Strength)
    assert(strAdjust.amount == 2)
    assert(conAdjust.ability == DndAbilitiesEnum.Constitution)
    assert(conAdjust.amount == 1)
  }

  test("Half-Orcs have 4 racial abilities (Darkvision, Menacing, Relentless Endurance, " +
    "and Savage Attacks)") {
    assert(Dnd5HalfOrc.racialAbilities.length == 4)
    assert((Dnd5HalfOrc.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5HalfOrc.racialAbilities count(_.abilityName == "Menacing")) == 1)
    assert((Dnd5HalfOrc.racialAbilities count(_.abilityName == "Relentless Endurance")) == 1)
    assert((Dnd5HalfOrc.racialAbilities count(_.abilityName == "Savage Attacks")) == 1)
  }
}
