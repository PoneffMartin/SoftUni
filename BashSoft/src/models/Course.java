package models;

import Exceptions.DuplicateEntryInStructureException;
import Exceptions.InvalidStringException;
import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mponev on 25.06.16.
 */
public class Course {
    public static final int NUMBER_OF_TASKS_ON_EXAM = 5;
    public static final int MAX_SCORE_ON_EXAM_TASK  = 100;
    private String name;
    private LinkedHashMap<String, Student> studentsByName;
    public Course (String name) {
        this.name = name;
        this.studentsByName = new LinkedHashMap<>();
    }
    public String getName() {
        return this.name;
    }
    public Map<String, Student> getStudentsByName() {
        return Collections.unmodifiableMap(this.studentsByName);
    }
    private void setUserName (String userName) {
        if (userName == null || userName.equals("")) {
            throw new InvalidStringException();
        }
        this.name = userName;
    }
    public void enrollStudent (Student student) {
        if (this.studentsByName.containsKey(student.getUserName())) {
            throw new DuplicateEntryInStructureException(student.getUserName(), this.name);
        }
        this.studentsByName.put(student.getUserName(), student);
    }
}
