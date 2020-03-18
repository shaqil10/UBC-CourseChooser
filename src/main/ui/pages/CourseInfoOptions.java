package ui.pages;

import ui.CourseChooser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseInfoOptions extends JPanel {
    CourseChooser courseChooser;
    CourseInfoPage courseInfoPage;
    JLabel courseIdLabel;
    JComboBox<String> options;
    JTextField courseIdField;
    JButton infoButton;
    JLabel optionsLabel;

    public CourseInfoOptions(CourseChooser courseChooser, CourseInfoPage courseInfoPage) {
        this.courseChooser = courseChooser;
        this.courseInfoPage = courseInfoPage;
        courseIdLabel = new JLabel("Course ID:");
        String [] choices = {"General Info", "Grade Distribution", "Statistics"};
        optionsLabel = new JLabel("Choose one of the following:");
        options = new JComboBox<>(choices);
        courseIdField = new JTextField("Ex. UBC-2018W-MATH-100-101",25);
        infoButton = new JButton("Show me!");
        infoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                courseInfoPage.removeText();
                String courseID = courseIdField.getText();
                String option = (String) options.getSelectedItem();

                courseChooser.returnCourseResults(courseID, option, courseInfoPage);
            }
        });


        Dimension dim = getPreferredSize();
        dim.height = 200;
        setPreferredSize(dim);
        Border titleBorder = BorderFactory.createTitledBorder("Enter a specific course ID and choose an option:");
        Border innerBorder = BorderFactory.createLineBorder(Color.BLACK,1,true);
        setBorder(BorderFactory.createCompoundBorder(innerBorder,titleBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //FIRST ROW//
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.fill = GridBagConstraints.NONE;
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
