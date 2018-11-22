package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object LifeDomain extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 1 features
    val spells = new SpecializationFeature("Life Domain Spells",
      "Cleric Levels\tSpells\n" +
        "     1st\tbless, cure wounds\n" +
        "     3rd\tlesser restoration, spirtual weapon\n'" +
        "     5th\tbeacon of hope, revivify\n" +
        "     7th\tdeath ward, guardian of faith\n" +
        "     9th\tmass cure wounds, raise dead")
    val bonus = new SpecializationFeature("Bonus Proficiency",
      "When you choose this domain at 1st level, you gain proficiency with heavy armor.")
    val disciple = new SpecializationFeature("Disciple of Life",
      "Also starting at level 1, your healing spells are more effective.  Whenever you use a " +
    "spell of 1st level or higher to restore hit points to a creature, the creature regains additional hit " +
    "points equal to 2 + the spell's level.")
    workingMap(1) = List(spells, bonus, disciple)

    // level 2 feature
    val preserve = new SpecializationFeature("Channel Divinity: Preserve Life",
      "Starting at 2nd level, you can use your Channel Divinity to heal the badly injured.\n" +
        "As an action, you present your holy symbol and evoke healing energy the can restore the number of " +
    "hit points equal to five times your cleric level.  Choose any creatures within 30 feet of you, and divide " +
    "those hit points among them.  This feature can restore a creature to no more than half of its hit point " +
    "maximum.  You can't use this feature on an undead or a construct.")
    workingMap(2) = List(preserve)

    // level 6 feature
    val healer = new SpecializationFeature("Blessed Healer",
      "Beginning at 6th level, the healing spells you cast on others heal you as well.  When " +
    "you cast a spell of 1st level or higher that restores hit points to a creature other than you, you regain " +
    "hit points equal to 2 + the spell's level.")
    workingMap(6) = List(healer)

    // level 8 feature
    val divine = new SpecializationFeature("Divine Strike",
      "At 8th level, you gain the ability to infuse your weapon strikes with divine energy.  Once on " +
    "each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra " +
    "1d8 radiant damage to the target.  When you reach 14th level, the extra damage increases to 2d8.")
    workingMap(8) = List(divine)

    // level 17 feature
    val supreme = new SpecializationFeature("Supreme Healing",
      "Starting at 17th level, when you would normally roll one or more dice to restore hit points " +
    "with a spell, you instead take the highest number possible for each die.  For example, instead of restoring " +
    "2d6 hit points to a creature, you restore 12.")
    workingMap(17) = List(supreme)

    workingMap.toMap
  }
}
