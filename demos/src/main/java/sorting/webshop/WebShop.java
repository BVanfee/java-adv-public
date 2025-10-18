package sorting.webshop;

import java.util.*;

public class WebShop {
    /*Írj egy webshop.Product osztályt name, price és LocalDateTime date
     attribútumokkal, konstruktorral, getterekkel! Írj egy webshop.WebShop
      osztályt mely tartalmaz egy Product lista attribútumot! Implementálj
       három metódust, melyek a termékeket különböző sorrendben adják vissza
       (mindegyik más attribútuma szerint rendezze a termékeket)! Ne az
       eredeti listát rendezd, hanem mindig készíts egy másolatot!
       A Comparator implementációkat anonymous inner classként add meg!*/

    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }

    public void addProducts(Product... product) {
        products.addAll(Arrays.asList(product));
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getProductsOrderByName(){
        List<Product> ordered = new ArrayList<>(products);
        Collections.sort(ordered, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return ordered;
    }

    public List<Product> getProductsOrderByPrice(){
        List<Product> ordered = new ArrayList<>(products);
        ordered.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getPrice()-o2.getPrice();
            }
        });
        return ordered;

    }

    public List<Product> getProductsOrderByDate(){
        List<Product> ordered = new ArrayList<>(products);
        ordered.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return ordered;
    }
}
