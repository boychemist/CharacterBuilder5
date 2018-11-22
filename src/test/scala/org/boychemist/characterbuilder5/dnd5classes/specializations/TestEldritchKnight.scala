package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestEldritchKnight extends FunSuite with DiagrammedAssertions {
  test("Eldritch Knight provides specialization features at 5 levels") {
    assert(EldritchKnight.features.size == 5)
  }

  test("Eldritch Knight provides 6 specialization features") {
    assert(EldritchKnight.getClassFeaturesUpToClassLevel(20).length == 6)
  }

  test("Eldritch Knight provides 2 feature ats 3rd level (Spellcasting and Wepon Bond)") {
    val features = EldritchKnight.getClassFeaturesForClassLevel(3)
    assert(features.length == 2)
    assert(features.head.name == "Spellcasting")
    assert(features.last.name == "Weapon Bond")
  }

  test("Eldritch Knight provides 1 feature at 7th level (War Magic)") {
    val features = EldritchKnight.getClassFeaturesForClassLevel(7)
    assert(features.length == 1)
    assert(features.head.name == "War Magic")
  }

  test("Eldritch Knight provides 1 feature at 10th level (Eldritch Strike)") {
    val features = EldritchKnight.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Eldritch Strike")
  }

  test("Eldritch Knight provides 1 feature at 15th level (Arcane Charge)") {
    val features = EldritchKnight.getClassFeaturesForClassLevel(15)
    assert(features.length == 1)
    assert(features.head.name == "Arcane Charge")
  }

  test("Eldritch Knight provides 1 feature at 18th level (Improved War Magic)") {
    val features = EldritchKnight.getClassFeaturesForClassLevel(18)
    assert(features.length == 1)
    assert(features.head.name == "Improved War Magic")
  }
}
