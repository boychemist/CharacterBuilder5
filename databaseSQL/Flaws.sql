drop table if exists flaws;

create table flaws (
  background_id int not null,
  sequence_num int not null,
  flaw char(130) not null,
  primary key (background_id, sequence_num),
  foreign key (background_id) references backgrounds (background_id)
);

/* Acolyte */
insert into flaws (background_id, sequence_num, flaw)
values (0, 1, 'I judge other harshly, and myself even more severely.');
insert into flaws (background_id, sequence_num, flaw)
values (0, 2, 'I put too much trust in those who wield power within my temple''s hierarchy.');
insert into flaws (background_id, sequence_num, flaw)
values (0, 3, 'My piety sometimes leads me to blindly trust those that profess faith in my god.');
insert into flaws (background_id, sequence_num, flaw)
values (0, 4, 'I am inflexible in my thinking.');
insert into flaws (background_id, sequence_num, flaw)
values (0, 5, 'I am suspicious of strangers and expect the worst of them.');
insert into flaws (background_id, sequence_num, flaw)
values (0, 6, 'Once I pick a goal, I become obsessed with it to the detriment of everything else in my life.');

/* Charlatan */
insert into flaws (background_id, sequence_num, flaw)
values (1, 1, 'I can''t resist a pretty face.');
insert into flaws (background_id, sequence_num, flaw)
values (1, 2, 'I''m always in debt.  I spend my ill-gotten gains on decadent luxuries faster than I bring them in.');
insert into flaws (background_id, sequence_num, flaw)
values (1, 3, 'I''m convinced that no one could ever fool me the way I fool others.');
insert into flaws (background_id, sequence_num, flaw)
values (1, 4, 'I''m too greedy for my own good.  I can''t resist taking a risk if there''s money involved.');
insert into flaws (background_id, sequence_num, flaw)
values (1, 5, 'I can''t resist swindling people who are more powerful than me.');
insert into flaws (background_id, sequence_num, flaw)
values (1, 6, 'I hate to admit it and will hate myself for it, but I''ll run and preserve my own hide if the going gets tough.');

/* Criminal */
insert into flaws (background_id, sequence_num, flaw)
values (2, 1, 'When I see something valuable, I can''t think about anything but how to steal it.');
insert into flaws (background_id, sequence_num, flaw)
values (2, 2, 'When faced with a choice between money and my friends, I usually choose the money.');
insert into flaws (background_id, sequence_num, flaw)
values (2, 3, 'If there''s a plan, I''ll forget it.  If I don''t forget it, I''ll ignore it.');
insert into flaws (background_id, sequence_num, flaw)
values (2, 4, 'I have a "tell" that reveals when I''m lying.');
insert into flaws (background_id, sequence_num, flaw)
values (2, 5, 'I turn tail and run when things look bad.');
insert into flaws (background_id, sequence_num, flaw)
values (2, 6, 'An innocent person is in prison for a crime that I committed.  I''m okay with that.');

/* Entertainer */
insert into flaws (background_id, sequence_num, flaw)
values (3, 1, 'I''ll do anything to win fame and renown.');
insert into flaws (background_id, sequence_num, flaw)
values (3, 2, 'I''m a sucker for a pretty face.');
insert into flaws (background_id, sequence_num, flaw)
values (3, 3, 'A scandal prevents me from ever going home again.  That kind of trouble seems to follow me around.');
insert into flaws (background_id, sequence_num, flaw)
values (3, 4, 'I once satirized a noble who still wants my head.  It was a mistake that I will likely repeat.');
insert into flaws (background_id, sequence_num, flaw)
values (3, 5, 'I have trouble keeping my true feelings hidden.  My sharp tongue lands me in trouble.');
insert into flaws (background_id, sequence_num, flaw)
values (3, 6, 'Despite my best efforts, I am unreliable to my friends.');

