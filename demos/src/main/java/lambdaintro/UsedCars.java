package lambdaintro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsedCars {
    /*Hozz létre egy Car osztályt, amelynek attribútumai a következők:
    márka, típus, ár, hossz (méterben)!

A UsedCars osztály tartalmazzon egy listát az eladni szándékozott autókról
és legyen három metódusa:

listCarsByPrice(): visszaad egy olyan listát, amelyben az autók áruk szerint
sorbarendezve szerepelnek.
listCarsByLengthDesc() : visszaad egy olyan listát, amelyben az autók hosszuk
 szerint fordított sorrendben szerepelnek (tehát a leghosszabb van elöl).
listCarsOneBrandByType(String brand) : visszaad egy olyan listát, amelyben
csak a megadott márkájú autók szerepelnek, típus szerint ábécé-sorrendben.
Ahol csak lehet, használj lambda-kifejezést vagy metódus referenciát!
Minden metódus egy-egy új listát adjon vissza, egyik se az eredeti lista
tartalmát rendezze!*/

    private List<Car> cars;

    public UsedCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> listCarsByPrice() {
        return cars
                .stream()
                .sorted(Comparator.comparingInt(Car::getPrice))
                .collect(Collectors.toList());
    }

    public List<Car> listCarsByLengthDesc() {
        return cars
                .stream()
                .sorted(new Comparator<Car>() {
                    @Override
                    public int compare(Car o1, Car o2) {
                        return (int) (o2.getLength() * 100) - (int) (o1.getLength() * 100);
                    }
                })
                .peek(System.out::println)
                .collect(Collectors.toList());

    }

    public List<Car> listCarsOneBrandByType(String brand) {
        return cars
                .stream()
                .filter(car -> car.getBrand().equals(brand))
                .sorted(new Comparator<Car>() {
                    @Override
                    public int compare(Car o1, Car o2) {
                        return o1.getType().compareTo(o2.getType());
                    }
                })
                .peek(System.out::println)
                .collect(Collectors.toList());
    }


    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }
}
