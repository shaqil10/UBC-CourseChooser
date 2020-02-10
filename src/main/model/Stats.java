package model;

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
}
