package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5Dragonborn extends FunSuite with DiagrammedAssertions {
  test("The Dragonborn race identifier should be '" + Dnd5RacesEnum.DragonBorn.toString + "'"){
    assert(Dnd5Dragonborn.race.toString == Dnd5RacesEnum.DragonBorn.toString)
  }

  test("Dragonborn are medium sized creatures"){
    assert(Dnd5Dragonborn.size == DndCharacterSizeEnum.Medium)
  }

  test("Dragonborn base speed is 30 feet"){
    assert(Dnd5Dragonborn.baseSpeed == 30)
  }

  test("Dragonborn have no intrinsic skills"){
    assert(Dnd5Dragonborn.skillProficiencies.isEmpty)
  }

  test("Dragonborn have no weapon proficiencies") {
    assert(Dnd5Dragonborn.weaponProficiencies.isEmpty)
  }

  test("Dragonborn have no armor proficiencies") {
    assert(Dnd5Dragonborn.armorProficiencies.isEmpty)
  }

  test("Dragonborn have no tool proficiency choices") {
    assert(Dnd5Dragonborn.toolsForProficiency.isEmpty)
  }

  test("Dragonborn get +2 Strength and +1 Charisma") {
    val strAdjust = Dnd5Dragonborn.abilityAdjustments.head
    val chaAdjust = Dnd5Dragonborn.abilityAdjustments.tail.head

    assert(strAdjust.ability == DndAbilitiesEnum.Strength)
    assert(strAdjust.amount == 2)
    assert(chaAdjust.ability == DndAbilitiesEnum.Charisma)
    assert(chaAdjust.amount == 1)
  }

  test("Dragonborn have 3 racial abilities (Draconic Ancestry, Breath Weapon, and Damage Resistance)") {
    assert(Dnd5Dragonborn.racialAbilities.length == 3)
    assert((Dnd5Dragonborn.racialAbilities count(_.abilityName == "Draconic Ancestry")) == 1)
    assert((Dnd5Dragonborn.racialAbilities count(_.abilityName == "Breath Weapon")) == 1)
    assert((Dnd5Dragonborn.racialAbilities count(_.abilityName == "Damage Resistance")) == 1)
  }
}
