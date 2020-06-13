package Model.FORMS;

import Model.PlayerContext.PlayerContext;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MAIN_FORM {
    private JButton TeamButton;
    private JButton ArenaGroundButton;
    private JButton TavernButton;
    private JTextField ACTUAL_GOLDTextField;
    private JButton ExitButton;
    private JPanel MainPanel;

    PlayerContext playerContext;

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
    public MAIN_FORM() {

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
    }
}
