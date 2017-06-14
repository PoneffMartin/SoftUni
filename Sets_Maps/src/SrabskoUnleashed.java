import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by mponev on 5/20/16.
 */
public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Pattern regex = Pattern.compile("^(\\w+\\s?\\w+?\\s?\\w+?)\\s@(\\w+\\s?\\w+?\\s?\\w+?)\\s(\\d+)\\s(\\d+)");
        LinkedHashMap<String, HashMap<String, Long>> venueLogs = new LinkedHashMap<>();
        long totalPrice = 0;
        while (!input.equals("End")) {
            Matcher matcher = regex.matcher(input);
            if (matcher.find()) {
                String singer = matcher.group(1);
                String venue  = matcher.group(2);
                Integer ticketPrice = Integer.parseInt(matcher.group(3));
                Integer ticketsCount = Integer.parseInt(matcher.group(4));
                totalPrice = ticketPrice * ticketsCount;
                if (!venueLogs.containsKey(venue)) {
                    venueLogs.put(venue, new LinkedHashMap<>());
                    venueLogs.get(venue).put(singer, 0L);
                } else if (!venueLogs.get(venue).containsKey(singer)) {
                    venueLogs.get(venue).put(singer, 0L);
                }
                long currentProfit = venueLogs.get(venue).get(singer);
                venueLogs.get(venue).put(singer, currentProfit + totalPrice);
            }
            input = scanner.nextLine();
        }
        for (Map.Entry<String, HashMap<String, Long>> entry: venueLogs.entrySet()) {
            System.out.println(entry.getKey());
            List<Map.Entry<String, Long>> sortedProfits = entry.getValue().entrySet().stream()
                    .sorted((entry1, entry2) -> {
                        Integer result = entry2.getValue().compareTo(entry1.getValue());
                        return result;
                    })
                    .collect(Collectors.toList());
            for (Map.Entry<String, Long> sortedProfit : sortedProfits) {
                System.out.printf("#  %s -> %d\n", sortedProfit.getKey(), sortedProfit.getValue());
            }
        }
    }
}
