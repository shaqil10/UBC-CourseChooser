package ui.pages;

import model.Course;
import ui.CourseChooser;

import javax.swing.*;
import java.awt.*;

// represents the second tab on the graphical user interface where users can edit and see their worklist
public class WorklistPage extends MainPanel {
    SubPanel workListOptions;

    //constructs the worklist tab with buttons, fields, and the appropriate layout
    public WorklistPage(CourseChooser courseChooser) {
        super(courseChooser);
        courseChooser.displayWorklist(infoDisplay);
        workListOptions = new WorkListOptions(courseChooser,this);
        add(workListOptions, BorderLayout.SOUTH);
    }
}
