drop table if exists tools;

create table tools(name char(30) not null unique, weight float not null, type char(18) null);

insert into tools(name, weight, type)
  values('Alchemist''s supplies', 8, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Brewer''s supplies', 9, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Calligrapher''s supplies', 5, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Carpenter''s tools', 6, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Cartographer''s tools', 6, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Cobbler''s tools', 5, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Cook''s utensils', 8, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Glassblower''s tools', 5, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Jeweler''s tools', 2, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Leatherworker''s tools', 5, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Mason''s tools', 8, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Painter''s supplies', 5, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Potter''s tools', 3, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Smith''s tools', 8, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Tinker''s tools', 10, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Weaver''s tools', 5, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Woodcarver''s tools', 5, 'Artisan''s tools');
insert into tools(name, weight, type)
  values('Dice set', 0.05, 'Gaming set');
insert into tools(name, weight, type)
  values('Dragonchess set', 0.5, 'Gaming set');
insert into tools(name, weight, type)
  values('Playing card set', 0.05, 'Gaming set');
insert into tools(name, weight, type)
  values('Three-Dragon Ante set', 0.05, 'Gaming set');
insert into tools(name, weight, type)
  values('Bagpipes', 6, 'Musical instrument');
insert into tools(name, weight, type)
  values('Drum', 3, 'Musical instrument');
insert into tools(name, weight, type)
  values('Dulcimer', 10, 'Musical instrument');
insert into tools(name, weight, type)
  values('Flute', 1, 'Musical instrument');
insert into tools(name, weight, type)
  values('Lute', 2, 'Musical instrument');
insert into tools(name, weight, type)
  values('Lyre', 2, 'Musical instrument');
insert into tools(name, weight, type)
  values('Horn', 2, 'Musical instrument');
insert into tools(name, weight, type)
  values('Pan flute', 2, 'Musical instrument');
insert into tools(name, weight, type)
  values('Shawm', 1, 'Musical instrument');
insert into tools(name, weight, type)
  values('Viol', 1, 'Musical instrument');
insert into tools(name, weight)
  values('Disguise kit', 3);
insert into tools(name, weight)
  values('Forgery kit', 5);
insert into tools(name, weight)
  values('Herbalism kit', 3);
insert into tools(name, weight)
  values('Navigator''s tools', 2);
insert into tools(name, weight)
  values('Poisoner''s tools', 2);
insert into tools(name, weight)
  values('Thieves'' tools', 1);
  
select * from tools;