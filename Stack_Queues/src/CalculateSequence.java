import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by mponev on 16.05.16.
 */
public class CalculateSequence {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Long n = console.nextLong();
        console.nextLine();
        Queue<Long> sequence = new ArrayDeque<>();
        sequence.add(n);
        for (int i = 0; i < 50; i++) {
            Long element = sequence.remove();
            System.out.printf("%d ", element);
            Long s1 = element + 1;
            Long s2 = (2 * element) + 1;
            Long s3 = element + 2;
            sequence.add(s1);
            sequence.add(s2);
            sequence.add(s3);
        }
    }
}
