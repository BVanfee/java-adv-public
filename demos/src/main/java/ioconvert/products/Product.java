package ioconvert.products;

public class Product {
    /*Az ioconvert.products csomagba hozd létre a ProductWriter osztályt,
    és benne a saveProduct() metódust, mely két paramétert kap: egy OutputStream-et
     és egy List<Product>-ot. A feladata a lista adatait kiírni csv formátumban az
     OutputStream-re, azaz pontosvesszővel elválasztva a Product adatait. Minden
     termék külön sorba kerüljön, a sor végére nem kell ;. Kiíráshoz használd a
     PrintStream osztályt!

A Product tartalmazza a termék nevét (String) és az árát (int).*/

    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
