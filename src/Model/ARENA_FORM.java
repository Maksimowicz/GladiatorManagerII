package Model;

import Model.Arenas.ArenaController.ArenaProxy;
import Model.Arenas.ArenaController.RandomArenProxyGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private JButton Arena_6_Glad;
    private JPanel Arena_1_ButtonsP;
    private JPanel Arena_2_ButtonsP;
    private JPanel Arena_3_ButtonsP;
    private JPanel Arena_4_ButtonsP;
    private JPanel Arena_5_ButtonsP;
    private JPanel Arena_6_ButtonsP;

    ArrayList<ArenaProxy> arenas;
    RandomArenProxyGenerator randomArenProxyGenerator;
    ArrayList<ArenaProxyControlGroup> controlGroups;

    class ArenaProxyControlGroup{
        JLabel rules;
        JTextField qualifier;
        JTextField qualifierDetails;
        JTextField gladiator;

        ArenaProxy arenaProxy;

        public ArenaProxyControlGroup(JLabel rules, JTextField qualifier, JTextField qualifierDetails, JTextField gladiator, ArenaProxy arenaProxy)
        {
            this.rules = rules;
            this.qualifier = qualifier;
            this.qualifierDetails = qualifierDetails;
            this.gladiator = gladiator;
            this.arenaProxy = arenaProxy;
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
        }

    }


    private void populateControlGroups()
    {
        JLabel rules = null;
        JTextField qualifier = null;
        JTextField qualifierDetails = null;
        JTextField gladiator = null;

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
                }




                controlGroups.add(
                        new ARENA_FORM.ArenaProxyControlGroup(
                                rules,
                                qualifier,
                                qualifierDetails,
                                gladiator,
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


    public ARENA_FORM() {

        arenas = new ArrayList<ArenaProxy>();
        randomArenProxyGenerator = new RandomArenProxyGenerator();
        controlGroups = new ArrayList<ArenaProxyControlGroup>();

        for(int i = 0; i < 6; i++)
        {
            arenas.add(randomArenProxyGenerator.generateRandomArenaProxy());
        }
        populateControlGroups();
        showValues();


        Arena_1_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        Arena_2_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Arena_3_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Arena_4_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Arena_5_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        Arena_6_PickGlad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    public static void main(String[] args) {

        ARENA_FORM form = new ARENA_FORM();
        JFrame frame = new JFrame("TAWERNA");
        frame.setContentPane(form.MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        int a = 0;
    }
}
