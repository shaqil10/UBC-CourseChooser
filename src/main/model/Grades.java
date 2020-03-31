package model;

import javax.swing.*;

//models the in-depth grade distributions provided from UBC Pair
public class Grades {
    Course course;
    private int zeroTo9;
    private int tenTo19;
    private int twentyTo29;
    private int thirtyTo39;
    private int fortyTo49;
    private int lessThan50;
    private int fiftyTo54;
    private int fiftyFiveTo59;
    private int sixtyTo63;
    private int sixtyFourTo67;
    private int sixtyEightTo71;
    private int seventyTwoTo75;
    private int seventySixTo79;
    private int eightyTo84;
    private int eightyFiveTo89;
    private int ninetyTo100;

    public Grades(Course course, int zeroTo9, int tenTo19, int twentyTo29, int thirtyTo39, int fortyTo49,
                  int lessThan50, int fiftyTo54, int fiftyFiveTo59, int sixtyTo63, int sixtyFourTo67,
                  int sixtyEightTo71, int seventyTwoTo75, int seventySixTo79, int eightyTo84, int eightyFiveTo89,
                  int ninetyTo100) {
        this.course = course;
        this.zeroTo9 = zeroTo9;
        this.tenTo19 = tenTo19;
        this.twentyTo29 = twentyTo29;
        this.thirtyTo39 = thirtyTo39;
        this.fortyTo49 = fortyTo49;
        this.lessThan50 = lessThan50;
        this.fiftyTo54 = fiftyTo54;
        this.fiftyFiveTo59 = fiftyFiveTo59;
        this.sixtyTo63 = sixtyTo63;
        this.sixtyFourTo67 = sixtyFourTo67;
        this.sixtyEightTo71 = sixtyEightTo71;
        this.seventyTwoTo75 = seventyTwoTo75;
        this.seventySixTo79 = seventySixTo79;
        this.eightyTo84 = eightyTo84;
        this.eightyFiveTo89 = eightyFiveTo89;
        this.ninetyTo100 = ninetyTo100;
    }

    //MODIFIES: this, course
    //EFFECTS: assigns these grades to a course
    public void setCourse(Course course) {
        if (isCourseNull() || (course.getGrades() == null) || (course.getGrades() != this) || (this.course != course)) {
            this.course = course;
            course.setGrades(this);
        }
    }

    public boolean isCourseNull() {
        return (this.course == null);
    }

    public int getZeroTo9() {
        return zeroTo9;
    }

    public int getTenTo19() {
        return tenTo19;
    }

    public int getTwentyTo29() {
        return twentyTo29;
    }

    public int getThirtyTo39() {
        return thirtyTo39;
    }

    public int getFortyTo49() {
        return fortyTo49;
    }

    public int getLessThan50() {
        return lessThan50;
    }

    public int getFiftyTo54() {
        return fiftyTo54;
    }

    public int getFiftyFiveTo59() {
        return fiftyFiveTo59;
    }

    public int getSixtyTo63() {
        return sixtyTo63;
    }

    public int getSixtyFourTo67() {
        return sixtyFourTo67;
    }

    public int getSixtyEightTo71() {
        return sixtyEightTo71;
    }

    public int getSeventyTwoTo75() {
        return seventyTwoTo75;
    }

    public int getSeventySixTo79() {
        return seventySixTo79;
    }

    public int getEightyTo84() {
        return eightyTo84;
    }

    public int getEightyFiveTo89() {
        return eightyFiveTo89;
    }

    public int getNinetyTo100() {
        return ninetyTo100;
    }

    public Course getCourse() {
        return course;
    }
}
