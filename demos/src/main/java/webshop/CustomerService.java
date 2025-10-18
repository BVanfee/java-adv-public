package webshop;

import java.text.Collator;
import java.util.*;

public class CustomerService {
    /*CustomerService (vevőszolgálat): Attribútuma a vásárlók halmaza. 
    Metódusai a következő funkciókat látják el:

Vásárló hozzáadása (a metódus a vásárlót várja paraméterül).
Egy metódus visszaadja egy listában a paraméterként megadott kategóriájú vásárlókat.
Egy metódus visszaadja a paraméterként megadott e-mail címmel rendelkező vásárlót. 
Ha nem talál ilyet, kivételt dob a megfelelő üzenettel.
Egy metódus visszaadja a vásárlókat egy listában, e-mail szerint rendezve.
Egy metódus visszaadja a vásárlók neveit egy listában, magyar ábécé szerint rendezve.*/

    private final Set<Customer> customers = new HashSet<>();

    public void addCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be empty.");
        } else if (customerExits(customer)) {
            throw new IllegalArgumentException("Customer with e-mail address: " + customer.getEmail() + " is already registered.");
        }
        customers.add(customer);
    }

    public List<Customer> listCustomersByCategoryGiven(CustomerCategory category) {
        if (customersMapOrderedByCategory().containsKey(category)) {
            return customersMapOrderedByCategory().get(category);
        }
        throw new IllegalArgumentException("There is no customers with this category: " + category);
    }

    public Customer getCustomerByEmail(String email) {
        Customer customer = null;
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Email can not be empty.");
        }
        for (Customer actualCustomer : customers) {
            if(email.equals(actualCustomer.getEmail())){
                customer = actualCustomer;
            }
        }
        if (customer == null) {
            throw new IllegalArgumentException("No customer with e-mail address: " + email);
        }
        return customer;
    }

    public List<Customer> listCustomersSortedByEmail(){
        List<Customer> ordered = new ArrayList<>(customers);
        ordered.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer firstCustomer, Customer nextCustomer) {
                return firstCustomer.getEmail().compareTo(nextCustomer.getEmail());
            }
        });
        return ordered;
    }

    public List<String> listCustomerNamesSorted(){
        List<String> names = new ArrayList<>();
        for (Customer customer : customers) {
            names.add(customer.getName());
        }
        names.sort(Collator.getInstance(new Locale("hu", "HU")));
        return names;
    }

    public Set<Customer> getCustomers() {
        return new HashSet<>(customers);
    }

    private Map<CustomerCategory, List<Customer>> customersMapOrderedByCategory() {
        Map<CustomerCategory, List<Customer>> customersByCategory = new HashMap<>();
        for (Customer customer : customers) {
            if (!customersByCategory.containsKey(customer.getCategory())) {
                customersByCategory.put(customer.getCategory(), new ArrayList<>(List.of(customer)));
            } else {
                customersByCategory.get(customer.getCategory()).add(customer);
            }
        }
        return customersByCategory;
    }

    private boolean customerExits(Customer customer) {
        return customers.contains(customer);
    }
}
