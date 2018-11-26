package org.boychemist.characterbuilder5.db

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
  lazy val schema: profile.SchemaDescription = Classes.schema ++ Races.schema ++ SpecFeatures.schema ++ Specializations.schema
  @deprecated("Use .schema instead of .ddl", "3.0")
  def ddl = schema

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
    def ? = (Rep.Some(classId), name).shaped.<>({r=>import r._; _1.map(_=> ClassesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column CLASS_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val classId: Rep[Int] = column[Int]("CLASS_ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(CHAR), Length(9,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(9,varying=false))
  }
  /** Collection-like TableQuery object for table Classes */
  lazy val Classes = new TableQuery(tag => new Classes(tag))

  /** Entity class storing rows of table Races
    *  @param raceId Database column RACE_ID SqlType(INTEGER), AutoInc, PrimaryKey
    *  @param name Database column NAME SqlType(CHAR), Length(10,false) */
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
    def ? = (Rep.Some(raceId), name).shaped.<>({r=>import r._; _1.map(_=> RacesRow.tupled((_1.get, _2)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

    /** Database column RACE_ID SqlType(INTEGER), AutoInc, PrimaryKey */
    val raceId: Rep[Int] = column[Int]("RACE_ID", O.AutoInc, O.PrimaryKey)
    /** Database column NAME SqlType(CHAR), Length(10,false) */
    val name: Rep[String] = column[String]("NAME", O.Length(10,varying=false))
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
    def ? = (Rep.Some(sfeatId), specId, name, level, description).shaped.<>({r=>import r._; _1.map(_=> SpecFeaturesRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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
  implicit def GetResultSpecializationsRow(implicit e0: GR[Int], e1: GR[String], e3: GR[Boolean]): GR[SpecializationsRow] = GR{
    prs => import prs._
      SpecializationsRow.tupled((<<[Int], <<[Int], <<[String], <<[Boolean], <<[String]))
  }
  /** Table description of table SPECIALIZATIONS. Objects of this class serve as prototypes for rows in queries. */
  class Specializations(_tableTag: Tag) extends profile.api.Table[SpecializationsRow](_tableTag, "SPECIALIZATIONS") {
    def * = (specId, classId, name, providesSpells, description) <> (SpecializationsRow.tupled, SpecializationsRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (Rep.Some(specId), classId, name, providesSpells, description).shaped.<>({r=>import r._; _1.map(_=> SpecializationsRow.tupled((_1.get, _2, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))

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

    /** Uniqueness Index over (name) (database name CONSTRAINT_INDEX_3) */
    val index1 = index("CONSTRAINT_INDEX_3", name, unique=true)
  }
  /** Collection-like TableQuery object for table Specializations */
  lazy val Specializations = new TableQuery(tag => new Specializations(tag))
}
