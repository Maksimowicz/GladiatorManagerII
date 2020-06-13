package Model.Arenas.Rules;

import Model.Arenas.ArenaModel.GladiatorArena;
import Model.Arenas.Team.TeamEnum;
import Model.Skills.Effect.SkillEffect;

public class DamageRules implements ArenaRules {

    private int damageTeamRed;
    private int damageTeamBlue;

    private int turnCount;

    @Override
    public boolean isDuelEnded() {
        if(turnCount < 5)
        {
            return false;
        }
        return true;
    }

    @Override
    public TeamEnum whoWon() {
        if(damageTeamRed == damageTeamBlue)
        {
            return TeamEnum.None;
        }

        if(damageTeamRed < damageTeamBlue)
        {
            return TeamEnum.Blue;
        }

        if(damageTeamRed > damageTeamBlue)
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
                    damageTeamBlue += skillEffect.getDamage();
                }
                break;
            case Red:
                for (SkillEffect skillEffect : gladiatorArena.getLastEffects())
                {
                    damageTeamRed += skillEffect.getDamage();
                }
        }

        turnCount++;
    }
}
