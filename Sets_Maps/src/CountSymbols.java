import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by mponev on 18.05.16.
 */
public class CountSymbols {
    public static void main(String[] args) {
        Scanner  console = new Scanner(System.in);
        TreeMap<Character, Integer> charOccurences = new TreeMap<>();
        String line = console.nextLine();
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (charOccurences.containsKey(ch)){
                int count = charOccurences.get(ch);
                charOccurences.put(ch, count + 1);
            } else {
                charOccurences.put(ch, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : charOccurences.entrySet()) {
            System.out.printf("%c: %d time/s\n", entry.getKey(), entry.getValue());
        }
    }
}
