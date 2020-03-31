package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {
    Course c15;
    Stats c15stats;
    Grades c15grades;
    Instructor c15Instructor;

    @BeforeEach
    public void runBefore() {
        c15stats = new Stats(null,70.34, 14.74, 99, 32, 107, 11, 3);
        c15grades = new Grades(null,0, 0, 0, 2, 9, 11,
                7, 9, 13, 10, 10, 7,
                12, 15, 15, 9);

        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, c15stats,c15grades);
        c15grades.setCourse(c15);
        c15stats.setCourse(c15);
        c15Instructor = c15.getInstructor();
    }

    @Test
    public void testGetName() {
        assertEquals("Sinclair, Scott", c15Instructor.getName());
    }

    @Test
    void testGetRating() {
        assertEquals("4.5/5",c15Instructor.getRating());
    }
}