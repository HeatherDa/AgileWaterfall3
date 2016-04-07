package com.Heather;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AgileWaterfall extends JFrame{
    private JTextField projectNameTextField;
    private JPanel rootPanel;
    private JCheckBox numberOfProgrammersExceedsCheckBox;
    private JCheckBox programmersAreExperiencedCheckBox;
    private JCheckBox projectRequiresDetailedPreceiseCheckBox;
    private JCheckBox programmersWorkInMultipleCheckBox;
    private JCheckBox projectRequiresHighStandardsCheckBox;
    private JCheckBox projectRequiresEarlyWorkingCheckBox;
    private JButton recommendationButton;
    private JLabel resultsLabel;
    private JButton quitButton;

    boolean programmers;
    boolean experience;
    boolean models;
    boolean location;
    boolean schedule;
    boolean quality;

    AgileWaterfall(){
        super("Agile or Waterfall Decidor");
        setContentPane(rootPanel);
        setPreferredSize(new Dimension(600,400));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        recommendationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pname=projectNameTextField.getText();
                programmers=numberOfProgrammersExceedsCheckBox.isSelected();
                schedule=projectRequiresDetailedPreceiseCheckBox.isSelected();
                experience=programmersAreExperiencedCheckBox.isSelected();
                location=programmersWorkInMultipleCheckBox.isSelected();
                quality=projectRequiresHighStandardsCheckBox.isSelected();
                models=projectRequiresEarlyWorkingCheckBox.isSelected();
                resultsLabel.setText(recommendation(pname, programmers, schedule, experience, location, quality, models));
            }
        });
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private String recommendation(String pname, Boolean programers, Boolean schedule, Boolean experience, Boolean location, Boolean quality, Boolean models){
        String result;//if true, use waterfall, if false, use Agile
        if (schedule|| (quality && programers && !models)) {//if the project requires a strict schedule it should use waterfall.  If it doesn't require a strict schedule, but does need other aspects of waterfall and doesn't need aspects of Agile, then waterfall should still be used
            result=pname+" should use the Waterfall method.";
        }else if(models && !programers && experience && !location){//no schedule, no assured quality, less than ten programmers, but they are very experienced and work together in one location.  Use Agile.
            result=pname+" should use the Agile method.";
        }else{
            result=pname+" could use either the Waterfall or the Agile method.";
        }
        return result;
    }
}