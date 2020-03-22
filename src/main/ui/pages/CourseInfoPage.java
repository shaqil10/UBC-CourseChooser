package ui.pages;

import model.Course;
import ui.CourseChooser;

import javax.swing.*;
import java.awt.*;

// represents the 3rd tab of the GUI where users can search for more detailed information on a specific course
public class CourseInfoPage extends JPanel {
    CourseChooser courseChooser;
    JTextArea displayedInfo;
    CourseInfoOptions courseInfoOptions;

    //constructs the Course Info tab
    public CourseInfoPage(CourseChooser courseChooser) {
        this.courseChooser = courseChooser;
        setLayout(new BorderLayout());

        displayedInfo = new JTextArea();
        displayedInfo.setEditable(false);
        displayedInfo.setFont(displayedInfo.getFont().deriveFont(16f));
        add(displayedInfo,BorderLayout.CENTER);
        courseInfoOptions = new CourseInfoOptions(courseChooser,this);
        add(courseInfoOptions, BorderLayout.NORTH);
    }

    //EFFECTS: clears the displayedInfo JTextArea
    public void removeText() {
        displayedInfo.setText("");
    }

    public JTextArea getDisplayedInfo() {
        return displayedInfo;
    }
}
