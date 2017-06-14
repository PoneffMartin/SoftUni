import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by mponev on 6/7/16.
 */
public class CustomComparator {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            List<String> stringCollection = Arrays.asList(reader.readLine().split("\\s+"));
            List<Integer> numbers = new ArrayList<>();
            for (String number : stringCollection) {
                numbers.add(Integer.parseInt(number));
            }
            Comparator<Integer> sortOddAndEvenNumbers = new Comparator<Integer>() {
                @Override
                public int compare(Integer var1, Integer var2) {
                    Integer result = 0;
                    if (var1 % 2 == 0 && var2 % 2 != 0) {
                        result =  -1;
                    } else if (var1 % 2 != 0 && var2 % 2 == 0) {
                        result = 1;
                    } else {
                        result = var1.compareTo(var2);
                    }
                    return result;
                }
            };
            Collections.sort(numbers, sortOddAndEvenNumbers);
            for (Integer number : numbers) {
                System.out.printf("%d ", number);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
