drop table if exists specializations;
create table specializations(spec_id int identity(0), class_id int not null, name char(80) unique not null,
    provides_spells boolean not null, description char(2048) not null);
alter table specializations
    add foreign key(class_id) references classes(class_id);
/* barbarian specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(0, 'Path of the Berserker', 'FALSE', 'For some barbarians, rage is a means to an end -- that end being violence.  The Path of the Berserker is a path of untrammeled fury, slick with blood.  As you enter the berserker''s rage, you thrill in the chaos of battle, heedless of your own health or well-being.');
insert into specializations(class_id, name, provides_spells, description)
    values(0, 'Path of the Totem Warrior', 'FALSE',
    'The Path of the Totem Warrior is a spiritual journey, as the barbarian accepts a spirit animal as guide, protector, and inspiration.  In battle, your totem spirit fills you with supernatural might, adding magical fuel to your barbarian rage.
    Most barbarian tribes consider a totem animal to be kin to a particular clan.  In such cases, it is unusual for an individual to have more than one totem animal spirit, though exceptions exist.');

/* bard specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(1, 'College of Lore', 'FALSE', 'Bards of the College of Lord know something about most things, collecting bits of knowledge from sources as diverse as scholarly tomes and peasant tales.  Whether singing folk ballads in taverns or elaborate compositions in royal courts, these bards use their gifts to hold audiences spellbound.  When the applause dies down, the audience members might find themselves questioning everthing they held to be true, from their faith in the priesthood of the local temple to their loyalty to the king.
    The loyalty of these bards lies in the pursuit of beauty and truth, not in fealty to a monarch or following the tenets of a deity.  A noble who keeps such a bard as a herald or advisor knows that the bard would rather be honest than politic.
    The college''s members gather in libraries and sometimes in actual colleges, complete with classrooms and dormitories, to share their lore with on another.  They also meet at festivals or affairs of state, where they can expose corruption, unravel lies, and poke fun at self-important figures of authority.');
insert into specializations(class_id, name, provides_spells, description)
    values(1, 'College of Valor', 'FALSE', 'Bards of the College of Valor are daring skalds whose tales keep alive the memory of the great heros of the past, and thereby inspire a new generation of heros.  These bards gather in mead halls or around great bonfires to sing the deeds of the mighty, both past and present.  They travel the land to witness great events firsthand and to ensure that the memory of those events doesn''t pass from the world.  With their songs, they inspire others to reach the same heights of accomplishment as the heros of old.');
/* cleric specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(2, 'Knowledge Domain', 'FALSE', 'The gods of knowledge -- including Oghma, Boccob, Gilean, Aureon, and Troth -- value learning and understanding above all.  Some teach that knowledge is to be gathered and shared in libraries and universities, or promote the practical knowledge and keep its secrets to themselves.  Followers of these gods study esoteric lore, collect old tomes, delve into secret places of the earth, and learn all they can.  Some gods of knowledge promote the practical knowledge of craft and invention, including smith deities like Gond, Reorx, Onatar, Moradin, Hephasetus, and Goibhniu.
    
    KNOWLEDGE DOMAIN SPELLS
     Cleric Level   Spells
           1st           command, identify
           3rd           augury, suggestion
           5th           nondetection, speak with dead
           7th           arcane eye, confusion
           9th           legend lore, scrying');
insert into specializations(class_id, name, provides_spells, description)
    values(2,'Life Domain', 'FALSE', 'The Life domain focuses on the vibrant positive energy -- one of the fundamental forces of the universe -- that sustains all life.  The gods of life promote vitality and health through healing the sick and wounded, caring for those in need, and driving away the forces of death and undeath.  Almost any non-evil deity can claim influence over this domain, particularly argricultural deities (such as Chauntea, Arawai, and Demeter), sun gods (such as Lathander, Pelor, and Re-Horakhty), gods of healing or endurance (such as Ilmater, Miahakal, Apollo, and Diancecht), and gods of home and community (such as Hestia, Hathor, and Boldrei).
    
    LIFE DOMAIN SPELLS
     Cleric Level    Spells
           1st            bless, cure wounds
           3rd            lesser restoratin, spiritual weapon
           5th            beacon of hope, revivify
           7th            death ward, guardian of faith
           9th            mass cure wounds, raise dead');
insert into specializations(class_id, name, provides_spells, description)
    values(2, 'Light Domain', 'FALSE', 'Gods of light -- including Helm, Lathander, Pholtus, Branchala, the Silver Flame, Belenus, Apollo, and Re-Horakhty -- promote the ideals of rebirth and renewal, truth, vigilance, and beauty, often using the symbol of the sun.  Some of these gods are portrayed as the sun itself or as a charioteer who guides the sun across the sky.  Others are tireless sentinels whose eyes pierce every shadow and see through every deception.  Some are deities of beauty and artistry, who teach that art is a vehicle for the soul''s improvement.  Clerics of a god of light are enlightened souls infused with radiance and the power of their gods'' discerning vision, charged with chasing away lies and burning away darkness.
    
    LIGHT DOMAIN SPELLS
     Cleric Level    Spells
           1st           burning hands, faerie fire
           3rd           flaming sphere, scorching ray
           5th           daylight, fireball
           7th           guardian of faith, wall of fire
           9th           flame strike, scrying.');
insert into specializations(class_id, name, provides_spells, description)
    values(2, 'Nature Domain', 'FALSE', 'Gods of nature are as varied as the natural world itself, from inscrutable gods of the deep forests (such as Silvanus, Obad-Hai, Chrislev, Balilnor, and Pan) to friendly deities assocaited with particular springs and groves (such as Eldath).  Druids revere nature as a whole and might serve one of these deities, practicing mysterious rites and reciting all-but-forgotten prayers in their own secret tongue.  But many of these gods have clerics as well, champions who take a more active role in advancing the interests of a particular nature god.  These clerics might hunt evil monstrosities that despoil woodlands, bless the harvest of the faithful, or wither the crops of those who anger their gods.
    
    NATURE DOMAIN SPELLS
      Cleric Level    Spells
           1st            animal friendship, speak with animals
           3rd            barkskin, spike growth
           5th            plant growth, wind wall
           7th            dominate beast, grasping vine
           9th            insect plague, tree stride');
insert into specializations(class_id, name, provides_spells, description)
    values(2, 'Tempest Domain', 'FALSE', 'Gods whos portfilios include the Tempest domain -- including Talos, Umberlee, Kord, Zeboim, the Devourer, Zeus, and Thor -- govern storms, sea, and sky.  They include gods of lightning and thunder, gods of earthquakes, some fire gods, and certain gods of violence, physical strength, and courage.  In some pantheons, agod of this domain rules over other deities and known for swift justice delivered by thunderbolds.  In the pantheons of seafaring people, gods of this domain are ocean deities and the patrons of saliors.  Tempest gods send their clerics to inspire fear in the common fold, either to keep those folk on the path of righteousness or to encourage them to offer sacrifices of propitiation to ward off divine wrath.
    
    TEMPEST DOMAIN SPELLS
      Cleric Level    Spells
           1st            fog cloud, thunderwave
           3rd            gust of wind, shatter
           5th            call lightning, sleet storm
           7th            control water, ice strom
           9th            destructive wave, insect plague');
insert into specializations(class_id, name, provides_spells, description)
    values(2, 'Trickery Domain', 'FALSE', 'Gods of trickery -- such as Tymora, Beshaba, Oldammara, the Traveler, Garl Glittergold, and Loki -- are mischief-makers and instigators who stand as a constant challenge to the accepted order among both gods and mortals.  They''re patrons of thieves, scoundrels, gamblers, rebels, and liberators.  Their clerics are a disruptive force in the world, puncturing pride, mocking tyrants, stealing from the rich, freeing captives, and flouting hollow traditions.  The prefer subterfuge, pranks, deception, and theft rather than direct confrontation.
    
    TRICKERY DOMAIN SPELLS
      Cleric Level    Spells
           1st            charm person, disguise self
           3rd            mirror image, pass without trace
           5th            blink, dispel magic
           7th            dimension door, polymorph
           9th            dominate person, modify memory');
insert into specializations(class_id, name, provides_spells, description)
    values(2, 'War Domain', 'FALSE', 'War has many manifestations.  It can make heros of ordinary people.  It can be desperate and horrific, with acts of cruelty and cowardice eclipsing instances of excellence and courage.  In either case, the gods of war watch over warriors and reward them for their great deeds.  The clerics of such gods excel in battle, inspiring others to fight the good fight or offering acts of violence as prayers.  Gods of war include champions of honor and chivalry (such as Torm, Heironeous and Kiri-Jolith) as well as gods of destruction and pillage (such as Erythunl, the Fury, Gruumsh, and Ares) and gods of conquest and domination (such as Bane, Hextor, and Maglubiyet).  Other war gods (such as Tempus, Nike, and Nuada) take a more neutral stance, promoting war in all its manifestations and supporting wariors in any circumstance.
    
    WAR DOMAIN SPELLS
      Cleric Level    Spells
           1st            divine favor, shield of faith
           3rd            magic weapon, spiritual weapon
           5th            crusader''s mantle, spirit guardian
           7th            freedom of movement, stoneskin
           9th            flame strike, hold monster');
/* druid specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(3, 'Circle of the Land', 'true', 'The Circle of the Land is make up of mystice and sages who safeguard ancient knowledge and rites through a vast oral tradition.  These druids meet within sacred curcles of trees or standing stones to whisper primal secrets in Druidic.  The circle''s wisest members preside as the chief priests of communities that hold to the Old Faith and serve as advisors to the rulers of those folk.  As a member of this circle, your magic is influenced by the land where you initiated into the circle''s mysterious rites.');
insert into specializations(class_id, name, provides_spells, description)
    values(3, 'Circle of the Moon', 'FALSE', 'Druids of the Circle of the Moon are fierce guardians of the wilds.  Their order gathers under the full moon to share news and trade warnings.  They haunt the deepest parts of the wilderness, where they might go for weeks on end before crossing paths with another humanoid creature, let alone another druid.
    Changeable as the moon, a druid of this circle might prowl as a great cat one night, soar over the treetops as an eagle the next day, and crash through the undergrowth in bear form to drive off a trespassing monster.  The wild in the druid''s blood.');
/* fighter specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(4, 'Champion', 'FALSE', 'The archetypal Champion focuses on the development of raw physical power honed to deadly perfection.  Those who model themselves on this archetype combine rigorous training with physical excellence to deal devastating blows.');
insert into specializations(class_id, name, provides_spells, description)
    values(4, 'Battle Master', 'FALSE', 'Those who emulate this archetypal Battle Master employ martial techniques passed down through generations.  To a Battle Master, combat is an academic field, sometimes including subjects beyond battle such as weaponsmithing and calligraphy.  Not every fighter absorbs the lessons of history, theory, and artistry that are reflected in the Battle Master archetype, but those who do are well-rounded fighters of great skill and knowledge');
insert into specializations(class_id, name, provides_spells, description)
    values(4, 'Eldritch Knight', 'TRUE', 'The archtypal Eldritch Knight combines the martial mastry common to all fighters with a careful study of magic.  Eldritch Knights use magical techniques similar to those practiced by wizards.  They focus their study on two of the eight schools of magic:  abjuration and evocation.  Abjuration spells grant an Eldritch Knight additional protection in battle, and evocation spells deal damage to many foes at once, extending the fighter''s reach in combat.  These knights learn a comparatively small number of spells, committing them to memory instead of keeping them in a spellbook.');
/* monk specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(5, 'Way of the Open Hand', 'FALSE', 'Monks of the Way of the Open Hand are the ultimate masters of martial arts combat, whether armed or unarmed.  The learn techniques to push and trip their opponents, manipulate ki to heal damage to their bodies, and practice advanced meditation tha can protect them from harm.');
insert into specializations(class_id, name, provides_spells, description)
    values(5, 'Way of Shadow', 'FALSE', 'Monks of the Way of Shadow follow a tradition that values stealth and subterfuge.  These monks might be called ninjas or shadowdancers, and they serve as spies and assassins.  Sometimes members of a ninja monastery are family members, forming a clan sworn to secrecy about their arts and missions.  Other monasteries are more like thieves'' guilds, hiring out their services to nobles, rich merchants, or anyone else who can pay their fees.  Regardless of their methods, the heads of these monasteries expect the unquestioning obediance of their students.');
insert into specializations(class_id, name, provides_spells, description)
    values(5, 'Way of the Four Elements', 'true', 'You follow a monastic tradition that teaches you to harness the elements.  When you focus your ki, you can align yourself with the forces of creation and bend the four elements to your will, using them as an extension of your body.  Some members of this tradition dedicate themselves to a single element, but others weave the elements together.
    Many monks of this tradition tatoo their bodies with representations of their ki powers, commonly imagined as coiling dragons but also as phoenixes, fish, plants, mountains, and cresting waves.');
/* paladin specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(6, 'Oath of Devotion', 'FALSE', 'The Oath of Devotion binds a paladin to the loftiest ideals of justice, virtue, and order.  Sometimes called cavaliers, white knights, or holy warriors, thes paladins meet the ideal of the knight in shining armor, acting with honor in pursuit of justice and the greater good.  They hold themselves to the highest standards of conduct, and some, for better or worse, hold the rest of the world to the same standards.  Many who swear this oath are devoted to gods of law and good and use their gods'' tenets as the measure of their devotion.  The hold angels -- perfect servants of good -- as their ideals, and incorporate images of angels wings into their helmets or coats of arms.
    
    TENETS OF DEVOTION
    Though the exact words and strictures of the Oath of Devotion vary, paladins of this oath share these tenets.
    
    HONESTY.
    Don''t lie or cheat.  Let your word be your promise.
    COURAGE.
    Never fear to act, though caution is wise.
    COMPASSION.
    Aid others, protect the weak, and punish those who threaten them.  Show mercy to your foes, but temper it with wisdom.
    HONOR.
    Treat others with fairness, and let your honorable deeds be an example to them.  Do as much good as possible while causing the least amount of harm.
    DUTY.
    Be responsible for your actions and their consequences, protect those enstruted to your care, and obey those who have authority over you.
    
    OATH SPELLS
     Paladin Level    Spells
          3rd             protection from evil and good, sanctuary
          5th             lesser restoration, zone of truth
          9th             beacon of hope, dispel magic
          13th           freedom of movement, guardian of faith
          17th           commune, flame strike');
insert into specializations(class_id, name, provides_spells, description)
    values(6, 'Oath of Ancients', 'FALSE', 'The Oath of Ancients is as old as the race of elves and ther rituals of the druids.  Sometimes called fey knights, green knights, or horned knights, paladins who swear this oath cast ther lot with the side of the light in the cosmic struggle against darkness because they love the beautiful and life-giving things of the world, not necessarily because they believe in the principles of honor, courage, and justice.  They adorn ther armor and clothing with images of growing things -- leaves, antlers, or flowers -- to reflect their commitment to preserming life and light in the world.
    
    TENETS OF THE ANCIENTS
    The tenets of the Oath of the Ancients have been preserved for uncounted centuries.  This oath emphasizes the principles of good above any concerns of law or chaos.  Its four central principles are simple.
    
    KINDLE THE LIGHT.
    Through your acts of mercy, kindness, and forgiveness, kindle the light of hope in the world, beating back dispair.
    SHELTER THE LIGHT.
    Where there is good, beauty, love, and laughter in the world, stand against the wickedness that would swallow it.  Where life flourishes, stand against the forces that would render it barren.
    PRESERVE YOUR OWN LIGHT.
    Delight in song and laughter, in beauty and art.  If you allow the light to die in your own heart, you can''t preserve it in the world.
    BE THE LIGHT.
    Be a glorious beacon fo all who live in despair.  Let the light of your joy and courage shine forth in all your deeds.

    OATH SPELLS
     Paladin Level    Spells
          3rd             ensnaring strike, speak with animals
          5th             misty step, moonbeam
          9th             plant growth, protection from energy
          13th           ice storm, stoneskin
          17th           commune with nature, tree stride');    
insert into specializations(class_id, name, provides_spells, description)
    values(6, 'Oath of Vengeance', 'FALSE', 'The Oath of Vengeance is a solemn commitment to punish those who have committed a grievous sin.  When evil forces slaughter helpless villagers, when an entire people turns against the will of the gods, when a thieves'' guild grows too violent and powerful, when a dragon rampages through the countryside -- at times like these, paladins arise and swear an Oath of Vengeance to set right that which has gone wrong.  To these paladins -- sometimes called avengers or dark knights -- their own purity is not as important as delivering justice.
    
    TENETS OF VENGENCE
    The tenets of the Oath of Vengeance vary by paladin, but all the tenets revolve around punishing wrongdoers by any means necesary.  Paladins who uphold these tenets are willing to sacrifice even their own righteousness  to mete out justice upon those who do evil, so the paladins are often neutral or lawful neutral in alignment.  The core principles of the tenets are brutally simple.
    
    FIGHT THE GREATER EVIL.
    Faced with a choice of fighting my sworn foes or combating a lesser evil, I choose the greater evil.
    NO MERCY FOR THE WICKED.
    Ordinary foes might win my mercy, but my sworn enemies do not.
    BY ANY MEANS NECESSARY.
    My qualms can''t get in the way of exterminating my foes.
    RESTITUTION.
    If my foes wreak ruin on the world, it is because I failed to stop them.  I must help those harmed by their misdeeds.
    
    OATH SPELLS
     Paladin Level    Spells
          3rd             bane, hunter''s mark
          5th             hold person, misty step
          9th             haste, protection from energy
          13th           banishment, dimension door
          17th           hold monster, scrying');    
/* ranger specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(7, 'Hunter', 'FALSE', 'Emulating the Hunter archetype means accepting your place as a bulwark between civilization and the terrors of the wilderness.  As you walk the Hunter''s path, you learn specialized techniques for fighting the threats you face, from rampaging ogres and hords of orcs to towering giants and terrifying dragons.');
insert into specializations(class_id, name, provides_spells, description)
    values(7, 'Beast Master', 'FALSE', 'The Beast Master archetype embodies a friendship between the civilized races and the beasts of the wild.  United in focus, beast and ranger fight the monsters that threaten civilization and the wilderness alike.');
/* rogue specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(8, 'Thief', 'FALSE', 'You hone your skills in the larcenous arts.  Burglars, bandits, cutpurses, and other criminals typically follow this archetype, but so do rogues who prefer to think of themselves as professional treasure seekers, explorers, delvers, andd investigators.  In addition to improving your agility and stealth, you learn skills useful for delving into ancient ruins, reading unfamiliar languages, and using magic items you normally couldn''t employ.');
insert into specializations(class_id, name, provides_spells, description)
    values(8, 'Assassin', 'FALSE', 'You focus your training on the grim art of death.  Those who adhere to this archetype are diverse:  hired killers, spies, bounty hunters, and even specially anointed priests trained to exterminate enemies of their deity.  Stealth, poison, and disguise help you eliminate your foes with deadly efficiency.');
insert into specializations(class_id, name, provides_spells, description)
    values(8, 'Arcane Trickster', 'TRUE', 'Some rogues enhance their fine-honed skills of stealth and agility with magic, learning tricks of enchantment and illusion.  These rogues include pickpockets and burglars, but also pranksters, mischief-makers, and a significant number of adventurers.');
/* sorcerer specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(9, 'Draconic Bloodline', 'FALSE', 'Your innate magic comes from draconic magic that was mingled with your blood or that of your ancestors.  Most often, sorcerers with this origin trace their descent back to a mighty sorcerer of ancient times who made a bargan with a dragon or who might even have claimed a dragon parent.  Some of these bloodlines are well established in the world, but most are obscrure.  Any given sorcerer could be the first of a new bloodline, as a result of a pact or some other exceptional circumstance.');
insert into specializations(class_id, name, provides_spells, description)
    values(9, 'Wild Magic', 'FALSE', 'Your innate magic comes from forces of chaos that underlie the order of creation.  You might have endured exposure to raw magic, perhaps through a planar portal leading to Limbo, the Elemental Planes, or the Far Realm.  Perhaps your were blessed by a fey being or marked by a demon.  Or your magic could be a fluke of your birth, with no apparent cause.  However it came to be, this magic churns within you, waiting for any outlet.');
/* warlock specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(10, 'The Archfey', 'FALSE', 'Your patron is a lord or lady of the fey, a creature of legend who holds secrets that were forgotten before the mortal races were born.  This being''s motivations are often inscrutable, and sometimes whimsical, and might involve striving for greater magical power or the settling of age-old grudges.  Beings of this sort include the Prince of Frost; the Queen of Air and Darkness, ruler of the Gloaming Court; Titania of the Summer Court; her consort Oberon, the Green Lord; Hyrsam, the Prince of Fools; and ancient hags.
    
    EXPANDED SPELL LIST
    The Archfey lets you choose from an expanded list of spells when you learn a warlock spell.  The following spells are added to the warlock spell list for you.
    
    ARCHFEY EXPANDANDED SPELLS
      Spell Level    Spells
          1st            faerie fire, sleep
          2nd            calm emotions, phantasmal force
          3rd            blink, plant growth
          4th            dominate beast, greater invisibility
          5th            dominate person, seeming');
insert into specializations(class_id, name, provides_spells, description)
    values(10, 'The Fiend', 'false', 'You have made a pact with a fiend from the lower planes of existence, a being whose aims are evil, even if you strive against those aims.  Such beings desire corruption or destruction of all things, ultimately including you.  Fiends powerful enough to forge a pact include demon lords such as Demogorgon, Orcus, Fraz''Urb-luu, and Baphomet; archdeviles such as Asmodeus, Dispather, Mephistopheles, and Belial; pit fiends and balors that are especially mighty; and utroloths and other lords of the yugoloths.
    
    FIEND EXPANDED SPELLS
      Spell Level    Spells
          1st            burning hands, command
          2nd            blindness/deafness, scorching ray
          3rd            fireball, stinking cloud
          4th            fire shield, wall of fire
          5th            flame strike, hallow');
insert into specializations(class_id, name, provides_spells, description)
    values(10, 'The Great Old One', 'false', 'Your patron is a mysterious entity whose nature is uterly foreign to the fabric of reality.  It might come from the Far Realm, the space beyond reality, or it could be one of the elder gods known only in legends.  Its motives are incomprehensible to mortals, and its knowledge so immense and ancient that even the greatest libraries pale in comparison to the vast secrets it holds.  The Great Old One might be unaware of your existence or entirely indifferent to your, but the secrets you have learned allow you to draw your magic from it.
    Entities of this type include Ghaunadar, called That Which Lurks; Tharizdun, the Chained God; Dendar, the Night Serpent; Zargon, the Returner; Great Cthulhu; and other unfathomable beings.
    
    GREAT OLD ONE EXPANDED SPELLS
      Spell Level    Spells
          1st            dissonant whispers, Tasha''s hideous laughter
          2nd            detect thoughts, phantasmal force
          3rd            clairvoyance, sending
          4th            dominate beast, Evard''s black tentacles
          5th            dominate person, telekinesis');
/* wizard specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(11, 'School of Abjuration', 'FALSE', 'The School of Abjuration emphasizes magic that blocks, banishes, or protects.  Detractors of this school say that its tradition is about denial, negation rather than positive assertion.  You understand, however, that ending harmful effects, protecting the weak, and banishing evil influences is anything but a philosophical void.  It is a proud and respected vocation.
    Called abjurers, members of this school are sought when baleful spirits require exorcism, when important locations must be guarded against magical spying, and when portals to other planes of existence must be closed.');
insert into specializations(class_id, name, provides_spells, description)
    values(11, 'School of Conjuration', 'false', 'As a conjurer, you favor spells that produce objects and creatures out of thin air.  You can conjure billowing clouds of killing fog or summon creatures from elsewhere to fight on your behalf.  As your mastery grows, you learn spells of transportation and can teleport yourself across vast distances, even to other planes of existence, in an instant.');
insert into specializations(class_id, name, provides_spells, description)
    values(11, 'School of Divination', 'false', 'The counsel of a diviner is sought by royalty and commoners alike, for all seek a clearer understanding of the past, present, and future.  As a diviner, you strive to part the veils of space, time, and consciousness so that you can see clearly.  You work to master spells of discernment, remote viewing, supernatural knowledge, and foresight.');
insert into specializations(class_id, name, provides_spells, description)
    values(11, 'School of Enchantment', 'false', 'As a member of the School of Enchantment, you have honed your ability to magically entrance and beguile other people and monsters.  Some enchanters are peacemakers who bewitch the violent to lay down their arms and charm the cruel into showing mercy.  Others are tyrants who magically bind the unwilling into their service.  Most enchanters fall somewhere in between.');
insert into specializations(class_id, name, provides_spells, description)
    values(11, 'School of Evocation', 'false', 'You focus your study on magic that creates powerful elemental effects such a bitter cold, searing flame, rolling thunder, crackling lightning, and buring acid.  Some evokers find employment in military forces, serving as artillery to blast enemy armies from afar.  Others use their spectacular power to protect the weak, while some seek their own gain as bandits, adventurers, or aspiring tyrants.');
insert into specializations(class_id, name, provides_spells, description)
    values(11, 'School of Illusion', 'false', 'You focus your studies on magic that dazzles the senses, befuddles the mind, and tricks even the wisest folk.  Your magic is subtle, but the illusions crafted by your keen mind make the impossible seem real.  Some illusionists -- including many gnome wizards -- are benign trickseters who use their spells to entertain.  Others are more sinister masters of deception, using their illusions to frighten and fool others for their personal gain.');
insert into specializations(class_id, name, provides_spells, description)
    values(11, 'School of Necromancy', 'false', 'The School of Necromancy explores the cosmic forces of life, death, and undeath.  As you focus your studies in this tradition, your learn to manipulate the energy that animates all living things.  As you progress, you learn to sap the life force from a creature as your magic destroys its body, transforming that vital energy into magical power you can manipulate.
    Most people see necromancers as menacing, or even villainous, due to the close association with death.  Not all necromancers are evil, but the forces they manipulate are considered taboo by many societies.');
insert into specializations(class_id, name, provides_spells, description)
    values(11, 'School of Transmutation', 'false', 'You are a student of spells  the modify energy and matter.  To you, the world is not a fixed thing, but eminently mutable, and you delight in being an agent of change.  You wield the raw stuff of creation and learn to alter both physical forms and mental qualities.  Your magic gives you the tools to become a smith on reality''s forge.
    Some transmuters are tinkerers and pranksters, turning people into toads and transforming copper into silver for fun and occasional profit.  Others pursue their magical studies with deadly seriousness, seeking the power of the gods to make and destroy worlds.');
/* barbarian paths from Xanthar's Guide */
insert into specializations(class_id, name, provides_spells, description)
    values(0, 'Path of the Ancestral Guardian', 'FALSE',
    'Some barbarians hail from cultures that revere their ancestors.  These tribes teach that the warriors of the past linger in the world as mighty spirits, who can guide and protect the living.  When a barbarian who follows this path rages, the barbarian contacts the spirit world and calls on these guardian spirits for aid.
    Barbarians who draw on their ancestral guardians can better fight to protect their tribes and allies.  In order to cement ties to their ancestral guardians, barbarians who follow this path cover themselves in elaborate tattoos that celebrate their ancestors'' deeds.  These tattoos tell sagas of victories against terrible monsters and other fearsome rivals.');
insert into specializations(class_id, name, provides_spells, description)
    values(0, 'Path of the Storm Herald', 'FALSE',
    'All barbarians harbor a fury within.  Their rage grants them superior strength, durability, and speed.  Barbarians who follow the Path of the Storm Herald learn to transform that rage into a mantle of primal magic, which swirls around them.  When in a fury, a barbarian of this path taps into the forces of nature to create powerful magical effects.
    Storm heralds are typically elite champions who train alongside druids, rangers, and others sworn to protect nature.  Other storm heralds hone their craft in lodges in regions wracked by storms, in the frozen reaches at the world''s end, or deep in the hottest deserts.');
insert into specializations(class_id, name, provides_spells, description)
    values(0, 'Path of the Zealot', 'FALSE',
    'Some deities inspire their followers to pitch themselves into a ferocious battle fury.  These barbarians are zealots -- warriors who channel their rage into powerful displays of divine power.
    A variety of gods across the worlds of D&D inspire their followers to embrace this path.  Tempus from the Forgotten Realms and Hextor and Erythnul of Greyhawk are all prime examples.  In general, the gods who inspire zealots are deities of combat, destruction, and violence.  Not all are evil, but few are good.');

/* bard specializations */
insert into specializations(class_id, name, provides_spells, description)
    values(1, 'College of Glamour', FALSE, 'The College of Glamour is the home of bards who mastered their craft in the vibrant realm of the Feywild or under the tutelage of someone who dwelled there.  Tutored by satyrs, eladrin, and other fey, these bards learn to use their magic to delight and captivate others.
    The bards of this college are regarded with a mixture of awe and fear.  Their performances are the stuff of legend.  These bards are so eloquent that a speech or song that one of them performs can cause captors to release the bard unharmed anc can lull a furious dragon into complacency.  The same magic that allows them to quell beasts can also bend minds.  Villainous bards of this college can leech off a community for weeks, misusing their magic to turn their hosts into thralls.  Heroic bards of this college instead use this power to gladden the downtrodden and undermine opressors.');
insert into specializations(class_id, name, provides_spells, description)
    values(1, 'College of Swords', FALSE, 'Bards of the College of Swords are called blades, and they entertain through daring feats of weapon prowess.  Blades perform stunts such as sword swallowing, knife throwing and juggling, and mock combats.  Though they use their weapons to entertain, they are also highly trained and skilled warriors in their own right.
    Their talent with weapons inspires many blades to lead double lives.  One blade might use a circus troupe as cover for nefarious deeds such as assassination, robbery, and blackmail.  Other blades strike at the wicked, bringing justice to bear against the cruel and powerful.  Most troupes are happy to accept a blade''s talent for the excitement it adds to a performance, but few entertainers fully trust a blade in their ranks.
    Blades who abandon their lives as entertainers have often run into trouble that makes maintaining their secret activities impossible.  A blade caught stealing or engaging in vigilante justice is too great a liability for most troupes.  With their weapon skills and magic, these blades either take up work as enforcers for thieves'' guilds or strike out on their own as adventurers.');
insert into specializations(class_id, name, provides_spells, description)
    values(1, 'College of Whispers', FALSE, 'Most folk are happy to welcome a bard into their midst.  Bards of the College of Whispers use this to their advantage.  They appear to be like other bards, sharing news, singing songs, and telling tales to the audiences they gather.  In truth, the College of Whispers teaches its students that they are wolves among sheep.  These bards use their knowledge and magic to uncover secrets and turn them against others through extortion and threats.
    Many bards hate the College of Whispers, viewing it as a parasite that uses a bard''s reputation to acquire wealth and power.  For this reason, members of this college rarely reveal their true nature.  They typically claim to follow some other college, or they keep their actual calling secret in order to infiltrate and exploit royal courts and other settings of power.');

/* Cleric */
insert into specializations(class_id, name, provides_spells, description)
    values(2, 'Forge Domain', FALSE, 'The gods of the forge are patrons of artisans who work with metal, from a humble blacksmith who keeps a village in horseshoes and plow blades to the mighty elf artisan whose diamond-tipped arrows of mithral have felled demon lords.  The gods of the forge teach that, with patience and hard work, even the most intractable metal can be transformed from a lump ofore to a beautifully wrought object.  Clerics of these deities search for objects lost to the forces of darkness, liberate mines overrun by orcs, and uncover rare and wondrous materials necessary to create potent magic items.  Followers of these gods take great pride in their work, and they are willing tor craft and use heavy armor and powerful weapons to protect them.  Deities of this domain include Gond, Reorx, Onatar, Moradin, Hephaestus, and Goibhniu.');
insert into specializations(class_id, name, provides_spells, description)
    values(2, 'Grave Domain', FALSE, 'Gods of the grave watch over the line between life and death.  To these deities, death and the afterlife are a foundational part of the multiverse.  To desecrate the peace of the dead is an abomination.  Deities of the grave include Kelemvor, Wee Jas, the ancestral spirits of the Undying Court, Hades, Anubis, and Osiris.  Followers of these deities seek to put wandering spirits to rest, destroy the undead, and ease the suffering of the dying.  Their magic also allows them to stave off death for a time, particularly for a person who still has some great work to accomplish in the world.  This is a delay of death, not a denial of it, for death will eventually get its due.');

/* Druid */
insert into specializations(class_id, name, provides_spells, description)
    values(3, 'Circle of Dreams', FALSE, 'Druids who are members of the Circle of Dreams hail from regions that have strong ties to the Feywild and its dreamlike realms.  The druids'' guardianship of the natural world makes for a natural alliance between them and the good-aligned fey.  These druids seek to fill the world with dreamy wonder.  Their magic mends wounds and brings joy to downcast hearts, and the realms they protect are gleaming, fruitful places, where dream and reality blur together and where the weary can find rest.');
insert into specializations(class_id, name, provides_spells, description)
    values(3, 'Circle of the Shepherd', FALSE, 'Druids of the Circle of Shepherds commune with the spirits of nature, especially the spirits of beasts and the fey, and call to those spirits for aid.  These druids recognize that all living things play a role in the natural world, yet they focus on protecting animals and fey creatures that have difficulty defending themselves.  Shepherds, as they are known, see such creatures as their charges.  They ward off monsters that threaten them, rebuke hunters who kill more prey than necessary, and prevent civilization from encroaching on rare animal habitats and on sites sacred to the fey.  Many of these druids are happiest far from cities and towns, content to spend their days in the company of animals and the fey creatures of the wilds.
    Members of this circle become adventurers to oppose forces that threaten their charges or to seek knowledge and power that will help safeguard their charges better.  Wherever these druids go, the spirits of the wilderness are with them.');

select c.name, s.name, s.provides_spells, s.description from classes c, specializations s where c.class_id = s.class_id;
/* select * from specializations; */
/* select class_id, name from classes; */

