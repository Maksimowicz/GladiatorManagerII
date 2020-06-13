package Model.Tavern.TaverController;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorDummy.GladiatorDummy;
import Model.Gladiator.GladiatorDummy.RandomGladiatorDummyGenerator;

import java.util.ArrayList;

//TODO: ADD GLADIATOR FACTORY
public class Tavern {

    RandomGladiatorDummyGenerator randomGladiatorDummyGenerator;
    //ArrayList<Gladiator> gladiatorsInTavern;

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
        Gladiator gladiatorBought = gladiatorsInTavern.get(gladiatorIndex).convertIntoGladiator();
        gladiatorsInTavern.set(gladiatorIndex, null);

        return gladiatorBought;
    }

}
