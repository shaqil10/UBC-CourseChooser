package model;

//models the in-depth grade distributions provided from UBC Pair
public class Grades {
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

    public Grades(int zeroTo9, int tenTo19, int twentyTo29, int thirtyTo39, int fortyTo49, int lessThan50,
                  int fiftyTo54, int fiftyFiveTo59, int sixtyTo63, int sixtyFourTo67, int sixtyEightTo71,
                  int seventyTwoTo75, int seventySixTo79, int eightyTo84, int eightyFiveTo89, int ninetyTo100) {
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

    //EFFECTS: Prints out all of the grade distribution values of a given Course
    public String gradesToString() {
        System.out.println("0-9 %    : " + String.valueOf(getZeroTo9()));
        System.out.println("10-19 %  : " + String.valueOf(getTenTo19()));
        System.out.println("20-29 %  : " + String.valueOf(getTwentyTo29()));
        System.out.println("30-39 %  : " + String.valueOf(getThirtyTo39()));
        System.out.println("40-49 %  : " + String.valueOf(getFortyTo49()));
        System.out.println("<50 %    : " + String.valueOf(getLessThan50()));
        System.out.println("50-54 %  : " + String.valueOf(getFiftyTo54()));
        System.out.println("55-59 %  : " + String.valueOf(getFiftyFiveTo59()));
        System.out.println("60-63 %  : " + String.valueOf(getSixtyTo63()));
        System.out.println("64-67 %  : " + String.valueOf(getSixtyFourTo67()));
        System.out.println("68-71 %  : " + String.valueOf(getSixtyEightTo71()));
        System.out.println("72-75 %  : " + String.valueOf(getSeventyTwoTo75()));
        System.out.println("76-79 %  : " + String.valueOf(getSeventySixTo79()));
        System.out.println("80-84 %  : " + String.valueOf(getEightyTo84()));
        System.out.println("85-89 %  : " + String.valueOf(getEightyFiveTo89()));
        System.out.println("90-100 % : " + String.valueOf(getNinetyTo100()));
        return "Yay";
    }

}
