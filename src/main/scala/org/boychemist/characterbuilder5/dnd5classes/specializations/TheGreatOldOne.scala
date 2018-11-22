package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object TheGreatOldOne extends Dnd5ClassSpecialization {
  val description: String = "Your patron is a mysterious entity whose nature is utterly foreign to the fabric of\n" +
    "reality.  It might come from the Far Realm, the space beyond reality, or it could be one of the elder gods\n" +
    "known only in legends.  Its motives are incomprehensible to mortals, and its knowledge so immense and \n" +
    "ancient that even the greatest libraries pale in comparison to the vast secrets it holds.  The Great Old\n" +
    "One might be unaware of your existence or entirely indifferent to you, but the secrets you have learned\n" +
    "allow you to draw magic from it.\n\n"+
    "Entities of this type include Ghaunadar, called That Which Lurks; Tharizdun, the Chained God; Dendar, the\n" +
    "the Night Serpent; Zargon, the Returner; Great Cthulhu; and other unfathomable beings.\n\n" +
    "EXPANDED SPELL LIST\n" +
    "The Great Old One lets you choose from an expanded list of spells when you learn a warlock spell.  The following\n" +
    "spells are added to the list of warlock spells for you.\n\n" +
    "ARCHFEY EXPANDED SPELLS\n\n" +
    "Spell Level   Spells\n" +
    "   1st        dissonant whispers, Tasha's hideous laughter\n" +
    "   2nd        detect thoughts, phantasmal force\n" +
    "   3rd        clairvoyance, sending\n" +
    "   4th        dominate beast, Evard's black tentacles\n" +
    "   5th        dominate person, telekenesis"

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 1
    val presence = new SpecializationFeature("Fey Presence",
      "Starting at 1st level, you patron bestows upon you the ability to project the beguiling and\n" +
        "fearsome presence of the fey.  As an action, you can cause each creature in a 10-foot cube originating\n" +
        "from you to make a Wisdom saving throw against you warlock spell save DC.  The creatures that fail their\n" +
        "saving throws are all charmed or frightened by you (your choice) until the end of your next turn.\n\n" +
        "Once you use this feature, you can't use it again until you finish a short or long rest.")
    workingMap(1) = List(presence)

    // level 6
    val misty = new SpecializationFeature("Misty Escape",
      "Starting at 6th level, you can vanish in a puff of mist in respnse to harm.  When you take\n" +
        "damage, you can use your reaction to turn invisible and teleport up to 60 feet to an unoccupied space you\n" +
        "can see.  You remain invisible until the start of your next turn or until you attack or cast a spell.\n\n" +
        "Once you use this feature, you can't use it again until you finisht a short or long rest.")
    workingMap(6) = List(misty)

    // level 10
    val defenses = new SpecializationFeature("Beguiling Defenses",
      "Beginning at 10th level, you patron teaches you how to turn the mind-affecting magic of your\n" +
        "enemies against them.  You are immune to being charmed, and when another creature attempts to charm you,\n" +
        "you can use your reaction to attempt to turn the charm back on that creature.  The creature must succeed\n" +
        "on a Wisdom saving throw against your warlock spell save DC or be charmed by your for 1 minute or until\n" +
        "the creature takes any damage.")
    workingMap(10) = List(defenses)

    // level 14
    val delirium = new SpecializationFeature("Dark Delirium",
      "Starting at 14th level, you can plunge a creature into an illusory realm.  As an action, choose a\n" +
        "creature that you can see withing 60 feet of you.  It must make a Wisdom saving throw against your warlock\n" +
        "spell save DC.  On a failed save, it is charmed or frightened you you (your choice) for 1 minute or until\n" +
        "your concentration is broken (as if you are concentrating on a spell).  This effect ends early if the\n" +
        "creature takes any damage.\n\n" +
        "Until this illusion ends, the creature thinks it is lost in a misty realm, the appearance of which you\n" +
        "choose.  The creature can see and hear only itself, you, and the illusion.\n\n" +
        "You must finish a short or long rest before you can use this feature again.")
    workingMap(14) = List(delirium)

    workingMap.toMap
  }
}
