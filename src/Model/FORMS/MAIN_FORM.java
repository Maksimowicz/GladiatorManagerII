package Model.FORMS;

import Model.PlayerContext.PlayerContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MAIN_FORM {
    private JButton TeamButton;
    private JButton ArenaGroundButton;
    private JButton TavernButton;
    private JTextField ACTUAL_GOLDTextField;
    private JButton ExitButton;
    private JPanel MainPanel;

    PlayerContext playerContext;
    START_FORM parent;

    public JPanel getMainFrame()
    {
        return this.MainPanel;
    }

    public void  addCloseListener() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(getMainFrame(), "Do you want to end session?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {

                    return;
                }

                //playerContext.removeNullsFromTeam();

                parent.setVisible(true);
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

    public JPanel getMainPanel()
    {
        return this.MainPanel;
    }

    public void setEnableForm(boolean enabled)
    {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.setEnabled(enabled);
        setGold();

    }

    private void setGold()
    {
        ACTUAL_GOLDTextField.setText(Integer.toString(playerContext.getGold()));
    }


    public MAIN_FORM geThis()
    {
        return this;
    }
    public MAIN_FORM(START_FORM parent) {
        this.parent = parent;
        playerContext = new PlayerContext();
        setGold();

        TavernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TAVERN_FORM form = new TAVERN_FORM(playerContext, geThis() );
                JFrame frame = new JFrame("TAVERN");


                frame.setContentPane(form.getMainFrame());
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                form.addCloseListener();


                setEnableForm(false);



            }

        });

        TeamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TEAM_FORM form = new TEAM_FORM(playerContext, geThis() );
                JFrame frame = new JFrame("TEAM");


                frame.setContentPane(form.getMainFrame());
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                form.addCloseListener();

                setEnableForm(false);
            }
        });
        ArenaGroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ARENA_FORM form = new ARENA_FORM(playerContext, geThis() );
                JFrame frame = new JFrame("ARENA GROUNDS");


                frame.setContentPane(form.getMainFrame());
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                form.addCloseListener();

                setEnableForm(false);
            }
        });
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
                topFrame.dispatchEvent(new WindowEvent(topFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }
}
