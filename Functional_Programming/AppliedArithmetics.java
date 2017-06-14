import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by mponev on 6/7/16.
 */
public class AppliedArithmetics {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        Function<Integer[], Integer[]> add = new Function<Integer[], Integer[]>() {
            @Override
            public Integer[] apply(Integer[] integers) {
                int i = 0;
                for (Integer integer : integers) {
                    integers[i] = integer + 1;
                    i++;
                }
                return integers;
            }
        };
        Function<Integer[], Integer[]> multiply = new Function<Integer[], Integer[]>() {
            @Override
            public Integer[] apply(Integer[] integers) {
                int i = 0;
                for (Integer integer : integers) {
                    integers[i] = integer * 2;
                    i++;
                }
                return integers;
            }
        };
        Function<Integer[], Integer[]> subtract = new Function<Integer[], Integer[]>() {
            @Override
            public Integer[] apply(Integer[] integers) {
                int i = 0;
                for (Integer integer : integers) {
                    integers[i] = integer - 1;
                    i++;
                }
                return integers;
            }
        };
        Consumer<Integer[]> printAll = new Consumer<Integer[]>() {
            @Override
            public void accept(Integer[] integers) {
                for (Integer integer : integers) {
                    System.out.printf("%d ", integer);
                }
                System.out.println();
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
            String command = reader.readLine();
            while (!command.equals("end")) {
                switch (command) {
                    case "add":
                        numbers = add.apply(numbers);
                        break;
                    case "multiply":
                        numbers = multiply.apply(numbers);
                        break;
                    case "subtract":
                        numbers = subtract.apply(numbers);
                        break;
                    case "print":
                        printAll.accept(numbers);
                        break;
                    default:
                        System.out.println("Invalid command");
                        break;
                }
                command = reader.readLine();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
