import java.util.Scanner;

/**
 * Created by mponev on 28.05.16.
 */
public class MultiplyBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number_1 = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        String product = "";
        int result = 0;
        int remainder = 0;
        int digit = 0;
        for (int i = number_1.length() - 1; i >= 0; i--) {
            digit = Character.getNumericValue(number_1.charAt(i));
            result = (digit * multiplier) + remainder;
            remainder = 0;
            if (i > 0) {
                while (result >= 10) {
                    remainder ++;
                    result = result - 10;
                }
            }
            product = result + product;
        }
        System.out.println(product);
    }
}
