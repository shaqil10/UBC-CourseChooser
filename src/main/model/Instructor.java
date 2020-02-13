package model;

// models an instructor who teaches a course and their rating from RateMyProfessor
public class Instructor {
    private String name;
    private String rating;

    public Instructor(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }
    // second field for link to RateMyProfessor
    // possibly a field that grabs the Professor Rating


    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }
}
