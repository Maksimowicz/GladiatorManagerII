package Model.Arenas.Qualifier;

import Model.Gladiator.Gladiator;

public class LevelQualifier implements ArenaQualifier{
    private int levelRequirement;

    public LevelQualifier(int levelRequirement)
    {
        this.levelRequirement = levelRequirement;
    }

    @Override
    public boolean validateGladiator(Gladiator gladiator) {
        if(gladiator.getLevel() < this.levelRequirement)
        {
            return false;
        }

        return true;
    }
}
