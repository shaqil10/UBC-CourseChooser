package ui.pages;

import ui.CourseChooser;

import javax.swing.*;
import java.awt.*;

// represents the toolbar containing the 3 tabs and the user can navigate between the pages using the TabbedPane
public class Toolbar extends JTabbedPane {
    CourseChooser courseChooser;
    SearchPage searchPage;
    WorklistPage worklistPage;
    CourseInfoPage courseInfoPage;

    //constructs the layout of the GUI into the three tabs: search, worklist, and course info
    public Toolbar(CourseChooser courseChooser) {
        this.courseChooser = courseChooser;
        searchPage = new SearchPage(courseChooser);
        worklistPage = new WorklistPage(courseChooser);
        courseInfoPage = new CourseInfoPage(courseChooser);
    }

    //EFFECTS: initalizes the tabs and adds it to the main frame
    //Source: https://examples.javacodegeeks.com/desktop-java/swing/jtabbedpane/create-jtabbedpane-example/
    public void addComponentToPane(Container pane) {
        JTabbedPane toolbar = new JTabbedPane();

        toolbar.addTab("Search", searchPage);
        toolbar.addTab("Worklist", worklistPage);
        toolbar.addTab("Course Info", courseInfoPage);

        pane.add(toolbar, BorderLayout.CENTER);
    }
}
