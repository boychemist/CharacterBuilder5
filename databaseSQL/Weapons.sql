drop table if exists weapons;
drop table if exists damage_type;
drop table if exists weapon_type;

create table weapon_type (wtype_id int identity(0), type char(22));
insert into weapon_type(type) values ('Simple Melee Weapons');
insert into weapon_type(type) values ('Simple Ranged Weapons');
insert into weapon_type(type) values ('Martial Melee Weapons');
insert into weapon_type(type) values ('Martial Ranged Weapons');

create table damage_type (damage_type_id int identity(0), type char(12) not null);
insert into damage_type(type) values ('bludgeoning');
insert into damage_type(type) values ('piercing');
insert into damage_type(type) values ('slashing');
insert into damage_type(type) values ('---');

create table weapons (
  weapon_id int identity(0),
  name char(20) not null unique,
  weapon_type_id int not null,
  damage_type_id int not null,
  damage_amount char(5) not null,
  weight float not null,
  properties char(60) not null,
  foreign key (weapon_type_id) references weapon_type(wtype_id),
  foreign key (damage_type_id)references damage_type(damage_type_id),
);

insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Club', 0, 0, '1d4', 2, 'Light');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Dagger', 0, 1, '1d4', 2, 'Finesse, light, thrown(range 20/60)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Greatclub', 0, 0, '1d8', 10, 'Two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Handaxe', 0, 2, '1d6', 2, 'Light, thrown(20/60)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Javelin', 0, 1, '1d6', 2, 'Thrown (range 30/120)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Light hammer', 0, 0, '1d4', 2, 'Light, thrown(range 20/60)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Mace', 0, 0, '1d6', 4, '---');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Quarterstaff', 0, 0, '1d6', 4, 'Versatile (1d8)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Sickle', 0, 2, '1d4', 2, 'Light');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Spear', 0, 1, '1d6', 3, 'Thrown (range 20/60), versatile (1d8)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Crossbow, light', 1, 1, '1d8', 5, 'Ammunition (range 80/320), loading, two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Dart', 1, 1, '1d4', 0.25, 'Finesse, thrown (range 20/60)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Shortbow', 1, 1, '1d6', 2, 'Ammunition (range 80/320), two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Sling', 1, 0, '1d4', 0, 'Ammunition (range 30/120)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Battleaxe', 2, 2, '1d8', 4, 'Versatile (1d10)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Flail', 2, 0, '1d8', 2, '---');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Glaive', 2, 2, '1d10', 6, 'Heavy, reach, two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Greataxe', 2, 2, '1d12', 7, 'Heavy, two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Greatsword', 2, 2, '2d6', 6, 'Heavy, two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Halberd', 2, 2, '1d10', 6, 'Heavy, reach, two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Lance', 2, 1, '1d12', 6, 'Reach, special');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Longsword', 2, 2, '1d8', 3, 'Versatile (1d10)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Maul', 2, 0, '2d6', 10, 'Heavy, two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Morningstar', 2, 1, '1d8', 4, '---');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Pike', 2, 1, '1d10', 18.0, 'Heavy, reach, two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Rapier', 2, 1, '1d8', 2, 'Finesse');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Scimitar', 2, 2, '1d6', 3, 'Finesse, light');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Shortsword', 2, 1, '1d6', 2, 'Finesse, light');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Trident', 2, 1, '1d6', 4, 'Thrown (range 20/60), versatile (1d8)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('War pick', 2, 1, '1d8', 2, '---');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Warhammer', 2, 0, '1d8', 2, 'Versatile (1d10)');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Whip', 2, 2, '1d4', 3, 'Finesse, reach');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Blowgun', 3, 1, '1', 1, 'Ammunition (range 25, 100), loading');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Crossbow, hand', 3, 1, '1d6', 3, 'Ammunition (range 30/120), light, loading');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Crossbow, heavy', 3, 1, '1d10', 18, 'Ammunition (range 100/400), heavy, loading, two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Longbow', 3, 1, '1d8', 2, 'Ammunition (range 150/600), heavy, two-handed');
insert into weapons (name, weapon_type_id, damage_type_id, damage_amount, weight, properties)
   values('Net', 3, 3, '---', 3, 'Special, thrown(5/15)');

select * from weapons;
select * from weapon_type;
select * from damage_type; 