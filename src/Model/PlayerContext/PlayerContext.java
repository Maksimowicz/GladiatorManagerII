package Model.PlayerContext;

import Model.Gladiator.Gladiator;

import java.util.ArrayList;

public class PlayerContext {
    ArrayList<Gladiator> gladiatorsTeam;
    final int maxGladiators = 6;
    int gold;


    public PlayerContext()
    {
        gladiatorsTeam = new ArrayList<Gladiator>();
        gold = 100000;
    }


    public boolean putGladiatorInTeam(Gladiator gladiator)
    {
        if(gladiatorsTeam.size() < 6) {
            gladiatorsTeam.add(gladiator);
            return true;
        }

        return false;
    }

    public Gladiator getGladiator(int gladiatorIndex)
    {
        return gladiatorsTeam.get(gladiatorIndex);
    }

    public void removeGladiatorFromTeam(int gladiatorIndex)
    {
        gladiatorsTeam.set(gladiatorIndex, null);
        //gladiatorsTeam.remove(gladiatorIndex);
    }

    public void receiveGold(int goldToReceive)
    {
        this.gold += goldToReceive;
    }

    public boolean payGold(int goldToPay)
    {
        if(this.gold < goldToPay)
        {
            return false;
        }

        this.gold -= goldToPay;

        return true;
    }

    public boolean isTeamFull()
    {
        if(gladiatorsTeam.size() < maxGladiators)
        {
            return false;
        }

        return true;
    }

    public int getGold()
    {
        return this.gold;
    }

    public int getTeamSize()
    {
        return gladiatorsTeam.size();
    }

    public void removeNullsFromTeam()
    {
        while(gladiatorsTeam.remove(null));
    }




}
