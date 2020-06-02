package Model.Arenas.Team;

import Model.Gladiator.Gladiator;

import java.util.ArrayList;

public final class GladiatorTeam {
    ArrayList<Gladiator> teamMember;
    TeamEnum teamColor;

    public GladiatorTeam(ArrayList<Gladiator> teamComposition, TeamEnum teamColor)
    {
        this.teamMember = teamComposition;
        this.teamColor = teamColor;
    }

}
