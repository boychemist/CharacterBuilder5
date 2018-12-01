package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object OathOfVengeance extends Dnd5ClassSpecialization {
  val description: String = "The Oath of Vengeance is a solemn commitment to punish those who have committed a " +
    "grievous sin.  When evil forces slaughter helpless villagers, when an entire people turns against the will " +
  "of the gods, when a thieves' guild grows too violent and powerful, when a dragon rampages through the " +
  "countryside -- at times like these, paladins arise and swear an Oath of Vengeance to set right that which has " +
  "gone wrong.  To these palacins -- sometimes called avengers or dark knights -- their own purity is not as " +
  "important as delivering justice.\n\n" +
  "TENENTS OF VENGEANCE\n" +
  "The tenets of the Oath of Vengeance vary by paladin, but all the tenents revolve around punishing wrongdoers " +
  "by any means necessary.  Paladins who uphold these tenents are willing to sacrifice even their own righteousness " +
  "to mete out justice upon those who do evil, so the paladins are often neutral or lawful neutral in alignment.  " +
  "The core principles of the tenents are brutally simple.\n" +
  "FIGHT THE GREATER EVIL.  Faced with a choice of fighting my sworn foes or combating a lesser evil, I choose " +
  "the greater evil.\n" +
  "NO MERCY FOR THE WICKED.  Ordinary foes might win my mercy, but my sworn enemies do not.\n" +
  "BY ANY MEANS NECSSSARY.  My qualms can't get in the way of exterminating my foes.\n" +
  "RESTITUTION.  If my foes wreak ruin on the world, it is because I failed to stop them.  I must help those " +
  "harmed by their misdeeds."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // Level 3
    val spells = new SpecializationFeature("Oath of Vengeance Spells",
      "You gain oath spells at the paladin levels listed.\n" +
        "Paladin Levels    Spells\n" +
        "     3rd          bane, hunter's mark\n" +
        "     5th          hold person, misty step\n" +
        "     9th          haste, protection from energy\n" +
        "    13th          banishment, dimension door\n" +
        "    17th          hold monster, scrying")
    val channel = new SpecializationFeature("Channel Divinity",
      "When you take this oath at 3rd level, you gain the following two Channel Divinity options.\n" +
        "ABJURE ENEMY.  As an action, you present your holy symbol and speak a prayer of denunciation, using your " +
    "Channel Divinity.  Choose one creature within 60 of you that you can see.  That creature must make a Wisdom " +
    "saving throw, unless it is immune to being frightened.  Fiends and undead have disadvantage on the saving " +
    "throw.\n" +
    "On a failed save, the creature is frightened for 1 minute or until it takes any damage.  Whild frightened the " +
    "creature's speed is 0, and it can't benefit from any bonus to its speed.\n" +
    "On a successful save, the creature's speed is halved for 1 minute or until the creature takes any damage.\n" +
    "VOW OF ENMITY.  As a bonus action, you can utter a vow of enmity against a creature you can see within 10 " +
    "feet of you, using your Channel Divinity.  You gain advantage on attack rolls against the creature for 1 " +
    "minute or until it drops to 0 hit points or falls unconscious.")
    workingMap(3) = List(spells, channel)

    // Level 7
    val avenger = new SpecializationFeature("Relentless Avenger",
      "By 7th leve, you supernatural focus helps you closeof a foe's retreat.  When you hit a creature " +
    "with an opportunity attack, you can move up to half you speed immediately after the attack and as part of the " +
    "same reaction.  This movement doesn't provoke opportunity attacks.")
    workingMap(7) = List(avenger)

    // level 15
    val soul = new SpecializationFeature("Soul of Vengeance",
      "Starting at 15th level, the authority whie which you speak you Vow of Enmity gives you greater " +
    "power over your foe.  When a creature under the effect of your Vow of Enmity makes an attack you can use your " +
    "reaction to make a melee weapon attack against that creature if it is within range.")
    workingMap(15) = List(soul)

    val angel = new SpecializationFeature("Avenging Angel",
      "At 20th level, you can assume the form of an angelic aventer.  Using your action, you undergo " +
        "a transformation.  For 1 hour, you gain the following benefits:\n\n" +
        "* Wings sprout from your back and grant you flying speed of 60 feet.\n" +
        "* You emanate an aura of menance in a 30-foot radius.  The first time\n" +
        "  an enemy creature enters the aura of starts its turn there during a battle,\n" +
        "  the creature must succeed on a Wisdom saving throw or become frightened of you\n" +
        "  for 1 minute or until it takes any damage.  Attack rolls against the frightened\n" +
        "  creature have advantage.\n\n" +
        "Once you use this feature, you can't use it again until you finish a long rest.")
    workingMap(20) = List(angel)

    workingMap.toMap
  }
}
