package searching;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookSearch {
    /*Készítsünk olyan osztályt, ami egy könyvtárban tárolt könyvek között
    tud keresni adott szerzőre és címre. Az osztályban a könyveket egy listában tároljuk,
    a keresés legyen bináris keresés!

Legyen egy Book osztály int id, String author és String title attribútumokkal!
A public int compareTo(Book o) metódust az igényeknek megfelelően készítsük el:
Alapértelmezetten szerző és ezen belül cím alapján rendezze a Book objektumokat!

Legyen ezután egy BookSearch osztály private List<Book> books attribútummal!
Ezt a listát az osztály konstruktora várja paraméterként! Az osztály publikus metódusa:
public Book findBookByAuthorTitle(String author, String title)
A két String paramétert le kell ellenőrizni, üres String esetén dobjon IllegalArgumentException-t!
Ha a bináris keresés nem talál könyvet, szintén dobjon a metódus
IllegalArgumentException-t a megfelelő tájékoztató szöveggel!*/

    private List<Book> books;

    public BookSearch(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public Book findBookByAuthorTitle(String author, String title) {
        if (author == null || author.isBlank() || title == null || title.isBlank()) {
            throw new IllegalArgumentException("Author or title must not be empty!");
        }
        int resultIndex = Collections.binarySearch(books, new Book(author, title));
        if (resultIndex < 0) {
            throw new IllegalArgumentException("No book found by " + author + " with title " + title);
        }
        return books.get(resultIndex);
    }
}
