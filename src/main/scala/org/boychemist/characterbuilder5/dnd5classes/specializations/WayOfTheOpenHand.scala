package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object WayOfTheOpenHand extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // Level 3
    val openHand = new SpecializationFeature("Open Hand Technique",
    "Starting when you choose this tradition at 3rd level, you can manipulate your enemy's " +
    "ki when you harness your own.  Whenever you hit a creature with one of the attacks granted by " +
    "your Furry of Blows, you can impose one of the following effects on that target\n\n" +
    "\to   It must succeed on a Dexterity saving throw or be knocked prone.\n" +
    "\to   It must make a Strength saving throw.  If it fails, you can push it up to 15 feet away from you.\n" +
    "\to   It can't take reactions until the end of your next turn.")
    workingMap(3) = List(openHand)

    // Level 6
    val body = new SpecializationFeature("Wholeness of Body",
    "At 6th level, you gain the ability to heal yourself.  As an action, you can regain hit " +
    "points equal to three times your monk level.  You must finish a long rest before you can use this " +
    "feature again.")
    workingMap(6) = List(body)

    // level 11
    val tranquility = new SpecializationFeature("Tranquility",
    "Beginning at 11th level, you can enter a special meditation that surrounds you with an aura " +
    "of peace.  At the end of a long rest, you gain the effect of a 'sanctuary' spell that lasts until the " +
    "start of your next long rest (the spell can end early as normal).  The saving throw DC for the spell " +
    "equals 8 + your Wisdom modifier + your proficiency bonus.")
    workingMap(11) = List(tranquility)

    val palm = new SpecializationFeature("Quivering Palm",
    "At 17th level, you gain the ability to set up lethal vibrations in someone's body.  When " +
    "you hit a creature with an unarmed strike, you can spend 3 ki points to start these imperceptible " +
    "vibrations, which last for a number of days equal to your monk level.  The vibrations are harmless " +
    "unless you use your action to end them.  To do so, you and the target must be in the same plane of " +
    "existence.  When you use this action, the creature must make a Constitution saving throw.  If it fails, " +
    "it is reduced to 0 hit points.  If it succeeds, it takes 10d10 necrotic damage.\n" +
    "You can have only one creature under the effect of this feature at a time.  You can choose to end the " +
    "vibrations harmlessly without using an action.")
    workingMap(17) = List(palm)

    workingMap.toMap
  }

}
