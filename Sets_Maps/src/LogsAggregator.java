import java.util.*;

/**
 * Created by mponev on 5/20/16.
 */
public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        scanner.nextLine();
        TreeMap<String, Integer> durationLogs = new TreeMap<>();
        HashMap<String, TreeSet<String>> ipLogs = new HashMap<>();
        String input;
        for (int i = 0; i < lines; i++) {
            input = scanner.nextLine();
            String [] tokens = input.split(" ");
            String ip = tokens[0];
            String user = tokens[1];
            Integer duration = Integer.parseInt(tokens[2]);
            if (!durationLogs.containsKey(user)){
                durationLogs.put(user, duration);
                ipLogs.put(user, new TreeSet<>());
            } else {
                Integer currentDuration = durationLogs.get(user);
                durationLogs.put(user, currentDuration + duration);
            }

            ipLogs.get(user).add(ip);
        }
        for (Map.Entry<String, Integer> durationEntry : durationLogs.entrySet()) {
            String user = durationEntry.getKey();
            Integer duration = durationEntry.getValue();
            TreeSet<String> ipAddresses = ipLogs.get(user);
            System.out.printf("%s: %d %s\n", user, duration, ipAddresses);
        }
    }
}
