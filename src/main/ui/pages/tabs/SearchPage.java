package ui.pages.tabs;

import ui.CourseChooser;
import ui.pages.subpanels.SearchCriteria;
import ui.pages.subpanels.SubPanel;

import java.awt.*;

//represents the first tab of the GUI where users can search for courses matching the given criteria
public class SearchPage extends MainPanel {
    SubPanel searchCriteria;

    //constructs the Search tab of the application
    public SearchPage(CourseChooser courseChooser) {
        super(courseChooser, "Course Info");
        searchCriteria = new SearchCriteria(courseChooser,this);
        infoDisplay.setFont(infoDisplay.getFont().deriveFont(18f));
        add(searchCriteria, BorderLayout.WEST);
    }
}