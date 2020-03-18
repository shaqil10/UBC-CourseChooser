package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

//represents a collection of courses
public class CourseList implements Saveable {
    ArrayList<Course> listCourse;

    //EFFECTS: Constructs a CourseList object with an ArrayList<Course> field
    public CourseList() {
        listCourse = new ArrayList<>();
    }

    public int getSize() {
        return listCourse.size();
    }

    //MODIFIES: this
    //EFFECTS: add the supplied Course c to the CourseList at the end of the list
    public void addCourse(Course c) {
        listCourse.add(c);
    }

    //MODIFIES: this
    //EFFECTS: removes the Course at the supplied index on the list and shifts the elements at higher indices back one
    //         if an index is provided that doesn't exist, an error is thrown
    public void removeCourse(int index) {
        listCourse.remove(index);
    }

    //MODIFIES: this
    //EFFECTS: removes the specified Course from the courseList
    //         if an index is provided that doesn't exist, an error is thrown
    public boolean removeCourse(Course course) {
        boolean result = listCourse.remove(course);
        return result;
    }

    //MODIFIES: this
    //EFFECTS: adds multiple Course objects supplied in the parameters to the CourseList
    public void addMultipleCourses(Course... args) {
        for (Course arg : args) {
            listCourse.add(arg);
        }
    }

    public ArrayList<Course> getListCourse() {
        return listCourse;
    }

    public Course getCourseAtIndex(int index) {
        return listCourse.get(index);
    }

    public boolean contains(Course c) {
        return listCourse.contains(c);
    }


    //EFFECTS: searches through this CourseList for courses that match the course subject, yearlevel, and an
    //         average greater than or equal to the meanThreshold supplied
    //         returns a new CourseList with the courses that match the criteria
    public CourseList searcher(String subject, String yearLevel, double meanThreshold) {
        ArrayList<Course> searchResults = (ArrayList<Course>) listCourse.stream()
                .filter(x -> subject.equals(x.getSubject())
                        && yearLevel.equals(x.getCourseNum().substring(0, 1))
                        && (meanThreshold <= x.getMean()))
                .collect(Collectors.toList());
        CourseList results = new CourseList();
        results.setListCourse(searchResults);
        return results;
    }


    public void setListCourse(ArrayList<Course> listCourse) {
        this.listCourse = listCourse;
    }

    @Override
    public void save(PrintWriter printWriter) {
        for (int i = 0; i < this.getSize(); i++) {
            if (i < (this.getSize() - 1)) {
                printWriter.print(this.getCourseAtIndex(i).getId());
                printWriter.print(Reader.DELIMITER);
            } else {
                printWriter.print(this.getCourseAtIndex(i).getId());
            }
        }
    }
}
