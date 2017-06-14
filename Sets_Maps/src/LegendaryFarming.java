import java.util.*;
import java.util.Map.Entry;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String [] input = null;
        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();
        boolean hasWinner = false;
        while (true){
            input = console.nextLine().toLowerCase().split(" ");
            for (int i = 0; i < input.length; i+=2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i+1];
                if (material.equals("shards") || material.equals("fragments")
                        || material.equals("motes")){
                    int value = keyMaterials.get(material) + quantity;
                    keyMaterials.put(material, value);
                    if (keyMaterials.get(material) >= 250) {
                        int newValue = keyMaterials.get(material) - 250;
                        keyMaterials.put(material, newValue);
                        switch (material) {
                            case "shards":
                                System.out.println("Shadowmourne obtained!");
                                break;
                            case "fragments":
                                System.out.println("Valanyr obtained!");
                                break;
                            case "motes":
                                System.out.println("Dragonwrath obtained!");
                                break;
                        }
                        hasWinner = true;
                        break;
                    }
                } else {
                    if (!junkMaterials.containsKey(material)){
                        junkMaterials.put(material, 0);
                    }
                    int value = junkMaterials.get(material) + quantity;
                    junkMaterials.put(material, value);
                }
            }
            if (hasWinner){
                break;
            }
        }
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>();
        for (Map.Entry<String, Integer> mapEntry : keyMaterials
                .entrySet()) {
            sortedList.add(mapEntry);
        }
        sortedList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Entry<String, Integer> о1, Entry<String, Integer> о2) {
                int value_1 = о1.getValue();
                int value_2 = о2.getValue();
                int cmp = Integer.compare(value_2, value_1);
                if (cmp == 0){
                    cmp = о1.getKey().compareTo(о2.getKey());
                }
                return cmp;
            }
        });
        printResult(sortedList, junkMaterials);
    }
    public static void printResult(List<Map.Entry<String, Integer>> sortedList, TreeMap<String, Integer> junkMap){
        for (int i = 0; i < sortedList.size(); i++) {
            System.out.printf("%s: %d\n", sortedList.get(i).getKey(), sortedList.get(i).getValue());
        }
        for (Map.Entry<String, Integer> junkEntry : junkMap.entrySet()) {
            System.out.printf("%s: %d\n", junkEntry.getKey(), junkEntry.getValue());
        }
    }
}
