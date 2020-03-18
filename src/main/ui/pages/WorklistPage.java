package ui.pages;

import model.Course;
import ui.CourseChooser;

import javax.swing.*;
import java.awt.*;

public class WorklistPage extends JPanel {
    CourseChooser courseChooser;
    JTextArea personalWorklist;
    WorkListOptions workListOptions;

    public WorklistPage(CourseChooser courseChooser) {
        this.courseChooser = courseChooser;
        setLayout(new BorderLayout());

        personalWorklist = new JTextArea();
        personalWorklist.setEditable(false);
        personalWorklist.setFont(personalWorklist.getFont().deriveFont(16f));
        courseChooser.displayWorklist(personalWorklist);
        add(personalWorklist, BorderLayout.CENTER);

        workListOptions = new WorkListOptions(courseChooser,this);
        add(workListOptions, BorderLayout.SOUTH);
    }

    public void removeText() {
        personalWorklist.setText("");
    }

    public JTextArea getPersonalWorklist() {
        return personalWorklist;
    }
}
