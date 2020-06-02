package Model;

import Model.Arenas.ArenaModel.GladiatorArena;
import Model.Arenas.Qualifier.ArenaQualifier;
import Model.Arenas.Qualifier.LevelQualifier;
import Model.Arenas.Rules.ArenaRules;
import Model.Arenas.Rules.DamageRules;
import Model.Classes.Warriors.WarriorSubtypes;
import Model.Classes.Warriors.WarriorsFactory;
import Model.Gladiator.CommonGladiator;
import Model.Gladiator.Gladiator;
import Model.Gladiator.RareGladiator;
import Model.Races.Race;
import Model.Races.RaceTypes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DUEL_TEST {
    private JPanel MAIN_PANEL;
    private JLabel RedHP;
    private JLabel BlueHP;
    private JButton RedPunchButton;
    private JButton BluePunchButton;
    private JButton START_BTN;
    private JLabel BlueLabel;
    private JLabel RedLabel;

    ArenaQualifier levelQualifier;
    ArenaRules     damageRules;

    ArrayList<Gladiator> blueTeam;
    ArrayList<Gladiator> redTeam;

    boolean isStarted;



    GladiatorArena gladiatorArena;







    public void startFight()
    {
        WarriorsFactory warriorsFactory = new WarriorsFactory();
        blueTeam.add(new CommonGladiator(Race.createRace(RaceTypes.Orc),
                                            warriorsFactory.createGladiatorClass(WarriorSubtypes.constructBerserker()),
                                            "Zenuś Mordotłuk"));

        redTeam.add(new RareGladiator(Race.createRace(RaceTypes.Dwarf),
                                        warriorsFactory.createGladiatorClass(WarriorSubtypes.constructDefender()),
                                        "Krzyśko Gniewnopały"));

        blueTeam.get(0).Level = 10;
        redTeam.get(0).Level = 10;

        blueTeam.get(0).setBaseHealthPoints();
        redTeam.get(0).setBaseHealthPoints();

        gladiatorArena = new GladiatorArena(levelQualifier, damageRules, blueTeam, redTeam, 5);

        isStarted = true;


        RedHP.setText(Integer.toString(redTeam.get(0).getHealthPoints()));
        BlueHP.setText(Integer.toString(blueTeam.get(0).getHealthPoints()));

        RedLabel.setText(redTeam.get(0).getGladiatorName() + " " + redTeam.get(0).getRace() + " " + redTeam.get(0).getGladiatorClass());
        BlueLabel.setText(blueTeam.get(0).getGladiatorName() + " " + blueTeam.get(0).getRace() + " " + blueTeam.get(0).getGladiatorClass());

    }


    public void initializeFight()
    {
        if(!isStarted) {
            levelQualifier = new LevelQualifier(10);
            damageRules = new DamageRules();

            blueTeam = new ArrayList<Gladiator>();
            redTeam = new ArrayList<Gladiator>();
        }


    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("DUEL_TEST");
        frame.setContentPane(new DUEL_TEST().MAIN_PANEL);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }

    public DUEL_TEST() {
        START_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeFight();
                startFight();
                //RedHP.setText("180");
                START_BTN.setEnabled(false);

                RedPunchButton.setEnabled(true);
                BluePunchButton.setEnabled(true);
            }
        });
    }
}
