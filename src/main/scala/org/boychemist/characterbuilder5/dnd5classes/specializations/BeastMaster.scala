package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object BeastMaster extends Dnd5ClassSpecialization {
  val description: String = "The Beast Master archetype embodies a friendshiop between the civilized races and the " +
  "beasts of the wild.  United in focus, beast and ranger fight the monsters that threaten civilization and the " +
  "wilderness alike."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val companion = new SpecializationFeature("Ranger's Companion",
      "At 3rd level, you gain a beast companion that accompanies you on your adventures and is trained " +
    "to fight alongside you.  Choose a beast that is no larger than Medium and tha has a challenge rating of 1/4 or " +
    "lower (appendix D of the Players Handbook presents statistics for the hawk, mastiff, and panther as examples).  " +
    "Add your prficiency bonus to the beast's AC, attack rolls, and damage rolls, as well as to any saving throws " +
    "and skills it is proficient in.  Its hit point maximum equals the hit point number in its stat block or four " +
    "times your range level, whichever is higher.  Like any creature, it can spend Hit Dice during a short rest to " +
    "regain hit points.\n" +
    "The beast obeys you commands as best as it can.  It takes its turn on your initiative, though it doesn't take " +
    "an action unless you command it to.  On you turn, you can verball command the beast where to move (no action " +
    "required by you).  Your can use your action to verbally command it to take the Attack, Dash, Disengage, Dodge, " +
    "or Help action.")
    workingMap(3) = List(companion)

    // level 7
    val training = new SpecializationFeature("Exceptional Training",
      "Beginning at 7th level, on any of your turns when you beast companion doesn't attack, you can " +
    "use a bonus action to command the beast to take the Dash, Disengage, Dodge, or Help actions on its turn.")
    workingMap(7) = List(training)

    // level 11
    val fury = new SpecializationFeature("Bestial Fury",
      "Starting at 11th level, when you command your beast companion to take the Attack action, the " +
    "beast can make two attacks, or it can take the Multiattack action if it has that action.")

    workingMap(11) = List(fury)

    // level 15
    val share = new SpecializationFeature("Share Spells",
      "Beginning at 15th level, when you cast a spell targeting youself, you can also affect your " +
    "beast companion with the spell if the beast is within 30 feet of you.")
    workingMap(15) = List(share)

    workingMap.toMap
  }
}
