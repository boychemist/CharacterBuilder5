package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestDraconicBloodline extends FunSuite with DiagrammedAssertions {
  test("DraconicBloodline provides specialization features at 4 levels") {
    assert(DraconicBloodline.features.size == 4)
  }

  test("DraconicBloodline provides 5 specialization features") {
    assert(DraconicBloodline.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("DraconicBloodline provides 2 feature at 1st level (Dragon Ancestor and Draconic Resilience)") {
    val features = DraconicBloodline.getClassFeaturesForClassLevel(1)
    assert(features.length == 2)
    assert(features.head.name == "Dragon Ancestor")
    assert(features.last.name == "Draconic Resilience")
  }

  test("DraconicBloodline provides 1 feature at 6th level (Elemental Affinity)") {
    val features = DraconicBloodline.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Elemental Affinity")
  }

  test("DraconicBloodline provides 1 feature at 14th level (Dragon Wings)") {
    val features = DraconicBloodline.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Dragon Wings")
  }

  test("DraconicBloodline provides 1 feature at 18th level (Draconic Presence)") {
    val features = DraconicBloodline.getClassFeaturesForClassLevel(18)
    assert(features.length == 1)
    assert(features.head.name == "Draconic Presence")
  }
}
