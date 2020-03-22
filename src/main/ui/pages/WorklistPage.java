package ui.pages;

import model.Course;
import ui.CourseChooser;

import javax.swing.*;
import java.awt.*;

// represents the second tab on the graphical user interface where users can edit and see their worklist
public class WorklistPage extends JPanel {
    CourseChooser courseChooser;
    JTextArea personalWorklist;
    WorkListOptions workListOptions;

    //constructs the worklist tab with buttons, fields, and the appropriate layout
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

    //EFFECTS: clears the text from personalWorklist JTextArea
    public void removeText() {
        personalWorklist.setText("");
    }

    public JTextArea getPersonalWorklist() {
        return personalWorklist;
    }
}
