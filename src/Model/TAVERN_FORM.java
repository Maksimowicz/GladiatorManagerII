package Model;

import Model.Gladiator.GladiatorDummy.GladiatorDummy;
import Model.Tavern.TaverController.Tavern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;


public class TAVERN_FORM {
    private JTextField Glad_4_Rarity;
    private JTextField Glad_4_Level;
    private JTextField Glad_4_Race;
    private JPanel Gladiator_4;
    private JPanel Gladiator_2;
    private JPanel Gladiator_3;
    private JPanel Gladiator_1;
    private JPanel Gladiator_5;
    private JPanel Gladiator_6;
    private JLabel Glad_1_Name;
    private JLabel Glad_2_Name;
    private JLabel Glad_3_Name;
    private JLabel Glad_4_Name;
    private JLabel Glad_5_Name;
    private JLabel Glad_6_Name;
    private JTextField Glad_1_Class;
    private JTextField Glad_2_Class;
    private JTextField Glad_3_Class;
    private JTextField Glad_4_Class;
    private JTextField Glad_5_Class;
    private JTextField Glad_6_Class;
    private JTextField Glad_1_Rarity;
    private JTextField Glad_1_Level;
    private JTextField Glad_1_Race;
    private JTextField Glad_2_Rarity;
    private JTextField Glad_2_Level;
    private JTextField Glad_2_Race;
    private JTextField Glad_3_Rarity;
    private JTextField Glad_3_Level;
    private JTextField Glad_3_Race;
    private JTextField Glad_5_Rarity;
    private JTextField Glad_5_Level;
    private JTextField Glad_5_Race;
    private JTextField Glad_6_Rarity;
    private JTextField Glad_6_Level;
    private JTextField Glad_6_Race;
    private JPanel MainPanel;
    private JTextField Glad_1_Cost;
    private JTextField Glad_2_Cost;
    private JTextField Glad_3_Cost;
    private JTextField Glad_4_Cost;
    private JTextField Glad_5_Cost;
    private JTextField Glad_6_Cost;
    private JButton HireGladiator_1;
    private JButton HireGladiator_2;
    private JButton HireGladiator_3;
    private JButton HireGladiator_4;
    private JButton HireGladiator_5;
    private JButton HireGladiator_6;


    ArrayList<GladiatorControlGroup> gladiatorControlGroup;
    Tavern tavern;



    public JPanel getJPanel()
    {
        return this.MainPanel;
    }



    public TAVERN_FORM() {
        this.tavern =  new Tavern();
        gladiatorControlGroup = new ArrayList<GladiatorControlGroup>();


        MainPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);

            }
        });

        HireGladiator_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        HireGladiator_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        HireGladiator_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        HireGladiator_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        HireGladiator_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        HireGladiator_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void getControlGroups()
    {
        int iterator = 0;

        JTextField level, race, gladClass, cost,rarity;
        JLabel name;

        name  = null;
        level = null;
        race = null;
        gladClass = null;
        cost = null;
        rarity = null;

        for(Component component_inner: MainPanel.getComponents())
        {
            if(component_inner instanceof JPanel)
            {
                for(Component text_components : ((JPanel) component_inner).getComponents())
                {
                    if(text_components instanceof  JTextField)
                    {
                        if(text_components.getName().contains("Rarity"))
                        {
                            rarity = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Level"))
                        {
                            level = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Race"))
                        {
                            race = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Class"))
                        {
                            gladClass = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Cost"))
                        {
                            cost = (JTextField)text_components;
                        }
                    }

                    if(text_components instanceof JLabel) {
                        if(text_components.getName().contains("Name"))
                        {
                            name = (JLabel)text_components;
                        }
                    }
                }




                gladiatorControlGroup.add(
                                            new GladiatorControlGroup(
                                                                        name,
                                                                        race,
                                                                        level,
                                                                        gladClass,
                                                                        cost,
                                                                        rarity,
                                                                        tavern.getGladiatorsInTavern().get(iterator++)));
            }
        }
    }

    public void showGladiatorsInfo()
    {
        if(!gladiatorControlGroup.equals(null))
        {
            for(GladiatorControlGroup gcg:gladiatorControlGroup)
            {
                gcg.fillFieldValues();
            }
        }
    }



    class GladiatorControlGroup
    {
        JTextField rarityField;
        JTextField raceField;
        JTextField levelField;
        JTextField gladiatorClassField;
        JTextField costField;
        JLabel nameField;


        GladiatorDummy gladiator;

        public GladiatorControlGroup(JLabel nameField, JTextField raceField, JTextField levelField, JTextField gladiatorClassField, JTextField costField, JTextField rarityField, GladiatorDummy gladiator)
        {
            this.nameField = nameField;
            this.raceField = raceField;
            this.levelField = levelField;
            this.gladiatorClassField = gladiatorClassField;
            this.costField = costField;
            this.rarityField = rarityField;
            this.gladiator = gladiator;
        }


        public void setGladiator(GladiatorDummy gladiator)
        {
            this.gladiator = gladiator;
        }

        public void setNameField(JLabel nameField)
        {
            this.nameField = nameField;
        }

        public void setRace(JTextField raceField)
        {
            this.raceField = raceField;
        }

        public void setLevel(JTextField levelField)
        {
            this.levelField = levelField;
        }

        public void setGladiatorClass(JTextField gladiatorClassField)
        {
            this.gladiatorClassField = gladiatorClassField;
        }

        public void setCostField(JTextField costField)
        {
            this.costField = costField;
        }

        public void fillFieldValues()
        {
            nameField.setText(gladiator.getName());
            raceField.setText(gladiator.getRaceTypes().toString());
            levelField.setText(Integer.toString(gladiator.getLevel()));
            gladiatorClassField.setText(gladiator.getClassName().getValue());
            costField.setText(Double.toString(gladiator.getCost()));

            rarityField.setText(gladiator.getRarity());
        }

    }

    public class MyFRAME extends JFrame
    {
        TAVERN_FORM tawernTEST;

        public MyFRAME()
        {
            super("TAWERNA");

        }

        public void run()
        {

            tawernTEST = new TAVERN_FORM();

            this.setContentPane(tawernTEST.MainPanel);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
            this.setVisible(true);
        }
    }




    public static void main(String[] args) {

        TAVERN_FORM form = new TAVERN_FORM();
        JFrame frame = new JFrame("TAWERNA");
        frame.setContentPane(form.MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        form.getControlGroups();
        form.showGladiatorsInfo();
        int a = 0;
    }
}
