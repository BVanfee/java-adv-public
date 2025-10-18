package sorting;

public class Car {

    private String brand;
    private int constructionYear;
    private int price;

    public Car(String brand, int constructionYear, int price) {
        this.brand = brand;
        this.constructionYear = constructionYear;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public int getConstructionYear() {
        return constructionYear;
    }

    public int getPrice() {
        return price;
    }
}
