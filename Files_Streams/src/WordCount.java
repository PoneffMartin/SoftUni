import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by mponev on 25.05.16.
 */
public class WordCount {
    public static void main(String[] args) {
        File wordsFile  = new File("//home//mponev//SoftUni//Advanced_Java//words.txt");
        File textFile   = new File("//home//mponev//SoftUni//Advanced_Java//text.txt");
        File outputFile = new File("//home//mponev//SoftUni//Advanced_Java//output.txt");
        LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();
        try (BufferedReader words_br = new BufferedReader(new FileReader(wordsFile));
        BufferedReader text_br = new BufferedReader(new FileReader(textFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            List<String> words = new ArrayList<>();
            String input = null;
            while ((input = words_br.readLine()) != null) {
                String [] tokens = input.split(" ");
                words = Arrays.asList(tokens);
            }
            input = null;
            for (String word : words) {
                wordCount.put(word, 0);
            }
            while ((input = text_br.readLine()) != null) {
                String [] tokens = input.split("[\\s,\\.]");
                for (String token : tokens) {
                    if (wordCount.containsKey(token)) {
                        int currentCount = wordCount.get(token);
                        wordCount.put(token, currentCount++);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception catch.");
        }
    }
}
