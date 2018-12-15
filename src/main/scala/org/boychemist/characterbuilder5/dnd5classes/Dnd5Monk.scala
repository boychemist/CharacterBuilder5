package org.boychemist.characterbuilder5.dnd5classes

import org.boychemist.characterbuilder5._
import org.boychemist.characterbuilder5.dnd5classes.specializations._

import scala.collection.mutable.{TreeMap => mTreeMap}
import scala.collection.immutable.TreeMap

object Dnd5Monk extends Dnd5BasicClass {
  val classID: Dnd5ClassesEnum.Value = Dnd5ClassesEnum.Monk
  // the class level at which a character must choose to specialize, ranges from 1 to 3
  val specializationStartLevel: Int = 3
  val hitDice: String = "1d8"
  val armorProficiencies: List[String] = List()
  val weaponProficiencies: List[String] = List("Simple weapons", "Shortswords")
  val toolProficiencies: List[String] = List("Choose one type of artisan's tools or one musical instrument")
  val savingThrowProficiencies: List[DndAbilitiesEnum.Value] =
    List(DndAbilitiesEnum.Strength, DndAbilitiesEnum.Dexterity)
  val skillChoices: List[String] = List("Acrobatics", "Athletics", "History", "Insight",
    "Religion", "Stealth")
  val numberOfSkills: Int = 2
  val features: Map[Int, List[ClassFeature]] = creatMonkClassFeatures()
  override val specializationName: String = "Monastic Tradition"

  def getMartialArtsHitDie(classLevel: Int): String = {
    if (classLevel < 5)
      "1d4"
    else if (classLevel < 11)
      "1d6"
    else if (classLevel < 17)
      "1d8"
    else
      "1d10"
  }

  def getKiPointsForLevel(classLevel: Int): Int = {
    if (classLevel == 1)
      0
    else
      classLevel
  }

  def getMovementBonus(classLevel: Int): Int = {
    if (classLevel == 1)
      0
    else if (classLevel < 6)
      10
    else if (classLevel < 10)
      15
    else if (classLevel < 14)
      20
    else if (classLevel < 18)
      25
    else
      30
  }

