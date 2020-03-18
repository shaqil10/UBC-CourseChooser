package ui.pages;

import ui.CourseChooser;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JTabbedPane {
    CourseChooser courseChooser;
    SearchPage searchPage;
    WorklistPage worklistPage;
    CourseInfoPage courseInfoPage;

    public Toolbar(CourseChooser courseChooser) {
        this.courseChooser = courseChooser;
        searchPage = new SearchPage(courseChooser);
        worklistPage = new WorklistPage(courseChooser);
        courseInfoPage = new CourseInfoPage(courseChooser);
    }

    public void addComponentToPane(Container pane) {
        JTabbedPane toolbar = new JTabbedPane();

        toolbar.addTab("Search", searchPage);
        toolbar.addTab("Worklist", worklistPage);
        toolbar.addTab("Course Info", courseInfoPage);

        pane.add(toolbar, BorderLayout.CENTER);
    }
}
