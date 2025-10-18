package lambdacollectors.christmastree;

public class ChristmasTree {

    /*Hozz létre egy christmastree.ChristmasTree osztályt, melynek
    attribútumai legyenek a következők: PineTreeType type, double height!
    A PineTreeType legyen egy enum, NORDMANN, SILVER, SPRUCE felsorolókkal,
    és legyen az enumnak egy int pricePerMeter attribútuma, amelynek értéke
    a különböző fenyőfajtáktól függően legyen rendre 10000 Ft, 8000 Ft és 4000 Ft
    a méterenkénti ára!
     Ezután hozz létre egy ChristmasTreeFair osztályt, amely listában tárolja az
      eladó fenyőfákat! Collectorok segítségével valósítsd meg benne a következő
      metódusokat:

Map<PineTreeType, Long> getCountByType(): egy Map-ben visszaadja, hogy fajtánként hány darab fa kapható.
double getMaxHeightByType(PineTreeType type): visszaadja a paraméterül kapott típusból a legmagasabb fa méretét. Ha nem talál megfelelő fát vagy a lista üres, adjon vissza 0.0-t!
double getAveragePrice(): visszaadja az összes kapható fa árából számolt átlagos árat. Ha üres a lista, 0.0-t adjon vissza!*/

    private PineTreeType type;
    private double height;

    public ChristmasTree(PineTreeType type, double height) {
        this.type = type;
        this.height = height;
    }

    public PineTreeType getType() {
        return type;
    }

    public double getHeight() {
        return height;
    }
}
