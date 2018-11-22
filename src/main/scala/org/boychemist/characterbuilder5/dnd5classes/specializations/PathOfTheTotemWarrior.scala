package org.boychemist.characterbuilder5.dnd5classes.specializations

import scala.collection.mutable.HashMap

/**
  * Specialization for the Berserker class in Dungeons and Dragons 5th Edition
  */
object PathOfTheTotemWarrior extends Dnd5ClassSpecialization {
  val description: String = ""

  val features: Map[Int, List[SpecializationFeature]] = createSpecFeatures()

  private def createSpecFeatures(): Map[Int, List[SpecializationFeature]] = {

    val workingMap: HashMap[Int, List[SpecializationFeature]] = new HashMap[Int, List[SpecializationFeature]]()

    // level 3 features
    val spirit = new SpecializationFeature("Spirit Seeker",
      "Yours is the path that seeks attunement with the natural world, giving you a kinship with " +
        "beasts.  At 3rd level when you adopt this path, you gain the ability to cast the 'beast sense' and " +
        "'speak with animals' spells, but only as rituals.")
    val totem = new SpecializationFeature("Totem Spirit",
      "At 3rd level, when you adopt this path, yu choose a totem spirit and gain its feature.  " +
        "You must make or acquire a physical totem object -- an amulet or similar adornment -- that incorporates " +
        "fur or feathers, claws, teeth, or bones of the totem animal.  At your option, you also gain minor physical " +
        "attributes that are reminiscent of your totem spirit.  For example, if you have a bear totem spirit, " +
        "you might be unusually hairy and thick skinned, or if your totem spirit is the eagle, your eyes turn " +
        "bright yellow.\n\nYour totem animal might bean animal related to those listed here but more appropriate " +
        "to your homeland.  For example, you could choose a hawk or vulture in place of an eagle.\n\n" +
        "BEAR\nWhile raging, you have resistance to all damage except psychic damage.  The spirit of the bear " +
        "makes you tough enough to stand up to any punishment.\n" +
        "EAGLE\nWhile you're raging and aren't wearing heavy armor, other creatures have disadvantage on opportunity " +
        "attack rolls against you, and you can use the Dash action as a bonus action on your turn.  The spirit of the " +
        "eagle makes you into a predator who can weave through the fray with ease.\n" +
        "WOLF\nWhile you're raging, your friends have advantage on melee attack rolls against any creature within " +
        "5 feet of you that is hostile to you.  The spirit of the wolf makes you a leader of hunters.")
    workingMap(3) = List(spirit, totem)

    // level 6 feature
    val beast = new SpecializationFeature("Aspect of the Beast",
      "At 6th level, you gain a magical benefit based on the totem animal of your choice.  " +
        "You can choose the same animal you selected at 3rd level or a different one.\n\n" +
        "BEAR\nYou gain the might of a bear.  Your carrying capacity (including maximum load and maximum " +
        "lift) is doubled, and you have advantage on Strength checks made to push, pull, lift, or break objects.\n" +
        "EAGLE\nYou gain the eysight of an eagle.  You can see up to 1 mile away with no difficulty, able to discern " +
        "even fine details as though looking at something no more than 100 feet away from you.  Additionally, dim " +
        "light doesn't impose disadvantage on your Wisdom(perception) checks.\n" +
        "WOLF\nyou gain the hunting sensibilities of a wolf.  You can track other creatures while traveling at a fast " +
        "pace, you can move stealthily while traveling at a normal pace.")
    workingMap(6) = List(beast)

    // level 10 feature
    val walker = new SpecializationFeature("Spirit Walker",
      "At 10th level, you can cast the 'commune with nature' spell, but only as a ritual.  " +
        "When you do so, a spiritual version of one of the totem animals you chose for Totem Spirit or " +
        "Aspect of the Beast appears to convey the information you seek.")
    workingMap(10) = List(walker)

    // level 14 feature
    val attune = new SpecializationFeature("Totemic Attunement",
      "At 14th level, you gain a magical benefit based on a totem animal of your choice.  You " +
        "can choose the same animal you selected previously or a different one.\n\n" +
        "BEAR\nWhile you're raging, any creature withing 5 feet of that's hostile to you has disadvantage on attack " +
        "rolls against targets other than you or another character with this feature.  An enemy is immune to this " +
        "effect if it can't see or hear you or if it can't be frightened.\n" +
        "EAGLE\nWhile raging, you have a flying speed equal to your current walking speed.  This benefit works only in " +
        "short bursts; you fall if you end your turn in the air and nothing else is holding you aloft.\n" +
        "WOLF\nWhile you're raging, you can use a bonus action on your turn to knock a Large or small creature prone " +
        "when you hit it with melee weapon attack.")
    workingMap(14) = List(attune)

    workingMap.toMap
  }
}
