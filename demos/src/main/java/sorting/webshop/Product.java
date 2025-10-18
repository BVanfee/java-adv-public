package sorting.webshop;

import java.time.LocalDateTime;

public class Product {

    private String name;
    private int price;
    private LocalDateTime date;

    public Product(String name, int price, LocalDateTime date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
