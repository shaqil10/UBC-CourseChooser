package ui.pages.tabs;

import ui.CourseChooser;
import ui.pages.subpanels.SubPanel;
import ui.pages.subpanels.WorkListOptions;

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
