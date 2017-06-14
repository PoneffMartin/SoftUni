import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by mponev on 16.05.16.
 */
public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner console = new Scanner (System.in);
        String input = console.nextLine();
        String [] tokens = input.split(" ");
        int amountOfElements = Integer.parseInt(tokens[0]);
        int amountOfElementsToPop = Integer.parseInt(tokens[1]);
        int searchElement = Integer.parseInt(tokens[2]);
        Queue<Integer> integerStack = new ArrayDeque<>();
        int element = 0;
        for (int i = 0; i < amountOfElements; i++) {
            element = console.nextInt();
            integerStack.add(element);
        }
        for (int i = 0; i < amountOfElementsToPop; i++) {
            integerStack.remove();
        }
        if (integerStack.contains(searchElement)){
            System.out.println("true");
        } else if (integerStack.size() != 0){
            int minElement = integerStack.remove();
            while (integerStack.size() != 0) {
                if (integerStack.peek() < minElement){
                    minElement = integerStack.remove();
                } else {
                    integerStack.remove();
                }
            }
            System.out.println(minElement);
        } else {
            System.out.println(0);
        }
    }
}
