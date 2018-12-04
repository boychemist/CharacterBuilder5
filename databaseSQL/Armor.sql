drop table if exists armor;

create table armor (
   armor char(15) not null unique,
   type char(15) not null,
   armor_class int not null,
   max_dex_bonus int not null,
   strength_required int not null,
   stealth_disadvantage boolean not null,
   weight int not null
);

insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Padded', 'Light Armor', 11, 10, 1, 'true', 8);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Leather', 'Light Armor', 11, 10, 1, 'false', 10);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Studded Leather', 'Light Armor', 12, 10, 1, 'false', 13);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Hide', 'Medium Armor', 12, 2, 1, 'false', 12);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Chain shirt', 'Medium Armor', 13, 2, 1, 'false', 20);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Scale mail', 'Medium Armor', 14, 2, 1, 'true', 45);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Breastplate', 'Medium Armor', 14, 2, 1, 'false', 20);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Half plate', 'Medium Armor', 15, 2, 1, 'true', 40);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Ring mail', 'Heavy Armor', 14, 0, 1, 'true', 40);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Chain mail', 'Heavy Armor', 16, 0, 13, 'true', 55);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Splint', 'Heavy Armor', 17, 0, 15, 'true', 60);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Plate', 'Heavy Armor', 18, 0, 15, 'true', 65);
insert into armor(armor, type, armor_class, max_dex_bonus, strength_required, stealth_disadvantage, weight)
   values ('Shield', 'Shield', 2, 0, 1, 'false', 6);

select * from armor;