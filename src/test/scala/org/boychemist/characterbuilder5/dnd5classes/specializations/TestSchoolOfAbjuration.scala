package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestSchoolOfAbjuration extends FunSuite with DiagrammedAssertions {
  test("School of Abjuration provides specialization features at 4 levels") {
    assert(SchoolOfAbjuration.features.size == 4)
  }

  test("School of Abjuration provides 5 specialization features") {
    assert(SchoolOfAbjuration.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("School of Abjuration provides 2 feature at 2nd level (Abjuration Savant and Arcane Ward)") {
    val features = SchoolOfAbjuration.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert(features.head.name == "Abjuration Savant")
    assert(features.last.name == "Arcane Ward")
  }

  test("School of Abjuration provides 1 feature at 6th level (Projected Ward)") {
    val features = SchoolOfAbjuration.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Projected Ward")
  }

  test("School of Abjuration provides 1 feature at 10th level (Improved Abjuration)") {
    val features = SchoolOfAbjuration.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Improved Abjuration")
  }

  test("School of Abjuration provides 1 feature at 14th level (Spell Resistance)") {
    val features = SchoolOfAbjuration.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Spell Resistance")
  }
}
