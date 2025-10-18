package filescanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    public static final String DELIMATER = ";";
    private List<Book> books = new ArrayList<>();

    public void loadFromFile(){
        try(Scanner scanner = new Scanner(this.getClass().getResourceAsStream("books.csv"))){
            while(scanner.hasNext()){
                String line = scanner.nextLine();
                addBookFromLine(line);
            }
        }
    }

    private void addBookFromLine(String line) {
        String[] data = line.split(DELIMATER);
        books.add(new Book(data[0],data[1],data[2],Integer.parseInt(data[3])));
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
