package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestBattleMaster extends FunSuite with DiagrammedAssertions {
  test("Battle Master provides specialization features at 4 levels") {
    assert(BattleMaster.features.size == 4)
  }

  test("Battle Master provides 5 specialization features") {
    assert(BattleMaster.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("Battle Master provides 2 feature ats 3rd level (Combat Superiority and Student of War)") {
    val features = BattleMaster.getClassFeaturesForClassLevel(3)
    assert(features.length == 2)
    assert(features.head.name == "Combat Superiority")
    assert(features.last.name == "Student of War")
  }

  test("Battle Master provides 1 feature at 7th level (Know Your Enemy)") {
    val features = BattleMaster.getClassFeaturesForClassLevel(7)
    assert(features.length == 1)
    assert(features.head.name == "Know Your Enemy")
  }

  test("Battle Master provides 1 feature at 10th level (Improved Combat Superiority)") {
    val features = BattleMaster.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Improved Combat Superiority")
  }

  test("Battle Master provides 1 feature at 15th level (Relentless)") {
    val features = BattleMaster.getClassFeaturesForClassLevel(15)
    assert(features.length == 1)
    assert(features.head.name == "Relentless")
  }
}
