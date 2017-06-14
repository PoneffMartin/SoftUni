import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mponev on 6/2/16.
 */
public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] tokens = input.split("[,\\\\/\\(\\) ]+");
        Pattern nameRegex = Pattern.compile("\\b([a-zA-Z][\\w_]{2,24})\\b");
        List<String> validNames = new ArrayList<>();
        Matcher matcher;
        for (int i = 0; i < tokens.length; i++) {
            matcher = nameRegex.matcher(tokens[i]);
            if (matcher.find()) {
                validNames.add(tokens[i]);
            }
        }
        String firstLongest = "";
        String secondLongest = "";
        int maxLengthSum = 0;
        for (int i = 0; i < validNames.size()-1; i++) {
            if (validNames.get(i).length() + validNames.get(i + 1).length() > maxLengthSum) {
                maxLengthSum = validNames.get(i).length() + validNames.get(i + 1).length();
                firstLongest = validNames.get(i);
                secondLongest = validNames.get(i + 1);
            }
        }
        System.out.println(firstLongest);
        System.out.println(secondLongest);
    }
}
