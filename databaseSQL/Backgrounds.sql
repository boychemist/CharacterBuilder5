drop table if exists personalitiy_traits;
drop table if exists ideals;
drop table if exists bonds;
drop table if exists flaws;
drop table if exists background_specializations;
drop table if exists background_details;
drop table if exists backgrounds;

create table backgrounds(
    background_id int identity(0),
    name char(14) unique not null,
    description char(2048) not null
);

insert into backgrounds (name, description)
  values('Acolyte', 'You have spent your life in the service of a temple to a specific god or pantheon of gods.  You act as an intermediary between the realm of the holy and the mortal world, performing sacred rites and offering sacrifices in order to conduct worshipers into the presence of the divine.  You are not necessarily a cleric -- performing sacred rites is not the same thing as channeling divine power.
  Choose a god, a pantheon of gods, or some other quasi-divine being from among those listed in appendix B of the Player''s Handbook or those specified by your DM, and work with your DM to detail the nature of your religious service.  Were you a lesser functionary in a temple, raised from childhood to assist the priests in the sacred rites?  Perhaps you were the leader of a small cult outside of any established temple structure, or even an occult group that served a fiendish master that you now deny.');

insert into backgrounds (name, description)
  values('Charlatan', 'You have always had a way with people.  You know what makes them tick, you can tease out their hearts'' desires after a few minutes of conversation, and with a few leading questions you can read them like they were children''s books.  It''s a useful talent, and one that you''re perfectly willing to use to your advantage.
  You know what people want and you deliver, or rather, you promise to deliver.  Common sense should steer people away from things that sound too good to be true, but common sense seems to be in short supply when you''re around.  The bottle of pink-colored liquid will surely cure that unseemly rash, this ointment -- nothing more that a bit of fat with as sprinke of silver dust -- can restore youth and vigor, and there''s a bridge in the city that just happens to be for sale.  These marvels sound implausible, but you make them sound like the real deal.');

insert into backgrounds (name, description)
  values('Criminal', 'You are and experienced criminal with a history of breaking the law.  You have spent a lot of time among other criminals and still have contacts within the criminal underworld.  You''re far close than most people to the world of murder, theft, and violence that pervades the underbelly of civilization, and you have survived up to this point by flouting the rules and regulations of society.');

insert into backgrounds (name, description)
  values('Entertainer', 'You thrive in front of an audience.  You know how to entrace them, entertain them, and even inspire them.  Your poetics can stir the hearts of those who hear you, awakening grief or joy, laughter or anger.  Your music raises their spirits or captures their sorrow.  You dance steps captivate, your humor cuts to the quick.  Whatever techniques you use, your art is your life.');

insert into backgrounds (name, description)
  values('Folk Hero', 'You come from a humble social rank, but you are destined for so much more.  Already the people of you home village regard you as their champion, and your destiny calls you to stand against the tyrants and monsters that threaten the common folk everywhere.');

insert into backgrounds (name, description)
  values('Guild Artisan', 'You are a member of an atrisan''s guild, skilled in a particular field and closely associate with other artisans.  You are a well-established part of the mercantile world, freed by talent and wealth from the constraints of a feudal social order.  You learned your skills as an apprentice to a master artisan, under the sponsorship of your guild, until you became a master in your own right.');

insert into backgrounds (name, description)
  values('Hermit', 'You lived in seclusion -- either in a sheltered community such as a monastery, or entirely alone -- for a formative part of your life.  In your time apart from the clamor of society, you found quiet, solitude, and perhaps som of the answers you were looking for.');

insert into backgrounds (name, description)
  values('Noble', 'You understand wealth, power, and privilege.  You carry a noble title, and your family owns land, collects taxes, and wields significant political influence.  You might be a pampered aristocrat unfamiliar with work or discomfort, a former merchant just elevated to the nobility, or a disinherited scoundrel with a  disproportionate senes of entitlement.  Or you could be an honest, hard-working landowner who cares deeply about the people who live and work on your land, keenly aware of your responsibility to them.
  Work with your DM to come up with an appropriate title and determine how much authority that title carries.  A noble title doesn''t stand on its own -- its connected to an entire family, and whatever title you hold, you will pass it down to your own children.  Not only do you need to determine you noble title, but you should also work with the DM to describe your family and their influence on you.
  Is your family old and established, or was you title only recently bestowed?  How much influence do they wield, and over what area?  What kind of reputation does your family have among the other aristocrats of the region?  How do the common people regard them?
  What''s your position in the family?  Are you the heir to the head of the family?  Have you already inherited the title?  How do you feel about that responsibility?  Or are you so far down the line of inheritance that no one cares what you do, as long as you don''t embarrass the family?  How does the head of your family feel about your adventuring career?  Are you in your family''s good graces, or shunned by the rest of your family?
  Does your family have a coat of arms?  An insignia you might wear on a signet ring?  Particular colors you wear all the time?  An animal you regard as a symbol of your line or even a spiritual member of the family?
  These details help establish your family and your title as features of the world of the campaign.');

insert into backgrounds (name, description)
  values('Outlander', 'You grew up in the wilds, far from civilization and the comforts of town and technology.  You''ve witnessed the migration of herds larger than forests, survived weather more extreme than any city-dweller could comprehend, and enjoyed the solitude of being the only thinking creature for miles in any direction.  The wilds are in your blood, whether you are a nomad, an explorer, a recluse, a hunter-gatherer, or even a maurader.  Even in places where you don''t know the specific features of the terrain, you know the ways of the wild.');

insert into backgrounds (name, description)
  values('Sage', 'You spent years learning the lore of the multiverse.  You scoured manuscripts, studied scrolls, and listened to the greatest experts on the subjects of interest to you.  Your efforts have made you a master in your fields of study.');

insert into backgrounds (name, description)
  values('Sailor', 'You sailed on a seagoing vessel for years.  In that time, you faced down mighty storms, monsters of the deep, and those who wanted to sink you craft to the bottomless depths.  Your first love is the distant line of the horizon, but the time has come to try you hand at something new.
  Discuss the nature of the ship you previously sailed with your Dungeon Master.  Was it a merchant ship, a naval vessel, a ship of discovery, or a pirate ship?  How famous (or infamous) is it?  Is it widely traveled?  Is it still sailing, or is it missing and presumed lost with all hands?
  What were you duties on board -- boatswain, captain, navigator, cook, or some other position?  Who were the captain and first mate?  Did you leave the ship on good terms with your fellows, or on the run?');

insert into backgrounds (name, description)
  values('Soldier', 'War has been your life for as long as you care to remember.  You trained as a youth, studied the use of weapons and armor, learned basic survival techiques, including how to stay alive on a battlefield.  You might have been part of a standing national army or a mercenary company, or perhaps a member of a local milita who rose to prominence during a recent war.
  When you choose this background, work with you DM to determine which military organizaiton your were a part of, how far through it ranks you progressed, and what kind of experiences you had during your military career.  Was it a standing army, a town guard, or a village militia?  Or it might have been a noble''s or merchant''s private army, or a mercenary company.');

insert into backgrounds (name, description)
  values('Urchin', 'You grew up on the streets alone, orphaned, and poor.  You had no one to watch over you or to provide for you, so you learned to provide for yourself.  You fought fiercely over food and kept a constant watch out for other desparate souls who might steal from you.  You slept on rooftops and in alleyways, exposed to the elements, and endured sicknessl without the advantage of medicine or a place to recuperate.  You''ve survived despite all odds, and did so through cunning, strength, speed, or some combination of each.
  You begin you adventuring career with enough money to live modestly but securely for at least ten days.  How did you come by that money?  What allowed you to break free of you desperate circumstances and embark on a better life?');

select * from backgrounds;