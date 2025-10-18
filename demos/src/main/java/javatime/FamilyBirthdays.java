package javatime;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyBirthdays {
    /*Írj egy FamilyBirthdays osztályt, mely konstruktor paraméterül kap születésnapokat.
    Implementáld benne az isFamilyBirthday és nextFamilyBirthDay metódusokat,
    a tesztben szereplő method reference-ek alapján.

A isFamilyBirthday visszaadja, hogy a paraméterként átadott dátum születésnap-e.
A nextFamilyBirthDay metódus visszaadja, hány nap van a legközelebbi születésnapig.

Implementáció
Nézd meg LocalDate query() metódusát, hogy mit kap paraméterül.
Használd a ChronoUnit osztályt annak meghatározására, hogy két dátum között hány nap telt el.*/

    private List<DateOfBirth> birthList;

    public FamilyBirthdays(List<DateOfBirth> birthList) {
        this.birthList = birthList;
    }

    public boolean isFamilyBirthday(LocalDate date) {
        return birthList
                .stream()
                .anyMatch(dateOfBirth -> dateOfBirth.getBirthDate().isEqual(date));
    }

    public int nextFamilyBirthDay(LocalDate currentDate) {
        List<LocalDate> upcomingBirthdays = birthList.stream()
                .map(DateOfBirth::getBirthDate)
                .map(date -> date.withYear(currentDate.getYear())) // Az aktuális évre állítjuk a születésnapokat
                .filter(date -> !date.isBefore(currentDate)) // Csak a jövőbeli vagy mai születésnapok
                .collect(Collectors.toList());

        if(upcomingBirthdays.isEmpty()){
            throw new NoSuchElementException("Idén már nincs ilyen szülinap");
        }

        Optional<LocalDate> nearest = upcomingBirthdays
                .stream()
                .min(Comparator.comparing(date -> date.compareTo(currentDate)));

        if(nearest.isPresent()){
            LocalDate searched = nearest.get();
            return (int) ChronoUnit.DAYS.between( currentDate, searched);
        }
        throw new NoSuchElementException("Idén már nincs ilyen szülinap");
    }

    public List<DateOfBirth> getBirthList() {
        return new ArrayList<>(birthList);
    }
}
