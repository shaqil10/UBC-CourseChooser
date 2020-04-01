package ui.pages.subpanels;

import ui.CourseChooser;
import ui.pages.tabs.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//represents the panel on the SearchPage where a user can input their search criteria
public class SearchCriteria extends SubPanel {
    private JLabel subjectLabel;
    private JLabel yearLabel;
    private JLabel averageLabel;
    private JButton searchButton;
    JComboBox<String> subjectField;
    JComboBox<String> yearField;
    JTextField averageField;

    //constructs the panel containing the text fields and buttons that a user can input the information to search
    // for courses
    public SearchCriteria(CourseChooser courseChooser, MainPanel searchPage) {
        super(courseChooser, searchPage, 300, "Fill in the following search criteria:");

        initComponents();
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        setUpGrid(gc);
        placeSearchButton(gc);
    }

    //EFFECTS: initializes all components in the panel
    private void initComponents() {
        initLabels();
        initComboBoxes();
        averageField = new JTextField("Enter a number between 0-100",16);
        initSearchButton();
    }

    //EFFECTS: initializes the two drop-down menus for the subject and year level
    private void initComboBoxes() {
        String [] subjects = {"CPSC", "MATH", "CHEM", "COMM"};
        subjectField = new JComboBox<>(subjects);
        String [] years = {"1","2","3","4"};
        yearField = new JComboBox<>(years);
    }

    //EFFECTS: initializes the subject, year, and average labels
    private void initLabels() {
        subjectLabel = initLabel("Subject:");
        yearLabel = initLabel("Year:");
        averageLabel = initLabel("Desired Average:");
    }

    //EFFECTS: initializes the entire layout of the panel and places all components
    @Override
    protected void setUpGrid(GridBagConstraints gc) {
        setUpGridRow1(gc);
        setUpGridRow2(gc);
        setUpGridRow3(gc);
    }

    //EFFECTS: places the "Search" button on the panel
    private void placeSearchButton(GridBagConstraints gc) {
        //BUTTON ROW//
        gc.weightx = 1;
        gc.weighty = 2.0;

        gc.gridx = 1;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(searchButton,gc);
    }

    //EFFECTS: initializes labels and text fields in the third row of the search criteria panel
    private void setUpGridRow3(GridBagConstraints gc) {
        //THIRD ROW//
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_END;
        add(averageLabel,gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        add(averageField,gc);
    }

    //EFFECTS: initializes labels and text fields in the second row of the search criteria panel
    private void setUpGridRow2(GridBagConstraints gc) {
        //SECOND ROW//
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_END;
        add(yearLabel,gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        add(yearField,gc);
    }

    //EFFECTS: initializes labels and text fields in the first row of the search criteria panel
    private void setUpGridRow1(GridBagConstraints gc) {
        //FIRST ROW//
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);

        add(subjectLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(subjectField,gc);
    }

    //EFFECTS: initializes the Search button and its functionality
    private void initSearchButton() {
        searchButton = initButton("Search!");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeText();
                String subject = (String) subjectField.getSelectedItem();
                String year = (String) yearField.getSelectedItem();
                String average = averageField.getText();

                courseChooser.produceSearchResults(subject,year,average, mainPanel);
            }
        });
    }
}
