package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._
import org.scalatest._

class TestDnd5Human extends FunSuite with DiagrammedAssertions {
  test("The Human race identifier should be '" + Dnd5RacesEnum.Human.toString + "'"){
    assert(Dnd5Human.race.toString == Dnd5RacesEnum.Human.toString)
  }

  test("Humans are medium sized creatures"){
    assert(Dnd5Human.size == DndCharacterSizeEnum.Medium)
  }

  test("Human base speed is 30 feet"){
    assert(Dnd5Human.baseSpeed == 30)
  }

  test("Humans have no intrinsic skills"){
    assert(Dnd5Human.skillProficiencies.isEmpty)
  }

  test("Humans have no weapon proficiencies") {
    assert(Dnd5Human.weaponProficiencies.isEmpty)
  }

  test("Humans have no armor proficiencies") {
    assert(Dnd5Human.armorProficiencies.isEmpty)
  }

  test("Humans have no tool proficiency choices") {
    assert(Dnd5Human.toolsForProficiency.isEmpty)
  }

  test("Humans get +1 to each ability") {
    assert(Dnd5Human.abilityAdjustments.length == DndAbilitiesEnum.values.size)
    val abilityIter = DndAbilitiesEnum.values.iterator
    while (abilityIter.hasNext) {
      val anAbility = abilityIter.next()
      assert((Dnd5Human.abilityAdjustments count(adj => adj.ability == anAbility && adj.amount == 1)) == 1)
    }
  }

  test("Humans have 1 racial ability (Second Language)") {
    assert(Dnd5Human.racialAbilities.length == 1)
    assert((Dnd5Human.racialAbilities count(_.abilityName == "Second Language")) == 1)
  }
}
