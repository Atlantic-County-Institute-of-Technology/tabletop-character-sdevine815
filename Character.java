import java.util.Random;
import java.util.ArrayList;

public class Character {
    //All the variables which represent the characters attributes
    protected String name;
    protected String characterClass;
    protected int STR, DEX, CON, INT, WIS, CHA;
    protected int level, HP, AC;
    protected ArrayList<String> feats = new ArrayList<String>();
    
    //Default intialize which sets all the values to default
    public Character(){
        this.name = "Player";
        this.level = 1;

        this.STR = 10;
        this.DEX = 10;
        this.CON = 10;
        this.INT = 10;
        this.WIS = 10;
        this.CHA = 10;

        this.calculateArmorClass();
        this.calculateHitPoints();
    }
    public Character(String name, int level){
        //checks that provided level is positive
        if(level < 1) throw new Error("Level cannot be negative");
        this.name = name;
        this.level = level;

        //sets values to a random value
        this.STR = this.rollndice(5);
        this.DEX = this.rollndice(5);
        this.CON = this.rollndice(5);
        this.INT = this.rollndice(5);
        this.WIS = this.rollndice(5);
        this.CHA = this.rollndice(5);
        
        this.calculateArmorClass();
        this.calculateHitPoints();
    }

    //rolls 5 dice, picks the 
    private int rollndice(int n){
        //creats a random sorted array of integers
        int[] rolls = new Random().ints(n, 1, 7).sorted().toArray();

        //iterates through the last 3 values and adds them to total
        int total = 0;
        for(int i = n - 3; i <= n; i++){ total += rolls[i]; }
        return total;
    }
    public void calculateHitPoints(){
        this.HP = (10 + this.CON) + (this.level - 1) * (6 + this.CON);
    }
    public void calculateArmorClass(){
        this.AC = 10 + this.DEX;
    }
    public int getAbilityModifier(int score){
        return (score - 10) / 2;
    }

    //ups the level then recalculates
    public void levelUp(){
        this.level += 1;
        this.calculateArmorClass();
        this.calculateHitPoints();
    }
    public void addFeat(String feat){
        this.feats.add(feat);
    }

    //prints all the data using string format
    public String toString(){
        return String.format("-Character: %s, Level: %d, Class: %s\r\n" + //
                "-HP: %d | AC: %d\r\n" + //
                "-STR: %d | DEX: %d | CON: %d\r\n" + //
                "-INT %d | WIS: %d | CHA: %d\r\n" + //
                "-Feats: %s", 
                this.name, this.level, this.getClass().getSimpleName(), 
                this.HP, this.AC, this.STR, 
                this.DEX, this.CON, this.INT, 
                this.WIS, this.CHA, 
                this.feats.toString()
            );
    }
}

class Barbarian extends Character {
    public Barbarian(){
        //calls constructor for parent class
        super();

        //increment level by x amount
        this.STR += 2;
        this.CON += 1;

        //adds the custom features
        this.addFeat("Rage");
        this.addFeat("Unarmored Defense");
    }

    //same thing as above but runs the constructor with arguments
    public Barbarian(String name, int level){
        super(name, level);
        this.STR += 2;
        this.CON += 1;
        this.addFeat("Rage");
        this.addFeat("Unarmored Defense");
    }
}

class Bard extends Character {
    public Bard(){
        super();
        this.CHA += 2;
        this.DEX += 1;
        this.addFeat("Inspiratio");
        this.addFeat("Jack of all Trades");
    }
    public Bard(String name, int level){
        super(name, level);
        this.CHA += 2;
        this.DEX += 1;
        this.addFeat("Inspiratio");
        this.addFeat("Jack of all Trades");
    }
}

class Cleric extends Character {
    public Cleric(){
        super();
        this.WIS += 2;
        this.CON += 1;
        this.addFeat("Channel Divinity");
        this.addFeat("Turn Undead");
    }
    public Cleric(String name, int level){
        super(name, level);
        this.WIS += 2;
        this.CON += 1;
        this.addFeat("Channel Divinity");
        this.addFeat("Turn Undead");
    }
}

