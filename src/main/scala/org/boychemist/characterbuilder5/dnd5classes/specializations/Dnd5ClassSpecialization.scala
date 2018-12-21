package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

case class SpecializationFeature(name: String, description: String)

/**
  * Class to provide access to the features of a specific class specialization based on the
  * Enum that is used to specify the specialization.
  *
  * @param specName name of the specialization
  * @param specializationMap the Map that contains the specialization features for the class
  */
class Dnd5ClassSpecialization(specName: String, descript: String, spells: Boolean,
                              specializationMap: Map[Int, List[SpecializationFeature]]) {
  val name: String = specName
  val description: String = descript
  val providesSpells: Boolean = spells
  val features: Map[Int, List[SpecializationFeature]] = specializationMap

  override def toString: String = name

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
    val sorted: mutable.TreeMap[Int, List[SpecializationFeature]] = new mutable.TreeMap[Int, List[SpecializationFeature]]()
    sorted ++= features.filterKeys(_ <= classLevel)

    val outList: mutable.MutableList[SpecializationFeature] = new mutable.MutableList[SpecializationFeature]()
    val iter = sorted.keysIterator
    while (iter.hasNext) {
      val aList = sorted(iter.next())
      outList ++= aList
    }

    outList.toList
  }
}

object Dnd5ClassSpecialization {

  def getSpecialilzationNamesAndDescriptionsByClassId(classId: Int): List[(String, String)] = {
    val rawSpecializations = DbClassInfo.getSpecializationDataById(classId)
    val working = new ListBuffer[(String, String)]
    val rawIter = rawSpecializations.iterator
    while (rawIter.hasNext) {
      val (name, description, _) = rawIter.next()
      working += Tuple2(name, description)
    }
    working.toList
  }

  private def getSpecializationFeaturesById(id: Int): Map[Int, List[SpecializationFeature]] = {
    val rawSpecializationFeatures = DbClassInfo.getSpecilalizationFeaturesBySpecID(id)
    val featuresIter = rawSpecializationFeatures.iterator
    val featuresMap = new mutable.TreeMap[Int, List[SpecializationFeature]]
    while (featuresIter.hasNext) {
      val feature = featuresIter.next()
      val specFeature = SpecializationFeature(feature.name, feature.description)
      if (featuresMap.contains(feature.level)) {
        featuresMap(feature.level) = featuresMap(feature.level) ++ List(specFeature)
      } else {
        featuresMap(feature.level) = List(specFeature)
      }
    }
    featuresMap.toMap
  }

  def getSpecializationImplFromDbBySpecializationName(name: String): (Int, Dnd5ClassSpecialization) = {
    val (specializationId: Int, description: String, hasSpells: Boolean) =
      DbClassInfo.getSpecializationDataByName(name).head
    val featuresMap = getSpecializationFeaturesById(specializationId)

    (specializationId, new Dnd5ClassSpecialization(name, description, hasSpells, featuresMap))
  }

  def getSpecializationImplFromDbById(id: Int): Dnd5ClassSpecialization = {
    val (name, description, hasSpells) = DbClassInfo.getSpecializationDataById(id).head
    val featuresMap = getSpecializationFeaturesById(id)
    new Dnd5ClassSpecialization(name, description, hasSpells, featuresMap)
  }
}
