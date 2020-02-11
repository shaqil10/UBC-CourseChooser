package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course c15;

    @BeforeEach
    public void runBefore() {
        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, new Stats(70.34, 14.74, 99, 32, 107, 11, 3),
                new Grades(0, 0, 0, 2, 9, 11, 7,
                        9, 13, 10, 10, 7, 12,
                        15, 15, 9));
    }

    @Test
    public void testGetters() {
         assertEquals("UBC-2017W-COMM-457-101", c15.getId());
         assertEquals("2017W",c15.getYearsession());
         assertEquals("COMM",c15.getSubject());
         assertEquals("457", c15.getCourseNum());
         assertEquals("101", c15.getSection());
         assertEquals("FNDTLS FIN ACCT", c15.getTitle());
         assertEquals("Sinclair, Scott", c15.getInstructor().getName());
         assertEquals("4.5/5", c15.getInstructor().getRating());
         assertEquals(121,c15.getEnrolled());
    }
}