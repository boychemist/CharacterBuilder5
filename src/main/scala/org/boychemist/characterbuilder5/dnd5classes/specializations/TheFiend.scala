package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object TheFiend extends Dnd5ClassSpecialization {
  val description: String = "You have made a pact with a fiend from the lower planes of existence, a being\n" +
    "whose aims are evil, even if you strive against those aims.  Such beings desire the corruption or \n" +
    "destruction of all things, ultimately including you.  Fiends powerfull enough to forge a pact include\n" +
    "demon lords such a Demogorgon, Orcus, Fraz'Urb-luu, and Baphomet; archdevils such as Asmodeus, Dispater,\n" +
    "Mephistopheles, and Belial; pit fiends and balors that are especially mighty; and ultrolths and other\n" +
    "lords of the yugoloths.\n\n" +
    "EXPANDED SPELL LIST\n" +
    "The Fiend lets you choose from an expanded list of spells when you learn a warlock spell.  The following\n" +
    "spells are added to the list of warlock spells for you.\n\n" +
    "ARCHFEY EXPANDED SPELLS\n\n" +
    "Spell Level   Spells\n" +
    "   1st        burning hands, command\n" +
    "   2nd        blindness/deafness, scorching ray\n" +
    "   3rd        fireball, stinking cloud\n" +
    "   4th        fire shield, wall of fire\n" +
    "   5th        flame strike, hallow"

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 1
    val blessing = new SpecializationFeature("Dark One's Blessing",
      "Starting at 1st level, when you reduce a hostile creature to 0 hit points, you gain temporary hit\n" +
    "points equal to your Charisma modifier + your warlock level (minimum of 1).")
    workingMap(1) = List(blessing)

    // level 6
    val luck = new SpecializationFeature("Dark One's Own Luck",
      "Starting at 6th level, you can call on your patron to alter fate in your favor.  When you make an\n" +
    "ability check or a saving throw, you can use this feature to add a d10 to your roll.  You can do so after\n" +
    "seeing the inital roll by before any of the roll's effects occur.\n\n" +
    "Once you use this feature, you can't use it again until you finish a short or long rest.")
    workingMap(6) = List(luck)

    // level 10
    val resilience = new SpecializationFeature("Fiendish REsilience",
      "Starting at 10th level, you can choose on damage type when you finish a short or long rest.  You\n" +
        "gain resistance to that damage type until you choose a different on with this feature.  Damage from\n" +
        "magic or silver weapons ignores this resistence.")
    workingMap(10) = List(resilience)

    // level 14
    val hurl = new SpecializationFeature("Hurl Through Hell",
      "Starting at 14th level, when you hit a creature with an attack, you can use this feature to\n" +
    "instantly transport the target through the lower planes.  The creature disappears and hurtles through a\n" +
    "nightmare landscape.\n\n" +
    "At the end of your next turn, the target returns to the space it previously occupied, or the nearest\n" +
    "unoccupied space.  If the target is not a fiend, it takes 10d10 psychic damage as it reels from its\n" +
    "horrific experience.\n\n" +
    "Once you use this feature, you can't use it again until you finish a long rest.")
    workingMap(14) = List(hurl)

    workingMap.toMap
  }
}
