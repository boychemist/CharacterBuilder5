package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestPathOfTheBerserker extends FunSuite with DiagrammedAssertions {
  test("Path of the Berserker provides 4 specialization features") {
    assert(PathOfTheBerserker.features.size == 4)
  }

  test("Path of the Berserker provides no features for levels 1 and 2") {
    assert(PathOfTheBerserker.getClassFeaturesUpToClassLevel(2).isEmpty)
  }

  test("Path of the Berserker provides 1 feature at level 3 (Frenzy)") {
    val featureList: List[SpecializationFeature] = PathOfTheBerserker.getClassFeaturesForClassLevel(3)
    assert(featureList.length == 1)
    val feature = featureList.head
    assert(feature.name == "Frenzy")
  }

  test("Path of the Berserker provides two features at level 6 (in the order Frenzy, Mindless Rage") {
    val featureList = PathOfTheBerserker.getClassFeaturesUpToClassLevel(6)
    assert(featureList.length == 2)
    val frenzy = featureList.head
    val rage = featureList.tail.head
    assert(frenzy.name == "Frenzy")
    assert(rage.name == "Mindless Rage")
  }

  test("Path of the Berserker provides 2 features through level 9") {
    assert(PathOfTheBerserker.getClassFeaturesUpToClassLevel(9).length == 2)
  }

  test("Path of the Berserker provides 3 features through level 13 (in the order Frenzy, Mindless Rage, " +
  "Intimidating Presence)") {
    val featureList = PathOfTheBerserker.getClassFeaturesUpToClassLevel(13)
    assert(featureList.length == 3)
    val frenzy = featureList.head
    val rage = featureList.tail.head
    val intimidate = featureList.last
    assert(frenzy.name == "Frenzy")
    assert(rage.name == "Mindless Rage")
    assert(intimidate.name == "Intimidating Presence")
  }

  test("Path of the Berserker provides Retaliation at level 14") {
    val featureList = PathOfTheBerserker.getClassFeaturesForClassLevel(14)
    assert(featureList.length == 1)
    val retaliation = featureList.head
    assert(retaliation.name == "Retaliation")
  }
}
