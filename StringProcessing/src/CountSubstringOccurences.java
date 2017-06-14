import java.util.*;

public class CountSubstringOccurences {
    public static void main(String[] args) {
        Scanner console=new Scanner(System.in);
        String text = console.nextLine().toLowerCase();
        String substring = console.nextLine().toLowerCase();
        StringBuilder currentString=new StringBuilder("");
        int count=0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = i; j < text.length(); j++) {
                currentString.append(text.charAt(j));
                if (currentString.toString().equals(substring)){
                    count++;
                    break;
                }
            }
            currentString=new StringBuilder("");
        }
        System.out.println(count);
    }
}