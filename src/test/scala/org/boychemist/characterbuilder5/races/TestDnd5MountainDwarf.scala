package org.boychemist.characterbuilder5.races

import org.scalatest._
import org.boychemist.characterbuilder5._

class TestDnd5MountainDwarf extends FunSuite with DiagrammedAssertions {
  test("The Mountain Dwarf race identifier should be '" + Dnd5RacesEnum.MountainDwarf.toString + "'"){
    assert(Dnd5MountainDwarf.race.toString == Dnd5RacesEnum.MountainDwarf.toString)
  }

  test("Mountain Dwarves are medium sized creatures"){
    assert(Dnd5MountainDwarf.size == DndCharacterSizeEnum.Medium)
  }

  test("Mountain Dwarf base speed is 25 feet"){
    assert(Dnd5MountainDwarf.baseSpeed == 25)
  }

  test("Mountain Dwarves have no intrinsic skills"){
    assert(Dnd5MountainDwarf.skillProficiencies.isEmpty)
  }

  test("Mountain Dwarves have 4 weapon proficiencies") {
    assert(Dnd5MountainDwarf.weaponProficiencies.length == 4)
  }

  test("Mountain Dwarves have 2 armor proficiencies") {
    assert(Dnd5MountainDwarf.armorProficiencies.length == 2)
  }

  test("Mountain Dwarves can choose from 3 tool proficiencies") {
    assert(Dnd5MountainDwarf.toolsForProficiency.length == 1)
    assert(Dnd5MountainDwarf.toolsForProficiency.head == "You gain proficiency with the artisan's tools of your choice: smith's tools, brewer's supplies, or mason's tools.")
  }

  test("Mountain Dwarves get +2 Con and +2 Strength") {
    val conAdjust = Dnd5MountainDwarf.abilityAdjustments.head
    val strAdjust = Dnd5MountainDwarf.abilityAdjustments.tail.head

    assert(conAdjust.ability == DndAbilitiesEnum.Constitution)
    assert(conAdjust.amount == 2)
    assert(strAdjust.ability == DndAbilitiesEnum.Strength)
    assert(strAdjust.amount == 2)
  }

  test("Mountain Dwarves have three racial abilities (Darkvision, Dwarven Resilience, and Stonecunning)") {
    assert(Dnd5MountainDwarf.racialAbilities.length == 3)
    assert((Dnd5MountainDwarf.racialAbilities count(_.abilityName == "Darkvision")) == 1)
    assert((Dnd5MountainDwarf.racialAbilities count(_.abilityName == "Dwarven Resilience")) == 1)
    assert((Dnd5MountainDwarf.racialAbilities count(_.abilityName == "Stonecunning")) == 1)
  }
}
