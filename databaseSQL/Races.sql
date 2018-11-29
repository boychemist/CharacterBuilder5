drop table if exists races;
create table races (race_id int identity(0), name char(20));
insert into races(name) values('Hill Dwarf');
insert into races(name) values('Mountain Dwarf');
insert into races(name) values('High Elf');
insert into races(name) values('Wood Elf');
insert into races(name) values('Drow');
insert into races(name) values('Lightfoot Halfling');
insert into races(name) values('Stout Halfling');
insert into races(name) values('Human');
insert into races(name) values('Dragonborn');
insert into races(name) values('Forest Gnome');
insert into races(name) values('Rock Gnome');
insert into races(name) values('Half-Elf');
insert into races(name) values('Half-Orc');
insert into races(name) values('Tiefling');
select * from races;
