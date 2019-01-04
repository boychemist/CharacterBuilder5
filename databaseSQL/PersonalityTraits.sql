drop table if exists personality_traits;

create table personality_traits(
  background_id int not null,
  sequence_num int not null,
  a_trait char(200) not null,
  primary key (background_id, sequence_num),
  foreign key (background_id) references backgrounds (background_id)
);

/* Acolyte */
insert into personality_traits (background_id, sequence_num, a_trait)
values (0, 1, 'I idolize a particular hero of my faith, and constantly refer to that person''s deeds and example.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (0, 2, 'I can find common ground between the fiercest enemies, empathizing with them and always working toward peace.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (0, 3, 'I see omens in every event and action.  The gods try to speak to us, we just need to listen.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (0, 4, 'Nothing can shake my optimistic attitude.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (0, 5, 'I quote (or misquote) sacred texts and proverbs in almost every situation.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (0, 6, 'I am tolerant (or intolerant) of other faiths and respect (or condem) the worship of other gods.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (0, 7, 'I''ve enjoyed fine food, drink, and high society among my temple''s elite.  Rough living grates on me.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (0, 8, 'I''ve spent so long in the temple that I have little practical experience dealing with people in the outside world.');

/*Charlatan */
insert into personality_traits (background_id, sequence_num, a_trait)
values (1, 1, 'I fall in and out of love easily, and am always pursuing someone.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (1, 2, 'I have a joke for every occasion, especially ocassions where humor is inappropriate.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (1, 3, 'Flattery is my perferred trick for getting what I want.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (1, 4, 'I''m a born gambler who can''t resist taking a risk for a potential payoff.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (1, 5, 'I lie about almost everything, even when there''s no good reason to.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (1, 6, 'Sarcasm and insults are my weapons of choice.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (1, 7, 'I keep multiple holy symbols on me and invoke whatever deity might come in useful at any given moment.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (1, 8, 'I pocket anything I see that might have some value.');

/* Criminal */
insert into personality_traits (background_id, sequence_num, a_trait)
values (2, 1, 'I always have a plan for what to do when things go wrong.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (2, 2, 'I am always calm, no matter what the situation.  I never  raise my voice or let my emotions control me.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (2, 3, 'The first thing I do in a new place is note the locations of everything valuable -- or where such things could be hidden.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (2, 4, 'I would rather make a new friend than a new enemy.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (2, 5, 'I am incredibly slow to trust.  Those who seem the fairest often have the most to hide.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (2, 6, 'I don''t pay attention to the risks in a situation.  Never tell me the odds.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (2, 7, 'The best way to get me to do something is to tell me I can''t do it.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (2, 8, 'I blow up at the slightest insult.');

/* Entertainer */
insert into personality_traits (background_id, sequence_num, a_trait)
values (3, 1, 'I know a story relevant to almost every situation.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (3, 2, 'Whenever I come to a new place, I collect local rumors and spread gossip.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (3, 3, 'I''m a hopeless romantic, always searching fo that "special someone."');
insert into personality_traits (background_id, sequence_num, a_trait)
values (3, 4, 'Nobody stay angry at me or around me for long, since I can defuse any amount of tension.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (3, 5, 'I love a good insult, even one directed at me.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (3, 6, 'I get bitter if I''m not the center of attention.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (3, 7, 'I''ll settle for nothing less than perfection.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (3, 8, 'I change my mood or my mind as quickly as I change key in a song.');

/* Folk Hero */
insert into personality_traits (background_id, sequence_num, a_trait)
values (4, 1, 'I judge people by their actions, not their words.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (4, 2, 'If someone is in trouble, I''m always ready to lend help.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (4, 3, 'When I set my mind to something, I follow through no matter what gets in my way.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (4, 4, 'I have a strong sense of fair play and always try to find the most equitable solution to arguments.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (4, 5, 'I''m confident in my own abilities and do what I can to instill confidence in others.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (4, 6, 'Thinking is for other people.  I prefer action.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (4, 7, 'I misuse long words in an attempt to sound smarter.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (4, 8, 'I get bored easily.  When am I going to get on with my destiny?');

/* Guild Artisan */
insert into personality_traits (background_id, sequence_num, a_trait)
values (5, 1, 'I believe that anything worth doing is worth doing right.  I can''t help it -- I''m a perfectionist.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (5, 2, 'I''m a snob who looks down on those who can''t appreciate fine art.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (5, 3, 'I always want to know how thing work and what makes people tick.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (5, 4, 'I''m full of witty aphorisms and have a proverb for every occasion.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (5, 5, 'I''m rude to people who lack my commitment to hard work and fair play.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (5, 6, 'I like to talk at length about my profession.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (5, 7, 'I don''t part with my money easily and will haggle tirelessly to get the best deal possible.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (5, 8, 'I''m well known for my work, and I want to make sure everyone appreciates it.  I''m alway taken aback when people haven''t heard of me.');

/* Hermit */
insert into personality_traits (background_id, sequence_num, a_trait)
values (6, 1, 'I''ve been isolated for so long that I rarely speak, preferring gestures and the occasional grunt.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (6, 2, 'I am utterly serene, even in the face of disaster.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (6, 3, 'The leader of my community had something wise to say on every topic, and I am eager to share that wisdom.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (6, 4, 'I feel tremondous empathy for all who suffer.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (6, 5, 'I''m oblivious to etiquette and social expectations.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (6, 6, 'I connect everything that happens to me to a grand, cosmic plan.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (6, 7, 'I often get lost in my thoughts and contemplation, becoming oblivious to my surroundings.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (6, 8, 'I am working on a grand philosophical theory and love sharing my ideas.');

/* Noble */
insert into personality_traits (background_id, sequence_num, a_trait)
values (7, 1, 'My eloquent flattery make eveyone I talk to feel like the most wonderful and important person in the world.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (7, 2, 'The common folk love me for my kindness and generosity.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (7, 3, 'No one could doubt by looking at my regal bearing that I am a cut above the unwashed masses.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (7, 4, 'I take great pains to alway look my best and follow the latest fashions.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (7, 5, 'I don''t like to get my hands dirty, and I won''t be caught dead in unsuitable accommodations.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (7, 6, 'Despite my noble birth, I do not place myself above other folk.  We all have the same blood.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (7, 7, 'My favor once lost, is lost forever.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (7, 8, 'If you do me an injury, I will crush you, ruin you name, and salt your fields.');

/* Outlander */
insert into personality_traits (background_id, sequence_num, a_trait)
values (8, 1, 'I''m driven by a wanderlust that led me away from home.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (8, 2, 'I watch over my friends as if they were a litter of newborn pups.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (8, 3, 'I once ran twenty-five miles without stopping to warn my clan of an approaching orc horde.  I''d do it again if I had to.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (8, 4, 'I have a lesson for every situation, drawn from observing nature.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (8, 5, 'I place no stock in wealthy or well-mannered folk.  Money and manners won''t save you from a hungry owlbear.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (8, 6, 'I''m always picking things up, absently fiddling with them, and sometimes accidentally breaking them.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (8, 7, 'I feel far more comfortable around animals that people.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (8, 8, 'I was, in fact, raised by wolves.');

/* Sage */
insert into personality_traits (background_id, sequence_num, a_trait)
values (9, 1, 'I use polysyllabic words that convey the impression of great erudation.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (9, 2, 'I''ve read every book in the world''s greatest libraries -- or I like to boast that I have.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (9, 3, 'I''m used to helping out those who aren''t as smart as I am, and I patiently explain anything and everything to others.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (9, 4, 'There''s nothing I like more that a good mystery.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (9, 5, 'I''m willing to listen to ever side of an argument before I make my own judgement.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (9, 6, 'I...speak...slowly...when talking...to idiots,...which...almost...everyone...is...compared...to me.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (9, 7, 'I am horribly, horribly awkward in social situations.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (9, 8, 'I''m convinced that people are always trying to steal my secrets.');

/* Sailor */
insert into personality_traits (background_id, sequence_num, a_trait)
values (10, 1, 'My friends know they can rely on me, no matter what.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (10, 2, 'I work hard so I can play hard whe the work is done.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (10, 3, 'I enjoy sailing into new ports and making new friends over a flagon of ale.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (10, 4, 'I stretch the truth for the sake of a good story.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (10, 5, 'To me, a tavern brawl is a nice way to get to know a new city.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (10, 6, 'I never pass up a friendly wager.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (10, 7, 'My language is as foul as an otyugh nest.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (10, 8, 'I like a job well done, especially if I can convince someone else to do it.');

/* Soldier */
insert into personality_traits (background_id, sequence_num, a_trait)
values (11, 1, 'I''m alway polite and respectful.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (11, 2, 'I''m haunted by memories of war.  I can''t get the images of violence out of my mind.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (11, 3, 'I''ve lost too many friends, and I''m slow to make new ones.')
insert into personality_traits (background_id, sequence_num, a_trait)
values (11, 4, 'I''m full of inspiring and cautionary tales from my military experience relevant to almost every combat situation.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (11, 5, 'I can stare down a hell hound without flinching.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (11, 6, 'I enjoy being strong and like breaking things.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (11, 7, 'I have a crude sense of humor.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (11, 8, 'I face problems head-on.  A simple, direct solution is the best path to success.');

/* Urchin */
insert into personality_traits (background_id, sequence_num, a_trait)
values (12, 1, 'I hide scraps of food and trinkets away in my pockets.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (12, 2, 'I ask a lot of questions.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (12, 3, 'I like to squeeze into small places where no one else can get to me.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (12, 4, 'I sleep with my back to a wall or tree, with everything I own wrapped in a bundle in my arms.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (12, 5, 'I eat like a pig and have bad manners.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (12, 6, 'I think anyone who''s nice to me is hiding evil intent.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (12, 7, 'I don''t like to bathe.');
insert into personality_traits (background_id, sequence_num, a_trait)
values (12, 8, 'I bluntly say what other people are hinting at or hiding.');

select b.name, p.sequence_num, p.a_trait from personality_traits p, backgrounds b where p.background_id = b.background_id

/* select background_id, name from backgrounds; */
