import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by mponev on 6/7/16.
 */
public class FindSmallestElement {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        Function<Integer[], Integer> findMinElementIndex = new Function<Integer[], Integer>() {
            @Override
            public Integer apply(Integer[] integers) {
                Integer min = Integer.MAX_VALUE;
                int index = 0;
                int minIndex = 0;
                for (Integer integer : integers) {
                    if (integer <= min) {
                        min = integer;
                        minIndex = index;
                    }
                    index ++;
                }
                return minIndex;
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
            Integer minElementIndex = findMinElementIndex.apply(numbers);
            System.out.println(minElementIndex);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
