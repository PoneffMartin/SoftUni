import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLogs {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();
        Pattern regex = Pattern.compile("^IP=(([0-9]{1,3}\\.){3}[0-9]{1,3}|([0-9a-zA-Z]{1,4}:){7}[0-9a-zA-Z]{1,4}).*user=(\\w{3,50})$");
        while (!input.equals("end")) {
            Matcher matcher = regex.matcher(input);
            if (matcher.find()){
                String ipAddress = matcher.group(1);
                String name = matcher.group(4);
                if (!userLogs.containsKey(name)) {
                    userLogs.put(name, new LinkedHashMap<>());
                    userLogs.get(name).put(ipAddress, 1);
                } else if (!userLogs.get(name).containsKey(ipAddress)) {
                    userLogs.get(name).put(ipAddress, 1);
                } else {
                    int numberOfMessages = userLogs.get(name).get(ipAddress);
                    userLogs.get(name).put(ipAddress, numberOfMessages + 1);
                }
            }
            input = console.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : userLogs.entrySet()) {
            System.out.printf("%s:\n", entry.getKey());
            Iterator<Map.Entry<String, Integer>> i = entry.getValue().entrySet().iterator();
            while (i.hasNext()) {
                Map.Entry<String, Integer> subEntry = i.next();
                System.out.printf("%s => %d", subEntry.getKey(), subEntry.getValue());
                if (i.hasNext()){
                    System.out.printf(", ");
                } else {
                    System.out.println(".");
                }
            }
        }
    }
}
