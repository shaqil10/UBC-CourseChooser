package persistence;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.CourseChooser;

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
        c1 = CourseChooser.getC1();
        c2 = CourseChooser.getC2();
        c3 = CourseChooser.getC3();
        c4 = CourseChooser.getC4();
        c5 = CourseChooser.getC5();

        c15 = CourseChooser.getC15();
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