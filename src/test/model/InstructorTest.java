package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {
    Course c15;
    Instructor c15Instructor;

    @BeforeEach
    public void runBefore() {
        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, new Stats(70.34, 14.74, 99, 32, 107, 11, 3),
                new Grades(0, 0, 0, 2, 9, 11, 7,
                        9, 13, 10, 10, 7, 12,
                        15, 15, 9));

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