package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object OathOfTheAncients extends Dnd5ClassSpecialization {
  val description: String = "The Oath of the Ancients is as old as the race of elves and the rituals of the " +
  "druids.  Sometimes called fey knights, green knights, or horned knights, paladins who swear this oath cast " +
  "their lot with the side of the light in the cosmic struggle against darkness because they love the beautiful " +
  "and life-giving things of the world, not necessarily because the believe in principles of honor, courage, and " +
  "justice.  They adorn their armor and clothing with images of growing things -- leaves, antlers, or flowers -- " +
  "to reflect their commitment to preserving life and light in the world.\n\n" +
  "TENETS of the ANCIENTS\n" +
  "The tenents of the Oath of the Ancients have been preserved for uncounted centuries.  This oath emphasizes the " +
  "principles of good above any concerns of law or chaos.  Its four central princliples are simple.\n" +
  "KINDLE THE LIGHT.  Through your acts of mercy, kindness, and forgiveness, kindle the light of hope in the world, " +
  "beating back dispair.\n" +
  "SHELTER THE LIGHT.  Where there is good, beauty, love, and laughter in the world, stand against the wickedness " +
  "that would swallow it.  Where life flourishes, stand against the forces that would render it barren.\n" +
  "PRESERVE YOUR OWN LIGHT.  Delight in song and laughter, in beauty and art.  If you allow the light to die in " +
  "your own heart, you can't preserve it in the world.\n" +
  "BE THE LIGHT.  Be a glorious beacon for all who live in despair.  Let the light of your joy and courage shine " +
  "forth in all your deeds."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // Level 3
    val spells = new SpecializationFeature("Oath of the Ancients Spells",
      "You gain oath spells at the paladin levels listed.\n" +
        "Paladin Levels    Spells\n" +
        "     3rd          ensnaring strike, speak with animals\n" +
        "     5th          misty step, moonbeam\n" +
        "     9th          plant growth, protection from energy\n" +
        "    13th          ice storm, stoneskin\n" +
        "    17th          commune with nature, tree stride")
    val channel = new SpecializationFeature("Channel Divinity",
      "When you take this oath at 3rd level, you gain the following two Channel Divinity options.\n" +
        "NATURE'S WRATH.  You can use your Channel Divinity to invoke primeval forces to ensnare a foe.  As an " +
    "action, you can cause spectral vines to spring up and reach for a creature within 10 feet of you that you " +
    "can see.  The creature must succeed on a Strength or Dexterity saving throw (its choice) or be restrained.  " +
    "While restrained by the vines, the creature repeats the saving throw at the end of each of its turns.  " +
    "On a success, it frees itself and the vines vanish.\n" +
    "TURN THE FAITHLESS.  You can use your Channel Divinity to utter ancient words that are painful for fey and " +
    "fiends to hear.  As an action, you present your holy symbol, and each fey or fiend within 30 feet of you that " +
    "can hear you makes a Wisdom saving throw.  On a failed save, the creature is turned for 1 minute or until " +
    "it takes damage.\n" +
    "A turned creature must spend its turns trying to move as far away from you as it can, and it can't willingly " +
    "move to a space within 30 feet of you.  It also can't take reactions.  For its action, it can only use the " +
    "Dash action or try to escape from an effect tha prevents it from moving.  If there's nowhere to move, the " +
    "creature can use the Dodge action.\n" +
    "If the creature's true form is concealed by an illusion, shapeshifting, or other effect, that form is revealed " +
    "while it is turned.")
    workingMap(3) = List(spells, channel)

    // Level 7
    val warding = new SpecializationFeature("Aura of Warding",
      "Beginning at 7th level, ancient magic lies so heavily upon you that it forms an eldritch ward.  " +
    "You and friendly creatures within 10 feet of you have resistance to damage from spells.\n" +
    "At 18th level, the range of the aura increases to 30 feet.")
    workingMap(7) = List(warding)

    // level 15
    val undying = new SpecializationFeature("Undying Sentinel",
      "Starting at 15th level, when you are reduced to 0 hit points and are not killed outright, you " +
    "can choose to drop to 1 hit point instead.  Once you use this ability, you can't use it again until you " +
    "finish a long rest.\n" +
    "Additionally, you suffer none of the drawbacks of old age, and you can't be aged magically.")
    workingMap(15) = List(undying)

    val elder = new SpecializationFeature("Elder Champion",
      "At 20th level, you can assume the form of an ancient force of nature, taking on an appearance " +
        "you choose.  For example, your skin might turn green or take on a bark-like texture, you hair might become " +
        "leafy or moss-like, or you might sprout antlers or a lion-like mane.\n" +
        "Using your action, you gain the following benefits:\n" +
        "*  At the start of each of your turns, you regain 10 hit points.\n" +
        "*  Whenever you case a paladin spell that has a casting time of 1 action,\n" +
        "   you can cast is using a bonus action instead.\n" +
        "*  Enemy creatures within 10 feet of you have disadvantage on saving throws\n" +
        "   against your paladin spells and Channel Divinity options.\n\n" +
        "Once you use this feature, you can't use it again until you finish a long rest.")
    workingMap(20) = List(elder)

    workingMap.toMap
  }
}
