package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.{HashMap => MutableHashMap}

/**
  * Class to provide access to the features of a specific class specialization based on the
  * Enum that is used to specify the specialization.
  *
  * @param id the enum value that provides the type of specializaton
  * @param specializationMap the Map that contains the specialization features for the class
  */
class Dnd5ClassSpecializationImpl(id: Dnd5SpecializationsEnum.Value, descript: String,
                                  specializationMap: Map[Int, List[SpecializationFeature]])
  extends Dnd5ClassSpecialization {
  val specId: Dnd5SpecializationsEnum.Value = id
  val description: String = descript
  val features: Map[Int, List[SpecializationFeature]] = specializationMap

  override def toString: String = specId.toString
}

object Dnd5ClassSpecializationImpl {

  private val specializationCache =
    new MutableHashMap[Dnd5SpecializationsEnum.Value, Dnd5ClassSpecializationImpl]()
  /**
    * Return an object that provides an instance class that contains the data from
    * a specialization Object.  The object returned is created new if no specialization of that
    * type was previously or is provided as a cached instance if it was previously requested.
    *
    * @param specType enum value specifying the type of specialization desired
    *
    * @return a class instance that contains the specialization features for a specific class specialization
    */
  def createFromEnum(specType:  Dnd5SpecializationsEnum.Value): Dnd5ClassSpecializationImpl = {
    if (specializationCache.nonEmpty && specializationCache.contains(specType))
      specializationCache(specType)
    else {

        val details =
        specType match {
          case Dnd5SpecializationsEnum.PathOfTheBerserker => (PathOfTheBerserker.description,
            PathOfTheBerserker.features)
          case Dnd5SpecializationsEnum.PathOfTheTotemWarrior => (PathOfTheTotemWarrior.description,
            PathOfTheTotemWarrior.features)
          case Dnd5SpecializationsEnum.CollegeOfLore => (CollegeOfLore.description, CollegeOfLore.features)
          case Dnd5SpecializationsEnum.CollegeOfValor => (CollegeOfValor.description, CollegeOfValor.features)
          case Dnd5SpecializationsEnum.KnowledgeDomain => (KnowledgeDomain.description, KnowledgeDomain.features)
          case Dnd5SpecializationsEnum.LifeDomain => (LifeDomain.description, LifeDomain.features)
          case Dnd5SpecializationsEnum.LightDomain => (LightDomain.description, LightDomain.features)
          case Dnd5SpecializationsEnum.NatureDomain => (NatureDomain.description, NatureDomain.features)
          case Dnd5SpecializationsEnum.TempestDomain => (TempestDomain.description, TempestDomain.features)
          case Dnd5SpecializationsEnum.TrickeryDomain => (TrickeryDomain.description, TrickeryDomain.features)
          case Dnd5SpecializationsEnum.WarDomain => (WarDomain.description, WarDomain.features)
          case Dnd5SpecializationsEnum.CircleOfTheLand => (CircleOfTheLand.description, CircleOfTheLand.features)
          case Dnd5SpecializationsEnum.CircleOfTheMoon => (CircleOfTheMoon.description, CircleOfTheMoon.features)
          case Dnd5SpecializationsEnum.Champion => (Champion.description, Champion.features)
          case Dnd5SpecializationsEnum.BattleMaster => (BattleMaster.description, BattleMaster.features)
          case Dnd5SpecializationsEnum.EldritchKnight => (EldritchKnight.description, EldritchKnight.features)
          case Dnd5SpecializationsEnum.WayOfTheOpenHand => (WayOfTheOpenHand.description, WayOfTheOpenHand.features)
          case Dnd5SpecializationsEnum.WayOfShadow => (WayOfShadow.description, WayOfShadow.features)
          case Dnd5SpecializationsEnum.WayOfTheFourElements => (WayOfTheFourElements.description,
            WayOfTheFourElements.features)
          case Dnd5SpecializationsEnum.OathOfDevotion => (OathOfDevotion.description, OathOfDevotion.features)
          case Dnd5SpecializationsEnum.OathOfTheAncients => (OathOfTheAncients.description, OathOfTheAncients.features)
          case Dnd5SpecializationsEnum.OathOfVengeance => (OathOfVengeance.description, OathOfVengeance.features)
          case Dnd5SpecializationsEnum.Hunter => (Hunter.description, Hunter.features)
          case Dnd5SpecializationsEnum.BeastMaster => (BeastMaster.description, BeastMaster.features)
          case Dnd5SpecializationsEnum.Thief => (Thief.description, Thief.features)
          case Dnd5SpecializationsEnum.Assassin => (Assassin.description, Assassin.features)
          case Dnd5SpecializationsEnum.ArcaneTrickster => (ArcaneTrickster.description, ArcaneTrickster.features)
          case Dnd5SpecializationsEnum.DraconicBloodline => (DraconicBloodline.description, DraconicBloodline.features)
          case Dnd5SpecializationsEnum.WildMagic => (WildMagic.description, WildMagic.features)
          case Dnd5SpecializationsEnum.TheArchfey => (TheArchFey.description, TheArchFey.features)
          case Dnd5SpecializationsEnum.TheFiend => (TheFiend.description, TheFiend.features)
          case Dnd5SpecializationsEnum.TheGreatOldOne => (TheGreatOldOne.description, TheGreatOldOne.features)
          case _ => throw new IllegalArgumentException
        }
      val newSpec = new Dnd5ClassSpecializationImpl(specType, details._1, details._2)
      specializationCache(specType) = newSpec
      newSpec
    }
  }
}
