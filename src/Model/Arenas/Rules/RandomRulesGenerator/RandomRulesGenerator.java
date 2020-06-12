package Model.Arenas.Rules.RandomRulesGenerator;

import Model.Arenas.Rules.RulesEnum.ArenaRulesEnum;

import java.util.Random;

public class RandomRulesGenerator {
    Random random;


    public RandomRulesGenerator()
    {
        random =  new Random();
    }

    public ArenaRulesEnum generateRandomArenaRules()
    {
        int randomized = random.nextInt(ArenaRulesEnum.values().length);

        return ArenaRulesEnum.values()[randomized];
    }


}
