package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestSchoolOfDivination extends FunSuite with DiagrammedAssertions {
  test("School of Divination provides specialization features at 4 levels") {
    assert(SchoolOfDivination.features.size == 4)
  }

  test("School of Divination provides 5 specialization features") {
    assert(SchoolOfDivination.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("School of Divination provides 2 feature at 2nd level (Divination Savant and Portent)") {
    val features = SchoolOfDivination.getClassFeaturesForClassLevel(2)
    assert(features.length == 2)
    assert(features.head.name == "Divination Savant")
    assert(features.last.name == "Portent")
  }

  test("School of Divination provides 1 feature at 6th level (Expert Divination)") {
    val features = SchoolOfDivination.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Expert Divination")
  }

  test("School of Divination provides 1 feature at 10th level (The Third Eye)") {
    val features = SchoolOfDivination.getClassFeaturesForClassLevel(10)
    assert(features.length == 1)
    assert(features.head.name == "The Third Eye")
  }

  test("School of Divination provides 1 feature at 14th level (Greater Portent)") {
    val features = SchoolOfDivination.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Greater Portent")
  }
}
