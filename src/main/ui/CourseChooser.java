package ui;

import model.*;
import persistence.Reader;
import persistence.Writer;
import ui.pages.*;
import ui.pages.tabs.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static java.lang.Integer.parseInt;

//Runs the application

public class CourseChooser extends JFrame {
    private CourseList myList;
    private CourseList courseList;
    private Toolbar toolbar;
    private static final String WORKLIST_FILE = "./data/worklist.txt";
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    //EFFECTS: Run the Course Chooser application
    public CourseChooser() {
        super("UBC Course Chooser");
        courseList = populateCourseList();
        loadWorklist();
        initializeGraphics();
    }

    //EFFECTS: initializes all of the pages and the window itself for the GUI
    private void initializeGraphics() {
        this.toolbar = new Toolbar(this);

        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        add(toolbar);
        //Source: StackOverflow https://stackoverflow.com/questions/9093448/how-to-capture-a-jframes-close-button-click-event
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(toolbar,
                        "Hold up playa, would you like to save your worklist?", "Save?",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                    saveWorklist();
                }
                System.exit(0);
            }
        });
        setVisible(true);
    }


    //EFFECTS: takes in the criteria from the SearchCriteria panel and searches the
    // database for courses that match the criteria and displays them on the SearchPage
    // if the average provided wasn't a valid number, a NumberFormatException should be caught here
    public void produceSearchResults(String subject, String year, String average, MainPanel searchPage) {
        JTextArea searchResult = searchPage.getInfoDisplay();
        try {
            CourseList searchResults = courseList.searcher(subject, year, parseInt(average));
            if (searchResults.getSize() == 0) {
                searchResult.append("My condolences, nothing matched your search criteria.");
            } else {
                searchResult.append("Check out deez beautiful results I found:\n\n");
                for (Course i : searchResults.getListCourse()) {
                    searchResult.append((i.getId() + "\n\n"));
                }
            }
        } catch (NumberFormatException e) {
            searchResult.append("That wasn't a valid average, homeslice. Try again.");
        }
    }

    //EFFECTS: takes in the courseID input and choice of information from the WorklistOptions panel
    // and displays the corresponding course information on the WorklistPage
    // if the course wasn't found, an error message is displayed
    public void returnCourseResults(String courseID, String option, MainPanel courseInfoPage) {
        JTextArea infoDisplay = courseInfoPage.getInfoDisplay();
        boolean found = false;
        for (Course i : courseList.getListCourse()) {
            if (courseID.equals(i.getId())) {
                infoDisplay.append("The " + option.toLowerCase() + " for " + courseID + " are as follows:\n\n");
                i.toString(infoDisplay, option);
                found = true;
            }
        }
        if (!found) {
            infoDisplay.append("Sorry, I couldn't find that course!");
        }
    }

    // MODIFIES: this
    // EFFECTS: loads the worklist from WORKLIST_FILE, if that file exists;
    // otherwise initializes a new empty worklist
    private void loadWorklist() {
        try {
            myList = Reader.readWorklist(new File(WORKLIST_FILE), courseList);
        } catch (IOException | IndexOutOfBoundsException e) {
            myList = new CourseList();
        }
    }

    // EFFECTS: saves state of personalized worklist to WORKLIST_FILE
    public void saveWorklist() {
        try {
            Writer writer = new Writer(new File(WORKLIST_FILE));
            writer.write(myList);
            writer.close();
            System.out.println("Your worklist was saved to file " + WORKLIST_FILE + " !");
        } catch (FileNotFoundException e) {
            System.out.println("Oof, I couldn't save your worklist to " + WORKLIST_FILE + " :(");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    //EFFECTS: when the "Add" or "Remove" button is clicked on the WorklistPage with a valid courseID, the course is
    // either removed or added from the worklist depending on the button chosen
    // If no courseID exists, an error message is displayed
    public void editWorkList(String courseToEdit, MainPanel worklistPage, String editOption) {
        JTextArea worklistDisplay = worklistPage.getInfoDisplay();
        boolean edited = false;

        if (editOption == "Remove") {
            for (Course i : myList.getListCourse()) {
                if (courseToEdit.equals(i.getId())) {
                    edited = implementEdits(worklistDisplay, i, editOption);
                    break;
                }
            }
        } else if (editOption == "Add") {
            for (Course i : courseList.getListCourse()) {
                if (courseToEdit.equals(i.getId())) {
                    edited = implementEdits(worklistDisplay, i, editOption);
                    break;
                }
            }
        }
        if (!edited) {
            worklistDisplay.append("Sorry, I couldn't find that course!\n\n");
        }
        displayWorklist(worklistDisplay);
    }


    //EFFECTS: Either adds or removes the course to the worklist depending on the editOption and appends the appropriate
    // text to the display window
    private boolean implementEdits(JTextArea worklistDisplay, Course i, String editOption) {
        if (editOption == "Add") {
            myList.addCourse(i);
            worklistDisplay.append("I added " + i.getId() + " to your worklist!\n\n");
        } else {
            myList.removeCourse(i);
            worklistDisplay.append("I removed " + i.getId() + " to your worklist!\n\n");
        }
        return true;
    }


    //EFFECTS: displays the user's personalized worklist on the WorklistPage
    public void displayWorklist(JTextArea worklistDisplay) {
        worklistDisplay.append("Your personalized worklist:\n\n");

        if (myList.getSize() == 0) {
            worklistDisplay.append("Your worklist is empty! Add some bad boys in there.");
        }

        for (Course course : myList.getListCourse()) {
            worklistDisplay.append(course.getId() + "\n\n");
        }
    }

    //EFFECTS: builds the course database
    public static CourseList populateCourseList() {

        //MATH:*
        Course c1 = getC1();

        Course c2 = getC2();
        Course c3 = getC3();
        Course c4 = getC4();
        Course c5 = getC5();

        //CPSC:
        Course c6 = getC6();

        Course c7 = getC7();
        Course c8 = getC8();
        Course c9 = getC9();
        Course c10 = getC10();


        //COMM:
        Course c11 = getC11();
        Course c12 = getC12();
        Course c13 = getC13();
        Course c14 = getC14();
        Course c15 = getC15();

        //CHEM:
        Course c16 = getC16();
        Course c17 = getC17();
        Course c18 = getC18();
        Course c19 = getC19();

        CourseList courseDatabase = new CourseList();
        courseDatabase.addMultipleCourses(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11,
                c12, c13, c14, c15, c16, c17, c18, c19);
        return courseDatabase;
    }


    public Course getC20() {
        Grades c20grades = new Grades(null,1, 0, 0, 0, 0,
                1, 1, 0, 0, 1, 3, 3,
                6, 15, 9, 20);
        Stats c20stats = new Stats(null,83.59, 13.46, 99, 9, 58, 1, 0);
        Course c20 = new Course("UBC-2018W-MUSC-105-001", "2018W", "MUSC", "105",
                "001", "AURAL SKILLS I", new Instructor("Paslawski, Gordon", "3.1/5"),
                59, c20stats, c20grades);
        c20grades.setCourse(c20);
        c20stats.setCourse(c20);
        return c20;
    }

    public static Course getC19() {
        Grades c19grades = new Grades(null,0, 0, 0, 0, 0,
                0, 0, 1, 0, 0, 0, 1,
                0, 3, 7, 7);
        Stats c19stats = new Stats(null,85.68, 8.78, 95, 56, 19, 0, 0);
        Course c19 = new Course("UBC-2017W-CHEM-405-110", "2017W", "CHEM", "405",
                "110", "BIOPHYSICAL CHEM", new Instructor("Straus, Suzana", "2.6/5"),
                19, c19stats, c19grades);
        c19grades.setCourse(c19);
        c19stats.setCourse(c19);
        return c19;
    }

    public static Course getC18() {
        Grades c18grades = new Grades(null,0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 1, 1,
                3, 2, 5, 3);
        Stats c18stats = new Stats(null,83.87, 7.61, 96, 71, 15, 0, 0);
        Course c18 = new Course("UBC-2017W-CHEM-402-210", "2017W", "CHEM", "402",
                "210", "DIFRACTION MTHDS", new Instructor("Patrick, Brian", "N/A"),
                15, c18stats, c18grades);
        c18grades.setCourse(c18);
        c18stats.setCourse(c18);
        return c18;
    }

    public static Course getC17() {
        Grades c17grades = new Grades(null,0, 0, 0, 0, 0,
                0, 0, 1, 2, 1, 0, 1,
                2, 4, 3, 4);
        Stats c17stats = new Stats(null,79.67, 12.32, 98, 58, 18, 0, 0);
        Course c17 = new Course("UBC-2018W-CHEM-418-209", "2018W", "CHEM", "418",
                "209", "ORGANOMETALLIC", new Instructor("Fryzuk, Michael", "3.53/5"),
                18, c17stats, c17grades);
        c17grades.setCourse(c17);
        c17stats.setCourse(c17);
        return c17;
    }

    public static Course getC16() {
        Grades c16grades = new Grades(null,0, 0, 0, 0, 0,
                0, 1, 1, 0, 1, 0, 1,
                1, 2, 3, 3);
        Stats c16stats = new Stats(null,79.0, 12.07, 96, 54, 13, 0, 0);
        Course c16 = new Course("UBC-2018W-CHEM-461-233", "2018W", "CHEM", "461",
                "233", "SYNTH CHEM BIOL", new Instructor("Perrin, David", "2.6/5"),
                14, c16stats, c16grades);
        c16grades.setCourse(c16);
        c16stats.setCourse(c16);
        return c16;
    }

    public static Course getC15() {
        Grades c15grades = new Grades(null,0, 0, 0, 2, 9,
                11, 7, 9, 13, 10, 10, 7,
                12, 15, 15, 9);
        Stats c15stats = new Stats(null,70.34,14.74, 99, 32,107, 11,3);
        Course c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, c15stats, c15grades);
        c15grades.setCourse(c15);
        c15stats.setCourse(c15);
        return c15;
    }

    public static Course getC14() {
        Grades c14grades = new Grades(null,0, 0, 0, 0, 0,
                0, 0, 0, 0, 0, 0, 4,
                13, 23, 0, 0);
        Stats c14stats = new Stats(null,79.38, 2.74, 84, 73,40,0,0);
        Course c14 = new Course("UBC-2018W-COMM-395-106", "2018W", "COMM", "395",
                "106", "BUSN COMMUNICATION", new Instructor("Brealey, Chad ", "3.3/5"),
                40, c14stats, c14grades);
        c14grades.setCourse(c14);
        c14stats.setCourse(c14);
        return c14;
    }

    public static Course getC13() {
        Grades c13grades = new Grades(null,0, 0, 0, 0, 0,
                0, 0, 1, 0, 2, 1,
                0, 3, 7, 4, 21);
        Stats c13stats = new Stats(null,86.77, 9.4, 98, 58,39, 0,0);
        Course c13 = new Course("UBC-2017W-COMM-337-201", "2017W", "COMM", "337",
                "201", "BUS PROG ANLYTCS", new Instructor("Lee, Gene ", "N/A"),
                39, c13stats, c13grades);
        c13grades.setCourse(c13);
        c13stats.setCourse(c13);
        return c13;
    }

    public static Course getC12() {
        Grades c12grades = new Grades(null,0, 0, 0, 0, 0,
                0, 0, 0, 1, 1, 3,
                3, 16, 26, 32, 35);
        Stats c12stats = new Stats(null,84.03, 6.65,95, 61,117,0,1);
        Course c12 = new Course("UBC-2017W-COMM-335-101", "2017W", "COMM", "335",
                "101", "INFO SYS MNGT", new Instructor("Cheung, Yau Man ", "3.7/5"),
                122, c12stats, c12grades);
        c12grades.setCourse(c12);
        c12stats.setCourse(c12);
        return c12;
    }

    public static Course getC11() {
        Grades c11grades = new Grades(null,0, 0, 0, 0, 0,
                0, 0, 0, 1, 0, 0, 5,
                6, 7, 1, 0);
        Stats c11stats = new Stats(null,76.45,4.93, 85, 63,20, 0,0);
        Course c11 = new Course("UBC-2018W-COMM-329-203", "2018W", "COMM", "329",
                "203", "ORGANIZTL BHVR", new Instructor("Svedic, Zorana ", "2.3/5"),
                20, c11stats, c11grades);
        c11grades.setCourse(c11);
        c11stats.setCourse(c11);
        return c11;
    }

    public static Course getC10() {
        Grades c10grades = new Grades(null,0, 0, 1, 1, 12,
                14, 3, 3, 7, 7, 8,
                10, 9, 27, 16, 17);
        Stats c10stats = new Stats(null,74.39,15.3,99,29, 107,14,4);
        Course c10 = new Course("UBC-2017W-CPSC-210-203", "2017W", "CPSC", "210",
                "203", "SFTWR CONSTRUCTN", new Instructor("Carter, Paul Martin", "4.4/5"),
                126, c10stats, c10grades);
        c10grades.setCourse(c10);
        c10stats.setCourse(c10);
        return c10;
    }

    public static Course getC9() {
        Grades c9grades = new Grades(null,0, 0, 1, 1, 3,
                5, 4, 8, 9, 15, 15,
                7, 16, 16, 5, 8);
        Stats c9stats = new Stats(null,71.23, 12.59,97,26,103, 5,0);
        Course c9 = new Course("UBC-2018W-CPSC-261-201", "2018W", "CPSC", "261",
                "201", "BASICS COMP SYST", new Instructor("Schroeder, Jonatan", "4.0/5"),
                109, c9stats, c9grades);
        c9grades.setCourse(c9);
        c9stats.setCourse(c9);
        return c9;
    }

    public static Course getC8() {
        Grades c8grades = new Grades(null,0, 0, 0, 1, 4,
                5, 3, 3, 3, 4, 8, 9,
                9, 20, 18, 36);
        Stats c8stats = new Stats(null,80.84, 14,100,32,113, 5,3);
        Course c8 = new Course("UBC-2017W-CPSC-221-102", "2017W", "CPSC", "221",
                "102", "BASIC ALG&DATA", new Instructor("Heeren, Cinda", "4.0/5"),
                123, c8stats, c8grades);
        c8grades.setCourse(c8);
        c8stats.setCourse(c8);
        return c8;
    }

    public static Course getC7() {
        Grades c7grades = new Grades(null,0, 1, 0, 0, 9,
                10, 2, 4, 7, 12, 10,
                15, 21, 22, 19, 19);
        Stats c7stats = new Stats(null,75.37, 13.77,99,19,131,10,4);
        Course c7 = new Course("UBC-2018W-CPSC-213-203", "2018W", "CPSC", "213",
                "203", "INTRO COMP SYS", new Instructor("Feeley, Michael", "3.7/5"),
                149, c7stats, c7grades);
        c7grades.setCourse(c7);
        c7stats.setCourse(c7);
        return c7;
    }

    public static Course getC6() {
        Grades c6grades = new Grades(null,0, 0, 1, 5, 31,
                37, 2, 7, 5, 10, 14,
                17, 18, 25, 39, 74);
        Stats c6stats = new Stats(null,76.72,17.45,100,27,211,37,18);
        Course c6 = new Course("UBC-2018W-CPSC-110-101", "2018W", "CPSC", "110",
                "101", "COMPTN PROGRMNG", new Instructor("Kiczales, Gregor", "3.7/5"),
                271, c6stats, c6grades);
        c6grades.setCourse(c6);
        c6stats.setCourse(c6);
        return c6;
    }

    public static Course getC5() {
        Grades c5grades = new Grades(null,0, 0, 1, 0, 8,
                9, 10, 7, 6, 8, 13,
                17, 8, 11, 3, 8);
        Stats c5stats = new Stats(null,68.52,14.03,97,25,91,9,2);
        Course c5 = new Course("UBC-2017W-MATH-200-103", "2017W", "MATH", "200",
                "103", "CALCULUS 3", new Instructor("Dahlberg, Samantha", "3.3/5"),
                102, c5stats, c5grades);
        c5grades.setCourse(c5);
        c5stats.setCourse(c5);
        return c5;
    }

    public static Course getC4() {
        Grades c4grades = new Grades(null,0, 0, 0, 9, 5,
                14, 14, 20, 14, 27, 17,
                20, 25, 24, 15, 10);
        Stats c4stats = new Stats(null,68.96, 14.12,98,30,186,14,7);
        Course c4 = new Course("UBC-2017W-MATH-105-208", "2017W", "MATH", "105",
                "208", "INT CALC AP C&SS", new Instructor("Yeager, Elyse", "4.3/5"),
                208, c4stats, c4grades);
        c4grades.setCourse(c4);
        c4stats.setCourse(c4);
        return c4;
    }

    public static Course getC3() {
        Grades c3grades = new Grades(null,0, 0, 0, 0, 0,
                0, 0, 2, 4, 1, 2,
                1, 2, 5, 8, 4);
        Stats c3stats = new Stats(null,78.76, 12.54, 100,57,29,0,0);
        Course c3 = new Course("UBC-2018W-MATH-121-201", "2018W", "MATH", "121",
                "201", "INTEGRAL CALCULUS ", new Instructor("Perkins, Edwin", "N/A"),
                29, c3stats, c3grades);
        c3grades.setCourse(c3);
        c3stats.setCourse(c3);
        return c3;
    }

    public static Course getC2() {
        Grades c2grades = new Grades(null,0, 0, 4, 5, 9,
                18, 20, 26, 29, 31, 20,
                18, 10, 21, 9, 15);
        Stats c2stats = new Stats(null,66.44,14.71,100,20,199,18,1);
        Course c2 = new Course("UBC-2017W-MATH-103-201", "2017W", "MATH", "103",
                "201", "INT CALC AP LF S", new Instructor("Hauert, Christoph", "3.1/5"),
                218, c2stats, c2grades);
        c2grades.setCourse(c2);
        c2stats.setCourse(c2);
        return c2;
    }

    public static Course getC1() {
        Grades c1grades = new Grades(null,0, 1, 0, 3, 2,
                6, 10, 12, 18, 14, 18,
                20, 17, 17, 4, 0);
        Stats c1stats = new Stats(null,67.79, 11.72,87,12,130,6,5);
        Course c1 = new Course("UBC-2018W-MATH-100-101", "2018W", "MATH", "100",
                "101", "DF CALC AP PH SC", new Instructor("Walls, Patrick", "4.4/5"),
                145, c1stats, c1grades);
        c1grades.setCourse(c1);
        c1stats.setCourse(c1);
        return c1;
    }

    public static void main(String[] args) {
        new CourseChooser();
    }
}




