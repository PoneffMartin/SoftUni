import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        LinkedHashMap<String, LinkedHashMap<String, Integer>> countries = new LinkedHashMap<>();
        while (!input.equals("report")) {
            String [] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            int population = Integer.parseInt(tokens[2]);
            if (!countries.containsKey(country)) {
                countries.put(country, new LinkedHashMap<>());
                countries.get(country).put(city, population);
            } else if (!countries.get(country).containsKey(city)) {
                countries.get(country).put(city, population);
            }
            input = console.nextLine();
        }
        List<Map.Entry<String, LinkedHashMap<String, Integer>>> sortedCountries = countries.entrySet().stream()
                .sorted((entry1, entry2) -> {
                    Integer result = (getTotalPopulation(entry2.getValue().values()))
                            .compareTo(getTotalPopulation(entry1.getValue().values()));
                    return result;
                })
                .collect(Collectors.toList());

        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : sortedCountries) {
            System.out.printf("%s (total population: %s)\n", entry.getKey(), getTotalPopulation(entry.getValue().values()).toString());
            List<Map.Entry<String, Integer>> sortedCities = entry.getValue().entrySet().stream()
                    .sorted((city1, city2) -> {
                        Integer result = city2.getValue().compareTo(city1.getValue());
                        return result;
                    })
                    .collect(Collectors.toList());
            for (Map.Entry<String, Integer> city : sortedCities) {
                System.out.printf("=>%s: %d\n", city.getKey(), city.getValue());
            }
        }
    }
    public static BigDecimal getTotalPopulation(Collection<Integer> population){
        BigDecimal totalPopulation = new BigDecimal(0);
        for (Integer integer : population) {
            totalPopulation = totalPopulation.add(BigDecimal.valueOf(integer));
        }
        return totalPopulation;
    }
}
