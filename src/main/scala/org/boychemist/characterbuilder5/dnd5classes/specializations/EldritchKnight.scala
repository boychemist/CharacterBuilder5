package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object EldritchKnight extends Dnd5ClassSpecialization {
  override val providesSpells = true

  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {
    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 3
    val spellCasting = new SpecializationFeature("Spellcasting",
      "When you reach 3rd level, you augment your martial prowess with the ability to cast spells.")
    val bond = new SpecializationFeature("Weapon Bond",
    "At 3rd level, you learn a ritual that creates a magical bond between yourself and one " +
    "weapon.  You perform the ritual over the course of 1 hour, which can be done during a short rest.  The " +
    "weapon must be within your reach throughout the ritual, at the conclusion of which you touch the weapon " +
    "and forge the bond.\n" +
    "Once you have bonded a weapon to yourself, you can't be disarmed of that weapon unless you are " +
    "incapacitated.  If it is on the same plane of existence, you can summon that weapon as a bonus action " +
    "on your turn, causing it to teleport instantly to your hand.\n" +
    "You can have up to two bonded weapons, but can summon only one at a time with your bonus action.  If " +
    "you attempt to bond with a third weapon, you must break the bond with one of the other two.")
    workingMap(3) = List(spellCasting, bond)

    // level 7
    val magic = new SpecializationFeature("War Magic",
      "Beginning at 7th level, when you use your action to cast a cantrip, you can make one " +
    "weapon attack as a bonus action.")
    workingMap(7) = List(magic)

    // level 10
    val strike = new SpecializationFeature("Eldritch Strike",
      "At 10th level, you learn how to make your weapon strikes undercut a creature's resistence " +
    "to your spells.  When you hit a creature with a weapon attack, that creature has disadvantage on the next " +
    "saving throw it makes against a spell you cast before the end of your next turn.")
    workingMap(10) = List(strike)

    // level 15
    val charge = new SpecializationFeature("Arcane Charge",
      "At 15th level, you gain the ability to teleport up to 30 feet to an unoccupied space " +
    "you can see when you use your Action Surge.  You can teleport before or after the additional action.")
    workingMap(15) = List(charge)

    // level 18
    val improvedMagic = new SpecializationFeature("Improved War Magic",
      "Starting at 18th level, when you use your action to cast a spell, you can make on weapon " +
    "attack as a bonus action.")
    workingMap(18) = List(improvedMagic)

    workingMap.toMap
  }
}
