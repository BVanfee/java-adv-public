package streams;

public class Book {
    /*Készíts egy Book osztályt, melynek attribútumai: szerző, cím
    és az oldalak száma! Majd készíts egy Read osztályt, amelynek
    van egy könyveket tartalmazó lista attribútuma! Legyen az
    osztálynak egy List<String> listBookTitlesShorterThanGiven(int maxNumberOfPages)
    metódusa, amely kiválogatja és egy listában visszaadja azon könyvek címét,
    amelyek a megadott paraméternél kevesebb oldalból állnak! Írj egy
    List<String> listBookTitlesWithGivenAuthor(String author) metódust, amely
    ábécé-sorrendben adja vissza egy paraméterül kapott szerző könyveinek címeit!
    Végül írj egy List<String> listAuthors() metódust, amely egy listában
    visszaadja a szerzők neveit! Fontos, hogy minden szerző neve csak egyszer
    szerepeljen!*/

    private String author;
    private String title;
    private int numberOfPages;

    public Book(String author, String title, int numberOfPages) {
        this.author = author;
        this.title = title;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }
}
