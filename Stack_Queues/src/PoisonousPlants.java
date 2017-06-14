import java.util.*;

/**
 * Created by mponev on 5/17/16.
 */
public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int n = console.nextInt();
        ArrayList<Integer> plants = new ArrayList<>();
        ArrayList<Integer> leftPlants = new ArrayList<>();
        Queue<Integer> diedPlants = new ArrayDeque<>();
        int day = 0;
        for (int i = 0; i < n; i++) {
            plants.add(console.nextInt());
        }
        while (true) {
            day ++;
            for (int i = 1; i < plants.size(); i++) {
                if (plants.get(i) > plants.get(i-1)){
                    diedPlants.add(i);
                }
            }
            if (!diedPlants.isEmpty()){
                for (int i = 0; i < plants.size(); i++) {
                    if (diedPlants.size() > 0){
                        if (!(diedPlants.peek() == i)){
                            leftPlants.add(plants.get(i));
                        } else {
                            diedPlants.remove();
                        }
                    } else {
                        leftPlants.add(plants.get(i));
                    }
                }
                diedPlants = new ArrayDeque<>();
            } else {
                break;
            }
            plants = leftPlants;
            leftPlants = new ArrayList<>();
        }
        System.out.println(day - 1);
    }
}
