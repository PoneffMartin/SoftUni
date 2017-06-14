import java.util.Scanner;

/**
 * Created by mponev on 28.05.16.
 */
public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number_1 = scanner.nextLine();
        String number_2 = scanner.nextLine();
        String sum = "";
        String minString = number_1.length() <= number_2.length()? number_1:number_2;
        String maxString = number_1.length() <= number_2.length()? number_2:number_1;
        int differnce = maxString.length() - minString.length();
        for (int i = 0; i < differnce; i++) {
            minString = "0" + minString;
        }
        int maxLength = maxString.length();
        int result = 0;
        int remainder = 0;
        int digit_1 = 0;
        int digit_2 = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            digit_1 = Character.getNumericValue(minString.charAt(i));
            digit_2 = Character.getNumericValue(maxString.charAt(i));
            result = digit_1 + digit_2 + remainder;
            if (result >= 10) {
                if (i > 0) {
                    remainder = 1;
                    result = result - 10;
                }
            } else {
                remainder = 0;
            }
            sum = result + sum;
        }
        System.out.println(sum);
    }
}
