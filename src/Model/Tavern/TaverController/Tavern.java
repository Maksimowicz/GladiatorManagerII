package Model.Tavern.TaverController;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorDummy.GladiatorDummy;
import Model.Gladiator.GladiatorDummy.RandomGladiatorDummyGenerator;

import java.util.ArrayList;


public class Tavern {

    RandomGladiatorDummyGenerator randomGladiatorDummyGenerator;

    ArrayList<GladiatorDummy> gladiatorsInTavern;
    public Tavern()
    {

        randomGladiatorDummyGenerator = new RandomGladiatorDummyGenerator();

        gladiatorsInTavern = new ArrayList<GladiatorDummy>();
        this.initializeTavern();
    }

    private void initializeTavern()
    {
        for(int i  = 0; i < 7; i++)
        {
            gladiatorsInTavern.add(randomGladiatorDummyGenerator.generateRandomGladiatorDummy());
        }
    }

    public ArrayList<GladiatorDummy> getGladiatorsInTavern()
    {
        return gladiatorsInTavern;
    }


    public Gladiator buyGladiator(int gladiatorIndex)
    {
        Gladiator gladiatorBought = gladiatorsInTavern.get(gladiatorIndex).convertIntoGladiator(false);
        gladiatorsInTavern.set(gladiatorIndex, null);

        return gladiatorBought;
    }

}
