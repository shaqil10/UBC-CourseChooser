package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseDatabaseTest {
    CourseDatabase data;
    Course c1;

    @BeforeEach
    public void runBefore() {
        data = new CourseDatabase();
    }

    @Test
    public void testPopulateCourseList() {
        assertEquals(data.populateCourseList().size(),21);
    }
}