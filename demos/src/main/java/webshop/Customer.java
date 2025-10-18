package webshop;

import java.util.Objects;

public class Customer implements Comparable<Customer> {
    /*Customer (vásárló): Attribútumai a név, email, kategória (CustomerCategory enum).
     Két vásárlót e-mail cím alapján tekintünk egyezőnek. Az osztály példányainak
     az e-mail cím alapján természetes rendezettsége van. Egy példányt ne lehessen
     üres adatokkal létrehozni! A vásárlók a létrehozásukkor automatikusan egyszerű
     (SINGLE) kategóriájú vásárlónak minősülnek. Az osztály tartalmaz egy metódust,
     amellyel át lehet állítani a vásárlói kategóriát VIP-re.*/

    private final String name;
    private final String email;
    private CustomerCategory category;

    public Customer(String name, String email) {
        validate(name, email);
        this.name = name;
        this.email = email;
        this.category = CustomerCategory.SINGLE;
    }

    public void setCustomerToVip() {
        this.category = CustomerCategory.VIP;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public CustomerCategory getCategory() {
        return category;
    }

    private void validate(String name, String email) {
        if (name == null || name.isBlank() || email == null || email.isBlank()) {
            throw new IllegalArgumentException("Name or e-mail address cannot be empty!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }

    @Override
    public int compareTo(Customer another) {
        return this.email.compareTo(another.getEmail());
    }
}
