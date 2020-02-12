package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GradesTest {
    Course c15;
    Grades c15grades;

    @BeforeEach
    public void runBefore() {
        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, new Stats(70.34, 14.74, 99, 32, 107, 11, 3),
                new Grades(0, 0, 0, 2, 9, 11, 7,
                        9, 13, 10, 10, 7, 12,
                        15, 15, 9));
        c15grades = c15.getGrades();
    }

    @Test
    public void test0to9() {
        assertEquals("0", String.valueOf(c15grades.getZeroTo9()));
    }

    @Test
    public void test10to19() {
        assertEquals("0", String.valueOf(c15grades.getTenTo19()));
    }

    @Test
    public void test20to29() {
        assertEquals("0", String.valueOf(c15grades.getTwentyTo29()));
    }

    @Test
    public void test30to39() {
        assertEquals("2", String.valueOf(c15grades.getThirtyTo39()));
    }

    @Test
    public void test40to49() {
        assertEquals("9", String.valueOf(c15grades.getFortyTo49()));
    }

    @Test
    public void testLessThan50() {
        assertEquals("11", String.valueOf(c15grades.getLessThan50()));
    }

    @Test
    public void test50t54() {
        assertEquals("7", String.valueOf(c15grades.getFiftyTo54()));
    }

    @Test
    public void tes55to59() {
        assertEquals("9", String.valueOf(c15grades.getFiftyFiveTo59()));
    }

    @Test
    public void test60to63() {
        assertEquals("13", String.valueOf(c15grades.getSixtyTo63()));
    }

    @Test
    public void test64to67() {
        assertEquals("10", String.valueOf(c15grades.getSixtyFourTo67()));
    }

    @Test
    public void test68to71() {
        assertEquals("10", String.valueOf(c15grades.getSixtyEightTo71()));
    }

    @Test
    public void test72to75() {
        assertEquals("7", String.valueOf(c15grades.getSeventyTwoTo75()));
    }

    @Test
    public void test76to79() {
        assertEquals("12", String.valueOf(c15grades.getSeventySixTo79()));
    }

    @Test
    public void test80to84() {
        assertEquals("15", String.valueOf(c15grades.getEightyTo84()));
    }

    @Test
    public void test85to89() {
        assertEquals("15", String.valueOf(c15grades.getEightyFiveTo89()));
    }

    @Test
    public void test90to100() {
        assertEquals("9", String.valueOf(c15grades.getNinetyTo100()));
    }

    @Test
    public void testGradestoString() {
        assertEquals("Yay", c15grades.gradesToString());
    }
}