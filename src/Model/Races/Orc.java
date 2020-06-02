package Model.Races;

public class Orc extends Race {
    public String getName()
    {
        return "Orc";
    }

    @Override
    public RaceTypes getRaceType() {
        return RaceTypes.Orc;
    }
}
