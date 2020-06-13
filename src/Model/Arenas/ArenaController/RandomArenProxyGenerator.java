package Model.Arenas.ArenaController;

import Model.Arenas.Qualifier.RandomQualifierGenerator.RandomQualifierGenerator;
import Model.Arenas.Rules.RandomRulesGenerator.RandomRulesGenerator;
import Model.Gladiator.GladiatorDummy.RandomGladiatorDummyGenerator;

public class RandomArenProxyGenerator {

    RandomRulesGenerator randomRulesGenerator;
    RandomGladiatorDummyGenerator randomGladiatorDummyGenerator;
    RandomQualifierGenerator randomQualifierGenerator;

    public RandomArenProxyGenerator()
    {
        randomRulesGenerator = new RandomRulesGenerator();
        randomGladiatorDummyGenerator = new RandomGladiatorDummyGenerator();
        randomQualifierGenerator = new RandomQualifierGenerator();
    }

    public ArenaProxy generateRandomArenaProxy()
    {
        return new ArenaProxy(randomRulesGenerator.generateRandomArenaRules(), randomQualifierGenerator.generateRandomQualifier(), randomGladiatorDummyGenerator.generateRandomGladiatorDummy());
    }
}
