import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mponev on 16.05.16.
 */
public class MaximumElement {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int amount = Integer.parseInt(console.nextLine());
        Stack<Integer> integerStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < amount; i++) {
            String input = console.nextLine();
            String [] tokens = input.split(" ");
            if (tokens.length > 1) {
                int element = Integer.parseInt(tokens[1]);
                integerStack.push(element);
                if (maxValue < element){
                    maxValue = element;
                    maxStack.push(maxValue);
                }
            } else if (tokens[0].equals("2")){
                int poppedItem = integerStack.pop();
                if (poppedItem == maxValue){
                    maxStack.pop();
                    if (maxStack.size() > 0){
                        maxValue = maxStack.peek();
                    } else {
                        maxValue = Integer.MIN_VALUE;
                    }
                }
            } else {
                System.out.println(maxValue);
            }
        }
    }
}
