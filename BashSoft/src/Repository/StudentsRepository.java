package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;
import StaticData.SessionData;
import models.Course;
import models.Student;
import sun.awt.image.ImageWatched;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mponev on 19.05.16.
 */
public class StudentsRepository {
    public boolean isDataInitialized = false;
    private RepositoryFilter filter;
    private RepositorySorter sorter;
    private LinkedHashMap<String, Course> courses;
    private LinkedHashMap<String, Student> students;
    public StudentsRepository(RepositoryFilter filter, RepositorySorter sorter) {
        this.filter = filter;
        this.sorter = sorter;
    }
    public void loadData(String fileName)  throws IOException{
        if (this.isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }
        this.students = new LinkedHashMap<>();
        this.courses = new LinkedHashMap<>();
        this.readData(fileName);
    }
    public void unloadData() {
        if (!this.isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
        }
        this.students = null;
        this.courses = null;
        this.isDataInitialized = false;
    }
    private void readData(String fileName) throws IOException {
        String regex = "([A-Z][a-zA-Z#+]*_[A-Z][a-z]{2}_\\d{4})\\s+([A-Za-z]+\\d{2}_\\d{2,4})\\s+([\\s0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        String path = SessionData.currentPath  + "//" + fileName;
        List<String> lines = Files.readAllLines(Paths.get(path));
        // Scanner scanner = new Scanner(System.in);
        // String input = scanner.nextLine();
        for (String line : lines) {
            matcher = pattern.matcher(line);
            if  (!line.isEmpty() && matcher.find()) {
                String courseName = matcher.group(1);
                String studentName = matcher.group(2);
                String scoreString = matcher.group(3);
                try {
                    String [] splitScores = scoreString.split("\\+");
                    int[] scores = new int[scoreString.length()];
                    for (int i = 0; i < splitScores.length; i++) {
                        scores[i] = Integer.parseInt(splitScores[i]);
                    }
                    if (Arrays.stream(scores).anyMatch(score -> score > 100 || score < 0)) {
                        OutputWriter.displayException(ExceptionMessages.INVALID_SCORE);
                        continue;
                    }
                    if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
                        OutputWriter.displayException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
                        continue;
                    }
                    if (!this.students.containsKey(studentName)) {
                        this.students.put(studentName, new Student(studentName));
                    }
                    if (!this.courses.containsKey(courseName)) {
                        this.courses.put(courseName, new Course(courseName));
                    }
                    Course course = this.courses.get(courseName);
                    Student student = this.students.get(studentName);
                    student.enrollInCourse(course);
                    student.setMarksOnCourse(courseName, scores);
                    course.enrollStudent(student);
                } catch (NumberFormatException e) {
                    OutputWriter.displayException(e.getMessage() + " at line: " + line);
                }
            }
        }
        isDataInitialized = true;
        OutputWriter.writeMessageOnNewLine("Data read.");
    }

    private boolean isQueryForCoursePossible (String courseName){
        if (!isDataInitialized) {
            OutputWriter.displayException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }
        if (!courses.containsKey(courseName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_COURSE);
        }
        return true;
    }
    private boolean isQueryForStudentPossible (String courseName, String studentName){
        if (!isQueryForCoursePossible(courseName)){
            return false;
        }
        if (!this.courses.get(courseName).getStudentsByName().containsKey(studentName)) {
            OutputWriter.displayException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }
        return true;
    }
    public void getStudentMarkInCourse (String course, String studentName) {
        if (!isQueryForStudentPossible(course, studentName)){
            return;
        }
        double mark = this.courses.get(course).getStudentsByName()
                .get(studentName).getMarksByCourseName().get(course);
        OutputWriter.printStudent(studentName, mark);
    }
    public void getStudentsByCourse (String course) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }
        OutputWriter.writeMessageOnNewLine(course + ":");
        for (Map.Entry<String, Student> student : this.courses.get(course).getStudentsByName().entrySet()) {
            this.getStudentMarkInCourse(course, student.getKey());
        }
    }
    public void filterAndTake(String courseName, String filter) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        filterAndTake(courseName, filter, studentsToTake);
    }

    public void filterAndTake(
            String courseName, String filter, int studentsToTake) {
        if (!isQueryForCoursePossible(courseName)) {
            return;
        }
        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry : this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue().getMarksByCourseName().get(courseName));
        }
        this.filter.printFilteredStudents(marks, filter, studentsToTake);
    }

    public void orderAndTake(
            String courseName, String orderType, int studentsToTake) {
        if (!isQueryForCoursePossible(courseName)) {
            return;
        }
        LinkedHashMap<String, Double> marks = new LinkedHashMap<>();
        for (Map.Entry<String, Student> entry : this.courses.get(courseName).getStudentsByName().entrySet()) {
            marks.put(entry.getKey(), entry.getValue().getMarksByCourseName().get(courseName));
        }
        this.sorter.printSortedStudents(marks, orderType, studentsToTake);
    }

    public void orderAndTake(String courseName, String orderType) {
        int studentsToTake = this.courses.get(courseName).getStudentsByName().size();
        orderAndTake(courseName, orderType, studentsToTake);
    }
}
