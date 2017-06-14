import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mponev on 16.05.16.
 */
public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        String input = console.nextLine();
        String [] tokens = input.split(" ");
        int amountOfElements = Integer.parseInt(tokens[0]);
        int amountOfElementsToPop = Integer.parseInt(tokens[1]);
        int searchElement = Integer.parseInt(tokens[2]);
        Stack<Integer> integerStack = new Stack<>();
        int element = 0;
        for (int i = 0; i < amountOfElements; i++) {
            element = console.nextInt();
            integerStack.push(element);
        }
        for (int i = 0; i < amountOfElementsToPop; i++) {
            integerStack.pop();
        }
        if (integerStack.contains(searchElement)){
            System.out.println("true");
        } else if (!integerStack.empty()){
            int minElement = integerStack.pop();
            while (!integerStack.empty()) {
                if (integerStack.peek() < minElement){
                    minElement = integerStack.pop();
                } else {
                    integerStack.pop();
                }
            }
            System.out.println(minElement);
        } else {
            System.out.println(0);
        }
    }
}
