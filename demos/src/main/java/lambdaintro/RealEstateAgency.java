package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RealEstateAgency {

    /*Hozz létre egy Flat osztályt, amelynek attribútumai a következők:
    cím, terület (négyzetméterben), ár (forintban)!

A RealEstateAgency osztály tartalmazzon egy listát az eladni szándékozott
lakásokról, és valósítsd meg benne a következő metódusokat:

private Flat findFirst(Predicate<Flat> condition) : egy olyan metódus, amelyet a többi metódus használni tud, amikor különböző, megadott feltételek alapján keresnek a lakások között. Ez a metódus úgy működik, hogy a paraméterül kapott feltétel alapján keres a lista lakásai között, és visszaadja a legelső találatot.
public Flat findFirstCheaperFlat(int maxPrice) : ez a metódus úgy adja át a findFirst() metódusnak paraméterül a feltételt, hogy az a megadott árnál olcsóbb lakást találjon.
public Flat findFirstGreaterFlat(double minArea) : ez a metódus úgy adja át a findFirst() metódusnak paraméterül a feltételt, hogy az a megadott területnél nagyobb lakást találjon.
public Flat findFirstFlatInSameTown(String town) : ez a metódus úgy adja át a findFirst() metódusnak paraméterül a feltételt, hogy az a megadott városban lévő lakást találjon.*/

    private List<Flat> flats;

    public RealEstateAgency(List<Flat> flats) {
        this.flats = flats;
    }

    public Flat findFirstCheaperFlat(int maxPrice) {
        return findFirst(flat -> flat.getPrice() < maxPrice);
    }

    public Flat findFirstGreaterFlat(double minArea) {
        return findFirst(flat -> flat.getArea() > minArea);
    }

    public Flat findFirstFlatInSameTown(String town){
        return findFirst(flat -> flat.getAddress().contains(town));
    }

    private Flat findFirst(Predicate<Flat> condition) {
        for (Flat flat : flats) {
            if (condition.test(flat)) {
                return flat;
            }
        }
        throw new IllegalArgumentException("No such flat.");
    }

    public List<Flat> getFlats() {
        return new ArrayList<>(flats);
    }
}
