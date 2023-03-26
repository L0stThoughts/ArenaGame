package character.Races;

public class Human implements RaceProperties{
    
    //bonus stats for different races
    @Override
    public double bonusSTR(){
        return 1.03;
    }

    @Override
    public double bonusDEF(){
        return 1;
    }

    @Override
    public double bonusINT(){
        return 1.03;
    }

    @Override
    public double bonusAGI(){
        return 1.04;
    }

    @Override
    public String getRace(){
        return "Human";
    }
}
