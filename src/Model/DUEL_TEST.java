package Model;

import Model.Arenas.ArenaModel.GladiatorArena;
import Model.Arenas.Qualifier.ArenaQualifier;
import Model.Arenas.Qualifier.LevelQualifier;
import Model.Arenas.Rules.ArenaRules;
import Model.Arenas.Rules.DamageRules;
import Model.Classes.Mages.MageSubtypes;
import Model.Classes.Mages.MagesFactory;
import Model.Classes.Warriors.WarriorSubtypes;
import Model.Classes.Warriors.WarriorsFactory;
import Model.Gladiator.Gladiator;
import Model.Gladiator.RareGladiator;
import Model.Races.Race;
import Model.Races.RaceTypes;
import Model.Skills.Arcane.SiphonLife;
import Model.Skills.Common.Punch;
import Model.Skills.Physical.FrenzyStrike;
import Model.Skills.Skill;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DUEL_TEST {
    private JPanel MAIN_PANEL;
    private JLabel RedHP;
    private JLabel BlueHP;
    private JButton RedSkill1;
    private JButton BlueSkill1;
    private JButton START_BTN;
    private JLabel BlueLabel;
    private JLabel RedLabel;
    private JLabel Winner;
    private JLabel TurnCounter;
    private JButton BlueSkill2;
    private JButton RedSkill2;
    private JButton BlueSkill3;
    private JButton RedSkill3;
    private JButton BlueSkill4;
    private JButton RedSkill4;

    ArenaQualifier levelQualifier;
    ArenaRules     damageRules;

    ArrayList<Gladiator> blueTeam;
    ArrayList<Gladiator> redTeam;

    boolean isStarted;

    ArrayList<JButton> redButtons;
    ArrayList<JButton> blueButtons;


    public void setButtonsLabels()
    {
        int iterator = 0;
        for(Skill skill : blueTeam.get(0).getSkillList())
        {
            blueButtons.get(iterator).setText(skill.getName());
            blueButtons.get(iterator++).setEnabled(true);
        }

        iterator = 0;
        for(Skill skill : redTeam.get(0).getSkillList())
        {
            redButtons.get(iterator).setText(skill.getName());
            redButtons.get(iterator++).setEnabled(true);
        }
    }

    public void enableRedSkills(boolean enable)
    {
        for(int i = 0; i < redTeam.get(0).getSkillList().size(); i++)
        {
            redButtons.get(i).setEnabled(enable);
        }
    }

    public void enableBlueSkills(boolean enable)
    {
        for(int i = 0; i < blueTeam.get(0).getSkillList().size(); i++)
        {
            blueButtons.get(i).setEnabled(enable);
        }
    }

    GladiatorArena gladiatorArena;



    public void enableButtons()
    {
        switch (gladiatorArena.getActiveTeam())
        {
            case Red:
                enableRedSkills(true);
                break;
            case Blue:
                enableBlueSkills(true);
                break;
        }
    }



    public void startFight()
    {
        WarriorsFactory warriorsFactory = new WarriorsFactory();
        MagesFactory magesFactory = new MagesFactory();

        blueTeam.add(new RareGladiator(Race.createRace(RaceTypes.Orc),
                                            warriorsFactory.createGladiatorClass(WarriorSubtypes.constructBerserker()),
                                            "Zenuś Mordotłuk"));

        redTeam.add(new RareGladiator(Race.createRace(RaceTypes.Dwarf),
                                        //warriorsFactory.createGladiatorClass(WarriorSubtypes.constructDuelist()),
                                        magesFactory.createGladiatorClass(MageSubtypes.constructCurser()),
                                        "Krzyśko Gniewnopały"));

        redButtons = new ArrayList<JButton>();
        blueButtons = new ArrayList<JButton>();


        blueTeam.get(0).Level = 10;
        redTeam.get(0).Level = 10;

        blueTeam.get(0).setBaseHealthPoints();
        redTeam.get(0).setBaseHealthPoints();

        blueTeam.get(0).addSkill(new Punch(blueTeam.get(0)));
        redTeam.get(0).addSkill(new Punch(redTeam.get(0)));

        blueTeam.get(0).addSkill(new FrenzyStrike(blueTeam.get(0)));
        redTeam.get(0).addSkill(new SiphonLife(redTeam.get(0)));

        blueTeam.get(0).prepareForFight();
        redTeam.get(0).prepareForFight();


        gladiatorArena = new GladiatorArena(levelQualifier, damageRules, blueTeam, redTeam);

        isStarted = true;


        RedHP.setText(Integer.toString(redTeam.get(0).getHealthPoints()));
        BlueHP.setText(Integer.toString(blueTeam.get(0).getHealthPoints()));

        RedLabel.setText(redTeam.get(0).getGladiatorName() + " " + redTeam.get(0).getRace() + " " + redTeam.get(0).getGladiatorClass());
        BlueLabel.setText(blueTeam.get(0).getGladiatorName() + " " + blueTeam.get(0).getRace() + " " + blueTeam.get(0).getGladiatorClass());

        TurnCounter.setText(Integer.toString(gladiatorArena.getRoundCounter()));


        redButtons.add(RedSkill1);
        redButtons.add(RedSkill2);
        redButtons.add(RedSkill3);
        redButtons.add(RedSkill4);

        blueButtons.add(BlueSkill1);
        blueButtons.add(BlueSkill2);
        blueButtons.add(BlueSkill3);
        blueButtons.add(BlueSkill4);

        setButtonsLabels();
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
    public void refreshValues()
    {
        RedHP.setText(Integer.toString(redTeam.get(0).getHealthPoints()));
        BlueHP.setText(Integer.toString(blueTeam.get(0).getHealthPoints()));
        TurnCounter.setText(Integer.toString(gladiatorArena.getRoundCounter()));
    }

    //Simple version with damage only
    public void roundConclusion()
    {
        if(gladiatorArena.nextRound())
        {
            Winner.setText(gladiatorArena.winnerTeam.toString());
            enableRedSkills(false);
            enableBlueSkills(false);
            refreshValues();
            return;
        }
        enableButtons();
        refreshValues();
    }

    public DUEL_TEST() {
        START_BTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeFight();
                startFight();
                //RedHP.setText("180");
                START_BTN.setEnabled(false);
                enableButtons();



            }
        });

        BlueSkill1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(blueTeam.get(0).useSkill(0, redTeam.get(0)));
                enableBlueSkills(false);
                roundConclusion();

            }
        });

        BlueSkill2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(blueTeam.get(0).useSkill(1, redTeam.get(0)));
                enableBlueSkills(false);
                roundConclusion();
            }
        });
        BlueSkill3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(blueTeam.get(0).useSkill(2, redTeam.get(0)));
                enableBlueSkills(false);
                roundConclusion();
            }
        });
        BlueSkill4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(blueTeam.get(0).useSkill(3, redTeam.get(0)));
                enableBlueSkills(false);
                roundConclusion();
            }
        });

        RedSkill1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(redTeam.get(0).useSkill(0, blueTeam.get(0)));
                enableRedSkills(false);
                roundConclusion();
            }
        });

        RedSkill2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(redTeam.get(0).useSkill(1, blueTeam.get(0)));
                enableRedSkills(false);
                roundConclusion();
            }
        });

        RedSkill3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(redTeam.get(0).useSkill(2, blueTeam.get(0)));
                enableRedSkills(false);
                roundConclusion();
            }
        });

        RedSkill4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(redTeam.get(0).useSkill(3, blueTeam.get(0)));
                enableRedSkills(false);
                roundConclusion();
            }
        });
    }


}
