package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestWayOfTheFourElements extends FunSuite with DiagrammedAssertions {
  test("Way of Shadow provides 1 specialization at level 3(Discipline of Elements)") {
    assert(WayOfTheFourElements.features.size == 1)

    val features = WayOfTheFourElements.getClassFeaturesUpToClassLevel(20)
    assert(WayOfTheFourElements.getClassFeaturesForClassLevel(3).length == 1)
    assert(features.length == 1)
    assert(features.head.name == "Discipline of the Elements")
  }
}
