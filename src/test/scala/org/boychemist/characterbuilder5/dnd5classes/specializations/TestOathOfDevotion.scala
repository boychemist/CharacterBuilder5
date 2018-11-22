package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestOathOfDevotion extends FunSuite with DiagrammedAssertions {
  test("Oath of Devotion provides specializations at 4 levels (3, 7, 15, 20)") {
    assert(OathOfDevotion.features.size == 4)
    assert(OathOfDevotion.getClassFeaturesForClassLevel(3).length == 2)
    assert(OathOfDevotion.getClassFeaturesForClassLevel(7).length == 1)
    assert(OathOfDevotion.getClassFeaturesForClassLevel(15).length == 1)
    assert(OathOfDevotion.getClassFeaturesForClassLevel(20).length == 1)
  }

  test("Oath of Devotion provides 5 features (Oath of Devotion Spells, Channel Divinity, " +
    "Aura of Devotion, Purity of Spirit, and Holy Nimbus)") {
    val allFeatures = OathOfDevotion.getClassFeaturesUpToClassLevel(20)
    assert(allFeatures.length == 5)
    assert((allFeatures count(_.name=="Oath of Devotion Spells")) == 1)
    assert((allFeatures count(_.name=="Channel Divinity")) == 1)
    assert((allFeatures count(_.name=="Aura of Devotion")) == 1)
    assert((allFeatures count(_.name=="Purity of Spirit")) == 1)
    assert((allFeatures count(_.name=="Holy Nimbus")) == 1)
  }
}
