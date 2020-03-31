package model;

// models a course's statistics that are provided from UBC Pair
public class Stats {
    Course course;
    private double average;
    private double stDev;
    private int high;
    private int low;
    private int pass;
    private int fail;
    private int withdrew;

    public Stats(Course course, double average, double stDev, int high, int low, int pass, int fail, int withdrew) {
        this.course = course;
        this.average = average;
        this.stDev = stDev;
        this.high = high;
        this.low = low;
        this.pass = pass;
        this.fail = fail;
        this.withdrew = withdrew;

    }

    //MODIFIES: this, course
    //EFFECTS: assigns these statistics to a course
    public void setCourse(Course course) {
        if ((isCourseNull()) || (course.getStats() == null) || (course.getStats() != this) || (this.course != course)) {
            this.course = course;
            course.setStats(this);
        }
    }

    public boolean isCourseNull() {
        return (this.course == null);
    }

    public Course getCourse() {
        return course;
    }

    public double getAverage() {
        return average;
    }

    public double getStDev() {
        return stDev;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
    }

    public int getPass() {
        return pass;
    }

    public int getFail() {
        return fail;
    }

    public int getWithdrew() {
        return withdrew;
    }

}
