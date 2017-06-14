import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * Created by mponev on 18.05.16.
 */
public class Phonebook {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        LinkedHashMap<String, String> phonebook = new LinkedHashMap<>();
        while (!input.equals("search")){
            String [] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            phonebook.put(name, number);
            input = console.nextLine();
        }
        input = console.nextLine();
        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)){
                System.out.printf("%s -> %s\n", input, phonebook.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }
            input = console.nextLine();
        }
    }
}
