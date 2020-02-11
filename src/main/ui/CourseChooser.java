package ui;

import model.*;
import model.Searcher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class CourseChooser {

    private Scanner input;

    //EFFECTS: Run the Course Chooser application
    public CourseChooser() {
        runProgram();
    }

    //MODIFIES: this
    //EFFECTS:

    public void runProgram() {
        ArrayList<Course> myList = new ArrayList<>();
        ArrayList<Course> courseList = populateCourseList();

        boolean runApp = true;
        String command = null;
        input = new Scanner(System.in);


        while (runApp) {
            displayStartMenu();
            command = input.next();
            command = command.toLowerCase();

            switch (command) {
                case "q" :
                    //exits the application
                    runApp = false;
                    break;

                case "s" :
                    //prompts the user for search parameters
                    System.out.println("What subject would you like to search for? Enter the 4-letter code.\n"
                            + "For example, 'CPSC' for computer science.");
                    Scanner subjectInput = new Scanner(System.in);
                    String subjectCommand = subjectInput.next();

                    System.out.println("What year level would you like to search for? Enter one number.\n"
                            + "For example, '2' for a 2nd year course.");
                    Scanner yearInput = new Scanner(System.in);
                    String yearCommand = yearInput.next();

                    System.out.println("What is the lowest course average you would like to consider in your search?\n"
                            + "For example, if you want only courses with an average of 75 or higher: enter '75'.");
                    Scanner avgInput = new Scanner(System.in);
                    String avgCommand = avgInput.next();

                    ArrayList<Course> searchResults = Searcher.searcher(courseList,
                            subjectCommand,yearCommand, parseInt(avgCommand));

                    for (Course i:searchResults) {
                        System.out.println(i.getId());
                    }

                    break;

                case "a" :
                    //prompts the user for a course ID
                    //adds the course with the given ID to their myList

                default:
                    System.out.println("That ain't an option, homie. Try again.");
            }



        }

        System.out.println("\nLater, skater.");


        //Prompt for subject, year level, and mean threshold
        //Help list for possible inputs
        //If one of the fields don't match, have a message saying one of the choices is invalid
        ArrayList<Course> searchResults = new Searcher().searcher(courseList, "!!!", "!!!", 0 );


    }


    public ArrayList<Course> populateCourseList() {

        //MATH:*
        Course c1 = new Course("UBC-2018W-MATH-100-101", "2018W", "MATH", "100",
                "101", "DF CALC AP PH SC", new Instructor("Walls, Patrick", "4.4/5"),
                145, new Stats(67.79, 11.72, 87, 12, 130, 6, 5),
                new Grades(0, 1, 0, 3, 2, 6, 10,
                        12, 18, 14, 18, 20, 17,
                        17, 4, 0));

        Course c2 = new Course("UBC-2017W-MATH-103-201", "2017W", "MATH", "103",
                "201", "INT CALC AP LF S", new Instructor("Hauert, Christoph", "3.1/5"),
                218, new Stats(66.44, 14.71, 100, 20, 199, 18, 1),
                new Grades(0, 0, 4, 5, 9, 18, 20,
                        26, 29, 31, 20, 18, 10,
                        21, 9, 15));

        Course c3 = new Course("UBC-2018W-MATH-121-201", "2018W", "MATH", "121",
                "201", "INTEGRAL CALCULUS ", new Instructor("Perkins, Edwin", "N/A"),
                29, new Stats(78.76, 12.54, 100, 57, 29, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        2, 4, 1, 2, 1, 2,
                        5, 8, 4));

        Course c4 = new Course("UBC-2017W-MATH-105-208", "2017W", "MATH", "105",
                "208", "INT CALC AP C&SS", new Instructor("Yeager, Elyse", "4.3/5"),
                208, new Stats(68.96, 14.12, 98, 30, 186, 14, 7),
                new Grades(0, 0, 0, 9, 5, 14, 14,
                        20, 14, 27, 17, 20, 25,
                        24, 15, 10));


        Course c5 = new Course("UBC-2017W-MATH-200-103", "2017W", "MATH", "200",
                "103", "CALCULUS 3", new Instructor("Dahlberg, Samantha", "3.3/5"),
                102, new Stats(68.52, 14.03, 97, 25, 91, 9, 2),
                new Grades(0, 0, 1, 0, 8, 9, 10,
                        7, 6, 8, 13, 17, 8,
                        11, 3, 8));


        //CPSC:
        Course c6 = new Course("UBC-2018W-CPSC-110-101", "2018W", "CPSC", "110",
                "101", "COMPTN PROGRMNG", new Instructor("Kiczales, Gregor", "3.7/5"),
                271, new Stats(76.72, 17.45, 100, 27, 211, 37, 18),
                new Grades(0, 0, 1, 5, 31, 37, 2,
                        7, 5, 10, 14, 17, 18,
                        25, 39, 74));


        Course c7 = new Course("UBC-2018W-CPSC-213-203", "2018W", "CPSC", "213",
                "203", "INTRO COMP SYS", new Instructor("Feeley, Michael", "3.7/5"),
                149, new Stats(75.37, 13.77, 99, 19, 131, 10, 4),
                new Grades(0, 1, 0, 0, 9, 10, 2,
                        4, 7, 12, 10, 15, 21,
                        22, 19, 19));

        Course c8 = new Course("UBC-2017W-CPSC-221-102", "2017W", "CPSC", "221",
                "102", "BASIC ALG&DATA", new Instructor("Heeren, Cinda", "4.0/5"),
                123, new Stats(80.84, 14, 100, 32, 113, 5, 3),
                new Grades(0, 0, 0, 1, 4, 5, 3,
                        3, 3, 4, 8, 9, 9,
                        20, 18, 36));

        Course c9 = new Course("UBC-2018W-CPSC-261-201", "2018W", "CPSC", "261",
                "201", "BASICS COMP SYST", new Instructor("Schroeder, Jonatan", "4.0/5"),
                109, new Stats(71.23, 12.59, 97, 26, 103, 5, 0),
                new Grades(0, 0, 1, 1, 3, 5, 4,
                        8, 9, 15, 15, 7, 16,
                        16, 5, 8));

        Course c10 = new Course("UBC-2017W-CPSC-210-203", "2017W", "CPSC", "210",
                "203", "SFTWR CONSTRUCTN", new Instructor("Carter, Paul Martin", "4.4/5"),
                126, new Stats(74.39, 15.3, 99, 29, 107, 14, 4),
                new Grades(0, 0, 1, 1, 12, 14, 3,
                        3, 7, 7, 8, 10, 9,
                        27, 16, 17));


        //COMM:

        Course c11 = new Course("UBC-2018W-COMM-329-203", "2018W", "COMM", "329",
                "203", "ORGANIZTL BHVR", new Instructor("Svedic, Zorana ", "2.3/5"),
                20, new Stats(76.45, 4.93, 85, 63, 20, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        0, 1, 0, 0, 5, 6,
                        7, 1, 0));

        Course c12 = new Course("UBC-2017W-COMM-335-101", "2017W", "COMM", "335",
                "101", "INFO SYS MNGT", new Instructor("Cheung, Yau Man ", "3.7/5"),
                122, new Stats(84.03, 6.65, 95, 61, 117, 0, 1),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        0, 1, 1, 3, 3, 16,
                        26, 32, 35));

        Course c13 = new Course("UBC-2017W-COMM-337-201", "2017W", "COMM", "337",
                "201", "BUS PROG ANLYTCS", new Instructor("Lee, Gene ", "N/A"),
                39, new Stats(86.77, 9.4, 98, 58, 39, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        1, 0, 2, 1, 0, 3,
                        7, 4, 21));

        Course c14 = new Course("UBC-2018W-COMM-395-106", "2018W", "COMM", "395",
                "106", "BUSN COMMUNICATION", new Instructor("Brealey, Chad ", "3.3/5"),
                40, new Stats(79.38, 2.74, 84, 73, 40, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 0, 4, 13,
                        23, 0, 0));


        Course c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, new Stats(70.34, 14.74, 99, 32, 107, 11, 3),
                new Grades(0, 0, 0, 2, 9, 11, 7,
                        9, 13, 10, 10, 7, 12,
                        15, 15, 9));


        //CHEM:

        Course c16 = new Course("UBC-2018W-CHEM-461-233", "2018W", "CHEM", "461",
                "233", "SYNTH CHEM BIOL", new Instructor("Perrin, David", "2.6/5"),
                14, new Stats(79.0, 12.07, 96, 54, 13, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 1,
                        1, 0, 1, 0, 1, 1,
                        2, 3, 3));

        Course c17 = new Course("UBC-2018W-CHEM-418-209", "2018W", "CHEM", "418",
                "209", "ORGANOMETALLIC", new Instructor("Fryzuk, Michael", "3.53/5"),
                18, new Stats(79.67, 12.32, 98, 58, 18, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        1, 2, 1, 0, 1, 2,
                        4, 3, 4));

        Course c18 = new Course("UBC-2017W-CHEM-402-210", "2017W", "CHEM", "402",
                "210", "DIFRACTION MTHDS", new Instructor("Patrick, Brian", "N/A"),
                15, new Stats(83.87, 7.61, 96, 71, 15, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        0, 0, 0, 1, 1, 3,
                        2, 5, 3));

        Course c19 = new Course("UBC-2017W-CHEM-405-110", "2017W", "CHEM", "405",
                "110", "BIOPHYSICAL CHEM", new Instructor("Straus, Suzana", "2.6/5"),
                19, new Stats(85.68, 8.78, 95, 56, 19, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        1, 0, 0, 0, 1, 0,
                        3, 7, 7));


        //RANDOM:*

        Course c20 = new Course("UBC-2018W-MUSC-105-001", "2018W", "MUSC", "105",
                "001", "AURAL SKILLS I", new Instructor("Paslawski, Gordon", "3.1/5"),
                59, new Stats(83.59, 13.46, 99, 9, 58, 1, 0),
                new Grades(1, 0, 0, 0, 0, 1, 1,
                        0, 0, 1, 3, 3, 6,
                        15, 9, 20));

        Course c21 = new Course("UBC-2017W-PHIL-260-001", "2017W", "PHIL", "260",
                "001", "SCIE & SOCIETY", new Instructor("Brain, Robert", "3.5/5"),
                28, new Stats(76.67, 10.09, 90, 40, 23, 1, 2),
                new Grades(0, 0, 0, 0, 1, 1, 0,
                        0, 0, 0, 3, 6, 3,
                        7, 2, 2));

        ArrayList<Course> courseDatabase = new ArrayList<>(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9,
                c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21));

        return courseDatabase;
    }

    // EFFECTS: displays menu of options to user
    private void displayStartMenu() {
        System.out.println("\nPick one of these bad boys:");
        System.out.println("\ta -> add a course to your worklist");
        System.out.println("\ts -> search for courses");
        System.out.println("\tq -> quit");
    }

}




