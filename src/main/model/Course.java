package model;

import javax.swing.*;

//represents a course with all the necessary fields that UBC Pair supplies from grade distributions
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

    // REQUIRES: option must be on of "General Info", "Grade Distribution", or "Statistics"
    // MODIFIES: infoDisplay
    // EFFECTS: appends the information, grades, or stats of this course onto infoDisplay based on the option provided
    public void toString(JTextArea infoDisplay, String option) {
        switch (option) {
            case "General Info":
                infoToString(infoDisplay);
                break;

            case "Grade Distribution":
                gradesToString(infoDisplay);
                break;

            case "Statistics":
                statsToString(infoDisplay);
                break;
        }
    }

    //MODIFIES: this, stats
    //EFFECTS: assigns these stats to the course
    public void setStats(Stats stats) {
        if ((isStatsNull()) || (stats.getCourse() == null) || (stats.getCourse() != this) || (this.stats != stats)) {
            this.stats = stats;
            stats.setCourse(this);
        }
    }

    public boolean isStatsNull() {
        return (this.stats == null);
    }

    //MODIFIES: this, grade
    //EFFECTS: assigns these grades to the course
    public void setGrades(Grades grade) {
        if ((!isGradesNull()) && (grades.getCourse() != null)
                && (grades.getCourse() == this) && (this.grades == grade)) {
            return;
        }
        this.grades = grade;
        grade.setCourse(this);
    }

    public boolean isGradesNull() {
        return (this.grades == null);
    }

    //EFFECTS: Prints out all of the general information for a course onto infoDisplay
    public String infoToString(JTextArea infoDisplay) {
        infoDisplay.append("Course ID :               " + getId() + "\n");
        infoDisplay.append("YearSession :           " + getYearsession() + "\n");
        infoDisplay.append("Subject :                    " + getSubject() + "\n");
        infoDisplay.append("Course Code :         " + getCourseNum() + "\n");
        infoDisplay.append("Section :                   " + getSection() + "\n");
        infoDisplay.append("Course Name :         " + getTitle() + "\n");
        infoDisplay.append("Instructor :                  " + getInstructor().getName() + "\n");
        infoDisplay.append("RateMyProfessor :   " + getInstructor().getRating() + "\n");
        infoDisplay.append("Enrolled :                   " + String.valueOf(getEnrolled()) + "\n");
        return infoDisplay.getText();
    }

    //EFFECTS: Prints out all of the statistics for a given course onto infoDisplay
    public String statsToString(JTextArea infoDisplay) {
        infoDisplay.append("Mean :      " + String.valueOf(stats.getAverage()) + "\n");
        infoDisplay.append("StDev :     " + String.valueOf(stats.getStDev()) + "\n");
        infoDisplay.append("High :        " + String.valueOf(stats.getHigh()) + "\n");
        infoDisplay.append("Low :         " + String.valueOf(stats.getLow()) + "\n");
        infoDisplay.append("Pass :       " + String.valueOf(stats.getPass()) + "\n");
        infoDisplay.append("Fail :          " + String.valueOf(stats.getFail()) + "\n");
        infoDisplay.append("Withdrew : " + String.valueOf(stats.getWithdrew()) + "\n");
        return infoDisplay.getText();
    }

    //EFFECTS: Prints out all of the grade distribution values of a given Course onto infoDisplay
    public String gradesToString(JTextArea infoDisplay) {
        infoDisplay.append("0-9 %        : " + String.valueOf(grades.getZeroTo9()) + "\n");
        infoDisplay.append("10-19 %   : " + String.valueOf(grades.getTenTo19()) + "\n");
        infoDisplay.append("20-29 %   : " + String.valueOf(grades.getTwentyTo29()) + "\n");
        infoDisplay.append("30-39 %   : " + String.valueOf(grades.getThirtyTo39()) + "\n");
        infoDisplay.append("40-49 %   : " + String.valueOf(grades.getFortyTo49()) + "\n");
        infoDisplay.append("<50 %       : " + String.valueOf(grades.getLessThan50()) + "\n");
        infoDisplay.append("50-54 %   : " + String.valueOf(grades.getFiftyTo54()) + "\n");
        infoDisplay.append("55-59 %   : " + String.valueOf(grades.getFiftyFiveTo59()) + "\n");
        infoDisplay.append("60-63 %   : " + String.valueOf(grades.getSixtyTo63()) + "\n");
        infoDisplay.append("64-67 %   : " + String.valueOf(grades.getSixtyFourTo67()) + "\n");
        infoDisplay.append("68-71 %   : " + String.valueOf(grades.getSixtyEightTo71()) + "\n");
        infoDisplay.append("72-75 %   : " + String.valueOf(grades.getSeventyTwoTo75()) + "\n");
        infoDisplay.append("76-79 %   : " + String.valueOf(grades.getSeventySixTo79()) + "\n");
        infoDisplay.append("80-84 %   : " + String.valueOf(grades.getEightyTo84()) + "\n");
        infoDisplay.append("85-89 %   : " + String.valueOf(grades.getEightyFiveTo89()) + "\n");
        infoDisplay.append("90-100 % : " + String.valueOf(grades.getNinetyTo100()) + "\n");
        return infoDisplay.getText();
    }
}
