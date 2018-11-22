package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestThief extends FunSuite with DiagrammedAssertions {
  test("Thief provides specialization features at 4 levels") {
    assert(Thief.features.size == 4)
  }

  test("Thief provides 5 specialization features") {
    assert(Thief.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("Thief provides 2 feature at 3rd level (Fast Hands and Second-Story Work)") {
    val features = Thief.getClassFeaturesForClassLevel(3)
    assert(features.length == 2)
    assert(features.head.name == "Fast Hands")
    assert(features.last.name == "Second-Story Work")
  }

  test("Thief provides 1 feature at 9th level (Supreme Sneak)") {
    val features = Thief.getClassFeaturesForClassLevel(9)
    assert(features.length == 1)
    assert(features.head.name == "Supreme Sneak")
  }

  test("Thief provides 1 feature at 13th level (Use Magic Device)") {
    val features = Thief.getClassFeaturesForClassLevel(13)
    assert(features.length == 1)
    assert(features.head.name == "Use Magic Device")
  }

  test("Thief provides 1 feature at 17th level (Thief's Reflexes)") {
    val features = Thief.getClassFeaturesForClassLevel(17)
    assert(features.length == 1)
    assert(features.head.name == "Thief's Reflexes")
  }
}
