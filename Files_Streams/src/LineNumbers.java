import java.io.*;

/**
 * Created by mponev on 25.05.16.
 */
public class LineNumbers {
    public static void main(String[] args) {
        File inputFile = new File("//home//mponev//SoftUni//Advanced_Java//input.txt");
        File outputFile = new File("//home//mponev//SoftUni//Advanced_Java//output.txt");
        try(BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            int lineCounter = 1;
            String inputLine = null;
            while ((inputLine = br.readLine()) != null) {
                bw.write(lineCounter + " " + inputLine);
                bw.newLine();
                lineCounter ++;
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}
