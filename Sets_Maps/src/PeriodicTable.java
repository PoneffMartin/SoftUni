import sun.reflect.generics.tree.Tree;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by mponev on 18.05.16.
 */
public class PeriodicTable {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int lines = console.nextInt();
        TreeSet<String> chemicalCompounds = new TreeSet<>();
        console.nextLine();
        for (int i = 0; i < lines; i++) {
            String [] tokens = console.nextLine().split(" ");
            for (int j = 0; j < tokens.length; j++) {
                String chemicalCompound = tokens[j];
                chemicalCompounds.add(chemicalCompound);
            }
        }
        for (String chemicalCompound : chemicalCompounds) {
            System.out.printf("%s ", chemicalCompound);
        }
    }
}
