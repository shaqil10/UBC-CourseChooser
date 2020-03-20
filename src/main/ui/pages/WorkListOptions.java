package ui.pages;

import com.sun.org.apache.regexp.internal.RE;
import model.Course;
import ui.CourseChooser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//represents the panel on the WorklistPage where users can either remove or add courses to their worklist or save
public class WorkListOptions extends JPanel {
    CourseChooser courseChooser;
    WorklistPage worklistPage;
    JButton saveButton;
    JButton addButton;
    JButton removeButton;
    JLabel addRemoveLabel;
    JTextField addRemoveField;

    public WorkListOptions(CourseChooser courseChooser, WorklistPage worklistPage) {
        this.courseChooser = courseChooser;
        this.worklistPage = worklistPage;
        addRemoveLabel = new JLabel("Enter the course ID of a course you would like to add or remove.");
        addRemoveField = new JTextField("Ex. UBC-2018W-MATH-100-101",25);

        initButtons(courseChooser, worklistPage);

        Dimension dim = getPreferredSize();
        dim.height = 250;
        setPreferredSize(dim);
        Border titleBorder = BorderFactory.createTitledBorder("Worklist Options");
        Border innerBorder = BorderFactory.createLineBorder(Color.BLACK,1,true);
        setBorder(BorderFactory.createCompoundBorder(innerBorder,titleBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        setUpGrid(gc);

    }

    private void setUpGrid(GridBagConstraints gc) {
        //FIRST COLUMN//
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0,0,0,5);

        add(addRemoveLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        add(addRemoveField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        add(addButton,gc);

        gc.gridx = 0;
        gc.gridy = 3;
        gc.anchor = GridBagConstraints.CENTER;
        add(removeButton, gc);


        //SAVE COLUMN//

        gc.gridx = 1;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        add(saveButton, gc);
    }

    private void initButtons(CourseChooser courseChooser, WorklistPage worklistPage) {
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                worklistPage.removeText();
                String courseAdded = addRemoveField.getText();
                courseChooser.addCourse(courseAdded, worklistPage);
            }
        });

        removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                worklistPage.removeText();
                String courseToRemove = addRemoveField.getText();
                courseChooser.removeCourse(courseToRemove, worklistPage);
            }
        });

        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                courseChooser.saveWorklist();
            }
        });
    }
}
