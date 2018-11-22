package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object WildMagic extends Dnd5ClassSpecialization {
  val description: String = "Your innate magic comes from the forces of chaos that underlie the order of " +
  "creation.  You might have endured exposure to raw magic, perhaps through a planar portal leading to Limbo, " +
  "the Elemental Planes, or the Far Realm.  Perhaps you were blessed by a fey being or marked by a demon.  Or " +
  "your magic could be a fluke of your birth with no apparent cause.  However it came to be, this magic churns " +
  "within you, waiting for an outlet."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val surge = new SpecializationFeature("Wild Magic Surge",
      "Starting when you choose this origin at 1st level, your spell casting can unleash surges of " +
    "untamed magic.  Once per turn, the DM can have you roll a d20 immediately after you cast a sorcerer spell of " +
    "1st level or higher.  If you roll a 1, roll on the Wild Magic Surge tablle to create a magical effect.  If " +
    "that effect is a spell, it is too wild to be affected by your Metamagic, and if it normally requires " +
    "concetration, it doesn't require concentration in this case; the spell lasts for its full duration.")
    val tides = new SpecializationFeature("Tides of Chaos",
      "Starting at 1st level, you can manipulate the forces of chance and chaos to gain advantage " +
    "on one attack roll, ability check, or saving throw.  Once you do so, you must finish a long rest before " +
    "you can use this feature again.\n" +
    "Any time before you regain the use of this feature, the DM can have you roll on the Wild Magic Surge table " +
    "immediately after you cast a sorcerer spell of 1st level or higher.  You then regain the use of this feature.")
    workingMap(1) = List(surge, tides)

    // level 6
    val luck = new SpecializationFeature("Bend Luck",
      "Starting at 6th level, you have the ability to twist fate using your wild magic.  When another " +
    "creature you can see makes an attack roll, an ability check, or a saving throw, you can use your reaction and " +
    "spend 2 sorcery points to roll 1d4 and apply the number rolled as a bonus or penalty (your choice) to the " +
    "creature's roll.  You can do so after the creature rolls but before an effects of the roll occur.")
    workingMap(6) = List(luck)

    // level 14
    val chaos = new SpecializationFeature("Controlled Chaos",
      "At 14th level, you gain a modicum of control over the surges of your wild magic.  Whenever " +
    "you roll on the Wild Magic Surge table, you can roll twice and use either number.")
    workingMap(14) = List(chaos)

    // level 18
    val spell = new SpecializationFeature("Spell Bombardment",
      "Beginning at 18th level, the harmful energy of your spells intesifies.  When you roll damage " +
    "for a spell and roll the highest number possible on any of the dice, choose one of those dice, roll it again " +
    "and add that roll to the damage.  You can use this feature only once per turn.")
    workingMap(18) = List(spell)

    workingMap.toMap
  }
}
