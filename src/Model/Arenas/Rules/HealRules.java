package Model.Arenas.Rules;

import Model.Arenas.ArenaModel.GladiatorArena;
import Model.Arenas.Team.TeamEnum;
import Model.Skills.Effect.SkillEffect;

public class HealRules implements ArenaRules {

    private int damageHealedTeamRed;
    private int damageHealedTeamBlue;

    private int turnCount;

    @Override
    public boolean isDuelEnded() {
        if(turnCount < 6)
        {
            return false;
        }
        return true;
    }

    @Override
    public TeamEnum whoWon() {
        if(damageHealedTeamRed == damageHealedTeamBlue)
        {
            return TeamEnum.None;
        }

        if(damageHealedTeamRed < damageHealedTeamBlue)
        {
            return TeamEnum.Blue;
        }

        if(damageHealedTeamRed > damageHealedTeamBlue)
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
                    damageHealedTeamBlue += skillEffect.getHeal();
                }
                break;
            case Red:
                for (SkillEffect skillEffect : gladiatorArena.getLastEffects())
                {
                    damageHealedTeamRed += skillEffect.getHeal();
                }
        }

        turnCount++;
    }
}
