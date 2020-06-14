package Model.FORMS;

import Model.Gladiator.Gladiator;
import Model.Gymnasion.Gymnasion;
import Model.PlayerContext.PlayerContext;
import Model.Skills.Skill;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class GYMNASION_FORM {
    private JPanel MainPanel;
    private JButton LearnSkill;
    private JScrollPane TablePane;
    private JTextField GoldText;
    private JTable SkillTable;



    ListSelectionModel listSelectionModel;
    Gymnasion gymnasion;

    String[][] data;
    String[] columns;
    DefaultTableModel defaultTableModel;
    int selectedSkill;

    PlayerContext playerContext;
    TEAM_FORM parent;
    Gladiator gladiator;


    public void  addCloseListener() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(getMainFrame(), "Do you want to leave Gymnasion?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {

                    return;
                }

                //gladiator.removeNullSkills();
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

    public JPanel getMainFrame()
    {
        return this.MainPanel;
    }

    private void initializeColumns()
    {
        //name, who can learn, description, stat multiper, cost :: 5

        columns = new String[5];
        columns[0] = "Skill name";
        columns[1] = "Who can learn";
        columns[2] = "Description";
        columns[3] = "Stat multiper";
        columns[4] = "Cost";


    }


    private void initializeData()
    {
        String[] row;
        defaultTableModel = new DefaultTableModel(0, 5);
        defaultTableModel.setColumnIdentifiers(columns);
        SkillTable = new JTable(defaultTableModel);

        JTableHeader jTableHeader = SkillTable.getTableHeader();

        for(Skill skill: gymnasion.getSkillsToLearn())
        {
            defaultTableModel.insertRow(defaultTableModel.getRowCount(),
                    new Object[]
                    {
                    skill.getName(),
                    skill.getWhoCanLearn(),
                    skill.getDescription(),
                    skill.getStatisticMultiper().name(),
                    Integer.toString( skill.getCost())
            });


        }

    }

    public GYMNASION_FORM(PlayerContext playerContext, Gladiator gladiator, TEAM_FORM parent)
    {
        gymnasion = new Gymnasion();
        this.playerContext = playerContext;
        this.gladiator = gladiator;
        this.parent = parent;

        initializeColumns();
        initializeData();
        //addCloseListener();

        GoldText.setText(Integer.toString(playerContext.getGold()));

        TablePane.setColumnHeaderView(SkillTable.getTableHeader());
        TablePane.setViewportView(SkillTable);

        listSelectionModel = SkillTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        LearnSkill.setEnabled(true);
                        selectedSkill = SkillTable.getSelectedRow();

                    }
                }
        );


        LearnSkill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(gymnasion.getSkillsToLearn().get(selectedSkill).getCost() <= playerContext.getGold()) {
                    if(gymnasion.trainSkill(gladiator, selectedSkill))
                    {
                        playerContext.payGold(gymnasion.getSkillsToLearn().get(selectedSkill).getCost());
                        JOptionPane.showMessageDialog(MainPanel, "Skill learned.");
                        GoldText.setText(Integer.toString(playerContext.getGold()));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(MainPanel, "This gladiator cant learn this skill.");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(MainPanel, "No enough money.");
                }
            }
        });
    }



}
