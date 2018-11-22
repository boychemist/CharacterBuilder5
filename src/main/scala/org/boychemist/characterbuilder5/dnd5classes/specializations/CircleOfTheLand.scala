package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object CircleOfTheLand extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 2
    val bonus = new SpecializationFeature("Bonus Cantrip",
    "When you choose this circle at 2nd level, you learn one additional druid cantrip of your choice.")
    val recovery = new SpecializationFeature("Natural Recovery",
    "Starting at 2nd level, you can regain some of your magical energy by sitting in meditation " +
    "and communing with nature.  During a short rest, you choose expended spell slots to recover.  The spell " +
    "slots can have a combined level that is equal to or less than half your druid level (rounded up) and none " +
    " of the slots can be 6th level or higher.  You can't use this feature again until you finish a long rest.\n" +
    "For example, when you ar a 4th level druid, you can recover up to two levels worth of spell slots.  You " +
    "can recover either a 2nd level spell slot or two 1st level slots.")
    workingMap(2) = List(bonus, recovery)

    // level 3
    val spells = new SpecializationFeature("Circle Spells",
    "Your mystical connection to the land infuses you with the ability to cast certain spells.  " +
    "At 3rd, 5th, 7th, and 9th levels you gain access to circle spells connected to the land where you became " +
    "a druid.  Choose that land -- arctic, coast, desert, forest, grassland, mountain, swamp, or Underdark -- " +
    "and consult the associated list of spells.\n" +
    "Once you gain access to a circle spell, you always have it prepared, and it doesn't count against the " +
    "number of spell you can prepare each day.  If you gain access to a spell that doesn't appear on the druid " +
    "spell list, the spell is nonetheless a druid spell for you.")
    workingMap(3) = List(spells)

    // level 6
    val stride = new SpecializationFeature("Land's Stride",
    "Starting at 6th level, moving through nonmagical difficult terrain costs you no extra " +
    "movement.  You can also pass through nonmagical plants without being slowed by them and without taking " +
    "damage from them if they have thorns, spines, or a similar hazard.\n" +
    "In addition, you have advantage on saving throws against plants that are magically created or " +
    "manipulated to impede movement,such as those created by the 'entangle' spell.")
    workingMap(6) = List(stride)

    // level 10
    val ward = new SpecializationFeature("Nature's Ward",
    "When you reach 10th level, you can't be charmed or frightened by elementals or fey, and you "+
    "are immune to poison and disease.")
    workingMap(10) = List(ward)

    // level 14
    val sanctuary = new SpecializationFeature("Nature's Sanctuary",
    "When you reach 14 th level, creatures of the natural world sense your connection to nature " +
    "and become hesitant to attack you.  When a beast or plant creature attacks you, that creature must make " +
    "a Wisdom saving throw against your druid spell DC.  On a failed save, the creature must choose a different " +
    "target, or the attack automatically misses.  On a successful save, the creature is immune to this effect " +
    "for 24 hours.\nThe creature is aware of this effect before it makes its attack against you.")
    workingMap(14) = List(sanctuary)

    workingMap.toMap
  }

}
