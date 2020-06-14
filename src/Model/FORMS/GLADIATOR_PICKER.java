package Model.FORMS;

import Model.Arenas.ArenaController.ArenaProxy;
import Model.Gladiator.Gladiator;
import Model.PlayerContext.PlayerContext;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class GLADIATOR_PICKER {

    private JTable GladiatorTable;



    ListSelectionModel listSelectionModel;

    String[] columns;
    DefaultTableModel defaultTableModel;
    int selectedGladiator;

    PlayerContext playerContext;
    ARENA_FORM parent;
    ArenaProxy arenaProxy;
    int indexOfArena = 0;
    boolean gladiatorPicked =false;
    private JPanel MainPanel;
    private JButton ChooseGladiator;
    private JScrollPane TeamPane;


    public void  addCloseListener() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                if(!gladiatorPicked) {
                    if (JOptionPane.showConfirmDialog(getMainFrame(), "Do you want to leave without picking Gladiator?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {

                        return;
                    }
                }

                if(gladiatorPicked) {
                    parent.setUpGroupButtons(indexOfArena);
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

    public JPanel getMainFrame()
    {
        return this.MainPanel;
    }

    private void initializeColumns()
    {

        columns = new String[5];
        columns[0] = "Name";
        columns[1] = "Level";
        columns[2] = "Race";
        columns[3] = "Class";
        columns[4] = "Rarity";


    }


    private void initializeData()
    {
        String[] row;
        defaultTableModel = new DefaultTableModel(0, 5);
        defaultTableModel.setColumnIdentifiers(columns);
        GladiatorTable = new JTable(defaultTableModel);

        JTableHeader jTableHeader = GladiatorTable.getTableHeader();

        for(Gladiator gladiator: playerContext.getGladiatorsTeam())
        {

            defaultTableModel.insertRow(defaultTableModel.getRowCount(),
                    new Object[]
                            {
                                    gladiator.getGladiatorName(),
                                    Integer.toString( gladiator.getLevel()),
                                    gladiator.getRace(),
                                    gladiator.getGladiatorClass(),
                                    gladiator.getRarity()
                            });


        }

    }

    public GLADIATOR_PICKER(PlayerContext playerContext, ArenaProxy arenaProxy, int indexOfArena, ARENA_FORM parent)
    {
        this.playerContext = playerContext;
        this.arenaProxy = arenaProxy;
        this.parent = parent;
        this.indexOfArena = indexOfArena;
        initializeColumns();
        initializeData();



        TeamPane.setColumnHeaderView(GladiatorTable.getTableHeader());
        TeamPane.setViewportView(GladiatorTable);

        listSelectionModel = GladiatorTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(
                new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {

                        selectedGladiator = GladiatorTable.getSelectedRow();
                        if(!arenaProxy.getArenaQualifierClass().validateGladiator(playerContext.getGladiator(selectedGladiator)))
                        {
                            ChooseGladiator.setEnabled(false);
                            ChooseGladiator.setText("Requirments not met for this gladiator");
                        }
                        else
                        {
                            ChooseGladiator.setEnabled(true);
                            ChooseGladiator.setText("Choose Gladiator");
                        }

                    }
                }
        );


        ChooseGladiator.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame =(JFrame) SwingUtilities.getWindowAncestor(MainPanel);
                gladiatorPicked = true;
                arenaProxy.putGladiator(playerContext.getGladiator(selectedGladiator));
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
    }



}
