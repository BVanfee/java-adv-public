package webshop;

import java.util.Objects;

public class Product {
    /*Product (termék): Attribútumai a vonalkód, név, ár, kategória (ProductCategory enum).
    Két terméket a vonalkód alapján tekintünk egyezőnek. Egy példányt ne lehessen üres adatokkal
    vagy negatív árral létrehozni!*/

    private final String barcode;
    private final String name;
    private final int price;
    private final ProductCategory category;

    public Product(String barcode, String name, int price, ProductCategory category) {
        validate(barcode, name, price, category);
        this.barcode = barcode;
        this.name = name;
        this.price = price;
        this.category = category;

    }

    private void validate(String barcode, String name, int price, ProductCategory category) {
        if (barcode == null || barcode.isBlank()) {
            throw new IllegalArgumentException("Barcode cannot be empty!");
        } else if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty!");
        } else if (price < 0) {
            throw new IllegalArgumentException("Price must be 0 or positive!");
        } else if (category == null || !category.getDeclaringClass().isEnum()) {
            throw new IllegalArgumentException("Category cannot be empty!");
        }
    }

    public String getBarcode() {
        return barcode;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(barcode, product.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(barcode);
    }
}
