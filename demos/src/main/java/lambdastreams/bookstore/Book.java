package lambdastreams.bookstore;

public class Book {

    /*Készíts egy bookstore.Book osztályt a könyv címével, kiadási
    évével, árával, darabszámával! A konstruktor is ebben a sorrendben
    kapja meg az adatokat!

A BookStore osztály tartalmazza a könyvek listáját. A listát a konstruktorban
kapja meg! Készítsd el benne az alábbi metódusokat streamek segítségével:

Integer getNumberOfBooks(): a könyvek darabszámát adja meg.
Optional<Book> findNewestBook(): a legújabb kiadású könyvet adja vissza.
Integer getTotalValue(): a könyvek összértékét adja meg.*/

    private String title;
    private int yearOfPublish;
    private int price;
    private int numberOfBooks;

    public Book(String title, int yearOfPublish, int price, int numberOfBooks) {
        this.title = title;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
        this.numberOfBooks = numberOfBooks;
    }

    public String getTitle() {
        return title;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }
}
