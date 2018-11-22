package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._
import org.scalatest._

class TestDndLightfootHafling extends FunSuite with DiagrammedAssertions {
  test("The Lightfoot Hafling race identifier should be '" + Dnd5RacesEnum.LightfootHalfling.toString + "'"){
    assert(Dnd5LightfootHafling.race.toString == Dnd5RacesEnum.LightfootHalfling.toString)
  }

  test("Lightfoot Haflings are small sized creatures"){
    assert(Dnd5LightfootHafling.size == DndCharacterSizeEnum.Small)
  }

  test("Lightfoot Hafling base speed is 25 feet"){
    assert(Dnd5LightfootHafling.baseSpeed == 25)
  }

  test("Lightfoot Hafling have no intrinsic skills"){
    assert(Dnd5LightfootHafling.skillProficiencies.isEmpty)
  }

  test("Lightfoot Haflings have no weapon proficiencies") {
    assert(Dnd5LightfootHafling.weaponProficiencies.isEmpty)
  }

  test("Lightfoot Haflings have no armor proficiencies") {
    assert(Dnd5LightfootHafling.armorProficiencies.isEmpty)
  }

  test("Lightfoot Haflings have no tool proficiency choices") {
    assert(Dnd5LightfootHafling.toolsForProficiency.isEmpty)
  }

  test("Lightfoot Haflings get +2 Dex and +1 Charisma") {
    val dexAdjust = Dnd5LightfootHafling.abilityAdjustments.head
    val chaAdjust = Dnd5LightfootHafling.abilityAdjustments.tail.head

    assert(dexAdjust.ability == DndAbilitiesEnum.Dexterity)
    assert(dexAdjust.amount == 2)
    assert(chaAdjust.ability == DndAbilitiesEnum.Charisma)
    assert(chaAdjust.amount == 1)
  }

  test("Lightfoot Hafling have 4 racial abilities (Lucky, Brave, Hafling Nimbleness, " +
    "and Naturally Stealthy)") {
    assert(Dnd5LightfootHafling.racialAbilities.length == 4)
    assert((Dnd5LightfootHafling.racialAbilities count(_.abilityName == "Lucky")) == 1)
    assert((Dnd5LightfootHafling.racialAbilities count(_.abilityName == "Brave")) == 1)
    assert((Dnd5LightfootHafling.racialAbilities count(_.abilityName == "Hafling Nimbleness")) == 1)
    assert((Dnd5LightfootHafling.racialAbilities count(_.abilityName == "Naturally Stealthy")) == 1)
  }
}
