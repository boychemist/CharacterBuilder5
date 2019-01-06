drop table if exists bonds;

create table bonds (
  background_id int not null,
  sequence_num int not null,
  bond char(130) not null,
  primary key (background_id, sequence_num),
  foreign key (background_id) references backgrounds (background_id)
);

/* Acolyte */
insert into bonds (background_id, sequence_num, bond)
values (0, 1, 'I would die to recover an ancient relic of my faith that was lost long ago.');
insert into bonds (background_id, sequence_num, bond)
values (0, 2, 'I will someday get revenge on the corrupt temple hierarchy who branded me a heretic.');
insert into bonds (background_id, sequence_num, bond)
values (0, 3, 'I owe my life to the priest who took me in when my parents died.');
insert into bonds (background_id, sequence_num, bond)
values (0, 4, 'Everything I do is for the common people.');
insert into bonds (background_id, sequence_num, bond)
values (0, 5, 'I will do anything to protect the temple where I served.');
insert into bonds (background_id, sequence_num, bond)
values (0, 6, 'I seek to preserve a sacred text that my enemies consider heretical and seek to destroy');

/* Charlatan */
insert into bonds (background_id, sequence_num, bond)
values (1, 1, 'I fleeced the wrong person and must work to ensure that this individual never crosses paths with me or those I care about.');
insert into bonds (background_id, sequence_num, bond)
values (1, 2, 'I owe everything to my mentor -- a horrible person who''s probably rotting in jail somewhere.');
insert into bonds (background_id, sequence_num, bond)
values (1, 3, 'Somewhere out there, I have a child who doesn''t know me.  I''m making the world better for him or her.');
insert into bonds (background_id, sequence_num, bond)
values (1, 4, 'I come from a noble family, and on day I''ll reclaim my lands and title from those who stole them from me.');
insert into bonds (background_id, sequence_num, bond)
values (1, 5, 'A powerful person killed someone I love.  Some day soon, I''ll have my revenge.');
insert into bonds (background_id, sequence_num, bond)
values (1, 6, 'I swindled and ruined a person who didn''t deserve it.  I seek to atone for my misdeeds but might never be able to forgive myself.');

/* Criminal */
insert into bonds (background_id, sequence_num, bond)
values (2, 1, 'I''m trying to pay off an old debt I owe to a generous benefactor.');
insert into bonds (background_id, sequence_num, bond)
values (2, 2, 'My ill-gotten gains go to support my family.');
insert into bonds (background_id, sequence_num, bond)
values (2, 3, 'Something important was taken from me, and I aim to steal it back.');
insert into bonds (background_id, sequence_num, bond)
values (2, 4, 'I will become the greatest thief that ever lived.');
insert into bonds (background_id, sequence_num, bond)
values (2, 5, 'I''m guilty of a terrible crime.  I hope I can redeem myself for it.');
insert into bonds (background_id, sequence_num, bond)
values (2, 6, 'Someone I loved died because of a mistake I made.  That will never happen again.');

/* Entertainer */
insert into bonds (background_id, sequence_num, bond)
values (3, 1, 'My instrument is my most treasured possession, and it reminds me of someone I love.');
insert into bonds (background_id, sequence_num, bond)
values (3, 2, 'Someone stole my precious instrument, and someday I''ll get it back.');
insert into bonds (background_id, sequence_num, bond)
values (3, 3, 'I want to be famous, whatever it takes.');
insert into bonds (background_id, sequence_num, bond)
values (3, 4, 'I idolize a hero of the old tales and measure my deeds against that person''s.');
insert into bonds (background_id, sequence_num, bond)
values (3, 5, 'I will do anything to prove myself superior to by hated rival.');
insert into bonds (background_id, sequence_num, bond)
values (3, 6, 'I would do anything for the other members of my old troupe.');

/* Folk Hero */
insert into bonds (background_id, sequence_num, bond)
values (4, 1, 'I have a family, but I have no idea where they are.  One day, I hope to see them again.');
insert into bonds (background_id, sequence_num, bond)
values (4, 2, 'I worked the land, I love the land, and I will protect the land.');
insert into bonds (background_id, sequence_num, bond)
values (4, 3, 'A proud noble once gave me a horrible beating, and I will take my revenge on any bully I encouter.');
insert into bonds (background_id, sequence_num, bond)
values (4, 4, 'My tools are symbols of my past life, and I carry them so that I will never forget my roots.');
insert into bonds (background_id, sequence_num, bond)
values (4, 5, 'I protect those who cannot protect themselves.');
insert into bonds (background_id, sequence_num, bond)
values (4, 6, 'I wish my childhood sweetheart had come with me to pursue my destiny.');

/* Guild Artisan */
insert into bonds (background_id, sequence_num, bond)
values (5, 1, 'The workshop where I learned my trade is the most important place in the world to me.');
insert into bonds (background_id, sequence_num, bond)
values (5, 2, 'I created a great work for someone, and then found them unworthy to receive it.  I''m still looking for someone worthy.');
insert into bonds (background_id, sequence_num, bond)
values (5, 3, 'I owe my guild a great debt for forging me into the person I am today.');
insert into bonds (background_id, sequence_num, bond)
values (5, 4, 'I pursue wealth to secure someone''s love.');
insert into bonds (background_id, sequence_num, bond)
values (5, 5, 'One day I will return to my guild and prove that I am the greatest artisan of them all.');
insert into bonds (background_id, sequence_num, bond)
values (5, 6, 'I will get revenge on the evil forces that destroyed my place of business and ruined my livelihood.');

