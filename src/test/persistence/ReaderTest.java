package persistence;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReaderTest {

    Course c1;
    Course c2;
    Course c3;
    Course c4;
    Course c5;
    Course c15;
    CourseList testDatabase;

    @BeforeEach
    void runBefore() {
        c1 = new Course("UBC-2018W-MATH-100-101", "2018W", "MATH", "100",
                "101", "DF CALC AP PH SC", new Instructor("Walls, Patrick", "4.4/5"),
                145, new Stats(67.79, 11.72, 87, 12, 130, 6, 5),
                new Grades(0, 1, 0, 3, 2, 6, 10,
                        12, 18, 14, 18, 20, 17,
                        17, 4, 0));

        c2 = new Course("UBC-2017W-MATH-103-201", "2017W", "MATH", "103",
                "201", "INT CALC AP LF S", new Instructor("Hauert, Christoph", "3.1/5"),
                218, new Stats(66.44, 14.71, 100, 20, 199, 18, 1),
                new Grades(0, 0, 4, 5, 9, 18, 20,
                        26, 29, 31, 20, 18, 10,
                        21, 9, 15));

        c3 = new Course("UBC-2018W-MATH-121-201", "2018W", "MATH", "121",
                "201", "INTEGRAL CALCULUS ", new Instructor("Perkins, Edwin", "N/A"),
                29, new Stats(78.76, 12.54, 100, 57, 29, 0, 0),
                new Grades(0, 0, 0, 0, 0, 0, 0,
                        2, 4, 1, 2, 1, 2,
                        5, 8, 4));

        c4 = new Course("UBC-2017W-MATH-105-208", "2017W", "MATH", "105",
                "208", "INT CALC AP C&SS", new Instructor("Yeager, Elyse", "4.3/5"),
                208, new Stats(68.96, 14.12, 98, 30, 186, 14, 7),
                new Grades(0, 0, 0, 9, 5, 14, 14,
                        20, 14, 27, 17, 20, 25,
                        24, 15, 10));


        c5 = new Course("UBC-2017W-MATH-200-103", "2017W", "MATH", "200",
                "103", "CALCULUS 3", new Instructor("Dahlberg, Samantha", "3.3/5"),
                102, new Stats(68.52, 14.03, 97, 25, 91, 9, 2),
                new Grades(0, 0, 1, 0, 8, 9, 10,
                        7, 6, 8, 13, 17, 8,
                        11, 3, 8));

        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, new Stats(70.34, 14.74, 99, 32, 107, 11, 3),
                new Grades(0, 0, 0, 2, 9, 11, 7,
                        9, 13, 10, 10, 7, 12,
                        15, 15, 9));
        testDatabase = new CourseList();
        testDatabase.addMultipleCourses(c1, c2,c3,c4,c5, c15);
    }

    @Test
    void testParseWorklistFile1() {
        try {
            CourseList readWorklist = Reader.readWorklist(new File("./data/testReadWorklist1.txt"),testDatabase);
            Course course0 = readWorklist.getCourseAtIndex(0);
            assertEquals("UBC-2018W-MATH-100-101", course0.getId());
            Course course1 = readWorklist.getCourseAtIndex(1);
            assertEquals("UBC-2017W-MATH-103-201", course1.getId());
            Course course2 = readWorklist.getCourseAtIndex(2);
            assertEquals("UBC-2017W-COMM-457-101", course2.getId());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }


    @Test
    void testParseWorklistFile2() {
        try {
            CourseList readWorklist = Reader.readWorklist(new File("./data/testReadWorklist2.txt"),testDatabase);
            Course course0 = readWorklist.getCourseAtIndex(0);
            assertEquals("UBC-2018W-MATH-121-201", course0.getId());
            Course course1 = readWorklist.getCourseAtIndex(1);
            assertEquals("UBC-2017W-MATH-105-208", course1.getId());
            Course course2 = readWorklist.getCourseAtIndex(2);
            assertEquals("UBC-2017W-MATH-200-103", course2.getId());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }


    @Test
    void testIOException() {
        try {
            Reader.readWorklist(new File("./path/does/not/exist/testAccount.txt"),testDatabase);
            fail("oops");
        } catch (IOException e) {
            System.out.println("KOBE");
            // expected
        }
    }

}