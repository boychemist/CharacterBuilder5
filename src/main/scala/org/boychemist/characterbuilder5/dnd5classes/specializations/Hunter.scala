package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object Hunter extends Dnd5ClassSpecialization {
  val description: String = "Emulating the Hunter archetype means accepting your place as a bulwork between " +
  "civilization and the terrors of the wilderness.  As you walk the Hunter's path, you learn specialized " +
  "techniques for fighting the threats you face, from rampaging ogres and hordes of orcs to towering giants " +
  "and terrifying dragons."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val prey = new SpecializationFeature("Hunter's Prey",
      "At 3rd level, you gain one of the following features of your choice.\n" +
    "COLOSSUS SLAYER.  Your tenacity can wear down the most potent foes.  When you hit a creature with a weapon " +
    "attack, the creature takes an extra 1d8 damage if it's below its hit point maximum.  You can deal this extra " +
    "damage only once per turn.\n" +
    "GIANT KILLER.  When a Large or larger creature within 5 feet of you hits or misses you with an attack, you " +
    "can use your reaction to attack that creature immediately after its attack, provided you can see the creature.\n" +
    "HORDE BREAKER.  Once on each of your turns when you make a weapon attack, you can make another attack with the " +
    "same weapon against a different creature that is within 5 feet of the original target and within range of your " +
    "weapon.")
    workingMap(3) = List(prey)

    // level 7
    val tactics = new SpecializationFeature("Defensive Tactics",
      "At 7th level, you gain one of the following features of your choice.\n" +
    "ESCAPE THE HORDE.  Opportunity attacks against you are made with disadvantage.\n" +
    "MULTIATTACK DEFENSE.  When a creature hits you with an attack, you gain +4 bonus to AC against all " +
    "subsequent attacks made by that creature for the rest of the turn.\n" +
    "STEEL WILL.  You have advantage on saving throws against being frightened.")
    workingMap(7) = List(tactics)

    // level 11
    val multiattack = new SpecializationFeature("Multiattack",
      "At 11th level, you gain one of the following features of your choice.\n" +
    "VOLLEY.  Your can use your action to make a ranged attack against any number of creatures within 10 feet " +
    "of a point you can see within your weapon's range.  You must have ammunition for each target, as normal, and " +
    "you make a separate attack roll for each target.\n" +
    "WHIRLWIND ATTACK.  You can use your action to make a melee attack against any number of creatures within 5 " +
    "feet of you, with a separate attack roll for each target.")

    workingMap(11) = List(multiattack)

    // level 15
    val superiorDefense = new SpecializationFeature("Superior Hunter's Defense",
      "At 15th level, you gain one of the following features of your choice.\n" +
    "EVASION.  When you are subjected to an effect, such as a red dragon's fiery berath of a 'lightening bolt' " +
    "spell, that allows you to make a Dexterity savin throw to take only half damage, you instead take no damage " +
    "if you succeed on the saving throw, and only half damage if you fail.\n" +
    "STAND AGAINST THE TIDE.  When a hostile creature misse you with a melee attack, you can use your reaction to " +
    "force that creature to repeat the same attack against another creature (other than itself) of your choice.\n" +
    "UNCANNY DODGE.  When an attacker that you can see hits you with an attack, you can use your reaction to halve " +
    "the attack's damage against you.")
    workingMap(15) = List(superiorDefense)

    workingMap.toMap
  }
}
