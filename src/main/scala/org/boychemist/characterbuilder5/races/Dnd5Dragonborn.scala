package org.boychemist.characterbuilder5.races

import org.boychemist.characterbuilder5._

object Dnd5Dragonborn extends Dnd5Race {
  override val race: Dnd5RacesEnum.Value = Dnd5RacesEnum.DragonBorn
  override val size: DndCharacterSizeEnum.Value = DndCharacterSizeEnum.Medium
  override val baseSpeed = 30
  override val skillProficiencies = List()
  override val weaponProficiencies = List()
  override val armorProficiencies = List() // Mountain Dwarf only
  override val toolsForProficiency = List()
  override val abilityAdjustments: List[AbilityAdjustment] = createDragonbornAbilityAdjustments()
  override val racialAbilities: List[RacialAbilitiy] = createDragonbornRacialAbilities()
  override val languages = List(Dnd5LanguagesEnum.Common, Dnd5LanguagesEnum.Draconic)

  private def createDragonbornAbilityAdjustments() = {
    val strAdjust = new AbilityAdjustment(DndAbilitiesEnum.Strength, 2)
    val chaAdjust = new AbilityAdjustment(DndAbilitiesEnum.Charisma, 1)
    List(strAdjust, chaAdjust)
  }

  private def createDragonbornRacialAbilities() ={
    val ancestry = new RacialAbilitiy("Draconic Ancestry",
      "You have draconic ancestry.  Choose one type of dragon from the Draconic Ancestry " +
    "table on page 34 of the 'Player's Handbook'.  Your breath weapon and damage resistance are " +
    "determined by the dragon type, as shown in the table.")

    val breath = new RacialAbilitiy("Breath Weapon",
      "You can use your action to exhale destructive energy. Your draconic ancestry determines the " +
        "size, shape, and damage type of the exhalation. When you use your breath weapon, each creature in the " +
        "area of the exhalation must make a saving throw, the type of which is determined by your draconic ancestry. " +
        "The DC for this saving throw equals 8 + your Constitution modifier + your proficiency bonus. A creature " +
        "takes 2d6 damage on a failed save, and half as much damage on a successful one. The damage increases to 3d6 "+
        "at 6th level, 4d6 at 11th level, and 5d6 at 16th level. After you use your breath weapon, you can’t use it " +
        "again until you complete a short or long rest. ")

    val resistance = new RacialAbilitiy("Damage Resistance",
      "You have resistance to the damage type associated with your draconic ancestry.")

    List(ancestry, breath, resistance)
  }
}
