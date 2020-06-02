package Model.Races;

public class Human extends Race {
    public String getName()
    {
        return "Human";
    }

    @Override
    public RaceTypes getRaceType() {
        return RaceTypes.Human;
    }
}
