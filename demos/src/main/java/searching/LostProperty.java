package searching;

import java.time.LocalDate;

public class LostProperty implements Comparable<LostProperty> {
    /*Készíts egy LostProperty osztályt, amelynek három attribútuma
    egy regisztrációs szám, egy rövid leírás az elveszett tárgyról és a
    talált tárgyak osztályára való bekerülésének dátuma! Az osztály implementálja
    a Comparable interfészt és valósítsa meg annak metódusát! Alapvetően a
    tárgyak leírása alapján hasonlítsa össze őket, ám ha az esetleg megegyezik,
    akkor a bekerülés dátuma alapján! Majd ezután legyen egy LostAndFoundOffice,
    amely egy listában tárolja az elhagyott tárgyakat! Az osztályban készíts egy
    LostProperty findLostProperty(LostProperty searched) metódust, amely bináris
    kereséssel megkeresi a listában a leírás alapján az elhagyott tárgyat!
    Ha nincs találat, dobjon a metódus IllegalArgumentException-t!*/

    private String regNumber;
    private String description;
    private LocalDate date;

    public LostProperty(String regNumber, String description, LocalDate date) {
        this.regNumber = regNumber;
        this.description = description;
        this.date = date;
    }

    public LostProperty(String description, LocalDate date) {
        this.description = description;
        this.date = date;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public int compareTo(LostProperty o) {
        if (this.description.compareTo(o.getDescription()) == 0) {
            return this.date.compareTo(o.getDate());
        } else {
            return this.description.compareTo(o.getDescription());
        }

    }
}
