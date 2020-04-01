package ui.pages.subpanels;

import ui.CourseChooser;
import ui.pages.tabs.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//represents the panel on the WorklistPage where users can either remove or add courses to their worklist or save
public class WorkListOptions extends SubPanel {
    JButton saveButton;
    JButton addButton;
    JButton removeButton;
    JLabel addRemoveLabel;
    JTextField addRemoveField;

    //constructs the worklist options panel with buttons, labels, and fields
    public WorkListOptions(CourseChooser courseChooser, MainPanel worklistPage) {
        super(courseChooser, worklistPage, 250, "Worklist Options");

        initComponents();
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.NONE;
        setUpGrid(gc);
    }

    //EFFECTS: initializes all components in the panel
    private void initComponents() {
        addRemoveLabel = initLabel("Enter the course ID of a course you would like to add or remove.");
        addRemoveField = new JTextField("Ex. UBC-2018W-MATH-100-101", 25);
        initButtons();
    }

    //EFFECTS: initializes the layout of the worklist options panel
    @Override
    protected void setUpGrid(GridBagConstraints gc) {
        //FIRST COLUMN//
        gc.weightx = 1;
        gc.weighty = 1;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.CENTER;
        gc.insets = new Insets(0, 0, 0, 5);

        add(addRemoveLabel, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.CENTER;
        add(addRemoveField, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.CENTER;
        add(addButton, gc);

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

    //EFFECTS: initializes the save, add, and remove buttons
    private void initButtons() {
        initAddButton();
        initRemoveButton();
        initSaveButton();
    }

    //EFFECTS: constructs the Save button and its function
    private void initSaveButton() {
        saveButton = initButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GifPanel popUpPanel = new GifPanel();
                JOptionPane.showMessageDialog(mainPanel, popUpPanel,"You smart.",1);
                courseChooser.saveWorklist();
            }
        });
    }

    //EFFECTS: constructs the Remove button and its function
    private void initRemoveButton() {
        removeButton = createAddRemoveButton("Remove");
    }

    //EFFECTS: constructs the Add button and its function
    private void initAddButton() {
        addButton = createAddRemoveButton("Add");
    }

    //EFFECTS: abstract method for adding an add or remove button
    private JButton createAddRemoveButton(String addremove) {
        JButton thisButton = new JButton(addremove);
        thisButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                initializeButtonEvent(mainPanel, addremove);
            }
        });
        return thisButton;
    }

    //EFFECTS: edits the worklist according to which button was pressed
    private void initializeButtonEvent(MainPanel worklistPage, String editOption) {
        worklistPage.removeText();
        String courseEdited = addRemoveField.getText();
        courseChooser.editWorkList(courseEdited, worklistPage, editOption);
    }

}
