package webshop;

import java.util.*;

public class Store {

    /*Store (raktár): Attribútuma a termékek halmaza. Metódusai a következő funkciókat látják el:

Termék hozzáadása (a metódus a terméket várja paraméterül).
Egy metódus visszaadja a paraméterként megadott vonalkóddal rendelkező terméket.
Ha nem talál ilyet, kivételt dob a megfelelő üzenettel.
Egy metódus visszaadja egy Map<ProductCategory, List<Product>>-ben, hogy kategóriánként milyen termékek vannak.
Egy metódus visszaadja a legolcsóbb terméket egy paraméterként megadott kategóriából.
Egy metódus visszaadja a termékeket egy listában, ár szerint rendezve, legolcsóbbtól a legdrágábbig.
Egy metódus visszaadja a termékeket egy listában, név szerint ábécé sorrendbe rendezve.*/

    private final Set<Product> products = new HashSet<>();

    public Set<Product> getProducts() {
        return new HashSet<>(products);
    }

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be empty!");
        } else if (productExits(product)) {
            throw new IllegalArgumentException("Product with barcode: " + product.getBarcode() + " is already registered.");
        }
        products.add(product);
    }

    public Product getProductByBarcode(String barcode) {
        if (barcode == null || barcode.isBlank()) {
            throw new IllegalArgumentException("Barcode can not be empty or null!");
        }
        for (Product product : products) {
            if (product.getBarcode().equals(barcode)) {
                return product;
            }
        }
        throw new IllegalArgumentException("No product with barcode: " + barcode);
    }

    public Map<ProductCategory, List<Product>> getProductsByCategory() {
        Map<ProductCategory, List<Product>> productsByCategory = new HashMap<>();
        for (Product product : products) {
            if (!productsByCategory.containsKey(product.getCategory())) {
                productsByCategory.put(product.getCategory(), new ArrayList<>(List.of(product)));
            } else {
                productsByCategory.get(product.getCategory()).add(product);
            }
        }
        return productsByCategory;
    }

    public Product getCheapestProductByCategory(ProductCategory category) {
        Product product = null;
        if (getProductsByCategory().containsKey(category)) {
            List<Product> productsByGivenCategory = getProductsByCategory().get(category);
            int minPrice = Integer.MAX_VALUE;
            for (Product actualProduct : productsByGivenCategory) {
                if (actualProduct.getPrice() < minPrice) {
                    minPrice = actualProduct.getPrice();
                    product = actualProduct;

                }
            }
        }
        if(product == null){
            throw new IllegalArgumentException("There is no products in category: " + category);
        }
        return product;
    }

    public List<Product> listProductsSortedByPrice(){
        List<Product> ordered = new ArrayList<>(products);
        ordered.sort(new Comparator<Product>() {
            @Override
            public int compare(Product firstProduct, Product nextProduct) {
                return firstProduct.getPrice()- nextProduct.getPrice();
            }
        });
        return ordered;
    }

    public List<Product> listProductsSortedByName(){
        List<Product> ordered = new ArrayList<>(products);
        ordered.sort(new Comparator<Product>() {
            @Override
            public int compare(Product firstProduct, Product nextProduct) {
                return firstProduct.getName().compareTo(nextProduct.getName());
            }
        });
        return ordered;
    }

    private boolean productExits(Product product) {
        return products.contains(product);
    }
}
