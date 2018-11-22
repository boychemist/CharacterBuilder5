package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object Champion extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
    new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val improvedCrit = new SpecializationFeature("Improved Critical",
    "Beginning when you choose this archetype at 3rd level, you weapon attacks score a critical " +
    "hit on a roll of 19 or 20.")
    workingMap(3) = List(improvedCrit)

    // level 7
    val athlete = new SpecializationFeature("Remarkable Athlete",
    "Starting at 7th level, you can add half you proficiency bonus (round up) to an Strength, " +
    "Dexterity, or Constitution check you make that doesn't already use your proficiency bonus.\n" +
    "In addition, when you make a running long jump, the distance you can cover increases by a number " +
    "of feet equal to your Strength modifier.")
    workingMap(7) = List(athlete)

    // level 10
    val style = new SpecializationFeature("Additional Fighting Style",
    "At 10th level, you can choose a second option from the Fighting Style class feature.")
    workingMap(10) = List(style)

    // level 15
    val superiorCrit = new SpecializationFeature("Superior Critical",
    "Starting at 15th level, your weapon attacks score a critical hit on a roll of 18-20.")
    workingMap(15) = List(superiorCrit)

    // level 18
    val survive = new SpecializationFeature("Survivor",
      "At 18th level, you attain the pinnacle of resilience in battle.  At the start of each " +
    "of your turns, you regain hit points equal to 5 + your Constitution modifier if you have no more than " +
    "half of your hit points left.  You don't gain this benefit if you have 0 hit points.")
    workingMap(18) = List(survive)

    workingMap.toMap
  }
}
