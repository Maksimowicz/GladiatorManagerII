package Model.Arenas.Rules;

import Model.Arenas.ArenaModel.GladiatorArena;
import Model.Arenas.Team.TeamEnum;
import Model.Skills.Effect.SkillEffect;

public class BiggestHitRules implements ArenaRules {

    private int biggestHitTeamRed;
    private int biggestHitTeamBlue;

    private int turnCount;

    @Override
    public boolean isDuelEnded() {
        if(turnCount < 4)
        {
            return false;
        }
        return true;
    }

    @Override
    public TeamEnum whoWon() {
        if(biggestHitTeamRed == biggestHitTeamBlue)
        {
            return TeamEnum.None;
        }

        if(biggestHitTeamRed < biggestHitTeamBlue)
        {
            return TeamEnum.Blue;
        }

        if(biggestHitTeamRed > biggestHitTeamBlue)
        {
            return TeamEnum.Red;
        }

        return TeamEnum.Blue;
    }

    @Override
    public void countPoints(GladiatorArena gladiatorArena)
    {
        switch(gladiatorArena.getActiveTeam())
        {
            case Blue:
                for(SkillEffect skillEffect : gladiatorArena.getLastEffects())
                {
                    if(biggestHitTeamBlue < skillEffect.getDamage()) {
                        biggestHitTeamBlue = skillEffect.getDamage();
                    }
                }
                break;
            case Red:
                for (SkillEffect skillEffect : gladiatorArena.getLastEffects())
                {
                    if(biggestHitTeamRed < skillEffect.getDamage()) {
                        biggestHitTeamRed = skillEffect.getDamage();
                    }

                }
        }

        turnCount++;
    }
}
