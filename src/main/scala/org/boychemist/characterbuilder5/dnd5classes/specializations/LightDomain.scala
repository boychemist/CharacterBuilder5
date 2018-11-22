package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object LightDomain extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 1 features
    val spells = new SpecializationFeature("Light Domain Spells",
      "Cleric Levels\tSpells\n" +
        "     1st\tburning hands, faerie fire\n" +
        "     3rd\tflaming sphere, scorching ray\n'" +
        "     5th\tdaylight, fireball\n" +
        "     7th\tguardian of faith, wall of fire\n" +
        "     9th\tflame strike, scrying")
    val cantrip = new SpecializationFeature("Bonus Cantrip",
    "When you choose this domain at 1st level, you gain the 'light' cantrip if you don't already know it.")
    val flare = new SpecializationFeature("Warding Flare",
    "Also at 1st level, you can interpose divine light between yourself and an attacking enemy.  When " +
    "you are attacked by a creature within 30 feet of you that you can see, you can use your reaction to impose " +
    "disadvantage on the attack roll, causing light to flare before the attacker before it hits or misses.  An " +
    "attacker that can't be blinded is immune to this feature.\n" +
    "You can use this feature a number of times equal to your Wisdom modifier (a minimum of once).  You regain " +
    "all expended uses when you finish a long rest.")
    workingMap(1) = List(spells, cantrip, flare)

    // level 2 feature
    val radiance = new SpecializationFeature("Channel Divinity: Radiance of the Dawn",
    "Starting at 2nd level, you can use your Channel Divinity to harness sunlight, banishing " +
    "darkness and dealing radiant damage to your foes.\n" +
    "As an action, you present your holy symbol, and any magical darkness within 30 feet of you is dispelled.  " +
    "Additionally, each hostile creature within 30 feet of you must make a Constitution saving throw.  A " +
    "creature takes radiant damage equal to 2d10 + your cleric level on failed saving throws, and half as much " +
    "damage on a successful one.  A creature that has total cover from you is not affected.")
    workingMap(2) = List(radiance)

    // level 6 feature
    val improvedFlare = new SpecializationFeature("Improved Flare",
    "Starting at 6th level, you can also use your Warding Flare feature when a creature that " +
    "you can see within 30 feet of attacks a creature other than you.")
    workingMap(6) = List(improvedFlare)

    // level 8 feature
    val spellcasting = new SpecializationFeature("Potent Spellcasting",
    "Starting at 8th level, you add your Wisdom modifier to the damage you deal with any cleric cantrip.")
    workingMap(8) = List(spellcasting)

    // level 17 feature
    val corona = new SpecializationFeature("Corona of Light",
    "Starting at 17th level, you can use your action to activate an aura of sunlight that lasts for " +
    "1 minute or until you dismiss it using another action.  You emit bright light in a 60 foot radius and dim " +
    "light 30 feet beyond that.  Your enemies in bright light have disadvantage on saving throws against any " +
    "spell that deals fire or radiant damage.")
    workingMap(17) = List(corona)

    workingMap.toMap
  }

}
