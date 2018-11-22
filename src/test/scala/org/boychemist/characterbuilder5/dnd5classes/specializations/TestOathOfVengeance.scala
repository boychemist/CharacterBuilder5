package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestOathOfVengeance extends FunSuite with DiagrammedAssertions {
  test("Oath of Vengeance provides specializations at 4 levels (3, 7, 15, 20)") {
    assert(OathOfVengeance.features.size == 4)
    assert(OathOfVengeance.getClassFeaturesForClassLevel(3).length == 2)
    assert(OathOfVengeance.getClassFeaturesForClassLevel(7).length == 1)
    assert(OathOfVengeance.getClassFeaturesForClassLevel(15).length == 1)
    assert(OathOfVengeance.getClassFeaturesForClassLevel(20).length == 1)
  }

  test("Oath of Vengeance provides 5 features (Oath of Vengeance Spells, Channel Divinity, " +
    "Relentless Avenger, Soul of Vengeance, and Avenging Angel)") {
    val allFeatures = OathOfVengeance.getClassFeaturesUpToClassLevel(20)
    assert(allFeatures.length == 5)
    assert((allFeatures count(_.name=="Oath of Vengeance Spells")) == 1)
    assert((allFeatures count(_.name=="Channel Divinity")) == 1)
    assert((allFeatures count(_.name=="Relentless Avenger")) == 1)
    assert((allFeatures count(_.name=="Soul of Vengeance")) == 1)
    assert((allFeatures count(_.name=="Avenging Angel")) == 1)
  }
}
