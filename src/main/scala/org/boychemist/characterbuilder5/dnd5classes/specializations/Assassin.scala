package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object Assassin extends Dnd5ClassSpecialization {
  val description: String = "You focus your training on the grim art of death.  Those who adhere to this " +
  "archetype are diverse:  hired killers, spies, bounty hunters, and even specially anointed priests trained " +
  "to exterminate the enemies of their deity.  Stealth, poison, and disguise help you eliminate your foes with " +
  "deadly efficiency."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val proficiency = new SpecializationFeature("Bonus Proficiencies",
    "When you choose this archetype at 3rd level, you gain proficiency with the disguise kit and " +
    "the poisoner's kit.")
    val assassinate = new SpecializationFeature("Assassinate",
      "Starting at 3rd level, you are t your deadliest when you get the drop on your enemies.  You " +
    "have advantage on attack rolls against any creature that hasn't taken a turn in combat yet.  In addition, " +
    "any hit you score against a creature that is suprised is a critical hit.")
    workingMap(3) = List(proficiency, assassinate)

    // level 9
    val infitration = new SpecializationFeature("Infiltration Expertise",
      "Starting at 9th level, you can unfailingly create false identities for yourself.  You must " +
    "spend seven days and 25 gp to establish the history, profession, and affiliations for an identity.  You " +
    "can't establish and identity that belongs to someone else.  For example, you might acquire appropriate " +
    "clothing, letters of introduction, and official-looking certification to establish yourself as a member of " +
    "a trading house from a remote city so you can insinuate yourself into the company of other merchants.\n" +
    "Thereafter, if you adopt the new identity as a disguise, other creatures believe you to be that person " +
    "until given an obvious reason not to.")
    workingMap(9) = List(infitration)

    // level 13
    val impostor = new SpecializationFeature("Impostor",
      "At 13th level, you gain the ability to unerringly mimic another person's speach, writing, " +
    "and behavior.  You must spend at least three hours studying these three components of the person's " +
    "behavior, listening to speach, examining handwriting, and observing mannerisms.\n" +
    "Your ruse is indiscernible to a casual observer.  If a wary creature suspects something is amiss, you " +
    "have advantage on any Charisma(Deception) check you make to avoid detection.")
    workingMap(13) = List(impostor)

    // level 17
    val strike = new SpecializationFeature("Death Strike",
      "Starting at 17th level, you become a master of instant death.  When you attack and hit a " +
    "creature that is suprised, it must make a Constitution saving throw (DC 8 + your Dexterity modifier + your " +
    "proficiency bonus).  On a failed save, double the damage of your attack against the creature.")
    workingMap(17) = List(strike)

    workingMap.toMap
  }
}
