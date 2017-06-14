import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by mponev on 6/7/16.
 */
public class ConsumerPrint {
    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        Consumer<String> consumer = word -> System.out.println(word);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            stringCollection = Arrays.asList(reader.readLine().split(" "));
            for (String s : stringCollection) {
                consumer.accept(s);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
