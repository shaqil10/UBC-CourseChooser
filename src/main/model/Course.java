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

}
