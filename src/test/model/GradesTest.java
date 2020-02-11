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
    public void testGetters() {
        assertEquals("0", String.valueOf(c15grades.getZeroTo9()));
        assertEquals("0", String.valueOf(c15grades.getTenTo19()));
        assertEquals("0", String.valueOf(c15grades.getTwentyTo29()));
        assertEquals("2" ,String.valueOf(c15grades.getThirtyTo39()));
        assertEquals("9", String.valueOf(c15grades.getFortyTo49()));
        assertEquals("11" , String.valueOf(c15grades.getLessThan50()));
        assertEquals("7", String.valueOf(c15grades.getFiftyTo54()));
        assertEquals("9", String.valueOf(c15grades.getFiftyFiveTo59()));
        assertEquals("13", String.valueOf(c15grades.getSixtyTo63()));
        assertEquals("10", String.valueOf(c15grades.getSixtyFourTo67()));
        assertEquals("10", String.valueOf(c15grades.getSixtyEightTo71()));
        assertEquals("7", String.valueOf(c15grades.getSeventyTwoTo75()));
        assertEquals("12", String.valueOf(c15grades.getSeventySixTo79()));
        assertEquals("15", String.valueOf(c15grades.getEightyTo84()));
        assertEquals("15", String.valueOf(c15grades.getEightyFiveTo89()));
        assertEquals("9" , String.valueOf(c15grades.getNinetyTo100()));
    }
}