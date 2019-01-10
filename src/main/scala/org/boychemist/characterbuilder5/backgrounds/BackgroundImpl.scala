package org.boychemist.characterbuilder5.backgrounds

import org.boychemist.characterbuilder5.Dnd5SkillsEnum
import org.boychemist.characterbuilder5.dbInterface.DbBackgroundInfo
import org.boychemist.characterbuilder5.dbInterface.Tables.BackgroundFeaturesRow

import scala.collection.mutable.ListBuffer

object BackgroundImpl {
  def getBackgroundByName(backgroundName: String): BackgroundImpl = {
    new BackgroundImpl(DbBackgroundInfo.getBackgroundIdByName(backgroundName))
  }

  def choiceSeqToStringSeq(pairs: Seq[(Int, String)]): Seq[String] = {
    pairs.map {case (num, str) => num.toString + ") " + str}
  }
}

class BackgroundImpl(backgroundID: Int) extends BackgroundBase {
  override val backgroundId: Int = backgroundID
  private val baseRow = DbBackgroundInfo.getBackgroundById(backgroundID)
  override val name: String = baseRow.name
  override val description: String = baseRow.description

  private val choices: String = baseRow.choices match {
    case Some(s) => s
    case None    => ""
  }
  private var specName, specDescription: String = ""
  if (choices.length > 0) {
    val parts = choices.split("""\|""")
    specName = parts(0)
    specDescription = parts(1)
  }
  override val specializationName: String = specName
  override val specializationDescription: String = specDescription
  private val featSeq =
    DbBackgroundInfo.getBackgroundFeaturesForBackgroundID(backgroundID)
  private var mainFeat: BackgroundFeaturesRow = _
  private var altFeats: ListBuffer[BackgroundFeaturesRow] = ListBuffer()
  if (featSeq.length == 1) {
    mainFeat = featSeq.head
  } else {
    for (aFeat <- featSeq) {
      if (aFeat.variant) {
        altFeats += aFeat
      } else {
        mainFeat = aFeat
      }
    }
  }
  override val feature: BackgroundFeaturesRow = mainFeat
  override val variantFeatures: List[BackgroundFeaturesRow] = altFeats.toList
  private val details =
    DbBackgroundInfo.getBackgroundDetailsByBackgroundID(backgroundID)
  override val skills: List[Dnd5SkillsEnum.Value] =
    List(Dnd5SkillsEnum.withName(details.skill1.trim),
         Dnd5SkillsEnum.withName(details.skill2.trim))
  override val characteristics: String = details.characteristics
  private val toolsList: ListBuffer[String] = new ListBuffer()
  if (details.tools.length > 0) {
    for (atool <- details.tools.split("""\|""")) {
      toolsList += atool
    }
  }
  override val toolOptions: List[String] = toolsList.toList
  private val equipmentList = new ListBuffer[String]
  for (aPart <- details.equipment.split("""\|""")) {
    equipmentList += aPart
  }
  override val equipmentOptions: List[String] = equipmentList.toList
  override val numAdditionalLanguages: Int = details.numLanguages
  override val gold: Long = details.gold
  override val personalityTraits: Seq[(Int, String)] =
    DbBackgroundInfo.getPersonalityTraitsByBackgroundID(backgroundID)
  override val idealChoices: Seq[(Int, String)] =
    DbBackgroundInfo.getIdealsByBackgroundID(backgroundID)
  override val bondChoices: Seq[(Int, String)] =
    DbBackgroundInfo.getBondsByBackgroundID(backgroundID)
  override val flawChoices: Seq[(Int, String)] =
    DbBackgroundInfo.getFlawsByBackgroundID(backgroundID)
  override val specializationChoices: Seq[(Int, String)] =
    DbBackgroundInfo.getBackgroundChoicesByBackgroundID(backgroundID)
}
