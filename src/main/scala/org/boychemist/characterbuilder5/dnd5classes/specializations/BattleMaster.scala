package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object BattleMaster extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val combat = new SpecializationFeature("Combat Superiority",
      "When you choose this archetype at 3rd level, you learn maneuvers that are fueled by " +
    "special dice, called superiority dice.\n" +
    "MANEUVERS\nYou learn three maneuvers of your choice, which are detailed under 'Maneuvers' in the " +
    "Players Handbook.  Many maneuvers enhance and attack is some way.  You can use only one maneuver " +
    "per attack.\nYou learn two additional maneuvers of your choice a 7th, 10th, and 15th level.  Each time " +
    "you learn new maneuvers, you can also replace on maneuver you know with a different one.\n" +
    "SUPERIORITY DICE\nYou have four superiority dice, which are d8s.  A superiority die is expenced when " +
    "you use it.  You regain all of your expended superiority dice when you finish a short or long rest.\n" +
    "You gain another superiority die at 7th level and one more at 15th level.\n" +
    "SAVING THROWS\nSome of your maneuvers require your target to make a saving throw to resist the maneuver's " +
    "effects.  The save throw DC is calculated as follows:\n" +
    "\tManeuver Save DC = 8 + your proficiency bonus + your Strength or Dexterity modifier (your choice)")
    val student = new SpecializationFeature("Student of War",
    "At 3rd level, you gain proficiency with one type of artisan's tools of your choice.")
    workingMap(3) = List(combat, student)

    // level 7
    val enemy = new SpecializationFeature("Know Your Enemy",
      "Starting at 7th level, if you spend at least 1 minute observing or interacting with " +
    "another creature outside combat, you can learn certian information about its capabilities compared " +
    "to your own.  The DM tells you if the creature is your equal, superior, or inferior in regard to two " +
    "of the following characteristics of your choice:\n\tStrength score\n\tDexterity score\n\t" +
    "Constitution score\n\tArmor Class\n\tCurrent hit points\n\tTotal class levels (if any)\n\t" +
    "Fighter class levels (if any)")
    workingMap(7) = List(enemy)

    // level 10
    val improvedCombat = new SpecializationFeature("Improved Combat Superiority",
      "At 10th level, your superiority dice turn into d10s.  At 18th level, they turn " +
    "into d12s.")
    workingMap(10) = List(improvedCombat)

    // level 15
    val rentless = new SpecializationFeature("Relentless",
      "Starting at 15th level, when you roll initiative and have no superiority dice remaining, " +
    "you regain one superiority die.")
    workingMap(15) = List(rentless)

    workingMap.toMap
  }
}
