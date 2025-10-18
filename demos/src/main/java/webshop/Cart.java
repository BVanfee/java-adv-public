package webshop;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Cart {
    /*Cart: Ez az éppen aktuális, megkezdett, de még be nem fejezett vásárlás.
    Attribútumai egy vásárló és egy vásárlói kosár (Map<Product, Integer> típusú:
    termékek és az azokból vásárolt mennyiségek). Két kosár a vásárló alapján
    minősül egyezőnek (ez azért fontos, hogy egy vásárlónak ne lehessen egyszerre
    két megkezdett vásárlása). Az osztály tartalmaz egy metódust, amellyel egy
    terméket lehet hozzáadni a kosár tartalmához. Ez paraméterként a terméket és
    a vásárolni kívánt mennyiséget várja. Ha már benne van ez a termék a kosárban,
    akkor csak annak a mennyiségét növeli.*/

    private final Customer customer;
    private final Map<Product, Integer> products = new HashMap<>();

    public Cart(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be empty!");
        }
        this.customer = customer;
    }

    public void addCartItem(Product product, int numberOfProduct) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be empty.");
        } else if (numberOfProduct <= 0) {
            throw new IllegalArgumentException("Quantity cannot be 0 or a negative number");
        }
        if (!products.containsKey(product)) {
            products.put(product, numberOfProduct);
        } else {
            products.put(product, products.get(product) + numberOfProduct);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(customer, cart.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(customer);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Map<Product, Integer> getProducts() {
        return new HashMap<>(products);
    }
}
