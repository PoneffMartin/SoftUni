import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mponev on 01.06.16.
 */
public class SentenceExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyword = scanner.nextLine();
        String text = scanner.nextLine();
        Pattern sentenceRegex = Pattern.compile("([^\\.!?]*[\\.!?])");
        Pattern keywordRegex = Pattern.compile("\\s" + keyword + "\\s");
        Matcher matcher = sentenceRegex.matcher(text);
        while (matcher.find()) {
            String sentence = matcher.group();
            Matcher keywordMatcher = keywordRegex.matcher(sentence);
            if (keywordMatcher.find()) {
                System.out.println(sentence);
            }
        }
    }
}
