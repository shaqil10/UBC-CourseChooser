package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsTest {
    Course c15;
    Stats c15stats;


    @BeforeEach
    public void runBefore() {
        c15 = new Course("UBC-2017W-COMM-457-101", "2017W", "COMM", "457",
                "101", "FNDTLS FIN ACCT", new Instructor("Sinclair, Scott", "4.5/5"),
                121, new Stats(70.34, 14.74, 99, 32, 107, 11, 3),
                new Grades(0, 0, 0, 2, 9, 11, 7,
                        9, 13, 10, 10, 7, 12,
                        15, 15, 9));
        c15stats = c15.getStats();
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