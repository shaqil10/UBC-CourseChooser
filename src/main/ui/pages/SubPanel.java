package ui.pages;

import ui.CourseChooser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

// represents a separate panel within one of the tabs (MainPanels)
public abstract class SubPanel extends JPanel {
    CourseChooser courseChooser;
    MainPanel mainPanel;

    // constructs a subpanel's general layout, dimensions, and borders within the mainPanel
    public SubPanel(CourseChooser courseChooser, MainPanel mainPanel, int dimensions, String borderTitle) {
        this.courseChooser = courseChooser;
        this.mainPanel = mainPanel;
        Dimension dim = getPreferredSize();
        dim.width = dimensions;
        dim.height = dimensions;
        setPreferredSize(dim);
        initBorders(borderTitle);
        setLayout(new GridBagLayout());
    }

    //EFFECTS: constructs the borders in the panel
    protected void initBorders(String borderTitle) {
        Border titleBorder = BorderFactory.createTitledBorder(borderTitle);
        Border innerBorder = BorderFactory.createLineBorder(Color.BLACK,1,true);
        setBorder(BorderFactory.createCompoundBorder(innerBorder,titleBorder));
    }

    //EFFECTS: constructs a JButton with buttonDescription as the text
    protected JButton initButton(String buttonDescription) {
        JButton newButton = new JButton(buttonDescription);
        return newButton;
    }

    //EFFECTS: constructs a JLabel with label as the description
    protected JLabel initLabel(String label) {
        JLabel newLabel = new JLabel(label);
        return newLabel;
    }

    //EFFECTS: initializes the entire grid layout of the panel
    protected abstract void setUpGrid(GridBagConstraints gc);
}
