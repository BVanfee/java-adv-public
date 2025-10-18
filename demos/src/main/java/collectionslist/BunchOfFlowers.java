package collectionslist;

import java.util.LinkedList;
import java.util.List;

public class BunchOfFlowers {

    /*Készíts egy BunchOfFlowers osztályt,
    és ennek legyen egy LinkedList típusú listája,
    amely egy virágcsokrot reprezentál!
    A virágcsokorban String objektumok reprezentálják
    az egyes virágszálakat! Legyen az osztálynak egy
    addFlowerInTheMiddle(String flower)metódusa,
    amely a paraméterül átadott szál virágot éppen a
    csokor közepére illeszti be, ha a csokor páros
    számú szálat tartalmaz! Ha azonban a csokorban
    páratlan számú virág van, akkor pedig a középen
    lévő elem jobb és bal oldalára tegyen be egyet-egyet
    a paraméterként átadott szál virágból!*/

    private List<String> flowers = new LinkedList<>();

    public List<String> getBunch() {
        return flowers;
    }

    public void addFlowerInTheMiddle(String flower) {
        int middleIndex = flowers.size() / 2;
        if (flowers.size() % 2 == 0) {
            flowers.add(middleIndex, flower);
        }else{
            flowers.add(middleIndex, flower);
            flowers.add(middleIndex+2,flower );
        }

    }

    public void addFlower(String flower) {
        flowers.add(flower);
    }
}
