import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by mponev on 28.05.16.
 */
public class ConvertFromNBaseTo10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger base = scanner.nextBigInteger();
        BigInteger baseN = scanner.nextBigInteger();
        BigInteger result = new BigInteger("0");
        BigInteger multiplication = new BigInteger("0");
        String stringNumber = baseN.toString();
        for (int position = stringNumber.length() - 1, power = 0; position >= 0; position--, power ++) {
            BigInteger number = BigInteger.valueOf(Character.getNumericValue(stringNumber.charAt(position)));
            multiplication = number.multiply(base.pow(power));
            result = result.add(multiplication);
        }
        System.out.println(result.toString());
    }
}
