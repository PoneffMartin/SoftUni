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
public class CustomMinFunction {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        Function<Integer[], Integer> findMin = new Function<Integer[], Integer>() {
            @Override
            public Integer apply(Integer[] integers) {
                Integer min = Integer.MAX_VALUE;
                for (Integer integer : integers) {
                    if (integer < min) {
                        min = integer;
                    }
                }
                return min;
            }
        };
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            stringCollection = Arrays.asList(reader.readLine().split("\\s+"));
            Integer [] numbers = new Integer[stringCollection.size()];
            int i = 0;
            for (String number : stringCollection) {
                numbers[i] = Integer.parseInt(number);
                i++;
            }
            Integer minValue = findMin.apply(numbers);
            System.out.println(minValue);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
