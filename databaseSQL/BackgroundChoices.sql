drop table if exists background_choices;

create table background_choices(
  background_id int not null,
  sequence_num int not null,
  choice char(200) not null,
  primary key (background_id, sequence_num),
  foreign key (background_id) references backgrounds (background_id)
);

/* Acolyte -- none */
/* Charlatan */
insert into background_choices (background_id, sequence_num, choice)
values (1, 1, 'I cheat at games of chance.');
insert into background_choices (background_id, sequence_num, choice)
values (1, 2, 'I shave coins or forge documents.');
insert into background_choices (background_id, sequence_num, choice)
values (1, 3, 'I insinuate myself into people''s lives to prey on their weakness and secure their fortunes.');
insert into background_choices (background_id, sequence_num, choice)
values (1, 4, 'I put on new identities like clothes.');
insert into background_choices (background_id, sequence_num, choice)
values (1, 5, 'I run slight-of-hand cons on street corners.');
insert into background_choices (background_id, sequence_num, choice)
values (1, 6, 'I convince people that worthless junk is worth their hard-earned money.');

/* Criminal */
insert into background_choices (background_id, sequence_num, choice)
values (2, 1, 'Blackmailer');
insert into background_choices (background_id, sequence_num, choice)
values (2, 2, 'Burglar');
insert into background_choices (background_id, sequence_num, choice)
values (2, 3, 'Enforcer');
insert into background_choices (background_id, sequence_num, choice)
values (2, 4, 'Fence');
insert into background_choices (background_id, sequence_num, choice)
values (2, 5, 'Highway robber');
insert into background_choices (background_id, sequence_num, choice)
values (2, 6, 'Hired killer');
insert into background_choices (background_id, sequence_num, choice)
values (2, 7, 'Pickpocket');
insert into background_choices (background_id, sequence_num, choice)
values (2, 8, 'Smuggler');

/* Entertainer */
insert into background_choices (background_id, sequence_num, choice)
values (3, 1, 'Actor');
insert into background_choices (background_id, sequence_num, choice)
values (3, 2, 'Dancer');
insert into background_choices (background_id, sequence_num, choice)
values (3, 3, 'Fire-eater');
insert into background_choices (background_id, sequence_num, choice)
values (3, 4, 'Jester');
insert into background_choices (background_id, sequence_num, choice)
values (3, 5, 'Juggler');
insert into background_choices (background_id, sequence_num, choice)
values (3, 6, 'Instrumentalist');
insert into background_choices (background_id, sequence_num, choice)
values (3, 7, 'Poet');
insert into background_choices (background_id, sequence_num, choice)
values (3, 8, 'Singer');
insert into background_choices (background_id, sequence_num, choice)
values (3, 9, 'Storyteller');
insert into background_choices (background_id, sequence_num, choice)
values (3, 10, 'Tumbler');

/* Folk Hero */
insert into background_choices (background_id, sequence_num, choice)
values (4, 1, 'I stood up to a tyrant''s agents');
insert into background_choices (background_id, sequence_num, choice)
values (4, 2, 'I saved people during a natural disaster.');
insert into background_choices (background_id, sequence_num, choice)
values (4, 3, 'I stood alone against a terrile monster.');
insert into background_choices (background_id, sequence_num, choice)
values (4, 4, 'I stole from a corrupt merchant to help the poor.');
insert into background_choices (background_id, sequence_num, choice)
values (4, 5, 'I led a militia to figth of an invading army.');
insert into background_choices (background_id, sequence_num, choice)
values (4, 6, 'I broke into a tyrant''s castle and stole weapons to arm the people.');
insert into background_choices (background_id, sequence_num, choice)
values (4, 7, 'I trained the peasantry to use farm implements as weapons against a tyrant''s soldiers.');
insert into background_choices (background_id, sequence_num, choice)
values (4, 8, 'A lord rescinded an unpopular decree after I led a symbolic act of protest against it.');
insert into background_choices (background_id, sequence_num, choice)
values (4, 9, 'A celestial, fey, or similar creature gave me a blessingl or revealed my secret origin.');
insert into background_choices (background_id, sequence_num, choice)
values (4, 10, 'Recruited into a lord''s army, I rose to leadership and was commended for my herroism.');

