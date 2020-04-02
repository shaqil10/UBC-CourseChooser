package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class StatsTest {
    Course c15;
    Stats c15stats;
    Grades c15grades;
    Instructor c15Instructor;
    Course c8;
    Grades c8grades;
    Stats c8stats;

    @BeforeEach
    public void runBefore() {
        c15stats = new Stats(null,70.34, 14.74, 99, 32, 107, 11, 3);
        c15grades = new Grades(null,0, 0, 0, 2, 9, 11,
                7, 9, 13, 10, 10, 7,
                12, 15, 15, 9);

        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, null, c15grades);

        c15grades.setCourse(c15);
        c15Instructor = c15.getInstructor();

        c8 = new Course("UBC-2017W-CPSC-221-102", "2017W", "CPSC", "221",
                "102", "BASIC ALG&DATA", new Instructor("Heeren, Cinda", "4.0/5"),
                123, null, c8grades);
        c8grades = new Grades(c8,0, 0, 0, 1, 4,
                5, 3, 3, 3, 4, 8, 9,
                9, 20, 18, 36);
        c8stats = new Stats(c8,80.84, 14,100,32,113, 5,3);
        c8grades.setCourse(c8);
    }

    @Test
    public void testSetCourse() {
        assertTrue(c15stats.isCourseNull());
        c15stats.setCourse(c15);
        assertEquals(c15,c15stats.getCourse());
        assertEquals(c15stats, c15.getStats());

        assertTrue(c8stats.getCourse() != null);
        assertNull(c8.getStats());
        c8stats.setCourse(c8);
        assertEquals(c8,c8stats.getCourse());
        assertEquals(c8stats, c8.getStats());
    }

    @Test
    public void testSetCourseNeitherNull1() {
        Course c = new Course("UBC-2017W-CPSC-221-102", "2017W", "CPSC", "221",
                "102", "BASIC ALG&DATA", new Instructor("Heeren, Cinda", "4.0/5"),
                123, c8stats, c8grades);
        Stats cstats = new Stats(c,80.84, 14,100,32,113, 5,3);
        assertTrue(c.getStats() != cstats);
        cstats.setCourse(c);
        assertEquals(c,cstats.getCourse());
        assertEquals(cstats, c.getStats());
    }

    @Test
    public void testSetCourseNeitherNull2() {
        Stats cstats = new Stats(c8,80.84, 14,100,32,113, 5,3);
        Course c = new Course("UBC-2017W-CPSC-221-102", "2017W", "CPSC", "221",
                "102", "BASIC ALG&DATA", new Instructor("Heeren, Cinda", "4.0/5"),
                123, cstats, c8grades);
        assertTrue(cstats.getCourse() != c);
        cstats.setCourse(c);
        assertEquals(c,cstats.getCourse());
        assertEquals(cstats, c.getStats());
    }

    @Test
    public void testGetAvg() {
        assertEquals(70.34, c15stats.getAverage());
    }

    @Test
    public void testGetStDev() {
        assertEquals(14.74, c15stats.getStDev());
    }

    @Test
    public void testGetHigh() {
        assertEquals(99, c15stats.getHigh());
    }

    @Test
    public void testGetLow() {
        assertEquals(32, c15stats.getLow());
    }

    @Test
    public void testGetPass() {
        assertEquals(107, c15stats.getPass());
    }

    @Test
    public void testGetFail() {
        assertEquals(11, c15stats.getFail());
    }

    @Test
    public void testGetWithdrew() {
        assertEquals(3, c15stats.getWithdrew());
    }

}