import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Created by user on 6/22/16.
 */
public class Car {
    public String model;
    public double fuelAmount;
    public double fuelCostPerKm;
    public int distanceTraveled;
    public Car(String model, double fuelAmount, double fuelCostPerKm) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPerKm = fuelCostPerKm;
        this.distanceTraveled = 0;
    }
    public boolean isAbleToDrive (double amountOfKm) {
        if (amountOfKm * this.fuelCostPerKm > this.fuelAmount) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        int linesCount = Integer.parseInt(reader.readLine());
        List<Car> cars = new ArrayList<>();
        String inputLine;
        for (int i = 0; i < linesCount; i++) {
            inputLine = reader.readLine();
            String [] tokens = inputLine.split("\\s");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostPerKm = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuelAmount, fuelCostPerKm);
            cars.add(car);
        }
        inputLine = reader.readLine();

        while (!inputLine.equals("End")) {
            String [] tokens = inputLine.split("\\s");
            String carModel = tokens[1];
            int amountOfKm = Integer.parseInt(tokens[2]);
            inputLine = reader.readLine();
            Supplier<Car> getCar = new Supplier<Car>() {
                @Override
                public Car get() {
                    Car result = null;
                    for (Car car : cars) {
                        if (car.model.equals(carModel)){
                            result = car;
                            break;
                        }
                    }
                    return result;
                }
            };
            Car currentCar = getCar.get();
            if (currentCar.isAbleToDrive(amountOfKm)) {
                currentCar.fuelAmount = currentCar.fuelAmount - (currentCar.fuelCostPerKm * amountOfKm);
                currentCar.distanceTraveled = currentCar.distanceTraveled + amountOfKm;
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
        }
        for (Car car : cars) {
            System.out.printf("%s %.2f %d\n", car.model, car.fuelAmount, car.distanceTraveled);
        }
    }
}
