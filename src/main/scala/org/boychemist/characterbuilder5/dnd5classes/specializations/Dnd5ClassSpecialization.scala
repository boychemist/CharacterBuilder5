package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{MutableList, TreeMap}

case class SpecializationFeature(val name: String, val description: String)

/**
  * Defines the data for a Dungeons and Dragons 5th Edition class specialization.  The Player's Handbook
  * provides different names for the specializations for each class.
  * Barbarians choose a Primal Path
  * Bards choose a Bard College
  * Clerics choose a Divine Domain
  * Druids choose a Druid Circle
  * Fighters choose a Martial Archetype
  * Monks choose a Monastic Tradition
  * Paladins choose a Sacred Oath
  * Rangers choose a Ranger Archetype
  * Rogues choose a Roguish Archetype
  * Sorcerers choose a Sorcerous Origin
  * Warlocks choose an Otherworldly Patron
  * Wizards choose an Arcane Tradition
  */
trait Dnd5ClassSpecialization {
  def providesSpells:Boolean = false
  val description: String
  /**
    * Contains a Map whose key is the integer level for which a List of specialization features
    * exist and whose value is the List of specialization features.
    */
  val features: Map[Int, List[SpecializationFeature]]

  /**
    * Extract the specialization features for a class level
    *
    * @param classLevel for which the features are desired
    *
    * @return a list of ClassFeature or an empty list if none are defined for the level
    */
  def getClassFeaturesForClassLevel(classLevel: Int): List[SpecializationFeature] = {
    def levelFeautures(x: Option[List[SpecializationFeature]]): List[SpecializationFeature] = x match{
      case Some(l) => l
      case None => List()
    }
    levelFeautures(features.get(classLevel))
  }

  /**
    * Get all the specialization features whose key is less than or equal to the specified class level.
    *
    * @param classLevel of interest
    *
    * @return a list of all the specialization features whose key is less than or equal to the specified
    *         class level or an empty list if no specialization feature keys are found.  If the list is
    *         not empty, the specialization features are sorted so that the specialization features for
    *         lower class levels are nearer the head of the list than the features for higher class levels.
    */
  def getClassFeaturesUpToClassLevel(classLevel: Int): List[SpecializationFeature] ={
    val sorted: TreeMap[Int, List[SpecializationFeature]] = new TreeMap[Int, List[SpecializationFeature]]()
    sorted ++= features.filterKeys(_ <= classLevel)

    val outList: MutableList[SpecializationFeature] = new MutableList[SpecializationFeature]()
    val iter = sorted.keysIterator
    while (iter.hasNext) {
      val aList = sorted(iter.next())
      outList ++= aList
    }

    outList.toList
  }
}
