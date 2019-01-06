drop table if exists ideals;

create table ideals (
  background_id int not null,
  sequence_num int not null,
  ideal char(135) not null,
  primary key (background_id, sequence_num),
  foreign key (background_id) references backgrounds (background_id)
);

/* Acolyte */
insert into ideals (background_id, sequence_num, ideal)
values (0, 1, 'TRADITION.
The ancient traditions of worship and sacrifice must be upheld. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (0, 2, 'CHARITY.
I always try to help those in need, no matter what the personal cost. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (0, 3, 'CHANGE.
We must help bring about the changes the gods are constantly working in the world. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (0, 4, 'POWER.
I hope to one day rise to the top of my faith''s religious hierarchy. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (0, 5, 'FAITH.
I trust that my deity will guide my actions.  I have faith that if I work hard, things will go well. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (0, 6, 'ASPIRATION.
I seek to prove myself worthy of my god''s favor by matching my actions against his or her teachings. (Any)');

/* Charlatan */
insert into ideals (background_id, sequence_num, ideal)
values (1, 1, 'INDEPENDENCE.
I am a free spirit -- no one tells me what to do. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (1, 2, 'FAIRNESS.
I never target people who can''t afford to lose a few coins. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (1, 3, 'CHARITY.
I distribute the money I acquire to the people who really need it. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (1, 4, 'CREATIVITY.
I never run the same con twice. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (1, 5, 'FRIENDSHIP.
Material goods come and go.  Bonds of friendship last forever. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (1, 6, 'ASPIRATION.
I''m determined to make something of myself. (Any)');

/* Criminal */
insert into ideals (background_id, sequence_num, ideal)
values (2, 1, 'HONOR.
I don''t steal from others in the trade. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (2, 2, 'FREEDOM.
Chains are meant to be broken, as are those who would forge them. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (2, 3, 'CHARITY.
I steal from the wealthy so that I can help people in need. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (2, 4, 'GREED.
I will do whatever it takes to become wealthy. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (2, 5, 'PEOPLE.
I''m loyal to my friends, not to any ideals, and everyone else can take a trip down the Styx for all I care. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (2, 6, 'REDEMPTION.
There''s a spark of good in everyone. (Good)');

/* Entertainer */
insert into ideals (background_id, sequence_num, ideal)
values (3, 1, 'BEAUTY.
When I perform, I make the world better than it was. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (3, 2, 'TRADITION.
The stories, legends, and songs of the past must never be forgotten for they teach us who we are. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (3, 3, 'CREATIVITY.
The world is in need of new ideas and bold action. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (3, 4, 'GREED.
I''m only in it for the money and fame. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (3, 5, 'PEOPLE
I like seeing the smiles on people''s faces when I perform.  That''s all that matters. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (3, 6, 'HONESTY
Art should reflect the soul; it should come from within and reveal who we really are. (Any)');

/* Folk Hero */
insert into ideals (background_id, sequence_num, ideal)
values (4, 1, 'RESPECT.
People deserve to be treated with dignity and respect. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (4, 2, 'FAIRNESS.
No one should get preferential treatment before the law, and no one is above the law. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (4, 3, 'FREEDOM.
Tyrants must not be allowed to opress the people. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (4, 4, 'MIGHT.
If I become strong, I can take what I want -- what I deserve. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (4, 5, 'SINCERITY.
There''s no good in pretending to be something I''m not. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (4, 6, 'DESTINY.
Nothing and no one can steer me away from my higher calling. (Any)');

/* Guild Artisan */
insert into ideals (background_id, sequence_num, ideal)
values (5, 1, 'COMMUNITY.
It is the duty of all civilized people to strengthen the bonds of community and the security of civilization. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (5, 2, 'GENEROSITY.
My talents were given to me so that I could use them to benefit the world. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (5, 3, 'FREEDOM.
Everyone should be free to pursue his or her own livelihood. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (5, 4, 'GREED.
I''m only in it for the money. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (5, 5, 'PEOPLE.
I''m committed to the people I care about, not to ideals. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (5, 6, 'ASPIRATION.
I work hard to be the best there is at my craft. (Any)');

/* Hermit */
insert into ideals (background_id, sequence_num, ideal)
values (6, 1, 'GREATER GOOD.
My gifts are meant to be shared with all, not used for my own benefit. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (6, 2, 'LOGIC.
Emotions must not cloud our sense of what is right and true, or our logical thinking. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (6, 3, 'FREE THINKING.
Inquiry and curiosity are the pillars of progress. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (6, 4, 'POWER.
Solitude and contemplation are paths toward mystical or magical power. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (6, 5, 'LIVE and LET LIVE.
Meddling in the affairs of others only causes trouble. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (6, 6, 'SELF-KNOWLEDGE.
If you know yourself, there''s nothing left to know. (Any)');

/* Noble */
insert into ideals (background_id, sequence_num, ideal)
values (7, 1, 'RESPECT.
Respect is due to me becase of my position, but all people regardless of station deserve to be treated with dignity. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (7, 2, 'RESPONSIBILITY.
It is my duty to respect the authority of those above me, just as those below me must respect mine. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (7, 3, 'INDEPENDENCE.
I must prove that I can handle myself without the coddling of my family. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (7, 4, 'POWER.
If I can attain more power, no one will tell me what to do. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (7, 5, 'FAMILY.
Blood runs thicker that water. (Any)');
insert into ideals (background_id, sequence_num, ideal)
values (7, 6, 'NOBLE OBLIGATION.
It is my duty to protect and care for the people beneath me. (Good)');

/* Outlander */
insert into ideals (background_id, sequence_num, ideal)
values (8, 1, 'CHANGE.
Life is like the seasons, in constant change, and we must change with it. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (8, 2, 'GREATER GOOD.
It is each person''s responsibility to make the most happiness for the whole tribe. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (8, 3, 'HONOR.
If I dishonor myself, I dishonor my whole clan. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (8, 4, 'MIGHT.
The strongest are meant to rule. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (8, 5, 'NATURE.
The natural world is more important than all the constructs of civilization. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (8, 6, 'GLORY.
I must earn glory in battle, for myself and my clan. (Any)');

/* Sage */
insert into ideals (background_id, sequence_num, ideal)
values (9, 1, 'KNOWLEDGE.
The path to power and self-improvement is through knowledge. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (9, 2, 'BEAUTY.
What is beautiful points us beyond itself toward what is true. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (9, 3, 'LOGIC.
Emotions must not cloud our logical thinking. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (9, 4, 'NO LIMITS.
Nothing should fetter the infinite possibility inherent in all existence. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (9, 5, 'POWER.
Knowledge is the path to power and domination. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (9, 6, 'SELF-IMPROVEMENT.
The goal of a life of study is the betterment of oneself. (Any)');

/* Sailor */
insert into ideals (background_id, sequence_num, ideal)
values (10, 1, 'RESPECT.
The thing that keeps a ship togehter is mutual respect between captain and crew. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (10, 2, 'FAIRNESS.
We all do the work, so we all share in the rewards. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (10, 3, 'FREEDOM.
The sea is freedom -- the freedom to go anywhere and do anything. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (10, 4, 'MASTERY.
I''m a predator, and the other ships on the sea are my prey. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (10, 5, 'PEOPLE.
I''m committed to my crewmates, not to ideals. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (10, 6, 'ASPIRATION.
Someday I''ll own my own ship and chart my own destiny. (Any)');

/* Soldier */
insert into ideals (background_id, sequence_num, ideal)
values (11, 1, 'GREATER GOOD.
Our lot is to lay down our lives in defense of others. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (11, 2, 'RESPONSIBILITY.
I do what I must and obey just authority. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (11, 3, 'INDEPENDENCE.
When people follow orders blindly, they embrace a kind of tyranny. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (11, 4, 'MIGHT.
In life as in war, the stronger force wins. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (11, 5, 'LIVE and LET LIVE.
Ideals aren''t worth killing over or going to war for. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (11, 6, 'NATION.
My city, nation, or people are all that matter. (Any)');

/* Urchin */
insert into ideals (background_id, sequence_num, ideal)
values (12, 1, 'RESPECT.
All people, rich or poor, deserve respect. (Good)');
insert into ideals (background_id, sequence_num, ideal)
values (12, 2, 'COMMUNITY.
We have to take care of each other, because no one else is going to do it. (Lawful)');
insert into ideals (background_id, sequence_num, ideal)
values (12, 3, 'CHANGE.
The low are lifted up, and the high and mighty are brought down.  Change is the nature of things. (Chaotic)');
insert into ideals (background_id, sequence_num, ideal)
values (12, 4, 'RETRIBUTION.
The rich need to be shown what life and death are like in the gutters. (Evil)');
insert into ideals (background_id, sequence_num, ideal)
values (12, 5, 'PEOPLE.
I help the people who help me -- that''s what keeps us alive. (Neutral)');
insert into ideals (background_id, sequence_num, ideal)
values (12, 6, 'ASPIRATION.
I''m going to prove that I''m worthy of a better life.');


select b.name, i.sequence_num, i.ideal from ideals i, backgrounds b where i.background_id = b.background_id

/* select background_id, name from backgrounds; */

