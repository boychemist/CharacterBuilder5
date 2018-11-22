package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object DraconicBloodline extends Dnd5ClassSpecialization {
  val description: String = "Your innate magic comes from draconic magic that was mingled with your blood or " +
  "that of your ancestors.  Most often, sorcerers with this orign trace their descent back to a mighty sorcerer " +
  "of ancient times who made a bargain with a dragon or who might even have claimed a dragon parent.  Some of " +
  "these bloodlines are well established in the world, but most are obacure.  Any given sorcerer could be the " +
  "first of a new bloodline, as a result of a pact or some other exceptional circumstance."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val ancestor = new SpecializationFeature("Dragon Ancestor",
      "At 1st level, you choose one type of dragon as your ancestor.  The damage type associated " +
    "with each dragon is used by features you gain later.\n\n" +
    "DRACONIC ANCESTRY\n\n" +
    "Dragon           Damage Type\n" +
    "------           -----------\n" +
    "Black             Acid\n" +
    "Blue              Lightening\n" +
    "Brass             Fire\n" +
    "Bronze            Lightening\n" +
    "Copper            Acid\n" +
    "Gold              Fire\n" +
    "Green             Poison\n" +
    "Red               Fire\n" +
    "Silver            Cold\n" +
    "White             Cold\n\n" +
    "You can speak, read, and write Draconic.  Additionally, whenever you make a Charisma check when " +
    "interacting with dragons, your proficiency bonus is doubled if it applies to the check.")
    val resilience = new SpecializationFeature("Draconic Resilience",
      "As magic flows through your body, it causes physical traits of your dragon ancestors to " +
    "emerge.  At 1st level, your hit point maximum increases by 1 and increases by 1 again whenever you gain " +
    "a level in this class.\n" +
    "Additionally, parts of your skin are covered by a thin sheen of dragon-like scales.  When you aren't " +
    "wearing armor, you AC equals 13 + you Dexterity modifier.")
    workingMap(1) = List(ancestor, resilience)

    // level 6
    val affinity = new SpecializationFeature("Elemental Affinity",
      "Starting at 6th level, when you cast a spell that deals damage of the type associated with " +
    "your dreaconic ancestry, you can add your Charisma modifier to one damage roll of that spell.  At the same " +
    "time, you can spend 1 sorcery point to gain resistance to that damage type for 1 hour.")
    workingMap(6) = List(affinity)

    // level 14
    val wings = new SpecializationFeature("Dragon Wings",
      "At 14th level, you gain the ability to sprout a pair of dragon wings from your back, gaining " +
    "a flying speed equal to your current speed.  You can ceate these wings as a bonus action on your turn.  " +
    "They last until you dismiss them as a bonus action on your turn.\n" +
    "You can't manifest your wings while wearing armor unless the armor is made to accommodate them, and " +
    "clothing not made to accommodate them might be destroyed when you manifest them.")
    workingMap(14) = List(wings)

    // level 18
    val draconic = new SpecializationFeature("Draconic Presence",
      "Beginning at 18th level, you can channel the dread presence of your dragon ancestor, causing " +
    "those around you to become awstruck or frightened.  As an action, you can spend 5 sourcery points to draw " +
    "on this power and exude an aura of awe or fear (your choice) to a distance of 60 feet.  For 1 minute or until " +
    "you lose your concentration (as if you were casting a concentration spell), each hostile creature that starts " +
    "its turn in the aura must succeed on a Wisdom saving throw or be charmed (if you chose awe) or frightened " +
    "(if you chose fear) until the aura ends.  A creature that succeeds on this saving throw is immune to your " +
    "aura for 24 hours.")
    workingMap(18) = List(draconic)

    workingMap.toMap
  }
}
