package Model.FORMS;

import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mages.MageSubtypes;
import Model.Classes.Mages.MagesFactory;
import Model.Classes.Rogues.RogueSubtypes;
import Model.Classes.Rogues.RoguesFactory;
import Model.Classes.Warriors.WarriorSubtypes;
import Model.Classes.Warriors.WarriorsFactory;
import Model.Gladiator.*;
import Model.Races.Race;
import Model.Races.RaceTypes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class TEST_FORM {
    private JButton button1;
    private JPanel panel1;
    private JTextField LVL;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel LABEL_FIRST;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton LevelUp;
    private JTextField EXP;
    private JTextField EXP_NXT;
    private JTextField STR;
    private JTextField HP;
    private JTextField AGI;
    private JTextField INT;
    private JTextField DEF;

    Gladiator testedGladiator;



    public static void main(String[] args) {
        JFrame frame = new JFrame("TAWERNA");
        frame.setContentPane(new TEST_FORM().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public void setTextFields()
    {
        LVL.setText(Integer.toString( testedGladiator.getLevel()));
        HP.setText(Integer.toString(testedGladiator.getHealthPoints()));
        STR.setText(Integer.toString(testedGladiator.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Strength)));
        AGI.setText(Integer.toString(testedGladiator.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Agility)));
        INT.setText(Integer.toString(testedGladiator.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Intelligence)));
        DEF.setText(Integer.toString(testedGladiator.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Defence)));
        EXP.setText("TO IMPLEMENT");
        EXP_NXT.setText(Integer.toString(testedGladiator.getNextLevelExpirience()));
    }


    public TEST_FORM() {





        button1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                HashSet<GladiatorClassSubtypes> hashSet = new HashSet<GladiatorClassSubtypes>();
                HashSet<RaceTypes> raceTypesSet = new HashSet<RaceTypes>();

                WarriorsFactory warriorsFactory = new WarriorsFactory();
                MagesFactory magesFactory = new MagesFactory();
                RoguesFactory roguesFactory = new RoguesFactory();

                CommonGladiator gladiatorElfDuelist = new CommonGladiator(Race.createRace(RaceTypes.Elf),
                                                                            warriorsFactory.createGladiatorClass(WarriorSubtypes.constructDuelist()),
                                                                            "Zenuś");

                RareGladiator gladiatorOrcCurser = new RareGladiator(Race.createRace(RaceTypes.Orc),
                                                                        magesFactory.createGladiatorClass(MageSubtypes.constructCurser()),
                                                                        "Bronek");

                LegendaryGladiator gladiatorKoboldAssassin = new LegendaryGladiator(Race.createRace(RaceTypes.Kobold),
                                                                                roguesFactory.createGladiatorClass(RogueSubtypes.constructAssassin()),
                                                                                "Krzysiu");

                testedGladiator = gladiatorElfDuelist;
                setTextFields();

            }
        });
        LevelUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                testedGladiator.levelUp();
                testedGladiator.prepareForFight();

                setTextFields();
            }
        });
    }
}
