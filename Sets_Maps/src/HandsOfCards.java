import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by mponev on 5/19/16.
 */
public class HandsOfCards {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        LinkedHashMap<String, TreeSet<String>> players = new LinkedHashMap<>();
        // int counter = 1;
        String personName = "";
        String cards = "";
        int totalPoints = 0;
        while (!input.equals("JOKER")){
            String [] tokens = input.split(":");
            personName = tokens[0];
            cards = tokens[1].replaceAll("\\s", "");
            String [] cardTokens = cards.split(",");
            if (!players.containsKey(personName)){
                players.put(personName, new TreeSet<>());
            }
            for (int i = 0; i < cardTokens.length; i++) {
                String card = cardTokens[i];
                players.get(personName).add(card);
            }
            input = console.nextLine();
        }
        for (Map.Entry<String, TreeSet<String>> entry : players.entrySet()) {
            for (String card : entry.getValue()) {
                totalPoints += calculatePoints(card);
            }
            System.out.printf("%s: %d\n", entry.getKey(), totalPoints);
            totalPoints = 0;
        }
    }
    public static int calculatePoints(String card){
        int points = 0;
        String [] powerString = card.split("[SHDC]");
        char typeString  = card.charAt(card.length() - 1);
        int power = 0;
        int type  = 0;
        switch (powerString[0]){
            case "J":
                power = 11;
                break;
            case "Q":
                power = 12;
                break;
            case "K":
                power = 13;
                break;
            case "A":
                power = 14;
                break;
            default:
                power = Integer.parseInt(powerString[0]);
                break;
        }
        switch (typeString){
            case 'S':
                type = 4;
                break;
            case 'H':
                type = 3;
                break;
            case 'D':
                type = 2;
                break;
            case 'C':
                type = 1;
                break;
        }
        points = power * type;
        return points;
    }
}
