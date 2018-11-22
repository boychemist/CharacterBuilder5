package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestCollegeOfLore extends FunSuite with DiagrammedAssertions {
  test("College of Lore provides specialization features at 3 levels") {
    assert(CollegeOfLore.features.size == 3)
  }

  test("College of Lore provides 4 specialization features") {
    assert(CollegeOfLore.getClassFeaturesUpToClassLevel(20).length == 4)
  }

  test("College of Lore provides 2 features at 3rd level (Bonus Proficiencies and Cutting Words)") {
    val features = CollegeOfLore.getClassFeaturesForClassLevel(3)
    assert(features.length == 2)
    assert(features.head.name == "Bonus Proficiencies")
    assert(features.last.name == "Cutting Words")
  }

  test("College of Lore provides 1 feature at 6th level (Additional Magical Secrets)") {
    val features = CollegeOfLore.getClassFeaturesForClassLevel(6)
    assert(features.length == 1)
    assert(features.head.name == "Additional Magical Secrets")
  }

  test("College of Lore provides 1 feature at 14th level (Peerless Skill)") {
    val features = CollegeOfLore.getClassFeaturesForClassLevel(14)
    assert(features.length == 1)
    assert(features.head.name == "Peerless Skill")
  }
}
