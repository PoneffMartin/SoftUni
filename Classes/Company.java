import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by user on 6/22/16.
 */
public class Employee {
    public String name;
    public double salary;
    public String position;
    public String department;
    public String email;
    public int age;
    public Employee () {

    }
    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }
    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }
    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }
    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.salary = salary;
        this.name = name;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }
    @Override
    public String toString() {
        String output = String.format("%s %.2f %s %d", name, salary, email, age);
        return output;
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);
        int linesCount = Integer.parseInt(reader.readLine());
        String inputLine = null;
        String name = null;
        double salary = 0;
        String position = null;
        String department = null;
        String email = null;
        int age = 0;
        HashMap<String, List<Employee>> departments = new HashMap<>();
        for (int i = 0; i < linesCount; i++) {
            inputLine = reader.readLine();
            String [] tokens = inputLine.split("\\s");
            name = tokens[0];
            salary = Double.parseDouble(tokens[1]);
            position = tokens[2];
            department = tokens[3];
            Employee employee;
            if (tokens.length == 4) {
                employee = new Employee(name, salary, position, department, "n/a", -1);
            } else if (tokens.length == 6) {
                email = tokens[4];
                age = Integer.parseInt(tokens[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else {
                if (isNumeric(tokens[4])) {
                    age = Integer.parseInt(tokens[4]);
                    employee = new Employee(name, salary, position, department, age);
                } else {
                    email = tokens[4];
                    employee = new Employee(name, salary, position, department, email);
                }
            }
            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
            }
            departments.get(department).add(employee);
        }
        String departmentWithHighestAverageSalary = null;
        List<Employee> employeesOfDepartment = new ArrayList<>();
        double highestAverageSalary = 0;
        for (Map.Entry<String, List<Employee>> entrySet : departments.entrySet()) {
            double averageSalary = getAverageSalary(entrySet);
            if (averageSalary > highestAverageSalary) {
                highestAverageSalary = averageSalary;
                departmentWithHighestAverageSalary = entrySet.getKey();
                employeesOfDepartment = entrySet.getValue();
            }
        }
        Collections.sort(employeesOfDepartment, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee1, Employee employee2) {
                int result;
                if (employee1.salary < employee2.salary) {
                    result = 1;
                } else if (employee1.salary > employee2.salary) {
                    result = -1;
                } else {
                    result = 0;
                }
                return result;
            }
        });
        System.out.printf("Highest Average Salary: %s\n", departmentWithHighestAverageSalary);
        for (Employee employee : employeesOfDepartment) {
            System.out.println(employee.toString());
        }
    }
    public static double getAverageSalary (Map.Entry<String, List<Employee>> entry) {
        double totalSalary = 0;
        for (Employee employee : entry.getValue()) {
            totalSalary += employee.salary;
        }
        return totalSalary / entry.getValue().size();
    }
    public static boolean isNumeric (String strNum) {
        boolean isNumber = true;
        for (int i = 0; i < strNum.length(); i++) {
            isNumber = Character.isDigit(strNum.charAt(i));
            if (!isNumber) {
                return false;
            }
        }
        return true;
    }
}
