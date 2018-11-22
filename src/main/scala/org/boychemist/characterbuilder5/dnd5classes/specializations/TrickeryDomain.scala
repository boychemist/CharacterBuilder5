package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object TrickeryDomain extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 1 features
    val spells = new SpecializationFeature("Trickery Domain Spells",
      "Cleric Levels\tSpells\n" +
        "     1st\tcharm person, disguise self\n" +
        "     3rd\tmirror image, pass without trace\n'" +
        "     5th\tblink, dispel magic\n" +
        "     7th\tdimension door, polymorph\n" +
        "     9th\tdominate person, modify memory")
    val trickster = new SpecializationFeature("Blessing of the Trickster",
      "Starting when you choose this domain at 1st level, you can use your action to touch " +
    "a willing creature other than yourself to give advantage on Dexterity(Stealth) checks.  This blessing " +
    "lasts for 1 hour or until you use this feature again.")
    workingMap(1) = List(spells, trickster)

    // level 2 feature
    val channel = new SpecializationFeature("Channel Divinity: Invoke Duplicity",
      "Starting at 2nd level, you can use your Channel Divinity to create an illusory " +
    "duplicate of yourself.\nAs an action, you create a perfect illusion of yourself that lasts for 1 minute, " +
    "or until you lose your concentration (as if you were concentrating on a spell).  The illusion appears in " +
    "an unoccupied space within 30 feet of you.  As a bonus action on your turn, you can move the illusion up " +
    "to 30 feet to space you can see, but it must remain within 120 feet of you.\n" +
    "For the duration, you can cast spells as though you were in the illusion's space, but you must use your " +
    "own senses.  Additionally, when both you and your illusion are within 5 feet of a creature that can see " +
    "the illusion, you advantage on attack rolls against that creature, given how distracting the illusion " +
    "is to the target.")
    workingMap(2) = List(channel)

    // level 6 feature
    val shadows = new SpecializationFeature("Channel Divinity: Cloak of Shadows",
      "Starting at 6th level, you can use your Channel Divinity to vanish.\n" +
    "As an action, you become invisible until the end of your next turn.  You become visible if you attack " +
    "or cast a spell.")
    workingMap(6) = List(shadows)

    // level 8 feature
    val strike = new SpecializationFeature("Divine Strike",
      "At 8th level, you gain the ability to infuse your weapon strikes with poison -- a gift from your "+
      "deity.  Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to "+
        "deal an extra 1d8 poison damage to the target.  When you reach 14th level, the extra damage increases to 2d8.")
    workingMap(8) = List(strike)

    // level 17 feature
    val duplicity = new SpecializationFeature("Improved Duplicity",
      "At 17th level, you can create up to four duplicates of yourself, instead of one, when you " +
    "use Invoke Duplicity.  As a bonus action on your turn, you can move any number of them up to 30 feet, to " +
    "a maximum range of 120 feet.")
    workingMap(17) = List(duplicity)

    workingMap.toMap
  }
}
