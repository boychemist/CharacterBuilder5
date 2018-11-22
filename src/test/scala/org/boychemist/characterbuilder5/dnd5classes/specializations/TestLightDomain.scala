package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestLightDomain  extends FunSuite with DiagrammedAssertions {
  test("Light Domain provides specialization features at 5 levels") {
    assert(LightDomain.features.size == 5)
  }

  test("Light Domain provides 7 features") {
    assert(LightDomain.getClassFeaturesUpToClassLevel(20).length == 7)
  }

  test("Light Domain provides 3 feature at level 1") {
    assert(LightDomain.getClassFeaturesForClassLevel(1).length == 3)
  }

  test("Light Domain provides 1 feature at level 2") {
    assert(LightDomain.getClassFeaturesForClassLevel(2).length == 1)
  }

  test("Light Domain provides 1 feature at level 6") {
    assert(LightDomain.getClassFeaturesForClassLevel(6).length == 1)
  }

  test("Light Domain provides 1 feature at level 8") {
    assert(LightDomain.getClassFeaturesForClassLevel(8).length == 1)
  }

  test("Light Domain provides 1 feature at level 17") {
    assert(LightDomain.getClassFeaturesForClassLevel(17).length == 1)
  }
}

