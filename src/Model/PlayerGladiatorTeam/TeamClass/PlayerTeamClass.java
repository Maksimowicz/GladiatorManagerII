package Model.PlayerGladiatorTeam.TeamClass;

import Model.Gladiator.Gladiator;

import java.util.ArrayList;

public class PlayerTeamClass {
    private ArrayList<Gladiator> playersTeam;
    final int maxSize = 10;

    public PlayerTeamClass()
    {
        this.playersTeam = new ArrayList<Gladiator>();
    }

    public int getTeamSize()
    {
        return this.playersTeam.size();
    }

    public void addGladiatorToTeam(Gladiator gladiator)
    {
        if(playersTeam.size() <= maxSize)
        {
            playersTeam.add(gladiator);
        }

        return;
    }

    public void replaceGladiatorInTeam(int gladiatorToReplace, Gladiator gladiator)
    {
        playersTeam.set(gladiatorToReplace, gladiator);
    }

    public Gladiator getGladiator(int gladiatorToGet)
    {
        return playersTeam.get(gladiatorToGet);
    }

}
