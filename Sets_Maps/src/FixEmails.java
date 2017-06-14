import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        LinkedHashMap<String, String> emails = new LinkedHashMap<>();
        int counter = 1;
        String name = "";
        String email = "";
        while (!input.equals("stop")){
            if (counter % 2 != 0) {
                name = input;
            } else {
                email = input;
                emails.put(name, email);
            }
            counter++;
            input = console.nextLine();
        }
        for (Map.Entry<String, String> entry : emails.entrySet()) {
            boolean isValidEmail = isValid(entry.getValue());
            if (isValidEmail){
                System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
            }
        }
    }
    public static boolean isValid (String email){
        email = email.toLowerCase();
        int length = email.length();
        String domain = email.substring(length - 2, length);
        if (domain.equals("uk") || domain.equals("us")){
            return false;
        } else {
            return true;
        }
    }
}
