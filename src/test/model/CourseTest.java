package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course c15;
    JTextArea testTextArea;
    Grades c15grades;
    Stats c15stats;
    Course c8;
    Grades c8grades;
    Stats c8stats;
    Instructor c15Instructor;

    @BeforeEach
    public void runBefore() {
        c15stats = new Stats(null,70.34, 14.74, 99, 32, 107, 11, 3);
        c15grades = new Grades(null,0, 0, 0, 2, 9, 11,
                7, 9, 13, 10, 10, 7,
                12, 15, 15, 9);

        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, null,null);
        c15Instructor = c15.getInstructor();

        c8grades = new Grades(null,0, 0, 0, 1, 4,
                5, 3, 3, 3, 4, 8, 9,
                9, 20, 18, 36);
        c8stats = new Stats(null,80.84, 14,100,32,113, 5,3);
        c8 = new Course("UBC-2017W-CPSC-221-102", "2017W", "CPSC", "221",
                "102", "BASIC ALG&DATA", new Instructor("Heeren, Cinda", "4.0/5"),
                123, c8stats, c8grades);

        testTextArea = new JTextArea();
    }

    @Test
    public void testSetStatsAndGradesNullCase1() {
        assertTrue(c15.isStatsNull());
        assertTrue(c15.isGradesNull());
        assertTrue(c15stats.isCourseNull());
        assertTrue(c15grades.isCourseNull());
        c15.setGrades(c15grades);
        c15.setStats(c15stats);
        assertEquals(c15stats, c15.getStats());
        assertEquals(c15grades, c15.getGrades());
        assertEquals(c15, c15stats.getCourse());
        assertEquals(c15, c15grades.getCourse());
    }

    @Test
    public void testSetStatsandGradesNullCase2() {
        assertFalse(c8.isStatsNull());
        assertFalse(c8.isGradesNull());
        assertTrue(c8stats.isCourseNull());
        assertTrue(c8grades.isCourseNull());
        c8.setGrades(c8grades);
        c8.setStats(c8stats);
        assertEquals(c8stats, c8.getStats());
        assertEquals(c8grades, c8.getGrades());
        assertEquals(c8, c8stats.getCourse());
        assertEquals(c8, c8grades.getCourse());
    }

    @Test
    public void testSetStatsandGradesNonNull1() {
        Grades cgrades = new Grades(c15,0, 0, 0, 1, 4,
                5, 3, 3, 3, 4, 8, 9,
                9, 20, 18, 36);
        Stats cstats = new Stats(c15,80.84, 14,100,32,113, 5,3);
        Course c = new Course("UBC-2017W-CPSC-221-102", "2017W", "CPSC", "221",
                "102", "BASIC ALG&DATA", new Instructor("Heeren, Cinda", "4.0/5"),
                123, c8stats, c8grades);
        assertFalse(c.isStatsNull());
        assertFalse(c.isGradesNull());
        assertFalse(cstats.isCourseNull());
        assertFalse(cgrades.isCourseNull());
        assertTrue(cstats.getCourse() != c);
        assertTrue(cgrades.getCourse() != c);
        c.setGrades(cgrades);
        c.setStats(cstats);
        assertEquals(cstats, c.getStats());
        assertEquals(cgrades, c.getGrades());
        assertEquals(c, cstats.getCourse());
        assertEquals(c, cgrades.getCourse());
    }

    @Test
    public void testSetStatsandGradesNonNull12() {
        Course c = new Course("UBC-2017W-CPSC-221-102", "2017W", "CPSC", "221",
                "102", "BASIC ALG&DATA", new Instructor("Heeren, Cinda", "4.0/5"),
                123, c8stats, c8grades);
        Grades cgrades = new Grades(c,0, 0, 0, 1, 4,
                5, 3, 3, 3, 4, 8, 9,
                9, 20, 18, 36);
        Stats cstats = new Stats(c,80.84, 14,100,32,113, 5,3);
        assertFalse(c.isStatsNull());
        assertFalse(c.isGradesNull());
        assertFalse(cstats.isCourseNull());
        assertFalse(cgrades.isCourseNull());
        assertEquals(cstats.getCourse() , c);
        assertEquals(cgrades.getCourse() , c);
        assertTrue(c.getStats() != cstats);
        assertTrue(c.getGrades() != cgrades);
        c.setGrades(cgrades);
        c.setStats(cstats);
        assertEquals(cstats, c.getStats());
        assertEquals(cgrades, c.getGrades());
        assertEquals(c, cstats.getCourse());
        assertEquals(c, cgrades.getCourse());
    }

    @Test
    public void testGetId() {
        assertEquals("UBC-2017W-COMM-457-101", c15.getId());
    }

    @Test
    public void testGetYearSession() {
        assertEquals("2017W", c15.getYearsession());
    }

    @Test
    public void testGetSubject() {
        assertEquals("COMM", c15.getSubject());
    }

    @Test
    public void testGetCourseNum() {
        assertEquals("457", c15.getCourseNum());
    }

    @Test
    public void testGetSection() {
        assertEquals("101", c15.getSection());
    }

    @Test
    public void testGetTitle() {
        assertEquals("FNDTLS FIN ACCT", c15.getTitle());
    }

    @Test
    public void testGetEnrolled() {
        assertEquals(121, c15.getEnrolled());
    }

    @Test
    public void testGetStats() {
        c15.setStats(c15stats);
        assertEquals(70.34, c15.getStats().getAverage());
    }

    @Test
    public void testGetGrades() {
        c15.setGrades(c15grades);
        assertEquals(11, c15.getGrades().getLessThan50());
    }

    @Test
    public void testInfoToString() {
        c15.toString(testTextArea, "");
        assertEquals("",testTextArea.getText());
        c15.toString(testTextArea, "General Info");
        assertEquals("Course ID :               " + c15.getId() + "\n"
                + "YearSession :           " + c15.getYearsession() + "\n"
        + "Subject :                    " + c15.getSubject() + "\n"
        + "Course Code :         " + c15.getCourseNum() + "\n"
        + "Section :                   " + c15.getSection() + "\n"
        + "Course Name :         " + c15.getTitle() + "\n"
        + "Instructor :                  " + c15Instructor.getName() + "\n"
        + "RateMyProfessor :   " + c15Instructor.getRating() + "\n"
        + "Enrolled :                   " + String.valueOf(c15.getEnrolled()) + "\n",testTextArea.getText());
    }

    @Test
    public void testGradesToString() {
        c15.setGrades(c15grades);
        c15.toString(testTextArea, "Grade Distribution");
        assertEquals("0-9 %        : " + String.valueOf(c15grades.getZeroTo9()) + "\n"
        + "10-19 %   : " + String.valueOf(c15grades.getTenTo19()) + "\n"
        + "20-29 %   : " + String.valueOf(c15grades.getTwentyTo29()) + "\n"
        + "30-39 %   : " + String.valueOf(c15grades.getThirtyTo39()) + "\n"
        + "40-49 %   : " + String.valueOf(c15grades.getFortyTo49()) + "\n"
        + "<50 %       : " + String.valueOf(c15grades.getLessThan50()) + "\n"
        + "50-54 %   : " + String.valueOf(c15grades.getFiftyTo54()) + "\n"
        + "55-59 %   : " + String.valueOf(c15grades.getFiftyFiveTo59()) + "\n"
        + "60-63 %   : " + String.valueOf(c15grades.getSixtyTo63()) + "\n"
        + "64-67 %   : " + String.valueOf(c15grades.getSixtyFourTo67()) + "\n"
        + "68-71 %   : " + String.valueOf(c15grades.getSixtyEightTo71()) + "\n"
        + "72-75 %   : " + String.valueOf(c15grades.getSeventyTwoTo75()) + "\n"
        + "76-79 %   : " + String.valueOf(c15grades.getSeventySixTo79()) + "\n"
        + "80-84 %   : " + String.valueOf(c15grades.getEightyTo84()) + "\n"
        + "85-89 %   : " + String.valueOf(c15grades.getEightyFiveTo89()) + "\n"
        + "90-100 % : " + String.valueOf(c15grades.getNinetyTo100()) + "\n", testTextArea.getText());
    }

    @Test
    public void testStatsToString() {
        c15.setStats(c15stats);
        c15.toString(testTextArea, "Statistics");
        assertEquals("Mean :      " + String.valueOf(c15stats.getAverage()) + "\n"
        + "StDev :     " + String.valueOf(c15stats.getStDev()) + "\n"
        + "High :        " + String.valueOf(c15stats.getHigh()) + "\n"
        + "Low :         " + String.valueOf(c15stats.getLow()) + "\n"
        + "Pass :       " + String.valueOf(c15stats.getPass()) + "\n"
        + "Fail :          " + String.valueOf(c15stats.getFail()) + "\n"
        + "Withdrew : " + String.valueOf(c15stats.getWithdrew()) + "\n", testTextArea.getText());
    }
}
