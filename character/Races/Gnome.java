package character.Races;

public class Gnome implements RaceProperties{

    //bonus stats for different races
    @Override
    public double bonusSTR(){
        return 1.07;
    }

    @Override
    public double bonusDEF(){
        return 1.03;
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
        return "Gnome";
    }
}
