package character.classes;

import character.Character;
import character.Races.RaceProperties;

public class Explorer extends Character{

    public Explorer(String name, int LVL, int STR, int INT, int AGI, int DEF, int XP, RaceProperties race){
        super(name, STR, INT, AGI, DEF, LVL, XP, race);
    } 

    public Explorer(String name, int STR, int INT, int AGI, int DEF, RaceProperties race){
        super(name, STR, INT, AGI, DEF, race);
    } 
 

    @Override
    public double getAttack(){  //gains damage
        return 3 * getAGI();
    }
  
    @Override
    public double getPropertiesDefense(Character defender){  //gains defense
        return defender.getAGI();
    }

    public double getDefending(Character enemy){  //gains defense against enemy
        return enemy.getDefense(this);
    }

    public double getReceiveDamage(Character defender){  //receives damage from enemy
        return defender.getHP() - getDamage(this);
    }

    public String getCLASS(){  //class name
        return "Explorer";
    }

}
