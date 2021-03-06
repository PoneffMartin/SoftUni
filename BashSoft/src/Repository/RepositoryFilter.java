package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

/**
 * Created by mponev on 06.06.16.
 */
public class RepositoryFilter {
    public void printFilteredStudents (HashMap<String, Double> studentsWithMarks,
                                              String filterType,
                                       Integer numberOfStudents) {
        Predicate<Double> filter = createFilter(filterType);
        if (filter == null) {
            OutputWriter.displayException(ExceptionMessages.INVALID_FILTER);
            return;
        }
        int studentsCount = 0;
        for (String student : studentsWithMarks.keySet()) {
            if (studentsCount >= numberOfStudents) {
                break;
            }

            Double mark = studentsWithMarks.get(student);
            if (filter.test(mark) == true) {
                OutputWriter.printStudent(student, mark);
                studentsCount++;
            }
        }
    }
    private Predicate<Double> createFilter (String filterType) {
        switch (filterType) {
            case "excellent":
                return mark -> mark >= 5.0;
            case "average":
                return mark -> mark >= 3.5 && mark < 5.0;
            case "poor":
                return mark -> mark < 3.5;
            default:
                return null;
        }
    }
}
