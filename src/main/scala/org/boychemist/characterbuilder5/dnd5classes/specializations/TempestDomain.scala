package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object TempestDomain extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 1 features
    val spells = new SpecializationFeature("Tempest Domain Spells",
      "Cleric Levels\tSpells\n" +
        "     1st\tfog cloud, thunderwave\n" +
        "     3rd\tgust of wind, shatter\n'" +
        "     5th\tcall lightening, sleet storm\n" +
        "     7th\tcontrol water, ice storm\n" +
        "     9th\tdestructive wave, insect plague")
    val bonus = new SpecializationFeature("Bonus Proficiencies",
      "At 1st level, you gain proficiency with martial weapons and heavy armor.")
    val wrath = new SpecializationFeature("Wrath of the Storm",
      "Also at 1st level, you can thunderously rebuke attackers.  When a creature within 5 feet " +
    "of you that you can see hits you with an attack, you can use your reaction to cause the creature to make " +
    "a Dexterity saving throw.  The creature takes 2d8 lightening or thunder damage (your choice) on a failed " +
    "saving throw, and half as much damage on a successful one.")
    workingMap(1) = List(spells, bonus, wrath)

    // level 2 feature
    val channel = new SpecializationFeature("Channel Divinity: Destructive Wrath",
      "Starting at 2nd level, you can use your Channel Divinity to wield the power of the storm " +
    "with unchecked ferocity.\nWhen you roll lightening or thunder damage, you can use your Channel Divinity " +
    "to deal maximum damage, instead of rolling.")
    workingMap(2) = List(channel)

    // level 6 feature
    val thunderbolt = new SpecializationFeature("Thunderbolt Strike",
      "At 6th level, when you deal lightening damage to a Large or smaller creature, you can also " +
    "push it up to 10 feet away from you.")
    workingMap(6) = List(thunderbolt)

    // level 8 feature
    val strike = new SpecializationFeature("Divine Strike",
      "At 8th level, you gain the ability to infuse your weapon strikes with divine energy.  Once on " +
        "each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra " +
        "1d8 thunder damage to the target.  When you reach 14th level, the extra damage increases to 2d8.")
    workingMap(8) = List(strike)

    // level 17 feature
    val stormborn = new SpecializationFeature("Stormborn",
      "At 17th level, you have a flying speed equal to your current walking speed whenever you are " +
        "not underground or indors.")
    workingMap(17) = List(stormborn)

    workingMap.toMap
  }
}
