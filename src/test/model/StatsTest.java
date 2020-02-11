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
    public void testGetters() {
        assertEquals(70.34, c15stats.getAverage());
        assertEquals(14.74, c15stats.getStDev());
        assertEquals(99, c15stats.getHigh());
        assertEquals(32, c15stats.getLow());
        assertEquals(107, c15stats.getPass());
        assertEquals(11,c15stats.getFail());
        assertEquals(3, c15stats.getWithdrew());

    }
}