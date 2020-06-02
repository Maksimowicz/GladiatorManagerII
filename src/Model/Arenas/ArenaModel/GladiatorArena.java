package Model.Arenas.ArenaModel;

import Model.Arenas.Qualifier.ArenaQualifier;
import Model.Arenas.Rules.ArenaRules;
import Model.Arenas.Team.TeamEnum;
import Model.Gladiator.Gladiator;

import java.util.ArrayList;
import java.util.Random;

public class GladiatorArena {
    private ArenaQualifier arenaQualifier;
    private ArenaRules     arenaRules;

    private ArrayList<Gladiator> teamBlue;
    private ArrayList<Gladiator> teamRed;
    private int roundCount;

    TeamEnum activeTeam;


    public GladiatorArena(ArenaQualifier arenaQualifier, ArenaRules arenaRules, ArrayList<Gladiator> teamBlue, ArrayList<Gladiator> teamRed, int roundCount)
    {
        this.arenaQualifier = arenaQualifier;
        this.arenaRules = arenaRules;

        this.teamBlue = teamBlue;
        this.teamRed = teamRed;

        this.roundCount = roundCount;
    }

    public void nextRound()
    {
        //TODO: Logic of round

        roundCount++;
    }

    private ArrayList<String> getTeamString(TeamEnum teamEnum)
    {
        ArrayList<String> teamArray = new ArrayList<String>();
        ArrayList<Gladiator> iterableTeam = null;

        switch(teamEnum)
        {
            case Blue:
                iterableTeam = teamBlue;
                break;
            case Red:
                iterableTeam = teamRed;
                break;
        }

        for(Gladiator gladiator : iterableTeam)
        {
            teamArray.add(gladiator.getGladiatorName() + " " + gladiator.getGladiatorClassType());
        }

        return teamArray;
    }

    public ArrayList<String> getBlueTeam()
    {
        return getTeamString(TeamEnum.Blue);
    }

    public ArrayList<String> getRedTeam()
    {
        return getTeamString(TeamEnum.Red);
    }

    public TeamEnum rollStartingTeam()
    {
        Random random = new Random();
        int value = random.nextInt(1);
        TeamEnum startingTeam = TeamEnum.None;

        switch(value)
        {
            case 0:
                startingTeam = TeamEnum.Blue;
                break;
            case 1:
                startingTeam = TeamEnum.Red;
                break;
        }

        activeTeam = startingTeam;

        return activeTeam;
    }


    public TeamEnum getActiveTeam()
    {
        return activeTeam;
    }

    private void changeActiveTeam()
    {
        switch(activeTeam)
        {
            case Blue:
                activeTeam = TeamEnum.Red;
                break;
            case Red:
                activeTeam = TeamEnum.Blue;
                break;
        }

    }


}