/* Folk Hero */
insert into flaws (background_id, sequence_num, flaw)
values (4, 1, 'The tyrant who rules my land will stop at nothing to see me killed.');
insert into flaws (background_id, sequence_num, flaw)
values (4, 2, 'I''m convinced of the significance of my destiny, and blind to my shortcomings and the risk of failure.');
insert into flaws (background_id, sequence_num, flaw)
values (4, 3, 'The people who knew me when I was young know my shameful secret, so I can never go home again.');
insert into flaws (background_id, sequence_num, flaw)
values (4, 4, 'I have a weakness for the vices of the city, especially hard drink.');
insert into flaws (background_id, sequence_num, flaw)
values (4, 5, 'Secretly, I believe that things would be better if I were a tyrant lording over the land.');
insert into flaws (background_id, sequence_num, flaw)
values (4, 6, 'I have trouble trusting my allies.');

/* Guild Artisan */
insert into flaws (background_id, sequence_num, flaw)
values (5, 1, 'I''ll do anything to get my hands on something rare or priceless.');
insert into flaws (background_id, sequence_num, flaw)
values (5, 2, 'I''m quick to assume that someone is trying to cheat me.');
insert into flaws (background_id, sequence_num, flaw)
values (5, 3, 'No one must ever learn that I once stole money from guild coffers.');
insert into flaws (background_id, sequence_num, flaw)
values (5, 4, 'I''m never satisfied with what I have -- I always want more.');
insert into flaws (background_id, sequence_num, flaw)
values (5, 5, 'I would kill to acquire a noble title.');
insert into flaws (background_id, sequence_num, flaw)
values (5, 6, 'I''m horribly jealous of anyone who can outshine my handiwork.  Everywhere I go, I''m surrounded by rivals.');

/* Hermit */
insert into flaws (background_id, sequence_num, flaw)
values (6, 1, 'Now that I''ve returned to the world, I enjoy its delights a little too much.');
insert into flaws (background_id, sequence_num, flaw)
values (6, 2, 'I harbor dark, bloodthirsty thoughts that my isolation and meditation failed to quell.');
insert into flaws (background_id, sequence_num, flaw)
values (6, 3, 'I am dogmatic in my thoughts and philosophy.');
insert into flaws (background_id, sequence_num, flaw)
values (6, 4, 'I let my need to win arguments overshadow friendships and harmony.');
insert into flaws (background_id, sequence_num, flaw)
values (6, 5, 'I''d risk too much to uncover a lost bit of knowledge.');
insert into flaws (background_id, sequence_num, flaw)
values (6, 6, 'I like keeping secrets and won''t share them with anyone.');

/* Noble */
insert into flaws (background_id, sequence_num, flaw)
values (7, 1, 'I secretly believe everyone is beneath me.');
insert into flaws (background_id, sequence_num, flaw)
values (7, 2, 'I hide a truly scandalous secret that could ruin my family forever.');
insert into flaws (background_id, sequence_num, flaw)
values (7, 3, 'I too often hear veiled insults and threats in every word addressed to me, and I''m quick to anger.');
insert into flaws (background_id, sequence_num, flaw)
values (7, 4, 'I have an insatiable desire for carnal pleasures.');
insert into flaws (background_id, sequence_num, flaw)
values (7, 5, 'In fact, the world does revolve around me.');
insert into flaws (background_id, sequence_num, flaw)
values (7, 6, 'By my words and actions, I often bring shame to my family.');

/* Outlander */
insert into flaws (background_id, sequence_num, flaw)
values (8, 1, 'I am too enamored of ale, wine, and other intoxicants.');
insert into flaws (background_id, sequence_num, flaw)
values (8, 2, 'There''s no room for caution in a life lived to the fullest.');
insert into flaws (background_id, sequence_num, flaw)
values (8, 3, 'I remember every insult I''ve received and nurse a silent resentment toward anyone who''s ever wronged me.');
insert into flaws (background_id, sequence_num, flaw)
values (8, 4, 'I am slow to trust members of other races, tribes, and societies.');
insert into flaws (background_id, sequence_num, flaw)
values (8, 5, 'Violence is my answer to almost any challenge.');
insert into flaws (background_id, sequence_num, flaw)
values (8, 6, 'Don''t expect me to save those who can''t save themselves.  It is nature''s way that the strong survive and the weak perish.');

