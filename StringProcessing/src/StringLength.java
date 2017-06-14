import java.util.Scanner;

/**
 * Created by mponev on 28.05.16.
 */
public class StringLength {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = "";
        if (input.length() >= 20) {
            result = input.substring(0, 20);
        } else {
            result += input;
            for (int i = result.length(); i < 20; i++) {
                result += "*";
            }
        }
        System.out.println(result);
    }
}
