package genericsusage.withgenerics;

import genericsusage.Book;

import java.util.List;

public class Library {

/*Valósítsd meg a getFirstBook(List<Book> books) metódust generikusok használatával!
 Ha a könyvtárat reprezentáló kollekció null, a metódus dobjon NullPointerException
 kivételt! Ha a könyvtárat reprezentáló kollekció üres,
 a metódus dobjon IllegalArgumentException kivételt!*/

//    private final List<Book> books = new ArrayList<>();

    public Book getFirstBook(List<Book> books) {
        if (books == null) {
            throw new NullPointerException("Argument should not be null!");
        } else if (books.isEmpty()) {
            throw new IllegalArgumentException("Argument should not be empty!");
        }
        return books.get(0);
    }
}
