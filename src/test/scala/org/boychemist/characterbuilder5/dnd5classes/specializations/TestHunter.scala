package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestHunter extends FunSuite with DiagrammedAssertions {
  test("Hunter provides specialization features at 4 levels") {
    assert(Hunter.features.size == 4)
  }

  test("Hunter provides 4 specialization features") {
    assert(Hunter.getClassFeaturesUpToClassLevel(20).length == 4)
  }

  test("Hunter provides 1 feature at 3rd level (Hunter's Prey)") {
    val features = Hunter.getClassFeaturesForClassLevel(3)
    assert(features.length == 1)
    assert(features.head.name == "Hunter's Prey")
  }

  test("Hunter provides 1 feature at 7th level (Defensive Tactics)") {
    val features = Hunter.getClassFeaturesForClassLevel(7)
    assert(features.length == 1)
    assert(features.head.name == "Defensive Tactics")
  }

  test("Hunter provides 1 feature at 11th level (Multiattack)") {
    val features = Hunter.getClassFeaturesForClassLevel(11)
    assert(features.length == 1)
    assert(features.head.name == "Multiattack")
  }

  test("Hunter provides 1 feature at 15th level (Superior Hunter's Defense)") {
    val features = Hunter.getClassFeaturesForClassLevel(15)
    assert(features.length == 1)
    assert(features.head.name == "Superior Hunter's Defense")
  }
}
