drop table if exists background_details;

create table background_details(
  background_id int unique not null,
  skill_1 char(15) not null,
  skill_2 char(15) not null,
  num_languages int not null,
  tools char(100) not null,
  equipment char(256) not null,
  gold int not null,
  characteristics char(1024) not null,
  primary key (background_id),
  foreign key (background_id) references backgrounds (background_id)
);

/* Acolyte */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (0, 'Insight', 'Religion', 2, '', 'A holy symbol(a gift to you when you entered the priesthood)|A prayer book or prayer wheel|5 sticks of incense|vestments|a set of common clothes', 15, 'Acolytes are shaped by their experience in temples and other religious communities.  Their study of the history and tenents of their faith and their relationships to temples, shrines, or hierarchies affect their mannerisms and ideals.  Their flaws might be some hidden hypocrisy or heritical idea, or an ideal or bond taken to an extreme.');

/* Charlatan */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (1, 'Deception', 'Sleight Of Hand', 0, 'Disguise kit|Forgery kit', 'A fine set of clothes|A disguise kit| tools of the con of your choice (ten stoppered bottles filled with colored liquid, a set of weighted dice, a deck of marked cards, or a signet ring of an imaginary duke)', 15, 'Charlatans are colorful characters who conceal their true selves behind the masks they construct.  They reflect what people want to see, what they want to believe, and how they see the world.  But their true selves are sometimes plagued by an uneasy conscience, an old enemy, or deep-seated trust issues.');

/* Criminal */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (2, 'Deception', 'Stealth', 0, 'One type of gaming set|Thieves'' tools', 'A crowbar|A set of dark common clothes including a hood', 15, 'Criminals might seem like villains on the surface, and many of them are villainous to the core.  But some have an abundance of endearing, if not redeeming, characteristics.  There might be honor among thieves, but criminals rarely show any respect for law or authority.');

/*Entertainer */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (3, 'Acrobatics', 'Performance', 0, 'Disguise kit|One type of musical instrument', 'A musical instrument (one of your choice)|The favor of an admirer (love letter, lock of hair, or trinket)|A costume', 15, 'Successful entertainers have to be able to capture and hold an audience''s attention, so they tend to  have flamboyant or forceful personalities.  They''re inclinedl toware the romantic and often cling to high-minded ideals about the practice of art and the appreciation of beauty.');

/* Folk Hero */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (4, 'Animal Handling', 'Survival', 0 , 'One type of artisan''s tools|Vehicles(land)',
'A set of artisan''s tools (one of your choice)|A shovel|An iron pot|A set of common clothes',
10, 'A folk hero is one of the common people, for better or worse.  Most folk heros look on their humble origins as a virtue, not a shortcoming, and their home communities remain very important to them.');

/* Guild Artisan */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (5, 'Insight', 'Persuasion', 1, 'One type of artisan''s tools', 'A set of artisan''s tools (one of your choice)|A letter of introduction from your guild|A set of traveler''s clothes', 15, 'Guild artisans are among the most ordinary people in the world -- until they set down their tools and take up an adventuring career.  They understand the value of hard work and the importance of community, but they''re vulnerable to the sins of greed and covetousness.');

/* Hermit */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (6, 'Medicine', 'Religion', 1, 'Herbalism kit', 'A scroll case stuffed full of notes from your studies or prayer|A winter blanket|A set of common clothes|A herbalism kit', 5, 'Some hermits are well suited to a life of seclusion, whereas others chafe against it and long to escape it and long for company.  Whether they embrace solitude or long to escape it, the solitary life shapes their attitudes and ideals.  A few are driven slightly mad by their years apart from society.');

/* Noble */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (7, 'History', 'Persuasion', 1, 'One type of gaming set', 'A set of fine clothes|A signet ring|A scroll of pedigree', 25, 'Nobels are born and raised to a very different lifestyle than most people ever experience, and their personalities reflect that upbringing.  A noble title comes with a plethora of bonds -- responsibilities to family, to other nobles (including the sovereign), to the people entrusted to the family''s care, or even to the title itself.  But this responsibility is often a good way to undermine a noble.');

/* Outlander */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (8, 'Athletics', 'Survival', 1, 'One type of musical instrument', 'A staff|A hunting trap|A trophy from and animal you killed|A set of traveler''s clothes', 10, 'Often considered rude and uncouth among civilized folk, outlanders have little respect for niceties of life in the cities.  The ties of tribe, clan, family, and the natural world of which they are a part are the most important bonds to most outlanders.');

/* Sage */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (9, 'Arcana', 'History', 2, '', 'A bottle of black ink|A quill|A small knife|A letter from a dead colleague posing a question you have not yet been able to answer|A set of common clothes', 10, 'Sages are defined by their extensive studies, and their characteristics reflect this life of study.  Devoted to scholarly pursuits, a sage values knowledge highly -- sometimes in its own right, sometimes as a means toward other ideals.');

/* Sailor */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (10, 'Athletics', 'Perception', 0, 'Navigator''s tools|Vehicles(water)', 'A belaying pin (club)|50 feet of silk rope, a lucky charm such as a rabbit foot or a small stone with a hole in the center (or you may roll a random trinket on the Trinkets table)|A set of common clothes', 10, 'Sailors can be a rough lot, but the responsibilities of life on a ship make them generally reliable as well.  Life aboard a ship shapes their outlook and forms their most important attachments.');

/* Solder */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (11, 'Athletics', 'Intimidation', 0, 'One type of gaming set|vehicles (land)', 'An insignia of rank|A trophy taken from a fallen enemy (a dagger, broken blade, or piece of a banner)|A set of bone dice or deck of cards|A set of common clothes', 10, 'The horrors of war combined with the rigid discipline of military service leave their mark on all soldiers, shaping their ideals, creating strong bonds, and often leaving the scarred an vulnerable to fear, shame, and hatred.');

/* Urchin */
insert into background_details (background_id, skill_1, skill_2, num_languages, tools, equipment, gold, characteristics)
values (12, 'Sleight Of Hand', 'Stealth', 0, 'Disguise kit|Thieves'' tools', 'A small knife|A map of the city you grew up in|A pet mouse|A token to remember you parents by|A set of common clothes', 10, 'Urchins are shaped by lives of desparate poverty, for good and for ill.  They tend to be driven either by a commitment to the people with whom they shared life on the street or by a burning desire to find a better life -- and maybe get some payback on all the rich people who treated them badly.');

select b.name, d.skill_1, d.skill_2, d.num_languages, d.tools, d.equipment, d.gold, d.characteristics from background_details d, backgrounds b where d.background_id = b.background_id

/* select background_id, name from backgrounds; */
