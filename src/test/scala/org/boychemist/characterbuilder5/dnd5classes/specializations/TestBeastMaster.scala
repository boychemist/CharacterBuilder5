package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestBeastMaster extends FunSuite with DiagrammedAssertions {
  test("Beast Master provides specialization features at 4 levels") {
    assert(BeastMaster.features.size == 4)
  }

  test("Beast Master provides 4 specialization features") {
    assert(BeastMaster.getClassFeaturesUpToClassLevel(20).length == 4)
  }

  test("Beast Master provides 1 feature at 3rd level (Ranger's Companion)") {
    val features = BeastMaster.getClassFeaturesForClassLevel(3)
    assert(features.length == 1)
    assert(features.head.name == "Ranger's Companion")
  }

  test("Beast Master provides 1 feature at 7th level (Exceptional Training)") {
    val features = BeastMaster.getClassFeaturesForClassLevel(7)
    assert(features.length == 1)
    assert(features.head.name == "Exceptional Training")
  }

  test("Beast Master provides 1 feature at 11th level (Bestial Fury)") {
    val features = BeastMaster.getClassFeaturesForClassLevel(11)
    assert(features.length == 1)
    assert(features.head.name == "Bestial Fury")
  }

  test("Beast Master provides 1 feature at 15th level (Share Spells)") {
    val features = BeastMaster.getClassFeaturesForClassLevel(15)
    assert(features.length == 1)
    assert(features.head.name == "Share Spells")
  }
}
