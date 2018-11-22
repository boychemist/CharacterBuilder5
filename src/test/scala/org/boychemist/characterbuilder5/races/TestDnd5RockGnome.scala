package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5RockGnome extends FunSuite with DiagrammedAssertions {
  test("The Rock Gnome race identifier should be '" + Dnd5RacesEnum.RockGnome.toString + "'"){
    assert(Dnd5RockGnome.race.toString == Dnd5RacesEnum.RockGnome.toString)
  }

  test("Rock Gnomes are small sized creatures"){
    assert(Dnd5RockGnome.size == DndCharacterSizeEnum.Small)
  }

  test("Rock Gnome base speed is 25 feet"){
    assert(Dnd5RockGnome.baseSpeed == 25)
  }

  test("Rock Gnomes have no intrinsic skills"){
    assert(Dnd5RockGnome.skillProficiencies.isEmpty)
  }

  test("Rock Gnomes have no weapon proficiencies") {
    assert(Dnd5RockGnome.weaponProficiencies.length == 0)
  }

  test("Rock Gnome have no armor proficiencies") {
    assert(Dnd5RockGnome.armorProficiencies.isEmpty)
  }

  test("Rock Gnome 1 tool proficiency choices") {
    assert(Dnd5RockGnome.toolsForProficiency.length == 1)
  }

  test("Rock Gnome get +2 Intelligence and +1 Dexterity") {
    val intAdjust = Dnd5RockGnome.abilityAdjustments.head
    val conAdjust = Dnd5RockGnome.abilityAdjustments.tail.head

    assert(conAdjust.ability == DndAbilitiesEnum.Constitution)
    assert(conAdjust.amount == 1)
    assert(intAdjust.ability == DndAbilitiesEnum.Intelligence)
    assert(intAdjust.amount == 2)
  }

  test("Rock Gnomes have 4 racial abilities (Darkvision, Gnome Cunning, Artificier's Lore, " +
    "and Tinker)") {
    assert(Dnd5RockGnome.racialAbilities.length == 4)
    assert((Dnd5RockGnome.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5RockGnome.racialAbilities count(_.abilityName == "Gnome Cunning")) == 1)
    assert((Dnd5RockGnome.racialAbilities count(_.abilityName == "Artificier's Lore")) == 1)
    assert((Dnd5RockGnome.racialAbilities count(_.abilityName == "Tinker")) == 1)
  }
}
