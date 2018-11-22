package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestCircleOfTheMoon extends FunSuite with DiagrammedAssertions {
  test("Circle of the Moon provides specialization features at 4 levels") {
    assert(CircleOfTheMoon.features.size == 4)
  }

  test("Circle of the Moon provides 5 specialization features") {
    assert(CircleOfTheMoon.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("Circle of the Moon provides 2 features at 2nd level (Combat Wild Shape and Circle Forms)") {
    val features = CircleOfTheMoon.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert(features.head.name == "Combat Wild Shape")
    assert(features.last.name == "Circle Forms")
  }

  test("Circle of the Moon provides 1 feature at 6th level (Primal Strike)") {
    val features = CircleOfTheMoon.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Primal Strike")
  }

  test("Circle of the Moon provides 1 feature at 10th level (Elemental Wild Shape)") {
    val features = CircleOfTheMoon.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Elemental Wild Shape")
  }

  test("Circle of the Moon provides 1 feature at 14th level (Thousand Forms)") {
    val features = CircleOfTheMoon.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Thousand Forms")
  }
}
