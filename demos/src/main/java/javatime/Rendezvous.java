package javatime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Rendezvous {
    /*Fontos találkozó előtt állunk, és nem akarjuk lekésni, ezért tudnunk kell,
    hány perc van addig. Azzal is számolunk, hogy az időpont módosulhat.
    Egy Rendezvous osztályt készítünk a funkciókhoz.

Hibakezelés
Üres pattern esetén dobjon IllegalArgumentException-t. Hasonlóképpen a
sikertelen parszolás is dobjon IllegalArgumentException-t. Ha elfeledkezünk
 az időpontról és már késő elmenni, a countMinutesLeft() metódus dobjon
 MissedOpportunityException-t. Ezt nekünk kell megírni, ez is egy RuntimeException.

Tippek
Használd a ChronoUnit enumot arra, hogy kiszámold, hány perc van két idő között!
Szervezzük külön metódusba a paraméterek ellenőrzését!*/

    private LocalTime time;

    public Rendezvous(String time, String pattern) {
        setTime(time, pattern);
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(String time, String pattern) {
        validate(time, pattern);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
            this.time = LocalTime.parse(time, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("The pattern (" + pattern + ") is no valid to the given time: " + time + "\n" + e.getMessage());
        }

    }

    public int countMinutesLeft(){
        if(LocalTime.now().isAfter(time)){
            throw new MissedOpportunityException("Missed the appointment!");
        }
        return (int) ChronoUnit.MINUTES.between(LocalTime.now(),time);
    }

    private void validate(String time, String pattern) {
        if (time == null || time.isBlank()) {
            throw new IllegalArgumentException("Time can not be empty or null.");
        } else if (pattern == null || pattern.isBlank()) {
            throw new IllegalArgumentException("Pattern can not be empty or null");

        }
    }

    public static void main(String[] args) {
        Rendezvous randi = new Rendezvous("16:45", "HH:mm");

        System.out.println(randi.countMinutesLeft());
    }


    private class MissedOpportunityException extends RuntimeException {

        public MissedOpportunityException(String message) {
            super(message);
        }
    }
}
