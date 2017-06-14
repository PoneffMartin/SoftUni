import java.util.*;

public class MelrahShake {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        String input = console.nextLine();
        String pattern = console.nextLine();
        String result = "";
        String tmpString = input;
        while (!pattern.equals("")){
            int indexToRemove = pattern.length()/2;
            int firstPatternOccurence = tmpString.indexOf(pattern);
            int lastPatternOccurence = tmpString.lastIndexOf(pattern);
            if (firstPatternOccurence != -1 && lastPatternOccurence != -1
                    && firstPatternOccurence != lastPatternOccurence) {
                tmpString = tmpString.substring(0, firstPatternOccurence) +
                        tmpString.substring(firstPatternOccurence+pattern.length(), lastPatternOccurence) +
                        tmpString.substring(lastPatternOccurence+pattern.length(),tmpString.length());
                System.out.println("Shaked it.");
                pattern = pattern.substring(0, indexToRemove) + pattern.substring(indexToRemove+1, pattern.length());
            } else {
                break;
            }
            result = tmpString;
        }
        System.out.println("No shake.");
        System.out.println(result);
    }
}
