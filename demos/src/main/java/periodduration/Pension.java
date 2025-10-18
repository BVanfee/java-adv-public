package periodduration;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Pension {
    private static final int DAYS_IN_MONTH = 30;
    private static final int DAYS_IN_YEAR = 365;
    /*Nyugdíjszámításhoz szükségünk van egy olyan osztályra, amely segítségével összegezni tudjuk
    a nyugdíj jogosultságot adó időtartamokat, egy-egy dátum adta intervallumot módosítani tudunk
    (pl. jogosultságot nem szerző napokkal), és egyéb műveleteket is végezhetünk.

Hibakezelés
A Stringként megadott paraméterek nem lehetnek null vagy üres String értékek. Ezek esetében
dobjon a rendszer IllegalArgumentException-t, a megfelelő tájékoztató szöveggel. A dátum paraméter
nem lehet null érték, a megfelelő metódus dobjon NullPointerException-t.

Megvalósítási javaslatok
A Period objektum normalizálható, de ez csak az év és hónap mezők “átváltását” biztosítja.
Készítsünk egy teljes mértékben normalizáló metódust, ami a nap és hónap értékek közötti
konverziót is biztosítja 1 hónap = 30 nap átváltás mellett (Period fullyNormalized(Period period)).

publikus metódusok:

Copy Code
public void addEmploymentPeriod(Period period)
public Period sumEmploymentPeriods()
public Period modifyByDays(Period period, int days)
public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate)
public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern)
public int calculateTotalDays(Period period)
Tippek
Ahol a visszatérési érték Period, mindig a teljes mértékben normalizált objektumot adjuk vissza!
 (Ennek létjogosultsága persze vitatható, de legyünk következetesek!) Nézzük át a dokumentációban
  a parszolható period String szerkezetét! A paraméter stringek vizsgálatához készítsünk egy
  boolean isEmpty(String str) metódust! Az összegyűjtött időtartamokat egy kollekcióban célszerű
  tárolni, és azt lehet szükség esetén összegezni.*/

    private List<Period> employmentsPeriod;

    public Pension(List<Period> employmentsPeriod) {
        this.employmentsPeriod = employmentsPeriod;
    }

    public void addEmploymentPeriod(Period period) {
        validate(period);
        employmentsPeriod.add(period);
    }

    public Period sumEmploymentPeriods() {
        return employmentsPeriod
                .stream()
                .reduce(Period::plus)
                .orElseThrow(() -> new IllegalStateException("Nincs összegzésre alkalmas időszak"))
                .normalized();
    }

    public Period modifyByDays(Period period, int days) {
        validate(period);
        return fullyNormalized(period.plusDays(days).normalized());
    }

    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate) {
        validate(fromDate);
        validate(toDate);
        return fullyNormalized(Period.between(fromDate, toDate).normalized());
    }

    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern) {
        validate(fromDate);
        validate(toDate);
        validate(pattern);
        Period period = null;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            period = getPeriodBetweenDates(LocalDate.parse(fromDate, formatter),
                    LocalDate.parse(toDate, formatter));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Illegal pattern", e.getCause());
        }
        if (period == null) {
            throw new IllegalArgumentException("Period can not be null.");
        }
        return fullyNormalized(period.normalized());
    }

    public int calculateTotalDays(Period period) {
        Period normalized = fullyNormalized(period);
        return normalized.getYears() * DAYS_IN_YEAR + normalized.getMonths() * DAYS_IN_MONTH + normalized.getDays();
    }

    public List<Period> getEmploymentsPeriod() {
        return new ArrayList<>(employmentsPeriod);
    }

    private void validate(String text) {
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Text can not be null or empty.");
        }
    }

    private static void validate(Period period) {
        if (period == null) {
            throw new NullPointerException("Period can not be empty");
        }
    }

    private Period fullyNormalized(Period period) {
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        years += (months + days / DAYS_IN_MONTH) / 12;
        months = (months + days / DAYS_IN_MONTH) % 12;
        days = days % DAYS_IN_MONTH;

        return Period.of(years, months, days).normalized();
    }

    private void validate(LocalDate date) {
        if (date == null) {
            throw new NullPointerException("Date can not be null");
        }
    }
}
