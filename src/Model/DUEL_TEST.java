package Model;

import Model.Arenas.ArenaModel.GladiatorArena;
import Model.Arenas.Qualifier.ArenaQualifier;
import Model.Arenas.Qualifier.LevelQualifier;
import Model.Arenas.Rules.ArenaRules;
import Model.Arenas.Rules.DamageRules;
import Model.Gladiator.Gladiator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DUEL_TEST {
    private JPanel MAIN_PANEL;
    private JLabel RedHP;
    private JLabel BlueHP;
    private JButton punchButton1;
    private JButton punchButton;
    private JButton START_BTN;

    ArenaQualifier levelQualifier;
    ArenaRules     damageRules;

    ArrayList<Gladiator> blueTeam;
    ArrayList<Gladiator> redTeam;



    GladiatorArena gladiatorArena;
    public void initializeFight()
    {
        levelQualifier = new LevelQualifier(10);
        damageRules = new DamageRules();

        blueTeam = new ArrayList<Gladiator>();
        redTeam = new ArrayList<Gladiator>();

        //blueTeam.add(new CommonGladiator(Race.createRace(RaceTypes)))

        gladiatorArena = new GladiatorArena(levelQualifier, damageRules,blueTeam, redTeam, 5);

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

            }
        });
    }
}
