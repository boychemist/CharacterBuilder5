package org.boychemist.characterbuilder5.dnd5classes.specializations

import org.boychemist.characterbuilder5.dbInterface.DbClassInfo

import scala.collection.mutable
import scala.collection.mutable.{ListBuffer, HashMap => MutableHashMap}

/**
  * Class to provide access to the features of a specific class specialization based on the
  * Enum that is used to specify the specialization.
  *
  * @param specName name of the specialization
  * @param specializationMap the Map that contains the specialization features for the class
  */
class Dnd5ClassSpecializationImpl(specName: String, descript: String, spells: Boolean,
                                  specializationMap: Map[Int, List[SpecializationFeature]])
  extends Dnd5ClassSpecialization { // todo -- merge with trait and remove trait (and all specializations)
  val name: String = specName
  val description: String = descript
  override val providesSpells: Boolean = spells
  val features: Map[Int, List[SpecializationFeature]] = specializationMap

  override def toString: String = name
}

object Dnd5ClassSpecializationImpl {

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

  def getSpecializationImplFromDbBySpecializationName(name: String): (Int, Dnd5ClassSpecializationImpl) = {
    val (specializationId: Int, description: String, hasSpells: Boolean) =
      DbClassInfo.getSpecializationDataByName(name).head
    val featuresMap = getSpecializationFeaturesById(specializationId)

    (specializationId, new Dnd5ClassSpecializationImpl(name, description, hasSpells, featuresMap))
  }

  def getSpecializationImplFromDbById(id: Int): Dnd5ClassSpecializationImpl = {
    val (name, description, hasSpells) = DbClassInfo.getSpecializationDataById(id).head
    val featuresMap = getSpecializationFeaturesById(id)
    new Dnd5ClassSpecializationImpl(name, description, hasSpells, featuresMap)
  }
}
