package lambdaoptional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Costumer {

    /*Hozz létre egy Costume osztályt, amelynek attribútumai a
    következők: leírás, méret (egy enum, S, M, L, XL felsorolókkal),
    ár (forintban)!

A Costumer osztály tartalmazzon egy listát az eladó jelmezekről,
és valósítsd meg benne a következő metódusokat:

private Optional<Costume> findFirst(Predicate<Costume> condition) :
egy olyan metódus, amelyet a többi metódus használni tud, amikor
különböző, megadott feltételek alapján keresnek a jelmezek között.
Ez a metódus úgy működik, hogy a paraméterül kapott feltétel alapján
keres a lista elemei között, és visszaadja a legelső találatot,
Optional-be csomagolva. Ha nem talál megfelelő elemet, akkor üres
Optional-t ad vissza.

Optional<Costume> findFirstCostumeWithKeyWord(String keyWord) :
ez a metódus úgy adja át a findFirst() metódusnak paraméterül a
feltételt, hogy az olyan jelmezt találjon, amelynek leírásában
szerepel a megadott kulcsszó.

Optional<Costume> findFirstCheaperCostume(int maxPrice) : ez a metódus
 úgy adja át a findFirst() metódusnak paraméterül a feltételt, hogy az
  a megadott árnál olcsóbb jelmezt találjon.

Optional<Costume> findFirstCostumeSameSize(Size size) : ez a metódus
úgy adja át a findFirst() metódusnak paraméterül a feltételt, hogy az
a megadott mérettel megegyező jelmezt találjon.*/

    private List<Costume> costumes;

    public Costumer(List<Costume> costumes) {
        this.costumes = costumes;
    }

    public Optional<Costume> findFirstCostumeWithKeyWord(String keyWord){
        return findFirst(costume -> costume.getDescription().contains(keyWord));
    }

    public Optional<Costume> findFirstCheaperCostume(int maxPrice) {
        return findFirst(costume -> costume.getPrice() < maxPrice);
    }

    public Optional<Costume> findFirstCostumeSameSize(Size size){
        return findFirst(costume -> costume.getSize() == size);
    }

    public List<Costume> getCostumes() {
        return new ArrayList<>(costumes);
    }

    private Optional<Costume> findFirst(Predicate<Costume> condition) {
        for (Costume costume : costumes) {
            if (condition.test(costume)) {
                return Optional.of(costume);
            }
        }
        return Optional.empty();
    }
}
