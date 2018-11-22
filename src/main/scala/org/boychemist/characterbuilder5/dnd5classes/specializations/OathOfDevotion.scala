package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object OathOfDevotion extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // Level 3
    val spells = new SpecializationFeature("Oath of Devotion Spells",
      ("You gain oath spells at the paladin levels listed.\n" +
    "Paladin Levels    Spells\n" +
    "     3rd          protection from evil and good, sanctuary\n" +
    "     5th          lesser restoration, zone of truth\n" +
    "     9th          beacon of hope, dispel magic\n" +
    "    13th          freedom of movement, guardian of faith\n" +
    "    17th          commune, flame strike"))
    val channel = new SpecializationFeature("Channel Divinity",
    "When you take this oath at 3rd level, you gain the following two Channel Divinity options.\n" +
    "SACRED WEAPONS.  As and action, you can imbue one weapon that you are holding with positive energy, " +
    "using your Channel Divinity.  For 1 minute, you add you Charisma modifier to attack rolls made with that " +
    "weapon (with a minimum bonus of +1).  The weapon also emits bright light in a 20-foot radius and a dim light " +
    "20 feet beyond that.  If the weapon is not already magical, it becomes magical for the duration.\n" +
    "You can end this effect on your turn as part of any other action.  If you are no longer holding or carrying " +
    "the weapon, or if you fall unconsious, this effect ends.\n" +
    "TURN THE UNHOLY.  As an action, you present your holy symbol and speak a prayer censuring fiends and " +
    "undead, using your Channel Divinity.  Each fiend or undead that can see or hear you within 30 feet of you " +
    "must make a Wisdom saving throw.  If the creature fails its saving throw, it is turned for 1 minute or until " +
    "it takes damage.\n" +
      "A turned creature must spend its turns trying to move as far away from you as it can, and it can't " +
    "willingly move to a space within 30 feet of you.  It also can't take reactions.  For its action, it can use " +
    "only the Dash action or try to escape from an effect that prevents it from moving.  If there's nowhere to " +
    "move, the creature can use the Dodge action.")
    workingMap(3) = List(spells, channel)

    // Level 7
    val devotion = new SpecializationFeature("Aura of Devotion",
      "Starting at 7th level, you and friendly creatures within 10 feet of you can't be charmed " +
    "while you are conscious.\nAt 18th level, the range of the aura increases to 30 feet.")
    workingMap(7) = List(devotion)

    // level 15
    val purity = new SpecializationFeature("Purity of Spirit",
      "Beginning at 15th level, you are always under the effects of a 'protections from evil and " +
    "good' spell.")
    workingMap(15) = List(purity)

    val nimbus = new SpecializationFeature("Holy Nimbus",
      "At 20th level, as an action, you can eminate an aura of sunlight.  For 1 minute, bright light " +
    "shines from you in a 30-foot radius, and dim light shines 30 feet beyond that.\n" +
    "Whenever an enemy creature starts its turn in the bright light, the creature takes 10 radiant damage.\n" +
    "In addition, for the duration, you have advantage on saving throws cast by fiends or undead.\n" +
    "Once you use this feature, you can't use it again until you finish a long rest.")
    workingMap(20) = List(nimbus)

    workingMap.toMap
  }
}
