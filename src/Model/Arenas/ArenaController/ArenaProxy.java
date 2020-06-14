package Model.Arenas.ArenaController;

import Model.Arenas.ArenaModel.GladiatorArena;
import Model.Arenas.Qualifier.ArenaQualifier;
import Model.Arenas.Rules.RulesEnum.ArenaRulesEnum;
import Model.Arenas.Rules.RulesFactory.RulesFactory;
import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorDummy.GladiatorDummy;


import java.util.ArrayList;

public class ArenaProxy {

    ArenaRulesEnum arenaRulesEnum;
    ArenaQualifier arenaQualifier;
    GladiatorDummy gladiatorDummy;


    Gladiator gladiatorBlue;

    public ArenaProxy(ArenaRulesEnum arenaRulesEnum, ArenaQualifier arenaQualifier, GladiatorDummy gladiatorDummy)
    {
        this.arenaRulesEnum = arenaRulesEnum;
        this.arenaQualifier = arenaQualifier;
        this.gladiatorDummy = gladiatorDummy;
    }


    public ArenaQualifier getArenaQualifierClass()
    {
        return this.arenaQualifier;
    }

    public String getRules()
    {
        return arenaRulesEnum.toString();
    }

    public String getQualifier()
    {
        return arenaQualifier.getName();
    }

    public String getQualifierDescription()
    {
        return arenaQualifier.getDescription();
    }

    public GladiatorDummy getGladiatorDummy()
    {
        return this.gladiatorDummy;
    }

    public void putGladiator(Gladiator gladiator)
    {
        gladiatorBlue = gladiator;
    }


    public boolean canArenaBeStarted()
    {
        if(!gladiatorBlue.equals(null))
        {
            return true;
        }

        return false;
    }


    public GladiatorArena convertToGladiatorArena()
    {
        GladiatorArena gladiatorArena;
        ArrayList<Gladiator> teamBlue = new ArrayList<Gladiator>();
        ArrayList<Gladiator> teamRed = new ArrayList<Gladiator>();

        teamBlue.add(gladiatorBlue);
        teamRed.add(gladiatorDummy.convertIntoGladiator(true));

        return new GladiatorArena(this.arenaQualifier, RulesFactory.constructArenaRules(arenaRulesEnum),teamBlue, teamRed );
    }


}
