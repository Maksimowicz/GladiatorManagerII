package Model.FORMS;

import Model.Gladiator.Gladiator;
import Model.PlayerContext.PlayerContext;
import Model.Skills.Skill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class SKILLS_FORM {
    private JPanel MainPanel;
    private JPanel Skill_1;
    private JTextField Skill_1_SMultiper;
    private JTextField Skill_1_Damage;
    private JTextField Skill_1_Heal;
    private JTextField Skill_1_SBoost;
    private JTextField Skill_1_SBDesc;
    private JTextField Skill_1_IsSelfDmg;
    private JPanel Skill_2;
    private JPanel Skill_3;
    private JPanel Skill_4;
    private JLabel Skill_1_Name;
    private JLabel Skill_2_Name;
    private JLabel Skill_3_Name;
    private JLabel Skill_4_Name;
    private JTextField Skill_2_SMultiper;
    private JTextField Skill_3_SMultiper;
    private JTextField Skill_4_SMultiper;
    private JTextField Skill_2_Damage;
    private JTextField Skill_3_Damage;
    private JTextField Skill_4_Damage;
    private JTextField Skill_2_Heal;
    private JTextField Skill_3_Heal;
    private JTextField Skill_4_Heal;
    private JTextField Skill_2_SBoost;
    private JTextField Skill_3_SBoost;
    private JTextField Skill_4_SBoost;
    private JTextField Skill_2_SBDesc;
    private JTextField Skill_3_SBDesc;
    private JTextField Skill_4_SBDesc;
    private JTextField Skill_2_IsSelfDmg;
    private JTextField Skill_3_IsSelfDmg;
    private JTextField Skill_4_IsSelfDmg;
    private JButton Skill_1_Forget;
    private JButton Skill_2_Forget;
    private JButton Skill_3_Forget;
    private JButton Skill_4_Forget;

    ArrayList<SkillControlGroup> skillControlGroup;
    TEAM_FORM parent;
    PlayerContext playerContext;
    Gladiator gladiator;

    public void  addCloseListener() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(MainPanel);
        topFrame.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(getMainFrame(), "Do you want to leave Skills?", "Confirm exit.", JOptionPane.OK_OPTION, 0, new ImageIcon("")) != 0) {

                    return;
                }

                gladiator.removeNullSkills();
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

    class SkillControlGroup
    {
        JLabel skillName;
        JTextField statMultipler;
        JTextField skillDamage;
        JTextField skillHeal;
        JTextField statBoost;
        JTextField statBoosted;
        JTextField isSelfDmg;

        JButton forget;

        Skill skill;
        public SkillControlGroup(JLabel name,
                                 JTextField statMultipler,
                                 JTextField skillDamage,
                                 JTextField skillHeal,
                                 JTextField statBoost,
                                 JTextField statBoosted,
                                 JTextField isSelfDamage,
                                 JButton forget,
                                 Skill skill)
        {
            this.skillName = name;
            this.statMultipler = statMultipler;
            this.skillDamage = skillDamage;
            this.skillHeal = skillHeal;
            this.statBoost = statBoost;
            this.statBoosted = statBoosted;
            this.forget = forget;
            this.skill = skill;
            this.isSelfDmg = isSelfDamage;

        }

        public void removeSkill()
        {
            this.skill = null;
        }

        public void fillFields()
        {
            if(skill != null)
            {
                this.skillName.setText(skill.getName());
                this.statMultipler.setText(skill.getStatisticMultiper().name());
                this.skillDamage.setText(Integer.toString( skill.getSkillDamage()));
                this.skillHeal.setText(Integer.toString( skill.getSkillHeal()));
                this.statBoost.setText(Integer.toString(skill.getStatisticBoost()));
                this.statBoosted.setText(skill.getBoostedStatistics().name());
                this.isSelfDmg.setText(Boolean.toString(skill.getIsSelfDamage()));

            }
            else
            {
                this.skillName.setText("");
                this.statMultipler.setText("");
                this.skillDamage.setText("");
                this.skillHeal.setText("");
                this.statBoost.setText("");
                this.statBoosted.setText("");
                this.isSelfDmg.setText("");
                this.forget.setEnabled(false);
            }
        }
    }

    public void getControlGroups()
    {
        int iterator = 0;

        JTextField statMultiper, skillDamage, skillHeal, statBoost, statBoosted, isSelfDmg;
        JButton forget;
        JLabel skillName;

        statMultiper = null;
        skillDamage = null;
        skillHeal = null;
        statBoost = null;
        statBoosted = null;
        isSelfDmg = null;
        forget = null;
        skillName = null;



        for(Component component_inner: MainPanel.getComponents())
        {
            if(component_inner instanceof JPanel)
            {
                for(Component text_components : ((JPanel) component_inner).getComponents())
                {
                    if(text_components instanceof  JTextField)
                    {

                        if(text_components.getName().contains("SMultiper"))
                        {
                            statMultiper = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Damage"))
                        {
                            skillDamage = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("Heal"))
                        {
                            skillHeal = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("SBoost"))
                        {
                            statBoost = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("SBDesc"))
                        {
                            statBoosted = (JTextField)text_components;
                        }
                        else if(text_components.getName().contains("IsSelfDmg"))
                        {
                            isSelfDmg = (JTextField)text_components;
                        }

                    }

                    if(text_components instanceof JLabel) {
                        if(text_components.getName() != null && text_components.getName().contains("Name"))
                        {
                            skillName = (JLabel)text_components;
                        }
                    }

                    if(text_components instanceof JButton)
                    {
                        if(text_components.getName() != null && text_components.getName().contains("Forget"))
                        {
                            forget = (JButton)text_components;
                        }


                    }
                }

                Skill skillHelper = null;
                if(iterator < gladiator.getSkillList().size()) {
                    skillHelper = gladiator.getSkillList().get(iterator++);
                }
                skillControlGroup.add(
                        new SkillControlGroup(
                                skillName,
                                statMultiper,
                                skillDamage,
                                skillHeal,
                                statBoost,
                                statBoosted,
                                isSelfDmg,
                                forget,
                                skillHelper
                        ));
            }
        }
    }


    public void fillFields()
    {
        for(SkillControlGroup scg : skillControlGroup)
        {
            scg.fillFields();
        }
    }

    public void forgetSkill(int indexOfSkill)
    {
        gladiator.getSkillList().remove(indexOfSkill);
        skillControlGroup.get(indexOfSkill).removeSkill();
        fillFields();
    }

    public SKILLS_FORM(PlayerContext playerContext, Gladiator gladiator, TEAM_FORM parent)
    {
        this.playerContext = playerContext;
        this.parent = parent;
        this.gladiator = gladiator;
        skillControlGroup = new ArrayList<SkillControlGroup>();
        getControlGroups();
        fillFields();

        Skill_1_Forget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgetSkill(0);
            }
        });

        Skill_2_Forget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgetSkill(1);
            }
        });

        Skill_3_Forget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgetSkill(2);
            }
        });

        Skill_4_Forget.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forgetSkill(3);
            }
        });
    }
}
