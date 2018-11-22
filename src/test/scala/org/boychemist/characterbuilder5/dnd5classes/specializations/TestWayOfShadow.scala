package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestWayOfShadow extends FunSuite with DiagrammedAssertions {
  test("Way of Shadow provides specializations at 4 levels (3, 6, 11, 17)") {
    assert(WayOfShadow.features.size == 4)
    assert(WayOfShadow.getClassFeaturesForClassLevel(3).length == 1)
    assert(WayOfShadow.getClassFeaturesForClassLevel(6).length == 1)
    assert(WayOfShadow.getClassFeaturesForClassLevel(11).length == 1)
    assert(WayOfShadow.getClassFeaturesForClassLevel(17).length == 1)
  }

  test("Way of Shadow provides 4 features (Shadow Arts, Shadow Step, " +
    "Cloak of Shadows, and Opportunist)") {
    val allFeatures = WayOfShadow.getClassFeaturesUpToClassLevel(20)
    assert(allFeatures.length == 4)
    assert((allFeatures count(_.name=="Shadow Arts")) == 1)
    assert((allFeatures count(_.name=="Shadow Step")) == 1)
    assert((allFeatures count(_.name=="Cloak of Shadows")) == 1)
    assert((allFeatures count(_.name=="Opportunist")) == 1)
  }
}
