drop table if exists background_features;

create table background_features(
    name char(50) unique not null,
    variant boolean not null,
    description char(1024) not null,
    background_id int not null,
    primary key (name),
    foreign key (background_id) references backgrounds (background_id)
);

/* Acolyte */
insert into background_features (background_id, name, variant, description)
  values(0, 'Shelter of the Faithful', FALSE, 'As an acolyte, you command the respect of those who share your faith, and you can perform the religious caremonies of your deity.  You and your adventuring companions receive free healing and care at a temple, shrine, or other established presence of your faith, though you must provide any material components needed for the spells.  Those who share your religion will support you (but only you) at a modest lifestyle.
  You might also have ties to a specific temple dedicated to you chosen deity or pantheon, and you have a residence there.  This could be the temple where you used to serve, if you reamain on good terms with it, or a temple where you have found a new home.  While near your temple, you can call upon the priests for assistance, provided the assistance you ask for is not hazardus and you remain in good standing with your temple.');

/* Charlatan */
insert into background_features (background_id, name, variant, description)
  values(1, 'False Identity', FALSE, 'You have created a second identity that includes documentation, established acquaintances, and disguises that allow you to assume that personna.  Additionally, you can forge documents including official papers and personal letters, as long as you have seen an example of the kind of document or the handwriting your are trying to copy.');

/* Criminal */
insert into background_features (background_id, name, variant, description)
  values(2, 'Criminal Contact', FALSE, 'You have a reliable and trustworth contact who acts as your liaison to a network of other criminals.  You know how to get messages to and from your contact, even over great distances; specifically, you know the local messengers, corrupt caravan masters, and seedy sailors who can deliver messages for you.');
insert into background_features (background_id, name, variant, description)
  values(2, 'Spy', TRUE, 'Although your capabilities are not much different from those of a burglar or smuggler, you learned and practiced them in a very different context:  as an espionage agent.  You might have been an officially sanctioned agent of the crown, or perhaps you sold the secrets you uncovered to the highest bidder.');

/* Entertainer */
insert into background_features (background_id, name, variant, description)
  values(3, 'By Popular Demand', FALSE, 'You can always find a place to perform, usually in an inn or tavern but possibly with a circus, at a theater, or even in a noble''s court.  At such a place, you receive free lodging and food of a modest or comfortable standard (depending on the quality of the establishment), as long as you perform each night.  In addition, your performance makes you something of a local figure.  When strangers recognize you in a town where you have performed, they typically take a liking to you.');
insert into background_features (background_id, name, variant, description)
  values(3, 'Gladiator', TRUE, 'A gladiator is as much an entertainer as any minstral or circus performer, trained to make the arts of combat into a spectacle the crowd can enjoy.  This kind of flashy combat is your entertainer routine, though you might also have some skills as a tumbler or actor.  Using your By Popular Demand feature, you can find a place to perform in any place that features combat for entertainment -- perhaps a gladiatorial arena or secret pit fighting club.  You can replace the musical instrument in you equipment package with an inexpensive but unusual weapon, such as a trident or net.');

/* Folk Hero */
insert into background_features (background_id, name, variant, description)
  values(4, 'Rustic Hospitality', FALSE, 'Since you come from the ranks of the common folk, you fit in among them with ease.  You can find a place to hide, rest, or recuperate among other commoners, unless you have shown yourself to be a danger to them.  They will shield you from the law or anyone else searching for you, though they will not risk their lives for you.');

/* Guild Artisan */
insert into background_features (background_id, name, variant, description)
  values(5, 'Guild Membership', FALSE, 'As an established and respected member of a guild, you can rely on certain benefits tghat membership provides.  You fellow guild members will provide you with lodging and food if necessary, and pay for your funeral if needed.  In some cities and towns, a guildhall offers a central place to meet other members of your profession, which can be a good place to meet potential patrons, allies, or hirelings.
  Guilds often wield tremendous political power.  If you are accused of a crime, your guild will support you if a good case can be made for your innocence or the crime is justifiable.  You can also gain access to powerful political figures through the guild, if you are a member in good standing.  Such connections might require the donation of money or magic items to the guild''s coffers.
  You must pay dues of 5 gp per month to the guild.  If you miss payments, you must make up back dues to remain in the guild''s good graces.');
insert into background_features (background_id, name, variant, description)
  values(5, 'Guild Merchant', TRUE, 'Instead of an artisans'' guild, you might belong to a guild of traders, caravan masters, or shopkeepers.  You don''t craft items yourself but earn a living by buying and selling the works of others (or the raw materials artisans need to practice their craft).  Your guild might be a large merchant consortium (or family) with interests across the region.  Perhaps you transported goods from on place to another, by ship, wagon, or caravan, or bought them from traveling traders and sold them in you own little shop.  In some ways, the traveling merchant''s life lends itself to adventuring far more than the life of an artisan.
  Rather than a proficiency with artisan''s tools, you might be proficient with navigator''s tools or an additional language.  And instead of an artisan''s tools, you can start with a mule or a cart.');

/* Hermit */
insert into background_features (background_id, name, variant, description)
  values(6, 'Discovery', FALSE, 'The quiet seclusion of your extended hermitage gave you access to a unique and powerful discovery.  The exact nature of this revelation depends on the nature of your seclusion.  It might be a great truth about the cosmos, the deities, the powerful  beings of the outer planes, or the forces of nature.  It could be a site that no one else has ever seen.  You might have uncovered a fact that has long been forgotten, or unearthed some relic fo the past that could rewrite history.  It might be information that would be damaging to the people who or consigned you to exile, and hence the reason for your return to society.
  Work with your DM to determine the details of your discovery and its impact on the campaign.');

/* Noble */
insert into background_features (background_id, name, variant, description)
  values(7, 'Position of Privilege', FALSE, 'Thanks to your noble birth, people are inclined to think the best of you.  You are welcome in high society, and people assume you have the right to be wherever you are.  The common folk make every effort to accommodate you and avoid your displeasure, and other people of high birth treat you as a member of the same social sphere.  You can secure an audience with a local noble if you need to.');
insert into background_features (background_id, name, variant, description)
  values(7, 'Knight', TRUE, 'A knighthood is among the lowest noble titles in most societies, but it can be a path to higher status.  If you wish to be a knight, choose the Retainers feature instead of Position of Privilege feature.  One of your commoner retainers is replaced by a noble who serves as your squire, aiding you in exchange for training on his or her own path to knighthood.  Your two remaining retainers might include a groom to care for your horse and a servant who polishes your armor (and even helps you put it on).
  As an emblem of chivalry and the ideals of courtly love, you might include among your equipment a banner or other token from a noble lord or lady to whom you have given your heart -- in a chaste sort of devotion.  (This person could be your bond.)');
insert into background_features (background_id, name, variant, description)
  values(7, 'Retainers', TRUE, 'If your character has a noble background, you may select this background feature instead of Position of Privilege.
  You have the service of three retainers loyal to your family.  These retainers can be attendants or messengers, and one might be a majordomo.  Your retainers are commoners who can perform mundane tasks for you, but they do not fight for you, will not follow you into obviously dangerous areas (such as dungeons), and will leave if they are frequently endangered or abused.');

/* Outlander */
insert into background_features (background_id, name, variant, description)
  values(8, 'Wanderer', FALSE, 'You have an excellent memory for maps and geography, and you can always recall the general layout of terrrain, settlements, and other features around you.  In addition, you can find food and fresh water for yourself and up to five other people each day, provided the land offers berries, small game, water, and so forth.');

/* Sage */
insert into background_features (background_id, name, variant, description)
  values(9, 'Researcher', FALSE, 'When you attempt to learn or recall a piece of lore, if you do not know that information, you often know where and from whom you can obtain it.  Usually, this information comes from a library, scriptorium, university, or a sage or other learned person or creature.  Your DM might rule that the knowledge you seek is secreted away in an almost inaccessible place, or that it simply cannot be found.  Unearthing the deepest  secrets of the multiverse can require an adventure or even a whole campaign.');

/* Sailor */
insert into background_features (background_id, name, variant, description)
  values(10, 'Ship''s Passage', FALSE, 'When you need to, you can secure free passage on a sailing ship for yourself and your adventuring companions.  You might sail on the ship you served on, or another ship you have good relations with (perhaps on captained by a former crewmate).  Because you''re calling in a favor, you can''t be certain of a schedule or route that will meet your every need.  You Dungeon Master will determine how long it takes to get where you need to go.  In return for your free passage, you and your companions are expected to assist the crew during the voyage.');
insert into background_features (background_id, name, variant, description)
  values(10, 'Bad Reputation', TRUE, 'If you character has a sailor background, you may select this background feature instead of Ship''s Passage.
  No matter where you go, people are afraid of you due to your reputation.  When you are in a civilized settlement, you can get away with minor criminal offenses, such as refusing to pay for food at a tavern or breaking down doors at a local shop, since most people will not report your actvitity to the authorities.');

/* Soldier */
insert into background_features (background_id, name, variant, description)
  values(11, 'Military Rank', FALSE, 'You have a military rank from you career as a soldier.  Soldiers loyal to your former military organization still recognize your authority and influence, and they defer to you if they are of lower rank.  You can invoke your rank to exert influence over other soldiers and requisition simple equipment or horses for temporary use.  You can also usually gain access to friendly military encampments and fortresses where your rank is recognized.');

/* Urchin */
insert into background_features (background_id, name, variant, description)
  values(12, 'City Secrets', FALSE, 'You know the secret patterns and flow to cities and can find passages through urban sprawl that others would miss.  When you are not in combat, you (and companions you lead) can travel between any two locations in the city twice as fast as your speed would normally allow.');

/* select * from background_features; */

select f.name, f.variant, f.description, b.name from backgrounds b, background_features f where f.background_id = b.background_id

/* select background_id, name from backgrounds; */