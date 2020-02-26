package persistence;

import model.Course;
import model.CourseList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static final String DELIMITER = ",";

    //EFFECTS: returns a worklist parsed from file; throws
    // IOException if an exception is raised when opening/reading from file
    public static CourseList readWorklist(File file, CourseList database) throws IOException {
        String fileContent = readFile(file);
        return parseContent(fileContent, database);
    }


    //EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file, **but will only return the first element for now
    // as only one worklist will allowed to be saved currently**
    private static String readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath()).get(0);
    }

    //EFFECTS: returns a worklist parsed from a single string containing its data
    private static CourseList parseContent(String fileContent, CourseList database) {
        ArrayList<String> lineComponents = splitString(fileContent);
        return parseWorklist(lineComponents, database);
    }

    //EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    //**add break or something to remove redundant searching**
    //EFFECTS: returns a new worklist by parsing a list of strings containing the ID's of each course in the list
    // and matching them to the corresponding course in the database and adding it to the worklist
    private static CourseList parseWorklist(List<String> components, CourseList database) {
        CourseList savedWorklist = new CourseList();
        for (String i : components) {
            for (Course c : database.getListCourse()) {
                if (i.equals(c.getId())) {
                    savedWorklist.addCourse(c);
                    break;
                }
            }
        }
        return savedWorklist;
    }

}