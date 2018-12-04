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
  lazy val schema: profile.SchemaDescription = Array(AdventuringGear.schema, Armor.schema, Character.schema, CharacterClasses.schema, CharacterLanguages.schema, CharacterProficiencies.schema, CharacterSpells.schema, Classes.schema, DamageType.schema, Languages.schema, Races.schema, SpecFeatures.schema, Specializations.schema, Weapons.schema, WeaponType.schema).reduceLeft(_ ++ _)
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

  /** Entity class storing rows of table AdventuringGear
   *  @param name Database column NAME SqlType(CHAR), Length(30,false)
   *  @param weight Database column WEIGHT SqlType(DOUBLE)
   *  @param `type` Database column TYPE SqlType(CHAR), Length(14,false) */
  case class AdventuringGearRow(name: String, weight: Double, `type`: Option[String])
  /** GetResult implicit for fetching AdventuringGearRow objects using plain SQL queries */
  implicit def GetResultAdventuringGearRow(implicit e0: GR[String], e1: GR[Double], e2: GR[Option[String]]): GR[AdventuringGearRow] = GR{
    prs => import prs._
    AdventuringGearRow.tupled((<<[String], <<[Double], <<?[String]))
  }
  /** Table description of table ADVENTURING_GEAR. Objects of this class serve as prototypes for rows in queries.
   *  NOTE: The following names collided with Scala keywords and were escaped: type */
  class AdventuringGear(_tableTag: Tag) extends profile.api.Table[AdventuringGearRow](_tableTag, "ADVENTURING_GEAR") {
    def * = (name, weight, `type`) <> (AdventuringGearRow.tupled, AdventuringGearRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(name), Rep.Some(weight), `type`).shaped.<>({r=>import r._; _1.map(_=> AdventuringGearRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column NAME SqlType(CHAR), Length(30,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(30,varying=false))
    /** Database column WEIGHT SqlType(DOUBLE) */
    val weight: Rep[Double] = column[Double]("WEIGHT")
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

  /** Entity class storing rows of table Character
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER), AutoInc, PrimaryKey
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
   *  @param level Database column LEVEL SqlType(INTEGER)
   *  @param baseArmorClass Database column BASE_ARMOR_CLASS SqlType(INTEGER)
   *  @param baseSpeed Database column BASE_SPEED SqlType(INTEGER)
   *  @param copper Database column COPPER SqlType(BIGINT), Default(0)
   *  @param silver Database column SILVER SqlType(BIGINT), Default(0)
   *  @param electrum Database column ELECTRUM SqlType(BIGINT), Default(0)
   *  @param gold Database column GOLD SqlType(BIGINT), Default(0)
   *  @param platinum Database column PLATINUM SqlType(BIGINT), Default(0) */
  case class CharacterRow(characterId: Int, name: String, race: String, alignment: String, hitPointBonus: Int, strength: Int, dexterity: Int, constitution: Int, intelligence: Int, wisdom: Int, charisma: Int, initialMaxHp: Int, adjustedMaxHp: Int, currentHp: Int, level: Int, baseArmorClass: Int, baseSpeed: Int, copper: Long = 0L, silver: Long = 0L, electrum: Long = 0L, gold: Long = 0L, platinum: Long = 0L)
  /** GetResult implicit for fetching CharacterRow objects using plain SQL queries */
  implicit def GetResultCharacterRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Long]): GR[CharacterRow] = GR{
    prs => import prs._
    CharacterRow.tupled((<<[Int], <<[String], <<[String], <<[String], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Int], <<[Long], <<[Long], <<[Long], <<[Long], <<[Long]))
  }
  /** Table description of table CHARACTER. Objects of this class serve as prototypes for rows in queries. */
  class Character(_tableTag: Tag) extends profile.api.Table[CharacterRow](_tableTag, "CHARACTER") {
    def * = (characterId, name, race, alignment, hitPointBonus, strength, dexterity, constitution, intelligence, wisdom, charisma, initialMaxHp, adjustedMaxHp, currentHp, level, baseArmorClass, baseSpeed, copper, silver, electrum, gold, platinum) <> (CharacterRow.tupled, CharacterRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(name), Rep.Some(race), Rep.Some(alignment), Rep.Some(hitPointBonus), Rep.Some(strength), Rep.Some(dexterity), Rep.Some(constitution), Rep.Some(intelligence), Rep.Some(wisdom), Rep.Some(charisma), Rep.Some(initialMaxHp), Rep.Some(adjustedMaxHp), Rep.Some(currentHp), Rep.Some(level), Rep.Some(baseArmorClass), Rep.Some(baseSpeed), Rep.Some(copper), Rep.Some(silver), Rep.Some(electrum), Rep.Some(gold), Rep.Some(platinum)).shaped.<>({r=>import r._; _1.map(_=> CharacterRow.tupled((_1.get, _2.get, _3.get, _4.get, _5.get, _6.get, _7.get, _8.get, _9.get, _10.get, _11.get, _12.get, _13.get, _14.get, _15.get, _16.get, _17.get, _18.get, _19.get, _20.get, _21.get, _22.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID", O.AutoInc, O.PrimaryKey)
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
    /** Database column LEVEL SqlType(INTEGER) */
    val level: Rep[Int] = column[Int]("LEVEL")
    /** Database column BASE_ARMOR_CLASS SqlType(INTEGER) */
    val baseArmorClass: Rep[Int] = column[Int]("BASE_ARMOR_CLASS")
    /** Database column BASE_SPEED SqlType(INTEGER) */
    val baseSpeed: Rep[Int] = column[Int]("BASE_SPEED")
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

    /** Uniqueness Index over (name) (database name CONSTRAINT_INDEX_35) */
    val index1 = index("CONSTRAINT_INDEX_35", name, unique=true)
  }
  /** Collection-like TableQuery object for table Character */
  lazy val Character = new TableQuery(tag => new Character(tag))

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

    /** Primary key of CharacterClasses (database name CONSTRAINT_64) */
    val pk = primaryKey("CONSTRAINT_64", (characterId, classId))

    /** Foreign key referencing Character (database name CONSTRAINT_64F) */
    lazy val characterFk = foreignKey("CONSTRAINT_64F", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterClasses */
  lazy val CharacterClasses = new TableQuery(tag => new CharacterClasses(tag))

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

    /** Primary key of CharacterLanguages (database name CONSTRAINT_7) */
    val pk = primaryKey("CONSTRAINT_7", (characterId, languageId))

    /** Foreign key referencing Character (database name CONSTRAINT_75) */
    lazy val characterFk = foreignKey("CONSTRAINT_75", characterId, Character)(r => r.characterId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing Languages (database name CONSTRAINT_753) */
    lazy val languagesFk = foreignKey("CONSTRAINT_753", languageId, Languages)(r => r.langId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
  }
  /** Collection-like TableQuery object for table CharacterLanguages */
  lazy val CharacterLanguages = new TableQuery(tag => new CharacterLanguages(tag))

  /** Entity class storing rows of table CharacterProficiencies
   *  @param characterId Database column CHARACTER_ID SqlType(INTEGER)
   *  @param proficiency Database column PROFICIENCY SqlType(CHAR), Length(20,false) */
  case class CharacterProficienciesRow(characterId: Int, proficiency: String)
  /** GetResult implicit for fetching CharacterProficienciesRow objects using plain SQL queries */
  implicit def GetResultCharacterProficienciesRow(implicit e0: GR[Int], e1: GR[String]): GR[CharacterProficienciesRow] = GR{
    prs => import prs._
    CharacterProficienciesRow.tupled((<<[Int], <<[String]))
  }
  /** Table description of table CHARACTER_PROFICIENCIES. Objects of this class serve as prototypes for rows in queries. */
  class CharacterProficiencies(_tableTag: Tag) extends profile.api.Table[CharacterProficienciesRow](_tableTag, "CHARACTER_PROFICIENCIES") {
    def * = (characterId, proficiency) <> (CharacterProficienciesRow.tupled, CharacterProficienciesRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(characterId), Rep.Some(proficiency)).shaped.<>({r=>import r._; _1.map(_=> CharacterProficienciesRow.tupled((_1.get, _2.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CHARACTER_ID SqlType(INTEGER) */
    val characterId: Rep[Int] = column[Int]("CHARACTER_ID")
    /** Database column PROFICIENCY SqlType(CHAR), Length(20,false) */
    val proficiency: Rep[String] = column[String]("PROFICIENCY", O.Length(20,varying=false))

    /** Primary key of CharacterProficiencies (database name CONSTRAINT_F3) */
    val pk = primaryKey("CONSTRAINT_F3", (characterId, proficiency))

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

    /** Foreign key referencing Specializations (database name CONSTRAINT_EF) */
    lazy val specializationsFk = foreignKey("CONSTRAINT_EF", specId, Specializations)(r => r.specId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
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

    /** Foreign key referencing DamageType (database name CONSTRAINT_73B60) */
    lazy val damageTypeFk = foreignKey("CONSTRAINT_73B60", damageTypeId, DamageType)(r => r.damageTypeId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)
    /** Foreign key referencing WeaponType (database name CONSTRAINT_73B6) */
    lazy val weaponTypeFk = foreignKey("CONSTRAINT_73B6", weaponTypeId, WeaponType)(r => r.wtypeId, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Restrict)

    /** Uniqueness Index over (name) (database name CONSTRAINT_INDEX_73) */
    val index1 = index("CONSTRAINT_INDEX_73", name, unique=true)
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
