package lambdaprimitives;

public class Cargo {
    /*Hozz létre egy Cargo osztályt, amelynek attribútumai: String description,
    int weight és double length! Majd hozz létre egy Truck osztályt, amely tárol
     egy listát a rakományról: List<Cargo> thingsToLoad!

Készítsd el a következő metódusokat streamek segítségével (minden metódusban
alakítsd primitívek streamjévé a lista objektumait):

double getShortestLength(): visszaadja a legrövidebb rakomány hosszát (ha üres
a lista, adjon vissza 0.0-t).
int getTotalWeight(): visszaadja az rakomány összsúlyát.
double getAverageWeight(): visszaadja az átlagos súlyt, illetve ha nincs
rakomány, amiből számoljon (üres a lista), akkor dobjon IllegalArgumentException-t
 "No cargo." szöveggel!
int getMaxWeight(): visszaadja a legnehezebb rakomány súlyát (ha üres a lista,
adjon vissza 0-t).
String getWeightStatistics(): visszaad egy statisztikát a rakomány súlyát
érintően a következőhöz hasonló formában:
A rakományban található 5 tétel, melyeknek összsúlya 495 kg, közülük a
legnehezebb 300 kg, a legkönnyebb 15 kg. A súlyuk átlagosan 99.0 kg.

Ha nincs rakomány (üres a lista), akkor adja vissza a "No cargo." szöveget!*/

    private String description;
    private int weight;
    private double length;

    public Cargo(String description, int weight, double length) {
        this.description = description;
        this.weight = weight;
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public double getLength() {
        return length;
    }
}
