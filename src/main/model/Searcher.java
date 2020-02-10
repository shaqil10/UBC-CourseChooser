package model;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Searcher {

    public static ArrayList<Course> searcher(ArrayList<Course> courseList,
                                             String subject, String yearLevel, double meanThreshold) {

        ArrayList<Course> searchResults = (ArrayList<Course>) courseList.stream()
                .filter(x -> subject.equals(x.getSubject())
                 && yearLevel.equals(x.getCourseNum().substring(0,1))
                && (meanThreshold <= x.getMean()))
                .collect(Collectors.toList());
        return searchResults;
    }


}
