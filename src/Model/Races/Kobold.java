package Model.Races;

public class Kobold extends Race {
    public String getName()
    {
        return "Kobold";
    }

    @Override
    public RaceTypes getRaceType() {
        return RaceTypes.Kobold;
    }
}
