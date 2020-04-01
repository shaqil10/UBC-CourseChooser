package ui.pages;

import ui.CourseChooser;
import java.awt.*;

// represents the 3rd tab of the GUI where users can search for more detailed information on a specific course
public class CourseInfoPage extends MainPanel {
    SubPanel courseInfoOptions;

    //constructs the Course Info tab
    public CourseInfoPage(CourseChooser courseChooser) {
        super(courseChooser);
        courseInfoOptions = new CourseInfoOptions(courseChooser, this);
        add(courseInfoOptions, BorderLayout.NORTH);
    }
}
