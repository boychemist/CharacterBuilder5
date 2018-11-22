package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object SchoolOfAbjuration extends Dnd5ClassSpecialization {
  override val providesSpells = false

  val description: String = "The School of Abjuration emphasized magic that blocks, banishes, or protects.\n" +
  "Detractors of this school say that its tradition is about denial, negation rather than positive assertion.\n" +
  "You understand, however, that ending harmful effects, protecting the weak, and banishing evil influences\n" +
  "is anything but a philosophical void.  It is a proud and respected tradition.\n\n" +
  "Called abjurers, members of this school are sought when baleful spirits require exorcism, when important\n" +
  "locations must be guarded against magical spying, and when portals to other planse of existence must be closed."

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 2
    val savant = new SpecializationFeature("Abjuration Savant",
      "Beginning when you select this school at 2nd level, the gold and time you must spend to copy\n" +
    "an abjuration spell into your spellbook is halved.")
    val ward = new SpecializationFeature("Arcane Ward",
      "Starting at 2nd level, you can weave magic around yourself for protection.  When you cast an\n" +
    "abjuration spell of 1st level or higher, you can simultaneously use a strand of the spell's magic to create\n" +
    "a magical ward on yourself that lasts unitl you finish a long rest.  The ward has a hit point maximum equal\n" +
    "to twice you wizard level + your Intelligence modifier.  Whenever you take damage, the ward takes damage\n" +
    "instead.  If this damages the ward to 0 hit points, you take any remaining damage.\n\n" +
    "While the ward has 0 hit points, it can't absorb damage, but its magic remains.  Whenever you cast an\n" +
    "abjuration spell of 1st level or higher, the ward regains a number of hit point equal to twice the spell level\n\n" +
    "Once you create the ward, you can't create it again until you finish a long rest.")
    workingMap(2) = List(savant, ward)

    // level 6
    val projected = new SpecializationFeature("Projected Ward",
      "Starting at 6th level, when a creature that you can see within 30 feet of you takes damage,\n" +
    "you can use your reaction to cause your Arcane Ward to absorb that damage.  If this damage reduces the ward\n" +
    "to 0 hit points, the warded creature takes any remaining damage.")
    workingMap(6) = List(projected)

    // level 10
    val improved = new SpecializationFeature("Improved Abjuration",
      "Beginning at 10th level, when you cast an abjuration spell that requires you to make an ability\n" +
    "check as a part of casting that spell (as in counterspell and dispell magic), you add your proficiency bonus\n" +
    "to that ability check.")
    workingMap(10) = List(improved)

    // level 14
    val resistance = new SpecializationFeature("Spell Resistance",
      "Staring at 14th level, you have advantage on saving throws against spells.\n\n" +
    "Furthermore, you have resistance against the damage of spells.")
    workingMap(14) = List(resistance)

    workingMap.toMap
  }
}
