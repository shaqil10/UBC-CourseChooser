package model;

public class Course {
    private String id;
    private String yearsession;
    private String subject;
    private String coursenum;
    private String section;
    private String title;
    private Instructor instructor;
    private int enrolled;
    private Stats stats;
    private Grades grades;

    public Course(String id, String yearsession, String subject, String coursenum, String section,
                  String title, Instructor instructor, int enrolled, Stats stats, Grades grades) {
        this.id = id;
        this.yearsession = yearsession;
        this.subject = subject;
        this.coursenum = coursenum;
        this.section = section;
        this.title = title;
        this.instructor = instructor;
        this.enrolled = enrolled;
        this.stats = stats;
        this.grades = grades;
    }

    public String getSubject() {
        return subject;
    }

    public String getId() {
        return id;
    }

    public String getCourseNum() {
        return coursenum;
    }

    public double getMean() {
        return stats.getAverage();
    }

    public Grades getGrades() {
        return grades;
    }

    public String getYearsession() {
        return yearsession;
    }

    public String getSection() {
        return section;
    }

    public String getTitle() {
        return title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public int getEnrolled() {
        return enrolled;
    }

    public Stats getStats() {
        return stats;
    }

    public void infoToString() {
        System.out.println("Course ID   : " + getId());
        System.out.println("YearSession : " + getYearsession());
        System.out.println("Subject     : " + getSubject());
        System.out.println("Course Code : " + getCourseNum());
        System.out.println("Section     : " + getSection());
        System.out.println("Course Name : " + getTitle());
        System.out.println("Instructor  : " + getInstructor().getName());
        System.out.println("Enrolled    : " + String.valueOf(getEnrolled()));
    }
}
