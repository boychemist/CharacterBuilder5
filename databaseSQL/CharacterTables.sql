/* Define the tables needed to define and track a character description */
drop table if exists character_spells;
drop table if exists character_languages;
drop table if exists character_classes;
drop table if exists character_proficiencies;
drop table if exists character_weapons;
drop table if exists character_armor;
drop table if exists character_gear;
drop table if exists character_jewels;
drop table if exists equipped_weapons;
drop table if exists equipped_armor;
drop table if exists equipped_gear;
drop table if exists character_coins;
drop table if exists character_background;

drop table if exists character;
create table character(
   name char(30) unique not null,
   race char(18) not null,
   alignment char(30) not null,
   hit_point_bonus int not null, // Hill Dwarf only has non-zero value
   strength int not null,
   dexterity int not null,
   constitution int not null,
   intelligence int not null,
   wisdom int not null,
   charisma int not null,
   initial_max_hp int not null,
   adjusted_max_hp int not null,
   current_hp int not null,
   experience_points int not null,
   check_points int not null,
   treasure_points int not null,
   level int not null,
   base_armor_class int not null,
   base_speed int not null,
   draconic_ancestry char(6) not null,
   character_id int identity(0)
);

create table character_coins(
   character_id int not null,
   copper bigint not null default 0,
   silver bigint not null default 0,
   electrum bigint not null default 0,
   gold bigint not null default 0,
   platinum bigint not null default 0,
   primary key (character_id),
   foreign key (character_id) references character(character_id),
);

create table character_classes(
   character_id int not null,
   class_id int not null,
   class_level int not null,
   class_specialization_id int null references specializations(spec_id),
   primary key (character_id, class_id),
   foreign key (character_id) references character(character_id),
   foreign key (class_id) references classes(class_id),
);

create table character_languages(
   character_id int not null,
   language_id int not null,
   primary key (character_id, language_id),
   foreign key (character_id) references character(character_id),
   foreign key (language_id) references languages(lang_id)
);

create table character_spells(
   character_id int not null,
   spell_name char(50) not null,
   spell_level int not null,
   foreign key(character_id) references character(character_id),
   primary key (character_id, spell_name)
);

create table character_proficiencies (
   character_id int not null,
   proficiency_type char(6) not null,
   proficiency char(30) not null,
   foreign key (character_id) references character(character_id),
   primary key (character_id, proficiency_type, proficiency)
);

create table character_weapons (
   character_id int not null,
   name char(30) not null,
   hit_die char(4) not null,
   weight float not null,
   to_hit_bonus int not null,
   damage_bonus int not null,
   ac_adjust int not null,
   equipped boolean not null,
   ability_adjustments char (90) not null,
   foreign key (character_id) references character(character_id)
);

create table character_armor (
   character_id int not null,
   name char(30) not null,
   armor_class int not null,
   max_dex_modifier int not null,
   stealth_disadvantabe boolean not null,
   minStrength int not null,
   to_hit_bonus int not null,
   damage_bonus int not null,
   ac_adjust int not null,
   equipped boolean not null,
   ability_adjustments char (90) not null,
   foreign key (character_id) references character(character_id)
);

create table character_gear (
   character_id int not null,
   name char(30) not null,
   weight float not null,
   to_hit_bonus int not null,
   damage_bonus int not null,
   ac_adjust int not null,
   equipped boolean not null,
   ability_adjustments char (90) not null,
   foreign key (character_id) references character(character_id)   
);

create table character_jewels (
   character_id int not null,
   name char(30) not null,
   value int not null,
   count int not null,
   primary key (character_id, name, value),
   foreign key (character_id) references character(character_id)
);

create table character_background (
   character_id int not null,
   background_id int not null,
   specialization char(100) not null,
   personality_trait char(135) not null,
   ideal char(135) not null,
   bond char(130) not null,
   flaw char(130) not null,
   foreign key (character_id) references character(character_id),
   foreign key (background_id) references backgrounds(background_id),
   primary key (character_id),
);
