import java.util.Scanner;

/**
 * Created by mponev on 28.05.16.
 */
public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word1 = scanner.next();
        String word2 = scanner.next();
        String longerString = word1.length() <= word2.length()? word2:word1;
        String shorterString = word1.length() <= word2.length()? word1:word1;
        long sum = 0;
        for (int i = 0; i < shorterString.length(); i++) {
            sum += word1.charAt(i) * word2.charAt(i);
        }
        if (word1.length() != word2.length()) {
            for (int i = shorterString.length(); i < longerString.length(); i++) {
                sum += longerString.charAt(i);
            }
        }
        System.out.println(sum);
    }
}