  private def creatMonkClassFeatures(): Map[Int, List[ClassFeature]] = {
    var workingMap = new mTreeMap[Int, List[ClassFeature]]()
    // Level 1
    val defense = new ClassFeature("Unarmored Defense",
      "Beginning at 1st level, while you are wearing no armor and not wielding a shield, your AC " +
    "equals 10 + your Dexterity modifier + your Wisdom modifier.")
    val martial = new ClassFeature("Martial Arts",
      "At 1st level, your practice of martial arts gives you mastery of combat styles that use " +
    "unarmed strikes and monk weapons, which are shortswords and any simple melee weapons that don't have " +
    "the two-handed or heavy property.\n" +
    "You gain the following benefits while you are unarmed or wielding monk weapons and you aren't wearing " +
    "armor or wielding a shield:\n\n" +
    "\t* You can use Desterity instead of Strength for the attack and damage rolls\n" +
    "\t  of your unarmed strikes and monk weapons.\n" +
    "\t* You can rolla d4 in place of the normal damage of your unarmed strike or\n" +
    "\t  monk weapon.  This die changes as you gain monk levels, as shown in the\n" +
    "\t  Martial Arts column of the Monk table.\n" +
    "\t* When you use the Attack action with an unarmed strike or a monk weapon on\n" +
    "\t  your turn, you can make one unarmed strike as a bonus action.  For example,\n" +
    "\t  if you take the Attack action and attack with a quarterstaff, you can also make\n" +
    "\t  an unarmed strike as a bonus action, assuming you haven't already taken a bonus\n" +
    "\t  action this turn.\n\n" +
    "Certain monasteries use specialize forms of the monk weapons.  For example, you might use a club that is two " +
    "lengths of wood connected by a short chain (called a nunchaku) or a sickle with a shorter, straighter blade " +
    "(called a kama).  Whatever name you use for a monk weapon, you can use the game statistics provided for the " +
    "weapon in chapter 5, \"Equipment\" of the Player's Handbook.")
    workingMap(1) = List(defense, martial)
    // Level 2
    val ki = new ClassFeature("Ki",
    "Starting at 2nd level, your training allows you to harness the mystic energy of ki.  You access " +
    "to this energy is represented by a number of ki points.  Your monk level determines the number of points you " +
    "have, as shown in the Ki Points column of the Monk table.\n" +
    "You can spend these points to fuel various ki features.  You start knowing three such features:  Flurry of " +
    "Blows, Patient Defense, and Step of the Wind.  You learn more ki features as you gain levels in this class.\n" +
    "When you spend a ki point, it is unavailable until you finish a short or long rest, at the end of which you " +
    "draw all of your expended ki back into yourself.  You must spend at least 30 minutes of the rest meditating " +
    "to regain your ki points.\n" +
    "Some of your ki features require your target to make a saving throw to resist the feature's effects.  The " +
    "saving throw DC is calculated as follows:\n\n" +
      "\tKI SAVE DC = 8 + your proficiency bonus + your Wisdom modifier")
    val unarmored = new ClassFeature("Unarmored Movement",
    "Starting at 2nd level, your speed increases by 10 feet while your are not wearing armor or " +
    "wielding a shield.  This bonus increases when you reach certain monk levels, as shown in the Monk table\n" +
    "At 9th level you gain the ability to move along vertical surfaces and across liquids on your turn without " +
    "falling during the move.")
    workingMap(2) = List(ki, unarmored)
    // Level 3
    val deflect = new ClassFeature("Deflect Missiles",
    "When you reach 3rd level, you can use your reaction to deflect or catch the missile when you are " +
    "hit by a ranged weapon attack.  When you do so, the damage you take from the attack is reduced by 1d10 + " +
    "your Dexterity modifier + your monk level.\n\n" +
    "If you reduce the damage to 0, you can catch the missile if it is small enough for you to hold in one hand " +
    "and you have at least one hand free.  If you catch a missile in this way, you can spend 1 ki point to make a " +
    "ranged attack with the weapon or piece of ammunition you just caught, as part of the same reaction.  You " +
    "make the attack with proficiency, regardless of your weapon proficiencies, and the missile counts as a monk " +
    "weapon for this attack, which has a normal range of 20 feet and a long range of 60 feet.")
    workingMap(3) = List(deflect)
    // Level 4
    val fall = new ClassFeature("Slow Fall",
    "Beginning at 4th level, you can use your reaction when you fall to reduce any falling damage you " +
    "take by an amount equal to five times your monk level.")
    workingMap(4) = List(fall)
    // Level 5
    val attack = new ClassFeature("Extra Attack",
    "Beginning at 5th level, you can attack twice, instead of once, whenever you take the Attack " +
    "action on your turn.")
    val stun = new ClassFeature("Stunning Strike",
      "Starting at 5th level, you can interfere with the flow of ki in an opponent's body.  When " +
    "you hit another creature with a melee weapon attack, you can spend 1 ki point to attempt a stunning strike.  " +
    "The target must succeed on a Constitution saving throw or be stunned until the end of your next turn.")
    workingMap(5) = List(attack, stun)
    // Level 6
    val empowered = new ClassFeature("Ki-Empowered Strikes",
    "Starting at 6th level, you unarmed strikes count as magical for the purpose of overcoming " +
    "resistance and immunity to nonmagical attacks and damage.")
    workingMap(6) = List(empowered)
    // Level 7
    val evasion = new ClassFeature("Evasion",
    "At 7th level, your instinctive agility lets you dodge out of the way of certain area effects, " +
    "such as a blue dragon's lightening breath or a 'fireball' spell.  When you are subjected to an effect " +
    "that allows you to make a Dexterity saving throw to take only half damage, you instead take no damage if " +
    "you succeed on the saving throw, and only half damage if you fail.")
    val stillness = new ClassFeature("Stillness of Mind",
    "Starting at 7th level, you can use your action to end one effect on yourself that is causing " +
    "you to be charmed or frightened.")
    workingMap(7) = List(evasion, stillness)
    // Level 10
    val purity = new ClassFeature("Purity of Body",
    "At 10th level, your mastery of ki flowing through you makes you immune to disease and poison.")
    workingMap(10) = List(purity)
    // Level 13
    val tongue = new ClassFeature("Tongue of the Sun and Moon",
    "Starting at 13th level, you learn to touch the ki of other minds so that you understand all " +
    "spoken languages.  Moreover, any creature that can understand a language can understand what you say.")
    workingMap(13) = List(tongue)
    // Level 14
    val diamond = new ClassFeature("Diamond Soul",
    "Beginning at 14th level, you mastery of ki grants you proficiency in all saving throws.\n" +
    "Additionally, whenever you make a saving throw and fail, you can spend 1 ki point to reroll it and take " +
    "the second result.")
    workingMap(14) = List(diamond)
    // Level 15
    val timeless = new ClassFeature("Timeless Body",
    "At 15th level, you ki sustains you so that you suffer none of the frailty of old age, and you " +
    "can't be aged magically.  You can still die of old age, however.  In addition, you no longer need food or water")
    workingMap(15) = List(timeless)
    // Level 18
    val empty = new ClassFeature("Empty Body",
    "Beginning at 18th level, you can use your action to spend 4 ki points to become invisible for 1 " +
    "minute.  During this time, you also have resistance to all damage but force damage.\n" +
    "Additionally, you can spend 8 ki points to cast the 'astral projection' spell, without needing material " +
    "components.  When you do so, you can't take any other creatures with you.")
    workingMap(18) = List(empty)
    // Level 20
    val perfect = new ClassFeature("Perfect Self",
    "At 20th level, when you roll for initiative and have no ki points remaining, you regain 4 ki points.")
    workingMap(20) = List(perfect)

    val immutableMap = TreeMap.empty[Int, List[ClassFeature]] ++ workingMap
    immutableMap
  }

}
