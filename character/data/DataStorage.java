package character.data;

import java.io.Serializable;

import character.Races.RaceProperties;

public class DataStorage implements Serializable{ //storage for certain data
    String name;
    double STR;
    double INT;
    double AGI;
    double DEF;
    double LVL;
    double XP;
    RaceProperties race;
}
