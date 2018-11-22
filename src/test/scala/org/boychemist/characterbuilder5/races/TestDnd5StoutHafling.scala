package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._
import org.scalatest._

class TestDnd5StoutHafling extends FunSuite with DiagrammedAssertions {
  test("The Stout Hafling race identifier should be '" + Dnd5RacesEnum.StoutHafling.toString + "'") {
    assert(Dnd5StoutHafling.race.toString == Dnd5RacesEnum.StoutHafling.toString)
  }

  test("Stout Haflings are small sized creatures") {
    assert(Dnd5StoutHafling.size == DndCharacterSizeEnum.Small)
  }

  test("Stout Hafling base speed is 25 feet") {
    assert(Dnd5StoutHafling.baseSpeed == 25)
  }

  test("Stout Hafling have no intrinsic skills") {
    assert(Dnd5StoutHafling.skillProficiencies.isEmpty)
  }

  test("Stout Haflings have no weapon proficiencies") {
    assert(Dnd5StoutHafling.weaponProficiencies.isEmpty)
  }

  test("Stout Haflings have no armor proficiencies") {
    assert(Dnd5StoutHafling.armorProficiencies.isEmpty)
  }

  test("Stout Haflings have no tool proficiency choices") {
    assert(Dnd5StoutHafling.toolsForProficiency.isEmpty)
  }

  test("Stout Haflings get +2 Dex and +1 Constitution") {
    val dexAdjust = Dnd5StoutHafling.abilityAdjustments.head
    val conAdjust = Dnd5StoutHafling.abilityAdjustments.tail.head

    assert(dexAdjust.ability == DndAbilitiesEnum.Dexterity)
    assert(dexAdjust.amount == 2)
    assert(conAdjust.ability == DndAbilitiesEnum.Constitution)
    assert(conAdjust.amount == 1)
  }

  test("Stout Hafling have 4 racial abilities (Lucky, Brave, Hafling Nimbleness, " +
    "and Stout Resilience)") {
    assert(Dnd5StoutHafling.racialAbilities.length == 4)
    assert((Dnd5StoutHafling.racialAbilities count (_.abilityName == "Lucky")) == 1)
    assert((Dnd5StoutHafling.racialAbilities count (_.abilityName == "Brave")) == 1)
    assert((Dnd5StoutHafling.racialAbilities count (_.abilityName == "Hafling Nimbleness")) == 1)
    assert((Dnd5StoutHafling.racialAbilities count (_.abilityName == "Stout Resilience")) == 1)
  }
}
