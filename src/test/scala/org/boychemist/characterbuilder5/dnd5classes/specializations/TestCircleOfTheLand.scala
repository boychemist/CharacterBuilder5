package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestCircleOfTheLand extends FunSuite with DiagrammedAssertions {
  test("Circle of the Land provides specialization features at 5 levels") {
    assert(CircleOfTheLand.features.size == 5)
  }

  test("Circle of the Land provides 6 specialization features") {
    assert(CircleOfTheLand.getClassFeaturesUpToClassLevel(20).length == 6)
  }

  test("Circle of the Land provides 2 features at 2nd level (Bonus Cantrip and Natural Recovery)") {
    val features = CircleOfTheLand.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert(features.head.name == "Bonus Cantrip")
    assert(features.last.name == "Natural Recovery")
  }

  test("Circle of the Land provides 1 feature at 3rd level (Circle Spells)") {
    val features = CircleOfTheLand.getClassFeaturesForClassLevel(3)
    assert(features.length == 1)
    assert(features.head.name == "Circle Spells")
  }

  test("Circle of the Land provides 1 feature at 6th level (Circle Spells)") {
    val features = CircleOfTheLand.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Land's Stride")
  }

  test("Circle of the Land provides 1 feature at 10th level (Nature's Ward)") {
    val features = CircleOfTheLand.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Nature's Ward")
  }

  test("Circle of the Land provides 1 feature at 14th level (Nature's Sanctuary)") {
    val features = CircleOfTheLand.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Nature's Sanctuary")
  }
}
