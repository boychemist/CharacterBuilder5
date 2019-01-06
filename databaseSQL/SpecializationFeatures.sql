drop table if exists spec_features;
create table spec_features(sfeat_id int identity, spec_id int not null, name char(50) not null, level int not null,
description char(4096) not null);
alter table spec_features add foreign key(spec_id) references specializations(spec_id);

/* Path of the Berserker */
insert into spec_features(spec_id, name, level, description)
    values(0, 'Frenzy', 3, 'Starting when you choose this path at 3rd level, you can go into a frenzy when you rage.  If you do so, for the duration of your rage you can make a single melee weapon attack as a bonus action on each of you turns after this one.  When your rage ends, you suffer one level of exhaustion (as described in appendix A of the Player''s Handbook).');
insert into spec_features(spec_id, name, level, description)
    values(0, 'Mindless Rage', 6, 'Beginning at 6th level, you can''t be charmed or frightened while raging.  If you are charmed or frightened when you enter your rage, the effect is suspended for the duration of the rage.');
insert into spec_features(spec_id, name, level, description)
    values(0, 'Intimidating Presence', 10, 'Beginning at 10th level, you can use your actions to frighten someone with your menacing presence.  When you do so, choose one creature that you can see within 30 feet of you.  If the creature can see or hear you, it must succeed on a Wisdom saving throw (DC equal to 8 + your proficiency bonus + your Charisma modifier) or be frightened of until the end of your next turn.  On subsequent turns, you can use your action to extend the duration of this effect on the frightened creature until the end of your next turn.  This effect ends if the creature ends its turn out of line of sight or more than 60 feet away from you.
    If the creature succeeds in its saving throw, you can''t use this feature on that creature again for 24 hours.');
insert into spec_features(spec_id, name, level, description)
    values(0, 'Retaliation', 14, 'Starting at 14th level, when you take damage from a creature that is within 5 feet of you, you can use your reaction to make a melee weapon attack against that creature.');

/* Path of the Totem Warrior */
insert into spec_features(spec_id, name, level, description)
    values(1, 'Spirit Seeker', 3, 'Yours is a path that seeks attunement with the natural world, giving your a kinship to beasts.  At 3rd level when you adopt this path, you gain the ability to cast the "beast sense" and "speak with animals" spells, but only as rituals, as described in chapter 10, "Spellcasting", in the Player''s Handbook.');
insert into spec_features(spec_id, name, level, description)
    values(1, 'Totem Spirit', 3, 'At 3rd level, when you adopt this path, you choose a totem spirit and gain its feature.  You must make or acquire a physical totem object -- an amulet or similar adornment -- that incorporates fur or feathers, claws, teeth, or bones of the totem animal.  At your option, you also gain minor physical attributes that are reminiscent of your totem spirit.  For example, if you have a bear totem spirit, you might be unusually hairy or thick skinned, or if your totem is the eagle, your eyes turn bright yellow.
    Your totem animal might be an animal related to those listed here but more appropriate to your homeland.  For example, you could choose a hawk or vulture in place of an eagle.
    BEAR.
    While raging, you have resistance to all damage except psychic damage.  The spirit of the bear makes you tough enough to stand up to any punishment.
    EAGLE.
    While you''re raging and aren''t wearing heavy armor, other creatures have disadvantage on opportunity attack rolls against you, and you can use the Dash action as a bonus action on your turn.  The spirit of the eagle makes you into a predator who can weave through the fray with ease.
    WOLF.
    While you''re raging, you friends have advantage on melee attack rolls against any creature within 5 feet of you that is hostile to you.  The spirit of the wolf makes you a leader of hunters.');
insert into spec_features(spec_id, name, level, description)
    values(1, 'Aspect of the Beast', 6, 'At 6th level, you gain a magical benefit based on the totem animal of your choice.  You can choose the same animal you selected at 3rd level or a different one.
    BEAR.
    You gain the might of a bear.  Your carrying capacity (including maximum load and maximum lift) is doubled, and you have advantage on Strength checks made to push, pull, lift, or break objects.
    EAGLE.
    You gain the eyesight of an eagle.  You can see up to 1 mile away with no difficulty, able to discern even fine details as though looking at something no more than 100 feet away from you.  Additionally, dim light doesn''t impose disadvantage on your Wisdom(Perception) checks.
    WOLF.
    You gain the hunting sensibilities of a wolf.  You can track other creatures while traveling at a fast pace, and you can move stealthily while traveling at a normal pace (see chapter 8, "Adventuring" in the Player''s Handbook for rules on travel pace.)');
insert into spec_features(spec_id, name, level, description)
    values(1, 'Spirit Walker', 10, 'At 10th level, you can cast the "commune with nature" spell, but only as a ritual.  When you do so, a spiritual version of one of the animals you chose for Totem Spirit or Aspect of the Beast appears to you to convey the information you seek.');
insert into spec_features(spec_id, name, level, description)
    values(1, 'Totemic Attunement', 14, 'At 14th level, you gain a magical benefit based on a totem animal of your choice.  You can choose the same animal you choose previously or a different one.
    BEAR.
    While you''re raging, any creature within 5 feet of you that''s hostile to you has disadvantage on attack rolls against targets other than you or another character with this feature.  An enemy is immune to this effect if it can''t see or hear you or if it can''t be frightened.
    EAGLE.
    While raging, your have a flying speed equal to your current walking speed.  This benefit works only in short bursts; you fall if you end your turn in the air and nothing else is holding you aloft.
    WOLF.
    While you''re raging, you can use a bonus action on your turn to knock a Large or smaller creature prone when you hit it with melee weapon attack.');

/* College of Lore */
insert into spec_features(spec_id, name, level, description)
    values(2, 'Bonus Proficiencies', 3, 'When you join the College of Lore at 3rd level, you gain proficiences with three skills of your choice.');
insert into spec_features(spec_id, name, level, description)
    values(2, 'Cutting Words', 3, 'At 3rd level, you learn how to use your wit to distract, confuse, and otherwise sap the confidence and competence of others.  When a creature that you can see within 60 feet of you makes an attack roll, an ability check, or a damage roll, you can use your reaction to expend one of your uses of Bardic Inspiration, rolling a Bardic Inspiration die and subtracting the number rolled from the creature''s roll.  You can choose to use this feature after the creature makes its roll, but before the DM determines whether the attack roll or ability check succeeds or fails, or before the creature deals its damage.  The creature is immune if it can''t hear you or if it is immune to being charmed.');
insert into spec_features(spec_id, name, level, description)
    values(2, 'Additional Magical Secrets', 6, 'At 6th level, you learn two spells of your choice from any class.  A spell you choose must be of a level you can cast, as shown on the Bard table, or a cantrip.  The chosen spells count as bard spells for you but don''t count against the number of bard spells you know.');
insert into spec_features(spec_id, name, level, description)
    values(2, 'Peerless Skill', 14, 'Starting at 14th level, when you make an ability check, you can expend one use of Bardic Inspiration.  Roll a Bardic Inspiration die and add the number rolled to your ability check.  You can choose to do so after you roll the die for the ability check, but before the DM tells you whether you succeed or fail.');

/* College of Valor */
insert into spec_features(spec_id, name, level, description)
    values(3, 'Bonus Proficiencies', 3, 'When you join the College of Valor at 3rd level, you gain proficiency with medium armor, shields, and martial weapons.');
insert into spec_features(spec_id, name, level, description)
    values(3, 'Combat Inspiration', 3, 'Also at 3rd level, you learn to inspire others in battle.  A creature that has a Bardic Inspiration die from you can roll that die and add the number rolled to a weapon damage roll it just made.  Alternatively, when an attack roll is made against the creature, it can use its reaction to roll the Bardic Inspiration die and add the number rolled to it AC against that attack, after seeing the roll but before knowing if it hits or misses.');
insert into spec_features(spec_id, name, level, description)
    values(3, 'Extra Attack', 6, 'Starting at 6th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.');
insert into spec_features(spec_id, name, level, description)
    values(3, 'Battle Magic', 14, 'At 14th level, you have mastered the art of weaving spellcasting and weapon use into a single harmonious act.  When you use your action to cast a bard spell, you can make one weapon attack as a bonus action.');

/* Knowledge Domain */
insert into spec_features(spec_id, name, level, description)
    values(4, 'Blessings of Knowledge', 1, 'At 1st level, you learn two languages of your choice.  You also become proficient in your choice of two of the following skills:  Arcana, History, Nature, or Religion.
    Your proficiency bonus is doubled for any ability check you make that uses either of these skills.');
insert into spec_features(spec_id, name, level, description)
    values(4, 'Channel Divinity:  Knowledge of the Ages', 2, 'Starting at 2nd level, you can use your Channel Divinity to tap into a divine well of knowledge.  As an action, you can choose one skill or tool.  For 10 minutes, you have proficiency with the chosen skill or tool.');
insert into spec_features(spec_id, name, level, description)
    values(4, 'Channel Divinity:  Read Thoughts', 6, 'At 6th level, you can use your Channel Divinity to read a creature''s thoughts.  You can then use your access to the creature''s mind to command it.
    As an action, choose one creature that you can see within 60 feet of you.  That creature must make a Wisdom saving throw.  If the creature succeeds on the saving throw, you can''t use this feature on it again until you finish a long rest.
    If the creature fails its save, you can read its surface thoughts (those foremost in its mind, reflecting its current emotions and what it is actively thinking about) when it is within 60 feet of you.  This effect lasts for 1 minute.
    During that time, you can use your action to end this effect and cast the "suggestion" spell on the creature without expending a spell slot.  The target automatically fails its saving throw against the spell.');
insert into spec_features(spec_id, name, level, description)
    values(4, 'Potent Spellcasting', 8, 'Starting at 8th level, you add your Wisdom modifier to the damage you deal with any cleric cantrip.');
insert into spec_features(spec_id, name, level, description)
    values(4, 'Visions of the Past', 17, 'Starting 17th level, you can call up visions of the past that relate to an object you hold or you immediate surroundings.  You spend at least 1 minute in meditation and prayer, then receive dreamlike, shadowy glimpses of recent events.  You can meditate in this way for a number of minutes equal to your Wisdom score and must maintain concentration during that time, as if you were casting a spell.
    Once you use this feature, you can''t use it again until you finish a short or long rest.
    OBJECT READING.
    Holding an object as you meditate, you can see visions of the object''s previous owner.  After meditating for 1 minute, you learn how the owner acquired and lost the object, as well as the most recent significant event involving the object and that owner.  If the object was owned by another creature in the recent past (within a number of days equal to your Wisdom score), you can spend 1 additional minute for each owner to learn the same information about that creature.
    AREA READING.
    As you meditate, you see visions of recent events in your immediate vicinity (a room, street, tunnel, clearing, or the like, up to a 50-foot cube), going back a number of days eual to your Wisdom score.  For each minute you meditate, you learn about on significant event, beginning with the most recent.  Significant events typically involve powerful emotions, such as battles and betrayals, marriages and murders, births and funerals.  However, they might also include more mundate events that are nevertheless important to your current situation.'); 

/* Life Domain */
insert into spec_features(spec_id, name, level, description)
    values(5, 'Bonus Proficiency', 1, 'When you choose this domain at 1st level, you gain proficiency with heavy armor.');
insert into spec_features(spec_id, name, level, description)
    values(5, 'Disciple of Life', 1, 'Also starting a 1st level, you healing spells are more effective.  Whenever you use a spell of 1st level or higher to restore hit points to a creature, the creature regains additional hit points equal to 2 + the spell''s level.');
insert into spec_features(spec_id, name, level, description)
    values(5, 'Channel Divinity:  Preserve Life', 2, 'Starting at 2nd level, you can use your Channel Divinity to heal the badly injured.
    As an action, you present your holy symbol and evoke healing energy that can restore a number of hit points equal to five times your cleric level.  Choose any creatures within 30 feet of you, and divide those hit points among them.  This feature can restore a creature to no more than half of its hit point maximum.  You can''t use this feature on an undead or construct.');
insert into spec_features(spec_id, name, level, description)
    values(5, 'Blessed Healer', 6, 'Beginning at 6th level, the healing spells you cast on others heal you as well.  When you cast a spell of 1st level or higher that restores hit points to a creature other than you, you regain hit points equal to 2 + the spell''s level.');
insert into spec_features(spec_id, name, level, description)
    values(5, 'Divine Strike', 8, 'At 8th level, you gain the ability to infuse your weapon strikes with divine energy.  Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 radiant damage to the target.  When you reach 14th level, the extra damage increases to 2d8.');
insert into spec_features(spec_id, name, level, description)
    values(5, 'Supreme Healing', 17, 'Starting at 17th level, when you would normally roll one or more dice to restore hit points with a spell, you instead use the highest number possible for each die.  For example, instead of restoring 2d6 hit points to a creature, you restore 12.');

/* Light Domain */
insert into spec_features(spec_id, name, level, description)
    values(6, 'Bonus Cantrip', 1, 'When you choose this domain at 1st level, you gain the "light" cantrip if you don''t already know it.');
insert into spec_features(spec_id, name, level, description)
    values(6, 'Warding Flare', 1, 'Also at 1st level, you can interpose divine light between yourself and an attacking enemy.  When you are attacked by a creature within 30 feet of you that you can see, you can use your reaction to impose disadvantage on the attack roll, causing light to flare before the attacker before it hits or misses.  An attacker that can''t be blinded is immune to this feature.
    You can use this feature a number of times equal to your Wisdom modifier (a minimum of once).  You regain all expended uses when you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(6, 'Channel Divinity:  Radiance of the Dawn', 2, 'Starting at 2nd level, you can use your Channel Divinity to harness sunlight, banishing darkness and dealing radiance damage to your foes.
    As an action, you present your holy symbol, and any magical darkness within 30 feet of you is dispelled.  Additionally, each hostile creature within 30 feet of you must make a Constitution saving throw.  A creature takes radiant damage equal to 2d10 + your cleric level on a failed saving throw, and half a much damage on a successful one.  A creature that has total cover from you is not affected.');
insert into spec_features(spec_id, name, level, description)
    values(6, 'Improved Flare', 6, 'Starting at 6th level, you can also use your Warding Flare feature when a creature that you can see within 30 feet of you attacks a creature other than you.');
insert into spec_features(spec_id, name, level, description)
    values(6, 'Potent Spellcasting', 8, 'Starting at 8th level, you add your Wisdom modifier to the damage you deal with any cleric cantrip.');
insert into spec_features(spec_id, name, level, description)
    values(6, 'Corona of Light', 17, 'Starting at 17th level, you can use your action to activate an aura of sunlight that lasts for 1 minute or until you dismiss it using another action.  You emit bright light in a 60-foot radius and dim light 30 feet beyond that.  Your enemies in the bright light have disadvantage on saving throws against any spell the deals fire or radiant damage.');

/* Nature Domain */
insert into spec_features(spec_id, name, level, description)
    values(7, 'Acolyte of Nature', 1, 'At 1st level, you learn one druid cantrip of your choice.  You also gain proficiency in one of the following skills of your choice:  Animal Handling, Nature, or Survival.');
insert into spec_features(spec_id, name, level, description)
    values(7, 'Bonus Proficiency', 1, 'Also at 1st level, your gain proficiency with heavy armor.');
insert into spec_features(spec_id, name, level, description)
    values(7, 'Channel Divinity:  Charm Animals and Plants', 2, 'Starting at 2nd level, you can use our Channel Divinity to charm animals and plants.
    As an action, you present your holy symbol and invoke the name of your deity.  Each beast or plant creature that can see you within 30 feet of you makes a Wisdom saving throw.  If the creature fails its saving throw, it is charmed by you for 1 minute or until it takes damage.  While it is charmed by you, it is friendly to you and other creatures you designate.');    
insert into spec_features(spec_id, name, level, description)
    values(7, 'Dampen Elements', 6, 'Starting a 6th level, when you or a creature within 30 feet of you takes acid, cold, fire, lightning, or thunder damage, you can use your action to grant resistance to the creature against that instance of damage.');
insert into spec_features(spec_id, name, level, description)
    values(7, 'Divine Strike', 8, 'At 8th level, you gain the ability to infuse your weapon strikes with divine energy.  Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 cold, fire, or lightning damage (your choice) to the target.  When you reach 14th level, the extra damage increases to 2d8.');
insert into spec_features(spec_id, name, level, description)
    values(7, 'Master of Nature', 17, 'At 17th level, you gain the ability to command animals and plant creatures.  While creatures are charmed by you Charm Animals and Plants feature, you can take a bonus action on your turn to verbally command what each of those creatures will do on its next turn');

/* Tempest Domain */
insert into spec_features(spec_id, name, level, description)
    values(8, 'Bonus Proficiencies', 1, 'At 1st level, you gain proficiency with martial weapons and heavy armor.');
insert into spec_features(spec_id, name, level, description)
    values(8, 'Wrath of the Storm', 1, 'Also at 1st level, you can thunderously rebuke attackers.  When a creature within 5 feet of you that you can see hits you with an attack, you can use your reaction to cause the creature to make a Dexterity saving throw.  The creature takes 2d8 lightning or thunder damage (your choice) on a failed saving throw, and half as much damage on a successful one.
    You can use this feature a number of times equal to your Wisdom modifier (a minimum of once).  You regain all expended uses when you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(8, 'Channel Divinity:  Destructive Wrath', 2, 'Starting at 2nd level, you can use your Channel Divinity to wield the power of the storm with unchecked ferocity.
    When you roll lightning or thunder damage, you can use your Channel Divinity to dal maximum damage, instead of rolling.');
insert into spec_features(spec_id, name, level, description)
    values(8, 'Thunderbolt Strike', 6, 'At 6th level, when you deal lightning damage to a Large or smaller creature, you can also push it up to 10 feet away from you.');
insert into spec_features(spec_id, name, level, description)
    values(8, 'Divine Strike', 8, 'At 8th level, you gain the ability to infuse your weapon strikes with divine energy.  Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 thunder damage to the target.  When you reach 14th level, the extra damage increases to 2d8.');
insert into spec_features(spec_id, name, level, description)
    values(8, 'Stormborn', 17, 'At 17th level, you have flying speed equal to your current walkling speed whenever you are not underground or indoors.');

/* Trickery Domain */
insert into spec_features(spec_id, name, level, description)
    values(9, 'Blessing of the Trickster', 1, 'Starting when you choose this domain at 1st level, you can use your action to touch a willing creature other than yourself to give it advantage on Dexterity(Stealth) checks.  This blessing lasts for 1 hour or until you use this feature again.');
insert into spec_features(spec_id, name, level, description)
    values(9, 'Channel Divinity:  Invoke Duplicity', 2, 'Starting at 2nd level, you can use your Channel Divinity to create an illusory duplicate of yourself.
    As an action, you create a perfect illusion of yourself that lasts for 1 minute, or until you lose your concentration (as if you were concentrating on a spell).  The illusion appears in an unoccupied space that you can see within 30 feet of you.  As a bonus action on your turn, you can move the illusion up to 30 feet to a space you can see, but it must remain within 120 feet of you.
    For the duration, you can cast spells as though you were in the illusion''s space, but you must use your own senses.  Additionally, when both you and your illusion are within 5 feet of a creature that can see the illusion, you have advantage on attack rolls against the creature, given how distracting the illusion is to the target.');
insert into spec_features(spec_id, name, level, description)
    values(9, 'Channel Divinity:  Cloak of Shadows', 6, 'Starting at 6th level, you can use your Channel Divinity to vanish.
    As an action, you become invisible until the end of your next turn.  You become visible if you attack or cast a spell.');
insert into spec_features(spec_id, name, level, description)
    values(9, 'Divine Strike', 8, 'At 8th level, you gain the ability to infuse your weapon strikes with poison -- a gift from your deity.  Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal and extra 1d8 poison damage to the target.  When you reach 14th level, the extra damage increases to 2d8.');
insert into spec_features(spec_id, name, level, description)
    values(9, 'Improved Duplicity', 17, 'At 17th level, you can create up to four duplicates of yourself, instead of one, when you use Invoke Duplicity.  As a bonus action on your turn, you can move any number of them up to 30 feet, to a maximum range of 120  feet.');

/* War Domain */
insert into spec_features(spec_id, name, level, description)
    values(10, 'Bonus Proficiencies', 1, 'At 1st level, you gain proficiency with martial weapons and heavy armor.');
insert into spec_features(spec_id, name, level, description)
    values(10, 'War Priest', 1, 'From 1st level, you god delivers bolts of inspiration to you while you are engated in battle.  When you use the Attack action, you can make one weapon attack as a bonus action.
    You can use this feature a number of times equal to your Wisdom modifier (a minimum of once).  You regain all expended uses when you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(10, 'Channel Divinity:  Guided Strike', 2, 'Starting at 2nd level, you can use your Channel Divinity to strike with supernatural accuracy.  When you make an attack roll, you can use your Channel Divinity to gain a +10 bonus to the roll.  You make this choice after you see the foll, but before the DM says whether the attack hits or misses.');
insert into spec_features(spec_id, name, level, description)
    values(10, 'Channel Divinity:  War God''s Blessing', 6, 'At 6th level, when a creature within 30 feet of you makes an attack roll, you can use your reaction to grant the creature a +10 bonus to the roll, using your Channel Divinity.  You make this choice after you see the roll, but before the DM says whether the attack hits or misses.');
insert into spec_features(spec_id, name, level, description)
    values(10, 'Divine Strike', 8, 'At 8th level, you gain the ability to infuse your weapon strikes with divine energy.  Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal an extra 1d8 damage of the same type dealt by the weapon to the target.  When you reach 14th level, the extra damage increases to 2d8.');
insert into spec_features(spec_id, name, level, description)
    values(10, 'Avatar of Battle', 17, 'At 17th level, you gain resistance to bludgeoning, piercing, and slashing damage from nonmagical weapons.');

/* Circle of the Land */
insert into spec_features(spec_id, name, level, description)
    values(11, 'Bonus Cantrip', 2, 'When you choose this circle at 2nd level, you can learn one additional durid cantrip of your choice.');
insert into spec_features(spec_id, name, level, description)
    values(11, 'Natural Recovery', 2, 'Starting at 2nd level, you can regain some of your magical energy by sitting in meditation and communing with nature.  During a short rest, you choose expended spell slots to recover.  The spell slots can have a combined level tha is equal to or less than half your druid level (rounded up), and none of the slots can be 6th level or higher.  You can''t use this feature again until you finish a long rest.
    For example, when you are a 4th-level druid, you can recover either a 2nd-level slot or two 1st-level slots.');
insert into spec_features(spec_id, name, level, description)
    values(11, 'Circle Spells', 3, 'Your mystical connection to the land infuses you with the ability to cast certain spells.  At 3rd, 5th, 7th, and 9th level you gain access to circle spells connected to the land where you became a druid.  Choose that land -- arctic, coast, desert, forest, grassland, mountain, swamp, or Underdark -- and consult the associated list of spells on page 68 of the Player''s Handbook.
    Once you gain access to a circle spell, you always have it prepared, and it doesn''t count against the number of spells you prepare each day.  If you gain access to a spell that doesn''t appear on the druid spell list, the spell is nontheless a druid spell for you.');
insert into spec_features(spec_id, name, level, description)
    values(11, 'Land''s Stride', 6, 'Starting at 6th level, moving through nonmagical difficult terrain costs you no extra movement.  You can also pass through nonmagical plants without being slowed by them and without taking damage from them if the have thorns, spines, or a similar hazard.
    In addition, you have advantage on saving throws against plants that are magically created or manipulated to impede movement, such as those created by an "entangle" spell.');
insert into spec_features(spec_id, name, level, description)
    values(11, 'Nature''s Ward', 10, 'When you reach 10th level, you can''t be charmed or frightened by elementals or fey, and you are immune to poison and disease.');
insert into spec_features(spec_id, name, level, description)
    values(11, 'Nature''s Sanctuary', 14, 'When you reach 14th level, creatures of the natural world sense your connection to nature and become hesitant to attack you.  When a beast or plant creature attacks you, the creature must make a Wisdom saving throw against your druik spell save DC.  On a failed save, the creature must choose a different target, or the attack automatically misses.');

/* Circle of the Moon */
insert into spec_features(spec_id, name, level, description)
    values(12, 'Combat Wild Shape', 2, 'When you choose this circle at 2nd level, you gain the ability to use Wild Shape on your turn as a bonus action, rather than as an action.
    Additionally, while you are transformed by Wild Shape, you can use a bonus action to expend one spell slot to regain 1d8 hit points per level of the spell slot expended.');
insert into spec_features(spec_id, name, level, description)
    values(12, 'Circle Forms', 2, 'The rites of your circle grant you the ability to transform into more dangerous animal forms.  Starting at 2nd level, you can use your Wild Shape to transform into a beast with a challenge rating as high a 1 (you ignore the Max. CR column of the Beast Shapes table, but must abide by the other limitations there).
    Starting at 6th level, you can transform into a beast with a challenge rating as high as your druid level divided by 3, rounded down.');
insert into spec_features(spec_id, name, level, description)
    values(12, 'Primal Strike', 6, 'Starting at 6th level, your attacks in beast form count as magical for the purpose of overcoming resistance and immunity to nonmagical attacks and damage.');
insert into spec_features(spec_id, name, level, description)
    values(12, 'Elemental Wild Shape', 10, 'At 10th level, you can expend two uses of Wild Shape at the same time to transform into an air elemental, and earth elemental, a fire elemental, or a water elemental.');
insert into spec_features(spec_id, name, level, description)
    values(12, 'Thousand Forms', 14, 'By 14th level, you have learned to use magic to alter your physical form in more subtle ways.  You can cast the "alter self" spell at will.');

/* Champion */
insert into spec_features(spec_id, name, level, description)
    values(13, 'Improved Critical', 3, 'When you choose this archetype at 3rd level, your weapon attacks score a critical hit on a roll of 19 or 20.');
insert into spec_features(spec_id, name, level, description)
    values(13, 'Remarkable Athlete', 7, 'Starting at 7th level, your can add half your proficiency bonus (round up) to any Strength, Dexterity, or Consitution check you make that doesn''t alread use your proficiency bonus.
    In addition, when you make a running long jump, the distance you can cover increases by a number of feet equal to your Strength modifier.');
insert into spec_features(spec_id, name, level, description)
    values(13, 'Additional Fighting Style', 10, 'At 10th level, you can choose a second option from the Fighting Style class feature.');
insert into spec_features(spec_id, name, level, description)
    values(13, 'Superior Critical', 15, 'Starting at 15th level, your weapon attacks score a critical hit on a roll of 18-20.');
insert into spec_features(spec_id, name, level, description)
    values(13, 'Survivor', 18, 'At 18th level, you attain the pinnacle of resilience in battle.  At the start of each of your turns, your regain hit points equal to 5 + your Constitution modifier if you have no more than half your hit points left.  You don''t gain this benefit if you have 0 hit points.');

/* Battle Master */
insert into spec_features(spec_id, name, level, description)
    values(14, 'Combat Superiority', 3, 'When you choose this archetype at 3rd level, you learn maneuvers that are fueled by special dice call superiority dice.
    MANEUVERS.
    You learn three maneuvers of your choice which are detailed under "Manuevers" on page 74 of the Player''s Handbook.  Many maneuvers enhance an attack is some way.  You can use only one maneuver per attack.
    You learn two additional maneuvers of your choice at 7th, 10th, and 15th level.  Each time you learn new maneuvers, you can also replace one maneuver you know with a different one.
    SUPERIORITY DICE.
    You have four superiority dice, which are d8s.  A superiority die is expended when you use it.  You regain all of your expended superiority dice when you finish a short or long rest.  You gain another superiority die at 7th level and one more at 15th level.
    SAVING THROWS.
    Some of your maneuvers require your target to make a saving throw to resist the maneuver''s effects.  The saving throw DC is calculates as follows:
        Maneuver save DC = 8 + your proficiency ponus + your Strength or Dexterity modifier (your Choice)');
insert into spec_features(spec_id, name, level, description)
    values(14, 'Student of War', 3, 'At 3rd level, you gain proficiency with one type of artisan''s tools of your choice.');
insert into spec_features(spec_id, name, level, description)
    values(14, 'Know Your Enemy', 7, 'Starting at 7th level, if you spend at least 1 minute observing or interacting with another creature outide combat, you can learn certain information about its capabilities compared to your own.  The DM tells you if the creature is equal, superiour, or inferior in regard to two of the following characteristics of your choice:
    - Strength score
    - Dexterity score
    - Constitution score
    - Armor Class
    - Current hit points
    - Total class levels (if any)
    - Fighter class levels (if any)');
insert into spec_features(spec_id, name, level, description)
    values(14, 'Improved Combat Superiority', 10, 'At 10th level, your superiority dice turn into d10s.  At 18th level, they turn into d12s.');
insert into spec_features(spec_id, name, level, description)
    values(14, 'Relentless', 15, 'Starting at 15th level, when you roll initiative and have no superiority dice remaining, you regain one superiority die.');

/* Eldritch Knight */
insert into spec_features(spec_id, name, level, description)
    values(15, 'Spellcasting', 3, 'When you reach 3rd level, you augment your martial prowess with the ability to cast spells.  See the "Spellcasting" section on page 75 of the Player''s Handbook for details of this feature.');
insert into spec_features(spec_id, name, level, description)
    values(15, 'Weapon Bond', 3, 'At 3rd level, you learn a ritual that creates a magical bond between yourself and one weapon.  You perform the ritual over the course of 1 hour, which can be done during a short rest.  The weapon must be within your reach throughout the ritual, at the conclusion of which you touch the weapon and forge the bond.
    Once you have bonded a weapon to yourself, you can''t be disarmed of that weapon unless you are incapacitated.  If it is on the same plane of existence, you can summon that weapon as a bonus action on your turn, causing it to teleport instantly to your hand.
    You can have up to two bonded weapons, but can summon only one at a time with your bonus action.  If you attempt to bond with a third weapon, you must break the bond with one of the other two.');
insert into spec_features(spec_id, name, level, description)
    values(15, 'War Magic', 7, 'Beginning at 7th level, when you use your action to cast a cantrip, you can make one weapon attack as a bonus action.');
insert into spec_features(spec_id, name, level, description)
    values(15, 'Eldritch Strike', 10, 'At 10th level, you learn how to make your weapon strikes undercut a creature''s resistance to your spells.  When you hit a creature with a weapon attack, that creature has disadvantage on the next saving throw it makes against a spell you cast before the end of your next turn.');
insert into spec_features(spec_id, name, level, description)
    values(15, 'Arcane Charge', 15, 'At 15th level, you gain the ability to teleport up to 30 feet to an unoccupied space you can see when you use your Action Surge.  You can teleport before or after the additional action.');
insert into spec_features(spec_id, name, level, description)
    values(15, 'Improved War Magic', 18, 'Starting at 18th level, when you use your action to cast a spell, you can make one weapon attack as a bonus action.');

/* Way of the Open Hand */
insert into spec_features(spec_id, name, level, description)
    values(16, 'Open Hand Technique', 3, 'Starting when you choose this tradition at 3rd level, you can manipulate you enemy''s ki when you harnes your own.  Whenever you hit a creature with one of the attacks granted by your Flurry of Blows, you can impose one of the following effects on that target:
    • It must succeed on a Dexterity saving throw or be knocked prone.
    • It must make a Strength saving throw.  If it fails, you can push it up to 15 feet away from you.
    • It can''t take reactions until the end of your next turn.');
insert into spec_features(spec_id, name, level, description)
    values(16, 'Wholeness of Body', 6, 'At 6th level, you gain the ability to heal yourself.  As an action, you can regain hit points equal to three times your monk level.  You must finish a long rest before you can use this feature again.');
insert into spec_features(spec_id, name, level, description)
    values(16, 'Tranquility', 11, 'Beginning at 11th level, you can enter a special meditation that surrounds you with an aura of peace.  At the end of a long rest, you gain the effect of a "sanctuary" spell that lasts until the start of your next long rest (the spell can end early as normal).  The saving throw DC for the spell equals 8 + your Wisdom modifier + your proficiency bonus.');
insert into spec_features(spec_id, name, level, description)
    values(16, 'Quivering Palm', 17, 'At 17th level, you gain the ability to set up lethal vibrations in someone''s body.  When you hit a creature with an unarmed strike, you can spend 3 ki points to start these imperceptible vibrations, which last for a number of days equal to our monk level.  The vibrations are harmless unless you use their action to end them.  To do so, you and the target must be on the same plane of existence.  When you use this action, the creature must make a Consitituion saving throw.  If it fails, it is reduced to 0 hit points.  If it succeeds, it takes 10d10 necrotic damage.
    You can have only one creature under the effect of this feature at a time.  You can choose to end the vibrations harmlessly without using an action.');

/* Way of Shadow */
insert into spec_features(spec_id, name, level, description)
    values(17, 'Shadow Arts', 3, 'When you choose this tradition at 3rd level, you can use your ki points to duplicate the effects of certain spells.  As an action you can spend 2 ki points to cast "darkness", "darkvision", "pass without trace", or "silence", without providing material components.  Additionally, you gain the "minor illusion" cantrip if you don''t already know it.');
insert into spec_features(spec_id, name, level, description)
    values(17, 'Shadow Step', 6, 'At 6th level, you gain the ability to step from one shadow into another.  When you are in dim light or darkness, as a bonus action you can teleport up to 60 feet to an unoccupied space you can see that is also in dim light or darkness.  You then have advantage on the first melee attack you make before the end of the turn.');
insert into spec_features(spec_id, name, level, description)
    values(17, 'Cloak of Shadows', 11, 'By 11th level, you have learned to become one with the shadows.  When you are in an area of dim light or darkness, you can use your action to become invisible.  You remain invisible until you make an attack, cast a spell, or in an area of bright light.');
insert into spec_features(spec_id, name, level, description)
    values(17, 'Opportunist', 17, 'At 17th level, you can exploit a creature''s momentary distraction when it is hit by an attack.  Whenever a creature within 5 feet of you is hit by an attack made by a creature other than you, you can use your reaction to make a melee attack against that creature.');

/* Way of the Four Elements */
insert into spec_features(spec_id, name, level, description)
    values(18, 'Discipline of Elements', 3, 'When you choose this tradition at 3rd level, you learn magical disciplines to harness the power of the four elements.  A discipline requires you to spend ki points each time you use it.
    You know the Elemental Attunement disciplien and one other elemental discipline of your choice, which are detailed in the "Elemental Disciplines" section on page 81 of the Player''s Handbook.  You learn one additional elemental discipline of your choice at 6th, 11th, and 17th level.
    Whenever you learn a new elemental discipline, you can also replace on elemental discipline that you already know with a different discipline.
    CASTING ELEMENTAL SPELLS.
    Some elemental disciplines allow you to cast spells.  See chapter 10 of the Player''s Handbook for the general rules of spellcasting.  To cast one of these spells, you use its casting time and other rules, but you don''t need to provide material components for it.
    Once you reach 5th level in this class, you can spend additional ki points to increase the level of an elemental discipline spell that you cast, provided that the spell has an enhanced effect at a higher level, as "burning hands", you can spend 3 ki points to cast it as a 2nd-level spell (the discipline''s base cost of 2 ki points plus 1).
    The maximum number of ki points you can spend to cast a spell in this way (including the base ki point cost and any additional ki points you spend to increase it level) is determined by your monk level, as shown in the Spells and Ki Points table.
    
    SPELLS and KI POINTS
    
      Monk Levels   Maximum Ki Points for a Spell
       5th-8th                3
       9th-12th               4
      13th-16th               5
      17th-20th               6');

/* Oath of Devotion */
insert into spec_features(spec_id, name, level, description)
    values(19, 'Channel Divinity', 3, 'When you take this oath at 3rd level, you gain the following two Channel Divinity options.
    SACRED WEAPONS.
    As an action, you can imbue one weapon that you are holding with positive energy, using your Channel Divinity.  For 1 minute, you add your Charisma modifier to attack rolls made with that weapon (with a minumum bonus of +1).  The weapon also emits bright light in a 20-foot radius and dim light 20 feet beyond that.  If the weapon is not already magical, it becomes magical for the duration.
    You can end this effect on you turn as part of any other action.  If you are no longer holding or carrying this weapon, or if you fall unconscious, the effect ends.
    TURN THE UNHOLY.
    As an action, you present your holy symbol and speak of prayer censuring fiends and undead, using your Channel Divinity.  Each fiend or undead that can see or hear you within 30 feet of you must make a Wisdom saving throw.  If the creature fails its saving throw, it is turned for 1 minute or until it takes damage.  A turned creature must spend its turns trying to move as far away from you as it can, and it can''t willingly move to a space within 30 feet of you.  It also can''t tak reactions.  For its action, it can only use the Dash action or try to escape from an effect tha prevents it from moving.  If there''s nowhere to move, the creature can use the Dodge action.');
insert into spec_features(spec_id, name, level, description)
    values(19, 'Aura of Devotion', 7, 'Starting at 7th level, you and friendly creatures within 10 feet of you can''t be charmed while you are conscious.
    At 18th level, the range of this aura increases to  30 feet.');
insert into spec_features(spec_id, name, level, description)
    values(19, 'Purity of Spirit', 15, 'Beginning at 15th level, you are always under the effects of a ''protection from evil and good'' spell');
insert into spec_features(spec_id, name, level, description)
    values(19, 'Holy Nimbus', 20, 'At 20th level, as an action, you can emanate an aura of sunlight.  For 1 minute, bright light shines from you in a 30-foot radius, and dim light shines 30 feet beyond that.
    Whenever an enemy creature starts its turn in the bright light, the creature takes 10 radiant damage.
    In addition, for the duration, you have advantage on saving throws against spells cast by fiends or undead.
    Once you use this feature, you can''t use it again until you finish a long rest.');

/* Oath of the Ancients */
insert into spec_features(spec_id, name, level, description)
    values(20, 'Channel Divinity', 3, 'When you take this oath at 3rd level, you gain the following two Channel Divinity options.
    NATURE''S WRATH
    You can use your Channel Divinity to invoke primeval forces to ensnare a foe.  As an action, you can cause spectral vines to spring up and reach for a creature within 10 feet of you that you can see.  The creature must succeed on a Strength of Dexterity saving throw (its choice) or be restrained.  While restrained by the vines, the creature repeats the saving throw at the end of each of its turns.  On a success, it frees itself and the vines vanish.
    TURN THE FAITHLESS
    You can use your Channel Divinity to utter ancient words that are painful for fey and fiends to hear.  As an action, you present your holy symbol, and each fey or fiend within 30 feet of you that can hear you must make a Wisdom saving throw.  On a failed save, the creature is turned for 1 minute or until it takes damage.
    A turned creature must spend it turns trying to move as far away from you as it can, and it can''t willingly move to a space within 30 feet of you.  It also can''t take reactions.  For its action, it can only use the Dash action or try to escape from an effect that prevents it from moving.  If there''s nowhere to move, the creature can use the Dodge action.
    If the creature''s true form is concealed by an illusion, shapeshifting, or other effect, that form is revealed while it is turned.');
insert into spec_features(spec_id, name, level, description)
    values(20, 'Aura of Warding', 7, 'Beginning at 7th level, ancient magic lies so heavily upon you that it forms an eldritch ward.  You and friendly creatures within 10 feet of you have resistance to damage from spells.
    At 18th level, the range of this aura increases to 30 feet.');
insert into spec_features(spec_id, name, level, description)
    values(20, 'Undying Sentinel', 15, 'Starting at 15th level, when you are reduced to 0 hit points and are not killed outright, you can choose to drop to 1 hit point instead.  Once you use this ability, you can''t use it again until you finish a long rest.
    Additionally, you suffer none of the drawbacks of old age, and you can''t be aged magically.');
insert into spec_features(spec_id, name, level, description)
    values(20, 'Elder Champion', 20, 'At 20th level, you can assume the form of an ancient force of nature, taking on an appearance you choose.  For example, your skin might turn bright green or take on a bark-like texture, your hair might become leafy or moss-like, or you might sprout antlers or a lion-like mane.
    Using your action, you undergo a transformation.  For 1 minute, you gain the following benefits:
    
    • At the start of each of you turns, you regain 10 hit points.
    • Whenever you cast a paladin spell that has a casting time of 1 action, you can cast it using a bonus action instead.
    • Enemy creatures within 10 feet of you have disadvantage on saving throws against your paladin spells and Channel Divinity options.
    
    Once you use this feature, you can''t use it again until you finish a long rest.');

/* Oath of Vengeance */
insert into spec_features(spec_id, name, level, description)
    values(21, 'Channel Divinity', 3, 'When you take this oath at 3rd level, you gain the following two Channel Divinity options.
    ABJURE ENEMY
    As an action, you present your holy symbol and speak a prayer of denunciation, using your Channel Divinity.  Choose one creature whithin 60 feet of you that you can see.  That creature must make a Wisdom saving throw, unless it is immune to being frightened.  Fiends and undead have disadvantage on this saving throw.
    On a failed save, the creature is frightened for 1 minute or until it takes any damage.  While frightened, the creature''s speed is 0, and it can''t benefit from any bonus to its speed.
    On a successful save, the creature''s speed is halved for 1 minute or until the creature takes any damage.
    VOW OF ENMITY
    As a bonus action, you can utter a vow of enmity against a creature you can see within 10 feet of you, using your Channel Divinity.  You gain advantage on attack rolls against the creature for 1 minute or until it drops to 0 hit points or falls unconscious.');
insert into spec_features(spec_id, name, level, description)
    values(21, 'Relentless Avenger', 7, 'By 7th level, your supernatural focus helps you close off a foe''s retreat.  When you hit a creatur with and opportunity attack, you can move up to half your speed immediately after the attack and as part of the same reaction.  This movement doesn''t provide opportunity attacks.');
insert into spec_features(spec_id, name, level, description)
    values(21, 'Soul of Vengeance', 15, 'Starting at 15th level, the authority with which you speek you Vow of Enmity gives you greater power over your foe.  When a creature under the effect of your Vow of Enmity makes an attack, you can use your reaction to make a melee weapon attack against that creature if it is within range.');
insert into spec_features(spec_id, name, level, description)
    values(21, 'Avenging Angel', 20, 'At 20th level, you can assume the form of an angelic avenger.  Using your action, you undergo a transformation.  For 1 hour, you gain the following benefits:
    
    • Wings sprout from you back and grant you a flying speed of 60 feet.
    • You emanate an aura of menace in a 30-foot radius.  The first time any enemy creature enters the aura or starts its turn there during a battle, the creature must succeed on a Wisdom saving throw or become frightened of you for 1 minute or until it takes any damage.  Attack rolls against the frightened creature have advantage.
    
    Once you use this feature, you can''t use it again until you finish a long rest.');

/* Hunter */
insert into spec_features(spec_id, name, level, description)
    values(22, 'Hunter''s Prey', 3, 'At 3rd level, you gain one of the following features of your choice.
    COLOSSUS SLAYER
    Your tenacity can wear down the most potent foes.  When you hit a creature with a weapon attack, the creature takes an extra 1d8 damage if it''s below its hit point maximum.  You can deal this extra damage only once per turn.
    GIANT KILLER
    When a Large or larger creature within 5 feet of you hits or misses you with an attack, you can use your reaction to attack that creature immediately after its attack, provided you can see the creature.
    HORDE BREAKER
    Once on each of your turns when you make a weapon attack, you can make another attack with the same weapon against a different creature that is within 5 feet of the original target and within range of your weapon.');
insert into spec_features(spec_id, name, level, description)
    values(22, 'Defensive Tactics', 7, 'At 7th level, you gain one of the following features of your choice.
    ESCAPE THE HORDE
    Opportunity attacks against you are made with disadvantage.
    MULTIATTACK DEFENSE
    When a creature hits you with an attack, you gain +4 bonus to AC against all subsequent attacks made by that creature fot the rest of the turn.
    STEEL WILL
    You have advantage on saving throws against being frightened.');
insert into spec_features(spec_id, name, level, description)
    values(22, 'Multiattack', 11, 'At 11th level, you gain one of the following features of your choice.
    VOLLEY
    You can use your action to make a ranged attack against any number of creatures within 10 feet of a point you can see within your weapon''s range.  You must have ammunition for each target, as normal, and you make a separate attack roll for each target.
    WHIRLWIND ATTACK
    You can use your action to make a melee attack against any number of creature withing 5 feet of you, with a separate attack roll for each target.');
insert into spec_features(spec_id, name, level, description)
    values(22, 'Superior Hunter''s Defense', 15, 'At 15th level, you gain one of the following features of your choice.
    EVASION
    When you are subjected to an effect, such as a red dragon''s fiery breath or a ''lightning bolt'' spell, that allows you to make a Dexterity saving throw to take only half damage, you instead take no damage if you succeed on the saving throw, and only half damage if you fail.
    STAND AGAINST THE TIDE
    When a hostile creature misses you with a melee attack, you can use your reaction to force that creature to repeat the same attack against another creature (other than itself) of your choice.
    UNCANNY DODGE
    When an attacker that you can see hits you with an attack, you can use your reaction to halve the attack''s damage against you.');

/* Beast Master */
insert into spec_features(spec_id, name, level, description)
    values(23, 'Ranger''s Companion', 3, 'At 3rd level, you gain a beast companion that accompanies you on your adventures and is trained to fight alongside you.  Choose a beast that is no larger than Medium and that has a challenge rating of 1/4 or lower (appendix D of the Player''s Handbook presents statistics for the hawk, mastif, and panther as examples).  Add your proficiency bonus to the beast''s AC, attack rolls, and damage rolls, as well as to any saving throws and skills it is proficient in.  Its hit point maximum equals the hit point number in its stat block or four times your ranger level, whichever is higher.  Like any creature, it can spend Hit Dice during a short rest to regain hit points.
    The beast obeys your commands as best at it can.  It takes its turn on your initiative, though it doesn''t take an action unless you command it to.  On your turn, you can verbally command the beast where to move (no action required by you).  You can use your action to verbally command it to take the Attack, Dash, Disengage, Dodge, or Help action.  Once you have the Extra Attack feature, you can make on weapon attack yourself when you command the beast to take the Attack action.
    If you are incapacitated or absent, the beast acts on its own, focusing on protecting you and itself.  The beast never requires your command to use its reaction, such as when making an opportunity attack.
    When traveling through your favorite terrain with only the beast, you can move stealthily at a normal pace.
    If the beast dies, you can obtain a new companion by spending 8 hours magically bonding with a beast that isn''t hostile to you and that meets the requirements.');
insert into spec_features(spec_id, name, level, description)
    values(23, 'Exceptional Training', 7, 'Beginning at 7th level, on any of your turns when your beast companion doesn''t attack, you can use a bonus action to command the beast to take the Dash, Disengage, Dodge, or Help action on its turn.');
insert into spec_features(spec_id, name, level, description)
    values(23, 'Bestial Fury', 11, 'Starting at 11th level, when you command your beast companion to take the Attack action, the beast can make two attacks, or it can take the Multiattack action if it has that action.');
insert into spec_features(spec_id, name, level, description)
    values(23, 'Share Spells', 15, 'Beginning at 15th level, when you cast a spell targeting yourself, you can also affect your beast companion with the spell if it is within 30 feet of you.');

/* Thief */
insert into spec_features(spec_id, name, level, description)
    values(24, 'Fast Hands', 3, 'Starting at 3rd level, you can use the bonus action granted by your Cunning Action to make a Dexterity (Slieght of Hand) check, use your thieves'' tools to disarm a trap or open a lock, or take the Use an Object action.');
insert into spec_features(spec_id, name, level, description)
    values(24, 'Second-Story Work', 3, 'When you choose this archetype at 3rd level, you gain the ability to climb faster than normal; climbing no longer costs you extra movement.
    In addition, when you make a running jump, the distance you cover increases by a number of feet equal to your Dexterity modifier.');
insert into spec_features(spec_id, name, level, description)
    values(24, 'Supreme Sneak', 9, 'Starting at 9th level, you have advantage on a Dexterity (Stealth)check if you move no more than half you speed on the same turn.');
insert into spec_features(spec_id, name, level, description)
    values(24, 'Use Magic Device', 13, 'By 13th level, you have learned enough about the workings of magic that you can improvise the use of items even when they are not intended for you.  You ignore all class, race, and level requirements on the use of magic items.');
insert into spec_features(spec_id, name, level, description)
    values(24, 'Thief''s Reflexes', 17, 'When you reach 17th level, you have become adept at laying ambushed and quickly escaping danger.  You can take two turns during the first round of any combat.  You take your first turn at your normal initiative and your second turn at your initiative minus 10.  You can''t use this feature when you are surprised.');

/* Assassin */
insert into spec_features(spec_id, name, level, description)
    values(25, 'Bonus Proficiencies', 3, 'When you choose this archetype at 3rd level, you gain proficiency with the disguise kit and the poisoner''s kit.');
insert into spec_features(spec_id, name, level, description)
    values(25, 'Assassinate', 3, 'Starting at 3rd level, you are at your deadliest when you get the drop on you enemies.  You have advantage on attack rolls against any creature that hasn''t taken a turn in combat yet.  In addition, any hit you score against a creature that is surprised is a critical hit.');
insert into spec_features(spec_id, name, level, description)
    values(25, 'Infiltration Expertise', 9, 'Starting at 9th level, you can unfailingly create false identities for yourself.  You must spend seven days and 25 gp to establish the history, profession, and affiliations for an identity.  You can''t establish an identity that belongs to someone else.  For example, you might acquire appropriate clothing, letters of introduction, and official-looking certification to establish yourself as a member of a trading house from a remote city so you can insinuate yourself into the company of other wealthy merchants.
    Thereafter, if you adopt the new identity as a disguise, other creatures believe you to be that person until given an obvious reason to to.');
insert into spec_features(spec_id, name, level, description)
    values(25, 'Imposter', 13, 'At 13th level, you gain the ability to unerringly mimic another person''s speech, writing, and behavior.  You must spend at least three hours studying these three components of the person''s behavior, listening to speech, examining handwriting, and observing mannerisms.
    Your ruse is indiscernible to the casual observer.  If a wary creature suspects something is amiss, you have advantage on any Charisma (Deception) check you make to avoid detection.');
insert into spec_features(spec_id, name, level, description)
    values(25, 'Death Strike', 17, 'Starting at 17th level, you become a master of instant death.  When you attack and hit a creature that is suprised, it must make a Constituion saving throw (DC 8 + your Dexterity modifier + your proficiency bonus).  On a failed save, double the damage of your attack against the creature.');

/* Arcane Trickster */
insert into spec_features(spec_id, name, level, description)
    values(26, 'Spellcasting', 3, 'When your reach 3rd level, you gain the ability to cast spells.  See chapter 10 of the Player''s Handbook for the general rules of spellcasting and chapter 11 for the wizard spell list.
    CANTRIPS
    You learn three cantrips: ''mage hand'' and two other cantrips of your choice from the wizard spell list.  You learn another wizard cantrip of your choice at 10th level.
    SPELL SLOTS
    The Arcane Trickster Spellcasting table shows how many spell slots you have to cast your spells of 1st level and higher.  To cast one of these spells, you must expend a slot of the spell''s level or higher.  You regain all expended spell slots when you finish a long rest.
    For example, if you know the 1st-level spell ''charm person'' and have a 1st-level and a 2nd-level spell slot available, you can cast ''charm person'' using either slot.
    SPELLS KNOWN OF 1ST-LEVEL AND HIGHER
    You know three 1st-level wizard spells of you choice, two of which you must choose from the enchantment and illusion spells on the wizard spell list.
    The Spells Know column of the Arcane Trickster Spellcasting table shows when you learn more wizard spells of 1st level or higher.  Each of these spells must be an enchantment or illusion spell of your choice, and must be of a level for which you have spell slots.  For instance, when you reach 7th level in this class, you can learn one new spell of 1st or 2nd level.
    The spells you learn at 8th, 14th, and 20th level can be from any school of magic.
    Whenever you gain a level in this class, you can replace one of the wizard spells you know with another spell of your choice from the wizard spell list.  The new spell must be of a level for which you hav spell slots, and it must be an enchantment or illusion spell, unless you''re replacing the spell you gained at 8th, 14th, or 20th level.
    SPELLCASTING ABILITY
    Intelligence is your spellcasting ability for your wizard spells, since you learn your spells through dedicated study and memorization.  You use your Intelligence whenever a spell refers to your spellcasting ability.  In addition, you use your Intelligence modifier when setting the saving throw DC for a wizard spell you cast and when making an attack roll with one.
    	Spell save DC = 8 + your proficiency bonus + your Intelligence modifier
    	Spell attack modifier = your proficiency bonus + your Intelligence modifier');
insert into spec_features(spec_id, name, level, description)
    values(26, 'Mage Hand Legerdemain', 3, 'Starting at 3rd level, when you cast ''mage hand'', you can make the spectral hand invisible, and you can perform the following additional tasks with it:
    
    • You can stow one object the hand is holding in a container worn or carried by another creature.
    • You can retrieve an object in a container worn or carried by another creature.
    • You can use thieves'' tools to pick locks and disarm traps at range.
    
    You can perform one of these tasks without being noticed by a creature if you succeed on a Dexterity (Sleight of Hand) check contested by the creature''s Wisdom (Perception) check.
    In addition, you can use the bonus action granted by your Cunning Action to control the hand.');
insert into spec_features(spec_id, name, level, description)
    values(26, 'Magical Ambush', 9, 'Starting at 9th level, if you are hidden from a creature when you cast a spell on it, the creature has disadvantage on any saving throw it makes against the spell this turn.');
insert into spec_features(spec_id, name, level, description)
    values(26, 'Versatile Trickster', 13, 'At 13th level, you gain the ability to distract targets with your ''mage hand''.  As a bonus action on your turn, you can designate a creature within 5 feet of the spectral hand created by the spell.  Doing so gives you advantage on attack rolls against that creature until the end of the turn.');
insert into spec_features(spec_id, name, level, description)
    values(26, 'Spell Thief', 17, 'At 17th level, you gain the ability to magically steal the knowledge of how to cast a spell from another spellcaster.
    Immediately after a creature casts a spell that targets you or includes you in its area of effect, you can use your reaction to force the creature to make a saving throw with its spellcasting ability modifier.  The DC equals your spell save DC.  On a failed save, you negate the spell''s effect against you, and you steal the knowledge of the spell if it is at least 1st level and of a level you can cast (it doesn''t need to be a wizard spell).  For the next 8 hours, you know the spell and can cast it using one of your spell slots.  The creature can''t cast that spell until the 8 hours have passed.
    Once you use this feature, you can''t use it again until you finish a long rest.');

/* Draconic Bloodline */
insert into spec_features(spec_id, name, level, description)
    values(27, 'Dragon Ancestor', 1, 'At 1st level, you choose one type of dragon as your ancestor.  The damage type associated with each dragon is used by features you gain later.
    
    DRACONIC ANCESTRY
    Dragon            Damage Type
    ---------         -----------
    Black             Acid
    Blue              Lightning
    Brass             Fire
    Bronze            Lightning
    Copper            Acid
    Gold              Fire
    Green             Poison
    Red               Fire
    Silver            Cold
    White             Cold
    
    You can speak, read, and write Draconic.  Additionally, whenever you make a Charisma check when interacting with dragons, you proficiency bonus is doubled if it applies to the check.');
insert into spec_features(spec_id, name, level, description)
    values(27, 'Draconic Resilience', 1, 'As magic flows through your body, it causes physical traits of your dragon ancestors to emerge.  At 1st level, you hit point maximum increases by 1 and increases by 1 again whenever you gain a level in this class.
    Additionally, parts of your skin are covered by a thin sheen of dragon-like scales.  When you aren''t wearing armor, your AC equals 13 = your Dexterity modifier.');
insert into spec_features(spec_id, name, level, description)
    values(27, 'Elemental Affinity', 6, 'Starting at 6th level, when you cast a spell that deals damage of the type associated with your draconic ancestry, your can add your Charisma modifier to one damage roll of that spell.  At the same time, you can spend 1 sorcery poin to gain resistance to that damage type for 1 hour.');
insert into spec_features(spec_id, name, level, description)
    values(27, 'Dragon Wings', 14, 'At 14th level, you gain the ability to sprout a pair of dragon wings from your back, gaining a flying speed equal to your current speed.  You can create these wings as a bonus action on your turn.  They last until you dismiss them as a bonus action on your turn.
    You can''t manifest your wings while wearing armor unless the armor is made to accommodate them, and clothing not made to accommodate your wings might be destroyed when you manifest them.');
insert into spec_features(spec_id, name, level, description)
    values(27, 'Draconic Presence', 18, 'Beginning at 18th level, you can channel the dread presence of your dragon ancestor, causing those around you to become awestruck or frightened.  As an action, you can spend 5 sorcery points to draw on this power and exude an aura of awe or fear (your choice) to a distance of 60 feet.  For 1 minute, or until you lose your concentration (as if you were casting a concentration spell), each hostile creature that starts its turn in this aura must succeed on a Wisdom saving throw or be charmed (if you chose awe) or frightened (if you chose fear) until the aura ends.  A creature that succeeds on this saving throw is immune to your aura for 24 hours.');

/* Wild Magic */
insert into spec_features(spec_id, name, level, description)
    values(28, 'Wild Magic Surge', 1, 'Starting when you choose this origin at 1st level, your spellcasting can unleash surges of untamed magic.  Once per turn, the DM can have you roll a d20 immediately after you cast a sorcerer spell of 1st level or higher.  If you roll a 1, roll on the Wild Magic Surge table to create a magical effect.  If that effect is a spell, it is too wild to be affected by your Metamagic, and if it normally requires concentration, it doesn''t require concentration in this case; the spell lasts for its full duration.');
insert into spec_features(spec_id, name, level, description)
    values(28, 'Tides of Chaos', 1, 'Starting at 1st level, you can manipulate the forces of chance and chaos to gain advantage on one attack roll, ability check, or saving throw.  Once you do so, you must finish a long rest before you can use this feature again.
    Any time before you regain the use of this feature, the DM can have you roll on the Wild Magic Surge table immediately after you cast a sorcerer spell of 1st level or higher.  You then regain the use of this feature.');
insert into spec_features(spec_id, name, level, description)
    values(28, 'Bend Luck', 6, 'Starting at 6th level, you have the ability to twist fate using your wild magic.  When another creature you can see makes an attack roll, an ability check, or a saving throw, you can use your reaction and spend 2 sorcery points to roll 1d4 and apply the number rolled as a bonus or penalty (your choice) to the creature''s roll.  You can do so after the creature rolls but before any effects of the roll occur.');
insert into spec_features(spec_id, name, level, description)
    values(28, 'Controlled Chaos', 14, 'At 14th level, you gain a modicum of control over the surges of your wild magic.  Whenever you roll on the Wild Magic Surge table, you can roll twice and use either number.');
insert into spec_features(spec_id, name, level, description)
    values(28, 'Spell Bombardment', 18, 'Beginning at 18th level, the harmful energy of your spells intensifies.  When you roll damage for a spell and roll the highest number possible on any of the dice, choose one of those dice, roll it again, and add that roll to the damage.  You can use the feature only once per turn.');

/* The Archfey */
insert into spec_features(spec_id, name, level, description)
    values(29, 'Fey Presence', 1, 'Starting at 1st level, your patron bestows upon you the ability to project the beguiling and fearsome presence of the fey.  As an action, you can cause each creature in a 10-foot cube originating from you to make a Wisdom saving throw against your warlock spell save DC.  The creatures that fail their saving throws are all charmed or frightened by you (your choice) until the end of your next turn.
    Once you use this feature, you can''t use it again until you finish a short or long rest.');
insert into spec_features(spec_id, name, level, description)
    values(29, 'Misty Escape', 6, 'Starting at 6th level, you can vanish in a puff of mist in response to harm.  When you take damage, you can use your reaction to turn invisible and teleport up to 60 feet to an unoccupied space you can see.  You remain invisible until the start of your next turn or until you attack or cast a spell.
    Once you use this feature, you can''t use it again until you finish a short or long rest.');
insert into spec_features(spec_id, name, level, description)
    values(29, 'Beguiling Defenses', 10, 'Beginning at 10th level, your patron teaches you how to turn the mind-affecting magic of your enemies against them.  You are immune to being charmed, and when another creature attempts to charm you, you can use your reaction to attempt to turn the charm back on that creature.  The creature must succeed on a Wisdom saving throw against your warlock spell save DC or be charmed by you for 1 minute or until the creature takes any damage.');
insert into spec_features(spec_id, name, level, description)
    values(29, 'Dark Delirium', 14, 'Starting at 14th level, you can plunge a creature into an illusory realm.  As an action, choose a creature that you can see within 60 feet of you.  If must make a Wisdom saving throw against your warlock spell save DC.  On a failed save, it is charmed or frightened by you (your choice) for 1 minute or until your concentration is broken (as if you were concentrating on a spell).  This effect ends early if the creature takes any damage.
    Until this illusion ends, the creature thinks it is lost in a misty realm, the appearance of which you choose.  The creature can see and hear only itself, you, and the illusion.
    You must finish a short or long rest befor you can use this feature again.');

/* The Fiend */
insert into spec_features(spec_id, name, level, description)
    values(30, 'Dark One''s Blessing', 1, 'Starting at 1st level, when you reduce a hostile creature to 0 hit points, you gain temporary hit points equal to your Charisma modifier + your warlock level (minimum of 1).');
insert into spec_features(spec_id, name, level, description)
    values(30, 'Dark One''s Own Luck', 6, 'Starting at 6th level, you can call on your patron to alter fate in your favor.  When you make an ability check or a saving throw, you can use this feature to add a d10 to your roll.  You can do this after seeing the initial roll but before any of the roll''s effects occur.
    Once you use this feature, you can''t use it again until you finish a short or long rest.');
insert into spec_features(spec_id, name, level, description)
    values(30, 'Fiendish Resilience', 10, 'Starting at 10th level, you can choose one damage type when you finish a short or long rest.  You gain resistance to that damage type until you choose a different one with this feature.  Damage from magical weapons or silver weapons ignores this resistance.');
insert into spec_features(spec_id, name, level, description)
    values(30, 'Hurl Through Hell', 14, 'Starting at 14th level, when you hit a creature with an attack, you can use this feature to instantly transport the target through the lower planes.  The creature disappears and hurtles through a nightmare landscape.
    At the end of your next turn, the target returns to the space it previously occupied, or the nearest unoccupied space.  If the target is not a fiend, it takes 10d10 psychic damage as it reels from its horrific experience.
    Once you use this feature, you can''t use it again until you finish a long rest.');

/* The Great Old One */
insert into spec_features(spec_id, name, level, description)
    values(31, 'Awakened Mind', 1, 'Starting at 1st level, your alien knowledge give you the ability to touch the minds of other cretures.  You can telepathically speak to any creature you can see within 30 feet of you.  You don''t need to share a language with the creature for it to understand your telepathic utterances, but the creature must be able to understand at least one language.');
insert into spec_features(spec_id, name, level, description)
    values(31, 'Entropic Ward', 6, 'At 6th level, you learn to magically ward yourself against attack and to turn an enemy''s failed strike into good luck for yourself.  When a creature makes an attack roll against you, your can use your reaction to impose disadvantage on that roll.  If the attack misses you, your next attack roll against the creature has advantage if you make it before the end of your next turn.
    Once you use this feature, you can''t use it again until you finish a short or long rest.');
insert into spec_features(spec_id, name, level, description)
    values(31, 'Thought Shield', 10, 'At 10th level, you thoughts can''t be read by telepathy or other means unless you allow it.  You also have resistance to psychic damage, and whenever a creature deals psychic damage to you, that creature takes the same amount of damage that you do.');
insert into spec_features(spec_id, name, level, description)
    values(31, 'Create Thrall', 14, 'At 14th level, you gain the ability to infect a humanoid''s mind with the alien magic of your patron.  You can use your action to touch and incapacitated humanoid.  That chreature is then charmed by you until a ''remove curse'' spell is cast on it, the charmed condition is removed from it, or you use this feature again.
    You can communicate with telepathically with the charmed creature as long as the two of you are on the same plane of existence.');

/* School of Abjuration */
insert into spec_features(spec_id, name, level, description)
    values(32, 'Abjuration Savant', 2, 'Beginning when you select this school at 2nd level, the gold and time you must spend to copy an abjuration spell into your spellbook is halved.');
insert into spec_features(spec_id, name, level, description)
    values(32, 'Arcane Ward', 2, 'Starting at 2nd level, you can weave magic around yourself for protection.  When you cast an abjuration spell of 1st level or higher, you can simultaneously use a strand of the spell''s magic to create a magical ward on yourself that lasts until you finish a long rest.  The ward has a hit maximum equal to twice your wizard level + your Intelligence modifer.  Whenever you take damage, the ward takes damage instead.  If this damage reduces the ward to 0 hit points, you take any remaining damage.
    When the ward has 0 hit points, it can''t absorb damage, but its magic remains.  Whenever you cast an abjuration spell of 1st level or higher, the ward regains a number of hit points equal to twice the level of the spell.
    Once you create a ward, you can''t create it again until you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(32, 'Projected Ward', 6, 'Starting at 6th level, when a creature that you can see within 30 feet of you takes damage, you can use your reaction to cause your Arcane Ward to absorb that damage.  If this damage reduces the ward to 0 hit points, the warded creature takes any remaining damage.');
insert into spec_features(spec_id, name, level, description)
    values(32, 'Improved Abjuration', 10, 'Beginning at 10th level, when you cast an abjuration spell that requires you to make an ability check as a part of casting that spell (as in ''counterspell'' and ''dispel magic''), you add your proficiency bonus to that ability check.');
insert into spec_features(spec_id, name, level, description)
    values(32, 'Spell Resistance', 14, 'Starting at 14th level, you have advantage on saving throws against spells.
    Furthermore, you have resistance against the damage of spells.');

/* School of Conjuration */
insert into spec_features(spec_id, name, level, description)
    values(33, 'Conjuration Savant', 2, 'Beginning when you select this school at 2nd level, the gold and time you must spend to copy a conjuration spell into your spellbook is halved.');
insert into spec_features(spec_id, name, level, description)
    values(33, 'Minor Conjuration', 2, 'Starting at 2nd level when you select this school, you can use your action to conjure up and inanimate object in your hand or on the ground in an unoccupied space that you can see within 10 feet of you.  This object can be no larger than 3 feet on a side and weigh no more than 10 pounds, and its form must be that of a nonmagical object that you have seen.  The object is visibly magical, radiating a dim light out to 5 feet.
    The object disappears after 1 hour, when you use this feature again, or if it takes or deals any damage.');
insert into spec_features(spec_id, name, level, description)
    values(33, 'Benign Transposition', 6, 'Starting at 6th level, you can use your action to teleport up to 30 feet to an unoccupied space that you can see.  Alternatively, you can choose a space within range that is occupied by a Small or Medium creature.  If that creature is willing, you both teleport, swapping places.
    Once you use this feature, you can''t use it again until you finish a long rest or you cast a conjuration spell of 1st level or higher.');
insert into spec_features(spec_id, name, level, description)
    values(33, 'Focused Conjuration', 10, 'Beginning at 10th level, while your are concentrating on a conjuration spell, your concentration can''t be broken as a result of taking damage.');
insert into spec_features(spec_id, name, level, description)
    values(33, 'Durable Summons', 14, 'Starting at 14th level, any creature that you summon or create with a conjuration spell has 30 temporary hit points.');

/* School of Divination */
insert into spec_features(spec_id, name, level, description)
    values(34, 'Divination Savant', 2, 'Beginning when you select this school at 2nd level, the gold and time you must spend to copy a divination spell into your spellbook is halved.');
insert into spec_features(spec_id, name, level, description)
    values(34, 'Portent', 2, 'Starting at 2nd level when you choose this school, glimpses of the future begin to press in on your awareness.  When you finish a long rest, roll two d20s and record the numbers rolled.  You can replace any attack roll, saving throw, or ability check made by you or a creature that you can see with one of these foretelling rolls.  You must choose to do so before the roll, and you can replace a roll in this way only once per turn.
    Each fortelling roll can be used only once.  When you finish a long rest, you lose any unused foretelling rolls.');
insert into spec_features(spec_id, name, level, description)
    values(34, 'Expert Divination', 6, 'Beginning at 6th level, casting divination spells comes so easily to you that it expends only a fraction of your spellcasting efforts.  When you cast a divination spell of 2nd level or higher using a spell slot, you regain one expended spell slot.  The slot you regain must be must be of a level lower that the spell you cast and can''t be higher than 5th level.');
insert into spec_features(spec_id, name, level, description)
    values(34, 'The Third Eye', 10, 'Starting at 10th level, you can use your action to increase your powers of perception.  When you do so, choose one of the following benefits, which lasts until your are incapacitated or you take a short or long rest. You can''t use the feature again until you finish a rest.
    DARKVISION
    You gain darkvision out to a range of 60 feet, as described in chapter 8 of the Player''s Handbook.
    ETHEREAL SIGHT
    You can see into the Ethereal Plane within 60 feet of you.
    GREATER COMPREHENSION
    You can read any language.
    SEE INVISIBILITY
    You can see invisible creatures and objects within 10 feet of you that are within line of sight.');
insert into spec_features(spec_id, name, level, description)
    values(34, 'Greater Portent', 14, 'Starting at 14th level, the visions in your dreams intensify and paint a more accurate picture in your mind of what is to come.  You can roll three d20s for your Portent feature, rather than two.');

/* School of Enchantment */
insert into spec_features(spec_id, name, level, description)
    values(35, 'Enchantment Savant', 2, 'Beginning when you select this school at 2nd level, the gold and time you must spend to copy an enchantment spell into your spellbook is halved.');
insert into spec_features(spec_id, name, level, description)
    values(35, 'Hypnotic Gaze', 2, 'Starting at 2nd level when you choose this school, your soft words and enchanting gaze can magically enthrall another creature.  As an action, choose one creature that you can see within 5 feet of you.  If the target can see or hear you, it must succeed on a Wisdom saving throw against your wizard spell save DC or be charmed by you until the end of your next turn.  The charmed creature''s speed drops to 0, and the creature is incapacitated and visibly dazed.
    On subsequent turns, you can use your action to maintain this effect, extending its duration until the end of your next turn.  However, the effect ends if you move more that 5 feet away from the creature, it the creature can neither see nor hear you, if if the creature takes damage.
    Once the effect ends, or if the creature succeeds on its initial saving throw against this effect, you can''t use this feature on that creature again until you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(35, 'Instinctive Charm', 6, 'Beginning at 6th level, when a creature you can see within 30 feet of makes an attack roll against you, you can use your reaction to divert the attack, provided that another creature is within the attack''s range.  The attacker must make a Wisdom saving throw against your wizard spell save DC.  On a failed save, the attacker must target the creature that is closest to it, not including you or itself.  If multiple creatures are closest, the attacker chooses which one to target.  On a successful save, you can''t use this feature on the attacker again until you finish a long rest.
    You must choose to use this feature before knowing whether the attack hits or misses.  Creatures that can''t be charmed are immune to this effect.');
insert into spec_features(spec_id, name, level, description)
    values(35, 'Split Enchantment', 10, 'Starting at 10th level, when you cast an enchantment spell of 1st level or higher that targets only one creature, you can have it target a second creature.');
insert into spec_features(spec_id, name, level, description)
    values(35, 'Alter Memories', 14, 'At 14th level, you gain the ability to make a creature unaware of you magical influence on it.  When you cast and enchantment spell to charm one or more creatures, you can alter one creature''s understanding so that it remains unaware of being charmed.
    Additionally, once before the spell expires, you can use your action to try to make the chosen creature forget some of the time it spent charmed.  The creature must succeed on an Intelligence saving throw against your wizard spell save DC or lose a number of hours of its memory equal to 1 + your Charisma modifier (minimum 1).  You can make the creature forget less time, and the amount of time can''t exceed the duration of your enchantment spell.');

/* School of Evocation */
insert into spec_features(spec_id, name, level, description)
    values(36, 'Evocation Savant', 2, 'Beginning when you select this school at 2nd level, the gold and time you must spend to copy an evocation spell into your spellbook is halved.');
insert into spec_features(spec_id, name, level, description)
    values(36, 'Sculpt Spells', 2, 'Beginning at 2nd level, you can create pockets of relative safety within the effects of your evocation spells.  When you cast an evocation spell that affects other creature that you can see, you can choose a number of them equal to 1 + the spell''s level.  The chosen creatures automatically succeed on their saving throws against the spell, and they take on damage if they would normally take half damage on a successful save.');
insert into spec_features(spec_id, name, level, description)
    values(36, 'Potent Cantrip', 6, 'Starting at 6th level, you damaging cantrips affect even creatures that avoid the brunt of the effect.  When a creature succeeds on a saving throw against your cantrip, the creature takes half the cantrip''s damage (if any) but suffers no additional effect from the cantrip.');
insert into spec_features(spec_id, name, level, description)
    values(36, 'Empowered Evocation', 10, 'Beginning at 10th level, you add your Intelligence modifier to one damage roll of any wizard evocation spell you cast.');
insert into spec_features(spec_id, name, level, description)
    values(36, 'Overchannel', 14, 'Starting a 14th level, you can increase the power of you simpler spells.  When you cast a wizard spell of 1st through 5th level that deals damage, you can deal maximum damage with that spell.
    The first time you do so, you suffer no adverse effect.  If you use this feature again before you finish a long rest, you take 2d12 necrotic damage for each level of the spell, immediately after you cast it.  Each time you use this feature again before finishing a long rest, the necrotic damage per spell level increases by 1d12.  This damage ignores resistance and immunity.');

/* School of Illusion */
insert into spec_features(spec_id, name, level, description)
    values(37, 'Illusion Savant', 2, 'Beginning when you select this school at 2nd level, the gold and time you must spend to copy an illusion spell into your spellbook is halved.');
insert into spec_features(spec_id, name, level, description)
    values(37, 'Improved Minor Illusion', 2, 'When you choose this school at 2nd level, you learn the ''minor illusion'' cantrip.  If you already know this cantrip, you learn a different wizard cantrip of your choice.  The cantrip doesn''t count against you number of cantrips known.
    When you cast ''minor illusion'', you can create both a sound and and image with a single casting of the spell.');
insert into spec_features(spec_id, name, level, description)
    values(37, 'Malleable Illusions', 6, 'Starting at 6th level, when you cast an illusion spell that has a duration of 1 minute or longer, you can use your action to change the nature of that illusion (using the spell''s normal parameters for the illusion), provided that you can see the illusion.');
insert into spec_features(spec_id, name, level, description)
    values(37, 'Illusory Self', 10, 'Beginning at 10th level, your can create an illusory duplicate of yourself as an instant, almost instinctual reaction to danger.  When a creature makes an attack roll against you, you can use your reaction to interpose the illusory duplicate between the attacker and yourself.  The attack automatically misses your, then the illusion dissipates.
    Once you use this feature, you can''t use it again until you finish a short or long rest.');
insert into spec_features(spec_id, name, level, description)
    values(37, 'Illusory Reality', 14, 'By 14th level, you have learned the secret of weaving shadow magic into your illusions to give them a semi-reality.  When you cast an illusion spell of 1st level or higher, you can choose one inanimate, nonmagical object that is part of the illusion and make the object real.  You can do this on your turn as a bonus action while the spell is ongoing.  The object remains real for 1 minute.  For example, you can create an illusion of a bridge over a chasm and then make it real long enough for your allies to cross.
    The object can''t deal damage or otherwise directly harm anyone.');

/* School of Necromancy */
insert into spec_features(spec_id, name, level, description)
    values(38, 'Necromancy Savant', 2, 'Beginning when you select this school at 2nd level, the gold and time you must spend to copy a necromancy spell into your spellbook is halved.');
insert into spec_features(spec_id, name, level, description)
    values(38, 'Grim Harvest', 2, 'At 2nd level, you gain the ability to reap life energy from creatures you kill with your spells.  Once per turn when you kill one or more creatures with a spell of 1st level or higher, your regain hit points equal to twice the spell''s level, or three times its level if the spell belongs to the School of Necromancy.  You don''t gain this benefit for killing constructs or undead.');
insert into spec_features(spec_id, name, level, description)
    values(38, 'Undead Thralls', 6, 'At 6th level, you add the ''animate undead'' spell to your spellbook if it is not there already.  When you cast ''animate dead'', you can target one additional corpse or pile of bones, creating another zombie or skeleton, as appropriate.
    Whenever you create an undead using a necromancy spell, it has additional benefits:
    
    • The creature''s hit point maximum is increased by and amount equal to your wizard level.
    • The creature adds your proficiency bonus to its weapon damage rolls.');
insert into spec_features(spec_id, name, level, description)
    values(38, 'Inured to Undeath', 10, 'Beginning at 10th level, your have resistance to necrotic damage, and your hit point maximum can''t be reduced.  You have spent so much time dealing with undead and the forces that animate them that you have become inured to some of their worst effects.');
insert into spec_features(spec_id, name, level, description)
    values(38, 'Command Undead', 14, 'Starting at 14th level, you can use magic to bring undead under your control, even those created by other wizards.  As an action, you can choose one undead that you can see within 60 feet of you.  That creature must make a Charisma saving throw against your wizard spell save DC.  If it succeeds, you can''t use the feature on it again.  If it fails, it becomes friendly to you and obeys your command until you use this feature again.
    Intelligent undead are harder to control in this way.  If the target has an Intelligence of 8 or higher, it has advantage on the saving throw.  If it fails the saving throw or has an Intelligence of 12 or higher, it can repeat the saving throw at the end of every hour until it succeeds and breaks free.');

/* School of Transmutation */
insert into spec_features(spec_id, name, level, description)
    values(39, 'Transmutation Savant', 2, 'Beginning when you select this school at 2nd level, the gold and time you must spend to copy a transmutation spell into your spellbook is halved.');
insert into spec_features(spec_id, name, level, description)
    values(39, 'Minor Alchemy', 2, 'Starting at 2nd level when you select this school, you can temporarily alter the physical properties of one nonmagical object, changing it from one substance into another.  You perform a special alchemical procedure on one object composed entirely of wood, stone (but not gemstone), iron, copper, or silver, transforming it into a different one of those materials.  For each 10 minutes you spend performing the procedure, you can transform up to 1 cubic foot of material.  After 1 hour, or until you lose your concentration (as if you were concetrating on a spell), the material reverts to its original substance.');
insert into spec_features(spec_id, name, level, description)
    values(39, 'Transmuter''s Stone', 6, 'Starting at 6th level, you can spend 8 hours creating a transmuter''s stone that stores transmutation magic.  You can benefit from the stone yourself or give it to another creature.  A creature gains a benefit of your choice as long as the stone is in the creature''s possession.  When you create the stone, choose the benefit from the following options:
    
    • Darkvision out to a range of 60 feet, as described in chapter 8 of the Player''s Handbook
    • In increase to speed of 10 feet while the creature is unencumbered
    • Proficiency in Constitution saving throws
    • Resistance to acid, cold, fire, lightning, or thunder damage (your choice whenever you choose this benefit)
    
    Each time you cast a transmutation spell of 1st level or higher, you can change the effect of your stone if the stone is on your person.
    If you create a new transmuter''s stone, the previous one ceases to function.');
insert into spec_features(spec_id, name, level, description)
    values(39, 'Shapechanger', 10, 'At 10th level, you add the ''polymorph'' spell to youre spellbook, if it is not there already.  You can cast ''polymorph'' without expending a spell slot.  When you do so, you can target only yourself and transform into a beast whose challenge rating is 1 or lower.
    Once you cast ''polymorph'' in this way, you can''t do so again until you finish a short or long rest, though you can still cast it normally using an available spell slot.');
insert into spec_features(spec_id, name, level, description)
    values(39, 'Master Transmuter', 14, 'Starting at 14th level, you can use your action to consume the reserve of transmutation magic stored in your transmuter''s stone in a single burst.  When you do so, choose one of the following effects.  Your transmuter''s stone is destroyed and can''t be remade until you finish a long rest.
    MAJOR TRANSFORMATION
    You can transmute one nonmagical object -- no larger than a 5-foot cube -- into another nonmagical object of similar size and mass and of equal or lesser value.  You must spend 10 minutes handling the object to transform it.
    PANACEA
    You remove all curses, diseases, and poisons affecting a creature that you touch with the transmuter''s stone.  The creature also regains all its hit points.
    RESTORE LIFE
    You cast the ''raise dead'' spell on a creature you touch with the transmuter''s stone, without expending a spell slot or needing to have the spell in your spellbook.
    RESTORE YOUTH
    You touch the transmuter''s stone to a willing creature, and that creature''s apparent age is reduced by 3d10 years, to a minimum of 13 years.  This effect doesn''t extend the creature''s lifespan.');
/* Path of the Ancestral Guardian */
insert into spec_features(spec_id, name, level, description)
    values(40, 'Ancestral Protectors', 3, 'Starting when you choose this path at 3rd level, spectral warriors appear when you enter your rage.  While you''re raging the first creature you hit with an attack on your turn becomes the target of the warriors, which hinder its attacks.  Until the start of your next turn, that target has disadvantage on any attack roll that isn''t against you, and when that target hits a creature other than you with an attack, that creature has resistance to the damage dealt by the attack.  The effect on the target ends early if your rage ends.');
insert into spec_features(spec_id, name, level, description)
    values(40, 'Spirit Shield', 6, 'Starting at 6th level, the guardian spirits that aid you can provide supernatural protection to those you defend.  If you are raging and another creature you can see within 30 feet of you takes damage, you can use your reaction to reduce that damage by 2d6.
    When you reach certain levels in this class, you can reduce the damage by more:  by 3d6 at 10th level and by 4d6 at 14th level.');
insert into spec_features(spec_id, name, level, description)
    values(40, 'Consult the Spirits', 10, 'At 10th level, you gain the ability to consult with your ancestral spirits.  When you do so, you cast the "augury" or "clairvoyance" spell, without using a spell slot or material components.  Rather than creating a spherical sensor, this use of "clairvoyance" invisibly summons one of your ancestral spirits to the chosen location.  Wisdom is your spellcasting ability for these spells.
    After you cast either spell in this way, you can''t use this feature again until you finish a short or long rest.');
insert into spec_features(spec_id, name, level, description)
    values(40, 'Vengeful Ancestors', 14, 'At 14th level, your ancestraal spirits grow powerful enough to retaliate.  When you use your Spirit Shield to reduce the damage of an attack, the attacker takes an amount of damage equal to the damage that your Spirit Shield prevents.');
/* Path of the Storm Herald */
insert into spec_features(spec_id, name, level, description)
    values(41, 'Storm Aura', 3, 'Starting at 3rd level, you emanate a stormy, magical aura while you rage.  This aura extends 10 feet from you in every direction, but not through total cover.
    Your aura has an effect that activates when you enter your rage, and you can activate the effect again on each of your turns as a bonus action.  Choose desert, sea, or tundra.  Your aura''s effect depends on that chosen environment, as detailed below.  You can change your environment choice whenever you gain a level in this class.
    If your aura''s effects require a saving throw, the DC equals 8 + your proficiency bonus + your Constitution modifier.
    DESERT
    When this effect is activated, all other creatures in your aura take 2 fire damage each.  The damage increases when you reach certain levels in this class, increasing to 3 at 5th level, 4 at 10th level, 5 at 15th level, and 6 at 20th level.
    SEA
    When this effect is activated, you can choose one other creature you can see in your aura.  The target must make a Dexterity saving throw.  The target takes 1d6 lightning damage on a failed save, or half that much damage on a successful one.  The damage increases when you reach certain levels in this class, increasing to 2d6 at 10th level, 3d6 at 15th level, and 4d6 at 20th level.
    TUNDRA
    When this effect is activated, each creature of your choice in your aura gains 2 temporary hit points, as icy spirits inure it to suffering.  The temporary hit points increase when you reach certain levels in this class, increasing to 3 at 5th level, 4 at 10th level, 5 at 15th level, and 6 at 20th level.');
insert into spec_features(spec_id, name, level, description)
    values(41, 'Storm Soul', 6, 'At 6th level, the storm grants you benefits even when your aura isn''t active.  The benefits are base on the environment your chose for your Storm Aura.
    DESERT
    You gain resistance to fire damage, and you don''t suffer the effects of extreme heat, as described in the "Dungeon Master''s Guide".  Moreover, as an action, you can touch a flammable object that isn''t being worn or carried by anyone else and set it on fire.
    SEA
    You gain resistance to lightning damage, and you can breathe underwater.  You also gain a swimming speed of 30 feet.
    TUNDRA
    You gain resistance to cold damage, and you don''t suffer the effects of extreme cold, as described in the "Dungeon Master''s Guide".  Moreover, as an action you can touch water and turn a 5-foot cube of it into ice, which melts after 1 minute.  This action fails if a creature is in the cube.');
insert into spec_features(spec_id, name, level, description)
    values(41, 'Shielding Storm', 10, 'At 10th level, you learn to use your mastery of the storm to protect others.  Each creature of your choice has the damage resistance your gained from the Storm Soul feature while that creature is in you Storm Aura.');
insert into spec_features(spec_id, name, level, description)
    values(41, 'Raging Storm', 14, 'At 14th level, the power of the storm you channel grows mightier, lashing out at your foes.  The effect is based on the environment you chose for your Storm Aura.
    DESERT
    Immediately after a creature in your aura hits you with an attack, you can use your reaction to force that creature to make a Dexterity saving throw.  On a failed save, the creature takes fire damage equal to half your barbarian level.
    SEA
    When you hit a creature in your aura with an attack, you can use your reaction to force that creature to make a Strength saving throw.  On a failed save, the creature is knocked prone, as if struck by a wave.
    TUNDRA
    Whenever the effect of your Storm Aura is activated, you can choose one creature yoiu can see in the aura.  That creature must succeed on a Strength saving throw, or its speed is reduced to 0 until the start of your next turn, as magical frost covers it.');
/* Path of the Zealot */
insert into spec_features(spec_id, name, level, description)
    values(42, 'Divine Fury', 3, 'Starting when you choose this path at 3rd level, you can channel divine fury into your weapon strikes.  While you''re raging, the first creature you hit on each of your turns with a weapon attack takes extra damage equal to 1d6 + half your barbarian level.  The extra damage is necrotic or radiant; you choose the type of damage when you gain this feature.');
insert into spec_features(spec_id, name, level, description)
    values(42, 'Warrior of the Gods', 3, 'At 3rd level, your soul is marked for endless battle.  If a spell, such as "raise dead", has the sole effect of restoring you to life (but not undeath), the caster doesn''t need material components to case the spell on you.');
insert into spec_features(spec_id, name, level, description)
    values(42, 'Fanatical Focus', 6, 'Starting at 6th level, the divine power that fuels your rage can protect you.  If you fail a saving throw while you''re raging, you can reroll it, and you must use the new roll.  You can use this ability only once per rage.');
insert into spec_features(spec_id, name, level, description)
    values(42, 'Zealous Presence', 10, 'At 10th level, you learn to channel divine power to inspire zealotry in others.  As a bonus action, you unleash a battle cry infused with divine energy.  Up to ten other creatures of your choice within 60 feet of you that can hear you gain advantage on attack rolls and saving throws until the start of your next turn.
    Once you use this feature, you can''t use it again until you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(42, 'Rage Beyond Death', 14, 'Starting at 14th level, the divine power that fuels your rage allows you to shrug off fatal blows.
    While you''re raging, having 0 hit points doesn''t knock you unconscious.  You still must make death saving throws, and you suffer the normal effects of taking damage while at 0 hit points.  However, if you would die due to failing death saving throws, you don''t die until your rage ends, and you die only if you still have 0 hit points.');
/* College of Glamour */
insert into spec_features(spec_id, name, level, description)
    values(43, 'Mantle of Inspiration', 3, 'When you join the College of Glamour at 3rd level, you gain the ability to weave a song of fey magic that imbues your allies with vigor and speed.
    As a bonus action, you can expend one use of your Bardic Inspiration to grant yourself a wondrous appearance.  When you do so, choose a number of creatures you can see and that can see you within 60 feet of you, up to a number equal to your Charisma modifier (minimum of one).  Each of them gains 5 temporary hit points.  When a creature gains these temporary hit points, it can immediately use its reaction to move up to its speed, without provoking opportunity attacks.
    The number of temporary hit points increases when you reach certain levels of this class, increasing to 8 at 5th level, 11 at 10th level, and 14 at 15th leve.');
insert into spec_features(spec_id, name, level, description)
    values(43, 'Enthralling Performance', 3, 'Starting at 3rd level, you can charge your performance with seductive, fey magic.
    If you perform for at least 1 minute, you can attempt to inspire wonder in you audience by singing, reciting a poem, or dancing.  At the end of the performance, choose a number of humanoids within 60 feet of you who watched or listened to all of it, up to a number equal to your Charisma modifier (minimum of one).  Each target must succeed on a Wisdom saving throw against your spell DC or be charmed by you.  While charmed in this way, the target idolizes your, it speaks glowingly of you to anyone who talks to it, and it hinders anyone who opposes you, although it avoids violence unless it was already inclined to  fight on your behalf.  This effect ends on a target after 1 hour, if it takes any damage, if you attack it, or if it witnesses you attacking or damaging its allies.
    If a target succeeds on its saving throw, the target has no hint that you tried to charm it.
    Once you use this feature, you can''t use it again until you finish a short or long rest.');
insert into spec_features(spec_id, name, level, description)
    values(43, 'Mantle of Majesty', 6, 'At 6th level, you gain the ability to cloak yourself in a fey magic that makes others want to serve you.  As a bonus action, you cast "command", without expending a spell slot, and you take on an appearance of unearthly beauty for 1 minute or until your concentration ends (as if you were concentrating on a spell).  During this time, you can cast "command" as a bonus action on each of your turns, without expending a spell slot.
    Any creature charmed by you automatically fails its saving throw against the "command" you cast with this feature.
    Once you use this feature, you can''t use it again until you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(43, 'Unbreakable Majesty', 14, 'At 14th level, your appearance permanently gains an otherworldly aspect that makes you look more lovely and fierce.
    In addition, as a bonus action, you can assume a magically majestic presence for 1 minute or until you are incapacitated.  For the duration, whenever any creature tries to attack you for the first time on a turn, the attacker must make a Charisma saving throw against your spell save DC.  On a failed save, it can''t attack you on this turn, and it must choose a new target for its attack or the attack is wasted.  On a successful save, it can attack you on this turn but it has disadvantage on any saving throw it makes against your spells on your next turn.
    Once your assume this majectic presence, you can''t do so again until you finish a short or long rest.');

/* College of Swords */
insert into spec_features(spec_id, name, level, description)
    values(44, 'Bonus Proficiencies', 3, 'When you join the College of Swords at 3rd level, you gain proficiency with medium armor and the scimitar.
    If you''re proficient with a simple or martial melee weapon, you can use it as a spellcasting focus for your bard spells.');
insert into spec_features(spec_id, name, level, description)
    values(44, 'Fighting Style', 3, 'At 3rd level, you adopt a style of fighting as your speciality.  Choose one of the following options.  You can''t take a Fighting Style option more than once, even if something in the game lets you choose again.
    DUELING.
    When your ar wielding a melee weapon in one hand and no other weapons, you gain a +2 bonus to damage rolls with that weapon.
    TWO-WEAPON FIGHTING.
    When you engage in two-weapon fighting, you can add your ability modifier to the damage of the second attack.');
insert into spec_features(spec_id, name, level, description)
    values(44, 'Blade Flourish', 3, 'At 3rd level, you learn to perform impressive displays of martial prowess and speed.
    Whenever you take the Attack action on your turn, you walking speed increases by 10 feet until the end of the turn, and if a weapon attack that you make as part of this action hits a creature, you can use one of the following Blade Flourish options of your choice.  You can use on one Blade Flourish option per turn.
    DEFENSIVE FLOURISH.
    You can expend on use of your Bardic Inspiration to cause the weapon to deal extra damage to the target you hit.  The damage equals the number you roll on the Bardic Inspiration die.  You also add the number rolled to your AC until the start of your next turn.
    SLASHING FLOURISH.
    You can expend on use of your Bardic Inspiriation to cause the weapon to deal extra damage to the target you hit and to any other creature of your choice that you can see within 5 feet of you.  The damage equals the number you roll on the Bardic Inspiration die.
    MOBILE FLOURISH.
    You can expend one use of your Bardic Inspiration to cause the weapon to deal extra damage to the target you hit.  The damage equals the number you roll on the Bardic Inspiration die.  You can also push the target up to 5 feet away from your, plus a number of feet equal to the number you roll on that die.  You can then immediately use your reaction to move up to your walking speed to an unoccupied space within 5 feet of the target.');
insert into spec_features(spec_id, name, level, description)
    values(44, 'Extra Attack', 6, 'Starting at 6th level, you can attack twice, instead of once, whenever you take the Attack action on your turn.');
insert into spec_features(spec_id, name, level, description)
    values(44, 'Master''s Flourish', 14, 'Starting at 14th level, whenever you use a Blade Flourish option, you can roll a d6 and use it instead of expending a Bardic Inspiration die.');

/* College of Whispers */
insert into spec_features(spec_id, name, level, description)
    values(45, 'Psychic Blades', 3, 'When you join the College of Whispers at 3rd level, you gain the ability to make your weapon attacks magically toxic to a creature''s mind.
    When you hit a creature with a weapon attack, you can expend one of your Bardic Inspiration to deal an extra 2d6 psychic damage to that target.  You can do so only once per round on your turn.
    The psychic damage increases when you reach certain levels in this class, increasing to 3d6 at 5th level, 5d6 at 10th level, and 8d6 at 15th level.');
insert into spec_features(spec_id, name, level, description)
    values(45, 'Words of Terror', 3, 'At 3rd level, you learn to infuse innocent-seeming words with an insidious magic that can inspire terror.
    If you speak to a humanoid alone for at least 1 minute, you can attempt to seed paranoia in its mind.  At the end of the converstion, the target must succeed on a Wisdom saving throw against your spell save DC or be frightened of your or another creature of your choice.  The target is frightened in this way for 1 hour, until it is attacked or damaged, or until it witnesses its allies being attacked or damaged.
    If the target succeeds on its saving throw, the target has no hint that you tried to frighten it.
    Once you use this feature, you can''t use it again until you finish a short or long rest.');
insert into spec_features(spec_id, name, level, description)
    values(45, 'Mantle of Whispers', 6, 'At 6th level, you gain the ability to adopt a humanoid''s persona.  When a humanoid dies within 30 feet of your, you can magically capture its shadow using your reaction.  You retain the shadow until you use it or you finish a long rest.
    You can use the shadow as an action.  When you do so, it vanishes, magically transforming into a disguise that appears on you.  You now look like the dead person, but healthy and alive.  This disguise lasts for 1 hour or until you end it as a bonus action.
    While you''re in the disguise, you gain access to all information that a humanoid would freely share with a casual acquaintance.  Such information includes general details on its background and personal life, but doesn''t include secrets.  The information is enough that you can pass yourself off as the person by drawing on its memories.
    Another creature can see through this disguise by succeeding on a Wisdom(Insight) check contested by your Charisma(Deception) check.  You gaina +5 bonus on your check.
    Once you capture a shadow with this feature, you can''t capture another one until you finish a short or long rest.');
insert into spec_features(spec_id, name, level, description)
    values(45, 'Shadow Lore', 14, 'At 14th level, you gain the ability to weave dark magic into your words and tap into a creature''s deepest fears.
    As an action, you magically whisper a phrase that only one creature of your choice within 30 feet of you can hear.  The target must make a Wisdom saving throw against your spell save DC.  It automatically succeeds if it doesn''t share a language with you or if it can''t hear you.  On a successful saving throw, you whisper sounds like unintelligible mumbling and has no effect.
    On a failed saving throw, the target is charmed by you for the next 8 hours or until you or your allies attack it, damage it, or force it to make a saving throw.  It interprets the whispers as a description of its most mortifying secret.  You gain no knowledge of this secret, but the target is convinced you know it.
    The charmed creature obeys your commands for fear that you will reveal its secret.  It won''t risk its life for you or fight for you, unless it is already inclinded to do so.  It grants you favors and gifts it would offer to a close friend.
    When the effect ends, the creature has no understanding of why it held you in such fear.
    Once you use this feature, you can''t use it again until you finish a long rest.');

/* Forge Domain */
insert into spec_features(spec_id, name, level, description)
    values(46, 'Domain Spells', 1, 'You gain domain spells at the cleric levels listed in the Forge Domain Spells table in Xanther''s Guide to Everything.  See the Divine Domain class feature for how domain spells work.');
insert into spec_features(spec_id, name, level, description)
    values(46, 'Bonus Proficiencies', 1, 'When you choose this domain at 1st level, you gain proficiency with heavy armor and smith''s tools.');
insert into spec_features(spec_id, name, level, description)
    values(46, 'Blessing of the Forge', 1, 'At 1st level, you gain the ability to imbue magic into a weapon or armor.  At the end of a long rest, you can touch one nonmagical object that is a suit of armor or a simple or martial weapon.  Until the end of your next long rest or until you die, the object becomes a magic item, granting it a +1 bonus to AC if it''s armor or a +1 bonus to attack and damage rolls if it''s a weapon.
    Once you use this feature, you can''t use it again until you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(46, 'Channel Divinity:  Artisan''s Blessing', 2, 'Starting at 2nd level, your can use your Channel Divinity to create simple items.
    You conduct an hour-long ritual that crafts a non-magical item that must include some metal:  a simple or martial weapon, a suit of armor, ten pieces of ammunition, a set of tools, or another metal object (see Chapter 5, "Equipment," in the Player''s Handbook for examples of these items).  The creation is completed at the end of the hour, coalescing in an unoccupied space of your choice on a surface within 5 feet of you.
    The thing you create can be something that is worth no more than 100 gp.  As part of this ritual, you must lay out metal, which can include coins, with a value equal to the creation.  The metal irretrieveably coalesces and transforms into the creation at the ritual''s end, magically forming even non-metal parts of the creation.
    The ritual can create a duplicate of a nonmagical item that contains metal, such as a key, if you possess the original during the ritual.');
insert into spec_features(spec_id, name, level, description)
    values(46, 'Soul of the Forge', 6, 'Starting at 6th level, your mastery of the forge grants you special abilities:
    - You gain resistance to fire damage.
    - While wearing heavy armor, you gain a +1 bonus to AC.');
insert into spec_features(spec_id, name, level, description)
    values(46, 'Divine Strike', 8, 'At 8th level, you gain the ability to infuse your weapon strikes with the fiery power of the forge.  Once on each of your turns when you hit a creature with a weapon attack, you can cause the attack to deal and extra 1d8 fire damage to the target.  When you reach 14th level, the extra damage is 2d8.');
insert into spec_features(spec_id, name, level, description)
    values(46, 'Saint of Forge and Fire', 17, 'At 17th level, your blessed affinity with fire and metal becomes more powerful:
    - You gain immunity to fire damage.
    - While wearing heavy armor, you have resistance to bludgeoning, piercing, and slashing damage from nonmagical attacks.');

/* Grave Domain */
insert into spec_features(spec_id, name, level, description)
    values(47, 'Domain Spells', 1, 'You gain domain spells at the cleric levels listed in the Grave Domain Spells table in Xanther''s Guide to Everything.  See the Divine Domain class feature for how domain spells work.');
insert into spec_features(spec_id, name, level, description)
    values(47, 'Circle of Mortality', 1, 'At 1st level, you gain the ability to manipulate the line between life and death.  When you would normally roll one or more dice to restore hit points with a spell to a creature at 0 hit points, you instead use the highest number possible for each die.
    In addition, you learn the "spare the dying" cantrip, which doesn''t count against the number of cleric cantrips you know.  For you, it has a range of 30 feet, and you can cast it as a bonus action.');
insert into spec_features(spec_id, name, level, description)
    values(47, 'Eyes of the Grave', 1, 'At 1st level, you gain the ability to ocassionally sense the presence of undead, whose existence is an insult to the natural cycle of life.  As an action, you can open your awareness to magically detect undead.  Until the end of your next turn, you know the location of any undead within 60 feet of you that isn''t behind total cover and that isn''t protected from divination magic.  This sense doesn''t tell you anything about a creature''s capabilities or identity.
    You can use this feature a number of times equal to your Wisdom modifier (minimum once).  You regain all expended uses when you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(47, 'Channel Divinity:  Path to the Grave', 2, 'Starting at 2nd level, you can use your Channel Divinity to mark another creature''s life force for termination.
    As an action, you choose one creature you can see within 30 feet of you, cursing it until the end of your next turn.  The next time you or an ally of yours hits the cursed creature with an attack, the creature has vulnerability to all of the attack''s damage, and then the curse ends.');
insert into spec_features(spec_id, name, level, description)
    values(47, 'Sentinel at Death''s Door', 6, 'At 6th level, you gain the ability to impede death''s progress.  As a reaction when you or a creature you can see within 30 feet of you suffers a critical hit, you can turn that hit into a normal hit.  Any effects triggered by a critical hit are cancelled.
    You can use this feature a number of times equal to your Wisdom modifier (minimum of once).  You regain all expended uses when you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(47, 'Potent Spellcasting', 8, 'Starting at 8th level, you add your Wisdom modifier to the damage you deal with any cleric cantrip.');
insert into spec_features(spec_id, name, level, description)
    values(47, 'Keeper of Souls', 17, 'Starting at 17th level, you can seize a trace of vitality from a parting soul and use it to heal the living.  When an enemy you can see dies within 60 feet of you, you or one creature of your choice that is within 60 feet of you regains hit points equal to the enemy''s number of Hit Dice.  You can use this feature only if you aren''t incapacitated.  Once you use it, you can''t do again until the start of your next turn.');

/* Circle of Dreams */
insert into spec_features(spec_id, name, level, description)
    values(48, 'Balm of the Summer Court', 2, 'At 2nd level, you become imbued with the blessings of the Summer Court.  Your are a font of energy that offers respite from injuries.  You have a pool of fey energy represented by a number of d6s equal to your druid level.
    As a bonus action, you can choose one creature you can see within 120 feet of you and spend a number of those dice equal to half your druid level or less.  Roll the spent dice and add them together.  The target regains a number of hit points equal to the total.  The target also gains 1 temporary hit point per die spent.
    You regain all expended dice when you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(48, 'Hearth of Moonlight and Shadow', 6, 'At 6th level, home can be wherever you are.  During a short or long rest, you can invoke the shadowy power of the Gloaming Court to help guard your respite.  At the start of the rest, you touch a point in space, and an invisible, 30-foot-radius sphere of magic appears, centered on that point.  Total cover blocks the sphere.
    While within the sphere, you and your allies gain a +5 bonus to Dexterity(Stealth) and Wisdom(Perception) checks, and any light from open flames in the sphere (a campfire, torches, or the like) isn''t visible outside it.
    The sphere vanishes at the end of the rest or when you leave the sphere.');
insert into spec_features(spec_id, name, level, description)
    values(48, 'Hidden Paths', 10, 'Starting at 10th level, you can use the hidden, magical pathways that some fey use to traverse space in the blink of an eye.  As a bonus action on your turn, you can teleport up to 60 feet to an unoccupied space you can see.  Alternatively, you can use your action to teleport one willing creature ou touch up to 30 feet to an unoccupied space you can see.
    You can use this feature a number of times equal to your Wisdom modifier (minimum of once), and you regain all expended uses when you finish a long rest.');
insert into spec_features(spec_id, name, level, description)
    values(48, 'Walker in Dream', 14, 'At 14th level, the magic of the Feywild grants you the ability to travel mentally or physically through dreamlands.
    When you finish a short rest, you can cast one of the following spells without expending a spell slot or requiring material components: "dream" (with you as the messenger), "scrying", or "teleportation circle".
    This use of the "teleportation circle" is special.  Rather than opening a portal to a permanent teleportation circle, it opens a portal to the last location where you finished a long rest on your current plane of existence.  If you haven''t taken a long rest on your current plane, the spell fails but isn''t wasted.
    Once you use this feature, you can''t use it again until you finish a long rest.');

/* Circle of the Shepherd */
insert into spec_features(spec_id, name, level, description)
    values(49, 'Speech of the Woods', 2, 'At 2nd level, you gain the ability to converse with beasts and many fey.
    You learn to speak, read, and write Sylvan.  In addition, beasts can understand your speach, and you gain the ability to decipher their noises and motions.  Most beasts lack the intelligence to convey or understand sophisticated concepts, but a friendly beast could relay what it has seen or heard in the recent past.  This ability doesn''t grant you friendship with beasts, though you can combine this ability with gifts to curry favor with them as you would with any nonplayer character.');
insert into spec_features(spec_id, name, level, description)
    values(49, 'Spirit Totem', 2, 'Starting at 2nd level, you can call forth nature spirits to influence the world around you.  As a bonus action, you can magically summon an incorporeal spirit to a point you can see within 60 feet of you.  The spirit creates and aurain a 30-foot radius around that point.  It counts as neither a creature nor an object, though it has the spectral appearance of the creature it represents.
    As a bonus action, you can move the spirit up to 60 feet to a point that you can see.
    The spirit persists for 1 minute or until you''re incapacitated.  Once you use this feature, you can''t use it again until you finish a short or long rest.
    The effect of the spirit''s aura depends on the type of spirit you summon from the options below.
    BEAR SPIRIT.
    The bear spirit grants you and your allies its might and endurance.  Each creature of your choice in the aura when the spirit appears gains temporary hit points equal to 5 + your druid level.  In addition, you and your allies gain advantage on Strength checks and Strength saving throws while in the aura.
    HAWK SPIRIT.
    The hawk spirit is a consummant hunter, aiding you and your allies with its keen sight.  When a creature makes an attack roll against a target in the spirit''s aura, you can use your reaction to grant advantage to that attack roll.  In addition, you and your allies have advantage on Wisdom(Perception) checks while in the aura.
    UNICORN SPIRIT.
    The unicorn spirit lends its protection to those nearby.  You and your allies gain advantage on all ability checks made to detect creatures in the spirit''s aura.  In addition, if you cast a spell using a spell slot that restores hit points to any creature inside or outside the aura, each creature of you choice in the aura also regains hit points equal to your druid level.');
insert into spec_features(spec_id, name, level, description)
    values(49, 'Mighty Summoner', 6, 'Starting at 6th level, beasts and fey that you conjure are more resilient than normal.  Any beast or fey summoned or created by a spell you cast gains the following benefits:
    - The creature appears with more hit points than normal:  2 extra hit points per Hit Die it has.
    - The damage from its natural weapons is considered magical for the purpose of overcomming immunity and resistance to nonmagical attacks and damage.');
insert into spec_features(spec_id, name, level, description)
    values(49, 'Guardian Spirit', 10, 'Beginning at 10th level, your Spirit Totem safeguards the beasts and fey that you call forth with your magic.  When a beast or fey that you summoned or created with a spell ends its turn in your Spirit Totum aura, that creature regains a number of hit points equal to half your druid level.');
insert into spec_features(spec_id, name, level, description)
    values(49, 'Faithful Summons', 14, 'Starting at 14th level, the nature spirits you commune with protect your when you are the most defenseless.  If you are reduced to 0 hit points or are incapacitated against your will, you can immediately gain the benefits of "conjure animals" as if it were cast using a 9th-level spell slot.  It summons four beasts of your choice that are challenge rating 2 or lower.  The conjured beasts appear within 20 feet of you.  If they receive no commands from you, they protect you from harm and attack your foes.  The spell lasts for 1 hour, requiring no concentration, or until you dismiss it (no action required).
    Once you use this feature, you can''t use it again until you finish a long rest.');

select s.name, sf.name, sf.level, sf.description from specializations s, spec_features sf where sf.spec_id = s.spec_id;
/* select * from spec_features; */
/* select spec_id, name from specializations */
