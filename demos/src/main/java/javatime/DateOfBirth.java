package javatime;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Locale;


public class DateOfBirth {
    /*Életünk nevezetes dátumairól (DateOfBirth osztály) szeretnénk speciális információkat
    kapni, mint például: a hét mely napján születtünk, eddig összesen hány napot éltünk,
    vagy a saját és barátunk/párunk születése között pontosan hány nap telt el. A dátumokat
     tetszőlegesen formázott String formájában is szeretnénk látni.

Hibakezelés
Üres pattern esetén dobjon IllegalArgumentException-t az adott metódus. A Locale nem lehet
null. Ha rossz dátumot adtunk meg születési dátumként, a countDaysSinceBirth() metódus
dobjon IllegalStateException-t

Tippek
Használd a ChronoUnit enumot arra, hogy kiszámold, hány nap van két dátum között!
Szervezzük külön metódusba az azonos paraméterek ellenőrzését!

Megjegyzés
Érdemes a dokumentációban átnézni a LocalDate, LocalTime osztályok nyújtotta lehetőségeket!*/

    private LocalDate birthDate;

    public DateOfBirth(int year, int month, int day) {
        this.birthDate = LocalDate.of(year, month, day);
    }

    public DateOfBirth(String birthDate) {
        if (birthDate == null || birthDate.isBlank()) {
            throw new IllegalStateException("BirthDate can not be empty or null");
        }
        try {
            this.birthDate = LocalDate.parse(birthDate);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("The has to be in this yyyy-mm-dd format, not in this: " + birthDate, e.getCause());
        }
    }

    public DateOfBirth(String birthDate, String pattern) {
        if (birthDate == null || birthDate.isBlank()) {
            throw new IllegalStateException("BirthDate can not be empty or null");
        } else if (pattern == null || pattern.isBlank()) {
            throw new IllegalStateException("Pattern can not be empty or null");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            this.birthDate = LocalDate.parse(birthDate, formatter);
        } catch (DateTimeException e) {
            throw new IllegalStateException("Wrong pattern: " + e.getMessage());
        }

    }

    public String getDayOfBirthDate() {
        return birthDate.getDayOfWeek().name().toLowerCase();
    }

    public boolean isWeekDay() {
        return birthDate.getDayOfWeek().getValue() <= 5;
    }

    public boolean wasItALeapYear(){
        return birthDate.isLeapYear();
    }

    public String findBirthDayOfWeekLaterInGivenYear(int year){
        return birthDate.withYear(year).getDayOfWeek().name().toLowerCase();
    }

    public long countDaysSinceBirth() {
        return ChronoUnit.DAYS.between(birthDate, LocalDate.now());
    }

    public long daysBetween(DateOfBirth other) {
        return ChronoUnit.DAYS.between(birthDate, other.getBirthDate());
    }

    public String formatBirthDate(String pattern, Locale locale) {
        validate(pattern, locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        return birthDate.format(formatter);
    }

    private void validate(String pattern, Locale locale) {
        if (locale == null) {
            throw new IllegalArgumentException("Locale can not be empty.");
        } else if (pattern == null || pattern.isBlank()) {
            throw new IllegalStateException("Pattern can not be empty or null");
        }

    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "DateOfBirth{" +
                "birthDate=" + birthDate +
                '}';
    }

    public static void main(String[] args) {
        DateOfBirth myBirth = new DateOfBirth("1990-05-15", "yyyy-MM-dd");
        DateOfBirth friendBirth = new DateOfBirth("1990.06.20", "yyyy.MM.dd");

        System.out.println(myBirth);
        System.out.println(myBirth.getDayOfBirthDate());
        System.out.println(myBirth.countDaysSinceBirth());
        System.out.println(myBirth.formatBirthDate("yy-MMMM-dd", Locale.ENGLISH));
        System.out.println(myBirth.daysBetween(friendBirth));
    }

}
