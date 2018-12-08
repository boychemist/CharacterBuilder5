package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations._

import scala.collection.mutable.{MutableList => mList, TreeMap => tMap}

class ClassFeature(val name: String, val description: String)

/**
  * Define the structure of the data common to all classes in Dungeons and Dragons 5th Edition.
  */
trait Dnd5BasicClass {
  def classID: Dnd5ClassesEnum.Value
  // specialization is the unique choice for class leveling and has different names for each class
  def allowedSpecializations: Vector[Dnd5SpecializationsEnum.Value]
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  def specializationStartLevel: Int
  def hitDice: String
  def armorProficiencies: List[String]
  def weaponProficiencies: List[String]
  def toolProficiencies: List[String]
  def savingThrowProficiencies: List[DndAbilitiesEnum.Value]
  def skillChoices: List[String]
  def numberOfSkills: Int
  def features: Map[Int, List[ClassFeature]]
  val specializationName: String

  /**
    * Extract the class features for a class level
    *
    * @param classLevel for which the features are desired
    *
    * @return a list of ClassFeature or an empty list if none are defined for the level
    */
  def getClassFeaturesForClassLevel(classLevel: Int): List[ClassFeature] = {
    def levelFeautures(x: Option[List[ClassFeature]]): List[ClassFeature] = x match{
      case Some(l) => l
      case None => List()
    }
    levelFeautures(features.get(classLevel))
  }

  /**
    * Get all the class features whose key is less than or equal to the specified class level.
    *
    * @param classLevel of interest
    *
    * @return a list of all the class features whose key is less than or equal to the specified
    *         class level or an empty list if no class feature keys are found.  If the list is
    *         not empty, the class features are sorted so that the class features for
    *         lower class levels are nearer the head of the list than the features for higher class levels.
    */
  def getClassFeaturesUpToClassLevel(classLevel: Int): List[ClassFeature] ={
    val sorted: tMap[Int, List[ClassFeature]] = new tMap[Int, List[ClassFeature]]()
    sorted ++= features.filterKeys(_<= classLevel)

    val outList: mList[ClassFeature] = new mList[ClassFeature]()
    val iter = sorted.keysIterator
    while (iter.hasNext) {
      val aList = sorted(iter.next())
      outList ++= aList
    }

    outList.toList
  }

  override def toString: String = classID.toString
}
