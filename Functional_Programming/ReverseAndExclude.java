import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by mponev on 6/7/16.
 */
public class ReverseAndExclude {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        Consumer<Integer> reversedNumbers = number -> System.out.printf("%d ", number);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            stringCollection = Arrays.asList(reader.readLine().split("\\s+"));
            Integer divisor = Integer.parseInt(reader.readLine());
            for (int i = stringCollection.size() - 1; i >= 0; i--) {
                Integer currentNumber = Integer.parseInt(stringCollection.get(i));
                if (! (currentNumber % divisor == 0)) {
                    reversedNumbers.accept(currentNumber);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
