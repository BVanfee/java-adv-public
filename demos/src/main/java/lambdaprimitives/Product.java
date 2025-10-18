package lambdaprimitives;

public class Product {
    /*Hozz létre egy Product osztályt, amely a sportszer nevét, árát, darabszámát tárolja!
    A konstruktora is ezeket kapja meg, ugyanebben a sorrendben!
    A SportGadgetStore osztály tárolja a termékek listáját, és
    különböző statisztikákat készít belőle. Az osztály kapja meg a listát kívülről!

Készítsd el a következő metódusokat streamek segítségével (minden metódusban
alakítsd primitívek streamjévé a lista objektumait):

int getNumberOfProducts(): összesen hány termék van a boltban.
double getAveragePrice(): átlagosan mennyibe kerül egy termék.
Ha nincs termék, 0-t adjon vissza.
String getExpensiveProductStatistics(double minPrice): adott árnál
drágább termékek darabszámáról szolgáltat statisztikát. Az összesítést
szövegként adja vissza az alábbi formában:
Összesen 3 féle termék, amelyekből minimum 1 db, maximum 52 db, összesen 74 db van.

Ha nincs ilyen, akkor a visszaadott szöveg a Nincs ilyen termék. legyen!*/

    private String name;
    private double price;
    private int pieces;

    public Product(String name, double price, int pieces) {
        this.name = name;
        this.price = price;
        this.pieces = pieces;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getPieces() {
        return pieces;
    }
}
