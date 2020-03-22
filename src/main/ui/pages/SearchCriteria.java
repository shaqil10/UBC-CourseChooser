package ui.pages;

import ui.CourseChooser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.BorderFactory.createTitledBorder;

//represents the panel on the SearchPage where a user can input their search criteria
public class SearchCriteria extends JPanel {
    private SearchPage searchPage;
    private JLabel subjectLabel;
    private JLabel yearLabel;
    private JLabel averageLabel;
    private JButton searchButton;
    JComboBox<String> subjectField;
    JComboBox<String> yearField;
    JTextField averageField;
    CourseChooser courseChooser;

    //constructs the panel containing the text fields and buttons that a user can input the information to search
    // for courses
    public SearchCriteria(CourseChooser courseChooser, SearchPage searchPage) {
        this.courseChooser = courseChooser;
        this.searchPage = searchPage;
        Dimension dim = getPreferredSize();
        dim.width = 300;
        dim.height = 300;
        setPreferredSize(dim);
        subjectLabel = new JLabel("Subject:");
        yearLabel = new JLabel("Year:");
        averageLabel = new JLabel("Desired Average:");

        String [] subjects = {"CPSC", "MATH", "CHEM", "COMM"};
        subjectField = new JComboBox<>(subjects);
        String [] years = {"1","2","3","4"};
        yearField = new JComboBox<>(years);
        averageField = new JTextField("Enter a number between 0-100",16);

        initButton(courseChooser, searchPage);

        initBorders();

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        setUpGridRow1(gc);
        setUpGridRow2(gc);
        setUpGridRow3(gc);
        placeButton(gc);
    }

    //EFFECTS: constructs the borders in the search criteria panel
    private void initBorders() {
        Border titleBorder = BorderFactory.createTitledBorder("Fill in the following search criteria:");
        Border innerBorder = BorderFactory.createLineBorder(Color.BLACK,1,true);
        setBorder(BorderFactory.createCompoundBorder(innerBorder,titleBorder));
    }

    //EFFECTS: places the "Search" button on a specific position in the grid layout of the search criteria panel
    private void placeButton(GridBagConstraints gc) {
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
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);

        add(subjectLabel, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        add(subjectField,gc);
    }

    //EFFECTS: initializes the Search button and its functionality
    private void initButton(CourseChooser courseChooser, SearchPage searchPage) {
        searchButton = new JButton("Search!");
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchPage.removeText();
                String subject = (String) subjectField.getSelectedItem();
                String year = (String) yearField.getSelectedItem();
                String average = averageField.getText();

                courseChooser.produceSearchResults(subject,year,average,searchPage);
            }
        });
    }
}
