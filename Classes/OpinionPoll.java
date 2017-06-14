import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by user on 6/22/16.
 */
public class Person {
    public String name = null;
    public int age = 0;
    public Person () {
        this("No name", 1);
    }
    public Person (int age) {
        this("No name" , age);
    }
    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        int linesCount = Integer.parseInt(reader.readLine());
        String inputLine = null;
        String name = null;
        int age = 0;
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < linesCount; i++) {
            inputLine = reader.readLine();
            String [] tokens = inputLine.split("\\s");
            name = tokens[0];
            age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            persons.add(person);
        }
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.name.compareTo(person2.name);
            }
        });
        for (Person person : persons) {
            if (person.age > 30)
                System.out.println(person.name + " - " + person.age);
        }
    }
}
