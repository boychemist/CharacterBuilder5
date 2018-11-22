package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.HashMap

/**
  * Specialization for the Bard class in Dungeons and Dragons 5th Edition
  */
object CollegeOfValor extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: HashMap[Int, List[SpecializationFeature]] = new HashMap[Int, List[SpecializationFeature]]()

    // level 3 features
    val bonus = new SpecializationFeature("Bonus Proficiencies",
    "When you join the College of Valor at 3rd level, you gain proficiency with medium armor, " +
    "shields, and martial weapons")
    val combat = new SpecializationFeature("Combat Inspiration",
    "Also at 3rd level, you learn to inspire others in battle.  A creature that has a Bardic " +
    "Inspiration die from you can roll that die and add that number to a weapon roll it just made.  " +
    "Alternatively, when an attack roll is made against the creature, it can use its reaction to roll the " +
    "Bardic Inspiration die and add the number rolled to its AC against the attack, after seeing the attack " +
    "but before knowing whether it hits or misses.")
    workingMap(3) = List(bonus, combat)

    // level 6 feature
    val attack = new SpecializationFeature("Extra Attack",
    "Starting at 6th level, you can attack twice, instead of once, whenever you take " +
    "the Attack action on your turn.")
    workingMap(6) = List(attack)

    // level 14 feature
    val magic = new SpecializationFeature("Battle Magic",
    "At 14th level, you have mastered the art of weaving spellcasting and weapon use into a " +
    "single harmonious act.  When you use your action to cast a bard spell, you can make one weapon attack " +
    "as a bonus action.")

    workingMap(14) = List(magic)

    workingMap.toMap
  }
}
