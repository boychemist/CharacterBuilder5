package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestChampion extends FunSuite with DiagrammedAssertions {
  test("Champion provides specialization features at 5 levels") {
    assert(Champion.features.size == 5)
  }

  test("Champion provides 5 specialization features") {
    assert(Champion.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("Champion provides 1 feature at 3rd level (Improved Critical)") {
    val features = Champion.getClassFeaturesForClassLevel(3)
    assert(features.length == 1)
    assert(features.head.name == "Improved Critical")
  }

  test("Champion provides 1 feature at 7th level (Remarkable Athlete)") {
    val features = Champion.getClassFeaturesForClassLevel(7)
    assert(features.length == 1)
    assert(features.head.name == "Remarkable Athlete")
  }

  test("Champion provides 1 feature at 10th level (Additional Fighting Style)") {
    val features = Champion.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Additional Fighting Style")
  }

  test("Champion provides 1 feature at 15th level (Superior Critical)") {
    val features = Champion.getClassFeaturesForClassLevel(15)
    assert(features.length == 1)
    assert(features.head.name == "Superior Critical")
  }

  test("Champion provides 1 feature at 18th level (Survivor)") {
    val features = Champion.getClassFeaturesForClassLevel(18)
    assert(features.length == 1)
    assert(features.head.name == "Survivor")
  }
}
