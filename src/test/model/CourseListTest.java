package model;
import ui.CourseChooser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseListTest {
    CourseList testList;
    Course c20;
    Course c19;
    Course c18;
    Course c17;
    Course c16;
    Course c15;
    Course c14;
    Course c13;
    Course c12;
    Course c11;
    Course c10;
    Course c9;
    Course c8;
    Course c7;
    Course c6;
    Course c5;
    Course c4;
    Course c3;
    Course c2;
    Course c1;
    CourseList testDatabase;

    @BeforeEach
    public void runBefore() {
        testDatabase = new CourseList();
        testList = new CourseList();
        c1 = CourseChooser.getC1();

        c2 = CourseChooser.getC2();
        c3 = CourseChooser.getC3();
        c4 = CourseChooser.getC4();
        c5 = CourseChooser.getC5();

        //CPSC:
        c6 = CourseChooser.getC6();

        c7 = CourseChooser.getC7();
        c8 = CourseChooser.getC8();
        c9 = CourseChooser.getC9();
        c10 = CourseChooser.getC10();


        //COMM:
        c11 = CourseChooser.getC11();
        c12 = CourseChooser.getC12();
        c13 = CourseChooser.getC13();
        c14 = CourseChooser.getC14();
        c15 = CourseChooser.getC15();

        //CHEM:
        c16 = CourseChooser.getC16();
        c17 = CourseChooser.getC17();
        c18 = CourseChooser.getC18();
        c19 = CourseChooser.getC19();

        testDatabase.addMultipleCourses(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19);
    }

    @Test
    public void testGetSize() {
        assertEquals(0, testList.getSize());
        assertEquals(19,testDatabase.getSize());
        testList.addCourse(c16);
        testList.addCourse(c17);
        assertEquals(2, testList.getSize());
    }
    @Test
    public void testAddCourse() {
        testList.addCourse(c16);
        assertEquals(1,testList.getSize());
        assertEquals(c16,testList.getCourseAtIndex(0));
        testList.addCourse(c17);
        assertEquals(2,testList.getSize());
        assertEquals(c17,testList.getCourseAtIndex(1));
    }

    @Test
    public void testRemoveCourseIndex() {
        testList.addMultipleCourses(c16,c17,c18);
        assertEquals(3,testList.getSize());
        testList.removeCourse(1);
        assertEquals(2, testList.getSize());
        assertTrue(testList.contains(c16));
        assertFalse(testList.contains(c17));
        assertTrue(testList.contains(c18));
    }

    @Test
    public void testRemoveCourse() {
        testList.addMultipleCourses(c16,c17,c18);
        assertEquals(3,testList.getSize());
        assertTrue(testList.removeCourse(c17));
        assertTrue(testList.contains(c16));
        assertFalse(testList.contains(c17));
        assertTrue(testList.contains(c18));
        assertFalse(testList.removeCourse(c15));
        assertEquals(2,testList.getSize());
        testList.removeCourse(0);
        assertEquals(1,testList.getSize());
        assertTrue(testList.contains(c18));
    }

    @Test
    public void testAddMultipleCourses() {
        testList.addMultipleCourses(c16,c17,c18);
        assertEquals(3,testList.getSize());
        assertTrue(testList.contains(c16));
        assertTrue(testList.contains(c17));
        assertTrue(testList.contains(c18));
    }

    @Test
    public void testContains() {
        testList.addMultipleCourses(c16,c18);
        assertTrue(testList.contains(c16));
        assertFalse(testList.contains(c17));
        assertTrue(testList.contains(c18));
    }

    @Test
    public void testGetCourseAtIndex() {
        testList.addMultipleCourses(c16,c17);
        assertEquals(c16,testList.getCourseAtIndex(0));
        assertEquals(c17,testList.getCourseAtIndex(1));
    }

    @Test
    public void testSetListCourse() {
        ArrayList<Course> dummyList = new ArrayList<>();
        dummyList.add(c1);
        dummyList.add(c7);
        dummyList.add(c20);
        testList.setListCourse(dummyList);
        assertEquals(dummyList, testList.getListCourse());
    }

    @Test
    public void testSubjectFilter() {
        CourseList result = testDatabase.searcher("MATH", "1", 0.0);
        assertEquals(result.getSize(), 4);
        assertEquals(c1,result.getCourseAtIndex(0));
        assertEquals(c2,result.getCourseAtIndex(1));
        assertEquals(c3,result.getCourseAtIndex(2));
        assertEquals(c4,result.getCourseAtIndex(3));
        for (Course i : result.getListCourse()) {
            System.out.println(i.getId());
        }
    }

    @Test
    public void testAllFilters1() {
        CourseList result = testDatabase.searcher("CPSC", "2", 75);
        assertEquals(2, result.getSize());
        assertEquals(c7,result.getCourseAtIndex(0));
        assertEquals(c8,result.getCourseAtIndex(1));
        for (Course i : result.getListCourse()) {
            System.out.println(i.getId());
        }
    }

    @Test
    public void testAllFilters2() {
        CourseList result = testDatabase.searcher("CHEM", "4", 85);
        assertEquals(1, result.getSize());
        assertTrue(result.contains(c19));
        for (Course i : result.getListCourse()) {
            System.out.println(i.getId());
        }
    }

    @Test
    public void testAllFilters3Fail() {
        CourseList result = testDatabase.searcher("COMM", "3", 100);
        assertEquals(0, result.getSize());
        for (Course i : result.getListCourse()) {
            System.out.println(i.getId());
        }
    }
}