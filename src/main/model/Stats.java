package model;

// models a course's statistics that are provided from UBC Pair
public class Stats {
    private double average;
    private double stDev;
    private int high;
    private int low;
    private int pass;
    private int fail;
    private int withdrew;

    public Stats(double average, double stDev, int high, int low, int pass, int fail, int withdrew) {

        this.average = average;
        this.stDev = stDev;
        this.high = high;
        this.low = low;
        this.pass = pass;
        this.fail = fail;
        this.withdrew = withdrew;

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

    //EFFECTS: Prints out all of the statistics for a given course
    public String statsToString() {
        System.out.println("Mean     : " + String.valueOf(getAverage()));
        System.out.println("StDev    : " + String.valueOf(getStDev()));
        System.out.println("High     : " + String.valueOf(getHigh()));
        System.out.println("Low      : " + String.valueOf(getLow()));
        System.out.println("Pass     : " + String.valueOf(getPass()));
        System.out.println("Fail     : " + String.valueOf(getFail()));
        System.out.println("Withdrew : " + String.valueOf(getWithdrew()));
        return "Yay";
    }
}
