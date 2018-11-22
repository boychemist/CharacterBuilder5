package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object NatureDomain extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 1 features
    val spells = new SpecializationFeature("Nature Domain Spells",
      "Cleric Levels\tSpells\n" +
        "     1st\tanimal friendship, speak with animals\n" +
        "     3rd\tbarkskin, spike growth\n'" +
        "     5th\tplant growth, wind wall\n" +
        "     7th\tdominate beast, grasping vine\n" +
        "     9th\tinsect plague, tree stride")
    val acolyte = new SpecializationFeature("Acolyte of Nature",
      "At 1st level, you learn on druid cantrip of your choice.  You also gain proficiency in one " +
    "of the following skills of your choice: Animal Handling, Nature, or Survival.")
    val bonus = new SpecializationFeature("Bonus Proficiency",
      "Also at 1st level, you gain proficiency with heavy armor.")
    workingMap(1) = List(spells, acolyte, bonus)

    // level 2 feature
    val charm = new SpecializationFeature("Channel Divinity: Charm Animals and Plants",
      "Starting at 2nd level, you can use your Channel Divinity to charm animals and plants.\n" +
    "As an action, you present your holy symbol and invoke the name of your deity.  Each beast or plant " +
    "creature that can see you within 30 feet of you must make a Wisdom saving throw.  If the creature fails " +
    "its saving throw, it is charmed by you for 1 minute or until it takes damage.  While it is charmed by you " +
    "it is friendly to you and other creatures you designate.")
    workingMap(2) = List(charm)

    // level 6 feature
    val dampen = new SpecializationFeature("Dampen Elements",
      "Starting at 6th level, when you or a creature within 30 feet of you takes acid, cold, fire, " +
    "lightening, or thunder damage, you can use your action to grant resistance to the creature against that " +
    "instance of the damage")
    workingMap(6) = List(dampen)

    // level 8 feature
    val strike = new SpecializationFeature("Divine Strike",
      "At 8th level, you gain the ability to infuse your weapon strikes with divine energy.  Once on " +
    "each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra " +
    "1d8 cold, fire, or lightening damage (your choice) to the target.  When you reach 14th level, the extra " +
        "damage increases to 2d8.")
    workingMap(8) = List(strike)

    // level 17 feature
    val master = new SpecializationFeature("Master of Nature",
      "At 17th level, you gain the ability to command animals and plant creatures.  While creatures " +
    "are charmed by your Charm Animals and Plants feature, you can take a bonus action on your turn to verbally " +
    "command what each of those creatures will do on its next turn.")
    workingMap(17) = List(master)

    workingMap.toMap
  }
}
