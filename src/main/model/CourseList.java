package model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CourseList {
    ArrayList<Course> listCourse;

    public CourseList() {
        listCourse = new ArrayList<>();
    }

    public int getSize() {
        return listCourse.size();
    }

    public void addCourse(Course c) {
        listCourse.add(c);
    }

    public void removeCourse(int index) {
        listCourse.remove(index);
    }

    public void addMultipleCourses(Course...args) {
        for (Course arg: args) {
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

    public CourseList searcher(String subject, String yearLevel, double meanThreshold) {
        ArrayList<Course> searchResults = (ArrayList<Course>) listCourse.stream()
                .filter(x -> subject.equals(x.getSubject())
                        && yearLevel.equals(x.getCourseNum().substring(0,1))
                        && (meanThreshold <= x.getMean()))
                .collect(Collectors.toList());
        CourseList results = new CourseList();
        results.setListCourse(searchResults);
        return results;
    }


    public void setListCourse(ArrayList<Course> listCourse) {
        this.listCourse = listCourse;
    }
}
