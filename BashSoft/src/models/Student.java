package models;

import Exceptions.DuplicateEntryInStructureException;
import Exceptions.InvalidStringException;
import Exceptions.KeyNotFoundException;
import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mponev on 25.06.16.
 */
public class Student {
    private String userName;
    private LinkedHashMap<String, Course> enrolledCourses;
    private LinkedHashMap<String, Double> marksByCourseName;
    public Student (String userName) {
        this.setUserName(userName);
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }
    public String getUserName() {
        return userName;
    }
    public Map<String, Course> getEnrolledCourses() {
        return Collections.unmodifiableMap(this.enrolledCourses);
    }
    public Map<String, Double> getMarksByCourseName() {
        return Collections.unmodifiableMap(this.marksByCourseName);
    }
    private void setUserName (String userName) {
        if (userName == null || userName.equals("")) {
            throw new InvalidStringException();
        }
        this.userName = userName;
    }
    public void enrollInCourse (Course course) {
        if (this.enrolledCourses.containsKey(course.getName())) {
            throw new DuplicateEntryInStructureException(this.userName, course.getName());
        }
        this.enrolledCourses.put(course.getName(), course);
    }
    public void setMarksOnCourse (String courseName, int... scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
            throw new KeyNotFoundException();
        }
        if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
            OutputWriter.displayException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
            return;
        }
        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }
    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSolvedExam * 4 + 2;
        return mark;
    }
}
