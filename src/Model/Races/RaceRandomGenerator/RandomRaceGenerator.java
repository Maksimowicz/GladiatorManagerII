package Model.Races.RaceRandomGenerator;

import Model.Races.Race;
import Model.Races.RaceTypes;

import java.util.Random;

public class RandomRaceGenerator{
    Random random;

    public RandomRaceGenerator()
    {
        random = new Random();
    }

    public RaceTypes getRandomRaceType()
    {
        int randomizedType = random.nextInt(RaceTypes.values().length);

        return RaceTypes.values()[randomizedType];
    }

    public Race getRandomRace()
    {
        return Race.createRace(this.getRandomRaceType());
    }


}
