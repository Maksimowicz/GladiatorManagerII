package Model.Races;

public class Dwarf extends Race{
    public String getName()
    {
        return "Dwarf";
    }

    @Override
    public RaceTypes getRaceType() {
        return RaceTypes.Dwarf;
    }
}
