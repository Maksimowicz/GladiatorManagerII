package Model.Arenas.Rules;

import Model.Arenas.Team.TeamEnum;

public interface ArenaRules {

    public boolean isDuelEnded();
    public TeamEnum whoWon();

}
