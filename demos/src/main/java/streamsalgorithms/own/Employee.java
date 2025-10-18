package streamsalgorithms.own;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    
    /*Hozz létre egy Employee osztályt, melynek két attribútuma legyen, 
    az alkalmazott neve és születési éve! Majd az osztály main() metódusában 
    készíts egy néhány elemet tartalmazó listát az alkalmazottakból, és írd meg a következőket:

Összegezd az alkalmazottak születési éveit!
Összegezd az alkalmazottak életkorát!
Add vissza streammel, hány alkalmazott van a listában!
Add vissza, hány alkalmazott született 1990-nél korábban!
Add vissza a legkorábban született alkalmazott születési évét!
Add vissza a legkorábban született alkalmazott nevét! (Itt szükség lesz a findFirst() záróműveletre.)
Add vissza, hogy igaz-e, hogy minden alkalmazott 1980 előtt született-e?
Add vissza egy listában az összes, 1990-nél korábban született alkalmazottat!
Add vissza egy listában az összes alkalmazott nevét!
Az előző két feladat kombinációja: Add vissza egy listában az összes, 1990-nél korábban született alkalmazott nevét!*/

    private String name;
    private int birthYear;

    public Employee(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", birthYear=" + birthYear +
                '}';
    }

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Worker John", 1975));
        employees.add(new Employee("Lazy Luke", 2001));
        employees.add(new Employee("Beginner Jane", 1995));
        employees.add(new Employee("Expert David", 1980));
        employees.add(new Employee("Smith Julia", 1999));
        employees.add(new Employee("Doe Joe", 1985));

        int sumBirtYear = employees
                .stream()
                .mapToInt(Employee::getBirthYear)
                .sum();

        System.out.println(sumBirtYear);

        int actualYear = 2025;

        int sumAge = employees
                .stream()
                .mapToInt(Employee::getBirthYear)
                .map(year -> actualYear - year)
                .sum();

        System.out.println(sumAge);

        long employeeNumber = employees
                .stream()
                .count();

        System.out.println(employeeNumber);

        long employeeBornBefore1990 = employees
                .stream()
                .filter(employee -> employee.getBirthYear() < 1990)
                .count();

        System.out.println(employeeBornBefore1990);

        int theOldestEmployee = employees
                .stream()
                .mapToInt(Employee::getBirthYear)
                .min().orElseThrow(() -> new IllegalArgumentException("There is no employee"));

        System.out.println(theOldestEmployee);

        String theOldestEmployeeName = employees
                .stream()
                .sorted(Comparator.comparingInt(Employee::getBirthYear))
                .map(Employee::getName)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("There is no employee"));

        System.out.println(theOldestEmployeeName);

        boolean isEverybodyBornBefore1980 = employees
                .stream()
                .filter(employee -> employee.getBirthYear() < 1980)
                .collect(Collectors.toList())
                .isEmpty();

        System.out.println(isEverybodyBornBefore1980);

        List<Employee> employeesBornBefore1990 = employees
                .stream()
                .filter(employee -> employee.getBirthYear() < 1990)
                .collect(Collectors.toList());

        System.out.println(employeesBornBefore1990);

        List<String> names = employees
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(names);

        List<String> namesOfEmployeesBornBefore1990 = employees
                .stream()
                .filter(employee -> employee.getBirthYear() < 1990)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println(namesOfEmployeesBornBefore1990);

    }
}
