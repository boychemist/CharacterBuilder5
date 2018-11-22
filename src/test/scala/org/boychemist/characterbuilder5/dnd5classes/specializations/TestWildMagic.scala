package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestWildMagic extends FunSuite with DiagrammedAssertions {
  test("Wild Magic provides specialization features at 4 levels") {
    assert(WildMagic.features.size == 4)
  }

  test("Wild Magic provides 5 specialization features") {
    assert(WildMagic.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("Wild Magic provides 2 feature at 1st level (Wild Magic Surge and Tides of Chaos)") {
    val features = WildMagic.getClassFeaturesForClassLevel(1)
    assert(features.length == 2)
    assert(features.head.name == "Wild Magic Surge")
    assert(features.last.name == "Tides of Chaos")
  }

  test("Wild Magic provides 1 feature at 6th level (Bend Luck)") {
    val features = WildMagic.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Bend Luck")
  }

  test("Wild Magic provides 1 feature at 14th level (Controlled Chaos)") {
    val features = WildMagic.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Controlled Chaos")
  }

  test("Wild Magic provides 1 feature at 18th level (Spell Bombardment)") {
    val features = WildMagic.getClassFeaturesForClassLevel(18)
    assert(features.length == 1)
    assert(features.head.name == "Spell Bombardment")
  }
}
