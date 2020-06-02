package Model.Arenas.Rules;

import Model.Arenas.Team.TeamEnum;

public class DamageRules implements ArenaRules {
    private int damageTeamRed;
    private int damageTeamBlue;

    private int turnCount;


    @Override
    public boolean isDuelEnded() {
        if(turnCount <= 5)
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
}
