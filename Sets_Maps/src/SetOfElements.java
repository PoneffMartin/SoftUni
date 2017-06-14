import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by mponev on 18.05.16.
 */
public class SetOfElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int firstSetSize = console.nextInt();
        int secondSetSize = console.nextInt();
        TreeSet<Integer> firstSet = new TreeSet<>();
        TreeSet<Integer> secondSet = new TreeSet<>();
        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(console.nextInt());
        }
        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(console.nextInt());
        }
        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)){
                System.out.printf("%d ", integer);
            }
        }
    }
}
