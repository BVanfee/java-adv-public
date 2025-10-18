package lambdacollectors.honey;

public class Honey {

    /*Egy méhész csak meghatározott fajtájú mézeket termel, és azokat csak
     meghatározott méretű üvegekben adja el. A mézek fajtáit a HoneyType
      enum reprezentálja: MULTIFLORAL(1200), ACACIA(1800), LINDEN(1500).
      A különböző fajták után zárójelben álló szám minden fajtának a
      kilogrammonkénti ára (ez az osztály attribútuma). Az üvegek típusait
      a GlassSize enum tárolja: BIG(1.0), SMALL(0.5), TASTER_SIZE(0.05).
      Az egyes típusok után zárójelben álló szám az üveg méretét adja meg
      oly módon, hogy hány kilogramm mézet lehet az adott fajta üvegbe tenni.
      Legyen egy Honey osztály, és annak legyen mindkét enum típusú attribútuma!
       Végül legyen egy BeeKeeper osztály, amely egy listában tárolja az összes
        megtermelt mézet. Ebben az osztályban Collectorok segítségével valósítsd
         meg az alábbi metódusokat:

int getTotalValueOfGivenGlasses(GlassSize size): visszaadja a paraméterül kapott
 méretű üvegben lévő mézek összértékét (fajtától függetlenül).
Map<GlassSize, Long> getAmountsOfGivenType(HoneyType type): visszaad egy Map-et,
 melyben csak a paraméterül kapot fajta mézet tartalmazó üvegek vannak.
 A Map kulcsai az egyes üvegméretek, értékei pedig az, hogy egyféle méretű
 üvegnyi mézből hány darab van.
Map<Boolean, List<Honey>> getGroupsByGivenTypeAndSize(HoneyType type, GlassSize size):
visszaad egy Map-et, melyben a mézek két csoportra vannak osztva: az egyik
csoportban true kulccsal szerepelnek azok, amelyek a paraméterül kapott típusúak
 és a paraméterül kapott méretű üvegben vannak, a másik csoportban false kulccsal
  szerepel az összes többi méz.*/

    private HoneyType type;
    private GlassSize size;

    public Honey(HoneyType type, GlassSize size) {
        this.type = type;
        this.size = size;
    }

    public double getPrice() {
        return type.getPricePerKg() * size.getCapacityInKg();
    }

    public HoneyType getType() {
        return type;
    }

    public GlassSize getSize() {
        return size;
    }
}
