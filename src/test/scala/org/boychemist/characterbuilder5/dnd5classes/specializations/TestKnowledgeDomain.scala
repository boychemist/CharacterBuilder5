package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.scalatest._

class TestKnowledgeDomain extends FunSuite with DiagrammedAssertions {
  test("Knowledge Domains provides specialization features at 5 levels") {
    assert(KnowledgeDomain.features.size == 5)
  }

  test("Knowledge Domains provides 6 features") {
    assert(KnowledgeDomain.getClassFeaturesUpToClassLevel(20).length == 6)
  }

  test("Knowledge Domains provides 2 feature at level 1") {
    assert(KnowledgeDomain.getClassFeaturesForClassLevel(1).length == 2)
  }

  test("Knowledge Domains provides 1 feature at level 2") {
    assert(KnowledgeDomain.getClassFeaturesForClassLevel(2).length == 1)
  }

  test("Knowledge Domains provides 1 feature at level 6") {
    assert(KnowledgeDomain.getClassFeaturesForClassLevel(6).length == 1)
  }

  test("Knowledge Domains provides 1 feature at level 8") {
    assert(KnowledgeDomain.getClassFeaturesForClassLevel(8).length == 1)
  }

  test("Knowledge Domains provides 1 feature at level 17") {
    assert(KnowledgeDomain.getClassFeaturesForClassLevel(17).length == 1)
  }
}
