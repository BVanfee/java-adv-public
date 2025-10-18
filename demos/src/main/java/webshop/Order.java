package webshop;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {

    /*Order: Ez egy véglegesített megrendelés. Attribútumai egy id,
    a megrendelés időpontja, valamint egy vásárló és egy vásárlói kosár
    (Map<Product, Integer> típusú: termékek és az azokból vásárolt mennyiségek).
    Az osztály konstruktora mindegyik attribútum értékét paraméterül várja.
    Ne lehessen egy példányt üres adatokkal létrehozni!
    Az osztály metódusai:

Egy metódus visszaadja a vásárlás végösszegét.
A végösszeg számításánál figyelembe kell venni, hogy a vásárlónak
jár-e kedvezmény (a vásárlói kategóriájának megfelelően).

Egy metódus paraméterként egy terméket vár, és visszaadja,
hogy a vásárló vásárolt-e az adott termékből.*/

    private final long id;
    private final LocalDateTime timeOfOrder;
    private final Customer customer;
    private final Map<Product, Integer> cart;

    public Order(long id, LocalDateTime timeOfOrder, Customer customer, Map<Product, Integer> cart) {
        validate(id, timeOfOrder, customer, cart);
        this.id = id;
        this.timeOfOrder = timeOfOrder;
        this.customer = customer;
        this.cart = cart;
    }

    public int getTotalAmount() {
        int sumOfOrder = 0;
        double result = 0;
        for (Map.Entry<Product, Integer> productAndPieces : cart.entrySet()) {
            int priceOfProduct = productAndPieces.getKey().getPrice();
            int pieceOfProduct = productAndPieces.getValue();
            sumOfOrder += (priceOfProduct * pieceOfProduct);
        }
        if (customer.getCategory().getDiscount() != 0) {
            double discount = ((double) (100 - customer.getCategory().getDiscount()) / 100);
            result = sumOfOrder * discount;
        }else{
            result = sumOfOrder;
        }
        return (int)result;
    }

    public boolean hasCustomerBoughtProduct(Product product) {
        return cart.containsKey(product);
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getTimeOfOrder() {
        return timeOfOrder;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getCart() {
        return new HashMap<>(cart);
    }

    private void validate(long id, LocalDateTime timeOfOrder, Customer customer, Map<Product, Integer> cart) {
        if (id == 0) {
            throw new IllegalArgumentException("Number 0 is not a valid id!");
        } else if (timeOfOrder == null) {
            throw new IllegalArgumentException("Time of order cannot be empty!");
        } else if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be empty!");
        } else if (cart == null || cart.isEmpty()) {
            throw new IllegalArgumentException("Cart cannot be empty!");
        }
    }
}
