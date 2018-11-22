package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object SchoolOfDivination extends Dnd5ClassSpecialization {
  override val providesSpells = false

  val description: String = "The counsel of a diviner is sought by royalty and commoners alike, for all seek a\n" +
  "clearer understanding of the past, present, and future.  As a diviner, you strive to part the veils of space,\n" +
  "time, anc consciousness so that you can see clearly.  You work to master spells of discernment, remote\n" +
  "viewing, supernatural knowledge, and foresight."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 2
    val savant = new SpecializationFeature("Divination Savant",
      "Beginning when you select this school at 2nd level, the gold and time you must spend to copy\n" +
        "a divination spell into your spellbook is halved.")
    val portent = new SpecializationFeature("Portent",
      "Starting at 2nd level when you choose this school, glimpses of the future begin to press in on\n" +
    "you awareness.  When you finish a long rest, roll two d20s and record the numbers rolled.  You can replace any\n" +
    "attack roll, saving throw, or ability check with one of these foretelling rolls.  You must choose to do so\n" +
    "before the roll, and ou can replace a roll in this way only once per turn.\n\n" +
    "Each foretelling roll can be used only once.  When you finish a long rest, you lose any unused foretelling\n" +
    "rolls.")
    workingMap(2) = List(savant, portent)

    // level 6
    val expert= new SpecializationFeature("Expert Divination",
      "Beginning at 6th level, casting diviniation spells comes so easily to you that it expends only\n" +
    "a fraction of your spellcasting efforts.  When you cast a divination spell of 2nd level or higher using a\n" +
    "spell slot, you regain one expended spell slot.  The slot you regain must be of a lower level than the\n" +
    "than the spell you cast and can't be higher than 5th level.")
    workingMap(6) = List(expert)

    // level 10
    val eye = new SpecializationFeature("The Third Eye",
      "Starting at 10th level, you can use your action to increase your powers of perception.  When\n" +
    "you do so, choose one of the following benefits, which lasts until you are incapacitated or you take a short\n" +
    "or long rest.  You can't use the feature again until you finish a rest.\n\n" +
    "DARKVISION\n" +
    "You gain darkvision out to a range of 60 feet, as described in chapter 8 of the Player's Guide.\n\n" +
    "ETHEREAL SIGHT\n" +
    "You can see into the Ethereal Plane within 60 feet of you.\n\n" +
    "GREATER COMPREHENSION\n" +
    "You can read any language.\n\n" +
    "SEE INVISIBILITY\n" +
    "You can see invisile creatures and objects withing 10 feet of that are within line of sight.")
    workingMap(10) = List(eye)

    // level 14
    val greater = new SpecializationFeature("Greater Portent",
      "Staring at 14th level, the visions of your derams intensify and paint a more accurate picture\n" +
    "of what is to come.  You roll three d20s for your Portent feature, rather than two.")
    workingMap(14) = List(greater)

    workingMap.toMap
  }
}
