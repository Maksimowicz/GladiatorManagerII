package Model.Races;

public class Elf extends Race {
    public String getName()
    {
        return "Elf";
    }

    @Override
    public RaceTypes getRaceType() {
        return RaceTypes.Elf;
    }
}
