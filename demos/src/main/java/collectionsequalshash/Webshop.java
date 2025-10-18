package collectionsequalshash;

import java.util.ArrayList;
import java.util.List;

public class Webshop {
    /*Legyen egy Product osztályod és azon belül
    két attribútum: név és regisztrációs szám!
    Egy webáruházban a regisztrációs számuk alapján
    különböztetik meg a termékeket, ezért a
    Product osztályban ez alapján írd felül az equals()
    és a hashCode() metódusokat!
    Majd legyen egy WebShop osztályod is,
    amelynek van egy listája, ahol nyilvántartja
    az általa árusított termékeket!
    Készíts egy findHowMany(Product product) metódust,
    amely a paraméterként átadott termék equals()
    metódusát felhasználva visszaadja, hogy hányszor
    szerepel az adott termék a webáruház listájában.
    Ezután az osztály main() metódusában próbáld is ki,
    hogy több különböző, de ugyanolyan regisztrációs
    számmal rendelkező terméket adsz a listához,
    majd meghívod a findHowMany() metódust, átadva neki
    egy szintén újonnan példányosított, de ugyanolyan
    regisztrációs számú terméket! Írd ki a metódus
    visszatérési értékét a konzolra!*/

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public int findHowMany(Product product){
        int counter = 0;
        for (Product product1 : products) {
            if(product1.equals(product)){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Webshop webshop = new Webshop();

        webshop.addProduct(new Product("Krém", "1235"));
        webshop.addProduct(new Product("Krém", "1235"));
        webshop.addProduct(new Product("Krémes", "2235"));
        webshop.addProduct(new Product("Kártya", "3335"));
        webshop.addProduct(new Product("Kaja", "1235"));
        webshop.addProduct(new Product("Krém", "1335"));

        System.out.println(webshop.findHowMany(new Product("Krém", "1235")));
    }
}
