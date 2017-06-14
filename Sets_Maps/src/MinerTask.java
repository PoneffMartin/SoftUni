import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by mponev on 18.05.16.
 */
public class MinerTask {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        LinkedHashMap<String, Integer> resources = new LinkedHashMap<>();
        int counter = 1;
        String resource = "";
        int quantity = 0;
        while (!input.equals("stop")){
            if (counter % 2 != 0) {
                resource = input;
            } else {
                quantity = Integer.parseInt(input);
                if (resources.containsKey(resource)){
                    int currentQuantity = resources.get(resource);
                    resources.put(resource, currentQuantity + quantity);
                } else {
                    resources.put(resource, quantity);
                }
            }
            counter++;
            input = console.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resources.entrySet()) {
            System.out.printf("%s -> %d\n", entry.getKey(), entry.getValue());
        }
    }
}
