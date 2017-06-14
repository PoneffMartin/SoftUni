import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by mponev on 28.05.16.
 */
public class ConvertFrom10BaseToN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int baseN = scanner.nextInt();
        BigDecimal baseTen = scanner.nextBigDecimal();
        StringBuilder result = new StringBuilder();
        Integer remainder = 0;
        BigDecimal zero = new BigDecimal("0");
        while (!baseTen.equals(zero)) {
            remainder = baseTen.remainder(new BigDecimal(baseN)).intValue();
            baseTen = baseTen.divideToIntegralValue(new BigDecimal(baseN));
            result.append(remainder);
        }
        result = result.reverse();
        System.out.println(result.toString());
    }
}
