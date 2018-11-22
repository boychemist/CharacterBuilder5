package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestOathOfTheAncients extends FunSuite with DiagrammedAssertions {
  test("Oath of the Ancients provides specializations at 4 levels (3, 7, 15, 20)") {
    assert(OathOfTheAncients.features.size == 4)
    assert(OathOfTheAncients.getClassFeaturesForClassLevel(3).length == 2)
    assert(OathOfTheAncients.getClassFeaturesForClassLevel(7).length == 1)
    assert(OathOfTheAncients.getClassFeaturesForClassLevel(15).length == 1)
    assert(OathOfTheAncients.getClassFeaturesForClassLevel(20).length == 1)
  }

  test("Oath of the Ancients provides 5 features (Oath of the Ancients Spells, Channel Divinity, " +
    "Aura of Warding, Undying Sentinal, and Elder Champion)") {
    val allFeatures = OathOfTheAncients.getClassFeaturesUpToClassLevel(20)
    assert(allFeatures.length == 5)
    assert((allFeatures count(_.name=="Oath of the Ancients Spells")) == 1)
    assert((allFeatures count(_.name=="Channel Divinity")) == 1)
    assert((allFeatures count(_.name=="Aura of Warding")) == 1)
    assert((allFeatures count(_.name=="Undying Sentinel")) == 1)
    assert((allFeatures count(_.name=="Elder Champion")) == 1)
  }
}
