package Model.Gladiator.GladiatorFactory;

import Model.Classes.GladiatorClass;
import Model.Gladiator.CommonGladiator;
import Model.Gladiator.Gladiator;
import Model.Races.Race;

public class CommonGladiatorFactory implements GladiatorAbstractFactory{

    @Override
    public Gladiator createGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName, int level) {
        return new CommonGladiator(gladiatorRace, gladiatorClass, gladiatorName, level);
    }

    @Override
    public Gladiator createGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName) {
        return new CommonGladiator(gladiatorRace, gladiatorClass, gladiatorName);
    }
}
