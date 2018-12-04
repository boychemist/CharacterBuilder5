drop table if exists languages;

create table languages (lang_id int identity(0), language char(12));
insert into languages(language) values ('Common');
insert into languages(language) values ('Dwarvish');
insert into languages(language) values ('Elvish');
insert into languages(language) values ('Giant');
insert into languages(language) values ('Gnomish');
insert into languages(language) values ('Goblin');
insert into languages(language) values ('Hafling');
insert into languages(language) values ('Orc');
insert into languages(language) values ('Abyssal');
insert into languages(language) values ('Celestial');
insert into languages(language) values ('Deep Speach');
insert into languages(language) values ('Draconic');
insert into languages(language) values ('Infernal');
insert into languages(language) values ('Primordial');
insert into languages(language) values ('Sylvan');
insert into languages(language) values ('Undercommon');

select * from languages;