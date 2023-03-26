package character.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import character.Character;

public class SaveLoad {
    Character ch;

    public SaveLoad(Character ch){
        this.ch = ch;
    }

    public void save() { //saves player data
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));

            DataStorage ds = new DataStorage();

            ds.name = ch.getName();
            ds.STR = ch.getSTR();
            ds.INT = ch.getINT();
            ds.AGI = ch.getAGI();
            ds.DEF = ch.getDEF();
            ds.LVL = ch.getLVL();
            ds.XP = ch.getXP();
            ds.race = ch.getRace(null);

            oos.writeObject(ds);

        } catch(Exception e){
            System.out.println("Save Error!");
        }
        
    }

    public void load() {  //loads player data
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));

            DataStorage ds = (DataStorage)ois.readObject();

            ch.getName().replace(ch.getName(), ds.name);
            ch.STR = (int) ds.STR;
            ch.INT = (int) ds.INT;
            ch.AGI = (int) ds.AGI;
            ch.DEF = (int) ds.DEF;
            ch.LVL = (int) ds.LVL;
            ch.XP = (int) ds.XP;
            

        }catch(Exception e){
            System.out.println("Load Exception!");
        }
    }
}
