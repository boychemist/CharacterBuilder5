package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object SchoolOfConjuration extends Dnd5ClassSpecialization {
  override val providesSpells = false

  val description: String = "As a conjurer, you favor spells that produce objects and creatures out of thin air.\n" +
  "You can conjure billowing clouds of killing fog or summon creatures from elsewhere to fight on your behalf.\n" +
  "As your mastery grows, you learn spells of transportation and can teleport yourself across vast distance,\n" +
  "even to other planes of existence, in an instant."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 2
    val savant = new SpecializationFeature("Conjuration Savant",
      "Beginning when you select this school at 2nd level, the gold and time you must spend to copy\n" +
        "a conjuration spell into your spellbook is halved.")
    val minor = new SpecializationFeature("Minor Conjuration",
      "Starting at 2nd level when you select this school, you can use your action to conjure up an\n" +
    "inanimate object in your hand on on the ground in an unoccupied space that you can see within 10 feet of\n" +
    "you.  This object can be no larger than 3 feet on a side and weigh no more than 10 pounds, and its form\n" +
    "must be that of a nonmagical object that you have seen.  The object is visibly magical, rediating a dim\n" +
    "light out to 5 feet.\n\n" +
    "The object disappears after 1 hour, when you use this feature again, or if it takes any damage.")
    workingMap(2) = List(savant, minor)

    // level 6
    val benign= new SpecializationFeature("Benign Transposition",
      "Starting at 6th level, you can use your action to teleport uyp to 30 feet to an unoccupied\n" +
    "space that you can see.  Alternatively, you can choose a space within range that is occupied by a Small or\n" +
    "Medium creature.  If that creature is willing, you both teleport, swapping places.\n\n" +
    "Once you use this feature, you can't use it again until you finish a long rest or you cast a conjuration\n" +
    "spell of 1st level or higher.")
    workingMap(6) = List(benign)

    // level 10
    val focused = new SpecializationFeature("Focused Conjuration",
      "Beginning at 10th level, while you are concentrating on a conjuration spell, your concentration\n" +
    "can't be broken as a result of taking damage.")
    workingMap(10) = List(focused)

    // level 14
    val durable = new SpecializationFeature("Durable Summons",
      "Staring at 14th level, any creature that you summon or create with a conjuration spell has\n" +
    "30 temporary hit points.")
    workingMap(14) = List(durable)

    workingMap.toMap
  }
}
