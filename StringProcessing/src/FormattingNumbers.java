import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mponev on 28.05.16.
 */
public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer number_1 = scanner.nextInt();
        Double  number_2 = scanner.nextDouble();
        Double  number_3 = scanner.nextDouble();
        String binaryForm = Integer.toBinaryString(number_1);
        StringBuilder tmpString = new StringBuilder(binaryForm);
        while (tmpString.length() > 10) {
            tmpString.deleteCharAt(tmpString.length() - 1);
        }
        System.out.printf("|%-10X|%010d|%10.2f|%-10.3f|", number_1, new BigInteger(tmpString.toString()),number_2, number_3);
    }
}