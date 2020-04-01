package ui.pages;

import ui.CourseChooser;
import ui.pages.tabs.CourseInfoPage;
import ui.pages.tabs.MainPanel;
import ui.pages.tabs.SearchPage;
import ui.pages.tabs.WorklistPage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

// represents the toolbar containing the 3 tabs and the user can navigate between the pages using the TabbedPane
public class Toolbar extends JTabbedPane {
    CourseChooser courseChooser;
    List<MainPanel> tabList;

    //constructs the layout of the GUI into the three tabs: search, worklist, and course info
    public Toolbar(CourseChooser courseChooser) {
        this.courseChooser = courseChooser;
        tabList = new ArrayList<>();
        initTabs();
    }

    public void initTabs() {
        MainPanel searchPage = new SearchPage(courseChooser);
        MainPanel worklistPage = new WorklistPage(courseChooser);
        MainPanel courseInfoPage = new CourseInfoPage(courseChooser);
        tabList.add(searchPage);
        tabList.add(worklistPage);
        tabList.add(courseInfoPage);
        for (MainPanel tab: tabList) {
            addTab(tab.getPanelName(), tab);
        }
    }
}