/* Guild Artisan */
insert into background_choices (background_id, sequence_num, choice)
values (5, 1, 'Alchemists and apothecaries');
insert into background_choices (background_id, sequence_num, choice)
values (5, 2, 'Armorers, locksmiths, and finesmiths');
insert into background_choices (background_id, sequence_num, choice)
values (5, 3, 'Brewers, distillers, and vintners');
insert into background_choices (background_id, sequence_num, choice)
values (5, 4, 'Calligraphers, scribes, and scriveners');
insert into background_choices (background_id, sequence_num, choice)
values (5, 5, 'Carpenters, roofers, and plasterers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 6, 'Cartographers, surveyors, and chart-makers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 7, 'Cobblers and shoemakers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 8, 'Cooks and bakers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 9, 'Glassblowers and glaziers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 10, 'Jewelers and gemcutters');
insert into background_choices (background_id, sequence_num, choice)
values (5, 11, 'Leatherworkers, skinners, and tanners');
insert into background_choices (background_id, sequence_num, choice)
values (5, 12, 'Masons and stonecutters');
insert into background_choices (background_id, sequence_num, choice)
values (5, 13, 'Painters, limners, and sign-makers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 14, 'Potters and tile-makers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 15, 'Shipwrights and sailmakers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 16, 'Smiths and metal-forgers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 17, 'Tinkers, pewters, and casters');
insert into background_choices (background_id, sequence_num, choice)
values (5, 18, 'Wagon-makers and wheelwrights');
insert into background_choices (background_id, sequence_num, choice)
values (5, 19, 'Weavers and dyers');
insert into background_choices (background_id, sequence_num, choice)
values (5, 20, 'Woodcarvers, coopers, and bowyers');

/* Hermit */
insert into background_choices (background_id, sequence_num, choice)
values (6, 1, 'I was searching for personal enlightenment');
insert into background_choices (background_id, sequence_num, choice)
values (6, 2, 'I was partaking of communal living in accordance with the dictates of a religious order.');
insert into background_choices (background_id, sequence_num, choice)
values (6, 3, 'I was exiled for a crime I didn''t commit.');
insert into background_choices (background_id, sequence_num, choice)
values (6, 4, 'I retreated from society after a life-altering event.');
insert into background_choices (background_id, sequence_num, choice)
values (6, 5, 'I needed a quiet place to work on my art, litterature, music, or manifesto.');
insert into background_choices (background_id, sequence_num, choice)
values (6, 6, 'I needed to commune with nature, far from civilization.');
insert into background_choices (background_id, sequence_num, choice)
values (6, 7, 'I was the caretaker of an ancient ruin or relic.');
insert into background_choices (background_id, sequence_num, choice)
values (6, 8, 'I was a pilgrim in search of a person, place, or relic of spiritual significance.');

/* Noble -- none */
/* Outlander */
insert into background_choices (background_id, sequence_num, choice)
values (8, 1, 'Forester');
insert into background_choices (background_id, sequence_num, choice)
values (8, 2, 'Trapper');
insert into background_choices (background_id, sequence_num, choice)
values (8, 3, 'Homesteader');
insert into background_choices (background_id, sequence_num, choice)
values (8, 4, 'Guide');
insert into background_choices (background_id, sequence_num, choice)
values (8, 5, 'Exile or outcast');
insert into background_choices (background_id, sequence_num, choice)
values (8, 6, 'Bounty hunter');
insert into background_choices (background_id, sequence_num, choice)
values (8, 7, 'Pilgrim');
insert into background_choices (background_id, sequence_num, choice)
values (8, 8, 'Tribal nomad');
insert into background_choices (background_id, sequence_num, choice)
values (8, 9, 'Hunter-gatherer');
insert into background_choices (background_id, sequence_num, choice)
values (8, 10, 'Tribal marauder');

/* Sage */
insert into background_choices (background_id, sequence_num, choice)
values (9, 1, 'Alchemist');
insert into background_choices (background_id, sequence_num, choice)
values (9, 2, 'Astronomer');
insert into background_choices (background_id, sequence_num, choice)
values (9, 3, 'Discredited academic');
insert into background_choices (background_id, sequence_num, choice)
values (9, 4, 'Librarian');
insert into background_choices (background_id, sequence_num, choice)
values (9, 5, 'Professor');
insert into background_choices (background_id, sequence_num, choice)
values (9, 6, 'Researcher');
insert into background_choices (background_id, sequence_num, choice)
values (9, 7, 'Wizard''s apprentice');
insert into background_choices (background_id, sequence_num, choice)
values (9, 8, 'Scribe');

/* Sailor -- None */
/* Soldier */
insert into background_choices (background_id, sequence_num, choice)
values (11, 1, 'Officer');
insert into background_choices (background_id, sequence_num, choice)
values (11, 2, 'Scout');
insert into background_choices (background_id, sequence_num, choice)
values (11, 3, 'Infantry');
insert into background_choices (background_id, sequence_num, choice)
values (11, 4, 'Cavalry');
insert into background_choices (background_id, sequence_num, choice)
values (11, 5, 'Healer');
insert into background_choices (background_id, sequence_num, choice)
values (11, 6, 'Quartermaster');
insert into background_choices (background_id, sequence_num, choice)
values (11, 7, 'Standard bearer');
insert into background_choices (background_id, sequence_num, choice)
values (11, 8, 'Support staff (cook, blacksmith, or the like)');

/* Urchin -- None */

select b.name, c.sequence_num, c.choice from background_choices c, backgrounds b where c.background_id = b.background_id

/* select background_id, name from backgrounds; */
