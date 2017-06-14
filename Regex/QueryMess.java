import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mponev on 6/3/16.
 */
public class QueryMess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String pairsRegex = "([^&\\?]*)=([^&\\?]*)";
        String spaceRegex = "(\\+|%20)+";
        Pattern pairsPattern = Pattern.compile(pairsRegex);
        Pattern spacePattern = Pattern.compile(spaceRegex);
        Matcher pairsMatcher;
        Matcher spaceMatcher;
        HashMap<String, ArrayList<String>> pairs = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            pairsMatcher = pairsPattern.matcher(input);
            while (pairsMatcher.find()) {
                spaceMatcher = spacePattern.matcher(pairsMatcher.group());
                String pair = pairsMatcher.group();
                if (spaceMatcher.find()) {
                    pair = spaceMatcher.replaceAll(" ");
                }
                String [] tokens = pair.split("=");
                String key = tokens[0].trim();
                String value = tokens[1];
                if (!pairs.containsKey(key)) {
                    pairs.put(key, new ArrayList<>());
                }
                value = value.trim();
                pairs.get(key).add(value);
            }
            for (Map.Entry<String, ArrayList<String>> entry : pairs.entrySet()) {
                System.out.printf("%s=%s", entry.getKey(), entry.getValue().toString());
            }
            System.out.println();
            pairs = new LinkedHashMap<>();
            input = scanner.nextLine();
        }
    }
}