/* Sage */
insert into flaws (background_id, sequence_num, flaw)
values (9, 1, 'I am easily distracted by the promise of information.');
insert into flaws (background_id, sequence_num, flaw)
values (9, 2, 'Most people scream and run when they see a demon.  I stop and take notes on its anatomy.');
insert into flaws (background_id, sequence_num, flaw)
values (9, 3, 'Unlocking an ancient mystery is worth the price of a civilization.');
insert into flaws (background_id, sequence_num, flaw)
values (9, 4, 'I overlook obvious solutions in favor of complicated ones.');
insert into flaws (background_id, sequence_num, flaw)
values (9, 5, 'I speak without really thinking through my words, invariably insulting others.');
insert into flaws (background_id, sequence_num, flaw)
values (9, 6, 'I can''t keep a secret to save my life, or anyone else''s life.');

/* Sailor */
insert into flaws (background_id, sequence_num, flaw)
values (10, 1, 'I follow orders, even if I think they''re wrong.');
insert into flaws (background_id, sequence_num, flaw)
values (10, 2, 'I''ll say anything to avoid having to do extra work.');
insert into flaws (background_id, sequence_num, flaw)
values (10, 3, 'Once someone questions my courage, I never back down no matter how dangerous the situation.');
insert into flaws (background_id, sequence_num, flaw)
values (10, 4, 'Once I start drinking, it''s hard for me to stop.');
insert into flaws (background_id, sequence_num, flaw)
values (10, 5, 'I can''t help but pocket loose coins and other trinkets I come across.');
insert into flaws (background_id, sequence_num, flaw)
values (10, 6, 'My pride will probably lead to my destruction.');

/* Soldier */
insert into flaws (background_id, sequence_num, flaw)
values (11, 1, 'The monstrous enemy we faced in battle still leaves me quivering with fear.');
insert into flaws (background_id, sequence_num, flaw)
values (11, 2, 'I have little respect for anyone who is not a proven warrior.');
insert into flaws (background_id, sequence_num, flaw)
values (11, 3, 'I made a terrible mistake in battle that cost many lives, and I would do anything to keep that mistake secret.');
insert into flaws (background_id, sequence_num, flaw)
values (11, 4, 'My hatred for my enemies is blind and unreasoning.');
insert into flaws (background_id, sequence_num, flaw)
values (11, 5, 'I obey the law, even if the law causes misery.');
insert into flaws (background_id, sequence_num, flaw)
values (11, 6, 'I''d rather eat my armor than admit when I''m wrong.');

/* Urchin */
insert into flaws (background_id, sequence_num, flaw)
values (12, 1, 'If I''m outnumbered, I will run away from a fight.');
insert into flaws (background_id, sequence_num, flaw)
values (12, 2, 'Gold seems like a lot of money to me, and I'' do just about anything for more of it.');
insert into flaws (background_id, sequence_num, flaw)
values (12, 3, 'I will never fully trust anyone other than myself.');
insert into flaws (background_id, sequence_num, flaw)
values (12, 4, 'I''d rather kill someone in their sleep that fight fair.');
insert into flaws (background_id, sequence_num, flaw)
values (12, 5, 'It''s not stealing if I need it more that someone else.');
insert into flaws (background_id, sequence_num, flaw)
values (12, 6, 'People who can''t take care of themselves get what they deserve.');


select b.name, f.sequence_num, f.flaw from flaws f, backgrounds b where f.background_id = b.background_id

/* select background_id, name from backgrounds; */
