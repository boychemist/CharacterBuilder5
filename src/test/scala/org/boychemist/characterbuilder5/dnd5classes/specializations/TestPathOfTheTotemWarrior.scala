package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestPathOfTheTotemWarrior extends FunSuite with DiagrammedAssertions {
  test("Path of the Totem Warrior provides specializations at 4 levels (3, 6, 10, 14)") {
    assert(PathOfTheTotemWarrior.features.size == 4)
    assert(PathOfTheTotemWarrior.getClassFeaturesForClassLevel(3).length == 2)
    assert(PathOfTheTotemWarrior.getClassFeaturesForClassLevel(6).length == 1)
    assert(PathOfTheTotemWarrior.getClassFeaturesForClassLevel(10).length == 1)
    assert(PathOfTheTotemWarrior.getClassFeaturesForClassLevel(14).length == 1)
  }

  test("Path of the Totem Warrior provides 5 features (Spirit Seeker, Totem Spirit, " +
  "Aspect of the Beast, Spirit Walker, Totemic Attunement)") {
    val allFeatures = PathOfTheTotemWarrior.getClassFeaturesUpToClassLevel(20)
    assert(allFeatures.length == 5)
    assert((allFeatures count(_.name=="Spirit Seeker")) == 1)
    assert((allFeatures count(_.name=="Totem Spirit")) == 1)
    assert((allFeatures count(_.name=="Aspect of the Beast")) == 1)
    assert((allFeatures count(_.name=="Spirit Walker")) == 1)
    assert((allFeatures count(_.name=="Totemic Attunement")) == 1)
  }
}
