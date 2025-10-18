package lambdaintermediate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    /*Készíts egy Coffee osztályt! Attribútumai: type - a kávé típusa,
    price - a kávé ára. A konstruktor is ebben a sorrendben kapja meg
    az adatokat!

A kávé típusához készíts egy CoffeeType enum-ot. Lehetséges értékei:
ESPRESSO, MACCHIATO, RISTRETTO, MOCHA, LATTE, CAPPUCCINO, AMERICANO.

A CoffeeOrder osztály tárolja az egy vásárló által megrendelt és
leszámlázott kávékat. Attibútumai: coffeeList - a megrendelt kávék
listája, dateTime - a vásárlás időpontja.

A Cafe osztály tartalmazza a kávézó összes rendelését egy listában.
A listát a konstruktorban kapja meg, de legyen lehetőség új rendelést
hozzáadni. Készítsd el benne az alábbi metódusokat streamek segítségével:

Integer getTotalIncome(): az eddigi összes bevétel
Integer getTotalIncome(LocalDate date): adott napi teljes bevétel
long getNumberOfCoffee(CoffeeType type): az adott típusú kávéból eladott összmennyiség
List<CoffeeOrder> getOrdersAfter(LocalDateTime from): a megadott időpont utáni
rendelések listája
List<CoffeeOrder> getFirstFiveOrder(LocalDate date): adott napon az első 5 vásárlásban
lévő rendelések listája*/

    private List<CoffeeOrder> coffeeOrders;

    public Cafe(List<CoffeeOrder> coffeeOrders) {
        this.coffeeOrders = coffeeOrders;
    }

    public void addCoffeeOrder(CoffeeOrder coffeeOrder) {
        coffeeOrders.add(coffeeOrder);
    }

    public Integer getTotalIncome() {
        return coffeeOrders
                .stream()
                .flatMap(x -> x.getCoffees().stream())
                .mapToInt(Coffee::getPrice)
                .sum();
    }

    public Integer getTotalIncome(LocalDate date) {
        return coffeeOrders
                .stream()
                .filter(coffeeorder -> coffeeorder.getDateTime().isAfter(date.atStartOfDay())
                        && coffeeorder.getDateTime().isBefore(date.atStartOfDay().plusDays(1)))
                .flatMap(x -> x.getCoffees().stream())
                .mapToInt(Coffee::getPrice)
                .sum();
    }

    public long getNumberOfCoffee(CoffeeType type) {
        return coffeeOrders
                .stream()
                .flatMap(x -> x.getCoffees().stream())
                .filter(coffee -> coffee.getType() == type)
                .count();
    }

    public List<CoffeeOrder> getOrdersAfter(LocalDateTime from) {
        return coffeeOrders
                .stream()
                .filter(coffeeOrder -> coffeeOrder.getDateTime().isAfter(from))
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getFirstFiveOrder(LocalDate date) {
        return coffeeOrders
                .stream()
                .filter(coffeeorder -> coffeeorder.getDateTime().toLocalDate().equals(date))
                .sorted(Comparator.comparing(CoffeeOrder::getDateTime))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<CoffeeOrder> getCoffeeOrders() {
        return new ArrayList<>(coffeeOrders);
    }
}
