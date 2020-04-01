package ui.pages.subpanels;

import ui.CourseChooser;
import ui.pages.tabs.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// represents the panel on the CourseInfoPage where users can search for specific information/stats on a course
public class CourseInfoOptions extends SubPanel {
    JLabel courseIdLabel;
    JComboBox<String> options;
    JTextField courseIdField;
    JButton infoButton;
    JLabel optionsLabel;

    //constructs the course info options panel where the user can input a courseID and select an option for
    //grades, stats, or general info
    public CourseInfoOptions(CourseChooser courseChooser, MainPanel courseInfoPage) {
        super(courseChooser, courseInfoPage,200,
                "Enter a specific course ID and choose an option:");

        initComponents();
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        setUpGrid(gc);
    }

    //EFFECTS: initializes all of the components in the panel
    private void initComponents() {
        courseIdLabel = initLabel("Course ID:");
        optionsLabel = initLabel("Choose one of the following:");
        String [] choices = {"General Info", "Grade Distribution", "Statistics"};
        options = new JComboBox<>(choices);
        courseIdField = new JTextField("Ex. UBC-2018W-MATH-100-101",25);
        initShowMeButton();
    }

    //EFFECTS: initializes the "Show me!" button and its functionality
    private void initShowMeButton() {
        infoButton = initButton("Show me!");
        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeText();
                String courseID = courseIdField.getText();
                String option = (String) options.getSelectedItem();
                courseChooser.returnCourseResults(courseID, option, mainPanel);
            }
        });
    }

    //EFFECTS: sets up the grid layout on the course information options panel
    @Override
    protected void setUpGrid(GridBagConstraints gc) {
        //FIRST ROW//
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);

        add(courseIdLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(courseIdField, gc);

        //SECOND ROW//
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(optionsLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(options, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(infoButton, gc);
    }
}
