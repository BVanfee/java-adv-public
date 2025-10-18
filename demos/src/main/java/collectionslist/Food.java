package collectionslist;

import java.time.LocalDate;

public class Food {

    private String name;
    private LocalDate date;

    public Food(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpirationDate() {
        return date;
    }


}
