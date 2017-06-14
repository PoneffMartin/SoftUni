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
public class EvensOrOdds {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        Consumer<String> consumer = word -> System.out.println("Sir " + word);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            stringCollection = Arrays.asList(reader.readLine().split("\\s+"));
            Integer lowBound = Integer.parseInt(stringCollection.get(0));
            Integer upperBound = Integer.parseInt(stringCollection.get(1));
            String command = reader.readLine();
            printNumbers(lowBound, upperBound, command, number -> number % 2 == 0);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    public static void printNumbers (int lowerBound,
                                     int upperBound,
                                     String command,
                                     Predicate<Integer> isEven) {
        if (command.equals("even")) {
            for (int i = lowerBound; i <= upperBound; i++) {
                if (isEven.test(i)) {
                    System.out.printf("%d ", i);
                }
            }
        } else {
            for (int i = lowerBound; i <= upperBound; i++) {
                if (!isEven.test(i)) {
                    System.out.printf("%d ", i);
                }
            }
        }
    }
}
