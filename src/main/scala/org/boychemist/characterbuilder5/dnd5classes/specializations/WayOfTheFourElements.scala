package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object WayOfTheFourElements extends Dnd5ClassSpecialization {
  override val providesSpells = true

  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    val discipline = new SpecializationFeature("Discipline of the Elements",
    "When you choose this tradition at 3rd level, you learn magical disciplines that harness " +
    "the elements.  A disciplie requires you to spend ki points each time you use it.\n\n" +
    "You know the Elemental Attunement discipline and one other elemental discipline of your choice, which " +
    "are detailed in the \"Elemental Disciplines\" section on page 81 of the Players Handbook.  You learn " +
    "one additional elemental discipline of your choice at 6th, 11th, and 17th level.\n\n" +
    "Whenever you learn a new elemental discipline, you can also replace one elemental discipline that you " +
    "already know with a different discipline.\n\n" +
    "CASTING ELEMENTAL SPELLS.  Some elemental disciplines allow you to cast spells.  See chapter 10 of the " +
    "Players Handbook for the general rules of spellcasting.  To cast one of these spells, you use its casting " +
    "time and other rules, but you don't need to provide material components for it.\n\n" +
    "Once you reach 5th level in this class, you can spend additional ki points to increase the level of an " +
    "elemental discipline spell that you cast, provided that the spell has an enhanced effect at higher level, " +
    "as 'burning hands' does.  The spell's level increases by 1 for each additional ki point you spend.  For " +
    "example, if you are a 5th-level monk and use Sweeping Cinder Strike to cast 'buring hands', you can spend " +
    "3 ki points to cast it as a 2nd-level spell (the discipline's base cost of 2 ki points plus 1).\n\n" +
    "The maximum number of ki points you can spend to cast a spell in this way (including its base ki point " +
    "cost and any additional ki points you spend to increase its level) is determined by you monk level, as " +
    "shown in the Spells and Ki Points table on page 80 of the Player's Handbook.")

    workingMap(3) = List(discipline)

    workingMap.toMap
  }

}
