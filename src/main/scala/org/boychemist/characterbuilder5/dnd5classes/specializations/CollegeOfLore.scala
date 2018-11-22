package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.HashMap

/**
  * Specialization for the Bard class in Dungeons and Dragons 5th Edition
  */
object CollegeOfLore extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: HashMap[Int, List[SpecializationFeature]] = new HashMap[Int, List[SpecializationFeature]]()

    // level 3 features
    val proficiencies = new SpecializationFeature("Bonus Proficiencies",
    "When your join the College of Lore at 3rd level, you gain proficiency with three " +
    "skills of your choice")
    val words = new SpecializationFeature("Cutting Words",
    "Also at 3rd level, you learn how to use your wit to distract, confuse, and otherwise " +
    "sap the confidence and competence of others.  When a creature that you can see within 60 feet of " +
    "you makes an attack roll, an ability check, or a damage roll, you can use your reaction to expend " +
    "one of your uses of Bardic Inspiration, rolling a Bardic Inspiration die and subtracting the number " +
    "rolled from the creature's roll.  You can choose to use this feature after the creature makes its " +
    "roll, but before the DM determines whether the attack roll or ability check succeeds or fails, or before " +
    "the creature deals its damage.  The creature is immune it if can't hear you or if it is immune to being " +
    "charmed.")

    workingMap(3) = List(proficiencies, words)

    // level 6 feature
    val magical = new SpecializationFeature("Additional Magical Secrets",
    "At 6th level, you can learn two spells of your choice from any class.  A spelll you choose " +
    "must be of a level you can cast, as shown in the Bard table, or a cantrip.  The chosen spells count as " +
    "bard spells for you but don't count against the number of bard spells you know.")

    workingMap(6) = List(magical)

    // level 14 feature
    val peerless = new SpecializationFeature("Peerless Skill",
    "Starting at 14th level, when you make an ability check, you can expend one use of Bardic " +
    "Inspiration.  Roll a Bardic Inspiration die and add the rolled number to your ability check.  You can " +
    "choose to do so after you roll the die for the ability check, but before the DM tells you whether you " +
    "succeed or fail.")

    workingMap(14) = List(peerless)

    workingMap.toMap
  }

}
