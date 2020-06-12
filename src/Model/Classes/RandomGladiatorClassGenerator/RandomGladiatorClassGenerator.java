package Model.Classes.RandomGladiatorClassGenerator;

import Model.Classes.GladiatorClass;
import Model.Classes.GladiatorClassFactory.GladiatorClassAbstractFactory;
import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mages.MageSubtypes;
import Model.Classes.Mages.MagesFactory;
import Model.Classes.Rogues.RogueSubtypes;
import Model.Classes.Rogues.RoguesFactory;
import Model.Classes.Warriors.WarriorSubtypes;
import Model.Classes.Warriors.WarriorsFactory;

import java.util.Random;

public class RandomGladiatorClassGenerator {
    Random random;


    public RandomGladiatorClassGenerator()
    {
        random = new Random();
    }


    public GladiatorClass getRandomGladiatorClass()
    {
        GladiatorClassSubtypes gladiatorClassSubtypes = this.getRandomGladiatorClassSubtypes();
        GladiatorClassAbstractFactory gladiatorClassAbstractFactory = null;

        if(gladiatorClassSubtypes instanceof WarriorSubtypes)
        {
            gladiatorClassAbstractFactory = new WarriorsFactory();
        }

        if(gladiatorClassSubtypes instanceof MageSubtypes)
        {
            gladiatorClassAbstractFactory = new MagesFactory();
        }

        if(gladiatorClassSubtypes instanceof RogueSubtypes)
        {
            gladiatorClassAbstractFactory = new RoguesFactory();
        }


        return gladiatorClassAbstractFactory.createGladiatorClass(gladiatorClassSubtypes);
    }


    public GladiatorClassSubtypes getRandomGladiatorClassSubtypes()
    {
        int randomizedClassSubtype = random.nextInt(9);

        switch (randomizedClassSubtype)
        {
            case 0:
                return WarriorSubtypes.constructDuelist();
            case 1:
                return WarriorSubtypes.constructDefender();
            case 2:
                return WarriorSubtypes.constructBerserker();

            case 3:
                return MageSubtypes.constructIllusionist();
            case 4:
                return MageSubtypes.constructElementalist();
            case 5:
                return MageSubtypes.constructCurser();

            case 6:
                return RogueSubtypes.constructEquilibrist();
            case 7:
                return RogueSubtypes.constructAssassin();
            case 8:
                return  RogueSubtypes.constructArcher();


        }

        return null;
   }
}
