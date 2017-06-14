import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by mponev on 6/7/16.
 */
public class PredicateForNames {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        Consumer<Integer> reversedNumbers = number -> System.out.printf("%d ", number);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Integer length = Integer.parseInt(reader.readLine());
            stringCollection = Arrays.asList(reader.readLine().split("\\s+"));
            Predicate<String> isLengthLessOrEqual = name -> name.length() <= length;
            for (int i = 0; i < stringCollection.size(); i++) {
                String name = stringCollection.get(i);
                if (isLengthLessOrEqual.test(name)) {
                    System.out.println(name);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
