package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.HashMap

object KnowledgeDomain extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

  val workingMap: HashMap[Int, List[SpecializationFeature]] = new HashMap[Int, List[SpecializationFeature]]()

  // level 1 features
  val spells = new SpecializationFeature("Knowledge Domain Spells",
  "Cleric Levels\tSpells\n" +
    "     1st\tcommand, identify\n" +
    "     3rd\taugury, suggestion\n'" +
    "     5th\tnondetection, speak with dead\n" +
    "     7th\tarcane eye, confusion\n" +
    "     9th\tlegend lore, scrying"
  )
  val blessings = new SpecializationFeature("Blessings of Knowledge",
  "At 1st level, you learn two languages of your choice.  You also become proficient in your " +
  "choice of two of the following skills:  Arcana, History, Nature, or Religion.\n" +
   "Your proficiency bonus is doubled for any ability check you make that uses either of these skills.")
  workingMap(1) = List(spells, blessings)

  // level 2 feature
  val ages = new SpecializationFeature("Channel Divinity: Knowledge of the Ages",
  "Starting at level 2, you can use your Channel Divinity to tap into a divine well of knowledge.  \n" +
  "As an action, you choose one skill or tool.  For 10 minutes, you have proficiency with the chosen skill or tool.")
  workingMap(2) = List(ages)

  // level 6 feature
  val thoughts = new SpecializationFeature("Channel Divinity: Read Thoughts",
  "At 6th level, you can user your Channel Divinity to read a creature's thoughts.  " +
  "You can then user your access to the creature's mind to command it.\n" +
  "As an action, choose one creature tha you can see within 60 feet of you.  That creature must make a" +
  "Wisdom saving throw.  If the creature succeeds, on the saving throw, you can't use this feature on it " +
  "again until you finish a long rest.\n" +
  "If the creature fails its save, you can read its surface thoughts (those foremost in its mind, reflecting " +
  "its curent emotions and what it is actively thinking about) when it is within 60 feet of you.  This effect " +
  "lasts for 1 minute.\n" +
  "During that time, you can use your actionto end this effect and cast the 'suggestion' spell on the creature " +
  "without expending a spell slot.  The target automatically fails its saving throw against the spell.")

  workingMap(6) = List(thoughts)

  // level 8 feature
  val potent = new SpecializationFeature("Potent Spellcasting",
  "Starting at 8th level, you add your Wisdom modifier to the damage you deal with any cleric cantrip.")
  workingMap(8) = List(potent)

  // level 17 feature
  val visions = new SpecializationFeature("Visions of the Past",
  "Starting at level 17, you can call up visions of the past that relate to an object you hold or " +
  "or your immediate surroundings.  You spend at least 1 minute in meditation and prayer, then receive " +
  "dreamlike, shadowy glimpses of recent events.  You can meditate in this way for a number of minutes " +
  "equal to your meditation score and must maintain concentration during that time, as if you were casting a spell.\n" +
  "Once you use this feature, you can't use it again until you finish a short or long rest.\n" +
    "OBJECT READING\n" +
    "Holding an object as you meditate, you can see visions of the object's previous owner.  After meditating 1 " +
    "minute, you learn how the owner acquired and lost the object, as well as the most recent significant event " +
    "involving the object and that owner.  If the object was owned by another creature in the recent past " +
    "(withing a number of days equal to your Wisdom score), you can spend 1 additional minute for each owner " +
    "to learn the same information about that creature.\n" +
    "AREA READING\n" +
    "As you meditate, you see visions of recent events in your immediate vicinity (a room, street, " +
    "tunnel, clearing, or the like, up to a 50-foot cube), going back a number of days equal to your Wisdom " +
    "score.  For each minute you meditate, you learn about one significant event, beginning with the most recent.  " +
    "Significant events typically include powerful emotions, such as battles and betrayals, marriages and " +
    "murders, births and funerals.  However, they might also include more mundane events that are nevertheless " +
    "important in your current situation.")
  workingMap(17) = List(visions)

  workingMap.toMap
}
}
