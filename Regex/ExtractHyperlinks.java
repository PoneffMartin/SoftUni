import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mponev on 6/2/16.
 */
public class ExtractHyperlinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "<a\\s+([^>]+\\s+)?href\\s*=\\s*('([^']*)'|\"([^\"]*)\"|([^\\s>]+))[^>]*>";
        Pattern hyperlinkPattern = Pattern.compile(regex);
        Matcher matcher;
        StringBuilder line = new StringBuilder();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            line.append(input);
            input = scanner.nextLine();
        }
        matcher = hyperlinkPattern.matcher(line);
        while (matcher.find()) {
            String output = matcher.group(3);
            if (output == null) {
                output = matcher.group(4);
            }
            if (output == null) {
                output = matcher.group(5);
            }
            System.out.println(output);
        }
    }
}
