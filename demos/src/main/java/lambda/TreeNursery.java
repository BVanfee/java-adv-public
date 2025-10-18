package lambda;

import java.util.ArrayList;
import java.util.List;

public class TreeNursery {

    /*Hozz létre egy Sapling (facsemete) nevű osztályt, amelynek attribútumai
    a következők legyenek: String species, int height (centiméterben vett
    magasság)! A magassághoz készíts setter metódust is! Majd hozz létre
    egy TreeNursery (faiskola) osztályt, mely egy listában tárolja a facsemetéket!
    Készítsd el a következő metódusokat:

A Sapling osztályban: void cut(int maxHeight) - a metódus úgy működik, hogy ha
az adott facsemete a megadott magasságnál nagyobb, akkor “visszavágja” a
megadott magasságra (beállítja azt magassági értékként), ha viszont annál kisebb,
 akkor békén hagyja.
A TreeNursery osztályban: void prune(int maxHeight) - ez a metódus “megmetszi” a
 fákat, vagyis a lista összes elemére meghívja a cut() metódust!
A TreeNursery osztályban: void sell(String species, int minHeight) - ez a metódus
 úgy működik, hogy ha az adott facsemete fajtája egyezik a megadott fajtával,
 illetve a magassága nagyobb, mint a paraméterül kapott érték, akkor “eladja”,
 vagyis törli a listából.*/

    private List<Sapling> saplings = new ArrayList<>();

    public TreeNursery(List<Sapling> saplings) {
        this.saplings = saplings;
    }

    public void prune(int maxHeight) {
        saplings.forEach(tree -> tree.cut(maxHeight));
    }

    public void sell(String species, int minHeight) {
        saplings.removeIf(tree -> tree.getSpecies().equals(species) && tree.getHeight() > minHeight);
    }

    public List<Sapling> getSaplings() {
        return new ArrayList<>(saplings);
    }

}
