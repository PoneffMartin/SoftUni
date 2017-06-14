import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by user on 6/27/16..
 * <Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure> <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age> <Tire4Pressure> <Tire4Age>
 */
public class Car {
    private static final String FRAGILE  = "fragile";
    private static final String FLAMABLE = "flamable";
    public String model;
    public Engine engine;
    public Cargo cargo;
    public List<Tire> tires = new ArrayList<>();
    public Car (String model, Integer engineSpeed, Integer enginePower, Integer cargoWeight, String cargoType, Integer tire1Age, Double tire1Pressure,
                Integer tire2Age, Double tire2Pressure, Integer tire3Age, Double tire3Pressure, Integer tire4Age, Double tire4Pressure) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tires.add(new Tire(tire1Age, tire1Pressure));
        this.tires.add(new Tire(tire2Age, tire2Pressure));
        this.tires.add(new Tire(tire3Age, tire3Pressure));
        this.tires.add(new Tire(tire4Age, tire4Pressure));
    }
    private class Engine {
        private Integer speed;
        private Integer power;
        private Engine (Integer speed, Integer power) {
            this.speed = speed;
            this.power = power;
        }
    }
    private class Cargo {
        private Integer weight;
        private String type;
        private Cargo (Integer weight, String type) {
            this.weight = weight;
            this.type   = type;
        }
    }
    private class Tire {
        private Integer age;
        private Double pressure;
        private Tire (Integer age, Double pressure) {
            this.age = age;
            this.pressure = pressure;
        }
    }
    public String getCargoType () {
        return this.cargo.type;
    }
    public boolean isTirePressureLessThanOne () {
        int size = this.tires.size();
        for (int i = 0; i < size; i++) {
            if (this.tires.get(i).pressure < 1) {
                return true;
            }
        }
        return false;
    }
    public boolean isEnginePowerGreaterTwoHundredAndFifty() {
        if (this.engine.power > 250) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.model;
    }

    public static void main(String[] args) throws Exception{
        List<Car> cars = new ArrayList<>();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        int linesCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < linesCount; i++) {
            String[] inputTokens = reader.readLine().split("\\s");
            String carModel = inputTokens[0];
            Integer engineSpeed  = Integer.parseInt(inputTokens[1]);
            Integer enginePower  = Integer.parseInt(inputTokens[2]);
            Integer cargoWeight  = Integer.parseInt(inputTokens[3]);
            String cargoType     = inputTokens[4];
            Double tire1Pressure = Double.parseDouble(inputTokens[5]);
            Integer tire1Age     = Integer.parseInt(inputTokens[6]);
            Double tire2Pressure = Double.parseDouble(inputTokens[7]);
            Integer tire2Age     = Integer.parseInt(inputTokens[8]);
            Double tire3Pressure = Double.parseDouble(inputTokens[9]);
            Integer tire3Age     = Integer.parseInt(inputTokens[10]);
            Double tire4Pressure = Double.parseDouble(inputTokens[11]);
            Integer tire4Age     = Integer.parseInt(inputTokens[12]);
            Car car = new Car(carModel, engineSpeed, enginePower, cargoWeight, cargoType, tire1Age, tire1Pressure, tire2Age, tire2Pressure,
                    tire3Age, tire3Pressure, tire4Age, tire4Pressure);
            cars.add(car);
        }
        String command = reader.readLine();
        if (command.equals(FRAGILE)) {
            for (Car car : cars) {
                if (car.getCargoType().equals(FRAGILE) && car.isTirePressureLessThanOne()) {
                    System.out.println(car.toString());
                }
            }
        } else {
            for (Car car : cars) {
                if (car.getCargoType().equals(FLAMABLE) && car.isEnginePowerGreaterTwoHundredAndFifty()) {
                    System.out.println(car.toString());
                }
            }
        }
    }
}
