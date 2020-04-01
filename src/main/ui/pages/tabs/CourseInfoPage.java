package ui.pages.tabs;

import ui.CourseChooser;
import ui.pages.subpanels.CourseInfoOptions;
import ui.pages.subpanels.SubPanel;

import java.awt.*;

// represents the 3rd tab of the GUI where users can search for more detailed information on a specific course
public class CourseInfoPage extends MainPanel {
    SubPanel courseInfoOptions;

    //constructs the Course Info tab
    public CourseInfoPage(CourseChooser courseChooser) {
        super(courseChooser, "Course Info");
        courseInfoOptions = new CourseInfoOptions(courseChooser, this);
        add(courseInfoOptions, BorderLayout.NORTH);
    }
}
