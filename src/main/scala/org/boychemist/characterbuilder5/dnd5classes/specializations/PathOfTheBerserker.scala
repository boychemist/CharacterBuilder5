package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.HashMap

/**
  * Specialization for the Berserker class in Dungeons and Dragons 5th Edition
  */
object PathOfTheBerserker extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: HashMap[Int, List[SpecializationFeature]] = new HashMap[Int, List[SpecializationFeature]]()

    // level 3 feature
    val frenzy = new SpecializationFeature("Frenzy",
    "Starting when you choose this path at 3rd level, you can go into a frenzy when you rage.  " +
    "If you do so, for the duration of your rage you can make a single melee weapon attack as a bonus action " +
    "action on each of your turns after this one.  When your rage ends, you suffer on level of exhaustion.")
    workingMap(3) = List(frenzy)

    // level 6 feature
    val rage = new SpecializationFeature("Mindless Rage",
    "Beginning at 6th level, you can't be charmed or frightened while raging.  If you are charmed " +
    "or frightened when you enter your rage, the effect is suspended for the duration of the rage.")
    workingMap(6) = List(rage)

    // level 10 feature
    val intimidate = new SpecializationFeature("Intimidating Presence",
    "Beginning at 10th level, you can use your action to frighten someone with your " +
    "menacing presence.  When you do so, choose one creature that you can see within 30 feet of " +
    "you.  If the creature can see or hear you, it must succeed on a Wisdom saving throw (DC equal " +
    "8 + yourproficiency bonus + your Charisma modifier) or be frightened of you until the end of your " +
    "next turn.  On subsequent turns, you can use your action to extend the duration of this effect on " +
    "the frightened creature until the end of your next turn.  This effect ends if the creature ends its " +
    "turn out of line of sight or more than 60 feet from you.\n\n" +
    "If the creature succeeds on its saving throw, you can't use this feature on that creature again for " +
    "24 hours.")
    workingMap(10) = List(intimidate)

    // level 14 feature
    val retaliation = new SpecializationFeature("Retaliation",
    "Starting at 14th level, when you take damage from a creature within 5 feet of you, you " +
    "can use your reaction to make a melee weapon attack against that creature.")
    workingMap(14)  = List(retaliation)

    workingMap.toMap
  }
}
