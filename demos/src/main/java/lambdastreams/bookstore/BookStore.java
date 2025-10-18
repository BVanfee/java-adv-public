package lambdastreams.bookstore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class BookStore {

    private List<Book> books;

    public BookStore(List<Book> books) {
        this.books = books;
    }

//        public Integer getNumberOfBooks() {
//        return books
//                .stream()
//                .mapToInt(Book::getNumberOfBooks)
//                .sum();
//    }

    public Integer getNumberOfBooks() {
        return books
                .stream()
                .reduce(0,
                        (i, b) -> i + b.getNumberOfBooks(),
                        (x, y) -> x + y);
    }

    public Optional<Book> findNewestBook() {
        return books
                .stream()
                //.max((book1, book2) -> book1.getYearOfPublish()-book2.getYearOfPublish());
                .max(Comparator.comparingInt(Book::getYearOfPublish));
    }


    public Integer getTotalValue() {
        return books
                .stream()
                .reduce(0,
                        (i, b) -> i + b.getPrice() * b.getNumberOfBooks(),
                        (x, y) -> x + y);
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
