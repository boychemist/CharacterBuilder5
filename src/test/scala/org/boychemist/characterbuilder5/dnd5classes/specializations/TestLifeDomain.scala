package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestLifeDomain extends FunSuite with DiagrammedAssertions {
  test("Life Domain provides specialization features at 5 levels") {
  assert(LifeDomain.features.size == 5)
}

  test("Life Domain provides 7 features") {
  assert(LifeDomain.getClassFeaturesUpToClassLevel(20).length == 7)
}

  test("Life Domain provides 3 feature at level 1") {
  assert(LifeDomain.getClassFeaturesForClassLevel(1).length == 3)
}

  test("Life Domain provides 1 feature at level 2") {
  assert(LifeDomain.getClassFeaturesForClassLevel(2).length == 1)
}

  test("Life Domain provides 1 feature at level 6") {
  assert(LifeDomain.getClassFeaturesForClassLevel(6).length == 1)
}

  test("Life Domain provides 1 feature at level 8") {
  assert(LifeDomain.getClassFeaturesForClassLevel(8).length == 1)
}

  test("Life Domain provides 1 feature at level 17") {
  assert(LifeDomain.getClassFeaturesForClassLevel(17).length == 1)
}
}
