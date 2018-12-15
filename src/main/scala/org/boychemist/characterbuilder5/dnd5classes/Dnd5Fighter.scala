package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations._

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap

object Dnd5Fighter extends Dnd5BasicClass {
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Fighter
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val specializationStartLevel: Int = 3
  val hitDice: String = "1d10"
  val armorProficiencies: List[String] = List("Light armor", "Medium armor", "Heavy armor", "Shields")
  val weaponProficiencies: List[String] = List("Simple weapons", "Martial weapons")
  val toolProficiencies: List[String] = List()
  val savingThrowProficiencies: List[DndAbilitiesEnum.Value] =
    List(DndAbilitiesEnum.Strength, DndAbilitiesEnum.Constitution)
  val skillChoices: List[String] = List("Acrobatics", "Animal Handling", "Athletics", "History", "Insight",
   "Intimidation", "Perception", "Survival")
  val numberOfSkills: Int = 2
  val features: Map[Int, List[ClassFeature]] = creatFighterClassFeatures()
  override val specializationName: String = "Martial Archetype"

  private def creatFighterClassFeatures(): Map[Int, List[ClassFeature]] = {
    var workingMap = new mTreeMap[Int, List[ClassFeature]]()
    // Level 1
    val style = new ClassFeature("Fighting Style",
    "You adopt a particular style of fighting as your speciality.  Choose one of the options in " +
    "the Player's Handbook.  You can't take a Fighting Style option more than once, even if you later get to " +
    "choose again.")
    val wind = new ClassFeature("Second Wind",
    "You have a limited pool of stamina that you can draw on to protect yourself from harm.  On " +
    "your turn, you can use a bonus action to regain hit points equal to 1d10 + your fighter level.  Once you " +
    "use this feature, you must finish a short or long rest before you can use it again.")
    workingMap(1) = List(style, wind)

    // level 2
    val surge = new ClassFeature("Action Surge",
    "Starting at 2nd level, you can push yourself beyond your normal limits for a moment.  On " +
    "your turn, you can take one additional action on top of your regular action and a possible bonus " +
    "action.\nOnce you use this feature, you must finish a short or long rest before you can use it again.  " +
    "Starting at 17th level, you can use it twice before a rest, but only once on the same turn.")
    workingMap(2) = List(surge)

    // level 5
    val attack = new ClassFeature("Extra Attack",
    "Beginning at 5th level, you can attack twice, instead of once, whenever your take the " +
    "Attack action on your turn.\nThe number of attacks increases to three when you reach 11th level " +
    "in this class and to four when you reach 20th level in this class.")
    workingMap(5) = List(attack)

    // level 9
    val indomitable = new ClassFeature("Indomitable",
    "Beginning at 9th level, you can reroll a saving throw that you fail.  If you do so, you " +
    "must use the new roll, and you can't use this feature again until your finish a long rest.\n" +
    "You can use this feature twice between long rests starting at 13th level and three times between " +
    "long rests starting at 17th level.")
    workingMap(9) = List(indomitable)

    // return an immutable Map
    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }

}
