package iowriter.music;

import java.util.Objects;

public class Band {
    /*Ebben a fájl olvasását és írását is gyakorolhatod. Adott a bands_and_years.txt
    állomány, melyben zenekarok nevét és alapítási évét találod. Készíts egy metódust
     melynek a paramétere egy fájl és egy évszám! Ez a metódus ki fogja írni a fájlba
     az évszámnál régebben alakult zenekarokat. Megoldási javaslat, hogy készíts egy
     privát metódust, ami kigyűjti ezeket a zenekarokat egy listába. Minden zenekart
     egy Band objektum reprezentál, melynek attribútumai a név és az évszám.*/

    private String name;
    private int year;

    public Band(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Band band = (Band) o;
        return year == band.year && Objects.equals(name, band.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }
}