class Druid extends Character {
    public Druid(){
        super();
        this.WIS += 2;
        this.CON += 1;
        this.addFeat("Wild Shape");
        this.addFeat("Commune with Nature");
    }
    public Druid(String name, int level){
        super(name, level);
        this.WIS += 2;
        this.CON += 1;
        this.addFeat("Wild Shape");
        this.addFeat("Commune with Nature");
    }
}

class Fighter extends Character {
    public Fighter(){
        super();
        this.DEX += 2;
        this.CON += 1;
        this.addFeat("Action Surge");
        this.addFeat("Second Wind");
    }
    public Fighter(String name, int level){
        super(name, level);
        this.DEX += 2;
        this.CON += 1;
        this.addFeat("Action Surge");
        this.addFeat("Second Wind");
    }
}

class Monk extends Character {
    public Monk(){
        super();
        this.DEX += 2;
        this.WIS += 1;
        this.addFeat("Unarmored Movement");
        this.addFeat("Stunning Strike");
    }
    public Monk(String name, int level){
        super(name, level);
        this.DEX += 2;
        this.WIS += 1;
        this.addFeat("Unarmored Movement");
        this.addFeat("Stunning Strike");
    }
}

class Paladin extends Character {
    public Paladin(){
        super();
        this.STR += 2;
        this.CHA += 1;
        this.addFeat("Divine Smite");
        this.addFeat("Aura of Protection");
    }
    public Paladin(String name, int level){
        super(name, level);
        this.STR += 2;
        this.CHA += 1;
        this.addFeat("Divine Smite");
        this.addFeat("Aura of Protection");
    }
}

class Ranger extends Character {
    public Ranger(){
        super();
        this.DEX += 2;
        this.WIS += 1;
        this.addFeat("Favored Enemy");
        this.addFeat("Surefooted");
    }
    public Ranger(String name, int level){
        super(name, level);
        this.DEX += 2;
        this.WIS += 1;
        this.addFeat("Favored Enemy");
        this.addFeat("Surefooted");
    }
}

class Rogue extends Character {
    public Rogue(){
        super();
        this.DEX += 2;
        this.INT += 1;
        this.addFeat("Sneak Attack");
        this.addFeat("Uncanny Dodge");
    }
    public Rogue(String name, int level){
        super(name, level);
        this.DEX += 2;
        this.INT += 1;
        this.addFeat("Sneak Attack");
        this.addFeat("Uncanny Dodge");
    }
}

class Sorcerer extends Character {
    public Sorcerer(){
        super();
        this.CHA += 2;
        this.CON += 1;
        this.addFeat("Wild Magic");
        this.addFeat("Flexible Spellcasting");
    }
    public Sorcerer(String name, int level){
        super(name, level);
        this.CHA += 2;
        this.CON += 1;
        this.addFeat("Wild Magic");
        this.addFeat("Flexible Spellcasting");
    }
}

class Warlock extends Character {
    public Warlock(){
        super();
        this.CHA += 2;
        this.CON += 1;
        this.addFeat("Eldritch Patron");
        this.addFeat("Pact Magic");
    }
    public Warlock(String name, int level){
        super(name, level);
        this.CHA += 2;
        this.CON += 1;
        this.addFeat("Eldritch Patron");
        this.addFeat("Pact Magic");
    }
}

class Wizard extends Character {
    public Wizard(){
        super();
        this.INT += 2;
        this.CON += 1;
        this.addFeat("Arcane Recovery");
        this.addFeat("Spell Mastery");
    }
    public Wizard(String name, int level){
        super(name, level);
        this.INT += 2;
        this.CON += 1;
        this.addFeat("Arcane Recovery");
        this.addFeat("Spell Mastery");
    }
}