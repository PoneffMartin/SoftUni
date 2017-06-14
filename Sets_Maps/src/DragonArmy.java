import java.util.*;

/**
 * Created by mponev on 5/20/16.
 */
public class DragonArmy {
    public static final Integer DEFAULT_HEALTH = 250;
    public static final Integer DEFAULT_DAMAGE = 45;
    public static final Integer DEFAULT_ARMOR  = 10;
    public static final String  DAMAGE         = "damage";
    public static final String  HEALTH         = "health";
    public static final String  ARMOR          = "armor";
    public static final String  NULL           = "null";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        LinkedHashMap<String, TreeMap<String, LinkedHashMap<String, Integer>>> dragonStats = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            String type = tokens[0];
            String name = tokens[1];
            String statDamage = tokens[2];
            String statHealth = tokens[3];
            String statArmor = tokens[4];
            Integer damage = 0;
            Integer health = 0;
            Integer armor = 0;
            if (!dragonStats.containsKey(type)) {
                dragonStats.put(type, new TreeMap<>());
                dragonStats.get(type).put(name, new LinkedHashMap<>());
            } else if (!dragonStats.get(type).containsKey(name)) {
                dragonStats.get(type).put(name, new LinkedHashMap<>());
            }
            if (statDamage.equals(NULL)) {
                damage = DEFAULT_DAMAGE;
            } else {
                damage = Integer.parseInt(statDamage);
            }
            if (statHealth.equals(NULL)) {
                health = DEFAULT_HEALTH;
            } else {
                health = Integer.parseInt(statHealth);
            }
            if (statArmor.equals(NULL)) {
                armor = DEFAULT_ARMOR;
            } else {
                armor = Integer.parseInt(statArmor);
            }
            dragonStats.get(type).get(name).put(DAMAGE, damage);
            dragonStats.get(type).get(name).put(HEALTH, health);
            dragonStats.get(type).get(name).put(ARMOR, armor);

        }
        for (Map.Entry<String, TreeMap<String, LinkedHashMap<String, Integer>>> entry : dragonStats.entrySet()) {
            double [] averages = getAverageStats(entry.getValue());
            double damageAverage = averages[0];
            double healthAverage = averages[1];
            double armorAverage  = averages[2];
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n", entry.getKey(), damageAverage, healthAverage, armorAverage);
            for (Map.Entry<String, LinkedHashMap<String, Integer>> subEntry : entry.getValue().entrySet()) {
                System.out.printf("-%s -> %s: %d, %s: %d, %s: %d\n", subEntry.getKey(),
                        DAMAGE, subEntry.getValue().get(DAMAGE),
                        HEALTH, subEntry.getValue().get(HEALTH),
                        ARMOR,  subEntry.getValue().get(ARMOR));
            }
        }
    }


    public static double [] getAverageStats(TreeMap<String, LinkedHashMap<String, Integer>> damageStats){
        int count = 0;
        int damageSum = 0;
        int healthSum = 0;
        int armorSum  = 0;
        double damageAverage = 0d;
        double healthAverage = 0d;
        double armorAverage  = 0d;
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : damageStats.entrySet()) {
            damageSum += entry.getValue().get(DAMAGE);
            healthSum += entry.getValue().get(HEALTH);
            armorSum  += entry.getValue().get(ARMOR);
            count ++;
        }
        damageAverage = (double)damageSum/count;
        healthAverage = (double)healthSum/count;
        armorAverage  = (double)armorSum/count;
        double [] averages = new double[3];
        averages[0]=damageAverage;
        averages[1]=healthAverage;
        averages[2]=armorAverage;

        return averages;
    }
}
