package org.boychemist.characterbuilder5.backgrounds

import org.boychemist.characterbuilder5.Dnd5SkillsEnum
import org.boychemist.characterbuilder5.dbInterface.Tables.BackgroundFeaturesRow

trait BackgroundBase {
  val backgroundId: Int  // database serial key
  val name: String
  val description: String
  val skills: List[Dnd5SkillsEnum.Value]
  val toolOptions: List[String]
  val equipmentOptions: List[String]
  val gold: Long
  val numAdditionalLanguages = 0
  val feature: BackgroundFeaturesRow
  val variantFeatures: List[BackgroundFeaturesRow] = List()
  val specializationName: String = ""
  val specializationDescription: String = ""
  val specializationChoices: Seq[(Int, String)] = Seq()
  val characteristics: String
  val personalityTraits: Seq[(Int, String)]
  val idealChoices: Seq[(Int, String)]
  val bondChoices: Seq[(Int, String)]
  val flawChoices: Seq[(Int, String)]
}
