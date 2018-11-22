package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._

/**
  * Defines the data specific to spell casters, for extending Dnd5BasicClass
  */
trait Dnd5SpellCaster {
  def spellSourceType: Dnd5ClassesEnum.Value  // defines the spell list to use when choosing spells
  def classLevelForFirstSpells: Int
  def abilityModifierforDC_attack: DndAbilitiesEnum.Value
  // empty cleric, druid, or wizard (Wizards must have spell in spell book)
  def totalSpellsKnownByClassLevel: Vector[Int]
  // the level restriction for spell slots is the class level, not the character level
  // the maps do not include entries for levels that don't provide spell slots of that level
  // Eldrich Knights, Paladins, and Rangers don't have cantrips at any level and don't have
  // spell slots above certain levels (4 or 5).  Arcane Tricksters don't have spell slots above level 4.
  def cantripsPerLevel(level:Int): Int = 0
  def firstLevelSlotsPerLevel(level:Int): Int = 0
  def level2SlotsPerLevel(level:Int): Int = 0
  def level3SlotsPerLevel(level:Int): Int = 0
  def level4SlotsPerLevel(level:Int): Int = 0
  def level5SlotsPerLevel(level:Int): Int = 0
  def level6SlotsPerLevel(level:Int): Int = 0
  def level7SlotsPerLevel(level:Int): Int = 0
  def level8SlotsPerLevel(level:Int): Int = 0
  def level9SlotsPerLevel(level:Int): Int = 0

//  def getSpellsPerLevel(levelMap: Map[Int, Int], level: Int): Int = {
//    levelMap(level)
//  }
}
