package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

object CircleOfTheMoon extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: MutableHashMap[Int, List[SpecializationFeature]] =
      new MutableHashMap[Int, List[SpecializationFeature]]()

    // level 2
    val combat = new SpecializationFeature("Combat Wild Shape",
      "When you choose this circle at 2nd level, you gain the ability to use Wild Shape on your " +
    "turn as a bonus action, rather than as an action.\nAdditionally, while you are transformed by Wild " +
    "Shape, you can use a bonus action to expend one spell slot to regain 1d8 points per level of the " +
    "spell slot expended.")
    val forms = new SpecializationFeature("Circle Forms",
    "The rites of your circle grant you the ability to transform into more dangerous animal forms.  " +
    "Starting at 2nd level, you can use your Wild Shape to transform into a beast with a challenge rating as " +
    "high as 1 (you ignore the Max. CR column of the Beast Shapes table, but must abide by the other " +
    "limitations there).\nStarting at 6th level, you can transform into a beast with a challenge rating as " +
    "high as your druid level divided by 3, rounded down.")
    workingMap(2) = List(combat, forms)

    // level 6
    val strike = new SpecializationFeature("Primal Strike",
      "Starting at 6th level, your attacks in beast form count as magical for the purpose of " +
    "overcomming resistance and immunity to nonmagical attacks and damage.")
    workingMap(6) = List(strike)

    // level 10
    val elemental = new SpecializationFeature("Elemental Wild Shape",
      "At 10th level, you can expend two uses of Wild Shape at the same time to transform into " +
    "an air elemental, and earth elemental, a fire elemental, or a water elemental.")
    workingMap(10) = List(elemental)

    // level 14
    val thousand = new SpecializationFeature("Thousand Forms",
      "By 14th level, you have learned to use magic to alter your physical form in more subtle " +
    "ways.  You can cast the 'alter self' spell at will.")
    workingMap(14) = List(thousand)

    workingMap.toMap
  }
}
