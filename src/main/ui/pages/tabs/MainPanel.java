package ui.pages.tabs;

import ui.CourseChooser;
import javax.swing.*;
import java.awt.*;

// represents a single tab of the application
public class MainPanel extends JPanel {
    CourseChooser courseChooser;
    JTextArea infoDisplay;

    // constructs a panel which is one of the tabs in the toolbar with a default layout and text area
    public MainPanel(CourseChooser courseChooser) {
        this.courseChooser = courseChooser;
        setLayout(new BorderLayout());
        infoDisplay = new JTextArea();
        infoDisplay.setEditable(false);
        infoDisplay.setFont(infoDisplay.getFont().deriveFont(16f));
        add(infoDisplay,BorderLayout.CENTER);
    }

    //EFFECTS: clears the searchResult JTextArea
    public void removeText() {
        infoDisplay.setText("");
    }

    public CourseChooser getCourseChooser() {
        return courseChooser;
    }

    public JTextArea getInfoDisplay() {
        return infoDisplay;
    }
}
