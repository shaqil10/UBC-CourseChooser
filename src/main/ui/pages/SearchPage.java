package ui.pages;

import model.*;
import ui.CourseChooser;

import javax.swing.*;
import java.awt.*;

import static java.lang.Integer.parseInt;

//represents the first tab of the GUI where users can search for courses matching the given criteria
public class SearchPage extends JPanel {
    private SearchCriteria searchCriteria;
    private JTextArea searchResult;
    private CourseChooser courseChooser;

    //constructs the Search tab of the application
    public SearchPage(CourseChooser courseChooser) {
        this.courseChooser = courseChooser;
        setLayout(new BorderLayout());

        searchResult = new JTextArea();
        searchResult.setEditable(false);
        searchResult.setFont(searchResult.getFont().deriveFont(18f));
        add(searchResult,BorderLayout.CENTER);
        searchCriteria = new SearchCriteria(courseChooser,this);
        add(searchCriteria, BorderLayout.WEST);
    }

    //EFFECTS: clears the searchResult JTextArea
    public void removeText() {
        searchResult.setText("");
    }

    public JTextArea getSearchResult() {
        return searchResult;
    }

}