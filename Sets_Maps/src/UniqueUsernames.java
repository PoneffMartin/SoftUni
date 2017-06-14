import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by mponev on 18.05.16.
 */
public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int amountOfNames = console.nextInt();
        console.nextLine();
        LinkedHashSet<String> setOfNames = new LinkedHashSet<>();
        for (int i = 0; i < amountOfNames; i++) {
            String inputLine = console.nextLine();
            setOfNames.add(inputLine);
        }
        for (String name : setOfNames) {
            System.out.println(name);
        }
    }
}
