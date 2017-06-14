import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mponev on 01.06.16.
 */
public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern pattern = Pattern.compile("\\s?(\\+359(\\s|-)2\\2[0-9]{3}\\2[0-9]{4})\\b");
        Matcher matcher;
        String input = scanner.nextLine();
        while (!input.equals("end")) {
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                String phone = matcher.group(1);
                System.out.println(phone);
            }
            input = scanner.nextLine();
        }
    }
}
