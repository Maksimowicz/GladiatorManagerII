package Model.Gladiator.GladiatorFactory;

import Model.Classes.GladiatorClass;
import Model.Gladiator.Gladiator;
import Model.Gladiator.RareGladiator;
import Model.Races.Race;

public class RareGladiatorFactory implements GladiatorAbstractFactory{
    @Override
    public Gladiator createGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName, int level) {
        return new RareGladiator(gladiatorRace, gladiatorClass, gladiatorName, level);
    }

    @Override
    public Gladiator createGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName) {
        return new RareGladiator(gladiatorRace, gladiatorClass, gladiatorName);
    }
}
