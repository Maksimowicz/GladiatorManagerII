package Model.Gladiator.GladiatorFactory;

import Model.Classes.GladiatorClass;
import Model.Gladiator.Gladiator;
import Model.Gladiator.LegendaryGladiator;
import Model.Races.Race;

public class LegendaryGladiatorFactory implements GladiatorAbstractFactory{
    @Override
    public Gladiator createGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName, int level) {
        return new LegendaryGladiator(gladiatorRace, gladiatorClass, gladiatorName, level);
    }

    @Override
    public Gladiator createGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName) {
        return new LegendaryGladiator(gladiatorRace, gladiatorClass, gladiatorName);
    }
}
