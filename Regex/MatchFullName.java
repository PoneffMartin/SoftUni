import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mponev on 01.06.16.
 */
public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\b([A-Z][a-z]+) ([A-Z][a-z]+)\\b");
        Matcher matcher;
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            matcher = pattern.matcher(input);
            if (matcher.find()){
                String fullName = matcher.group(1) + " " + matcher.group(2);
                System.out.println(fullName);
            }
            input = scanner.nextLine();
        }
    }
}
