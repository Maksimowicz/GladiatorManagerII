package Model.FORMS;

import Model.Arenas.ArenaModel.GladiatorArena;
import Model.Arenas.Team.TeamEnum;
import Model.PlayerContext.PlayerContext;
import Model.Skills.Skill;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class DUEL_TEST {
    private JPanel MainPanel;
    private JLabel RedHP;
    private JLabel BlueHP;
    private JButton RedSkill1;
    private JButton BlueSkill1;
    private JLabel BlueLabel;
    private JLabel RedLabel;
    private JLabel TurnCounter;
    private JButton BlueSkill2;
    private JButton RedSkill2;
    private JButton BlueSkill3;
    private JButton RedSkill3;
    private JButton BlueSkill4;
    private JButton RedSkill4;
    private JLabel LastRedUsed;


    boolean isStarted;

    ArrayList<JButton> redButtons;
    ArrayList<JButton> blueButtons;

    GladiatorArena gladiatorArena;
    ARENA_FORM parent;
    PlayerContext playerContext;
    int indexOfArena = 0;

    public void setButtonsLabels()
    {
        int iterator = 0;
        for(Skill skill : gladiatorArena.getTeamBlueArray().get(0).getSkillList())
        {
            blueButtons.get(iterator).setText(skill.getName());
            blueButtons.get(iterator++).setEnabled(true);
        }

        iterator = 0;
        for(Skill skill : gladiatorArena.getTeamRedArray().get(0).getSkillList())
        {
            redButtons.get(iterator).setText(skill.getName());
            redButtons.get(iterator++).setEnabled(false);
        }
    }



    public void enableBlueSkills(boolean enable)
    {
        for(int i = 0; i < gladiatorArena.getTeamBlueArray().get(0).getSkillList().size(); i++)
        {
            blueButtons.get(i).setEnabled(enable);
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
                if (JOptionPane.showConfirmDialog(getMainFrame(), "Do you want to leave Duel?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {

                    return;
                }

                //playerContext.removeNullsFromTeam();
                parent.disableGroup(indexOfArena);
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

    public void enableButtons()
    {
        switch (gladiatorArena.getActiveTeam())
        {
            case Red:
                gladiatorArena.getLastEffects().add(gladiatorArena.getTeamRedArray().get(0).useRandomSkill(gladiatorArena.getTeamBlueArray().get(0)));
                LastRedUsed.setText(Integer.toString(gladiatorArena.getLastEffects().get(0).getDamage()));
                enableBlueSkills(false);
                roundConclusion();
                break;
            case Blue:
                enableBlueSkills(true);

                break;
        }
    }



    public void startFight()
    {



        redButtons = new ArrayList<JButton>();
        blueButtons = new ArrayList<JButton>();


        gladiatorArena.getTeamBlueArray().get(0).prepareForFight();
        gladiatorArena.getTeamRedArray().get(0).prepareForFight();


        isStarted = true;


        RedHP.setText(Integer.toString(gladiatorArena.getTeamRedArray().get(0).getHealthPoints()));
        BlueHP.setText(Integer.toString(gladiatorArena.getTeamBlueArray().get(0).getHealthPoints()));

        RedLabel.setText(gladiatorArena.getTeamRedArray().get(0).getGladiatorName() + " " + gladiatorArena.getTeamRedArray().get(0).getRace() + " " + gladiatorArena.getTeamRedArray().get(0).getGladiatorClass());
        BlueLabel.setText(gladiatorArena.getTeamBlueArray().get(0).getGladiatorName() + " " + gladiatorArena.getTeamBlueArray().get(0).getRace() + " " + gladiatorArena.getTeamBlueArray().get(0).getGladiatorClass());

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
        enableButtons();

    }




    public void refreshValues()
    {
        RedHP.setText(Integer.toString(gladiatorArena.getTeamRedArray().get(0).getHealthPoints()));
        BlueHP.setText(Integer.toString(gladiatorArena.getTeamBlueArray().get(0).getHealthPoints()));
        TurnCounter.setText(Integer.toString(gladiatorArena.getRoundCounter()));
    }

    //Simple version with damage only
    public void roundConclusion()
    {
        if(gladiatorArena.nextRound())
        {

            if(gladiatorArena.winnerTeam == TeamEnum.Blue) {
                int expGained = gladiatorArena.getTeamRedArray().get(0).generateExp();
                int goldGained = gladiatorArena.getTeamRedArray().get(0).getGladiatorCost();
                JOptionPane.showMessageDialog(MainPanel, "VICTORY!" );
                JOptionPane.showMessageDialog(MainPanel,"EXP GAINED: " + Integer.toString(expGained) + " GOLD GAINED: " + Integer.toString(goldGained));
                playerContext.receiveGold(goldGained);
            }
            else
            {
                JOptionPane.showMessageDialog(MainPanel, "DEFEAT!");
            }

            enableBlueSkills(false);
            refreshValues();
            return;
        }
        enableButtons();
        refreshValues();
    }

    public DUEL_TEST(PlayerContext playerContext, GladiatorArena gladiatorArena, int indexOfArena, ARENA_FORM parent) {

        this.gladiatorArena = gladiatorArena;
        this.parent = parent;
        this.playerContext = playerContext;
        this.indexOfArena = indexOfArena;
        startFight();
        enableButtons();


        BlueSkill1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(gladiatorArena.getTeamBlueArray().get(0).useSkill(0, gladiatorArena.getTeamRedArray().get(0)));
                enableBlueSkills(false);
                roundConclusion();

            }
        });

        BlueSkill2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(gladiatorArena.getTeamBlueArray().get(0).useSkill(1, gladiatorArena.getTeamRedArray().get(0)));
                enableBlueSkills(false);
                roundConclusion();
            }
        });
        BlueSkill3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(gladiatorArena.getTeamBlueArray().get(0).useSkill(2, gladiatorArena.getTeamRedArray().get(0)));
                enableBlueSkills(false);
                roundConclusion();
            }
        });
        BlueSkill4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(gladiatorArena.getTeamBlueArray().get(0).useSkill(3, gladiatorArena.getTeamRedArray().get(0)));
                enableBlueSkills(false);
                roundConclusion();
            }
        });

        RedSkill1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(gladiatorArena.getTeamRedArray().get(0).useSkill(0, gladiatorArena.getTeamBlueArray().get(0)));

                roundConclusion();
            }
        });

        RedSkill2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(gladiatorArena.getTeamRedArray().get(0).useSkill(1, gladiatorArena.getTeamBlueArray().get(0)));

                roundConclusion();
            }
        });

        RedSkill3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(gladiatorArena.getTeamRedArray().get(0).useSkill(2, gladiatorArena.getTeamBlueArray().get(0)));

                roundConclusion();
            }
        });

        RedSkill4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gladiatorArena.getLastEffects().add(gladiatorArena.getTeamRedArray().get(0).useSkill(3, gladiatorArena.getTeamBlueArray().get(0)));

                roundConclusion();
            }
        });
    }


}
