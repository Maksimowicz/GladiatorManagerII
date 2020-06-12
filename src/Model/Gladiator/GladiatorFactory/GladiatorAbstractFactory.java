package Model.Gladiator.GladiatorFactory;

import Model.Classes.GladiatorClass;
import Model.Gladiator.Gladiator;
import Model.Races.Race;

public interface GladiatorAbstractFactory {

    public Gladiator createGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName, int level);
    public Gladiator createGladiator(Race gladiatorRace, GladiatorClass gladiatorClass, String gladiatorName);
}
