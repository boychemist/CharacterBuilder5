package org.boychemist.characterbuilder5.dbInterface
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = slick.jdbc.H2Profile
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: slick.jdbc.JdbcProfile
  import profile.api._
  import slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import slick.jdbc.{GetResult => GR}

  /** DDL for all tables. Call .create to execute. */
  lazy val schema: profile.SchemaDescription = Array(AdventuringGear.schema, Armor.schema, BackgroundFeatures.schema, Backgrounds.schema, Character.schema, CharacterArmor.schema, CharacterClasses.schema, CharacterCoins.schema, CharacterGear.schema, CharacterJewels.schema, CharacterLanguages.schema, CharacterProficiencies.schema, CharacterSpells.schema, CharacterWeapons.schema, Classes.schema, DamageType.schema, Languages.schema, Races.schema, SpecFeatures.schema, Specializations.schema, Weapons.schema, WeaponType.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table AdventuringGear
   *  @param name Database column NAME SqlType(CHAR), Length(30,false)
   *  @param weight Database column WEIGHT SqlType(DOUBLE)
   *  @param maxNumber Database column MAX_NUMBER SqlType(INTEGER)
   *  @param `type` Database column TYPE SqlType(CHAR), Length(14,false) */
  case class AdventuringGearRow(name: String, weight: Double, maxNumber: Option[Int], `type`: Option[String])
  /** GetResult implicit for fetching AdventuringGearRow objects using plain SQL queries */
  implicit def GetResultAdventuringGearRow(implicit e0: GR[String], e1: GR[Double], e2: GR[Option[Int]], e3: GR[Option[String]]): GR[AdventuringGearRow] = GR{
    prs => import prs._
    AdventuringGearRow.tupled((<<[String], <<[Double], <<?[Int], <<?[String]))
  }
  /** Table description of table ADVENTURING_GEAR. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class AdventuringGear(_tableTag: Tag) extends profile.api.Table[AdventuringGearRow](_tableTag, "ADVENTURING_GEAR") {
    def * = (name, weight, maxNumber, `type`) <> (AdventuringGearRow.tupled, AdventuringGearRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(name), Rep.Some(weight), maxNumber, `type`).shaped.<>({r=>import r._; _1.map(_=> AdventuringGearRow.tupled((_1.get, _2.get, _3, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column NAME SqlType(CHAR), Length(30,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(30,varying=false))
    /** Database column WEIGHT SqlType(DOUBLE) */
    val weight: Rep[Double] = column[Double]("WEIGHT")
    /** Database column MAX_NUMBER SqlType(INTEGER) */
    val maxNumber: Rep[Option[Int]] = column[Option[Int]]("MAX_NUMBER")
    /** Database column TYPE SqlType(CHAR), Length(14,false)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("TYPE", O.Length(14,varying=false))

    /** Uniqueness Index over (name) (database name CONSTRAINT_INDEX_5) */
    val index1 = index("CONSTRAINT_INDEX_5", name, unique=true)
  }
  /** Collection-like TableQuery object for table AdventuringGear */
  lazy val AdventuringGear = new TableQuery(tag => new AdventuringGear(tag))

  /** Entity class storing rows of table Armor
   *  @param armor Database column ARMOR SqlType(CHAR), Length(15,false)
   *  @param `type` Database column TYPE SqlType(CHAR), Length(15,false)
   *  @param armorClass Database column ARMOR_CLASS SqlType(INTEGER)
   *  @param maxDexBonus Database column MAX_DEX_BONUS SqlType(INTEGER)
   *  @param strengthRequired Database column STRENGTH_REQUIRED SqlType(INTEGER)
   *  @param stealthDisadvantage Database column STEALTH_DISADVANTAGE SqlType(BOOLEAN)
   *  @param weight Database column WEIGHT SqlType(INTEGER) */
  case class ArmorRow(armor: String, `type`: String, armorClass: Int, maxDexBonus: Int, strengthRequired: Int, stealthDisadvantage: Boolean, weight: Int)
  /** GetResult implicit for fetching ArmorRow objects using plain SQL queries */
  implicit def GetResultArmorRow(implicit e0: GR[String], e1: GR[Int], e2: GR[Boolean]): GR[ArmorRow] = GR{
    prs => import prs._
    ArmorRow.tupled((<<[String], <<[String], <<[Int], <<[Int], <<[Int], <<[Boolean], <<[Int]))
  }
  /** Table description of table ARMOR. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class Armor(_tableTag: Tag) extends profile.api.Table[ArmorRow](_tableTag, "ARMOR") {
    def * = (armor, `type`, armorClass, maxDexBonus, strengthRequired, stealthDisadvantage, weight) <> (ArmorRow.tupled, ArmorRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(armor), Rep.Some(`type`), Rep.Some(armorClass), Rep.Some(maxDexBonus), Rep.Some(strengthRequired), Rep.Some(stealthDisadvantage), Rep.Some(weight)).shaped.<>({r=>import r._; _1.map(_=> ArmorRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column ARMOR SqlType(CHAR), Length(15,false) */
    val armor: Rep[String] = column[String]("ARMOR", O.Length(15,varying=false))
    /** Database column TYPE SqlType(CHAR), Length(15,false)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("TYPE", O.Length(15,varying=false))
    /** Database column ARMOR_CLASS SqlType(INTEGER) */
    val armorClass: Rep[Int] = column[Int]("ARMOR_CLASS")
    /** Database column MAX_DEX_BONUS SqlType(INTEGER) */
    val maxDexBonus: Rep[Int] = column[Int]("MAX_DEX_BONUS")
    /** Database column STRENGTH_REQUIRED SqlType(INTEGER) */
    val strengthRequired: Rep[Int] = column[Int]("STRENGTH_REQUIRED")
    /** Database column STEALTH_DISADVANTAGE SqlType(BOOLEAN) */
    val stealthDisadvantage: Rep[Boolean] = column[Boolean]("STEALTH_DISADVANTAGE")
    /** Database column WEIGHT SqlType(INTEGER) */
    val weight: Rep[Int] = column[Int]("WEIGHT")

    /** Uniqueness Index over (armor) (database name CONSTRAINT_INDEX_3B) */
    val index1 = index("CONSTRAINT_INDEX_3B", armor, unique=true)
  }
  /** Collection-like TableQuery object for table Armor */
  lazy val Armor = new TableQuery(tag => new Armor(tag))

  /** Entity class storing rows of table BackgroundFeatures
   *  @param name Database column NAME SqlType(CHAR), PrimaryKey, Length(50,false)
   *  @param variant Database column VARIANT SqlType(BOOLEAN)
   *  @param description Database column DESCRIPTION SqlType(CHAR), Length(1024,false)
   *  @param backgroundId Database column BACKGROUND_ID SqlType(INTEGER) */
  case class BackgroundFeaturesRow(name: String, variant: Boolean, description: String, backgroundId: Int)
  /** GetResult implicit for fetching BackgroundFeaturesRow objects using plain SQL queries */
  implicit def GetResultBackgroundFeaturesRow(implicit e0: GR[String], e1: GR[Boolean], e2: GR[Int]): GR[BackgroundFeaturesRow] = GR{
    prs => import prs._
    BackgroundFeaturesRow.tupled((<<[String], <<[Boolean], <<[String], <<[Int]))
  }
  /** Table description of table BACKGROUND_FEATURES. Objects of this class serve as prototypes for rows in queries. */
  class BackgroundFeatures(_tableTag: Tag) extends profile.api.Table[BackgroundFeaturesRow](_tableTag, "BACKGROUND_FEATURES") {
    def * = (name, variant, description, backgroundId) <> (BackgroundFeaturesRow.tupled, BackgroundFeaturesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(name), Rep.Some(variant), Rep.Some(description), Rep.Some(backgroundId)).shaped.<>({r=>import r._; _1.map(_=> BackgroundFeaturesRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column NAME SqlType(CHAR), PrimaryKey, Length(50,false) */
    val name: Rep[String] = column[String]("NAME", O.PrimaryKey, O.Length(50,varying=false))
    /** Database column VARIANT SqlType(BOOLEAN) */
    val variant: Rep[Boolean] = column[Boolean]("VARIANT")
    /** Database column DESCRIPTION SqlType(CHAR), Length(1024,false) */
    val description: Rep[String] = column[String]("DESCRIPTION", O.Length(1024,varying=false))
    /** Database column BACKGROUND_ID SqlType(INTEGER) */
    val backgroundId: Rep[Int] = column[Int]("BACKGROUND_ID")

    /** Foreign key referencing Backgrounds (database name CONSTRAINT_F261) */
    lazy val backgroundsFk = foreignKey("CONSTRAINT_F261", backgroundId, Backgrounds)(r => r.backgroundId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table BackgroundFeatures */
  lazy val BackgroundFeatures = new TableQuery(tag => new BackgroundFeatures(tag))

  /** Entity class storing rows of table Backgrounds
   *  @param backgroundId Database column BACKGROUND_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param name Database column NAME SqlType(CHAR), Length(14,false)
   *  @param description Database column DESCRIPTION SqlType(CHAR), Length(2048,false) */
  case class BackgroundsRow(backgroundId: Int, name: String, description: String)
  /** GetResult implicit for fetching BackgroundsRow objects using plain SQL queries */
  implicit def GetResultBackgroundsRow(implicit e0: GR[Int], e1: GR[String]): GR[BackgroundsRow] = GR{
    prs => import prs._
    BackgroundsRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table BACKGROUNDS. Objects of this class serve as prototypes for rows in queries. */
  class Backgrounds(_tableTag: Tag) extends profile.api.Table[BackgroundsRow](_tableTag, "BACKGROUNDS") {
    def * = (backgroundId, name, description) <> (BackgroundsRow.tupled, BackgroundsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(backgroundId), Rep.Some(name), Rep.Some(description)).shaped.<>({r=>import r._; _1.map(_=> BackgroundsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column BACKGROUND_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val backgroundId: Rep[Int] = column[Int]("BACKGROUND_ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(CHAR), Length(14,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(14,varying=false))
    /** Database column DESCRIPTION SqlType(CHAR), Length(2048,false) */
    val description: Rep[String] = column[String]("DESCRIPTION", O.Length(2048,varying=false))

    /** Uniqueness Index over (name) (database name CONSTRAINT_INDEX_E) */
    val index1 = index("CONSTRAINT_INDEX_E", name, unique=true)
  }
  /** Collection-like TableQuery object for table Backgrounds */
  lazy val Backgrounds = new TableQuery(tag => new Backgrounds(tag))

  /** Entity class storing rows of table Character
   *  @param name Database column NAME SqlType(CHAR), Length(30,false)
   *  @param race Database column RACE SqlType(CHAR), Length(18,false)
   *  @param alignment Database column ALIGNMENT SqlType(CHAR), Length(30,false)
   *  @param hitPointBonus Database column HIT_POINT_BONUS SqlType(INTEGER)
   *  @param strength Database column STRENGTH SqlType(INTEGER)
   *  @param dexterity Database column DEXTERITY SqlType(INTEGER)
   *  @param constitution Database column CONSTITUTION SqlType(INTEGER)
   *  @param intelligence Database column INTELLIGENCE SqlType(INTEGER)
   *  @param wisdom Database column WISDOM SqlType(INTEGER)
   *  @param charisma Database column CHARISMA SqlType(INTEGER)
   *  @param initialMaxHp Database column INITIAL_MAX_HP SqlType(INTEGER)
   *  @param adjustedMaxHp Database column ADJUSTED_MAX_HP SqlType(INTEGER)
   *  @param currentHp Database column CURRENT_HP SqlType(INTEGER)
   *  @param experiencePoints Database column EXPERIENCE_POINTS SqlType(INTEGER)
   *  @param checkPoints Database column CHECK_POINTS SqlType(INTEGER)
   *  @param treasurePoints Database column TREASURE_POINTS SqlType(INTEGER)
   *  @param level Database column LEVEL SqlType(INTEGER)
   *  @param baseArmorClass Database column BASE_ARMOR_CLASS SqlType(INTEGER)
   *  @param baseSpeed Database column BASE_SPEED SqlType(INTEGER)
   *  @param draconicAncestry Database column DRACONIC_ANCESTRY SqlType(CHAR), Length(6,false)
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER), AutoInc, PrimaryKey */
  case class CharacterRow(name: String, race: String, alignment: String, hitPointBonus: Int, strength: Int, dexterity: Int, constitution: Int, intelligence: Int, wisdom: Int, charisma: Int, initialMaxHp: Int, adjustedMaxHp: Int, currentHp: Int, experiencePoints: Int, checkPoints: Int, treasurePoints: Int, level: Int, baseArmorClass: Int, baseSpeed: Int, draconicAncestry: String, characterId: Int)
  /** GetResult implicit for fetching CharacterRow objects using plain SQL queries */
  implicit def GetResultCharacterRow(implicit e0: GR[String], e1: GR[Int]): GR[CharacterRow] = GR{
    prs => import prs._
    CharacterRow.tupled((<<[String], <<[String], <<[String], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[String], <<[Int]))
  }
  /** Table description of table CHARACTER. Objects of this class serve as prototypes for rows in queries. */
  class Character(_tableTag: Tag) extends profile.api.Table[CharacterRow](_tableTag, "CHARACTER") {
    def * = (name, race, alignment, hitPointBonus, strength, dexterity, constitution, intelligence, wisdom, charisma, initialMaxHp, adjustedMaxHp, currentHp, experiencePoints, checkPoints, treasurePoints, level, baseArmorClass, baseSpeed, draconicAncestry, characterId) <> (CharacterRow.tupled, CharacterRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(name), Rep.Some(race), Rep.Some(alignment), Rep.Some(hitPointBonus), Rep.Some(strength), Rep.Some(dexterity), Rep.Some(constitution), Rep.Some(intelligence), Rep.Some(wisdom), Rep.Some(charisma), Rep.Some(initialMaxHp), Rep.Some(adjustedMaxHp), Rep.Some(currentHp), Rep.Some(experiencePoints), Rep.Some(checkPoints), Rep.Some(treasurePoints), Rep.Some(level), Rep.Some(baseArmorClass), Rep.Some(baseSpeed), Rep.Some(draconicAncestry), Rep.Some(characterId)).shaped.<>({r=>import r._; _1.map(_=> CharacterRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get, _21.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column NAME SqlType(CHAR), Length(30,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(30,varying=false))
    /** Database column RACE SqlType(CHAR), Length(18,false) */
    val race: Rep[String] = column[String]("RACE", O.Length(18,varying=false))
    /** Database column ALIGNMENT SqlType(CHAR), Length(30,false) */
    val alignment: Rep[String] = column[String]("ALIGNMENT", O.Length(30,varying=false))
    /** Database column HIT_POINT_BONUS SqlType(INTEGER) */
    val hitPointBonus: Rep[Int] = column[Int]("HIT_POINT_BONUS")
    /** Database column STRENGTH SqlType(INTEGER) */
    val strength: Rep[Int] = column[Int]("STRENGTH")
    /** Database column DEXTERITY SqlType(INTEGER) */
    val dexterity: Rep[Int] = column[Int]("DEXTERITY")
    /** Database column CONSTITUTION SqlType(INTEGER) */
    val constitution: Rep[Int] = column[Int]("CONSTITUTION")
    /** Database column INTELLIGENCE SqlType(INTEGER) */
    val intelligence: Rep[Int] = column[Int]("INTELLIGENCE")
    /** Database column WISDOM SqlType(INTEGER) */
    val wisdom: Rep[Int] = column[Int]("WISDOM")
    /** Database column CHARISMA SqlType(INTEGER) */
    val charisma: Rep[Int] = column[Int]("CHARISMA")
    /** Database column INITIAL_MAX_HP SqlType(INTEGER) */
    val initialMaxHp: Rep[Int] = column[Int]("INITIAL_MAX_HP")
    /** Database column ADJUSTED_MAX_HP SqlType(INTEGER) */
    val adjustedMaxHp: Rep[Int] = column[Int]("ADJUSTED_MAX_HP")
    /** Database column CURRENT_HP SqlType(INTEGER) */
    val currentHp: Rep[Int] = column[Int]("CURRENT_HP")
    /** Database column EXPERIENCE_POINTS SqlType(INTEGER) */
    val experiencePoints: Rep[Int] = column[Int]("EXPERIENCE_POINTS")
    /** Database column CHECK_POINTS SqlType(INTEGER) */
    val checkPoints: Rep[Int] = column[Int]("CHECK_POINTS")
    /** Database column TREASURE_POINTS SqlType(INTEGER) */
    val treasurePoints: Rep[Int] = column[Int]("TREASURE_POINTS")
    /** Database column LEVEL SqlType(INTEGER) */
    val level: Rep[Int] = column[Int]("LEVEL")
    /** Database column BASE_ARMOR_CLASS SqlType(INTEGER) */
    val baseArmorClass: Rep[Int] = column[Int]("BASE_ARMOR_CLASS")
    /** Database column BASE_SPEED SqlType(INTEGER) */
    val baseSpeed: Rep[Int] = column[Int]("BASE_SPEED")
    /** Database column DRACONIC_ANCESTRY SqlType(CHAR), Length(6,false) */
    val draconicAncestry: Rep[String] = column[String]("DRACONIC_ANCESTRY", O.Length(6,varying=false))
    /** Database column CHARACTER_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID", O.AutoInc, O.PrimaryKey)

    /** Uniqueness Index over (name) (database name CONSTRAINT_INDEX_35) */
    val index1 = index("CONSTRAINT_INDEX_35", name, unique=true)
  }
  /** Collection-like TableQuery object for table Character */
  lazy val Character = new TableQuery(tag => new Character(tag))

  /** Entity class storing rows of table CharacterArmor
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER)
   *  @param name Database column NAME SqlType(CHAR), Length(30,false)
   *  @param armorClass Database column ARMOR_CLASS SqlType(INTEGER)
   *  @param maxDexModifier Database column MAX_DEX_MODIFIER SqlType(INTEGER)
   *  @param stealthDisadvantabe Database column STEALTH_DISADVANTABE SqlType(BOOLEAN)
   *  @param minstrength Database column MINSTRENGTH SqlType(INTEGER)
   *  @param toHitBonus Database column TO_HIT_BONUS SqlType(INTEGER)
   *  @param damageBonus Database column DAMAGE_BONUS SqlType(INTEGER)
   *  @param acAdjust Database column AC_ADJUST SqlType(INTEGER)
   *  @param equipped Database column EQUIPPED SqlType(BOOLEAN)
   *  @param abilityAdjustments Database column ABILITY_ADJUSTMENTS SqlType(CHAR), Length(90,false) */
  case class CharacterArmorRow(characterId: Int, name: String, armorClass: Int, maxDexModifier: Int, stealthDisadvantabe: Boolean, minstrength: Int, toHitBonus: Int, damageBonus: Int, acAdjust: Int, equipped: Boolean, abilityAdjustments: String)
  /** GetResult implicit for fetching CharacterArmorRow objects using plain SQL queries */
  implicit def GetResultCharacterArmorRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[CharacterArmorRow] = GR{
    prs => import prs._
    CharacterArmorRow.tupled((<<[Int], <<[String], <<[Int], <<[Int], <<[Boolean], <<[Int], <<[Int], <<[Int], <<[Int], <<[Boolean], <<[String]))
  }
  /** Table description of table CHARACTER_ARMOR. Objects of this class serve as prototypes for rows in queries. */
  class CharacterArmor(_tableTag: Tag) extends profile.api.Table[CharacterArmorRow](_tableTag, "CHARACTER_ARMOR") {
    def * = (characterId, name, armorClass, maxDexModifier, stealthDisadvantabe, minstrength, toHitBonus, damageBonus, acAdjust, equipped, abilityAdjustments) <> (CharacterArmorRow.tupled, CharacterArmorRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(name), Rep.Some(armorClass), Rep.Some(maxDexModifier), Rep.Some(stealthDisadvantabe), Rep.Some(minstrength), Rep.Some(toHitBonus), Rep.Some(damageBonus), Rep.Some(acAdjust), Rep.Some(equipped), Rep.Some(abilityAdjustments)).shaped.<>({r=>import r._; _1.map(_=> CharacterArmorRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER) */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID")
    /** Database column NAME SqlType(CHAR), Length(30,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(30,varying=false))
    /** Database column ARMOR_CLASS SqlType(INTEGER) */
    val armorClass: Rep[Int] = column[Int]("ARMOR_CLASS")
    /** Database column MAX_DEX_MODIFIER SqlType(INTEGER) */
    val maxDexModifier: Rep[Int] = column[Int]("MAX_DEX_MODIFIER")
    /** Database column STEALTH_DISADVANTABE SqlType(BOOLEAN) */
    val stealthDisadvantabe: Rep[Boolean] = column[Boolean]("STEALTH_DISADVANTABE")
    /** Database column MINSTRENGTH SqlType(INTEGER) */
    val minstrength: Rep[Int] = column[Int]("MINSTRENGTH")
    /** Database column TO_HIT_BONUS SqlType(INTEGER) */
    val toHitBonus: Rep[Int] = column[Int]("TO_HIT_BONUS")
    /** Database column DAMAGE_BONUS SqlType(INTEGER) */
    val damageBonus: Rep[Int] = column[Int]("DAMAGE_BONUS")
    /** Database column AC_ADJUST SqlType(INTEGER) */
    val acAdjust: Rep[Int] = column[Int]("AC_ADJUST")
    /** Database column EQUIPPED SqlType(BOOLEAN) */
    val equipped: Rep[Boolean] = column[Boolean]("EQUIPPED")
    /** Database column ABILITY_ADJUSTMENTS SqlType(CHAR), Length(90,false) */
    val abilityAdjustments: Rep[String] = column[String]("ABILITY_ADJUSTMENTS", O.Length(90,varying=false))

    /** Foreign key referencing Character (database name CONSTRAINT_BF) */
    lazy val characterFk = foreignKey("CONSTRAINT_BF", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterArmor */
  lazy val CharacterArmor = new TableQuery(tag => new CharacterArmor(tag))

  /** Entity class storing rows of table CharacterClasses
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER)
   *  @param classId Database column CLASS_ID SqlType(INTEGER)
   *  @param classLevel Database column CLASS_LEVEL SqlType(INTEGER)
   *  @param classSpecializationId Database column CLASS_SPECIALIZATION_ID SqlType(INTEGER) */
  case class CharacterClassesRow(characterId: Int, classId: Int, classLevel: Int, classSpecializationId: Option[Int])
  /** GetResult implicit for fetching CharacterClassesRow objects using plain SQL queries */
  implicit def GetResultCharacterClassesRow(implicit e0: GR[Int], e1: GR[Option[Int]]): GR[CharacterClassesRow] = GR{
    prs => import prs._
    CharacterClassesRow.tupled((<<[Int], <<[Int], <<[Int], <<?[Int]))
  }
  /** Table description of table CHARACTER_CLASSES. Objects of this class serve as prototypes for rows in queries. */
  class CharacterClasses(_tableTag: Tag) extends profile.api.Table[CharacterClassesRow](_tableTag, "CHARACTER_CLASSES") {
    def * = (characterId, classId, classLevel, classSpecializationId) <> (CharacterClassesRow.tupled, CharacterClassesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(classId), Rep.Some(classLevel), classSpecializationId).shaped.<>({r=>import r._; _1.map(_=> CharacterClassesRow.tupled((_1.get, _2.get, _3.get, _4)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER) */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID")
    /** Database column CLASS_ID SqlType(INTEGER) */
    val classId: Rep[Int] = column[Int]("CLASS_ID")
    /** Database column CLASS_LEVEL SqlType(INTEGER) */
    val classLevel: Rep[Int] = column[Int]("CLASS_LEVEL")
    /** Database column CLASS_SPECIALIZATION_ID SqlType(INTEGER) */
    val classSpecializationId: Rep[Option[Int]] = column[Option[Int]]("CLASS_SPECIALIZATION_ID")

    /** Primary key of CharacterClasses (database name CONSTRAINT_64F) */
    val pk = primaryKey("CONSTRAINT_64F", (characterId, classId))

    /** Foreign key referencing Character (database name CONSTRAINT_64FD) */
    lazy val characterFk = foreignKey("CONSTRAINT_64FD", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing Classes (database name CONSTRAINT_64FD1) */
    lazy val classesFk = foreignKey("CONSTRAINT_64FD1", classId, Classes)(r => r.classId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing Specializations (database name CONSTRAINT_64) */
    lazy val specializationsFk = foreignKey("CONSTRAINT_64", classSpecializationId, Specializations)(r => Rep.Some(r.specId), onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterClasses */
  lazy val CharacterClasses = new TableQuery(tag => new CharacterClasses(tag))

  /** Entity class storing rows of table CharacterCoins
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER), PrimaryKey
   *  @param copper Database column COPPER SqlType(BIGINT), Default(0)
   *  @param silver Database column SILVER SqlType(BIGINT), Default(0)
   *  @param electrum Database column ELECTRUM SqlType(BIGINT), Default(0)
   *  @param gold Database column GOLD SqlType(BIGINT), Default(0)
   *  @param platinum Database column PLATINUM SqlType(BIGINT), Default(0) */
  case class CharacterCoinsRow(characterId: Int, copper: Long = 0L, silver: Long = 0L, electrum: Long = 0L, gold: Long = 0L, platinum: Long = 0L)
  /** GetResult implicit for fetching CharacterCoinsRow objects using plain SQL queries */
  implicit def GetResultCharacterCoinsRow(implicit e0: GR[Int], e1: GR[Long]): GR[CharacterCoinsRow] = GR{
    prs => import prs._
    CharacterCoinsRow.tupled((<<[Int], <<[Long], <<[Long], <<[Long], <<[Long], <<[Long]))
  }
  /** Table description of table CHARACTER_COINS. Objects of this class serve as prototypes for rows in queries. */
  class CharacterCoins(_tableTag: Tag) extends profile.api.Table[CharacterCoinsRow](_tableTag, "CHARACTER_COINS") {
    def * = (characterId, copper, silver, electrum, gold, platinum) <> (CharacterCoinsRow.tupled, CharacterCoinsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(copper), Rep.Some(silver), Rep.Some(electrum), Rep.Some(gold), Rep.Some(platinum)).shaped.<>({r=>import r._; _1.map(_=> CharacterCoinsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER), PrimaryKey */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID", O.PrimaryKey)
    /** Database column COPPER SqlType(BIGINT), Default(0) */
    val copper: Rep[Long] = column[Long]("COPPER", O.Default(0L))
    /** Database column SILVER SqlType(BIGINT), Default(0) */
    val silver: Rep[Long] = column[Long]("SILVER", O.Default(0L))
    /** Database column ELECTRUM SqlType(BIGINT), Default(0) */
    val electrum: Rep[Long] = column[Long]("ELECTRUM", O.Default(0L))
    /** Database column GOLD SqlType(BIGINT), Default(0) */
    val gold: Rep[Long] = column[Long]("GOLD", O.Default(0L))
    /** Database column PLATINUM SqlType(BIGINT), Default(0) */
    val platinum: Rep[Long] = column[Long]("PLATINUM", O.Default(0L))

    /** Foreign key referencing Character (database name CONSTRAINT_C1) */
    lazy val characterFk = foreignKey("CONSTRAINT_C1", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterCoins */
  lazy val CharacterCoins = new TableQuery(tag => new CharacterCoins(tag))

  /** Entity class storing rows of table CharacterGear
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER)
   *  @param name Database column NAME SqlType(CHAR), Length(30,false)
   *  @param weight Database column WEIGHT SqlType(DOUBLE)
   *  @param toHitBonus Database column TO_HIT_BONUS SqlType(INTEGER)
   *  @param damageBonus Database column DAMAGE_BONUS SqlType(INTEGER)
   *  @param acAdjust Database column AC_ADJUST SqlType(INTEGER)
   *  @param equipped Database column EQUIPPED SqlType(BOOLEAN)
   *  @param abilityAdjustments Database column ABILITY_ADJUSTMENTS SqlType(CHAR), Length(90,false) */
  case class CharacterGearRow(characterId: Int, name: String, weight: Double, toHitBonus: Int, damageBonus: Int, acAdjust: Int, equipped: Boolean, abilityAdjustments: String)
  /** GetResult implicit for fetching CharacterGearRow objects using plain SQL queries */
  implicit def GetResultCharacterGearRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Double], e3: GR[Boolean]): GR[CharacterGearRow] = GR{
    prs => import prs._
    CharacterGearRow.tupled((<<[Int], <<[String], <<[Double], <<[Int], <<[Int], <<[Int], <<[Boolean], <<[String]))
  }
  /** Table description of table CHARACTER_GEAR. Objects of this class serve as prototypes for rows in queries. */
  class CharacterGear(_tableTag: Tag) extends profile.api.Table[CharacterGearRow](_tableTag, "CHARACTER_GEAR") {
    def * = (characterId, name, weight, toHitBonus, damageBonus, acAdjust, equipped, abilityAdjustments) <> (CharacterGearRow.tupled, CharacterGearRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(name), Rep.Some(weight), Rep.Some(toHitBonus), Rep.Some(damageBonus), Rep.Some(acAdjust), Rep.Some(equipped), Rep.Some(abilityAdjustments)).shaped.<>({r=>import r._; _1.map(_=> CharacterGearRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER) */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID")
    /** Database column NAME SqlType(CHAR), Length(30,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(30,varying=false))
    /** Database column WEIGHT SqlType(DOUBLE) */
    val weight: Rep[Double] = column[Double]("WEIGHT")
    /** Database column TO_HIT_BONUS SqlType(INTEGER) */
    val toHitBonus: Rep[Int] = column[Int]("TO_HIT_BONUS")
    /** Database column DAMAGE_BONUS SqlType(INTEGER) */
    val damageBonus: Rep[Int] = column[Int]("DAMAGE_BONUS")
    /** Database column AC_ADJUST SqlType(INTEGER) */
    val acAdjust: Rep[Int] = column[Int]("AC_ADJUST")
    /** Database column EQUIPPED SqlType(BOOLEAN) */
    val equipped: Rep[Boolean] = column[Boolean]("EQUIPPED")
    /** Database column ABILITY_ADJUSTMENTS SqlType(CHAR), Length(90,false) */
    val abilityAdjustments: Rep[String] = column[String]("ABILITY_ADJUSTMENTS", O.Length(90,varying=false))

    /** Foreign key referencing Character (database name CONSTRAINT_95) */
    lazy val characterFk = foreignKey("CONSTRAINT_95", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterGear */
  lazy val CharacterGear = new TableQuery(tag => new CharacterGear(tag))

  /** Entity class storing rows of table CharacterJewels
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER)
   *  @param name Database column NAME SqlType(CHAR), Length(30,false)
   *  @param value Database column VALUE SqlType(INTEGER)
   *  @param count Database column COUNT SqlType(INTEGER) */
  case class CharacterJewelsRow(characterId: Int, name: String, value: Int, count: Int)
  /** GetResult implicit for fetching CharacterJewelsRow objects using plain SQL queries */
  implicit def GetResultCharacterJewelsRow(implicit e0: GR[Int], e1: GR[String]): GR[CharacterJewelsRow] = GR{
    prs => import prs._
    CharacterJewelsRow.tupled((<<[Int], <<[String], <<[Int], <<[Int]))
  }
  /** Table description of table CHARACTER_JEWELS. Objects of this class serve as prototypes for rows in queries. */
  class CharacterJewels(_tableTag: Tag) extends profile.api.Table[CharacterJewelsRow](_tableTag, "CHARACTER_JEWELS") {
    def * = (characterId, name, value, count) <> (CharacterJewelsRow.tupled, CharacterJewelsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(name), Rep.Some(value), Rep.Some(count)).shaped.<>({r=>import r._; _1.map(_=> CharacterJewelsRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER) */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID")
    /** Database column NAME SqlType(CHAR), Length(30,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(30,varying=false))
    /** Database column VALUE SqlType(INTEGER) */
    val value: Rep[Int] = column[Int]("VALUE")
    /** Database column COUNT SqlType(INTEGER) */
    val count: Rep[Int] = column[Int]("COUNT")

    /** Primary key of CharacterJewels (database name CONSTRAINT_8) */
    val pk = primaryKey("CONSTRAINT_8", (characterId, name, value))

    /** Foreign key referencing Character (database name CONSTRAINT_82) */
    lazy val characterFk = foreignKey("CONSTRAINT_82", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterJewels */
  lazy val CharacterJewels = new TableQuery(tag => new CharacterJewels(tag))

  /** Entity class storing rows of table CharacterLanguages
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER)
   *  @param languageId Database column LANGUAGE_ID SqlType(INTEGER) */
  case class CharacterLanguagesRow(characterId: Int, languageId: Int)
  /** GetResult implicit for fetching CharacterLanguagesRow objects using plain SQL queries */
  implicit def GetResultCharacterLanguagesRow(implicit e0: GR[Int]): GR[CharacterLanguagesRow] = GR{
    prs => import prs._
    CharacterLanguagesRow.tupled((<<[Int], <<[Int]))
  }
  /** Table description of table CHARACTER_LANGUAGES. Objects of this class serve as prototypes for rows in queries. */
  class CharacterLanguages(_tableTag: Tag) extends profile.api.Table[CharacterLanguagesRow](_tableTag, "CHARACTER_LANGUAGES") {
    def * = (characterId, languageId) <> (CharacterLanguagesRow.tupled, CharacterLanguagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(languageId)).shaped.<>({r=>import r._; _1.map(_=> CharacterLanguagesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER) */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID")
    /** Database column LANGUAGE_ID SqlType(INTEGER) */
    val languageId: Rep[Int] = column[Int]("LANGUAGE_ID")

    /** Primary key of CharacterLanguages (database name CONSTRAINT_75) */
    val pk = primaryKey("CONSTRAINT_75", (characterId, languageId))

    /** Foreign key referencing Character (database name CONSTRAINT_753) */
    lazy val characterFk = foreignKey("CONSTRAINT_753", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing Languages (database name CONSTRAINT_7535) */
    lazy val languagesFk = foreignKey("CONSTRAINT_7535", languageId, Languages)(r => r.langId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterLanguages */
  lazy val CharacterLanguages = new TableQuery(tag => new CharacterLanguages(tag))

  /** Entity class storing rows of table CharacterProficiencies
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER)
   *  @param proficiencyType Database column PROFICIENCY_TYPE SqlType(CHAR), Length(6,false)
   *  @param proficiency Database column PROFICIENCY SqlType(CHAR), Length(30,false) */
  case class CharacterProficienciesRow(characterId: Int, proficiencyType: String, proficiency: String)
  /** GetResult implicit for fetching CharacterProficienciesRow objects using plain SQL queries */
  implicit def GetResultCharacterProficienciesRow(implicit e0: GR[Int], e1: GR[String]): GR[CharacterProficienciesRow] = GR{
    prs => import prs._
    CharacterProficienciesRow.tupled((<<[Int], <<[String], <<[String]))
  }
  /** Table description of table CHARACTER_PROFICIENCIES. Objects of this class serve as prototypes for rows in queries. */
  class CharacterProficiencies(_tableTag: Tag) extends profile.api.Table[CharacterProficienciesRow](_tableTag, "CHARACTER_PROFICIENCIES") {
    def * = (characterId, proficiencyType, proficiency) <> (CharacterProficienciesRow.tupled, CharacterProficienciesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(proficiencyType), Rep.Some(proficiency)).shaped.<>({r=>import r._; _1.map(_=> CharacterProficienciesRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER) */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID")
    /** Database column PROFICIENCY_TYPE SqlType(CHAR), Length(6,false) */
    val proficiencyType: Rep[String] = column[String]("PROFICIENCY_TYPE", O.Length(6,varying=false))
    /** Database column PROFICIENCY SqlType(CHAR), Length(30,false) */
    val proficiency: Rep[String] = column[String]("PROFICIENCY", O.Length(30,varying=false))

    /** Primary key of CharacterProficiencies (database name CONSTRAINT_F3) */
    val pk = primaryKey("CONSTRAINT_F3", (characterId, proficiencyType, proficiency))

    /** Foreign key referencing Character (database name CONSTRAINT_F) */
    lazy val characterFk = foreignKey("CONSTRAINT_F", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterProficiencies */
  lazy val CharacterProficiencies = new TableQuery(tag => new CharacterProficiencies(tag))

  /** Entity class storing rows of table CharacterSpells
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER)
   *  @param spellName Database column SPELL_NAME SqlType(CHAR), Length(50,false)
   *  @param spellLevel Database column SPELL_LEVEL SqlType(INTEGER) */
  case class CharacterSpellsRow(characterId: Int, spellName: String, spellLevel: Int)
  /** GetResult implicit for fetching CharacterSpellsRow objects using plain SQL queries */
  implicit def GetResultCharacterSpellsRow(implicit e0: GR[Int], e1: GR[String]): GR[CharacterSpellsRow] = GR{
    prs => import prs._
    CharacterSpellsRow.tupled((<<[Int], <<[String], <<[Int]))
  }
  /** Table description of table CHARACTER_SPELLS. Objects of this class serve as prototypes for rows in queries. */
  class CharacterSpells(_tableTag: Tag) extends profile.api.Table[CharacterSpellsRow](_tableTag, "CHARACTER_SPELLS") {
    def * = (characterId, spellName, spellLevel) <> (CharacterSpellsRow.tupled, CharacterSpellsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(spellName), Rep.Some(spellLevel)).shaped.<>({r=>import r._; _1.map(_=> CharacterSpellsRow.tupled((_1.get, _2.get, _3.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER) */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID")
    /** Database column SPELL_NAME SqlType(CHAR), Length(50,false) */
    val spellName: Rep[String] = column[String]("SPELL_NAME", O.Length(50,varying=false))
    /** Database column SPELL_LEVEL SqlType(INTEGER) */
    val spellLevel: Rep[Int] = column[Int]("SPELL_LEVEL")

    /** Primary key of CharacterSpells (database name CONSTRAINT_926) */
    val pk = primaryKey("CONSTRAINT_926", (characterId, spellName))

    /** Foreign key referencing Character (database name CONSTRAINT_92) */
    lazy val characterFk = foreignKey("CONSTRAINT_92", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterSpells */
  lazy val CharacterSpells = new TableQuery(tag => new CharacterSpells(tag))

  /** Entity class storing rows of table CharacterWeapons
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER)
   *  @param name Database column NAME SqlType(CHAR), Length(30,false)
   *  @param hitDie Database column HIT_DIE SqlType(CHAR), Length(4,false)
   *  @param weight Database column WEIGHT SqlType(DOUBLE)
   *  @param toHitBonus Database column TO_HIT_BONUS SqlType(INTEGER)
   *  @param damageBonus Database column DAMAGE_BONUS SqlType(INTEGER)
   *  @param acAdjust Database column AC_ADJUST SqlType(INTEGER)
   *  @param equipped Database column EQUIPPED SqlType(BOOLEAN)
   *  @param abilityAdjustments Database column ABILITY_ADJUSTMENTS SqlType(CHAR), Length(90,false) */
  case class CharacterWeaponsRow(characterId: Int, name: String, hitDie: String, weight: Double, toHitBonus: Int, damageBonus: Int, acAdjust: Int, equipped: Boolean, abilityAdjustments: String)
  /** GetResult implicit for fetching CharacterWeaponsRow objects using plain SQL queries */
  implicit def GetResultCharacterWeaponsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Double], e3: GR[Boolean]): GR[CharacterWeaponsRow] = GR{
    prs => import prs._
    CharacterWeaponsRow.tupled((<<[Int], <<[String], <<[String], <<[Double], <<[Int], <<[Int], <<[Int], <<[Boolean], <<[String]))
  }
  /** Table description of table CHARACTER_WEAPONS. Objects of this class serve as prototypes for rows in queries. */
  class CharacterWeapons(_tableTag: Tag) extends profile.api.Table[CharacterWeaponsRow](_tableTag, "CHARACTER_WEAPONS") {
    def * = (characterId, name, hitDie, weight, toHitBonus, damageBonus, acAdjust, equipped, abilityAdjustments) <> (CharacterWeaponsRow.tupled, CharacterWeaponsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(name), Rep.Some(hitDie), Rep.Some(weight), Rep.Some(toHitBonus), Rep.Some(damageBonus), Rep.Some(acAdjust), Rep.Some(equipped), Rep.Some(abilityAdjustments)).shaped.<>({r=>import r._; _1.map(_=> CharacterWeaponsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER) */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID")
    /** Database column NAME SqlType(CHAR), Length(30,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(30,varying=false))
    /** Database column HIT_DIE SqlType(CHAR), Length(4,false) */
    val hitDie: Rep[String] = column[String]("HIT_DIE", O.Length(4,varying=false))
    /** Database column WEIGHT SqlType(DOUBLE) */
    val weight: Rep[Double] = column[Double]("WEIGHT")
    /** Database column TO_HIT_BONUS SqlType(INTEGER) */
    val toHitBonus: Rep[Int] = column[Int]("TO_HIT_BONUS")
    /** Database column DAMAGE_BONUS SqlType(INTEGER) */
    val damageBonus: Rep[Int] = column[Int]("DAMAGE_BONUS")
    /** Database column AC_ADJUST SqlType(INTEGER) */
    val acAdjust: Rep[Int] = column[Int]("AC_ADJUST")
    /** Database column EQUIPPED SqlType(BOOLEAN) */
    val equipped: Rep[Boolean] = column[Boolean]("EQUIPPED")
    /** Database column ABILITY_ADJUSTMENTS SqlType(CHAR), Length(90,false) */
    val abilityAdjustments: Rep[String] = column[String]("ABILITY_ADJUSTMENTS", O.Length(90,varying=false))

    /** Foreign key referencing Character (database name CONSTRAINT_7B) */
    lazy val characterFk = foreignKey("CONSTRAINT_7B", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterWeapons */
  lazy val CharacterWeapons = new TableQuery(tag => new CharacterWeapons(tag))

  /** Entity class storing rows of table Classes
   *  @param classId Database column CLASS_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param name Database column NAME SqlType(CHAR), Length(9,false) */
  case class ClassesRow(classId: Int, name: String)
  /** GetResult implicit for fetching ClassesRow objects using plain SQL queries */
  implicit def GetResultClassesRow(implicit e0: GR[Int], e1: GR[String]): GR[ClassesRow] = GR{
    prs => import prs._
    ClassesRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table CLASSES. Objects of this class serve as prototypes for rows in queries. */
  class Classes(_tableTag: Tag) extends profile.api.Table[ClassesRow](_tableTag, "CLASSES") {
    def * = (classId, name) <> (ClassesRow.tupled, ClassesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(classId), Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> ClassesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CLASS_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val classId: Rep[Int] = column[Int]("CLASS_ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(CHAR), Length(9,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(9,varying=false))
  }
  /** Collection-like TableQuery object for table Classes */
  lazy val Classes = new TableQuery(tag => new Classes(tag))

  /** Entity class storing rows of table DamageType
   *  @param damageTypeId Database column DAMAGE_TYPE_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param `type` Database column TYPE SqlType(CHAR), Length(12,false) */
  case class DamageTypeRow(damageTypeId: Int, `type`: String)
  /** GetResult implicit for fetching DamageTypeRow objects using plain SQL queries */
  implicit def GetResultDamageTypeRow(implicit e0: GR[Int], e1: GR[String]): GR[DamageTypeRow] = GR{
    prs => import prs._
    DamageTypeRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table DAMAGE_TYPE. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class DamageType(_tableTag: Tag) extends profile.api.Table[DamageTypeRow](_tableTag, "DAMAGE_TYPE") {
    def * = (damageTypeId, `type`) <> (DamageTypeRow.tupled, DamageTypeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(damageTypeId), Rep.Some(`type`)).shaped.<>({r=>import r._; _1.map(_=> DamageTypeRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column DAMAGE_TYPE_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val damageTypeId: Rep[Int] = column[Int]("DAMAGE_TYPE_ID", O.AutoInc, O.PrimaryKey)
    /** Database column TYPE SqlType(CHAR), Length(12,false)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[String] = column[String]("TYPE", O.Length(12,varying=false))
  }
  /** Collection-like TableQuery object for table DamageType */
  lazy val DamageType = new TableQuery(tag => new DamageType(tag))

  /** Entity class storing rows of table Languages
   *  @param langId Database column LANG_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param language Database column LANGUAGE SqlType(CHAR), Length(12,false) */
  case class LanguagesRow(langId: Int, language: Option[String])
  /** GetResult implicit for fetching LanguagesRow objects using plain SQL queries */
  implicit def GetResultLanguagesRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[LanguagesRow] = GR{
    prs => import prs._
    LanguagesRow.tupled((<<[Int], <<?[String]))
  }
  /** Table description of table LANGUAGES. Objects of this class serve as prototypes for rows in queries. */
  class Languages(_tableTag: Tag) extends profile.api.Table[LanguagesRow](_tableTag, "LANGUAGES") {
    def * = (langId, language) <> (LanguagesRow.tupled, LanguagesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(langId), language).shaped.<>({r=>import r._; _1.map(_=> LanguagesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column LANG_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val langId: Rep[Int] = column[Int]("LANG_ID", O.AutoInc, O.PrimaryKey)
    /** Database column LANGUAGE SqlType(CHAR), Length(12,false) */
    val language: Rep[Option[String]] = column[Option[String]]("LANGUAGE", O.Length(12,varying=false))
  }
  /** Collection-like TableQuery object for table Languages */
  lazy val Languages = new TableQuery(tag => new Languages(tag))

  /** Entity class storing rows of table Races
   *  @param raceId Database column RACE_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param name Database column NAME SqlType(CHAR), Length(20,false) */
  case class RacesRow(raceId: Int, name: String)
  /** GetResult implicit for fetching RacesRow objects using plain SQL queries */
  implicit def GetResultRacesRow(implicit e0: GR[Int], e1: GR[String]): GR[RacesRow] = GR{
    prs => import prs._
    RacesRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table RACES. Objects of this class serve as prototypes for rows in queries. */
  class Races(_tableTag: Tag) extends profile.api.Table[RacesRow](_tableTag, "RACES") {
    def * = (raceId, name) <> (RacesRow.tupled, RacesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(raceId), Rep.Some(name)).shaped.<>({r=>import r._; _1.map(_=> RacesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column RACE_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val raceId: Rep[Int] = column[Int]("RACE_ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(CHAR), Length(20,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(20,varying=false))
  }
  /** Collection-like TableQuery object for table Races */
  lazy val Races = new TableQuery(tag => new Races(tag))

  /** Entity class storing rows of table SpecFeatures
   *  @param sfeatId Database column SFEAT_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param specId Database column SPEC_ID SqlType(INTEGER)
   *  @param name Database column NAME SqlType(CHAR), Length(50,false)
   *  @param level Database column LEVEL SqlType(INTEGER)
   *  @param description Database column DESCRIPTION SqlType(CHAR), Length(4096,false) */
  case class SpecFeaturesRow(sfeatId: Int, specId: Int, name: String, level: Int, description: String)
  /** GetResult implicit for fetching SpecFeaturesRow objects using plain SQL queries */
  implicit def GetResultSpecFeaturesRow(implicit e0: GR[Int], e1: GR[String]): GR[SpecFeaturesRow] = GR{
    prs => import prs._
    SpecFeaturesRow.tupled((<<[Int], <<[Int], <<[String], <<[Int], <<[String]))
  }
  /** Table description of table SPEC_FEATURES. Objects of this class serve as prototypes for rows in queries. */
  class SpecFeatures(_tableTag: Tag) extends profile.api.Table[SpecFeaturesRow](_tableTag, "SPEC_FEATURES") {
    def * = (sfeatId, specId, name, level, description) <> (SpecFeaturesRow.tupled, SpecFeaturesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(sfeatId), Rep.Some(specId), Rep.Some(name), Rep.Some(level), Rep.Some(description)).shaped.<>({r=>import r._; _1.map(_=> SpecFeaturesRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SFEAT_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val sfeatId: Rep[Int] = column[Int]("SFEAT_ID", O.AutoInc, O.PrimaryKey)
    /** Database column SPEC_ID SqlType(INTEGER) */
    val specId: Rep[Int] = column[Int]("SPEC_ID")
    /** Database column NAME SqlType(CHAR), Length(50,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(50,varying=false))
    /** Database column LEVEL SqlType(INTEGER) */
    val level: Rep[Int] = column[Int]("LEVEL")
    /** Database column DESCRIPTION SqlType(CHAR), Length(4096,false) */
    val description: Rep[String] = column[String]("DESCRIPTION", O.Length(4096,varying=false))
  }
  /** Collection-like TableQuery object for table SpecFeatures */
  lazy val SpecFeatures = new TableQuery(tag => new SpecFeatures(tag))

  /** Entity class storing rows of table Specializations
   *  @param specId Database column SPEC_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param classId Database column CLASS_ID SqlType(INTEGER)
   *  @param name Database column NAME SqlType(CHAR), Length(80,false)
   *  @param providesSpells Database column PROVIDES_SPELLS SqlType(BOOLEAN)
   *  @param description Database column DESCRIPTION SqlType(CHAR), Length(2048,false) */
  case class SpecializationsRow(specId: Int, classId: Int, name: String, providesSpells: Boolean, description: String)
  /** GetResult implicit for fetching SpecializationsRow objects using plain SQL queries */
  implicit def GetResultSpecializationsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Boolean]): GR[SpecializationsRow] = GR{
    prs => import prs._
    SpecializationsRow.tupled((<<[Int], <<[Int], <<[String], <<[Boolean], <<[String]))
  }
  /** Table description of table SPECIALIZATIONS. Objects of this class serve as prototypes for rows in queries. */
  class Specializations(_tableTag: Tag) extends profile.api.Table[SpecializationsRow](_tableTag, "SPECIALIZATIONS") {
    def * = (specId, classId, name, providesSpells, description) <> (SpecializationsRow.tupled, SpecializationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(specId), Rep.Some(classId), Rep.Some(name), Rep.Some(providesSpells), Rep.Some(description)).shaped.<>({r=>import r._; _1.map(_=> SpecializationsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column SPEC_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val specId: Rep[Int] = column[Int]("SPEC_ID", O.AutoInc, O.PrimaryKey)
    /** Database column CLASS_ID SqlType(INTEGER) */
    val classId: Rep[Int] = column[Int]("CLASS_ID")
    /** Database column NAME SqlType(CHAR), Length(80,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(80,varying=false))
    /** Database column PROVIDES_SPELLS SqlType(BOOLEAN) */
    val providesSpells: Rep[Boolean] = column[Boolean]("PROVIDES_SPELLS")
    /** Database column DESCRIPTION SqlType(CHAR), Length(2048,false) */
    val description: Rep[String] = column[String]("DESCRIPTION", O.Length(2048,varying=false))

    /** Foreign key referencing Classes (database name CONSTRAINT_304) */
    lazy val classesFk = foreignKey("CONSTRAINT_304", classId, Classes)(r => r.classId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)

    /** Uniqueness Index over (name) (database name CONSTRAINT_INDEX_3) */
    val index1 = index("CONSTRAINT_INDEX_3", name, unique=true)
  }
  /** Collection-like TableQuery object for table Specializations */
  lazy val Specializations = new TableQuery(tag => new Specializations(tag))

  /** Entity class storing rows of table Weapons
   *  @param weaponId Database column WEAPON_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param name Database column NAME SqlType(CHAR), Length(20,false)
   *  @param weaponTypeId Database column WEAPON_TYPE_ID SqlType(INTEGER)
   *  @param damageTypeId Database column DAMAGE_TYPE_ID SqlType(INTEGER)
   *  @param damageAmount Database column DAMAGE_AMOUNT SqlType(CHAR), Length(5,false)
   *  @param weight Database column WEIGHT SqlType(DOUBLE)
   *  @param properties Database column PROPERTIES SqlType(CHAR), Length(60,false) */
  case class WeaponsRow(weaponId: Int, name: String, weaponTypeId: Int, damageTypeId: Int, damageAmount: String, weight: Double, properties: String)
  /** GetResult implicit for fetching WeaponsRow objects using plain SQL queries */
  implicit def GetResultWeaponsRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Double]): GR[WeaponsRow] = GR{
    prs => import prs._
    WeaponsRow.tupled((<<[Int], <<[String], <<[Int], <<[Int], <<[String], <<[Double], <<[String]))
  }
  /** Table description of table WEAPONS. Objects of this class serve as prototypes for rows in queries. */
  class Weapons(_tableTag: Tag) extends profile.api.Table[WeaponsRow](_tableTag, "WEAPONS") {
    def * = (weaponId, name, weaponTypeId, damageTypeId, damageAmount, weight, properties) <> (WeaponsRow.tupled, WeaponsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(weaponId), Rep.Some(name), Rep.Some(weaponTypeId), Rep.Some(damageTypeId), Rep.Some(damageAmount), Rep.Some(weight), Rep.Some(properties)).shaped.<>({r=>import r._; _1.map(_=> WeaponsRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column WEAPON_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val weaponId: Rep[Int] = column[Int]("WEAPON_ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(CHAR), Length(20,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(20,varying=false))
    /** Database column WEAPON_TYPE_ID SqlType(INTEGER) */
    val weaponTypeId: Rep[Int] = column[Int]("WEAPON_TYPE_ID")
    /** Database column DAMAGE_TYPE_ID SqlType(INTEGER) */
    val damageTypeId: Rep[Int] = column[Int]("DAMAGE_TYPE_ID")
    /** Database column DAMAGE_AMOUNT SqlType(CHAR), Length(5,false) */
    val damageAmount: Rep[String] = column[String]("DAMAGE_AMOUNT", O.Length(5,varying=false))
    /** Database column WEIGHT SqlType(DOUBLE) */
    val weight: Rep[Double] = column[Double]("WEIGHT")
    /** Database column PROPERTIES SqlType(CHAR), Length(60,false) */
    val properties: Rep[String] = column[String]("PROPERTIES", O.Length(60,varying=false))

    /** Foreign key referencing DamageType (database name CONSTRAINT_73B6) */
    lazy val damageTypeFk = foreignKey("CONSTRAINT_73B6", damageTypeId, DamageType)(r => r.damageTypeId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing WeaponType (database name CONSTRAINT_73B) */
    lazy val weaponTypeFk = foreignKey("CONSTRAINT_73B", weaponTypeId, WeaponType)(r => r.wtypeId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)

    /** Uniqueness Index over (name) (database name CONSTRAINT_INDEX_7) */
    val index1 = index("CONSTRAINT_INDEX_7", name, unique=true)
  }
  /** Collection-like TableQuery object for table Weapons */
  lazy val Weapons = new TableQuery(tag => new Weapons(tag))

  /** Entity class storing rows of table WeaponType
   *  @param wtypeId Database column WTYPE_ID SqlType(INTEGER), AutoInc, PrimaryKey
   *  @param `type` Database column TYPE SqlType(CHAR), Length(22,false) */
  case class WeaponTypeRow(wtypeId: Int, `type`: Option[String])
  /** GetResult implicit for fetching WeaponTypeRow objects using plain SQL queries */
  implicit def GetResultWeaponTypeRow(implicit e0: GR[Int], e1: GR[Option[String]]): GR[WeaponTypeRow] = GR{
    prs => import prs._
    WeaponTypeRow.tupled((<<[Int], <<?[String]))
  }
  /** Table description of table WEAPON_TYPE. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class WeaponType(_tableTag: Tag) extends profile.api.Table[WeaponTypeRow](_tableTag, "WEAPON_TYPE") {
    def * = (wtypeId, `type`) <> (WeaponTypeRow.tupled, WeaponTypeRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(wtypeId), `type`).shaped.<>({r=>import r._; _1.map(_=> WeaponTypeRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column WTYPE_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val wtypeId: Rep[Int] = column[Int]("WTYPE_ID", O.AutoInc, O.PrimaryKey)
    /** Database column TYPE SqlType(CHAR), Length(22,false)
     *  NOTE: The name was escaped because it collided with a Scala keyword. */
    val `type`: Rep[Option[String]] = column[Option[String]]("TYPE", O.Length(22,varying=false))
  }
  /** Collection-like TableQuery object for table WeaponType */
  lazy val WeaponType = new TableQuery(tag => new WeaponType(tag))
}
