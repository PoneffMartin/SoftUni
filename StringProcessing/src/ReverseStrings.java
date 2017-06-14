import java.util.Scanner;

/**
 * Created by mponev on 28.05.16.
 */
public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result ="";
        for (int i = input.length() - 1; i >= 0; i--) {
            result = result + input.charAt(i);
        }
        System.out.println(result);
    }
}
