package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object WarDomain extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 1 features
    val spells = new SpecializationFeature("War Domain Spells",
      "Cleric Levels\tSpells\n" +
        "     1st\tdivine favor, shield of faith\n" +
        "     3rd\tmagic weapon, spiritual weapon\n'" +
        "     5th\tcrusader's mantle, spirit guardian\n" +
        "     7th\tfreedom of movement, stoneskin\n" +
        "     9th\tflame strike, hold monster")
    val bonus = new SpecializationFeature("Bonus Proficiencies",
      "At 1st level, you gain proficiency with martial weapons and heavy armor.")
    val priest = new SpecializationFeature("War Priest",
    "From 1st level, your god delivers bolts of inspiration to you while you are engaged in battle.  " +
    "When you use the Attack action, you can make one weapon attack as a bonus action.\n" +
    "You can use this feature a number of times equal to your Wisdom modifier (a minimum of once).  You regain " +
    "all expended uses when you finish a long rest.")
    workingMap(1) = List(spells, bonus, priest)

    // level 2 feature
    val channel = new SpecializationFeature("Channel Divinity: Guided Strike",
      "Starting at 2nd level, you can use your Channel Divinity to strike with supernatural " +
    "accuracy.  When you make an attack roll, you can use your Channel Divinity to gain a +10 bonus to the roll. " +
    "You make this choice after you see the roll, but before the DM says whether the attack hits or misses.")
    workingMap(2) = List(channel)

    // level 6 feature
    val blessing = new SpecializationFeature("Channel Divinity: War God's Blessing",
      "Starting at 6th level, when a creature within 30 feet of you makes an attack roll, you can " +
    "use your reaction to grant the creature a +10 bonus to the roll, using your Channel Divinity.  You make " +
    "this choice after you see the roll, but before the DM says whether the attack hits or misses.")
    workingMap(6) = List(blessing)

    // level 8 feature
    val strike = new SpecializationFeature("Divine Strike",
      "At 8th level, you gain the ability to infuse your weapon strikes with divine energy.  " +
    "Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal " +
    "an extra 1d9 damage of the same type delt by the weapon to the target.  When you reach 14th level, the " +
    "extra damage increases to 2d8.")
    workingMap(8) = List(strike)

    // level 17 feature
    val avatar = new SpecializationFeature("Avatar of Battle",
      "At 17th level, you gain resistance to bludgeoning, piercing, and slashing damage from " +
    "nonmagical weapons.")
    workingMap(17) = List(avatar)

    workingMap.toMap
  }
}
