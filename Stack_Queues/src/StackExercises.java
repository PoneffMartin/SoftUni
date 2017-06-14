import java.util.LinkedList;
import java.util.Stack;

/**
 * Simple stack methods example
 * Created by mponev on 16.05.16.
 */
public class StackExercises {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(5);
        stack.add(6);
        stack.add(7);
        System.out.println(stack.peek());
        System.out.println(stack.peek());
    }
}
