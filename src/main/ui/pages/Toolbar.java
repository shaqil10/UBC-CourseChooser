package ui.pages;

import javax.swing.*;
import java.awt.*;

public class Toolbar extends JTabbedPane {
    SearchPage searchPage;
    WorklistPage worklistPage;
    CourseInfoPage courseInfoPage;

    public Toolbar() {
    }

    public void addComponentToPane(Container pane) {
        JTabbedPane toolbar = new JTabbedPane();
        searchPage = new SearchPage();
        worklistPage = new WorklistPage();
        courseInfoPage = new CourseInfoPage();

        toolbar.addTab("Search", searchPage);
        toolbar.addTab("Worklist", worklistPage);
        toolbar.addTab("Course Info", courseInfoPage);

        pane.add(toolbar, BorderLayout.CENTER);
    }
}
