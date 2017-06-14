import java.lang.reflect.Field;

/**
 * Created by user on 6/22/16.
 */
public class Person {
    private String name = null;
    private Integer age = null;
    public Person() {

    }
    public static void main(String[] args) throws Exception {
        Class person = Class.forName("Person");
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length);
    }
}
