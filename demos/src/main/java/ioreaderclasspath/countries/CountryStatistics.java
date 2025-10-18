package ioreaderclasspath.countries;

import annotations.Trainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CountryStatistics {

    /*A src/main/resources/country.txt állományban országnevek és a
    szomszédos országok száma található. Hozz létre egy az ország
    tárolására alkalmas osztályt Country néven!

Hozz létre egy CountryStatistics osztályt, ahol beolvasod file tartalmát
 egy listába, amjd írj metódusokat amelyek visszatérési értéke választ ad
 a következő kérdésekre: * Hány országot olvastál be? * Melyik országnak
 van a legtöbb szomszédja?*/

    private List<Country> countries = new ArrayList<>();

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }

    public void readFromFile(String file) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(CountryStatistics.class.getResourceAsStream(file)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addCountry(line);
            }
        } catch (IOException e) {
            throw new IllegalStateException("File can not read", e);
        }
    }

    private void addCountry(String line) {
        String[] data = line.split(" ");
        countries.add(new Country(data[0], Integer.parseInt(data[1])));
    }

    public int numberOFCountries() {
        return countries.size();
    }

    public Country mostBorderCountries() {
        return countries
                .stream()
//                .sorted(Comparator.comparing(Country::getBorderCountries).reversed())
//                .findFirst()
                .max(Comparator.comparing(Country::getBorderCountries))
                .orElseThrow();
    }
}
