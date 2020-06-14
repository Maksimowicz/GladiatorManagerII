package Model.FORMS;

import Model.Arenas.ArenaController.ArenaProxy;
import Model.Arenas.ArenaController.RandomArenProxyGenerator;
import Model.PlayerContext.PlayerContext;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ARENA_FORM {
    private JPanel MainPanel;
    private JPanel Arena_1_Panel;
    private JPanel Arena_2_Panel;
    private JPanel Arena_3_Panel;
    private JPanel Arena_4_Panel;
    private JPanel Arena_5_Panel;
    private JPanel Arena_6_Panel;
    private JTextField Arena_2_Qualifier;
    private JTextField Arena_1_Qualifier;
    private JTextField Arena_3_Qualifier;
    private JTextField Arena_4_Qualifier;
    private JTextField Arena_5_Qualifier;
    private JTextField Arena_6_Qualifier;
    private JTextField Arena_2_QualifierDetails;
    private JTextField Arena_1_QualifierDetails;
    private JTextField Arena_3_QualifierDetails;
    private JTextField Arena_4_QualifierDetails;
    private JTextField Arena_5_QualifierDetails;
    private JTextField Arena_6_QualifierDetails;
    private JTextField Arena_5_Gladiator;
    private JTextField Arena_6_Gladiator;
    private JTextField Arena_3_Gladiator;
    private JTextField Arena_4_Gladiator;
    private JTextField Arena_1_Gladiator;
    private JTextField Arena_2_Gladiator;
    private JLabel Arena_1_Rules;
    private JLabel Arena_2_Rules;
    private JLabel Arena_3_Rules;
    private JLabel Arena_4_Rules;
    private JLabel Arena_5_Rules;
    private JLabel Arena_6_Rules;
    private JButton Arena_1_PickGlad;
    private JButton Arena_1_Start;
    private JButton Arena_2_PickGlad;
    private JButton Arena_2_Start;
    private JButton Arena_3_PickGlad;
    private JButton Arena_3_Start;
    private JButton Arena_4_PickGlad;
    private JButton Arena_4_Start;
    private JButton Arena_5_PickGlad;
    private JButton Arena_5_Start;
    private JButton Arena_6_PickGlad;
    private JButton Arena_6_Start;
    private JPanel Arena_1_ButtonsP;
    private JPanel Arena_2_ButtonsP;
    private JPanel Arena_3_ButtonsP;
    private JPanel Arena_4_ButtonsP;
    private JPanel Arena_5_ButtonsP;
    private JPanel Arena_6_ButtonsP;

    ArrayList<ArenaProxy> arenas;
    RandomArenProxyGenerator randomArenProxyGenerator;
    ArrayList<ArenaProxyControlGroup> controlGroups;

    PlayerContext playerContext;
    MAIN_FORM parent;

    public JPanel getMainFrame()
    {
        return this.MainPanel;
    }

    public void  addCloseListener() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(getMainFrame(), "Do you want to leave Arena Grounds?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {

                    return;
                }

                //playerContext.removeNullsFromTeam();

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

    public void setEnableForm(boolean enabled)
    {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.setEnabled(enabled);

    }

    class ArenaProxyControlGroup{
        JLabel rules;
        JTextField qualifier;
        JTextField qualifierDetails;
        JTextField gladiator;

        JButton pickButton;
        JButton startButton;

        ArenaProxy arenaProxy;

        public ArenaProxyControlGroup(JLabel rules, JTextField qualifier, JTextField qualifierDetails, JTextField gladiator, JButton pickButton, JButton startButton, ArenaProxy arenaProxy)
        {
            this.rules = rules;
            this.qualifier = qualifier;
            this.qualifierDetails = qualifierDetails;
            this.gladiator = gladiator;
            this.arenaProxy = arenaProxy;

            this.pickButton = pickButton;
            this.startButton = startButton;
        }

        public void setValues()
        {
            rules.setText(arenaProxy.getRules());
            qualifier.setText(arenaProxy.getQualifier());
            qualifierDetails.setText(arenaProxy.getQualifierDescription());
            gladiator.setText(arenaProxy.getGladiatorDummy().getName() + " " +
                                arenaProxy.getGladiatorDummy().getRaceTypes().name() + " "+
                                arenaProxy.getGladiatorDummy().getClassName().getValue() + " " +
                                arenaProxy.getGladiatorDummy().getLevel());

            pickButton.setEnabled(true);
            startButton.setEnabled(false);
        }

        public void changeButtonsState()
        {
            pickButton.setEnabled(false);
            startButton.setEnabled(true);
        }

        public void disableGroup()
        {
            rules.setEnabled(false);
            qualifier.setEnabled(false);
            qualifierDetails.setEnabled(false);
            gladiator.setEnabled(false);
            pickButton.setEnabled(false);
            startButton.setEnabled(false);
        }

    }


    private void populateControlGroups()
    {
        JLabel rules = null;
        JTextField qualifier = null;
        JTextField qualifierDetails = null;
        JTextField gladiator = null;

        JButton pickButton = null;
        JButton startButton = null;

        int iterator = 0;

        for(Component component_inner: MainPanel.getComponents())
        {
            if(component_inner instanceof JPanel)
            {
                for(Component text_components : ((JPanel) component_inner).getComponents())
                {
                    if(text_components instanceof  JTextField)
                    {
                        if(text_components.getName().contains("Qualifier"))
                        {
                            qualifier = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("QDetails"))
                        {
                            qualifierDetails = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Gladiator"))
                        {
                            gladiator = (JTextField)text_components;
                        }
                    }

                    if(text_components instanceof JLabel) {
                        if(text_components.getName().contains("Rules"))
                        {
                            rules = (JLabel)text_components;
                        }
                    }

                    if(text_components instanceof  JPanel)
                    {
                        for(Component btn_components : ((JPanel) text_components).getComponents())
                        {
                            if(btn_components instanceof JButton)
                            {
                                if(btn_components.getName().contains("PickGlad"))
                                {
                                    pickButton = (JButton) btn_components;
                                }

                                else if(btn_components.getName().contains("Start"))
                                {
                                    startButton = (JButton) btn_components;
                                }
                            }
                        }
                    }
                }




                controlGroups.add(
                        new ARENA_FORM.ArenaProxyControlGroup(
                                rules,
                                qualifier,
                                qualifierDetails,
                                gladiator,
                                pickButton,
                                startButton,
                                arenas.get(iterator++)));
            }
        }
    }




    public void showValues()
    {
        for(ArenaProxyControlGroup arenaProxyControlGroup: controlGroups)
        {
            arenaProxyControlGroup.setValues();
        }
    }

    public void setUpGroupButtons(int indexOfGroup)
    {
        controlGroups.get(indexOfGroup).changeButtonsState();
    }

    public void disableGroup(int indexOfGroup)
    {
        controlGroups.get(indexOfGroup).disableGroup();
    }

    public void runGladiatorPicker(int indexOfArena)
    {
        GLADIATOR_PICKER form = new GLADIATOR_PICKER(playerContext, arenas.get(indexOfArena) , indexOfArena, this);
        JFrame frame = new JFrame("GLADIATOR PICKER");

        frame.setContentPane(form.getMainFrame());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        form.addCloseListener();

        setEnableForm(false);
    }

    public void runGladiatorFight(int indexOfArena)
    {
        DUEL_TEST form = new DUEL_TEST(playerContext, arenas.get(indexOfArena).convertToGladiatorArena(), indexOfArena,this);
        JFrame frame = new JFrame("ARENA FIGHT");

        frame.setContentPane(form.getMainFrame());
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        form.addCloseListener();

        setEnableForm(false);
    }

    public ARENA_FORM(PlayerContext playerContext, MAIN_FORM parent) {

        this.playerContext = playerContext;
        this.parent = parent;

        arenas = new ArrayList<ArenaProxy>();
        randomArenProxyGenerator = new RandomArenProxyGenerator();
        controlGroups = new ArrayList<ArenaProxyControlGroup>();

        for(int i = 0; i < 6; i++)
        {
            arenas.add(randomArenProxyGenerator.generateRandomArenaProxy());
        }
        populateControlGroups();
        showValues();
        //addCloseListener();


        Arena_1_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorPicker(0);

            }
        });

        Arena_2_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorPicker(1);
            }
        });

        Arena_3_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorPicker(2);
            }
        });

        Arena_4_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorPicker(3);
            }
        });

        Arena_5_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorPicker(4);
            }
        });

        Arena_6_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorPicker(5);
            }
        });


        Arena_1_Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorFight(0);
            }
        });
        Arena_2_Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorFight(1);
            }
        });
        Arena_3_Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorFight(2);
            }
        });
        Arena_4_Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorFight(3);
            }
        });
        Arena_5_Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorFight(4);
            }
        });
        Arena_6_Start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runGladiatorFight(5);
            }
        });
    }


}
