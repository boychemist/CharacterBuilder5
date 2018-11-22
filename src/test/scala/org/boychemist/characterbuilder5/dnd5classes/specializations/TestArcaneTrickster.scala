package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestArcaneTrickster extends FunSuite with DiagrammedAssertions {
  test("Arcane Trickster provides specialization features at 4 levels") {
    assert(ArcaneTrickster.features.size == 4)
  }

  test("Arcane Trickster provides 5 specialization features") {
    assert(ArcaneTrickster.getClassFeaturesUpToClassLevel(20).length == 5)
  }

  test("Arcane Trickster provides 2 feature at 3rd level (Spellcasting and Mage Hand Legerdemain)") {
    val features = ArcaneTrickster.getClassFeaturesForClassLevel(3)
    assert(features.length == 2)
    assert(features.head.name == "Spellcasting")
    assert(features.last.name == "Mage Hand Legerdemain")
  }

  test("Arcane Trickster provides 1 feature at 9th level (Magical Ambush)") {
    val features = ArcaneTrickster.getClassFeaturesForClassLevel(9)
    assert(features.length == 1)
    assert(features.head.name == "Magical Ambush")
  }

  test("Arcane Trickster provides 1 feature at 13th level (Versatile Trickster)") {
    val features = ArcaneTrickster.getClassFeaturesForClassLevel(13)
    assert(features.length == 1)
    assert(features.head.name == "Versatile Trickster")
  }

  test("Arcane Trickster provides 1 feature at 17th level (Spell Thief)") {
    val features = ArcaneTrickster.getClassFeaturesForClassLevel(17)
    assert(features.length == 1)
    assert(features.head.name == "Spell Thief")
  }
}
