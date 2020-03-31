package persistence;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.CourseChooser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

class WriterTest {
    private static final String TEST_FILE = "./data/testWorklist.txt";
    private Writer testWriter;
    private Course c1;
    private Course c2;
    private Course c15;
    private CourseList testWorklist;

    @BeforeEach
    void runBefore() throws FileNotFoundException, UnsupportedEncodingException {
        testWriter = new Writer(new File(TEST_FILE));

        c1 = CourseChooser.getC1();

        c2 = CourseChooser.getC2();

        c15 = CourseChooser.getC15();
        testWorklist = new CourseList();
        testWorklist.addMultipleCourses(c1, c2, c15);
    }

    @Test
    void testWriteWorklist() {
        testWriter.write(testWorklist);
        testWriter.close();

        try {
            CourseList readWorklist = Reader.readWorklist(new File(TEST_FILE), testWorklist);
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
}