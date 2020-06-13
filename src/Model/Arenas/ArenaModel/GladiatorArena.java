package Model.Arenas.ArenaModel;

import Model.Arenas.Qualifier.ArenaQualifier;
import Model.Arenas.Rules.ArenaRules;
import Model.Arenas.Team.TeamEnum;
import Model.Gladiator.Gladiator;
import Model.Skills.Effect.SkillEffect;

import java.util.ArrayList;
import java.util.Random;

public class GladiatorArena {
    private ArenaQualifier arenaQualifier;
    private ArenaRules     arenaRules;

    private ArrayList<Gladiator> teamBlue;
    private ArrayList<Gladiator> teamRed;
    private int roundCounter;

    TeamEnum activeTeam;
    public TeamEnum winnerTeam;
    ArrayList<SkillEffect> lastEffects;



    public GladiatorArena(ArenaQualifier arenaQualifier, ArenaRules arenaRules, ArrayList<Gladiator> teamBlue, ArrayList<Gladiator> teamRed)
    {
        this.arenaQualifier = arenaQualifier;
        this.arenaRules = arenaRules;

        this.teamBlue = teamBlue;
        this.teamRed = teamRed;

        this.rollStartingTeam();

        this.lastEffects = new ArrayList<SkillEffect>();

    }

    public boolean nextRound()
    {
        this.applyEffects();
        arenaRules.countPoints(this);
        roundCounter++;
        if(arenaRules.isDuelEnded()) {
            winnerTeam = arenaRules.whoWon();
            return true;
        }

        lastEffects.clear();
        this.changeActiveTeam();


        return false;
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
        int value = random.nextInt(2);
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

        this.activeTeam = startingTeam;

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

    //Adds skillEffect to array of skill used by active team
    public void setLastEffect(SkillEffect skillEffect)
    {
        lastEffects.add(skillEffect);
    }

    public ArrayList<SkillEffect> getLastEffects()
    {
        return lastEffects;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    private void applyEffects()
    {
        Gladiator helperGladiator = null;


        for(SkillEffect skillEffect: lastEffects)
        {
            helperGladiator = skillEffect.getTarget();

            helperGladiator.removeHealthPoints(skillEffect.getDamage());

            skillEffect.getOwner().getGladiatorStatisticsClass().addStatisticModifier(skillEffect.getGladiatorStatistic(), skillEffect.getStatisticBoost());
            skillEffect.getOwner().addHealthPoints(skillEffect.getHeal());

        }
    }
}
