package Model.Races;

public abstract class  Race {

    public abstract String getName();

    public abstract RaceTypes getRaceType();
    //Static farbic method for races
    public static  Race createRace(RaceTypes raceTypes)
    {
        switch(raceTypes)
        {
            case Dwarf:
                return new Dwarf();

            case Elf:
                return new Elf();

            case Human:
                return new Human();

            case Kobold:
                return new Kobold();

            case Orc:
                return new Orc();

            default:
                throw  new IllegalArgumentException();

        }
    }
}