/* Hermit */
insert into bonds (background_id, sequence_num, bond)
values (6, 1, 'Nothing is more important that the other members of my hermitage, order, or association.');
insert into bonds (background_id, sequence_num, bond)
values (6, 2, 'I entered seclusion to hide from the ones who might still be hunting me.  I must someday confront them.');
insert into bonds (background_id, sequence_num, bond)
values (6, 3, 'I''m still seeking the enlightenment I pursued in my seclusion, and it still eludes me.');
insert into bonds (background_id, sequence_num, bond)
values (6, 4, 'I enterend seclusion because I loved someone I could not have.');
insert into bonds (background_id, sequence_num, bond)
values (6, 5, 'Should my discovery come to light, it could bring ruin to the world.');
insert into bonds (background_id, sequence_num, bond)
values (6, 6, 'My isolation gave me great insight into a great evil that only I can destroy.');

/* Noble */
insert into bonds (background_id, sequence_num, bond)
values (7, 1, 'I will face any challenge to win the approval of my family.');
insert into bonds (background_id, sequence_num, bond)
values (7, 2, 'My house''s alliance with another noble family must be sustained at all costs.');
insert into bonds (background_id, sequence_num, bond)
values (7, 3, 'Nothing is more important than the other members of my family.');
insert into bonds (background_id, sequence_num, bond)
values (7, 4, 'I am in love with the heir of a family that my family despises.');
insert into bonds (background_id, sequence_num, bond)
values (7, 5, 'My loyalty to my sovreign is unwavering.');
insert into bonds (background_id, sequence_num, bond)
values (7, 6, 'The common folk must see me as a hero of the people.');

/* Outlander */
insert into bonds (background_id, sequence_num, bond)
values (8, 1, 'My family, clan, and tribe is the most important thing in my life, even when they are far from me.');
insert into bonds (background_id, sequence_num, bond)
values (8, 2, 'An injury to the unspoiled wilderness of my home is an injury to me.');
insert into bonds (background_id, sequence_num, bond)
values (8, 3, 'I will bring terrible wrath down on the evildoers who destroyed my homeland.');
insert into bonds (background_id, sequence_num, bond)
values (8, 4, 'I am the last of my tribe, and it is up to me to ensure their names enter legend.');
insert into bonds (background_id, sequence_num, bond)
values (8, 5, 'I suffer awful visions of a coming disaster and will do anything to prevent it.');
insert into bonds (background_id, sequence_num, bond)
values (8, 6, 'It is my duty to provide children to sustain my tribe.');

/* Sage */
insert into bonds (background_id, sequence_num, bond)
values (9, 1, 'It is my duty to protect my students.');
insert into bonds (background_id, sequence_num, bond)
values (9, 2, 'I have an ancient text that holds terrible secrets that must not fall into the wrong hands.');
insert into bonds (background_id, sequence_num, bond)
values (9, 3, 'I work to preserve a library, university, scriptorium, or monastery.');
insert into bonds (background_id, sequence_num, bond)
values (9, 4, 'My life''s work is a series of tomes related to a specific field of lore.');
insert into bonds (background_id, sequence_num, bond)
values (9, 5, 'I''ve been searching my whole life for the answer to a certain question.');
insert into bonds (background_id, sequence_num, bond)
values (9, 6, 'I sold my soul for knowledge.  I hope to do great deeds and win it back.');

/* Sailor */
insert into bonds (background_id, sequence_num, bond)
values (10, 1, 'I''m loyal to my captain first, everything else second.');
insert into bonds (background_id, sequence_num, bond)
values (10, 2, 'The ship is most important -- crewmates and captains come and go.');
insert into bonds (background_id, sequence_num, bond)
values (10, 3, 'I''ll always remember my first ship.');
insert into bonds (background_id, sequence_num, bond)
values (10, 4, 'In a harbor town, I have a paramour whose eyes nearly stole me from the sea.');
insert into bonds (background_id, sequence_num, bond)
values (10, 5, 'I was cheated out of my fair share of the profits, and I want to get my due.');
insert into bonds (background_id, sequence_num, bond)
values (10, 6, 'Ruthless pirates murdered my captain and crewmates, plundered our ship, and left me to die.  Vengence will be mine.');

/* Soldier */
insert into bonds (background_id, sequence_num, bond)
values (11, 1, 'I would still lay down my life for the people I served with.');
insert into bonds (background_id, sequence_num, bond)
values (11, 2, 'Someone saved my life on the battlefield.  To this day, I will never leave a friend behind.');
insert into bonds (background_id, sequence_num, bond)
values (11, 3, 'My honor is my life.');
insert into bonds (background_id, sequence_num, bond)
values (11, 4, 'I''ll never forget the crushing defeat my company suffered or the enemies who dealt it.');
insert into bonds (background_id, sequence_num, bond)
values (11, 5, 'Those who fight beside me are worth dying for.');
insert into bonds (background_id, sequence_num, bond)
values (11, 6, 'I fight for those who cannot fight for themselves.');

/* Urchin */
insert into bonds (background_id, sequence_num, bond)
values (12, 1, 'My town or city is my home, and I''ll fight to defend it.');
insert into bonds (background_id, sequence_num, bond)
values (12, 2, 'I sponsor an orphanage to keep others from enduring what I was forced to endure.');
insert into bonds (background_id, sequence_num, bond)
values (12, 3, 'I owe my survival to another urchin who taught me to live on the streets.');
insert into bonds (background_id, sequence_num, bond)
values (12, 4, 'I owe a debt I can never repay to the person who took pity on me.');
insert into bonds (background_id, sequence_num, bond)
values (12, 5, 'I escaped my life of poverty by robbing an important person, and I''m wanted for it.');
insert into bonds (background_id, sequence_num, bond)
values (12, 6, 'No one else should have to endure the hardships I''ve been through.');

select b.name, bo.sequence_num, bo.bond from bonds bo, backgrounds b where bo.background_id = b.background_id

/* select background_id, name from backgrounds; */


