package character;

import character.Races.RaceProperties;
import character.classes.Explorer;
import character.classes.Mage;
import character.classes.Viking;
import character.data.SaveLoad;

public abstract class Character {
    protected String name;
    public int STR;
    public int INT;
    public int AGI;
    public int DEF;
    public int LVL;
    public int XP;
    public RaceProperties race;
    SaveLoad saveLoad = new SaveLoad(this);
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSTR(int sTR) {
        STR = sTR;
    }

    public void setINT(int iNT) {
        INT = iNT;
    }

    public void setAGI(int aGI) {
        AGI = aGI;
    }

    public void setDEF(int dEF) {
        DEF = dEF;
    }

    public void setLVL(int lVL) {
        LVL = lVL;
    }

    public void setXP(int xP) {
        XP = xP;
    }

    public void setRace(RaceProperties race) {
        this.race = race;
    }

    
    
    public double getSTR(){
        return STR*race.bonusSTR();
    }

    public double getINT(){
        return INT*race.bonusINT();
    }

    public double getAGI(){
        return AGI*race.bonusAGI();
    }

    public double getDEF(){
        return DEF*race.bonusDEF();
    }

    public double getLVL(){
        return XP*100;
    }
    
    public String getName(){
        return name;
    }

    public RaceProperties getRace(RaceProperties race){
        return race;
    }

    public double getXP(){
        return XP;
    }


    public Character(String name, int STR, int INT, int AGI, int DEF, int LVL, int XP, RaceProperties race) {
        this.name = name;
        this.STR = STR;
        this.INT = INT;
        this.AGI = AGI;
        this.DEF = DEF;
        this.LVL = LVL;
        this.XP = XP;
        this.race = race;
    }
    public Character(String name, int STR, int INT, int AGI, int DEF, RaceProperties race) {
        this.name = name;
        this.STR = STR;
        this.INT = INT;
        this.AGI = AGI;
        this.DEF = DEF;
        this.LVL = 1;
        this.XP = 0;
        this.race = race;
    }
    
    /**
     * Factory method for character creation
     * class 1 = .. Viking
     * class 2 = .. Mage
     * class 3 = .. Explorer
     * @param name
     * @param STR
     * @param INT
     * @param AGI
     * @param DEF
     * @param race
     * @return
     */

    public static Character createCharacter(int CLASS, String name, int STR, int INT, int AGI, int DEF, RaceProperties race){ //creates chosen character 
        switch(CLASS){
            case 1: return new Viking(name, STR, INT, AGI, DEF, race);
            case 2: return new Mage(name, STR, INT, AGI, DEF, race);
            case 3: return new Explorer(name, STR, INT, AGI, DEF, race);
            default: throw new RuntimeException("Invalid");
        }
    }
    public abstract double getAttack(); //gets attack
    public abstract double getPropertiesDefense(Character defender); //gets defense

    public double getDamage(Character enemy){ //attack enemy
        return getAttack() - enemy.getDefense(this);
    }

    public double getDefense(Character enemy){ //gets defense against enemy
        return getDEF() + enemy.getPropertiesDefense(this);
    }

    public int getHP(){ //Hitpoints scaling
        return LVL*10;
    }

    public void lvlUp(){ //level up
        while(XP >= 100*LVL){
            XP -= 100 * LVL;
            LVL++;  
        }
    }

}
