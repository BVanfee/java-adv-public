package webshop;

import java.time.LocalDateTime;
import java.util.*;

public class WebShop {

    /*WebShop: Ez az osztály reprezentálja magát a webáruházat. Attribútumai a raktár, a vevőszolgálat, a
    megkezdett vásárlások halmaza és egy lista a véglegesített megrendelésekből. Az osztály metódusai a
    következő funkciókat látják el:*/

    private Store store;
    private CustomerService customerService;
    private Set<Cart> carts = new HashSet<>();
    private List<Order> orders = new ArrayList<>();

    public WebShop(Store store, CustomerService customerService) {
        validate(store, customerService);
        this.store = store;
        this.customerService = customerService;
    }

    public Store getStore() {
        return store;
    }

    public CustomerService getCustomerService() {
        return customerService;
    }

    public Set<Cart> getCarts() {
        return new HashSet<>(carts);
    }

    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }


    public void addProduct(Product product) {
        /*Termék hozzáadása (a metódus paraméterként a terméket várja,
        majd delegálja a kérést a Store osztály megfelelő metódusának).*/
        store.addProduct(product);
    }

    public void addCustomer(Customer customer) {
        /*Vásárló hozzáadása (a metódus paraméterként a vásárlót várja,
        majd delegálja a kérést a CustomerService osztály megfelelő metódusának).*/
        customerService.addCustomer(customer);
    }

    public void beginShopping(String email) {
        /*Vásárlás elkezdése. A metódus egy vásárló e-mail címét várja paraméterül,
        kikeresi a vásárlót, majd létrehoz számára egy új vásárlást (Cart).
        Ez még csak egy elkezdett vásárlás, tehát módosítható vagy akár törölhető is később.*/
        Customer customer = customerService.getCustomerByEmail(email);
        for (Cart cart : carts) {
            if (cart.getCustomer().equals(customer)) {
                throw new IllegalArgumentException("Customer with e-mail address: " + email + " has already began shopping!");
            }
        }
        carts.add(new Cart(customer));
    }

    public void addCartItem(String email, String barcode, int quantity) {
        /*Legyen egy metódus, mellyel a vásárló terméket tud rakni a kosarába!
        Ez paraméterül a vásárló e-mail címét, a termék vonalkódját és a vásárolni kívánt
        mennyiséget várja.
        Ha nem talál az adott vásárlóhoz megkezdett vásárlást, dobjon kivételt! Akkor is kivételt kell dobni,
        ha a vásárolni kívánt mennyiség 1-nél kisebb szám.*/
        Product product = store.getProductByBarcode(barcode);
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity cannot be 0 or a negative number");
        }
        findCartByEmail(email).addCartItem(product, quantity);
    }

    public void rejectCart(String mail) {
        /*Vásárlás elvetése. Paraméterként a vásárló e-mail címét kell megadni,
        és ez alapján a metódus törli az adott felhasználó megkezdett vásárlását a halmazból.*/
        if (mail == null || mail.isBlank()) {
            throw new IllegalArgumentException("Email can not be empty.");
        }
        Iterator<Cart> iterator = carts.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getCustomer().getEmail().equals(mail)) {
                iterator.remove();
            }
        }
    }

    public long order(String email, LocalDateTime timeOfOrder) {
        /*Megrendelés véglegesítése: A metódus a vásárló e-mail címét és a megrendelés
        időpontját várja paraméterül, létrehoz egy új Order-t, átmásolja bele a vásárló
        kosarának aktuális tartalmát, hozzáadja a véglegesített megrendelések listájához,
        majd visszatér a megrendelés id-jával. Id-t úgy készít a megrendelésnek, hogy lekéri
        annak a listában elfoglalt helyét (index + 1). A metódus törli az eddigi ideiglenes
        kosarat, valamint vizsgálja azt is, hogy a vásárlónak ez a hányadik vásárlása,
        ugyanis 5 véglegesített vásárlás után a vásárló kategóriáját VIP-re állítja,
        így a 6. vásárlástól kezdve jár majd neki a kedvezmény.*/
        Customer customer = customerService.getCustomerByEmail(email);
        Cart cart = findCartByEmail(email);
        long id = orders.size() + 1;
        orders.add(new Order(id, timeOfOrder, customer, cart.getProducts()));
        rejectCart(email);
        if (getOrderNumberOfACustomer(customer) == 5) {
            customer.setCustomerToVip();
        }
        return id;
    }


    public List<Customer> getCustomersByProduct(String barcode) {
        /*Egy metódus visszaadja egy halmazban, hogy mely felhasználók vásároltak
        egy bizonyos termékből (paraméterül a termék vonalkódját kell megadni,
        és csak a véglegesített megrendeléseket kell vizsgálni).*/
        Product product = store.getProductByBarcode(barcode);
        Set<Customer> customers = new HashSet<>();
        for (Order order : orders) {
            if (order.getCart().containsKey(product)) {
                customers.add(order.getCustomer());
            }
        }
        return new ArrayList<>(customers);
    }

    public Map<Long, Integer> getTotalAmounts() {
        /*Egy metódus visszaadja egy Map<Long, Integer>-ben (vásárlás id és végösszeg),
    hogy egyes vásárlásoknál mennyi a vásárlás végösszege (csak a véglegesített
    megrendeléseket kell vizsgálni).*/
        Map<Long, Integer> totalAmounts = new HashMap<>();
        for (Order order : orders) {
            totalAmounts.put(order.getId(), order.getTotalAmount());

        }
        return totalAmounts;
    }


    public Customer getCustomerWithMaxTotalAmount() {
        /*Egy metódus visszaadja a legtöbbet fizető vásárlót
    (csak a véglegesített megrendeléseket kell vizsgálni).*/
        long id = 0;
        int maxSum = Integer.MIN_VALUE;
        for (Map.Entry<Long, Integer> longIntegerEntry : getTotalAmounts().entrySet()) {
            if (longIntegerEntry.getValue() > maxSum) {
                maxSum = longIntegerEntry.getValue();
                id = longIntegerEntry.getKey();
            }
        }
        Order order = null;
        for (Order actualOrder : orders) {
            if (actualOrder.getId() == id) {
                order = actualOrder;
            }
        }
        if (order == null) {
            throw new IllegalArgumentException("No such customer.");
        }
        return order.getCustomer();

    }

    public List<Order> listOrdersSortedByTotalAmounts() {
    /*Egy metódus visszaadja egy listában a vásárlásokat a kifizetett végösszeg szerint,
    első helyre rakva a legnagyobb összegű vásárlást (csak a véglegesített megrendeléseket
    kell vizsgálni).*/
        List<Order> ordered = new ArrayList<>(orders);
        ordered.sort(new Comparator<Order>() {
            @Override
            public int compare(Order firstOrder, Order nextOrder) {
                return nextOrder.getTotalAmount() - firstOrder.getTotalAmount();
            }
        });
        return ordered;
    }

    public List<Order> listOrdersSortedByDate() {
        /*Egy metódus visszaadja egy listában a vásárlásokat a megrendelés dátuma alapján,
    elöl legyen a legfrissebb megrendelés (csak a véglegesített megrendeléseket kell vizsgálni).*/
        List<Order> ordered = new ArrayList<>(orders);
        ordered.sort(new Comparator<Order>() {
            @Override
            public int compare(Order firstOrder, Order nextOrder) {
                return nextOrder.getTimeOfOrder().compareTo(firstOrder.getTimeOfOrder());
            }
        });
        return ordered;
    }

    public boolean hasCustomerBoughtProduct(String email, String barcode) {
        /*Egy metódus paraméterként egy vásárló e-mail címét és egy termék vonalkódját várja, és
    visszaadja, hogy az a vásárló vásárolt-e az adott termékből
    (csak a véglegesített megrendeléseket kell vizsgálni).*/
        List<Customer> customers = getCustomersByProduct(barcode);
        for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    private int getOrderNumberOfACustomer(Customer customer) {
        int counter = 0;
        for (Order order : orders) {
            if (order.getCustomer().equals(customer)) {
                counter++;
            }
        }
        return counter;
    }

    private Cart findCartByEmail(String email) {
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email can not be empty.");
        }
        for (Cart cart : carts) {
            if (cart.getCustomer().getEmail().equals(email)) {
                return cart;
            }
        }
        throw new IllegalArgumentException("Customer with e-mail address " + email + " does not have an actual cart yet.");
    }

    private void validate(Store store, CustomerService customerService) {
        if (store == null) {
            throw new IllegalArgumentException("Store cannot be empty!");
        } else if (customerService == null) {
            throw new IllegalArgumentException("Customer service cannot be empty!");
        }
    }
}
