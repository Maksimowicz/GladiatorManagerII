package Model.Arenas.Qualifier;

import Model.Gladiator.Gladiator;
import Model.Races.RaceTypes;

import java.util.Set;

public class RaceQualifier implements ArenaQualifier {
    Set<RaceTypes> raceTypes;

    public RaceQualifier(Set<RaceTypes> raceTypes)
    {
        this.raceTypes = raceTypes;
    }

    public boolean validateGladiator(Gladiator gladiator)
    {
        if(raceTypes.contains(gladiator.getGladiatorRaceType().getRaceType()))
        {
            return true;
        }

        return false;
    }

    @Override
    public String getName() {
        return "Qualify by race";
    }

    @Override
    public String getDescription() {
        String racesToQualify = "";

        for(RaceTypes raceType : raceTypes)
        {
            racesToQualify += raceType;
            racesToQualify += ",";
        }

        if(racesToQualify != "")
        {
            racesToQualify = racesToQualify.substring(0, racesToQualify.length() -1);
        }
        return racesToQualify;
    }
}
