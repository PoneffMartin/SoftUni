import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mponev on 01.06.16.
 */
public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(\\w[\\w\\-_\\.]*\\w)@([a-zA-Z][a-zA-Z-]*[a-zA-Z])\\.([a-zA-Z][a-zA-Z-]*[a-zA-Z])(\\.([a-zA-Z][a-zA-Z-]*[a-zA-Z]))?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {

            System.out.println(matcher.group());
        }
    }
}
