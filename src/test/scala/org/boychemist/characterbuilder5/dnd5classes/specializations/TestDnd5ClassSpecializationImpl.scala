package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestDnd5ClassSpecializationImpl extends FunSuite with DiagrammedAssertions {

  test("Dnd5ClassSpecializationImpl can create an instance that has the same data as PathOfTheBerserker") {
    val testInstance = Dnd5ClassSpecializationImpl.createFromEnum(Dnd5SpecializationsEnum.PathOfTheBerserker)
    assert(testInstance.features == PathOfTheBerserker.features)
    // test that caching works
    val testInstance2 = Dnd5ClassSpecializationImpl.createFromEnum(Dnd5SpecializationsEnum.PathOfTheBerserker)
    assert(testInstance eq testInstance2)
  }

  test("Dnd5ClassSpecializationImpl can create an instance that has the same data as PathOfTheTotemWarrior") {
    val testInstance = Dnd5ClassSpecializationImpl.createFromEnum(Dnd5SpecializationsEnum.PathOfTheTotemWarrior)
    assert(testInstance.features == PathOfTheTotemWarrior.features)
  }

  test("Dnd5ClassSpecializationImpl can create an instance that has the same data as College of Lore") {
    val testInstance = Dnd5ClassSpecializationImpl.createFromEnum(Dnd5SpecializationsEnum.CollegeOfLore)
    assert(testInstance.features == CollegeOfLore.features)
  }

  test("Dnd5ClassSpecializationImpl can create an instance that has the same data as College of Valor") {
    val testInstance = Dnd5ClassSpecializationImpl.createFromEnum(Dnd5SpecializationsEnum.CollegeOfValor)
    assert(testInstance.features == CollegeOfValor.features)
  }

  test("Dnd5ClassSpecializationImpl can create an instance that has the same data as Knowledge Domain") {
    val testInstance = Dnd5ClassSpecializationImpl.createFromEnum(Dnd5SpecializationsEnum.KnowledgeDomain)
    assert(testInstance.features == KnowledgeDomain.features)
  }

  test("Dnd5ClassSpecializationImpl can create an instance that has the same data as Battle Master") {
    val testInstance = Dnd5ClassSpecializationImpl.createFromEnum(Dnd5SpecializationsEnum.BattleMaster)
    assert(testInstance.features == BattleMaster.features)
  }

  test("Dnd5ClassSpecializationImpl can create an instance that has the same data as Way of The Open Hand") {
    val testInstance = Dnd5ClassSpecializationImpl.createFromEnum(Dnd5SpecializationsEnum.WayOfTheOpenHand)
    assert(testInstance.features eq WayOfTheOpenHand.features)
  }

  test("Dnd5ClassSpecializationImpl can create an instance that has the same data as Draconic Bloodline") {
    val testInstance = Dnd5ClassSpecializationImpl.createFromEnum(Dnd5SpecializationsEnum.DraconicBloodline)
    assert(testInstance.features eq DraconicBloodline.features)
    assert(testInstance.description eq DraconicBloodline.description)
  }

  test("Dnd5ClassSpecializationImpl handles all values in Dnd5SpecializationsEnum") {
    // an exception is thrown for the first missing value
    def values = Dnd5SpecializationsEnum.values
    values foreach (Dnd5ClassSpecializationImpl.createFromEnum(_))
  }
}
