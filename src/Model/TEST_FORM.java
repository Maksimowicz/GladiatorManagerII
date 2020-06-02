package Model;

import Model.Arenas.Qualifier.ClassQualifier;
import Model.Arenas.Qualifier.RaceQualifier;
import Model.Classes.GladiatorClassSubtypes;
import Model.Classes.Mages.MageSubtypes;
import Model.Classes.Mages.MagesFactory;
import Model.Classes.Rogues.RogueSubtypes;
import Model.Classes.Rogues.RoguesFactory;
import Model.Classes.Warriors.WarriorSubtypes;
import Model.Classes.Warriors.WarriorsFactory;
import Model.Gladiator.CommonGladiator;
import Model.Gladiator.LegendaryGladiator;
import Model.Gladiator.RareGladiator;
import Model.Races.Race;
import Model.Races.RaceTypes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

public class TEST_FORM {
    private JButton button1;
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel LABEL_FIRST;
    private JLabel LABEL_SECOND;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TEST_FORM");
        frame.setContentPane(new TEST_FORM().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
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

                //SET with archer, duelist and curser

                LABEL_FIRST.setText("ARCHER DUELIST CURSER");

                hashSet.add(RogueSubtypes.constructArcher());
                hashSet.add(WarriorSubtypes.constructDuelist());
                hashSet.add(MageSubtypes.constructCurser());

                raceTypesSet.add(RaceTypes.Elf);
                raceTypesSet.add(RaceTypes.Dwarf);
                raceTypesSet.add(RaceTypes.Kobold);

                ClassQualifier classQualifier = new ClassQualifier(hashSet);
                RaceQualifier raceQualifier = new RaceQualifier(raceTypesSet);

                textField1.setText("CHECK IF ELF DUELIST CAN BE ADDED:" + " " + classQualifier.validateGladiator(gladiatorElfDuelist));
                textField2.setText("CHECK IF ORC CURSER CAN BE ADDED:" + " "+ classQualifier.validateGladiator(gladiatorOrcCurser));
                textField3.setText("CHECK IF KOBOLD ASSASSIN CAN BE ADDED:" + " " + classQualifier.validateGladiator(gladiatorKoboldAssassin));

                LABEL_SECOND.setText("ELF DWARF KOBOLD");

                textField4.setText("CHECK IF ELF ELF CAN BE ADDED:" + " " + raceQualifier.validateGladiator(gladiatorElfDuelist));
                textField5.setText("CHECK IF ORC ORC CAN BE ADDED:" + " "+ raceQualifier.validateGladiator(gladiatorOrcCurser));
                textField6.setText("CHECK IF KOBOLD ASSASSIN CAN BE ADDED:" + " " + raceQualifier.validateGladiator(gladiatorKoboldAssassin));


            }
        });
    }
}
