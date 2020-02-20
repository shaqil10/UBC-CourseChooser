package persistence;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, new Stats(70.34, 14.74, 99, 32, 107, 11, 3),
                new Grades(0, 0, 0, 2, 9, 11, 7,
                        9, 13, 10, 10, 7, 12,
                        15, 15, 9));
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