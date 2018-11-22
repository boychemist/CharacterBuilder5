package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object WayOfShadow extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // Level 3
    val arts = new SpecializationFeature("Shadow Arts",
      "Starting when you choose this tradition at 3rd level, you can use your ki to duplicate " +
    "the effects of certain spells.  As an action, you can spend 2 ki points to cast 'darkness', 'darkvision, " +
    "'pass without trace', or 'silence', without providing material components.  Additionally, you gain the " +
    "'minor illusion' cantrip if you don't already know it.")
    workingMap(3) = List(arts)

    // Level 6
    val step = new SpecializationFeature("Shadow Step",
      "At 6th level, you gain the ability to step from one shadow into another.  When you are in " +
    "dim light or darkness, as a bonus action you can teleport up to 60 feet to an unoccupied space you can " +
    "see that is also in dim light or darkness.  You then have advantage on the first melee attack you make before " +
    "the end of the turn.")
    workingMap(6) = List(step)

    // level 11
    val cloak = new SpecializationFeature("Cloak of Shadows",
      "By 11th level, you have learned to become one with the shadows.  When you are in an area " +
    "of dim light or darkness, you can use you action to become invisible.  You remain invisible until you " +
    "make an attack, cast a spell, or are in an area of bright light.")
    workingMap(11) = List(cloak)

    val opportunist = new SpecializationFeature("Opportunist",
      "At 17th level, you can exploit a creature's momentary distraction when it is hit by an " +
    "attack.  Whenever a creature within 5 feet of you is hit by an attack make by a creature other than you, " +
    "you can use your reaction to make a melee attack against that creature.")
    workingMap(17) = List(opportunist)

    workingMap.toMap
  }
}
