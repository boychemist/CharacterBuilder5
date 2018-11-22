package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestCollegeOfValor extends FunSuite with DiagrammedAssertions {
  test("College of Valor provides specialization features at 3 levels") {
    assert(CollegeOfValor.features.size == 3)
  }

  test("College of Valor provides 4 specialization features") {
    assert(CollegeOfValor.getClassFeaturesUpToClassLevel(20).length == 4)
  }

  test("College of Valor provides 2 features at 3rd level (Bonus Proficiencies and Combat Inspiration)") {
    val features = CollegeOfValor.getClassFeaturesForClassLevel(3)
    assert(features.length == 2)
    assert(features.head.name == "Bonus Proficiencies")
    assert(features.last.name == "Combat Inspiration")
  }

  test("College of Valor provides 1 feature at 6th level (Extra Attack)") {
    val features = CollegeOfValor.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Extra Attack")
  }

  test("College of Valor provides 1 feature at 14th level (Battle Magic)") {
    val features = CollegeOfValor.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Battle Magic")
  }
}
