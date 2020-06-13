package Model.FORMS;

import Model.Gladiator.GladiatorDummy.GladiatorDummy;
import Model.PlayerContext.PlayerContext;
import Model.Tavern.TaverController.Tavern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
    private JLabel GoldLabel;


    ArrayList<GladiatorControlGroup> gladiatorControlGroup;
    Tavern tavern;
    PlayerContext playerContext;
    MAIN_FORM parent;

    private void disableAllElementsInPanel(JPanel jPanel)
    {
        for(Component component : jPanel.getComponents())
        {
            component.setEnabled(false);
        }
    }

    public JPanel getJPanel()
    {
        return this.MainPanel;
    }

    public boolean hireGladiator(int gladiatorIndex)
    {
        if(playerContext.isTeamFull())
        {
            JOptionPane.showMessageDialog(MainPanel, "Team is full.");
            return false;
        }


        if(!playerContext.payGold(tavern.getGladiatorsInTavern().get(gladiatorIndex).getCost()))
        {
            JOptionPane.showMessageDialog(MainPanel, "No enough money.");
            return false;
        }


        playerContext.putGladiatorInTeam(tavern.buyGladiator(gladiatorIndex));
        GoldLabel.setText(Integer.toString( playerContext.getGold()));
        return true;



    }


    public TAVERN_FORM(PlayerContext playerContext, MAIN_FORM parent) {
        this.tavern =  new Tavern();
        gladiatorControlGroup = new ArrayList<GladiatorControlGroup>();
        this.playerContext = playerContext;
        this.parent = parent;

        getControlGroups();
        showGladiatorsInfo();
        GoldLabel.setText(Integer.toString( playerContext.getGold()));
        //addCloseListener();
        HireGladiator_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(hireGladiator(0)) {
                    disableAllElementsInPanel(Gladiator_1);
                }
            }
        });
        HireGladiator_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hireGladiator(1)) {
                    disableAllElementsInPanel(Gladiator_2);
                }
            }
        });
        HireGladiator_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hireGladiator(2)) {
                    disableAllElementsInPanel(Gladiator_3);
                }
            }
        });
        HireGladiator_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hireGladiator(3)) {
                    disableAllElementsInPanel(Gladiator_4);
                }
            }
        });
        HireGladiator_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hireGladiator(4)) {
                    disableAllElementsInPanel(Gladiator_5);
                }
            }
        });
        HireGladiator_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(hireGladiator(5)) {
                    disableAllElementsInPanel(Gladiator_6);
                }
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

    public JPanel getMainFrame()
    {
        return this.MainPanel;
    }

    public void  addCloseListener() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(getMainFrame(), "Do you want to leave Tavern?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {

                    return;
                }

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


}
