package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseTest {
    Course c15;
    JTextArea testTextArea;
    Grades grades;
    Stats stats;

    @BeforeEach
    public void runBefore() {
        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, new Stats(70.34, 14.74, 99, 32, 107, 11, 3),
                new Grades(0, 0, 0, 2, 9, 11, 7,
                        9, 13, 10, 10, 7, 12,
                        15, 15, 9));
        testTextArea = new JTextArea();
        grades = c15.getGrades();
        stats = c15.getStats();
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
        assertEquals(70.34, c15.getStats().getAverage());
    }

    @Test
    public void testGetGrades() {
        assertEquals(11, c15.getGrades().getLessThan50());
    }

    @Test
    public void testInfoToString() {
        c15.toString(testTextArea, "General Info");
        assertEquals("Course ID :               " + c15.getId() + "\n"
                + "YearSession :           " + c15.getYearsession() + "\n"
        + "Subject :                    " + c15.getSubject() + "\n"
        + "Course Code :         " + c15.getCourseNum() + "\n"
        + "Section :                   " + c15.getSection() + "\n"
        + "Course Name :         " + c15.getTitle() + "\n"
        + "Instructor :                  " + c15.getInstructor().getName() + "\n"
        + "RateMyProfessor :   " + c15.getInstructor().getRating() + "\n"
        + "Enrolled :                   " + String.valueOf(c15.getEnrolled()) + "\n",testTextArea.getText());
    }

    @Test
    public void testGradesToString() {
        c15.toString(testTextArea, "Grade Distribution");
        assertEquals("0-9 %        : " + String.valueOf(grades.getZeroTo9()) + "\n"
        + "10-19 %   : " + String.valueOf(grades.getTenTo19()) + "\n"
        + "20-29 %   : " + String.valueOf(grades.getTwentyTo29()) + "\n"
        + "30-39 %   : " + String.valueOf(grades.getThirtyTo39()) + "\n"
        + "40-49 %   : " + String.valueOf(grades.getFortyTo49()) + "\n"
        + "<50 %       : " + String.valueOf(grades.getLessThan50()) + "\n"
        + "50-54 %   : " + String.valueOf(grades.getFiftyTo54()) + "\n"
        + "55-59 %   : " + String.valueOf(grades.getFiftyFiveTo59()) + "\n"
        + "60-63 %   : " + String.valueOf(grades.getSixtyTo63()) + "\n"
        + "64-67 %   : " + String.valueOf(grades.getSixtyFourTo67()) + "\n"
        + "68-71 %   : " + String.valueOf(grades.getSixtyEightTo71()) + "\n"
        + "72-75 %   : " + String.valueOf(grades.getSeventyTwoTo75()) + "\n"
        + "76-79 %   : " + String.valueOf(grades.getSeventySixTo79()) + "\n"
        + "80-84 %   : " + String.valueOf(grades.getEightyTo84()) + "\n"
        + "85-89 %   : " + String.valueOf(grades.getEightyFiveTo89()) + "\n"
        + "90-100 % : " + String.valueOf(grades.getNinetyTo100()) + "\n", testTextArea.getText());
    }

    @Test
    public void testStatsToString() {
        c15.toString(testTextArea, "Statistics");
        assertEquals("Mean :      " + String.valueOf(stats.getAverage()) + "\n"
        + "StDev :     " + String.valueOf(stats.getStDev()) + "\n"
        + "High :        " + String.valueOf(stats.getHigh()) + "\n"
        + "Low :         " + String.valueOf(stats.getLow()) + "\n"
        + "Pass :       " + String.valueOf(stats.getPass()) + "\n"
        + "Fail :          " + String.valueOf(stats.getFail()) + "\n"
        + "Withdrew : " + String.valueOf(stats.getWithdrew()) + "\n", testTextArea.getText());
    }
}
