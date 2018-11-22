package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5ForestGnome extends FunSuite with DiagrammedAssertions {
  test("The Forest Gnome race identifier should be '" + Dnd5RacesEnum.ForestGnome.toString + "'"){
    assert(Dnd5ForestGnome.race.toString == Dnd5RacesEnum.ForestGnome.toString)
  }

  test("Forest Gnomes are small sized creatures"){
    assert(Dnd5ForestGnome.size == DndCharacterSizeEnum.Small)
  }

  test("Forest Gnome base speed is 25 feet"){
    assert(Dnd5ForestGnome.baseSpeed == 25)
  }

  test("Forest Gnomes have no intrinsic skills"){
    assert(Dnd5ForestGnome.skillProficiencies.isEmpty)
  }

  test("Forest Gnomes have no weapon proficiencies") {
    assert(Dnd5ForestGnome.weaponProficiencies.length == 0)
  }

  test("Forest Gnome have no armor proficiencies") {
    assert(Dnd5ForestGnome.armorProficiencies.isEmpty)
  }

  test("Forest Gnome have no tool proficiency choices") {
    assert(Dnd5ForestGnome.toolsForProficiency.isEmpty)
  }

  test("Forest Gnome get +2 Intelligence and +1 Dexterity") {
    val intAdjust = Dnd5ForestGnome.abilityAdjustments.head
    val dexAdjust = Dnd5ForestGnome.abilityAdjustments.tail.head

    assert(dexAdjust.ability == DndAbilitiesEnum.Dexterity)
    assert(dexAdjust.amount == 1)
    assert(intAdjust.ability == DndAbilitiesEnum.Intelligence)
    assert(intAdjust.amount == 2)
  }

  test("Forest Gnomes have 4 racial abilities (Darkvision, Gnome Cunning, Natural Illusionist, " +
    "and Speak with Small Beasts)") {
    assert(Dnd5ForestGnome.racialAbilities.length == 4)
    assert((Dnd5ForestGnome.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5ForestGnome.racialAbilities count(_.abilityName == "Gnome Cunning")) == 1)
    assert((Dnd5ForestGnome.racialAbilities count(_.abilityName == "Natural Illusionist")) == 1)
    assert((Dnd5ForestGnome.racialAbilities count(_.abilityName == "Speak with Small Beasts")) == 1)
  }
}
