import java.util.Scanner;

/**
 * Created by mponev on 21.05.16.
 */
public class RubikMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows  = scanner.nextInt();
        int cols  = scanner.nextInt();
        int lines = scanner.nextInt();
        scanner.nextLine();
        int counter = 1;
        int [][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }
        for (int i = 0; i < lines; i++) {
            String command = scanner.nextLine();
            String [] tokens = command.split(" ");
            Integer arrayIndex = Integer.parseInt(tokens[0]);
            String direction = tokens[1];
            Integer moves = Integer.parseInt(tokens[2]);
            switch (direction) {
                case "left":
                    moveRow(matrix, arrayIndex, moves % cols, cols);
                    break;
                case "right":
                    moveRow(matrix, arrayIndex, cols - (moves % cols), cols);
                    break;
                case "up":
                    moveCol(matrix, arrayIndex, moves % rows, rows);
                    break;
                case "down":
                    moveCol(matrix, arrayIndex, rows - (moves % rows), rows);
                    break;
            }
        }
        rearrange(matrix, rows, cols);
    }
    public static void moveRow(int [][] matrix, int rowIndex, int moves, int cols) {
        int [] tempArray = new int[cols];
        for (int i = 0; i < cols; i++) {
            tempArray[i] = matrix[rowIndex][(i+moves) % cols];
        }
        System.arraycopy(tempArray, 0, matrix[rowIndex], 0, cols);
    }
    public static void moveCol(int [][] matrix, int colIndex, int moves, int rows) {
        int [] tempArray = new int[rows];
        for (int i = 0; i < rows; i++) {
            tempArray[i] = matrix[(i+moves) % matrix.length][colIndex];
        }
        for (int i = 0; i < tempArray.length; i++) {
            matrix[i][colIndex] = tempArray[i];
        }
    }
    public static void rearrange (int [][] matrix, int rows, int cols) {
        int expected = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != expected){
                    for (int k = 0; k < rows; k++) {
                        for (int l = 0; l < cols; l++) {
                            if (matrix[k][l] == expected) {
                                System.out.printf("Swap (%d, %d) with (%d, %d)\n", i, j, k, l);
                                int temp = matrix[i][j];
                                matrix[i][j] = matrix[k][l];
                                matrix[k][l] = temp;
                            }
                        }
                    }
                } else {
                    System.out.println("No swap required");
                }
                expected++;
            }
        }
    }
}
