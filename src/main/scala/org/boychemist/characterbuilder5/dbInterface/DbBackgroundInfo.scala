package org.boychemist.characterbuilder5.dbInterface

import Tables._
import slick.jdbc.H2Profile.api._

import scala.concurrent.Await
import scala.concurrent.duration._

object DbBackgroundInfo {
  private lazy val allBackgrounds = TableQuery[Backgrounds]
  private lazy val allBackgroundFeatures = TableQuery[BackgroundFeatures]
  private lazy val allPersonalityTraits = TableQuery[PersonalityTraits]
  private lazy val allBackgroundDetails = TableQuery[BackgroundDetails]
  private lazy val allBackgroundChoices = TableQuery[BackgroundChoices]
  private lazy val allIdeals = TableQuery[Ideals]
  private lazy val allBonds = TableQuery[Bonds]
  private lazy val allFlaws = TableQuery[Flaws]

  private def exec[T](action: DBIO[T]): T =
    Await.result(CharacterDatabaseConnection.db.run(action), 2.seconds)

  def getAllBackgrounds: Seq[BackgroundsRow] = {
    exec(allBackgrounds.result)
  }

  def getBackgroundById(id: Int): BackgroundsRow = {
    val getRow = allBackgrounds.filter(_.backgroundId === id)
    val retRow = exec(getRow.result)
    retRow.head
  }

  def getBackgroundFeatureByName(featureName: String): BackgroundFeaturesRow = {
    val getFeature = allBackgroundFeatures.filter(_.name === featureName)
    val retFeature = exec(getFeature.result)
    retFeature.head
  }

  def getBackgroundFeaturesForBackgroundID(
      backgroundId: Int): Seq[BackgroundFeaturesRow] = {
    val getFeatures =
      allBackgroundFeatures.filter(_.backgroundId === backgroundId)
    exec(getFeatures.result)
  }

  def getBackgroundDetailsByBackgroundID(
      backgroundID: Int): BackgroundDetailsRow = {
    val getDetails =
      allBackgroundDetails.filter(_.backgroundId === backgroundID)
    val retDetails = exec(getDetails.result)
    retDetails.head
  }

  def getPersonalityTraitsByBackgroundID(ID: Int): Seq[(Int, String)] = {
    val sortedTraits = allPersonalityTraits
      .filter(_.backgroundId === ID)
      .sortBy(_.sequenceNum)
      .map(t => (t.sequenceNum, t.aTrait))
    exec(sortedTraits.result)
  }

  def getIdealsByBackgroundID(ID: Int): Seq[(Int, String)] = {
    val sortedIdeals = allIdeals
      .filter(_.backgroundId === ID)
      .sortBy(_.sequenceNum)
      .map(i => (i.sequenceNum, i.ideal))
    exec(sortedIdeals.result)
  }

  def getBondsByBackgroundID(ID: Int): Seq[(Int, String)] = {
    val sortedBonds = allBonds
      .filter(_.backgroundId === ID)
      .sortBy(_.sequenceNum)
      .map(b => (b.sequenceNum, b.bond))
    exec(sortedBonds.result)
  }

  def getFlawsByBackgroundID(ID : Int): Seq[(Int, String)] = {
    val sortedFlaws = allFlaws
      .filter(_.backgroundId === ID)
      .sortBy(_.sequenceNum)
      .map(f => (f.sequenceNum, f.flaw))
    exec(sortedFlaws.result)
  }

  def getBackgroundChoicesByBackgroundID(ID: Int): Seq[(Int, String)] = {
    val sortedChoices = allBackgroundChoices
      .filter(_.backgroundId === ID)
      .sortBy(_.sequenceNum)
      .map(c => (c.sequenceNum, c.choice))
    exec(sortedChoices.result)
  }
}
