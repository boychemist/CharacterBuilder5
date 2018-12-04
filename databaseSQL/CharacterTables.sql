/* Define the tables needed to define and track a character description */
drop table if exists character_spells;
drop table if exists character_languages;
drop table if exists character_classes;
drop table if exists character_proficiencies;
drop table if exists character;
create table character(
   character_id int identity(0),
   name char(30) unique not null,
   race char(18) not null,
   alignment char(30) not null,
   hit_point_bonus int not null, // Hill Dwarf only
   strength int not null,
   dexterity int not null,
   constitution int not null,
   intelligence int not null,
   wisdom int not null,
   charisma int not null,
   initial_max_hp int not null,
   adjusted_max_hp int not null,
   current_hp int not null,
   level int not null,
   base_armor_class int not null,
   base_speed int not null,
   copper bigint not null default 0,
   silver bigint not null default 0,
   electrum bigint not null default 0,
   gold bigint not null default 0,
   platinum bigint not null default 0
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
   proficiency char(20) not null,
   foreign key (character_id) references character(character_id),
   primary key (character_id, proficiency)
);
