package ui;

import model.*;
import persistence.Reader;
import persistence.Writer;
import ui.pages.CourseInfoPage;
import ui.pages.SearchPage;
import ui.pages.Toolbar;
import ui.pages.WorklistPage;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

//Runs the application

public class CourseChooser extends JFrame {
    private CourseList myList;
    private CourseList courseList;
    private boolean runApp;
    private Scanner input;
    private Toolbar toolbar;
    private static final String WORKLIST_FILE = "./data/worklist.txt";
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 700;

    //EFFECTS: Run the Course Chooser application
    public CourseChooser() {
        super("UBC Course Chooser");
        //initializeFields();
        courseList = populateCourseList();
        loadWorklist();
        initializeGraphics();
    }

    private void initializeGraphics() {
        this.toolbar = new Toolbar(this);

        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        toolbar.addComponentToPane(getContentPane());
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


    public void produceSearchResults(String subject, String year, String average, SearchPage searchPage) {
        JTextArea searchResult = searchPage.getSearchResult();
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

    public void returnCourseResults(String courseID, String option, CourseInfoPage courseInfoPage) {
        JTextArea infoDisplay = courseInfoPage.getDisplayedInfo();
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

    //    private void initializeFields() {
//        courseList = populateCourseList();
//        loadWorklist();
//
//
//        runApp = true;
//        String command = null;
//        input = new Scanner(System.in);
//
//        while (runApp) {
//            displayStartMenu();
//            command = input.next();
//            command = command.toLowerCase();
//
//            runApp = courseOptions(myList, courseList, runApp, command);
//        }
//        System.out.println("\nLater, skater.");
//    }
//
//    private boolean courseOptions(CourseList myList, CourseList courseList, boolean runApp, String command) {
//
//        switch (command) {
//            case "q":
//                //checks to see if user wants to save worklist and exits the application
//                runApp = quitApp();
//                break;
//
//            case "search":
//                //prompts the user for search parameters
//                search(courseList);
//                break;
//
//            case "info":
//                //returns general information about a specific course
//                info(courseList);
//                break;
//
//            case "grades":
//                //returns the grade distribution when prompted for a course ID
//                grades(courseList);
//                break;
//
//            case "stats":
//                //provides the in-depth statistics of a specific course when prompted for a courseID
//                stats(courseList);
//                break;
//
//            default:
//                courseListOptions(myList, courseList, command);
//        }
//        return runApp;
//    }
//
//    private void courseListOptions(CourseList myList, CourseList courseList, String input) {
//        switch (input) {
//
//            case "add":
//                //prompts the user for a course ID
//                //adds the course with the given ID to their myList
//                addCourse(myList, courseList);
//                return;
//
//            case "view":
//                //view the courses in my worklist
//                viewMyList(myList);
//                break;
//
//            case "remove":
//                //remove a course from the worklist
//                removeCourse(myList);
//                break;
//
//            case "save":
//                //saves worklist to file
//                saveWorklist();
//                break;
//
//            default:
//                System.out.println("That ain't an option, homie. Try again.");
//        }
//    }
//
//
    // MODIFIES: this
    // EFFECTS: loads the worklist from WORKLIST_FILE, if that file exists;
    // otherwise initializes a new empty worklist
    private void loadWorklist() {
        try {
            myList = Reader.readWorklist(new File(WORKLIST_FILE), courseList);
        } catch (IOException e) {
            myList = new CourseList();
        } catch (IndexOutOfBoundsException e) {
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
//
//    //EFFECTS: prompts user to see if they want to save their worklist, and saves it if yes and then quits
//    // the application, otherwise just quits
//    private boolean quitApp() {
//        System.out.println("Hold up playa, would you like to save your worklist?");
//        System.out.println("Type 'yes' or 'no'.");
//        String saveCommand = input.next();
//        if (saveCommand.equals("yes")) {
//            saveWorklist();
//        }
//        return false;
//    }
//
//    private void removeCourse(CourseList myList) {
//        if (myList.getSize() == 0) {
//            System.out.println("You ain't got any courses in your list, homedrizzle.");
//        } else {
//            System.out.println("Provide the index of which course you would like to remove:\n"
//                    + "(indexes are found to the right of the list entry)");
//            String indexCommand = input.next();
//            myList.removeCourse(parseInt(indexCommand));
//            System.out.println("You're the boss. That index is gone! Here's your updated list:");
//            Integer count = 0;
//            for (Course i : myList.getListCourse()) {
//                System.out.println(i.getId() + " [" + Integer.toString(count) + "]");
//                count++;
//            }
//        }
//    }
//
//    private void viewMyList(CourseList myList) {
//        if (myList.getSize() == 0) {
//            System.out.println("You ain't got any courses in your list, homedrizzle.");
//        } else {
//            System.out.println("Ay baybay, these are the courses in your worklist:");
//            Integer count = 0;
//            for (Course i : myList.getListCourse()) {
//                System.out.println(i.getId() + " [" + Integer.toString(count) + "]");
//                count++;
//            }
//        }
//    }
//
//
//    // MODIFIES: myList
//// EFFECTS: Finds the provided course in the database and adds it to the personal worklist
//    private void addCourse(CourseList myList, CourseList courseList) {
//        System.out.println("Provide the course ID for the class you would like to add in the following"
//                + " format: UBC-yearsession-subject-coursenum-section\n"
//                + "For example, UBC-2018W-MATH-100-101");
//        String courseCommand = input.next();
//        boolean added = false;
//        for (Course i : courseList.getListCourse()) {
//            if (courseCommand.equals(i.getId())) {
//                myList.addCourse(i);
//                System.out.println("I added " + i.getId() + " to your courselist!");
//                added = true;
//            }
//        }
//        if (!added) {
//            System.out.println("Sorry, I couldn't find that course!");
//        }
//    }
//
//    private void search(CourseList courseList) {
//        System.out.println("What subject would you like to search for? Enter the 4-letter code.\n"
//                + "For example, 'CPSC' for computer science.");
//        String subjectCommand = input.next();
//
//        System.out.println("What year level would you like to search for? Enter one number.\n"
//                + "For example, '2' for a 2nd year course.");
//        String yearCommand = input.next();
//
//        System.out.println("What is the lowest course average you would like to consider in your search?\n"
//                + "For example, if you want only courses with an average of 75 or higher: enter '75'.");
//        String avgCommand = input.next();
//
//        CourseList searchResults = courseList.searcher(subjectCommand, yearCommand, parseInt(avgCommand));
//
//        if (searchResults.getSize() == 0) {
//            System.out.println("My condolences, nothing matched your search criteria.");
//        } else {
//            System.out.println("Check out deez beautiful results I found:\n");
//            Integer count = 0;
//            for (Course i : searchResults.getListCourse()) {
//                System.out.println(i.getId() + " [" + Integer.toString(count) + "]");
//                count++;
//            }
//        }
//    }

    //EFFECTS: builds the course database
    public CourseList populateCourseList() {

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

        //RANDOM:*
        Course c20 = getC20();

        CourseList courseDatabase = new CourseList();
        courseDatabase.addMultipleCourses(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20);
        return courseDatabase;
    }


    private Course getC20() {
        return new Course("UBC-2018W-MUSC-105-001", "2018W", "MUSC", "105",
                "001", "AURAL SKILLS I", new Instructor("Paslawski, Gordon", "3.1/5"),
                59, new Stats(83.59, 13.46, 99, 9, 58, 1, 0),
                new Grades(1, 0, 0, 0, 0, 1, 1,
                        0, 0, 1, 3, 3, 6,
                        15, 9, 20));
    }

    private Course getC19() {
        return new Course("UBC-2017W-CHEM-405-110", "2017W", "CHEM", "405",
                "110", "BIOPHYSICAL CHEM", new Instructor("Straus, Suzana", "2.6/5"),
                19, new Stats(85.68, 8.78, 95, 56, 19, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        1, 0, 0, 0, 1, 0,
                        3, 7, 7));
    }

    private Course getC18() {
        return new Course("UBC-2017W-CHEM-402-210", "2017W", "CHEM", "402",
                "210", "DIFRACTION MTHDS", new Instructor("Patrick, Brian", "N/A"),
                15, new Stats(83.87, 7.61, 96, 71, 15, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 1, 1, 3,
                        2, 5, 3));
    }

    private Course getC17() {
        return new Course("UBC-2018W-CHEM-418-209", "2018W", "CHEM", "418",
                "209", "ORGANOMETALLIC", new Instructor("Fryzuk, Michael", "3.53/5"),
                18, new Stats(79.67, 12.32, 98, 58, 18, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        1, 2, 1, 0, 1, 2,
                        4, 3, 4));
    }

    private Course getC16() {
        return new Course("UBC-2018W-CHEM-461-233", "2018W", "CHEM", "461",
                "233", "SYNTH CHEM BIOL", new Instructor("Perrin, David", "2.6/5"),
                14, new Stats(79.0, 12.07, 96, 54, 13, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 1,
                        1, 0, 1, 0, 1, 1,
                        2, 3, 3));
    }

    private Course getC15() {
        return new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, new Stats(70.34, 14.74, 99, 32, 107, 11, 3),
                new Grades(0, 0, 0, 2, 9, 11, 7,
                        9, 13, 10, 10, 7, 12,
                        15, 15, 9));
    }

    private Course getC14() {
        return new Course("UBC-2018W-COMM-395-106", "2018W", "COMM", "395",
                "106", "BUSN COMMUNICATION", new Instructor("Brealey, Chad ", "3.3/5"),
                40, new Stats(79.38, 2.74, 84, 73, 40, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 4, 13,
                        23, 0, 0));
    }

    private Course getC13() {
        return new Course("UBC-2017W-COMM-337-201", "2017W", "COMM", "337",
                "201", "BUS PROG ANLYTCS", new Instructor("Lee, Gene ", "N/A"),
                39, new Stats(86.77, 9.4, 98, 58, 39, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        1, 0, 2, 1, 0, 3,
                        7, 4, 21));
    }

    private Course getC12() {
        return new Course("UBC-2017W-COMM-335-101", "2017W", "COMM", "335",
                "101", "INFO SYS MNGT", new Instructor("Cheung, Yau Man ", "3.7/5"),
                122, new Stats(84.03, 6.65, 95, 61, 117, 0, 1),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        0, 1, 1, 3, 3, 16,
                        26, 32, 35));
    }

    private Course getC11() {
        return new Course("UBC-2018W-COMM-329-203", "2018W", "COMM", "329",
                "203", "ORGANIZTL BHVR", new Instructor("Svedic, Zorana ", "2.3/5"),
                20, new Stats(76.45, 4.93, 85, 63, 20, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        0, 1, 0, 0, 5, 6,
                        7, 1, 0));
    }

    private Course getC10() {
        return new Course("UBC-2017W-CPSC-210-203", "2017W", "CPSC", "210",
                "203", "SFTWR CONSTRUCTN", new Instructor("Carter, Paul Martin", "4.4/5"),
                126, new Stats(74.39, 15.3, 99, 29, 107, 14, 4),
                new Grades(0, 0, 1, 1, 12, 14, 3,
                        3, 7, 7, 8, 10, 9,
                        27, 16, 17));
    }

    private Course getC9() {
        return new Course("UBC-2018W-CPSC-261-201", "2018W", "CPSC", "261",
                "201", "BASICS COMP SYST", new Instructor("Schroeder, Jonatan", "4.0/5"),
                109, new Stats(71.23, 12.59, 97, 26, 103, 5, 0),
                new Grades(0, 0, 1, 1, 3, 5, 4,
                        8, 9, 15, 15, 7, 16,
                        16, 5, 8));
    }

    private Course getC8() {
        return new Course("UBC-2017W-CPSC-221-102", "2017W", "CPSC", "221",
                "102", "BASIC ALG&DATA", new Instructor("Heeren, Cinda", "4.0/5"),
                123, new Stats(80.84, 14, 100, 32, 113, 5, 3),
                new Grades(0, 0, 0, 1, 4, 5, 3,
                        3, 3, 4, 8, 9, 9,
                        20, 18, 36));
    }

    private Course getC7() {
        return new Course("UBC-2018W-CPSC-213-203", "2018W", "CPSC", "213",
                "203", "INTRO COMP SYS", new Instructor("Feeley, Michael", "3.7/5"),
                149, new Stats(75.37, 13.77, 99, 19, 131, 10, 4),
                new Grades(0, 1, 0, 0, 9, 10, 2,
                        4, 7, 12, 10, 15, 21,
                        22, 19, 19));
    }

    private Course getC6() {
        return new Course("UBC-2018W-CPSC-110-101", "2018W", "CPSC", "110",
                "101", "COMPTN PROGRMNG", new Instructor("Kiczales, Gregor", "3.7/5"),
                271, new Stats(76.72, 17.45, 100, 27, 211, 37, 18),
                new Grades(0, 0, 1, 5, 31, 37, 2,
                        7, 5, 10, 14, 17, 18,
                        25, 39, 74));
    }

    private Course getC5() {
        return new Course("UBC-2017W-MATH-200-103", "2017W", "MATH", "200",
                "103", "CALCULUS 3", new Instructor("Dahlberg, Samantha", "3.3/5"),
                102, new Stats(68.52, 14.03, 97, 25, 91, 9, 2),
                new Grades(0, 0, 1, 0, 8, 9, 10,
                        7, 6, 8, 13, 17, 8,
                        11, 3, 8));
    }

    private Course getC4() {
        return new Course("UBC-2017W-MATH-105-208", "2017W", "MATH", "105",
                "208", "INT CALC AP C&SS", new Instructor("Yeager, Elyse", "4.3/5"),
                208, new Stats(68.96, 14.12, 98, 30, 186, 14, 7),
                new Grades(0, 0, 0, 9, 5, 14, 14,
                        20, 14, 27, 17, 20, 25,
                        24, 15, 10));
    }

    private Course getC3() {
        return new Course("UBC-2018W-MATH-121-201", "2018W", "MATH", "121",
                "201", "INTEGRAL CALCULUS ", new Instructor("Perkins, Edwin", "N/A"),
                29, new Stats(78.76, 12.54, 100, 57, 29, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        2, 4, 1, 2, 1, 2,
                        5, 8, 4));
    }

    private Course getC2() {
        return new Course("UBC-2017W-MATH-103-201", "2017W", "MATH", "103",
                "201", "INT CALC AP LF S", new Instructor("Hauert, Christoph", "3.1/5"),
                218, new Stats(66.44, 14.71, 100, 20, 199, 18, 1),
                new Grades(0, 0, 4, 5, 9, 18, 20,
                        26, 29, 31, 20, 18, 10,
                        21, 9, 15));
    }

    private Course getC1() {
        return new Course("UBC-2018W-MATH-100-101", "2018W", "MATH", "100",
                "101", "DF CALC AP PH SC", new Instructor("Walls, Patrick", "4.4/5"),
                145, new Stats(67.79, 11.72, 87, 12, 130, 6, 5),
                new Grades(0, 1, 0, 3, 2, 6, 10,
                        12, 18, 14, 18, 20, 17,
                        17, 4, 0));
    }


    // EFFECTS: displays menu of options to user
    private void displayStartMenu() {
        System.out.println("\nPick one of these bad boys:");
        System.out.println("\tadd    -> add a course to your worklist");
        System.out.println("\tgrades -> view grade distribution for a specific course");
        System.out.println("\tinfo   -> view general info on a specific course");
        System.out.println("\tstats  -> view detailed statistics for a specific course");
        System.out.println("\tremove -> remove a course from your worklist");
        System.out.println("\tsave   -> save your personalized worklist");
        System.out.println("\tsearch -> search for courses");
        System.out.println("\tview   -> view your worklist");
        System.out.println("\tq      -> quit");
    }

    public static void main(String[] args) {
        new CourseChooser();
    }

    public void addCourse(String courseAdded, WorklistPage worklistPage) {
        JTextArea worklistDisplay = worklistPage.getPersonalWorklist();
        boolean added = false;
        for (Course i : courseList.getListCourse()) {
            if (courseAdded.equals(i.getId())) {
                myList.addCourse(i);
                worklistDisplay.append("I added " + i.getId() + " to your worklist!\n\n");
                displayWorklist(worklistDisplay);
                added = true;
                break;
            }
        }

        if (!added) {
            worklistDisplay.append("Sorry, I couldn't find that course!\n\n");
            displayWorklist(worklistDisplay);
        }
    }

    public void displayWorklist(JTextArea worklistDisplay) {
        worklistDisplay.append("Your personalized worklist:\n\n");

        if (myList.getSize() == 0) {
            worklistDisplay.append("Your worklist is empty! Add some bad boys in there.");
        }

        for (Course course : myList.getListCourse()) {
            worklistDisplay.append(course.getId() + "\n\n");
        }
    }

    public void removeCourse(String courseToRemove, WorklistPage worklistPage) {
        JTextArea worklistDisplay = worklistPage.getPersonalWorklist();

        boolean removed = false;
        for (Course i : myList.getListCourse()) {
            if (courseToRemove.equals(i.getId())) {
                myList.removeCourse(i);
                worklistDisplay.append("I removed " + i.getId() + " to your worklist!\n\n");
                displayWorklist(worklistDisplay);
                removed = true;
                break;
            }
        }

        if (!removed) {
            worklistDisplay.append("Sorry, I couldn't find that course!\n\n");
            displayWorklist(worklistDisplay);
        }
    }
}




