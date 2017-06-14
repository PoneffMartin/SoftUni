import java.util.*;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int rows=console.nextInt();
        int cols=console.nextInt();
        console.nextLine();
        int [][] parking = new int[rows][cols];
        int entryRow=0;
        int desiredRow=0;
        int desiredCol=0;
        int closestSpotInLeft=0;
        int closestSpotInRight=0;
        int position=0;
        String command=console.nextLine();
        String [] spot;
        while (!command.equals("stop")){
            spot = command.split(" ");
            entryRow=Integer.parseInt(spot[0]);
            desiredRow=Integer.parseInt(spot[1]);
            desiredCol=Integer.parseInt(spot[2]);
            closestSpotInLeft=0;
            closestSpotInRight=0;
            if (isRowFull(parking, desiredRow)) {
                System.out.printf("Row %d full\n", desiredRow);
            } else if (parking[desiredRow][desiredCol]==0){
                System.out.println(Math.abs(desiredRow-entryRow)+desiredCol+1);
                parking[desiredRow][desiredCol]=1;
            } else {
                for (int i = desiredCol - 1; i >= 1; i--) {
                    if (parking[desiredRow][i] == 0) {
                        closestSpotInLeft = i;
                        break;
                    }
                }
                for (int i = desiredCol + 1; i < cols; i++) {
                    if (parking[desiredRow][i] == 0) {
                        closestSpotInRight = i;
                        break;
                    }
                }
                if (closestSpotInLeft == 0 && closestSpotInRight !=0){
                    parking[desiredRow][closestSpotInRight]=1;
                    System.out.println(Math.abs(desiredRow - entryRow) + closestSpotInRight + 1);
                } else if (closestSpotInLeft != 0 && closestSpotInRight ==0) {
                    parking[desiredRow][closestSpotInLeft]=1;
                    System.out.println(Math.abs(desiredRow - entryRow) + closestSpotInLeft + 1);
                } else if (desiredCol - closestSpotInLeft <= closestSpotInRight - desiredCol) {
                    parking[desiredRow][closestSpotInLeft]=1;
                    System.out.println(Math.abs(desiredRow - entryRow) + closestSpotInLeft + 1);
                } else {
                    parking[desiredRow][closestSpotInRight]=1;
                    System.out.println(Math.abs(desiredRow - entryRow) + closestSpotInRight + 1);
                }
            }
            command=console.nextLine();
        }
    }
    static boolean isRowFull(int[][] parking, int row){;
        for (int i = 1; i < parking[row].length; i++) {
            if (parking[row][i] == 0){
                return false;
            }
        }
        return true;
    }
}
