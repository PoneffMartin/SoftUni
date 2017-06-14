package Repository;

import IO.OutputWriter;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by mponev on 06.06.16.
 */
public class RepositorySorter {
    public  void printSortedStudents (HashMap<String, Double> studentsWithMarks,
                                            String comparisonType,
                                            int numberOfStudents) {
        Comparator<Map.Entry<String, Double>> comparator = (x, y ) -> {
            double value1 = x.getValue();
            double value2 = y.getValue();
            return Double.compare(value1, value2);
        };
        List<String> sortedStudents = studentsWithMarks.entrySet()
                .stream()
                .sorted(comparator)
                .limit(numberOfStudents)
                .map(x -> x.getKey())
                .collect(Collectors.toList());
        if (comparisonType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }
        printStudents(studentsWithMarks, sortedStudents);
    }
    private static void printStudents(HashMap<String, Double> studentsWithMarks, List<String> sortedStudents) {
        for (String student : sortedStudents) {
            OutputWriter.printStudent(student, studentsWithMarks.get(student));
        }
    }
}
