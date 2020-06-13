package Model.FORMS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class START_FORM {
    private JButton NewGameButton;
    private JButton ExitButton;
    private JPanel MainPanel;


    public START_FORM() {
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        NewGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MAIN_FORM form = new MAIN_FORM();
                JFrame frame = new JFrame("GLADIATOR MANAGER");
                frame.setContentPane(form.getMainPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);



            }
        });
    }

    public static void main(String[] args) {

        START_FORM form = new START_FORM();
        JFrame frame = new JFrame("GLADIATOR MANAGER");
        frame.setContentPane(form.MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }

}
