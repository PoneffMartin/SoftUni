import java.util.Scanner;

/**
 * Created by mponev on 21.05.16.
 */
public class TargetPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        String snake = scanner.nextLine();
        int impactRow = scanner.nextInt();
        int impactCol = scanner.nextInt();
        int radius = scanner.nextInt();
        char[][] matrix = new char[rows][cols];
        boolean isMovingLeft = true;
        int stringIndex = 0;
        int colIndex = cols - 1;
        for (int i = rows - 1; i >= 0; i--) {
            while (0 <= colIndex && colIndex < cols) {
                if (stringIndex == snake.length()) {
                    stringIndex = 0;
                }
                matrix[i][colIndex] = snake.charAt(stringIndex);
                if (isMovingLeft) {
                    colIndex --;
                } else {
                    colIndex ++;
                }
                stringIndex ++;
            }
            if (colIndex < 0){
                colIndex = 0;
            } else {
                colIndex = cols - 1;
            }
            isMovingLeft = !isMovingLeft;
        }
    }
}
