import java.io.File;

/**
 * Created by mponev on 25.05.16.
 */
public class FileExercise {
    public static void main(String[] args) {
        File file = new File("//home//mponev//");
        File [] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }
    }
}
