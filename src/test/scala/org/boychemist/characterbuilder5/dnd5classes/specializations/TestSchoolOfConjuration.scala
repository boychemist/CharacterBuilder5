package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestSchoolOfConjuration extends FunSuite with DiagrammedAssertions {
  test("School of Conjuration provides specialization features at 4 levels") {
    assert(SchoolOfConjuration.features.size == 4)
  }

  test("School of Conjuration provides 5 specialization features") {
    assert(SchoolOfConjuration.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("School of Conjuration provides 2 feature at 2nd level (Conjuration Savant and Minor Conjuration)") {
    val features = SchoolOfConjuration.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert(features.head.name == "Conjuration Savant")
    assert(features.last.name == "Minor Conjuration")
  }

  test("School of Conjuration provides 1 feature at 6th level (Benign Transposition)") {
    val features = SchoolOfConjuration.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Benign Transposition")
  }

  test("School of Conjuration provides 1 feature at 10th level (Focused Conjuration)") {
    val features = SchoolOfConjuration.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "Focused Conjuration")
  }

  test("School of Conjuration provides 1 feature at 14th level (Durable Summons)") {
    val features = SchoolOfConjuration.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Durable Summons")
  }
}
