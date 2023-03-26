package character.Races;

//bonus stats for different races
public class Troll implements RaceProperties{
    
    @Override
    public double bonusSTR(){
        return 1.1;
    }

    @Override
    public double bonusDEF(){
        return 1.;
    }

    @Override
    public double bonusINT(){
        return 1;
    }

    @Override
    public double bonusAGI(){
        return 1;
    }

    @Override
    public String getRace(){
        return "Troll";
    }
}
