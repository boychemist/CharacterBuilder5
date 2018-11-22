package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestNatureDomain extends FunSuite with DiagrammedAssertions {
  test("Nature Domain provides specialization features at 5 levels") {
    assert(NatureDomain.features.size == 5)
  }

  test("Nature Domain provides 7 features") {
    assert(NatureDomain.getClassFeaturesUpToClassLevel(20).length == 7)
  }

  test("Nature Domain provides 3 feature at level 1") {
    assert(NatureDomain.getClassFeaturesForClassLevel(1).length == 3)
  }

  test("Nature Domain provides 1 feature at level 2") {
    assert(NatureDomain.getClassFeaturesForClassLevel(2).length == 1)
  }

  test("Nature Domain provides 1 feature at level 6") {
    assert(NatureDomain.getClassFeaturesForClassLevel(6).length == 1)
  }

  test("Nature Domain provides 1 feature at level 8") {
    assert(NatureDomain.getClassFeaturesForClassLevel(8).length == 1)
  }

  test("Nature Domain provides 1 feature at level 17") {
    assert(NatureDomain.getClassFeaturesForClassLevel(17).length == 1)
  }
}
