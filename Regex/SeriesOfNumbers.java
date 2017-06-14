import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mponev on 01.06.16.
 */
public class SeriesOfNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("([a-zA-Z])(\\1{1,})");
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            input = matcher.replaceAll("$1");
            System.out.println(input);
        }
    }
}
