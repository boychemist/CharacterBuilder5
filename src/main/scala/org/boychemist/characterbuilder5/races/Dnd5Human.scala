package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

import scala.collection.mutable
import scala.collection.mutable.MutableList

object Dnd5Human extends Dnd5Race {
  override val race = Dnd5RacesEnum.Human
  override val size = DndCharacterSizeEnum.Medium
  override val baseSpeed = 30
  override val skillProficiencies = List()
  override val weaponProficiencies = List()
  override val armorProficiencies = List() // Mountain Dwarf only
  override val toolsForProficiency = List()
  override val abilityAdjustments = createHumanAbilityAdjustments()
  override val racialAbilities = createHumanRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common)
  override def hitPointIncrement() = 0

  private def createHumanAbilityAdjustments() = {
    val iter = DndAbilitiesEnum.values.iterator
    val varList = new mutable.MutableList[AbilityAdjustment]()
    while (iter.hasNext) {
      val adjust = new AbilityAdjustment(iter.next(), 1)
      varList += adjust
    }
    varList.toList
  }

  private def createHumanRacialAbilities() ={
    val extraLanguage = new RacialAbilitiy("Second Language",
      "You can speak, read, and write a second language of your choice.")

    List(extraLanguage)
  }
}
