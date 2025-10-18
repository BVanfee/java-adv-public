package filescanner;

public class Book {
    /*Egy könyvtár nyilvántartása a könyvek leltári számát,
    szerzőjét, címét és a kiadás évét tartalmazza. Készíts egy
    Book osztályt, mely konstruktorában megkapja ezeket az adatokat!
    Minden adata lekérdezhető, de egyik sem módosítható. A Library
    osztály attribútumként egy List<Book>-ot tartalmaz. A loadFromFile()
     metódusa a classpath-on található books.csv fájlból tölti be a könyvek
     adatait. A fájl minden sora egy könyv adatait tartalmazza pontosvesszővel
      elválasztva.

UML osztály diagram
UML osztály diagram
Tipp: Könnyebb a fájl olvasása, ha mind a ;-t, mind a sorvége karaktert
beállítod a Scanner elválasztójaként. Ehhez használd delimiterként
a ";|(\r\n)" kifejezést!*/

    private String registryNumber;
    private String author;
    private String title;
    private int year;

    public Book(String registryNumber, String author, String title, int year) {
        this.registryNumber = registryNumber;
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getRegistryNumber() {
        return registryNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
