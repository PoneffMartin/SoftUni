import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by mponev on 5/17/16.
 */
public class TruckTour {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        console.nextLine();
        Queue<Integer> amountOfPetrolQueue = new ArrayDeque<>();
        Queue<Integer> distanceToNextPumpQueue = new ArrayDeque<>();
        int amountOfPetrol = 0;
        int distanceToNextPump = 0;
        for (int i = 0; i < n; i++) {
            amountOfPetrol = console.nextInt();
            distanceToNextPump = console.nextInt();
            amountOfPetrolQueue.add(amountOfPetrol);
            distanceToNextPumpQueue.add(distanceToNextPump);
        }
        Queue<Integer> tempAmountOfPetrolQueue = new ArrayDeque<>();
        Queue<Integer> tempDistanceToNextPumpQueue = new ArrayDeque<>();
        int position = 0;
        int counter = 1;
        long leftFuel = 0;
        boolean hasFoundPump = false;
        while (true){
            amountOfPetrol = amountOfPetrolQueue.remove();
            distanceToNextPump = distanceToNextPumpQueue.remove();
            amountOfPetrolQueue.add(amountOfPetrol);
            distanceToNextPumpQueue.add(distanceToNextPump);
            leftFuel = (leftFuel + amountOfPetrol) - distanceToNextPump;
            while (leftFuel >= 0){
                amountOfPetrol = amountOfPetrolQueue.remove();
                distanceToNextPump = distanceToNextPumpQueue.remove();
                amountOfPetrolQueue.add(amountOfPetrol);
                distanceToNextPumpQueue.add(distanceToNextPump);
                leftFuel = (leftFuel + amountOfPetrol) - distanceToNextPump;
                if (counter == n-1) {
                    hasFoundPump = true;
                    break;
                }
                counter++;
            }
            if (hasFoundPump){
                System.out.println(position);
                break;
            }
            position += counter;
            counter = 1;
        }
    }
}
