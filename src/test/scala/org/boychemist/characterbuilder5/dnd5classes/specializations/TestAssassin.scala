package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestAssassin extends FunSuite with DiagrammedAssertions {
  test("Assassin provides specialization features at 4 levels") {
    assert(Assassin.features.size == 4)
  }

  test("Assassin provides 5 specialization features") {
    assert(Assassin.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("Assassin provides 3 feature at 3rd level (Bonus Proficiencies and Assassinate)") {
    val features = Assassin.getClassFeaturesForClassLevel(3)
    assert(features.length == 2)
    assert(features.head.name == "Bonus Proficiencies")
    assert(features.last.name == "Assassinate")
  }

  test("Assassin provides 1 feature at 9th level (Infiltration Expertise)") {
    val features = Assassin.getClassFeaturesForClassLevel(9)
    assert(features.length == 1)
    assert(features.head.name == "Infiltration Expertise")
  }

  test("Assassin provides 1 feature at 13th level (Impostor)") {
    val features = Assassin.getClassFeaturesForClassLevel(13)
    assert(features.length == 1)
    assert(features.head.name == "Impostor")
  }

  test("Assassin provides 1 feature at 17th level (Death Strike)") {
    val features = Assassin.getClassFeaturesForClassLevel(17)
    assert(features.length == 1)
    assert(features.head.name == "Death Strike")
  }
}
