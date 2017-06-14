import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mponev on 16.05.16.
 */
public class StackReverseNumbers {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        String [] tokens = input.split(" ");
        Stack<Integer> numbers = new Stack<>();
        int number = 0;
        for (int i = 0; i < tokens.length; i++) {
            number = Integer.parseInt(tokens[i]);
            numbers.push(number);
        }
        while (numbers.size() > 0){
            System.out.printf("%d ", numbers.pop());
        }
    }
}
