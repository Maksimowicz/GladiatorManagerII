package Model.FORMS;

import Model.Gladiator.Gladiator;
import Model.Gladiator.GladiatorStatistic;
import Model.PlayerContext.PlayerContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class TEAM_FORM {
    private JPanel MainPanel;
    private JPanel Gladiator_1;
    private JTextField Gladiator_1_Level;
    private JTextField Gladiator_1_Race;
    private JTextField Gladiator_1_Class;
    private JTextField Gladiator_1_Strength;
    private JTextField Gladiator_1_Agility;
    private JTextField Gladiator_1_Intelligence;
    private JTextField Gladiator_1_Defence;
    private JButton Gladiator_1_Sell;
    private JButton Gladiator_2_Sell;
    private JButton Gladiator_3_Sell;
    private JButton Gladiator_4_Sell;
    private JButton Gladiator_5_Sell;
    private JButton Gladiator_6_Sell;
    private JButton Gladiator_1_SList;
    private JButton Gladiator_2_SList;
    private JButton Gladiator_3_SList;
    private JButton Gladiator_4_SList;
    private JButton Gladiator_5_SList;
    private JButton Gladiator_6_SList;
    private JPanel Gladiator_2;
    private JPanel Gladiator_3;
    private JPanel Gladiator_4;
    private JPanel Gladiator_5;
    private JPanel Gladiator_6;
    private JTextField Gladiator_1_Cost;
    private JTextField Gladiator_2_Cost;
    private JTextField Gladiator_3_Cost;
    private JTextField Gladiator_4_Cost;
    private JTextField Gladiator_5_Cost;
    private JTextField Gladiator_6_Cost;
    private JLabel Gladiator_1_Name;
    private JTextField Gladiator_2_Level;
    private JLabel Gladiator_2_Name;
    private JTextField Gladiator_2_Race;
    private JTextField Gladiator_2_Class;
    private JTextField Gladiator_2_Strength;
    private JTextField Gladiator_2_Agility;
    private JTextField Gladiator_2_Intelligence;
    private JTextField Gladiator_2_Defence;
    private JTextField Gladiator_3_Level;
    private JTextField Gladiator_3_Race;
    private JTextField Gladiator_3_Class;
    private JTextField Gladiator_3_Strength;
    private JTextField Gladiator_3_Agility;
    private JTextField Gladiator_3_Intelligence;
    private JTextField Gladiator_3_Defence;
    private JTextField Gladiator_4_Level;
    private JTextField Gladiator_4_Race;
    private JTextField Gladiator_4_Class;
    private JTextField Gladiator_4_Strength;
    private JTextField Gladiator_4_Agility;
    private JTextField Gladiator_4_Intelligence;
    private JTextField Gladiator_4_Defence;
    private JTextField Gladiator_5_Level;
    private JLabel Gladiator_5_Name;
    private JTextField Gladiator_5_Race;
    private JTextField Gladiator_5_Class;
    private JTextField Gladiator_5_Strength;
    private JTextField Gladiator_5_Agility;
    private JTextField Gladiator_5_Intelligence;
    private JTextField Gladiator_5_Defence;
    private JLabel Gladiator_6_Name;
    private JTextField Gladiator_6_Level;
    private JTextField Gladiator_6_Race;
    private JTextField Gladiator_6_Class;
    private JTextField Gladiator_6_Strength;
    private JTextField Gladiator_6_Agility;
    private JTextField Gladiator_6_Intelligence;
    private JTextField Gladiator_6_Defence;
    private JLabel Gladiator_3_Name;
    private JLabel Gladiator_4_Name;
    private JButton Gladiator_1_Gym;
    private JButton Gladiator_2_Gym;
    private JButton Gladiator_3_Gym;
    private JButton Gladiator_4_Gym;
    private JButton Gladiator_5_Gym;
    private JButton Gladiator_6_Gym;

    ArrayList<GladiatorControlGroup> gladiatorControlGroup;
    PlayerContext playerContext;
    MAIN_FORM parent;

    class GladiatorControlGroup
    {
        JLabel nameFieldAndRarity;


        JTextField raceField;
        JTextField levelField;
        JTextField gladiatorClassField;
        JTextField costField;

        JTextField strengthField;
        JTextField agilityField;
        JTextField intelligenceField;
        JTextField defenceField;

        JButton skillList;
        JButton sell;
        JButton gymnasion;

        Gladiator gladiator;

        public GladiatorControlGroup(JLabel nameFieldAndRarity,
                                     JTextField raceField,
                                     JTextField levelField,
                                     JTextField gladiatorClassField,
                                     JTextField costField,
                                     JTextField strengthField,
                                     JTextField agilityField,
                                     JTextField intelligenceField,
                                     JTextField defenceField,
                                     JButton skillList,
                                     JButton sell,
                                     JButton gymnasion,
                                     Gladiator gladiator)
        {
            this.nameFieldAndRarity = nameFieldAndRarity;
            this.raceField = raceField;
            this.levelField = levelField;
            this.gladiatorClassField = gladiatorClassField;
            this.costField = costField;

            this.gladiator = gladiator;

            this.strengthField = strengthField;
            this.agilityField = agilityField;
            this.intelligenceField = intelligenceField;
            this.defenceField = defenceField;
            this.skillList = skillList;
            this.sell = sell;
            this.gymnasion = gymnasion;
        }


        public void removeGladiator()
        {
            this.gladiator = null;
        }

        public void fillFieldValues()
        {
            if(gladiator != null) {
                nameFieldAndRarity.setText(gladiator.getGladiatorName() + " " + gladiator.getRarity());
                raceField.setText(gladiator.getRace());
                levelField.setText(Integer.toString(gladiator.getLevel()));
                gladiatorClassField.setText(gladiator.getGladiatorClass());
                costField.setText(Double.toString(gladiator.getGladiatorCost()));


                strengthField.setText(Integer.toString(gladiator.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Strength)));
                agilityField.setText(Integer.toString(gladiator.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Agility)));
                intelligenceField.setText(Integer.toString(gladiator.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Intelligence)));
                defenceField.setText(Integer.toString(gladiator.getGladiatorStatisticsClass().getStatistic(GladiatorStatistic.Defence)));
            }
            else
            {
                nameFieldAndRarity.setText("NO NAME");
                raceField.setText("");
                levelField.setText("");
                gladiatorClassField.setText("");
                costField.setText(Double.toString(0));


                strengthField.setText(Integer.toString(0));
                agilityField.setText(Integer.toString(0));
                intelligenceField.setText(Integer.toString(0));
                defenceField.setText(Integer.toString(0));
                sell.setEnabled(false);
                skillList.setEnabled(false);
                gymnasion.setEnabled(false);

            }
        }

    }

    public void getControlGroups()
    {
        int iterator = 0;

        JTextField race, level, classField, cost, strength, agility, intelligence, defence;
        JButton skillList, sell, gymnasion;
        JLabel nameAndRarity = null;

        race = null;
        level = null;
        classField = null;
        cost = null;
        strength = null;
        agility = null;
        intelligence = null;
        defence = null;

        skillList = null;
        sell = null;
        gymnasion = null;

        for(Component component_inner: MainPanel.getComponents())
        {
            if(component_inner instanceof JPanel)
            {
                for(Component text_components : ((JPanel) component_inner).getComponents())
                {
                    if(text_components instanceof  JTextField)
                    {

                        if(text_components.getName().contains("Level"))
                        {
                            level = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Race"))
                        {
                            race = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Class"))
                        {
                            classField = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Cost"))
                        {
                            cost = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Strength"))
                        {
                            strength = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Agility"))
                        {
                            agility = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Intelligence"))
                        {
                            intelligence = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Defence"))
                        {
                            defence = (JTextField)text_components;
                        }

                    }

                    if(text_components instanceof JLabel) {
                        if(text_components.getName() != null && text_components.getName().contains("Name"))
                        {
                            nameAndRarity = (JLabel)text_components;
                        }
                    }

                    if(text_components instanceof JButton)
                    {
                        if(text_components.getName() != null && text_components.getName().contains("SList"))
                        {
                            skillList = (JButton)text_components;
                        }
                        else if(text_components.getName() != null && text_components.getName().contains("Sell"))
                        {
                            sell = (JButton)text_components;
                        }
                        else if(text_components.getName() != null && text_components.getName().contains("Gym"))
                        {
                            gymnasion = (JButton)text_components;
                        }




                    }
                }


                Gladiator gladiatorHelper = null;
                if(iterator < playerContext.getTeamSize()) {
                    gladiatorHelper = playerContext.getGladiator(iterator++);
                }
                gladiatorControlGroup.add(
                        new TEAM_FORM.GladiatorControlGroup(
                                nameAndRarity,
                                race,
                                level,
                                classField,
                                cost,
                                strength,
                                agility,
                                intelligence,
                                defence,
                                skillList,
                                sell,
                                gymnasion,
                                gladiatorHelper
                                ));
            }
        }
    }

    public void fillFields()
    {
        for(GladiatorControlGroup gcg: gladiatorControlGroup)
        {
            gcg.fillFieldValues();
        }
    }

    public JPanel getMainFrame()
    {
        return this.MainPanel;
    }

    public void setEnableForm(boolean enabled)
    {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.setEnabled(enabled);

    }

    public void  addCloseListener() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(getMainFrame(), "Do you want to leave Team?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {

                    return;
                }

                playerContext.removeNullsFromTeam();
                parent.setEnableForm(true);
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
                topFrame.dispose();
                //System.exit(-1);
            }

            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
    }

    public void sellGladiator(int gladiatorIndex)
    {
        playerContext.receiveGold(playerContext.getGladiator(gladiatorIndex).getGladiatorCost());
        playerContext.removeGladiatorFromTeam(gladiatorIndex);
        gladiatorControlGroup.get(gladiatorIndex).removeGladiator();
        fillFields();


    }

    public void runSkillsForm(int indexOfGladiator)
    {
        SKILLS_FORM form = new SKILLS_FORM(playerContext, playerContext.getGladiator(indexOfGladiator), this);
        JFrame frame = new JFrame("SKILL");

        frame.setContentPane(form.getMainFrame());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        form.addCloseListener();

        setEnableForm(false);
    }

    public void runGymnasionForm(int indexOfGladiator)
    {
        GYMNASION_FORM form = new GYMNASION_FORM(playerContext, playerContext.getGladiator(indexOfGladiator), this);
        JFrame frame = new JFrame("GYMNASION");

        frame.setContentPane(form.getMainFrame());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        form.addCloseListener();

        setEnableForm(false);
    }

    public TEAM_FORM(PlayerContext playerContext, MAIN_FORM parent)
    {
        this.gladiatorControlGroup = new ArrayList<GladiatorControlGroup>();
        this.playerContext = playerContext;
        this.parent = parent;
        getControlGroups();
        fillFields();

        Gladiator_1_SList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSkillsForm(0);
            }
        });
        Gladiator_1_Sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellGladiator(0);
            }
        });
        Gladiator_2_SList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSkillsForm(1);
            }
        });
        Gladiator_2_Sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellGladiator(1);
            }
        });

        Gladiator_3_SList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSkillsForm(2);
            }
        });
        Gladiator_3_Sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellGladiator(2);
            }
        });
        Gladiator_4_SList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSkillsForm(3);
            }
        });
        Gladiator_4_Sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellGladiator(3);
            }
        });

        Gladiator_5_SList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSkillsForm(4);
            }
        });
        Gladiator_5_Sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellGladiator(4);
            }
        });
        Gladiator_6_SList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSkillsForm(5);
            }
        });
        Gladiator_6_Sell.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sellGladiator(5);
            }
        });
        Gladiator_1_Gym.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGymnasionForm(0);
            }
        });
        Gladiator_2_Gym.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGymnasionForm(1);
            }
        });
        Gladiator_3_Gym.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGymnasionForm(2);
            }
        });
        Gladiator_4_Gym.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGymnasionForm(3);
            }
        });
        Gladiator_5_Gym.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGymnasionForm(4);
            }
        });
        Gladiator_6_Gym.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGymnasionForm(5);
            }
        });
    }


}
