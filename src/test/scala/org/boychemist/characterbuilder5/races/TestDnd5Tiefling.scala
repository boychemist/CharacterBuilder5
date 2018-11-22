package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5Tiefling extends FunSuite with DiagrammedAssertions {
  test("The Tiefling race identifier should be '" + Dnd5RacesEnum.Tiefling.toString + "'"){
    assert(Dnd5Tiefling.race.toString == Dnd5RacesEnum.Tiefling.toString)
  }

  test("Tiefling are medium sized creatures"){
    assert(Dnd5Tiefling.size == DndCharacterSizeEnum.Medium)
  }

  test("Tiefling base speed is 30 feet"){
    assert(Dnd5Tiefling.baseSpeed == 30)
  }

  test("Tiefling have no intrinsic skills"){
    assert(Dnd5Tiefling.skillProficiencies.isEmpty)
  }

  test("Tieflings have no weapon proficiencies") {
    assert(Dnd5Tiefling.weaponProficiencies.length == 0)
  }

  test("Tiefling have no armor proficiencies") {
    assert(Dnd5Tiefling.armorProficiencies.isEmpty)
  }

  test("Tiefling no tool proficiency choices") {
    assert(Dnd5Tiefling.toolsForProficiency.isEmpty)
  }

  test("Tiefling get +2 Charisma and +1 Intelligence") {
    val chaAdjust = Dnd5Tiefling.abilityAdjustments.head
    val intAdjust = Dnd5Tiefling.abilityAdjustments.tail.head

    assert(chaAdjust.ability == DndAbilitiesEnum.Charisma)
    assert(chaAdjust.amount == 2)
    assert(intAdjust.ability == DndAbilitiesEnum.Intelligence)
    assert(intAdjust.amount == 1)
  }

  test("Tiefling have 3 racial abilities (Darkvision, Hellish Resistance, and Infernal Legacy") {
    assert(Dnd5Tiefling.racialAbilities.length == 3)
    assert((Dnd5Tiefling.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5Tiefling.racialAbilities count(_.abilityName == "Hellish Resistance")) == 1)
    assert((Dnd5Tiefling.racialAbilities count(_.abilityName == "Infernal Legacy")) == 1)
  }
}
