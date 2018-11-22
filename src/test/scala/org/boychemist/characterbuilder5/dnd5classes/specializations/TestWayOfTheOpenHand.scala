package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestWayOfTheOpenHand extends FunSuite with DiagrammedAssertions {
  test("Way of the Open Hand provides specializations at 4 levels (3, 6, 11, 17)") {
    assert(WayOfTheOpenHand.features.size == 4)
    assert(WayOfTheOpenHand.getClassFeaturesForClassLevel(3).length == 1)
    assert(WayOfTheOpenHand.getClassFeaturesForClassLevel(6).length == 1)
    assert(WayOfTheOpenHand.getClassFeaturesForClassLevel(11).length == 1)
    assert(WayOfTheOpenHand.getClassFeaturesForClassLevel(17).length == 1)
  }

  test("Way of the Open Hand provides 4 features (Open Hand Technique, Wholeness of Body, " +
    "Tranquility, and Quivering Palm)") {
    val allFeatures = WayOfTheOpenHand.getClassFeaturesUpToClassLevel(20)
    assert(allFeatures.length == 4)
    assert((allFeatures count(_.name=="Open Hand Technique")) == 1)
    assert((allFeatures count(_.name=="Wholeness of Body")) == 1)
    assert((allFeatures count(_.name=="Tranquility")) == 1)
    assert((allFeatures count(_.name=="Quivering Palm")) == 1)
  }
}
