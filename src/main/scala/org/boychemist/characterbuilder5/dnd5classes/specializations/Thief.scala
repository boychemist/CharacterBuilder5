package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object Thief extends Dnd5ClassSpecialization {
  val description: String = "You hone your skills in the larcenous arts.  Burglars, bandits, cutpurses, and " +
    "other criminals typically follow this archetype, but so do rogues who prefer to think of themsalves as " +
    "professional treasure seekers, explorers, delvers, and investigators.  In addition to improving your agility " +
    "and stealth, you learn skills useful for delving into ancient ruins, reading unfamiliar languaages, and using " +
    "magic items you normally couldn't employ."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val hands = new SpecializationFeature("Fast Hands",
      "Starting at 3rd level, you can use the bonus action granted by your Cunning Action to make " +
        "a Dexterity(Sleight of Hand) check, use your thieves' tools to disarm a trap or open a lock, or take the " +
        "Use an Object action.")
    val secondStory = new SpecializationFeature("Second-Story Work",
      "When you choose this archetype at 3rd level, you gain the ability to climb faster than normal; " +
        "climbing no longer costs you extra movement.\n" +
        "In addition, when you make a running jump, the distance you cover increases by a number of feet equal to " +
        "your Dexterity modifier.")
    workingMap(3) = List(hands, secondStory)

    // level 9
    val sneak = new SpecializationFeature("Supreme Sneak",
      "Starting at 9th level, you have advantage on Dexterity(Stealth) check if you move no more " +
        "than half your speed on the same turn.")
    workingMap(9) = List(sneak)

    // level 13
    val device = new SpecializationFeature("Use Magic Device",
      "By 13th level, you have learned enough about the workings of magic that you can improvise the " +
        "use of items even when they are not intended for you.  You ignore all class, race, and level requirements " +
        "on the use of magic items.")
    workingMap(13) = List(device)

    // level 17
    val reflexes = new SpecializationFeature("Thief's Reflexes",
      "When you reach 17th level, you have become adept at laying ambushes and quickly escaping " +
        "danger.  You can take two turns during the first round of any combat.  You take your first turn at your " +
        "normal initiative and your second turn at your initiative minus 10.  You can't use this feature when you " +
        "are suprised.")
    workingMap(17) = List(reflexes)

    workingMap.toMap
  }
}
