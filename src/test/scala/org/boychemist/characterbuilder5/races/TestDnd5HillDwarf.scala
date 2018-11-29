package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5HillDwarf extends FunSuite with DiagrammedAssertions {
  test("The Hill Dwarf race identifier should be '" + Dnd5RacesEnum.HillDwarf.toString + "'"){
    assert(Dnd5HillDwarf.race.toString == Dnd5RacesEnum.HillDwarf.toString)
  }

  test("Hill Dwarves are medium sized creatures"){
    assert(Dnd5HillDwarf.size == DndCharacterSizeEnum.Medium)
  }

  test("Hill Dwarf base speed is 25 feet"){
    assert(Dnd5HillDwarf.baseSpeed == 25)
  }

  test("Hill Dwarves have no intrinsic skills"){
    assert(Dnd5HillDwarf.skillProficiencies.isEmpty)
  }

  test("Hill Dwarves have 4 weapon proficiencies") {
    assert(Dnd5HillDwarf.weaponProficiencies.length == 4)
  }

  test("Hill Dwarves have not armor proficiencies") {
    assert(Dnd5HillDwarf.armorProficiencies.isEmpty)
  }

  test("Hill Dwarves get +1 to hit points at each level") {
    assert(Dnd5HillDwarf.hitPointIncrement() == 1)
  }

  test("Hill Dwarves can choose from 3 tool proficienciess") {
    assert(Dnd5HillDwarf.toolsForProficiency.length == 1)
    assert(Dnd5HillDwarf.toolsForProficiency.head == "You gain proficiency with the artisan's tools of your choice: smith's tools, brewer's supplies, or mason's tools." )
  }

  test("Hill Dwarves get +2 Con and +1 Wisdom") {
    val conAdjust = Dnd5HillDwarf.abilityAdjustments.head
    val wisAdjust = Dnd5HillDwarf.abilityAdjustments.tail.head

    assert(conAdjust.ability == DndAbilitiesEnum.Constitution)
    assert(conAdjust.amount == 2)
    assert(wisAdjust.ability == DndAbilitiesEnum.Wisdom)
    assert(wisAdjust.amount == 1)
  }

  test("Hill Dwarves have three racial abilities (Darkvision, Dwarven Resilience, and Stonecunning)") {
    assert(Dnd5HillDwarf.racialAbilities.length == 3)
    assert((Dnd5HillDwarf.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5HillDwarf.racialAbilities count(_.abilityName == "Dwarven Resilience")) == 1)
    assert((Dnd5HillDwarf.racialAbilities count(_.abilityName == "Stonecunning")) == 1)
  }
}
